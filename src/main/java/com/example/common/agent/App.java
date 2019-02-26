package com.example.common.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author: Arthas
 * @date: 2019-02-26 16:45
 * @description:
 */
public class App {

    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new FirstAgent());
    }

}
