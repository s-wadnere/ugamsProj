package com.ugamsproj.core.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugamsproj.core.models.BannerArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = BannerArea.class,
        resourceType = BannerAreaImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions ="json",selector = "bannerarea_comp",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true")
        })

@JsonRootName("banner")
public class BannerAreaImpl implements BannerArea{
    protected static final String RESOURCE_TYPE="ugamsproj/components/content/banner-area";

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
    @Override
    public String getBannerAreaPathField() { return path; }

}
