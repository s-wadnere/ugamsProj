package com.ugamsProj.core.models.Impl;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamsProj.core.models.ServiceDemo;
import com.ugamsProj.core.utils.ResolverUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceDemoImpl implements ServiceDemo {

    @Inject
    private ResourceResolverFactory resourceResolverFactory;
    final Logger LOG = LoggerFactory.getLogger(ServiceDemoImpl.class);
    @Inject
    ResourceResolver resolver;
    @Inject
    QueryBuilder queryBuilder;
    String user = " ";
    /*@PostConstruct
    protected void init(){
        LOG.info("\n printing Model logs");
    }*/

    @Override
    public String getUsersList() {
        List<String> usernames = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try{
            //LOG.info("\n Inside Try..");
            ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            // LOG.info("\n resolver hit "+serviceResourceResolver.getUserID());
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {

                user = user + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }
        } catch (RepositoryException | LoginException e) {
            LOG.info("Service User ERROR",e.getMessage());
        }
        return user;
    }

}
