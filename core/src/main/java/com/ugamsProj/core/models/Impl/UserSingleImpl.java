package com.ugamsProj.core.models.Impl;
import com.ugamsProj.core.models.UserSingle;
import com.ugamsProj.core.services.UserApiConfigService;
import com.ugamsProj.core.utils.Network;
import com.ugamsProj.core.utils.UserApi;
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
import java.util.Iterator;
@Model(adaptables = Resource.class,
        adapters = UserSingle.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserSingleImpl implements UserSingle{
    final Logger log = LoggerFactory.getLogger(UserSingleImpl.class);

    @OSGiService
    UserApiConfigService userApiConfigService;

    @Inject
    String id;
    String fname;
    String lname;
    String email;
    String avatar;

    @Override
    public String getUrl(){
        return userApiConfigService.getSingleUserApi()+id;
    }


    @Override
    public String getMessage() throws IOException, JSONException {

        //String response = Network.readJson(getUrl());
        String response = UserApi.readData(getUrl());
        JSONObject jsonObject =  new JSONObject(response);
        log.info(String.valueOf(jsonObject));
        Iterator x = jsonObject.keys();
        JSONArray jsonArray = new JSONArray();
        while (x.hasNext()){
            String key = (String) x.next();
            jsonArray.put(jsonObject.get(key));
        }
        email = jsonArray.getJSONObject(0).getString("email");
        fname=jsonArray.getJSONObject(0).getString("first_name");
        lname=jsonArray.getJSONObject(0).getString("last_name");
        avatar=jsonArray.getJSONObject(0).getString("avatar");
        return response;
    }


    @Override
    public String getFname() {
        return fname;
    }

    @Override
    public String getLname() {
        return lname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAvatar() {
        //String path=avatar.replaceAll("https://reqres.in/img/faces/","/content/dam/ugamsproj/");
        String imgName = avatar.substring(28);
        String dam="/content/dam/ugamsproj/";
        return dam+imgName;
    }
}
