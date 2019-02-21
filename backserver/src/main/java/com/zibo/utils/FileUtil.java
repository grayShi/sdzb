package com.zibo.utils;


import com.google.common.base.Strings;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {
    public static final String FILE_PREFIX = "/tmp/upload/";

    {
        File file = new File(FILE_PREFIX);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static String createFile(byte[] bytes, String postfix) {
        return createFile(null, bytes, postfix);
    }

    public static String createFile(String parent, byte[] bytes, String postfix) {
        final String fileName = "upload_" + System.currentTimeMillis() + "." + postfix;
        File parentFile = new File(FILE_PREFIX);
        if (!Strings.isNullOrEmpty(parent)) {
            parentFile = new File(FILE_PREFIX + parent);
        }
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        File newFile = new File(parentFile, fileName);
        try (FileOutputStream outputStream = new FileOutputStream(newFile)) {
            outputStream.write(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    public static File getFileByPath(String filePath) {
        return new File(FILE_PREFIX + filePath);
    }
}
