package com.ugamsProj.core.models.Impl;

import com.day.cq.commons.date.DateUtil;
import com.day.cq.commons.date.InvalidDateException;
import com.day.cq.replication.*;
import com.ugamsProj.core.services.SchedularService;
import com.ugamsProj.core.utils.ResolverUtil;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Calendar;

@Component(immediate = true)
public class ReplicationProcessor implements Preprocessor {
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    @Reference
    SchedularService schedularService;

    @Override
    public void preprocess(ReplicationAction replicationAction, ReplicationOptions replicationOptions) throws ReplicationException {

        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            return;
        }
        String path = replicationAction.getPath();
        if (path.equals("/content/ugamsProj/us/en/scheduler")) {

            try(ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory)) {

                Session session = serviceResourceResolver.adaptTo(Session.class);
                Resource resource = serviceResourceResolver.getResource("/content/ugamsProj/us/en/scheduler/jcr:content/root/container/container/date_time");
                Node node = resource.adaptTo(Node.class);
                if (node.getProperty("time") != DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance()))) {
                    schedularService.getServiceName("/content/ugamsProj/us/en/scheduler/jcr:content/root/container/container/date_time");
                }
                session.save();
                session.logout();
            } catch (LoginException | RepositoryException | InvalidDateException e) {
                e.printStackTrace();
            }
        }
    }
}