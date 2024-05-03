package webjava.servlet.basic.frontctrl.step3.controller;

import webjava.servlet.basic.frontctrl.ModelView;
import webjava.servlet.basic.frontctrl.step3.Controller3;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.Map;

public class MemberSaveCtrl3 implements Controller3 {
    MemberRepos memberRepos = new MemberRepos();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String userName = paramMap.get("userName");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(userName, age);
        memberRepos.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}
