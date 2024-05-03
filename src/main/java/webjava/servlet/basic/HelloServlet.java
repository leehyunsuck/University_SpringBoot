package webjava.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        String name = req.getParameter("name");
        System.out.println("이름 : " + name);

        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        res.getWriter().write("Hello " + name);
    }
}