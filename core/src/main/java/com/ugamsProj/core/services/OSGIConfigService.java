package com.ugamsProj.core.services;

public interface OSGIConfigService {
    public String getServiceName();
    public int getServiceID();
    public boolean isService();
    public String[] getCountries() ;
    public String getRunModes();
}
