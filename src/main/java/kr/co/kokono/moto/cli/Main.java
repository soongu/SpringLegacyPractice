package kr.co.kokono.moto.cli;

import kr.co.kokono.moto.cli.config.AppConfig;
import kr.co.kokono.moto.cli.controller.MemberController;
import kr.co.kokono.moto.cli.repository.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        System.out.println("================== 사용자 정보 입력 ====================");

        Scanner sc = new Scanner(System.in);
        System.out.print("username : ");
        String username = sc.nextLine();

        System.out.print("password : ");
        String password = sc.nextLine();

        MemberController controller = context.getBean(MemberController.class);
        controller.insert(username, password);

        System.out.println("================= 사용자 전체 정보 ======================");

        controller.findAll().forEach(m -> System.out.println(m.toString()));

        sc.close();
        context.close();
    }
}
