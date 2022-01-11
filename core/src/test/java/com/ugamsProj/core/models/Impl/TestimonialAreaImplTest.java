package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.Service;
import com.ugamsProj.core.models.TestimonialArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TestimonialAreaImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/TestimonialArea.json","/content");
    }

    @Test
    void getTestimonialAreaDetails() {
        Resource resource = aemContext.currentResource("/content");
        TestimonialArea testimonialArea = resource.adaptTo(TestimonialArea.class);
        assertEquals("Testimonial", testimonialArea.getTestimonialAreaDetails().get(0).get("name"));
        assertEquals("desg", testimonialArea.getTestimonialAreaDetails().get(0).get("desg"));
        assertEquals("Testimonial area", testimonialArea.getTestimonialAreaDetails().get(0).get("desc"));

    }
}