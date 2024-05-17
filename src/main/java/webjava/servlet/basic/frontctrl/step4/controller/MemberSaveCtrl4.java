package webjava.servlet.basic.frontctrl.step4.controller;

import webjava.servlet.basic.frontctrl.step4.Controller4;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.Map;

public class MemberSaveCtrl4 implements Controller4 {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        String userName = paramMap.get("userName");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(userName, age);
        memberRepos.save(member);

        model.put("member", member);

        return "save-result";
    }
}
