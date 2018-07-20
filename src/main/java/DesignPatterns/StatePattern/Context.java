package DesignPatterns.StatePattern;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 11:48
 * @Description:
 */
@Data
public class Context {

    private State state;

    public Context(){
        state = null;
    }

}
