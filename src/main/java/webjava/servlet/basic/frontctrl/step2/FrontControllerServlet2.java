package webjava.servlet.basic.frontctrl.step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.View;
import webjava.servlet.basic.frontctrl.step2.controller.MemberFormCtrl2;
import webjava.servlet.basic.frontctrl.step2.controller.MemberListCtrl2;
import webjava.servlet.basic.frontctrl.step2.controller.MemberSaveCtrl2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet2", urlPatterns = "/front-ctrl/step2/*")
public class FrontControllerServlet2 extends HttpServlet {
    private Map<String, Controller2> jspMap = new HashMap<>();

    public FrontControllerServlet2() {
        jspMap.put("/front-ctrl/step2/students/new-form", new MemberFormCtrl2());
        jspMap.put("/front-ctrl/step2/students/save", new MemberSaveCtrl2());
        jspMap.put("/front-ctrl/step2/students", new MemberListCtrl2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("############################");
        System.out.println("FrontController 2 !!");

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        Controller2 controller = jspMap.get(requestURI);

        //HashMap에 없을 경우 404 응답하게 수정, Controller가 null일 경우
        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        View view = controller.process(req, res);
        view.render(req, res);

        //controller.process(req,res).render(req, res);
    }
}
