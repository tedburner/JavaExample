package com.example.DesignPatterns.adapter;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 10:15
 * @Description: 更高级的媒体播放器
 */
public interface AdvancedMediaPlayer {

    void playVlc(String fileName);

    void playMp4(String fileName);
}
