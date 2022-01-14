package com.ugamsproj.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "ugamsproj/components/page"
)
public class FormResourceTypeServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {

        final ResourceResolver resourceResolver = req.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/ugamsproj/us/en");

        ArrayList<String> pagesList = new ArrayList<>();
        Iterator<Page> childPagesList = page.listChildren();
        while (childPagesList.hasNext()) {
            Page childPage = childPagesList.next();
            String childPageName;
            childPageName =childPage.getTitle();
            pagesList.add(childPageName);
        }
        resp.setContentType("text/html");
        resp.getWriter().print(pagesList.toString());
    }


}
