package com.ugamsproj.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.ugamsproj.core.config.ContextAwareConfig;
import com.ugamsproj.core.models.Caconfiguration;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.ConfigurationResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import javax.annotation.PostConstruct;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Caconfiguration.class,
        resourceType = CaconfigurationImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class CaconfigurationImpl implements Caconfiguration {
    protected static final String RESOURCE_TYPE="";
    @SlingObject
    ResourceResolver resourceResolver;
    @ScriptVariable
    Page currentPage;
    @OSGiService
    ConfigurationResolver configurationResolver;
    private String siteCountry;
    private String siteAdmin;

    @Override
    public String getSiteCountry() {
        return siteCountry;
    }

    @Override
    public String getSiteAdmin() {
        return siteAdmin;
    }

    @PostConstruct
    public void postConstruct(){
        ContextAwareConfig caConfig = getContextAwareConfig(currentPage.getPath(),resourceResolver);
        siteCountry= caConfig.siteCountry();
        siteAdmin = caConfig.siteAdmin();
    }

    public ContextAwareConfig getContextAwareConfig(String currentPage,ResourceResolver resourceResolver){
        String currentPath = StringUtils.isNoneBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null){
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder!= null){
                return configurationBuilder.as(ContextAwareConfig.class);
            }
        }
        return null;
    }
}
