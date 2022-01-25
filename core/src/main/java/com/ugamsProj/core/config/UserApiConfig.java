package com.ugamsProj.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="UgamsProj - User API Configuration",
        description = " User API Configuration Demo")
public @interface UserApiConfig {

    @AttributeDefinition(
            name = "API for single user",
            description = "Enter API for single user",
            type = AttributeType.STRING)
    public String singleUserApi() default "https://reqres.in/api/users/";

    @AttributeDefinition(
            name = "API for multi user",
            description = "Enter API for multi user",
            type = AttributeType.STRING)
    public String multiUserApi() default "https://reqres.in/api/users?page=";
}
