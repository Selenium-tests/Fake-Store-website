package qa.utils;

import qa.testutil.TestUtil;

public class ConditionalUrlNavigator {

    public static void openIfUrlIsNot(TestUtil testUtil, String url) {

        if (!testUtil.getDriver().getCurrentUrl().equals(url)) {

            testUtil.goToUrl(url);
        }
    }
}
