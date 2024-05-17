package webjava.servlet.basic.frontctrl.step4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.View;
import webjava.servlet.basic.frontctrl.step4.controller.MemberFormCtrl4;
import webjava.servlet.basic.frontctrl.step4.controller.MemberListCtrl4;
import webjava.servlet.basic.frontctrl.step4.controller.MemberSaveCtrl4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//FrontControllerServlet3 : 모델 데이터가 ModelView.java 객체 내부 맵에 저장
//FrontControllerServlet4 : 모델 객체가 process 메서드의 매개변수로 전달

@WebServlet(name = "frontControllerServlet4", urlPatterns = "/front-ctrl/step4/*")
public class FrontControllerServlet4 extends HttpServlet {

    private Map<String, Controller4> jspMap = new HashMap<>();

    public FrontControllerServlet4() {
        jspMap.put("/front-ctrl/step4/students/new-form", new MemberFormCtrl4());
        jspMap.put("/front-ctrl/step4/students/save", new MemberSaveCtrl4());
        jspMap.put("/front-ctrl/step4/students", new MemberListCtrl4());
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("프론트컨트롤러서블릿4 접근");
        
        //Controller3 객체에 넘어온 URI 값으로 맞는 클래스의 객체 가져옴
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        Controller4 controller = jspMap.get(requestURI);

        //null인경우 없는 컨트롤러임
        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        //paramMap추가
        Map<String, String> paramMap = new HashMap<>();
        //model 추가
        Map<String, Object> model = new HashMap<>();
        
        req.getParameterNames().asIterator().forEachRemaining(
                paraName -> paramMap.put(paraName, req.getParameter(paraName))
        );
        
        //model 매개변수
        String viewName = controller.process(paramMap, model);

        View view = viewResolver(viewName);
        view.render(model, req, res);
    }

    private View viewResolver(String viewName) {
        return new View("/WEB-INF/step4/" + viewName + ".jsp");
    }
}
