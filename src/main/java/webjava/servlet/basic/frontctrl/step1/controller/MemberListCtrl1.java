package webjava.servlet.basic.frontctrl.step1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.step1.Controller1;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.io.IOException;
import java.util.List;

public class MemberListCtrl1 implements Controller1 {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepos.findAll();

        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/step1/members.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
