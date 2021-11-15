package com.ugamsProj.core.models.Impl;


import com.ugamsProj.core.models.BrandArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = Resource.class,
        adapters = BrandArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BrandAreaImpl implements BrandArea{
    @Inject
    List<String> imgPath;
    @Override
    public List<String> getImgPath() {
        if(imgPath!=null)
        {
            return new ArrayList<String>(imgPath);
        }
        else
        {
            return Collections.emptyList();
        }
    }

}
