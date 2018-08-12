package com.example.DesignPatterns.ProxyPattern.image;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:37
 * @Description:
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
