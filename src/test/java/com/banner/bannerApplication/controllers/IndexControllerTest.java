package com.banner.bannerApplication.controllers;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IndexControllerTest {

    @Test
    public void index() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void select() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/select?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void schoolInformation() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/school-information");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void buildings() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/buildings");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }
}
