package com.callegas.resources;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;


public class TruckResourceTest {

    HttpUriRequest request = new HttpGet( "http://localhost:8080/toll/truck/10/20" );
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

    public TruckResourceTest() throws IOException {
    }

    @Test
    public void whenAccessTollWithTruck_then200IsReceived() {
        Assert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void whenAccessTollWithTruckWithoutPayment_then404IsReceived() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/toll/truck/10" );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void whenRequestTruckIsExecuted_thenDefaultResponseContentTypeIsText(){
        String textMimeType = "text/plain";
        String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
        Assert.assertEquals( textMimeType , mimeType );
    }

}
