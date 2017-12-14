package ru.rogov.tests.classes;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rogov.base.TestBase;
import org.testng.annotations.Test;

public class MyTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void test() {
        Response response = restRequest.getRequest("/apitest/accounts/12345678");
    }

}
