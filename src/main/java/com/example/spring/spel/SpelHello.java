package com.example.spring.spel;

import com.example.domain.bean.SimpleDTO;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author: lingjun.jlj
 * @date: 2019/11/16 13:03
 * @description: SpEL
 */
public class SpelHello {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello'+' World'");
        String message = (String) expression.getValue();
        System.out.println(message);

        Expression exp1 = parser.parseExpression("'Hello'.concat('!')");
        String msg = (String) exp1.getValue();
        System.out.println(msg);

        SimpleDTO dto = new SimpleDTO();
        dto.setId(1);
        dto.setName("Jack");
        dto.setContent("hello");
        //构造SpEL 解析上下文
        EvaluationContext context = new StandardEvaluationContext(dto);
        //获取基本属性
        Integer id = (Integer) parser.parseExpression("id").getValue(context);
        String username = (String) parser.parseExpression("name").getValue(context);
        System.out.println(id + " " + username);


    }
}
