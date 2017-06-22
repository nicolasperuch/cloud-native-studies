package com.ilegra.jt.rxnetty;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {


    private final String healthCheckUri;
    private final HealthCheckEndpoint healthCheckEndpoint;
    private CalculatorResource calculatorResource;

    public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint, CalculatorResource calculatorResource) {
        this.healthCheckUri = healthCheckUri;
        this.healthCheckEndpoint = healthCheckEndpoint;
        this.calculatorResource = calculatorResource;

    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {

        if (request.getUri().contains("/math/")) {
            String[] uriTreated = calculatorResource.treatUri(request);
            return response.writeStringAndFlush(String.valueOf(calculatorResource.calculate(uriTreated)));
        }

        if (request.getUri().contains("/history/")){
            return response.writeStringAndFlush(calculatorResource.history());
        }

        return response.close();
    }




}