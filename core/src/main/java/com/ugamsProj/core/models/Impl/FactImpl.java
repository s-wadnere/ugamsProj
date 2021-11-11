package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.Fact;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = Fact.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FactImpl implements Fact{
    @ChildResource
    Resource field;
    @Override
    public List<Map<String, String>> getFactAreaDetails() {
        List<Map<String, String>> factAreaMap = new ArrayList<>();
        if (field != null) {
            for (Resource fact : field.getChildren()) {
                Map<String, String> factMap = new HashMap<>();
                factMap.put("number", fact.getValueMap().get("number", String.class));
                factMap.put("text", fact.getValueMap().get("text", String.class));
                factAreaMap.add(factMap);
            }
        }
        return factAreaMap;
    }

}
