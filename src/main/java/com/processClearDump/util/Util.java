package com.processClearDump.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;


@Service
public class Util  {
	
	public Boolean getResponseCODE(String urlString) throws IOException {
        URL u = new URL(urlString);
        int CODEResponse = 0;
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        CODEResponse = huc.getResponseCode();
        if (CODEResponse != 200) {
            return false;
        } else {
            return true;
        }
    }
	
}