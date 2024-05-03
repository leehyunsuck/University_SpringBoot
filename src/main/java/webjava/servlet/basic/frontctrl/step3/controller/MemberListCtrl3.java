package webjava.servlet.basic.frontctrl.step3.controller;

import webjava.servlet.basic.frontctrl.ModelView;
import webjava.servlet.basic.frontctrl.step3.Controller3;
import webjava.servlet.student.member.Member;
import webjava.servlet.student.member.MemberRepos;

import java.util.List;
import java.util.Map;

public class MemberListCtrl3 implements Controller3 {
    MemberRepos memberRepos = new MemberRepos();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepos.findAll();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);

        return modelView;
    }
}
