package webjava.servlet.basic.springmvc.step1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringStudentFormControllerV1 {
    @RequestMapping("/springmvc/step1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-forms");
    }
}
