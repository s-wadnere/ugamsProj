package com.ugamsproj.core.models.impl;

import com.ugamsproj.core.models.TestimonialArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = TestimonialArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestimonialAreaImpl implements TestimonialArea{
    @ChildResource
    Resource field;
    @Override
    public List<Map<String, String>> getTestimonialAreaDetails() {
        List<Map<String, String>> testimonialAreaMap = new ArrayList<>();
        if (field != null) {
            for (Resource fact : field.getChildren()) {
                Map<String, String> testimonialMap = new HashMap<>();
                testimonialMap.put("name", fact.getValueMap().get("name", String.class));
                testimonialMap.put("desg", fact.getValueMap().get("desg", String.class));
                testimonialMap.put("desc", fact.getValueMap().get("desc", String.class));
                testimonialAreaMap.add(testimonialMap);
            }
        }
        return testimonialAreaMap;
    }
}
