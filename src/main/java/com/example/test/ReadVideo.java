package com.example.test;

import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/10 13:58
 * @description: 使用jave读取视频时长
 */
public class ReadVideo {

    public static void main(String[] args) {
        File video = new File("C:\\Document\\upload\\2019\\05\\24\\1558662250649.mp4");
        try {
            
            MultimediaObject multimediaObject = new MultimediaObject(video);
            MultimediaInfo m = multimediaObject.getInfo();
            long duration = m.getDuration();
            System.out.println("视频时长：" + duration + ":毫秒");
            System.out.println("视频时长：" + (duration / 1000) + ":秒");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
