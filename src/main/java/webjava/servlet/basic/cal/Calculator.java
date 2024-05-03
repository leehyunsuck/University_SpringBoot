package webjava.servlet.basic.cal;

import com.slack.api.Slack;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import webjava.servlet.basic.SlackNotifier;

import java.io.IOException;

@WebServlet(name = "", urlPatterns = "/calc")
public class Calculator extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");
        try {
            String op = req.getParameter("op");

            Double num1 = Double.parseDouble(req.getParameter("num1"));
            Double num2 = Double.parseDouble(req.getParameter("num2"));

            Double result = switch(op) {
                case "+" -> { yield num1 + num2; }
                case "-" -> { yield num1 - num2; }
                case "*" -> { yield num1 * num2; }
                case "/" -> { yield num1 / num2; }
                default -> 0.0;
            };
            res.getWriter().write("결과 : " + result);
        } catch (Exception e) {
            res.getWriter().write("결과 : " + e.getMessage());
            SlackNotifier.send(e.getMessage());
        }
    }
}
