package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.OSGIConfigModelDemo;
import com.ugamsProj.core.services.OSGIConfigService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGIConfigModelDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGIConfigModelDemoImpl implements OSGIConfigModelDemo{
    @OSGiService
    OSGIConfigService osgiConfigService;

    @Override
    public String getServiceName() {
        return osgiConfigService.getServiceName();
    }

    @Override
    public int getServiceID() {
        return osgiConfigService.getServiceID();
    }

    @Override
    public boolean getIsService() {
        return osgiConfigService.isService();
    }

    @Override
    public String[] getCountries() {
        return osgiConfigService.getCountries();
    }

    @Override
    public String getRunModes() {
        return osgiConfigService.getRunModes();
    }
}
