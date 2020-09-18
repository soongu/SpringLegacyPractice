package kr.co.kokono.moto.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();

        context.scan("kr.co.kokono.moto.cli");
//        context.register(AppConfig.class);
        context.refresh();


        context.close();
    }
}
