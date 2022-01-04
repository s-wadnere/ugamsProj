package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.HomeAbout;
import com.ugamsProj.core.models.Portfolio;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class PortfolioImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Portfolio.json","/content");
    }

    @Test
    void getPortfolioTitle() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("2D Vinyl Design", portfolio.getPortfolioTitle());
    }

    @Test
    void getPortfolioText() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("raster", portfolio.getPortfolioText());
    }

    @Test
    void getImg() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("/content/dam/ugams/p6.jpg", portfolio.getImg());
    }
}