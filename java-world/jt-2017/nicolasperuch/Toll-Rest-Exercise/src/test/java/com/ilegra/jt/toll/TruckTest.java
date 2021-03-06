package com.ilegra.jt.toll;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TruckTest {

    @Test
    public void payTollPrintValueTest() throws ClientProtocolException, IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/rest/toll/truck/2");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void payTollPaymentNotEnoughTest() throws ClientProtocolException, IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/rest/toll/truck/2/-1");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void payTollPaymentEnoughTest() throws ClientProtocolException, IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/rest/toll/truck/2/100");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void payTollInvalidURITest() throws ClientProtocolException, IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/rest/truck/2/10");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }
    @Test
    public void payTollInvalidParamTest() throws ClientProtocolException, IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/rest/toll/truck/2/dez");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }


}
