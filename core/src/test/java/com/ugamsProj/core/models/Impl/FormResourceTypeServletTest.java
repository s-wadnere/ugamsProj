package com.ugamsProj.core.models.Impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FormResourceTypeServletTest {
    FormResourceTypeServlet resourceTypeServletTest = new FormResourceTypeServlet();


    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet(AemContext aemContext) throws ServletException, IOException {
        MockSlingHttpServletRequest mockSlingRequest = aemContext.request();
        MockSlingHttpServletResponse mockSlingResponse = aemContext.response();
        aemContext.create().page("/content/ugamsProj/us/en");
        aemContext.create().page("/content/ugamsProj/us/en/demo2");
        resourceTypeServletTest.doGet(mockSlingRequest,mockSlingResponse);
        List pagesList = new ArrayList();
        pagesList.add("demo2");
        assertEquals(pagesList.toString(),mockSlingResponse.getOutputAsString());
    }
}