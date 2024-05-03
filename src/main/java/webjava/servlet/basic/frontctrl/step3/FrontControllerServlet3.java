package webjava.servlet.basic.frontctrl.step3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.ModelView;
import webjava.servlet.basic.frontctrl.View;
import webjava.servlet.basic.frontctrl.step3.controller.MemberFormCtrl3;
import webjava.servlet.basic.frontctrl.step3.controller.MemberListCtrl3;
import webjava.servlet.basic.frontctrl.step3.controller.MemberSaveCtrl3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet3", urlPatterns = "/front-ctrl/step3/*")
public class FrontControllerServlet3 extends HttpServlet {

    private Map<String, Controller3> jspMap = new HashMap<>();

    public FrontControllerServlet3() {
        jspMap.put("/front-ctrl/step3/students/new-form", new MemberFormCtrl3());
        jspMap.put("/front-ctrl/step3/students/save", new MemberSaveCtrl3());
        jspMap.put("/front-ctrl/step3/students", new MemberListCtrl3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("====== FrontControllerServlet3 ======");


        //Controller3 객체에 넘어온 URI 값으로 맞는 클래스의 객체 가져옴
        String requestURI = req.getRequestURI();
        Controller3 controller = jspMap.get(requestURI);

        //null인경우 없는 컨트롤러임
        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap 생성
        Map<String, String> paramMap = new HashMap<>();
        //파라미터 값을 paramMap 이라는 맵 객체에 Key = 이름, Value = 파라미터값으로 넣음
        req.getParameterNames().asIterator().forEachRemaining(
                paramName -> paramMap.put(paramName, req.getParameter(paramName))
        );

        //ModelView 객체
        ModelView modelView = controller.process(paramMap);

        //
        String viewName = modelView.getViewName();
        View view = new View("/WEB-INF/step3/" + viewName + ".jsp");

        view.render(modelView.getModel(), req, res);
    }
}
