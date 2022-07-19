package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * 톰캣은 스프링 컨테이너 내에 관련 컨트롤러가 있는지 먼저 찾은 후, 없을 때 static 폴더에서 정적 컨텐츠를 찾는다.
 */
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
