package webjava.servlet.basic.cal;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "calculator2", urlPatterns = "/calc2")
public class Calculator2 extends HttpServlet {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Calculator.class);
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
        } catch (NumberFormatException e) {
            handleException("Invalid number : " + e.getMessage(), req, res);
        } catch (ArithmeticException e) {
            handleException("Arithmetic error: " + e.getMessage(), req, res);
        }
    }

    private void handleException(String errorMsg, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // 서버 로그에도 에러 메시지 남기기
        logger.error(errorMsg);

        // 클라이언트에도 에러 메시지 전달
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(errorMsg);

        // errorMsg를 request 객체에 속성으로 추가하여 전달
        request.setAttribute("errorMsg", errorMsg);

        // SlackNotificationServlet 호출
        request.getRequestDispatcher("/slack-notification").forward(request, response);
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/slack-notification");
        // dispatcher.forward(request,response);
    }
}
