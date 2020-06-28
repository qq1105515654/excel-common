package com.dongbawen.common.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

/**
 * @author snh
 * @version 1.0
 * @className TestFileToMultipartFile
 * @description TODO
 * @date 2020/6/28 10:27
 **/
public class TestFileToMultipartFile {

    public static void main(String[] args) {
        String fileName=getFileName("1236549987844547774");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("locus","[123,123213,123123,1313,13,3,21,32,3,3,32,32,323,23,23,2,32,3232,2,32,32,2,32,2,3,23,23,23,2,32,32,32,2,2,23,23,23,2,32,32,32,2,23,23,2,32,323,2,2,3,2,23,2,2,2,3,3]");
        File locusFile=new File(fileName);
        FileOutputStream fos=null;
        FileInputStream fis=null;
        try {
            fos=new FileOutputStream(locusFile);
            fos.write(jsonObject.toJSONString().getBytes());
            fos.flush();
            fis=new FileInputStream(locusFile);
            FileItem fileItem=new DiskFileItem(fileName, Files.probeContentType(locusFile.toPath()),false,locusFile.getName(),(int)locusFile.length(),locusFile.getParentFile());
            OutputStream os=fileItem.getOutputStream();
            IOUtils.copy(fis,os);
            MultipartFile multipartFile=new CommonsMultipartFile(fileItem);
            System.out.println(multipartFile.getName());
            /*ResponseObject response=fileService.upload(multipartFile);
            HashMap<String,String> map= (HashMap<String, String>) response.getData();
            String fid=map.get("fid");*/

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                locusFile.deleteOnExit();
                if(fos!=null){
                    fos.close();
                }
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取文件名
     * @param userId
     * @return
     */
    public static String getFileName(String userId){
        long time=System.currentTimeMillis();
        StringBuffer sb=new StringBuffer("/");
        sb.append(userId)
                .append("_")
                .append(time)
                .append(".json");
        return sb.toString();
    }


}
