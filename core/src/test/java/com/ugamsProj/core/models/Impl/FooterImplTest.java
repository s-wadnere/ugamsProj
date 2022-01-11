package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.BrandArea;
import com.ugamsProj.core.models.Footer;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FooterImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Footer.json","/content");
    }

    @Test
    void getTitle1() {
        Resource resource = aemContext.currentResource("/content");
        Footer footer = resource.adaptTo(Footer.class);
        assertEquals("title1", footer.getTitle1());
    }

    @Test
    void getTitle2() {
        Resource resource = aemContext.currentResource("/content");
        Footer footer = resource.adaptTo(Footer.class);
        assertEquals("title2", footer.getTitle2());
    }

    @Test
    void getTitle3() {
        Resource resource = aemContext.currentResource("/content");
        Footer footer = resource.adaptTo(Footer.class);
        assertEquals("title3", footer.getTitle3());
    }

    @Test
    void getText1() {
        Resource resource = aemContext.currentResource("/content");
        Footer footer = resource.adaptTo(Footer.class);
        assertEquals("text1", footer.getText1());
    }

    @Test
    void getText2() {
        Resource resource = aemContext.currentResource("/content");
        Footer footer = resource.adaptTo(Footer.class);
        assertEquals("text2", footer.getText2());
    }

    @Test
    void getText3() {
        Resource resource = aemContext.currentResource("/content");
        Footer footer = resource.adaptTo(Footer.class);
        assertEquals("text3", footer.getText3());
    }
}