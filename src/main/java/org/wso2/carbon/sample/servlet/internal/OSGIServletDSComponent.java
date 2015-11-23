package org.wso2.carbon.sample.servlet.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.equinox.http.helper.ContextPathServletAdaptor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.http.HttpService;
import org.wso2.carbon.sample.servlet.DataHolder;
import org.wso2.carbon.sample.servlet.servlet.SampleServlet;

import javax.servlet.Servlet;

/**
 * @scr.component name="osgi.servlet.dscomponent" immediate=true
 * @scr.reference name="osgi.httpservice" interface="org.osgi.service.http.HttpService"
 * cardinality="1..1" policy="dynamic" bind="setHttpService"
 * unbind="unsetHttpService"
 */


public class OSGIServletDSComponent {

    private static Log log = LogFactory.getLog(OSGIServletDSComponent.class);

    public static final String SAMPLE_SERVLET_URL = "/sampleservlet";

    protected void activate(ComponentContext ctxt) {

        // Register Sample Servlet
        Servlet sampleServlet = new ContextPathServletAdaptor(new SampleServlet(), SAMPLE_SERVLET_URL);

        try {
            DataHolder.getInstance().getHttpService().registerServlet(SAMPLE_SERVLET_URL, sampleServlet, null, null);
        } catch (Exception e) {
            String errMsg = "Error when registering Sample Servlet via the HttpService.";
            log.error(errMsg, e);
            throw new RuntimeException(errMsg, e);
        }

        log.info("OSGI SERVLET  bundle activated successfully..");
    }

    protected void deactivate(ComponentContext ctxt) {

        if (log.isDebugEnabled()) {
            log.debug("OSGI SERVLET  bundle is deactivated ");
        }
    }

    protected void setHttpService(HttpService httpService) {

        DataHolder.getInstance().setHttpService(httpService);

        if (log.isDebugEnabled()) {
            log.info("HTTP Service is set in the OSGI SERVLET bundle");
        }
    }

    protected void unsetHttpService(HttpService httpService) {

        DataHolder.getInstance().setHttpService(null);
        if (log.isDebugEnabled()) {
            log.debug("HTTP Service is unset in the OSGI SERVLET bundle");
        }
    }

}
