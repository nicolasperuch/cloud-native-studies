import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;


import java.io.IOException;

/**
 * Created by adriel on 07/06/17.
 */
public class TestRest {
    HttpUriRequest request;
    HttpResponse response;

    @Test
    public void testePaginaBikeOK() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/bicicleta");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePagamentoBike() throws  IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/bicicleta/pagamento/1");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePaginaBikeErro() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/bicicleta/a");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testePaginaCaminhaoOK() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/caminhao/1");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePagamentoCaminhao() throws  IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/caminhao/2/pagamento/11");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePaginaCaminhaoErro() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/caminhao/a");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testePaginaCarroOK() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/carro");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePagamentoCarro() throws  IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/carro/pagamento/2");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePaginaCarroErro() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/carro/a");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testePaginaOnibusOk() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/onibus");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePagamentoOnibus() throws  IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/onibus/pagamento/5");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePaginaOnibusErro() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/onibus/a");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testePaginaMotoOk() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/moto");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePagamentoMoto() throws  IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/moto/pagamento/5");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void testePaginaMotoErro() throws IOException{
        request = new HttpGet("http://localhost:8080/rest/toll/moto/a");
        response = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }


}

