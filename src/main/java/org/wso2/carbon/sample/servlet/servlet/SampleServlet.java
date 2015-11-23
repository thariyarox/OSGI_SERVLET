package org.wso2.carbon.sample.servlet.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SampleServlet extends HttpServlet {

    private static final long serialVersionUID = -7182121722709941646L;
    private static final Log log = LogFactory.getLog(SampleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Sample Servlet doGet got Hit !");

        resp.setContentType("text/plain");
        resp.getWriter().write("You are inside the servlet !");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Sample Servlet doPost got Hit !");

        resp.setContentType("text/plain");
        resp.getWriter().write("You are inside the servlet !");
    }
}
