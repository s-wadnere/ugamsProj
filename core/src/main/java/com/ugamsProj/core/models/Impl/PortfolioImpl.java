package com.ugamsproj.core.models.impl;

import com.ugamsproj.core.models.Portfolio;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Portfolio.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PortfolioImpl implements Portfolio{
    @Inject
    String portfolioText;
    @Inject
    String portfolioTitle;
    @Inject
    String img;

    @Override
    public String getPortfolioTitle() {
        return portfolioText;
    }
    @Override
    public String getPortfolioText() {
        return portfolioTitle;
    }
    @Override
    public String getImg() {
        return img;
    }

}
