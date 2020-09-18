package kr.co.kokono.moto.web.controller;

import kr.co.kokono.moto.web.domain.Member;
import kr.co.kokono.moto.web.domain.MemberCreateDto;
import kr.co.kokono.moto.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(MemberCreateDto member) {
        memberService.insert(member.getUsername(), member.getPassword());
        return "redirect:/";
    }
}
