package DesignPatterns.strateg;

/**
 * @Auther: lingjun, hkh
 * @Date: 2018/7/4 23:23
 * @Description:
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
