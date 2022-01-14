package com.ugamsproj.core.models.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class})
class FormAdditionPathTypeServletTest {

    AemContext aemContext = new AemContext();
    FormAdditionPathTypeServlet form = new FormAdditionPathTypeServlet();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet() throws IOException {


        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("number1",5);
        map.put("number2",5);
        request.setParameterMap(map);
        form.doGet(request,response);
        assertEquals(10, Integer.parseInt(response.getOutputAsString()));

    }
}