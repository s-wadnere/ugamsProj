package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.BrandArea;
import com.ugamsProj.core.models.Fact;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FactImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Fact.json","/content");
    }

    @Test
    void getFactAreaDetails() {
        Resource resource = aemContext.currentResource("/content");
        Fact fact = resource.adaptTo(Fact.class);
        assertEquals("2536", fact.getFactAreaDetails().get(0).get("number"));
        assertEquals("Projects Completed", fact.getFactAreaDetails().get(0).get("text"));
    }
}