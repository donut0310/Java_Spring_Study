package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // 반환값을 http 응답 메시지로 보냄
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody // 반환값을 http 응답 메시지로 보냄
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능
     * String, int, Integer 등의 단순 타입이면, @RequestParam도 생략 가능
     */
    @ResponseBody // 반환값을 http 응답 메시지로 보냄
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * 필수 파라미터
     */
    @ResponseBody // 반환값을 http 응답 메시지로 보냄
    @RequestMapping("/request-param-required")
    public String requiredParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        // int 타입은 null 값이 들어갈 수 없다.

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * 기본값 파라미터
     */
    @ResponseBody // 반환값을 http 응답 메시지로 보냄
    @RequestMapping("/request-param-default")
    public String requiredParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
            // defaultValue가 들어가면 required는 사실상 필요가 없다.
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // 반환값을 http 응답 메시지로 보냄
    @RequestMapping("/request-param-map")
    public String requiredParamMap(@RequestParam Map<String, Object> paramMap) {
        // 파라미터의 값이 1개가 확실하다면 Map을 사용해도 되지만,
        // 그렇지 않다면, MultiValueMap을 사용!!
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    /**
     * @ModelAttribute 적용
     * HelloData객체가 생성되면서, 요청 파라미터의 값도 모두 들어가있다.
     * 1. HelloData 객체 생성
     * 2. 요청 파라미터의 이름으로 HelloData 객체의 프로퍼티를 찾는다.
     * 3. 해당 프로퍼티의 setter를 호출해서 파라미터의 값을 입력(바인딩)한다.
     * 예) 파라미터 이름이 username이면 setUsername() 메서드를 찾아서 호출하며 값을 입력
     * 타입에 맞지 않는 파라미터가 들어가면 바인딩 오류로 처리된다.
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    /**
     * String, int, Integert 같은 단순 타입 = @RequestParam
     * 나머지 = @ModelAttribute (argument resolver로 지정해둔 타입 외)
     * ex) HttpServelet~~ 등 예약된 것들
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) { // @ModelAttribute 생략 가능
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
