package kr.co.kokono.moto.cli.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("classpath:application.xml");


        Service bean = context.getBean(Service.class);
        bean.log();

        context.close();
    }
}


