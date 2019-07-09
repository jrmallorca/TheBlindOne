package com.joni;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.HashMap;

// ApplicationTest already includes the necessary @BeforeEach, @AfterEach, etc.
class TestFXBase extends ApplicationTest {

    private final HashMap<FXMLName, String> mapFXML = new HashMap<>();
    private final WindowModel windowModel = new WindowModel();

    HashMap<FXMLName, String> getMapFXML() {
        return mapFXML;
    }

    WindowModel getWindowModel() {
        return windowModel;
    }

}
