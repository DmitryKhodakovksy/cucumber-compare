package w3shools.stepsDef;

import com.epam.cucumber.compare.qa.common.gui.services.pages.HomePageObject;
import com.epam.cucumber.compare.qa.common.gui.services.webdriver.WrappedWebdriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


public class AbstractStepsDef {

    @Autowired
    @Lazy
    public WrappedWebdriver driver;

    @Autowired
    @Lazy
    protected HomePageObject homePage;

}
