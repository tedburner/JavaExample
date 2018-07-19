package DesignPatterns.adapter;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 10:19
 * @Description:
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
