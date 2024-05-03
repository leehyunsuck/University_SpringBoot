package webjava.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.util.StreamUtils;
import webjava.servlet.basic.HelloData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "reqJsonServlet", urlPatterns = "/req-json")
public class ReqJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();
        String msg = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        HelloData helloData = new ObjectMapper().readValue(msg, HelloData.class);

        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloData.age = " + helloData.getAge());

        response.getWriter().write("ok");
    }
}
