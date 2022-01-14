package com.ugamsproj.core.models.impl;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamsproj.core.models.ServiceDemo;
import com.ugamsproj.core.utils.ResolverUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceDemoImpl implements ServiceDemo {

    @Inject
    private ResourceResolverFactory resourceResolverFactory;
    final Logger logger = LoggerFactory.getLogger(ServiceDemoImpl.class);
    @Inject
    ResourceResolver resolver;
    @Inject
    QueryBuilder queryBuilder;
    String user = " ";
    /*@PostConstruct
    protected void init(){
<<<<<<< Updated upstream
        LOG.info("\n printing Model logs");
    }*/
=======
        logger.info("\n printing Model logs");
    }
>>>>>>> Stashed changes

    @Override
    public String getUsersList() {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
<<<<<<< Updated upstream
        try{
            //LOG.info("\n Inside Try..");
            ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            // LOG.info("\n resolver hit "+serviceResourceResolver.getUserID());
=======
        try(ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory)){
            logger.info("\n Inside Try..");
>>>>>>> Stashed changes
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> hits = result.getHits();
            for (Hit hit : hits) {

                user = user.concat("\r\n").concat(hit.getProperties().get("rep:principalName", String.class));
            }
<<<<<<< Updated upstream
        } catch (RepositoryException | LoginException e) {
            LOG.info("Service User ERROR",e.getMessage());
=======
        } catch (RepositoryException e) {
            logger.info(e.getMessage());
        } catch (LoginException e) {
            e.printStackTrace();
>>>>>>> Stashed changes
        }
        return user;
    }

}
