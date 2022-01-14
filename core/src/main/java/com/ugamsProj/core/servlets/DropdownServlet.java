package com.ugamsproj.core.servlets;

import com.adobe.cq.commerce.common.ValueMapDecorator;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.cq.wcm.api.Page;
import org.apache.commons.collections.iterators.TransformIterator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import com.adobe.granite.ui.components.ds.DataSource;
import com.day.cq.commons.jcr.JcrConstants;
import javax.servlet.Servlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes=" + "/apps/pages"
        })
public class DropdownServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        try {
            ResourceResolver resourceResolver = request.getResourceResolver();
            List<KeyValue> dropDownList = new ArrayList<>();
            Resource pathResource = resourceResolver.getResource("/content/ugamsproj/us/en");
            if(pathResource != null) {
                Page page = pathResource.adaptTo(Page.class);
                if (page != null) {
                    Iterator<Page> iterator = page.listChildren();
                    List<Page> pages = new ArrayList<>();
                    iterator.forEachRemaining(pages::add);
                    pages.forEach(pagechild -> {
                        String name = pagechild.getName();
                        String title = pagechild.getTitle();
                        dropDownList.add(new KeyValue(name, title));
                    });
                    @SuppressWarnings("unchecked")
                    DataSource ds =
                            new SimpleDataSource(
                                    new TransformIterator(
                                            dropDownList.iterator(),
                                            input -> {
                                                KeyValue keyValue = (KeyValue) input;
                                                ValueMap vm = new ValueMapDecorator(new HashMap<>());
                                                vm.put("value", keyValue.key);
                                                vm.put("text", keyValue.value);
                                                return new ValueMapResource(
                                                        resourceResolver, new ResourceMetadata(),
                                                        JcrConstants.NT_UNSTRUCTURED, vm);
                                            }));
                    request.setAttribute(DataSource.class.getName(), ds);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private class KeyValue {

        private String key;
        private String value;
        private KeyValue(final String newKey, final String newValue) {
            this.key = newKey;
            this.value = newValue;
        }
    }
}
