package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.Blog;
import com.ugamsProj.core.models.BrandArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BrandAreaImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/BrandArea.json","/content");
    }

    @Test
    void getImgPath() {
        Resource resource = aemContext.currentResource("/content");
        BrandArea brandArea = resource.adaptTo(BrandArea.class);
        assertEquals("/content/dam/ugamsProj/l1.png", brandArea.getImgPath().get(0));
    }

    @Test
    void getPath() {
        Resource resource = aemContext.currentResource("/content/brands");
        BrandArea brandArea = resource.adaptTo(BrandArea.class);
        assertEquals(Collections.emptyList(), brandArea.getImgPath());
    }
}