package webjava.servlet.basic.springmvc.step2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.List;

@Controller
public class SpringStudentControllerV2 {

    MemberRepos memberRepos = new MemberRepos();

    @RequestMapping("/springmvc/step2/members/new-form")
    public ModelAndView form() {
        return new ModelAndView("new-forms");
    }

    @RequestMapping("/springmvc/step2/members/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(userName, age);
        memberRepos.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }

    @RequestMapping("/springmvc/step2/members")
    public ModelAndView list() {
        List<Member> members = memberRepos.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
