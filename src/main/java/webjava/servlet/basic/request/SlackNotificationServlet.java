package webjava.servlet.basic.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.SlackNotifier2;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "slackNotificationServlet", urlPatterns = "/slack-notification")
public class SlackNotificationServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errorMsg = (String) request.getAttribute("errorMsg");
        // 슬랙으로 알림 전송
        SlackNotifier2.send(errorMsg);;


        // 응답 반환
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>오류가 발생하였습니다.</h2>");
        out.println("<p>" + errorMsg + "</p>");
        out.println("</body></html>");
    }
}
