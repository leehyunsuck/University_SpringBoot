package webjava.servlet.basic.springmvc.step1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.List;

@Controller
public class SpringStudentListControllerV1 {
    MemberRepos memberRepos = new MemberRepos();

    @RequestMapping("/springmvc/step1/members")
    public ModelAndView process() {
        List<Member> members = memberRepos.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
