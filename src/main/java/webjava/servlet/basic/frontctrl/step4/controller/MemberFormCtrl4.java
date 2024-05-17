package webjava.servlet.basic.frontctrl.step4.controller;

import webjava.servlet.basic.frontctrl.step4.Controller4;

import java.util.Map;

public class MemberFormCtrl4 implements Controller4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-forms";
    }
}
