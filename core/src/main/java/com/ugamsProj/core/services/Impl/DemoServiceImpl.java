package com.ugamsProj.core.services.Impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamsProj.core.utils.ResolverUtil;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.annotations.Component;
import com.ugamsProj.core.services.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.*;

@Component(service = DemoService.class,immediate = true)
public class DemoServiceImpl implements DemoService{
    @SlingObject
    ResourceResolver resourceResolver;
    @OSGiService
    ResourceResolverFactory resourceResolverFactory;
    @Inject
    private QueryBuilder queryBuilder;


    @Override
    public String getUsers() {
        final Logger LOG = LoggerFactory.getLogger(DemoServiceImpl.class);

        List<String> usernames = new ArrayList<>();

        String Users=" ";

        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try (ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory)) {
            LOG.debug("try method");
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {

                Users = Users + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }
        } catch (LoginException | RepositoryException loginException) {
            loginException.printStackTrace();
        }


        return  Users;
    }

}
