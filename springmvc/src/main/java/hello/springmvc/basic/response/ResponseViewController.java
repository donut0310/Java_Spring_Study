package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","hello!");
        return "response/hello";
    }

    @RequestMapping("/response/hello") // 경로의 이름과 반환 값이 같을 때 반환값 생략 가능 => 컨트롤러의 이름과 뷰의 논리적 이름이 같다면 생략이 가능하다.
    public void responseViewV3(Model model){
        model.addAttribute("data","hello!");
    }
}
