package rest;


import configuration.AppConfig;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TruckTest {

    @Autowired
    private Truck truck;

    @Test
    public void truckPaymentMethodTest(){
        Assert.assertEquals(6.95,truck.getTotalValue(3), 0.001);
    }

    @Test
    public void truckPageOkTest() throws IOException {
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/truck");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void truckPaymentOkTest() throws IOException{
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/truck/1/1");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void truckPaymentErrorTestWithoutPay() throws IOException{
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/truck/a");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void truckPaymentErrorTestWithPay() throws IOException{
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/truck/1/a");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }
}
