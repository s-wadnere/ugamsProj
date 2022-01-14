package com.ugamsproj.core.models.impl;

import com.ugamsproj.core.models.Price;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.sling.api.resource.Resource;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PriceImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    private Price price;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Price.json","/content");
    }

    @Test
    void getPriceType() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Premium", price.getPriceType());
    }

    @Test
    void getPriceTitle() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("For the individuals", price.getPriceTitle());
    }

    @Test
    void getPriceNumber() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("03", price.getPriceNumber());
    }

    @Test
    void getPriceText1() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Secure Online Transfer", price.getPriceText1());
    }

    @Test
    void getPriceText2() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Unlimited Styles for interface", price.getPriceText2());
    }

    @Test
    void getPriceText3() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Reliable Customer Service", price.getPriceText3());
    }
}