package com.ugamsProj.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "UgamsProj - CA Configuration",description = "Context Aware Configuration for ugamsProj")
public @interface ContextAwareConfig {

    @Property(label ="Country site",description = "Site Name")
    String siteCountry() default "us";
    @Property(label = "site admin",description = "Admin")
    String siteAdmin() default "admin";
}
