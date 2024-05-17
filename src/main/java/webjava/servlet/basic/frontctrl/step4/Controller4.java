package webjava.servlet.basic.frontctrl.step4;

import java.util.Map;

public interface Controller4 {
    //process 메소드는 Map객체 paraMap과 Map객체 model을 받음
    String process (Map<String, String> paramMap, Map<String, Object> model);
}
