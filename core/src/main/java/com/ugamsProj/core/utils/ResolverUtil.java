package com.ugamsProj.core.utils;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import java.util.HashMap;
import java.util.Map;

public class ResolverUtil {
    private ResolverUtil() {
    }
    public static final String AEM_SERVICE_USER = "aemserviceuser";

    public static ResourceResolver newResolver(ResourceResolverFactory resourceResolverFactory ) throws LoginException {
        final Map<String, Object> paramMap = new HashMap<>();
        paramMap.put( ResourceResolverFactory.SUBSERVICE, AEM_SERVICE_USER );

        return resourceResolverFactory.getServiceResourceResolver(paramMap);
    }
}
