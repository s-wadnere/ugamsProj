package com.ugamsproj.core.models.impl;

import com.day.cq.commons.date.DateUtil;
import com.day.cq.commons.date.InvalidDateException;
import com.day.cq.replication.*;
import com.ugamsproj.core.services.SchedularService;
import com.ugamsproj.core.utils.ResolverUtil;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Calendar;

@Component(immediate = true)
public class ReplicationProcessor implements Preprocessor {
    //private static final Logger log = LoggerFactory.getLogger(ReplicationProcessor.class);
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    @Reference
    SchedularService schedularService;

<<<<<<< Updated upstream
    String compPath = "/content/ugamsProj/us/en/scheduler/jcr:content/root/container/container/date_time";

=======
>>>>>>> Stashed changes
    @Override
    public void preprocess(ReplicationAction replicationAction, ReplicationOptions replicationOptions) throws ReplicationException {

        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            return;
        }
        String path = replicationAction.getPath();
<<<<<<< Updated upstream
        if (path.equals("/content/ugamsProj/us/en/scheduler")) {
            //log.debug("==========Preprocessor Triggered============");

            ResourceResolver serviceResourceResolver = null;
            try {
                //log.debug("===============inside try====================");
                serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
=======
        if(path.equals("/content/ugamsproj/us/en/scheduler")){
            log.debug("==========Preprocessor Triggered============");


            try(ResourceResolver serviceResourceResolver  = ResolverUtil.newResolver(resourceResolverFactory)) {
                log.debug("===============inside try====================");
>>>>>>> Stashed changes
                Session session = serviceResourceResolver.adaptTo(Session.class);
                Resource resource = serviceResourceResolver.getResource("/content/ugamsproj/us/en/scheduler/jcr:content/root/container/container/date_time");
                Node node = resource.adaptTo(Node.class);
<<<<<<< Updated upstream
                if (node.getProperty("time") != DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance()))) {
                    //log.debug("===============inside if====================");
                    schedularService.getServiceName(compPath);
=======
                if(node.getProperty("time") != DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())))
                {
                    log.debug("===============inside if====================");
                    schedularService.getServiceName("/content/ugamsproj/us/en/scheduler/jcr:content/root/container/container/date_time");
>>>>>>> Stashed changes
                }
                session.save();
                session.logout();
            } catch (LoginException | RepositoryException | InvalidDateException e) {
                e.printStackTrace();
            }
/*try {
            log.debug(path);
        }
        catch (Exception e) {
            log.debug(e.getMessage());
        }*/
        }
    }
}