package webjava.servlet.basic.frontctrl.step2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.View;
import webjava.servlet.basic.frontctrl.step1.Controller1;
import webjava.servlet.basic.frontctrl.step2.Controller2;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.io.IOException;

public class MemberSaveCtrl2 implements Controller2 {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);

        memberRepos.save(member);

        request.setAttribute("member", member);

        return new View("/WEB-INF/step2/save-result.jsp");
    }
}
