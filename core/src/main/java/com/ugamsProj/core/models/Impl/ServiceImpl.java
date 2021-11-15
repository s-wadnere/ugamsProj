package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Service.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceImpl implements Service{
    @Inject
    String title;
    @Inject
    String text;

    @Override
    public String getServiceTitle() {
        return title;
    }
    @Override
    public String getServiceText() {
        return text;
    }

}
