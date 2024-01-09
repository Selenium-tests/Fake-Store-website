package com.commonstepdefs;

import io.cucumber.java.en.Given;
import qa.testutil.TestUtil;

public class WebPageManageCommonSteps {

    private final TestUtil testUtil;


    public WebPageManageCommonSteps(TestUtil testUtil) {

        this.testUtil = testUtil;
    }

    @Given("The page with url {string} is open")
    public void pageIsOpen(String url) {

        testUtil.goToUrl(url);
    }
}
