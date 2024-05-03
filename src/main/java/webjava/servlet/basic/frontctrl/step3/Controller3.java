package webjava.servlet.basic.frontctrl.step3;

import webjava.servlet.basic.frontctrl.ModelView;

import java.util.Map;

public interface Controller3 {
    ModelView process(Map<String,String> paramMap);
}
