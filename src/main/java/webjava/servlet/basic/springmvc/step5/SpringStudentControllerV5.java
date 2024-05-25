package webjava.servlet.basic.springmvc.step5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.List;

//반환을 문자열로 할 경우 view이름으로 인식함

@Controller
@RequestMapping("/springmvc/step5/members")
public class SpringStudentControllerV5 {

    MemberRepos memberRepos = new MemberRepos();
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String form() {
        return "new-forms";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("username") String userName, @RequestParam("age") int age, Model model) {
        
        Member member = new Member(userName, age);
        memberRepos.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Member> members = memberRepos.findAll();

        model.addAttribute("members", members);

        return "members";
    }
}
