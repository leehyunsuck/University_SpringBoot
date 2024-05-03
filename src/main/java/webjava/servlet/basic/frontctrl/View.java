package webjava.servlet.basic.frontctrl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {
    private String viewPath;

    public View(String viewPath) {
        this.viewPath = viewPath;
    }

    //step1~2 render메소드 코드
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(viewPath).forward(request, response);
    }

    //step3 render 메소드
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse res)
        throws ServletException, IOException {

        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, res);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
