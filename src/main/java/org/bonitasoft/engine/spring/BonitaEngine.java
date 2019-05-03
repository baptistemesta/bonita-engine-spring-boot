package org.bonitasoft.engine.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.platform.LogoutException;
import org.bonitasoft.engine.test.TestEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BonitaEngine {

    private TestEngine engine;
    private APIClient apiClient;

    @Autowired
    public BonitaEngine(TestEngine engine, APIClient apiClient) {
        this.engine = engine;
        this.apiClient = apiClient;
    }

    @PostConstruct
    public void start() throws Exception {
        engine.start();
        apiClient.login("install", "install");
    }

    @PreDestroy
    public void stop() throws LogoutException {
        apiClient.logout();
    }
}
