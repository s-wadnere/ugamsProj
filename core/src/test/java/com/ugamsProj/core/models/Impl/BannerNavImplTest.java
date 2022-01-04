package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.BannerNav;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerNavImplTest {
    private final AemContext aemContext = new AemContext();


    @BeforeEach
    void setUp() {
        aemContext.load().json("/BannerNav.json","/content");
    }

    @Test
    void getTitle() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("Banner Area", bannerNav.getTitle());
    }

    @Test
    void getNav1() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("nav1", bannerNav.getNav1());
    }

    @Test
    void getNav2() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("nav2", bannerNav.getNav2());
    }

    @Test
    void getPathNav1() {
        Resource resource = aemContext.currentResource("/content/bannernav");
        BannerNav bannerNav = resource.adaptTo(BannerNav.class);
        assertEquals("pathnav1", bannerNav.getPathNav1());
    }
}