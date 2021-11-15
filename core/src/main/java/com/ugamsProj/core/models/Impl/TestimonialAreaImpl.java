package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.TestimonialArea;
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
        List<Map<String, String>> TestimonialAreaMap = new ArrayList<>();
        if (field != null) {
            for (Resource fact : field.getChildren()) {
                Map<String, String> TestimonialMap = new HashMap<>();
                TestimonialMap.put("name", fact.getValueMap().get("name", String.class));
                TestimonialMap.put("desg", fact.getValueMap().get("desg", String.class));
                TestimonialMap.put("desc", fact.getValueMap().get("desc", String.class));
                TestimonialAreaMap.add(TestimonialMap);
            }
        }
        return TestimonialAreaMap;
    }
}
