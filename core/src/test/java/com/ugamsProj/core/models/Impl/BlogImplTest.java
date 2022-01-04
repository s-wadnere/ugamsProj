package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.BannerNav;
import com.ugamsProj.core.models.Blog;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BlogImplTest {
    private final AemContext aemContext = new AemContext();


    @BeforeEach
    void setUp() {
        aemContext.load().json("/Blog.json","/content");
    }

    @Test
    void getBlogTitle() {
        Resource resource = aemContext.currentResource("/content");
        Blog blog = resource.adaptTo(Blog.class);
        assertEquals("DO DREAMS SERVE AS A PREMONITION", blog.getBlogTitle());
    }

    @Test
    void getBlogText() {
        Resource resource = aemContext.currentResource("/content");
        Blog blog = resource.adaptTo(Blog.class);
        assertEquals("So many of us are demotivated to achieve anything.", blog.getBlogText());
    }

    @Test
    void getImg() {
        Resource resource = aemContext.currentResource("/content");
        Blog blog = resource.adaptTo(Blog.class);
        assertEquals("/content/dam/ugamsProj/b3.jpg", blog.getImg());
    }
}