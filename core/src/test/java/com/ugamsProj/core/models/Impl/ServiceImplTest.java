package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.Portfolio;
import com.ugamsProj.core.models.Service;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class ServiceImplTest {
    private final AemContext aemContext = new AemContext();


    @BeforeEach
    void setUp() {
        aemContext.load().json("/Service.json","/content");
    }

    @Test
    void getServiceTitle() {
        Resource resource = aemContext.currentResource("/content");
        Service service = resource.adaptTo(Service.class);
        assertEquals("Photography", service.getServiceTitle());
    }

    @Test
    void getServiceText() {
        Resource resource = aemContext.currentResource("/content");
        Service service = resource.adaptTo(Service.class);
        assertEquals("The more effort you put into improving your skills.", service.getServiceText());
    }
}