package com.joni;

import com.joni.model.WindowModel;
import org.testfx.framework.junit5.ApplicationTest;

// ApplicationTest already includes the necessary @BeforeEach, @AfterEach, etc.
public class TestFXBase extends ApplicationTest {

    private final WindowModel windowModel = new WindowModel();

    protected WindowModel getWindowModel() {
        return windowModel;
    }

}
