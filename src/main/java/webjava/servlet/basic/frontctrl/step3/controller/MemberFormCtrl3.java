package webjava.servlet.basic.frontctrl.step3.controller;

import webjava.servlet.basic.frontctrl.ModelView;
import webjava.servlet.basic.frontctrl.step3.Controller3;

import java.util.Map;

public class MemberFormCtrl3 implements Controller3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-forms");
    }
}
