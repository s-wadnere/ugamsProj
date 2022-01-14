package com.ugamsproj.core.models.impl;

import com.ugamsproj.core.models.Timeline;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TimelineImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/timeline.json","/content");
    }

    @Test
    void getTimeLineDetails() {
        Resource resource = aemContext.currentResource("/content");
        Timeline timeline = resource.adaptTo(Timeline.class);
        assertEquals("Session: 2010-11", timeline.getTimeLineDetails().get(0).get("year"));
        assertEquals("Masters in Graphics & Fine Arts", timeline.getTimeLineDetails().get(0).get("title"));
        assertEquals("Result: 3.78 (In the Scale of 4.00)", timeline.getTimeLineDetails().get(0).get("result"));
    }


}