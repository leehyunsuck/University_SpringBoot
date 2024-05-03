package webjava.servlet.basic.frontctrl.step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webjava.servlet.basic.frontctrl.View;

import java.io.IOException;

public interface Controller2 {
    View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
