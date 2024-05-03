package webjava.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.HelloData;

import java.io.IOException;

@WebServlet(name = "respJsonServlet", urlPatterns = "/res-json")
public class RespJsonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //JSON은 자바 (ObjectMapper)로 변환해서 사용해야함

        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        //basic에 HelloData 클래스 사용
        HelloData helloData = new HelloData();
        helloData.setUsername("hyunsuck");
        helloData.setAge(20);

        String result = new ObjectMapper().writeValueAsString(helloData);
        res.getWriter().write(result);
    }
}
