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
import java.util.List;

public class MemberListCtrl2 implements Controller2 {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepos.findAll();

        request.setAttribute("members", members);

        return new View("/WEB-INF/step2/members.jsp");
    }
}
