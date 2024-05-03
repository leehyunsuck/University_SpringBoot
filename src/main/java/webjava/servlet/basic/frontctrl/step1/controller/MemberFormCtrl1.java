package webjava.servlet.basic.frontctrl.step1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.step1.Controller1;

import java.io.IOException;

public class MemberFormCtrl1 implements Controller1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/step1/new-forms.jsp").forward(request, response);
    }
}
