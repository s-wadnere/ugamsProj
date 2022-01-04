package com.ugamsProj.core.models.Impl;

import com.day.cq.wcm.api.Page;
import com.ugamsProj.core.config.ContextAwareConfig;
import com.ugamsProj.core.models.Caconfiguration;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CaconfigurationImplTest {

    AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    CaconfigurationImpl caconfiguration;
    Page currentPage ;
    ResourceResolver resourceResolver = mock(ResourceResolver.class);
    Resource contentResource = mock(Resource.class);
    ConfigurationBuilder configurationBuilder = mock(ConfigurationBuilder.class);
    private String siteCountry;
    private String siteAdmin;
    private String siteSection;

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        caconfiguration=aemContext.registerService(new CaconfigurationImpl());
        ContextAwareConfig caConfig = mock(ContextAwareConfig.class);
        lenient().when(caConfig.siteAdmin()).thenReturn("ugam");
        lenient().when(caConfig.siteCountry()).thenReturn("us");
        currentPage = aemContext.create().page("/content/ugamsProj/us/en");
        String currentPath = "/content/ugamsProj/us/en";
        //Resource contentResource = resourceResolver.getResource(currentPath);
        PrivateAccessor.setField(caconfiguration,"currentPage",currentPage);
        PrivateAccessor.setField(caconfiguration,"resourceResolver",resourceResolver);
        when(resourceResolver.getResource(currentPath)).thenReturn(contentResource);
        when(contentResource.adaptTo(ConfigurationBuilder.class)).thenReturn(configurationBuilder);
        //PrivateAccessor.setField(caConfig,"contentResource",contentResource);
        when(configurationBuilder.as(ContextAwareConfig.class)).thenReturn(caConfig);
        caconfiguration.postConstruct();
    }

    @Test
    void getSiteCountry() {
        assertEquals("us",caconfiguration.getSiteCountry());
    }

    @Test
    void getSiteAdmin() {
        assertEquals("ugam",caconfiguration.getSiteAdmin());
    }

}