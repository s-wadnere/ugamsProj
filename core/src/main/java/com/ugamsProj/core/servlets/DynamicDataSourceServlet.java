package com.ugamsProj.core.servlets;
import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.commons.util.DamUtil;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.json.JSONArray;
import org.json.JSONException;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes=" + "/apps/ugamsProj/countrylist"
        }
)
public class DynamicDataSourceServlet extends SlingSafeMethodsServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceServlet.class);
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        LOGGER.info("inside get");
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource jsonResource = resourceResolver.getResource("/content/dam/ugamsproj/country.json");
        LOGGER.info("Inputstream========");
        Asset asset = DamUtil.resolveToAsset(jsonResource);
        Rendition originalAsset = Objects.requireNonNull(asset).getOriginal();
        InputStream content = Objects.requireNonNull(originalAsset).adaptTo(InputStream.class);
        LOGGER.info("Inputstream========");
        StringBuilder jsonContent = new StringBuilder();
        BufferedReader jsonReader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(content), StandardCharsets.UTF_8));
        String line;
        while ((line = jsonReader.readLine()) != null) {
            jsonContent.append(line);
        }
        LOGGER.info("jsoncontent===============");
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonContent.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Map<String, String> data = new TreeMap<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                data.put(jsonArray.getJSONObject(i).getString("text"),
                        jsonArray.getJSONObject(i).getString("value"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @SuppressWarnings({"unchecked", "rawtypes"})
        DataSource ds = new SimpleDataSource(new TransformIterator<>(data.keySet().iterator(), (Transformer) o -> {
            String dropValue = (String) o;
            ValueMap vm = new ValueMapDecorator(new HashMap<>());
            vm.put("text", dropValue);
            vm.put("value", data.get(dropValue));
            return new ValueMapResource(resourceResolver, new ResourceMetadata(), JcrConstants.NT_UNSTRUCTURED, vm);
        }));
        request.setAttribute(DataSource.class.getName(), ds);
    }

}