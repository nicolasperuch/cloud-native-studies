package com.ilegra.jt.rxnetty;

import com.ilegra.jt.calculator.Calculator;
import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;

public class CalculatorResource {

    private Calculator calculator;

    public CalculatorResource(Calculator calculator) {
        this.calculator = calculator;
    }


    public double calculate(String[] uri){
        return calculator.doTheMath(uri[2],Double.parseDouble(uri[3]), Double.parseDouble(uri[4]));
    }

    public String[] treatUri(HttpServerRequest<ByteBuf> request){
        String[] uri = request.getUri().split("/");
        return uri;
    }

    public String history(){
        return calculator.getHistoricMap().getHistoricMap().toString();
    }

}
