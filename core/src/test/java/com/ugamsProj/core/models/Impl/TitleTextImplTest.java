package com.ugamsProj.core.models.Impl;

import com.adobe.xfa.Bool;
import com.ugamsProj.core.models.BannerNav;
import com.ugamsProj.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TitleTextImplTest {
    private final AemContext aemContext = new AemContext();


    @BeforeEach
    void setUp() {
        aemContext.load().json("/TitleText.json","/content");
    }

    @Test
    void getTitle() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals("My Offered Services", titleText.getTitle());
    }

    @Test
    void getText() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals("At about this time of year", titleText.getText());
    }

    @Test
    void getSectionGap() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        Boolean SectionGap = true;
        assertEquals(SectionGap, titleText.getSectionGap());

    }

    @Test
    void getBottomPadding() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        Boolean BottomPadding = false;
        assertEquals(BottomPadding, titleText.getBottomPadding());
    }

    @Test
    void getColor() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        Boolean Color = false;
        assertEquals(Color, titleText.getColor());
    }
}