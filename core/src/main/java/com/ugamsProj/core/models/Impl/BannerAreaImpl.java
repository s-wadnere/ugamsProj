package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.BannerArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = BannerArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerAreaImpl implements BannerArea{
    @Inject
    String title;
    @Inject
    String desc;
    @Inject
    String heading;
    @Inject
    String buttonTitle;
    @Inject
    String img;
    @Override
    public String getBannerAreaTitle() {
        return title;
    }
    @Override
    public String getBannerAreaHeading() {
        return heading;
    }
    @Override
    public String getBannerAreaDescription() {
        return desc;
    }
    @Override
    public String getBannerAreaButtonTitle() {
        return buttonTitle;
    }
    @Override
    public String getImg() {
        return img;
    }

}
