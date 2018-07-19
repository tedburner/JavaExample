package DesignPatterns.MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:45
 * @Description: 对象负责从 Memento 中恢复对象的状态
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
