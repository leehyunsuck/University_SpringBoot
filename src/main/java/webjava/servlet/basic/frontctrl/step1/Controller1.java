package webjava.servlet.basic.frontctrl.step1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Controller1 {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
