package webjava.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "resp2HDServlet", urlPatterns = "/res-2header")
public class Resp2HDServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(HttpServletResponse.SC_OK);

        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        res.addCookie(cookie);


        PrintWriter writer = res.getWriter();
        writer.println("hello res-2-header");
    }
}
