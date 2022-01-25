package com.ugamsProj.core.models.Impl;

import com.ugamsProj.core.models.UserMulti;
import com.ugamsProj.core.services.UserApiConfigService;
import com.ugamsProj.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.io.IOException;
import java.util.*;
@Model(adaptables = Resource.class,
        adapters = UserMulti.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserMultiImpl implements UserMulti {
    final Logger log = LoggerFactory.getLogger(UserMultiImpl.class);
    @Inject
    String pageNo;

    @OSGiService
    UserApiConfigService userApiConfigService;

    @Override
    public List<Map<String, String>> getData() throws JSONException, IOException {

        String response = Network.readJson(getUrl());
        JSONObject jsonObject =  new JSONObject(response);
        log.info("=====take response");
        JSONArray jsonArray1 = jsonObject.getJSONArray("data");
        log.info("===============jsonArray1");
        List<Map<String, String>> userList = new ArrayList<>();
        for (int i=0;i<jsonArray1.length();i++){
            Map<String,String> user =new HashMap<>();
            user.put("fname",jsonArray1.getJSONObject(i).getString("first_name"));
            user.put("lname",jsonArray1.getJSONObject(i).getString("last_name"));
            user.put("email",jsonArray1.getJSONObject(i).getString("email"));
            user.put("avatar",jsonArray1.getJSONObject(i).getString("avatar"));
            userList.add(user);
        }
        log.info("===userList===");
        return userList;
    }

    @Override
    public String getUrl() {
        return userApiConfigService.getMultiUserApi()+pageNo;
    }
}
