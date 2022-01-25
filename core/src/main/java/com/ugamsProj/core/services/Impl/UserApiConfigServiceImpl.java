package com.ugamsProj.core.services.Impl;


import com.ugamsProj.core.config.UserApiConfig;
import com.ugamsProj.core.services.UserApiConfigService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = UserApiConfigService.class,immediate = true)
@Designate(ocd = UserApiConfig.class )
public class UserApiConfigServiceImpl implements UserApiConfigService{

    String singleUserApi;
    String multiUserApi;

    @Activate
    public void activate(UserApiConfig userApiConfig) {

        singleUserApi = userApiConfig.singleUserApi();
        multiUserApi = userApiConfig.multiUserApi();

    }
    @Override
    public String getSingleUserApi() {
        return singleUserApi;
    }

    @Override
    public String getMultiUserApi() {
        return multiUserApi;
    }
}
