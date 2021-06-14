package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.TitleText;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
@Model(adaptables = Resource.class,
        adapters = TitleText.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleTextImpl implements TitleText {
    @Inject
    String title;

    @Inject
    String text;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }
}
