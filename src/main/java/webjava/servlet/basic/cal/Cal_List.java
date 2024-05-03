package webjava.servlet.basic.cal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cal_list", urlPatterns = "/cal_list")
public class Cal_List extends HttpServlet {

    private final List<String> cal_history = new ArrayList<>();
    private final List<Double> cal_result = new ArrayList<>();
    private final List<String> cal_time = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String op = request.getParameter("op");

        double result = switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "/" -> num1 / num2;
            case "*" -> num1 * num2;
            default -> 0;
        };

        String calculation = num1 + " " + op + " " + num2;
        cal_history.add(calculation);
        cal_result.add(result);

        /*
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String executionTime = formatter.format(currentTime);
        cal_time.add(executionTime);
**/

        String exe_time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        cal_time.add(exe_time);

        response.setContentType("text/html; charset=utf-8");

        // 계산 결과 및 실행 시간 출력
        response.getWriter().write("결과는 = " + result + "<br>");

        // 이전 계산 목록을 테이블로 출력
        response.getWriter().write("<h3>이전 계산 목록</h3>");
        response.getWriter().write("<table border='1'>");
        response.getWriter().write("<tr><th>계산식</th><th>결과</th><th>실행 시간</th></tr>");
        for (int i = 0; i < cal_history.size(); i++) {
            response.getWriter().write("<tr><td>" + cal_history.get(i) + "</td><td>" + cal_result.get(i) + "</td><td>" + cal_time.get(i) + "</td></tr>");
        }
        response.getWriter().write("</table>");

    }
}
