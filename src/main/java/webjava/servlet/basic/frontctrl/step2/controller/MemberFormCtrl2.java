package webjava.servlet.basic.frontctrl.step2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.View;
import webjava.servlet.basic.frontctrl.step1.Controller1;
import webjava.servlet.basic.frontctrl.step2.Controller2;

import java.io.IOException;

public class MemberFormCtrl2 implements Controller2 {
    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new View("/WEB-INF/step2/new-forms.jsp");
    }
}
