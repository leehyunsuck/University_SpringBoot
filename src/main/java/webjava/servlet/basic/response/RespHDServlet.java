package webjava.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "respHDServlet", urlPatterns = "/res-header")
public class RespHDServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //상태코드 세팅
        res.setStatus(HttpServletResponse.SC_OK);

        //응답 header
        //res.setHeader("key", "value");
        res.setHeader("Content-Type", "text/plain;charset=utf-8");
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // cache 무효화
        //response.setHeader("Pragma", "no-cache");
        res.setHeader("my-header", "hello" );                       //내가 원하는 헤더 생성
        res.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");  //쿠키 설정

        //리다이렉션 (페이지 이동)
        res.setStatus(HttpServletResponse.SC_FOUND);
        res.sendRedirect("/basic/post-form.html");

        //body
        PrintWriter writer = res.getWriter();
        writer.println("hello");
    }
}
