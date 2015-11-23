package org.wso2.carbon.sample.servlet;

import org.osgi.service.http.HttpService;

/**
 * Singleton class to hold HTTP Service
 */
public class DataHolder {

    private static volatile DataHolder dataHolder = null;

    private HttpService httpService;

    private DataHolder() {

    }

    public static DataHolder getInstance() {

        if (dataHolder == null) {
            synchronized (DataHolder.class) {
                if (dataHolder == null) {
                    dataHolder = new DataHolder();
                }
            }
        }

        return dataHolder;
    }

    public HttpService getHttpService() {
        return httpService;
    }

    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

}
