package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.SpringdataJpaNotesApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdataJpaNotesApp.class)
public class TestEl {
    private class User{
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @Test
    public void a(){
        ExpressionParser parser=new SpelExpressionParser();
        User user=new User(9527,"周星驰");
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        //在上下文中设置变量，变量名为user，内容为user对象
        ctx.setVariable("user", user);
        //从用户对象中获得id并+1900，获得解析后的值在ctx上下文中
        int id = (Integer) parser.parseExpression("(1+ 1900)*2").getValue(ctx);
        System.out.println(id);
    }
}
