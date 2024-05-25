package webjava.servlet.basic.springmvc.step1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

@Controller
public class SpringStudentSaveControllerV1 {

    MemberRepos memberRepos = new MemberRepos();

    @RequestMapping("/springmvc/step1/memebers/save")
    public ModelAndView process(HttpServletRequest req, HttpServletRequest res) {
        String userName = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(userName, age);
        memberRepos.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }
}
