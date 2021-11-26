package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.BannerArea;
import com.ugamsProj.core.models.Price;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerAreaImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    private BannerArea bannerArea;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/BannerArea.json","/content");
    }

    @Test
    void getBannerAreaTitle() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("THIS IS ME", bannerArea.getBannerAreaTitle());
    }

    @Test
    void getBannerAreaHeading() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("PHILIP GILBERT", bannerArea.getBannerAreaHeading());
    }

    @Test
    void getBannerAreaDescription() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.", bannerArea.getBannerAreaDescription());
    }

    @Test
    void getBannerAreaButtonTitle() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("DISCOVER NOW", bannerArea.getBannerAreaButtonTitle());

    }

    @Test
    void getImg() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("/content/dam/ugamsProj/hero-img.png", bannerArea.getImg());
    }

    @Test
    void getBannerAreaPathField() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("/content/ugamsProj/us/en/about", bannerArea.getBannerAreaPathField());
    }
}