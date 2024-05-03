package webjava.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "reqGetServlet", urlPatterns = "/req-get")
public class ReqGetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("------------- [전체 요청 파라미터 조회함] -------------");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        response.getWriter().write("success");


        System.out.println("------------- [특정 파라미터 조회함] -------------");
        String userName = request.getParameter("username");
        System.out.println("이름 : " + userName);
        String gender = request.getParameter("gender");
        System.out.println("성별 : " + gender);


        System.out.println("------------- [이름 파라미터 여러개면] -------------");
        String[] userNames = request.getParameterValues("username");
        for (String s : userNames) {
            System.out.println("Name : " + s);
        }

    }
}
