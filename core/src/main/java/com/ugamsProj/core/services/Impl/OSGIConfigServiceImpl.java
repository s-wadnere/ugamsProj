package com.ugamsproj.core.services.impl;

import com.ugamsproj.core.config.OSGIConfigDemo;
import com.ugamsproj.core.services.OSGIConfigService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OSGIConfigService.class,immediate = true)
@Designate(ocd = OSGIConfigDemo.class )
public class OSGIConfigServiceImpl implements OSGIConfigService{
    private String serviceName;
    private int serviceID;
    private boolean isService;
    private String[] countries;
    private String runModes;

    @Activate
    public void activate(OSGIConfigDemo osgiConfigDemo){
        serviceName=osgiConfigDemo.serviceName();
        serviceID=osgiConfigDemo.serviceID();
        isService=osgiConfigDemo.isService();
        countries=osgiConfigDemo.serviceCountry();
        runModes=osgiConfigDemo.serviceRunMode();
    }


    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public int getServiceID() {
        return serviceID;
    }

    @Override
    public boolean isService() {
        return isService;
    }

    @Override
    public String[] getCountries() {
        return countries;
    }

    @Override
    public String getRunModes() {
        return runModes;
    }
}
