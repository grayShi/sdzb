package com.zibo.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zibo.entity.ReWorkLog;
import com.zibo.entity.SampleData;
import com.zibo.repository.ReWorkLogRepository;
import com.zibo.repository.SampleDataRepository;
import com.zibo.request.SampleReworkModel;
import com.zibo.request.SampleReworkRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
@Service
public class SampleService extends BasicService<SampleData, Long> {
    private SampleDataRepository sampleDataRepo;

    @Autowired
    private ReWorkLogRepository reWorkLogRepo;

    public SampleService(SampleDataRepository sampleDataRepo) {
        super(sampleDataRepo);
        this.sampleDataRepo = sampleDataRepo;
    }

    public SampleReworkModel reworkSample(Long id, SampleReworkRequest reworkRequest) {
        SampleData sampleData = this.getById(id);
        Preconditions.checkNotNull(sampleData, "不存在的记录.");
        sampleData.setSampleStatus(reworkRequest.getStatus());
        sampleData.setRework(true);
        this.saveOrUpdate(sampleData);
        ReWorkLog reWorkLog = new ReWorkLog();
        reWorkLog.setSampleData(sampleData);
        reWorkLog.setReasons(StringUtils.join(reworkRequest.getReason(), ","));
        reWorkLog.setRemarks(reworkRequest.getRemarks());
        reWorkLogRepo.save(reWorkLog);
        return new SampleReworkModel(reWorkLog);
    }

    public List<SampleReworkModel> reworkList(Long id) {
        List<SampleReworkModel> result = Lists.newArrayList();
        List<ReWorkLog> reWorkLogs = reWorkLogRepo.findAllBySampleDataId(id);
        for (ReWorkLog reWorkLog : reWorkLogs) {
            SampleReworkModel sampleReworkModel = new SampleReworkModel(reWorkLog);
            result.add(sampleReworkModel);
        }
        return result;
    }
}
