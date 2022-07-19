package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // => 스프링 컨테이너에서 컨트롤러 객체를 생성해 넣어둔다. // => 컴포넌트 스캔 => 스프링 빈으로 등록
public class MemberController {
    private final MemberService memberService;

    @Autowired // => 스프링 컨테이너에서 컨트롤러 객체를 생성할 때 아래 생성자가 실행되며
    // 스프링 빈에 등록된 memberService를 가져다 연결 시켜준다. => 의존성 주입(dependency injection)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
