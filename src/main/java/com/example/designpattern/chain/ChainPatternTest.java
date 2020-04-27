package com.example.designpattern.chain;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:44
 * @Description: 责任链模式
 */
public class ChainPatternTest {

    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger logger = getChainOfLoggers();

        logger.logMessage(AbstractLogger.INFO, "This is an info");

        logger.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        logger.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
