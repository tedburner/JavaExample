package com.example.designpattern.ProxyPattern.image;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:36
 * @Description:
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("真实的图片！！！！！");
    }
}
