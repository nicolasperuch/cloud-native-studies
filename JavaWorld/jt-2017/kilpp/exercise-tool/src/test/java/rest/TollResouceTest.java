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
public class TollResouceTest {

    @Autowired
    private TollResource tollResource;

    @Test
    public void validatePaymentTest(){
        Assert.assertEquals("PAGO!TROCO: 2.0", tollResource.validatePayment(3,1));
        Assert.assertEquals("DINHEIRO INSUFICIENTE! CLIENTE DEVE: 2.0", tollResource.validatePayment(1,3));
    }

    @Test
    public void tollPageOkTest() throws IOException{
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
