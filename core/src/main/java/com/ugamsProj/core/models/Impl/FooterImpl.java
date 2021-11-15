package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.Footer;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Footer.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterImpl implements Footer{

    @Inject
    String title1;
    @Inject
    String title2;
    @Inject
    String title3;
    @Inject
    String text1;
    @Inject
    String text2;
    @Inject
    String text3;

    @Override
    public String getTitle1() {
        return title1;
    }

    @Override
    public String getTitle2() {
        return title2;
    }

    @Override
    public String getTitle3() {
        return title3;
    }

    @Override
    public String getText1() {
        return text1;
    }

    @Override
    public String getText2() {
        return text2;
    }

    @Override
    public String getText3() {
        return text3;
    }
}
