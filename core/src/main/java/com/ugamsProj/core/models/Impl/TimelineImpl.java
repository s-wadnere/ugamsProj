package com.ugamsProj.core.models.Impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugamsProj.core.models.Timeline;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Model(adaptables = Resource.class,
        adapters = Timeline.class,
        resourceType = TimelineImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


@Exporter(name = "jackson", extensions ="json",selector = "timeline_comp",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true")
        })

@JsonRootName("timeline")
public class TimelineImpl implements Timeline{

    final protected static String RESOURCE_TYPE="ugamsProj/components/content/timeline";

    @ChildResource
    Resource timelinemulti;

    //@JsonProperty(value="Timeline Details")
    @Override
    public List<Map<String, String>> getTimeLineDetails() {
        List<Map<String, String>> timeLineMap=new ArrayList<>();

        if(timelinemulti!=null){
            for (Resource fact : timelinemulti.getChildren()) {
                Map<String,String> timelinearea=new HashMap<>();
                timelinearea.put("title",fact.getValueMap().get("title",String.class));
                timelinearea.put("year",fact.getValueMap().get("year",String.class));
                timelinearea.put("result",fact.getValueMap().get("result",String.class));
                timeLineMap.add(timelinearea);
            }
        }
        return timeLineMap;
    }

   /*@JsonProperty(value="Result")
    public String Result(){return "timeline";}*/

}
