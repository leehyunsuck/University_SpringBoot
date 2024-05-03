package webjava.servlet.basic.frontctrl.step1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.step1.Controller1;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.io.IOException;

public class MemberSaveCtrl1 implements Controller1 {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);

        memberRepos.save(member);

        request.setAttribute("member", member);

        String viewPath = "/WEB-INF/step1/save-result.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
