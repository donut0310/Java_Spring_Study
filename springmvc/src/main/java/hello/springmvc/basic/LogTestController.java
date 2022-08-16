package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// @Controller는 반환 값이 'String'이면 뷰 이름으로 인식되어, 해당 뷰를 찾고 뷰가 렌더링 된다.
// @RestController는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력 한다.
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // or LogTestController.class => @Slf4j 사용시 롬복이 자동으로 위 코드를 넣어줌

    @RequestMapping("log-test")
    public String logTest(){
        String name = "Spring";

        log.trace("info log="+name); // log 메소드가 호출되기 전, info log=name 수식이 먼저 연산되어버린다. => 쓸모없는 리소스 사용이 발생

        log.trace("trace log = {},", name); // 파라미터만 전달되기 때문에, 연산이 발생하지 않는다.
        log.debug("debug log = {},", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
