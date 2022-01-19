package com.ugamsProj.core.utils;

import com.ugamsProj.core.models.Impl.UserSingleImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UserApi {



    public static String readData(String url) {
        final Logger log = LoggerFactory.getLogger(UserApi.class);
        try {
            URL url1 = new URL(url);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url1.openConnection();
            httpsURLConnection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            String data;
            StringBuffer buffer = new StringBuffer();
            while((data = reader.readLine()) != null){
                buffer.append(data);
            }
            reader.close();
            return buffer.toString();


        } catch (Exception e) {
            e.getStackTrace();
        }
        return  null;
    }
}
