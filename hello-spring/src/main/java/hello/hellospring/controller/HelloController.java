package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // => 컴포넌트 스캔 => 스프링 빈으로 등록
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello";
    }
}
