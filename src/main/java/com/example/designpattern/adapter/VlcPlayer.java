package com.example.designpattern.adapter;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 10:18
 * @Description:
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
