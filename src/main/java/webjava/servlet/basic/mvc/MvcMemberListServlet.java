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
import java.util.ArrayList;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/mvc/members")
public class MvcMemberListServlet extends HttpServlet {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Member> members = new ArrayList<>();

        members.addAll(memberRepos.findAll());

        req.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, res);
    }
}
