package com.ugamsProj.core.services.Impl;

import com.day.cq.commons.date.DateUtil;

import com.ugamsProj.core.services.SchedularService;
import com.ugamsProj.core.utils.ResolverUtil;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.jcr.Node;
import javax.jcr.Session;
import java.util.Calendar;

@Component(service = SchedularService.class,immediate = true)
public class SchedularServiceImpl implements SchedularService {

    @Reference
    ResourceResolverFactory resourceResolverFactory;
    @Override

    public void getServiceName(String path) {
        try(ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory))  {

            Session session = serviceResourceResolver.adaptTo(Session.class);
            Resource resource = serviceResourceResolver.getResource(path);

            Node node=resource.adaptTo(Node.class);
            node.setProperty("time", DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())));
            session.save();
            session.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
