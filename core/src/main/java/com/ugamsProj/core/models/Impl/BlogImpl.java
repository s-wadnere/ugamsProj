package com.ugamsproj.core.models.impl;

import com.ugamsproj.core.models.Blog;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Blog.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogImpl implements Blog{
    @Inject
    String blogTitle;
    @Inject
    String blogText;
    @Inject
    String img;
    @Override
    public String getBlogTitle() {
        return blogTitle;
    }
    @Override
    public String getBlogText() {
        return blogText;
    }
    @Override
    public String getImg() {
        return img;
    }
}
