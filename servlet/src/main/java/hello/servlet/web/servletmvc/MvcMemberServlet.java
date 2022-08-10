package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // 컨트롤러에서 뷰로 이동할 때 사용
        dispatcher.forward(request, response); // 서블릿에서 jsp 호출, foward는 redirec와 달리 서버 내부에서 일어나는 호출
   
    }
}
