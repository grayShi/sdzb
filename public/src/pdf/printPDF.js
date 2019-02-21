// 第一个.将页面html转换成图片
// npm install --save html2canvas
// 第二个.将图片生成pdf
// npm install jspdf --save

// 导出页面为PDF格式
import html2Canvas from 'html2canvas';
import JsPDF from 'jspdf';

export default{
  install (Vue, options) {
    Vue.prototype.getPdf = function (title, id = 'printBodyPage', scale = 3, changeHeight = 0) {
      const canvas = document.createElement('canvas');
      const ele = document.querySelector(`#${id}`); // must set tag width

      const width = ele.offsetWidth;
      const height = ele.offsetHeight + changeHeight;
      canvas.width = width * scale;
      canvas.height = height * scale;

      canvas.getContext('2d').scale(scale, scale);

      const opts = {
        scale,
        canvas,
        logging: false,
        width,
        height
      };
      html2Canvas(ele, opts).then(function (canvas) {
        // document.getElementsByClassName('page-footer')[0].appendChild(canvas);
        let contentWidth = canvas.width / scale;
        let contentHeight = canvas.height / scale;
        let pageHeight = contentWidth / 592.28 * 841.89;
        let leftHeight = contentHeight;
        let position = 0;
        let imgWidth = 595.28;
        let imgHeight = 592.28 / contentWidth * contentHeight;
        let pageData = canvas.toDataURL('image/jpeg', 1.0);
        // let PDF = new JsPDF('', 'pt', 'a4');
        let PDF = new JsPDF({
          orientation: '',
          unit: 'pt',
          format: 'a4'
        });
        if (leftHeight < pageHeight) {
          PDF.addImage(pageData, 'JPEG', 0, 0, imgWidth, imgHeight);
        } else {
          while (leftHeight > 0) {
            PDF.addImage(pageData, 'JPEG', 0, position, imgWidth, imgHeight);
            leftHeight -= pageHeight;
            position -= 841.89;
            if (leftHeight > 0) {
              PDF.addPage();
            }
          }
        }
        PDF.save(title + '.pdf');
      }
      ).then(() => {
        this.loading = false;
      });
    };
  }
};
