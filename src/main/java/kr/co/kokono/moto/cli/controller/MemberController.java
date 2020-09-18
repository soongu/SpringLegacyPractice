package kr.co.kokono.moto.cli.controller;

import kr.co.kokono.moto.cli.domain.Member;
import kr.co.kokono.moto.cli.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void insert(String username, String password) {
        try {
            memberService.insert(username, password);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public List<Member> findAll() {

        try {
            return memberService.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
