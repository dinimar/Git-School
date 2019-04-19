package ru.kpfu.itis.gitschool.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIHelper {
    public static String myGetRequest(String url) throws IOException {
        URL urlForGetRequest = new URL(url);

        String readLine = null;

        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

        conection.setRequestMethod("GET");

        int responseCode = conection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader in = new BufferedReader(

                    new InputStreamReader(conection.getInputStream()));

            StringBuffer response = new StringBuffer();

            while ((readLine = in.readLine()) != null) {

                response.append(readLine);

            }
            in.close();

            // print result

            return response.toString();

            //GetAndPost.POSTRequest(response.toString());

        } else {
            return null;
        }
    }
}
