package webjava.servlet.basic.springmvc.step6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.List;

//반환을 문자열로 할 경우 view이름으로 인식함

@Controller
@RequestMapping("/springmvc/step6/members")
public class SpringStudentControllerV6 {

    MemberRepos memberRepos = new MemberRepos();
    @GetMapping("/new-form")
    public String form() {
        return "new-forms";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String userName, @RequestParam("age") int age, Model model) {

        Member member = new Member(userName, age);
        memberRepos.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String list(Model model) {
        List<Member> members = memberRepos.findAll();

        model.addAttribute("members", members);

        return "members";
    }
}
