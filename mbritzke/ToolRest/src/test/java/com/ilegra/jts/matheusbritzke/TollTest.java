package com.ilegra.jts.matheusbritzke;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TollTest {

    @Test
    public void carPassedTheTollbooth() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/car/5");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void bicyclePassedTheTollbooth() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/bicycle/5");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void busPassedTheTollbooth() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/bus/5");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void motoPassedTheTollbooth() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/moto/5");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void truckPassedTheTollbooth() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/truck/0/5");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void axleTruckPassedTheTollbooth() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/truck/1/10");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void vehicleHasNotPassedTheToll() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/car/1");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void uriInvalid() throws IOException{
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/toll/tec");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }
}
