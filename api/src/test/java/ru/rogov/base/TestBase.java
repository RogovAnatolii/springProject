package ru.rogov.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.rogov.config.TestConfig;
import ru.rogov.rest.RestRequest;

import java.lang.reflect.Method;

@ContextConfiguration(classes = {TestConfig.class})
public class TestBase extends AbstractTestNGSpringContextTests {

    private Logger log = LoggerFactory.getLogger(TestBase.class);

    @Autowired
    protected RestRequest restRequest;

    @BeforeMethod(alwaysRun = true)
    public void settingsConfiguration(Method method) {
        log.info("Starting test method: " + method.getName());

    }

    @AfterMethod(alwaysRun = true)
    public void methodFinished(Method method) {
        log.info("Finished test method: " + method.getName());
    }

    @Autowired
    protected Environment properties;


}
