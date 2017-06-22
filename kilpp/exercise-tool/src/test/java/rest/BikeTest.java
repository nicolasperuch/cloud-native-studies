package rest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BikeTest {

    @Test
    public void bikePageOkTest() throws IOException {
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/bike");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void bikePaymentOkTest() throws IOException{
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/bike/1");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void bikePaymentErrorTest() throws IOException{
        HttpUriRequest request = new HttpGet( "http://127.0.1.1:8080/rest/toll/bike/a");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }
}
