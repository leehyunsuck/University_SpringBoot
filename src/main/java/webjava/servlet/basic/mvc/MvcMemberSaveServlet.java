package webjava.servlet.basic.mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {
    MemberRepos memberRepos = new MemberRepos();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);

        memberRepos.save(member);

        req.setAttribute("member", member);
//
//        String viewPath = "/WEB-INF/views/save-result.jsp";
//        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
//        dispatcher.forward(req, res);

        req.getRequestDispatcher("/WEB-INF/views/save-result.jsp").forward(req, res);
    }
}
