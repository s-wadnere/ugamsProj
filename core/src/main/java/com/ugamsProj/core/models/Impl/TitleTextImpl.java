package com.ugamsproj.core.models.impl;

import com.ugamsproj.core.models.TitleText;
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

    @Inject
    Boolean sectionGap;

    @Inject
    Boolean bottomPadding;

    @Inject
    Boolean color;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Boolean getSectionGap() {
        return sectionGap;
    }

    @Override
    public Boolean getBottomPadding() {
        return bottomPadding;
    }

    @Override
    public Boolean getColor() { return color; }
}
