package com.lwp.wt;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestCreateFilePath {

    public static void main(String[] args){
        File file  = new File("D:/outPdf/");
        if(!file.isDirectory()){
            file.mkdirs();
        }else{
            System.out.println("路径已存在");
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("12","12313");
        System.out.println(map.toString());
    }
}
