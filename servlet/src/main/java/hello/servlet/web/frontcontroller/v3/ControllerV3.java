package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    /**
     * v2와 비교해서 서블릿이 들어가지 않는다. 즉, 서블릿에 종속적이지 않다.
     */
    ModelView process(Map<String, String> paramMap);
}
