package com.dongbawen.common;

import com.dongbawen.common.entity.Food;
import com.dongbawen.common.handler.imported.ImportHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommonApplicationTests {

    @Autowired
    ImportHandler importHandler;

    @Test
    public void contextLoads() {

    }


    @Test
    public void test(){
        long startTime=System.currentTimeMillis();

        File file=new File("F:\\WorkWorld\\运动处方\\中国食物成分表1.0-20200228.xlsx");
        try {
            InputStream is=new FileInputStream(file);
            MultipartFile multipartFile=new MockMultipartFile(file.getName(),is);
            Map<String, List> result=importHandler.importDataHandler(multipartFile, Food.class);
            long endTime=System.currentTimeMillis();

            System.out.println(result);
            System.out.println("总共耗时："+(endTime-startTime)+"/ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
