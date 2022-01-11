package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.config.OSGIConfigDemo;
import com.ugamsProj.core.models.OSGIConfigModelDemo;
import com.ugamsProj.core.services.Impl.OSGIConfigServiceImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class OSGIConfigModelDemoImplTest {
    AemContext aemContext = new AemContext();
    OSGIConfigServiceImpl osgiConfig;
    private String serviceName;
    private int serviceID;
    private boolean isService;
    private String[] countries;
    private String runModes;
    private String[] country={"us","in"};

    @BeforeEach
    void setUp() {
        osgiConfig=aemContext.registerService(new OSGIConfigServiceImpl());
        OSGIConfigDemo ugamOSGIConfig = mock(OSGIConfigDemo.class);
        when(ugamOSGIConfig.serviceName()).thenReturn("Demo Service");
        when(ugamOSGIConfig.serviceRunMode()).thenReturn("author");
        when(ugamOSGIConfig.serviceID()).thenReturn(0);
        when(ugamOSGIConfig.isService()).thenReturn(false);
        when(ugamOSGIConfig.serviceCountry()).thenReturn(country);
        osgiConfig.activate(ugamOSGIConfig);
    }

    @Test
    void getServiceName() {
        OSGIConfigModelDemo osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelDemo.class);
        assertEquals("Demo Service", osgiConfigModel.getServiceName());
    }

    @Test
    void getServiceID() {
        OSGIConfigModelDemo osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelDemo.class);
        assertEquals(0, osgiConfigModel.getServiceID());
    }

    @Test
    void getIsService() {
        OSGIConfigModelDemo osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelDemo.class);
        assertEquals(false, osgiConfigModel.getIsService());
    }

    @Test
    void getCountries() {
        OSGIConfigModelDemo osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelDemo.class);
        assertEquals(country, osgiConfigModel.getCountries());
    }

    @Test
    void getRunModes() {
        OSGIConfigModelDemo osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelDemo.class);
        assertEquals("author", osgiConfigModel.getRunModes());
    }
}