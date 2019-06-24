package com.zhoulianchang.mongo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhou
 */
public class BatchDownloadFile {
    private static Logger logger = LoggerFactory.getLogger(BatchDownloadFile.class);
    /**
     * 批量下载文件
     * @param zipOutputStream zip输出流
     * @param fileList 要下载的文件列表集合
     */
    public static void batchDownload(ZipOutputStream zipOutputStream, List<File> fileList) {
        InputStream inputStream = null;
        try {
            for (File file : fileList) {
                inputStream = new FileInputStream(file);
                logger.info("开始读取文件");
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                writeFile(inputStream,zipOutputStream);
                inputStream.close();
            }
            logger.info("结束读取文件");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写文件
     *
     * @param inputStream  文件输入流
     * @param outputStream 文件输出流
     * @throws IOException
     */
    public static void writeFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) !=-1) {
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
    }
    /**
     * 设置响应头使得浏览器下载文件
     *
     * @param fileName
     * @param response
     */
    public static void setResponseHeader(String fileName, HttpServletResponse response) {
        String name = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.reset();
        //告诉浏览器输出内容为流;设置了头文件才会有弹框;
        response.setContentType("application/octet-stream");
        //Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
        response.addHeader("Content-Disposition", "attachment;filename=" + name);
    }

}
