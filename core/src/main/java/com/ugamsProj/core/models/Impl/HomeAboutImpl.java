package com.ugamsproj.core.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugamsproj.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions ="json",selector = "homeAbout_comp",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true")
        })

@JsonRootName("HomeAbout_Component")
public class HomeAboutImpl implements HomeAbout{

    protected static final String RESOURCE_TYPE="ugamsproj/components/content/home-about";

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
    @Inject
    String path;
    @JsonProperty(value="Title")
    @Override
    public String getHomeAboutTitle() {
        return title;
    }
    @JsonProperty(value="Heading")
    @Override
    public String getHomeAboutHeading() {
        return heading;
    }
    @JsonProperty(value="Description")
    @Override
    public String getHomeAboutDescription() {
        return desc;
    }
    @JsonProperty(value="ButtonTitle")
    @Override
    public String getHomeAboutButtonTitle() {
        return buttonTitle;
    }
    @JsonProperty(value="ImagePath")
    @Override
    public String getImg() {
        return img;
    }
    @JsonProperty(value="ComponentPath")
    @Override
    public String getHomeAboutPath() {
        return path;
    }
}
