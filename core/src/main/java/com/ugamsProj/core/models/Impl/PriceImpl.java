package com.ugamsProj.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugamsProj.core.models.Price;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Price.class,
        resourceType = PriceImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions ="json",selector = "price_comp",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true")
        })

@JsonRootName("price")
public class PriceImpl implements Price{
    protected static final String RESOURCE_TYPE="ugamsProj/components/content/price";

    @Inject
    String type;
    @Inject
    String num;
    @Inject
    String title;
    @Inject
    String text1;
    @Inject
    String text2;
    @Inject
    String text3;
    @Override
    public String getPriceType() {
        return type;
    }
    @JsonProperty(value="Title")
    @Override
    public String getPriceTitle() {
        return title;
    }
    @Override
    public String getPriceNumber() {
        return num;
    }
    @Override
    public String getPriceText1() {
        return text1;
    }
    @Override
    public String getPriceText2() {
        return text2;
    }
    @Override
    public String getPriceText3() {
        return text3;
    }
}
