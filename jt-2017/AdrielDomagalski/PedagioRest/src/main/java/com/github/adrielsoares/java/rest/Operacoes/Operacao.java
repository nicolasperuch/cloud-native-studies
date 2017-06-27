package com.github.adrielsoares.java.rest.Operacoes;
import com.github.adrielsoares.java.rest.Veiculos.*;
import org.springframework.stereotype.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;


/**
 * Created by adriel on 06/06/17.
 */

@Service
@ApplicationPath("/toll")
public class Operacao extends Application implements Pedagio {
    Response.ResponseBuilder response;
    private Bicicleta bicicleta;
    private Onibus onibus;
    private Carro carro;
    private Moto moto;
    private Caminhao caminhao;

    public Operacao(Carro carro, Bicicleta bike, Caminhao caminhao, Moto moto, Onibus onibus) {
        this.bicicleta = bike;
        this.carro = carro;
        this.caminhao = caminhao;
        this.moto = moto;
        this.onibus = onibus;
    }

    @GET
    @Path("/carro")
    @Produces("text/plain")
    @Override
    public Response pagamentoCarro() {
        try {
            response = Response.ok(carro.printCarro());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @GET
    @Path("/carro/pagamento/{valor}")
    @Produces("text/plain")
    @Override
    public Response pagamentoCarro(@PathParam("valor") double valor) {
        try {
            response = Response.ok(carro.validaPagamentoCarro(valor));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/onibus")
    @Produces("text/plain")
    @Override
    public Response pagamentoOnibus() {
        try {
            response = Response.ok(onibus.printOnibus());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @GET
    @Path("/onibus/pagamento/{valor}")
    @Produces("text/plain")
    @Override
    public Response pagamentoOnibus(@PathParam("valor") double valor) {
        try {
            response = Response.ok(onibus.validaPagamentoOnibus(valor));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/bicicleta")
    @Produces("text/plain")
    @Override
    public Response pagamentoBicicleta() {
        try {
            response = Response.ok(bicicleta.printBike());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/bicicleta/pagamento/{valor}")
    @Produces("text/plain")
    @Override
    public Response pagamentoBicicleta(@PathParam("valor") double valor) {
        try {
            response = Response.ok(bicicleta.validaPagamentoBike(valor));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/moto")
    @Produces("text/plain")
    @Override
    public Response PagamentoMoto() {
        try {
            response = Response.ok(moto.printMoto());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/moto/pagamento/{valor}")
    @Produces("text/plain")
    @Override
    public Response PagamentoMoto(@PathParam("valor") double valor) {
        try {
            response = Response.ok(moto.validaPagamentoMoto(valor));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/caminhao/{valor}")
    @Produces("text/plain")
    @Override
    public Response PagamentoCaminhao(@PathParam("valor") int eixoAdicional) {
        try {
            response = Response.ok(caminhao.printCaminhao(eixoAdicional));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


    @GET
    @Path("/caminhao/{eixo}/pagamento/{valor}")
    @Produces("text/plain")
    @Override
    public Response PagamentoCaminhao(@PathParam("eixo") int eixoAdicional, @PathParam("valor") double valor) {
        try {
            response = Response.ok(caminhao.validaPagamentoCaminhao(eixoAdicional, valor));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }


}
