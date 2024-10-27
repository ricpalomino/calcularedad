package com.idat.calcularedad.endpoint;

import java.time.LocalDate;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soap.CalcularEdadRequest;
import com.example.soap.CalcularEdadResponse;

@Endpoint
public class CalcularEdadEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalcularEdadRequest")
    @ResponsePayload
    public CalcularEdadResponse calcularEdad(@RequestPayload CalcularEdadRequest request) {
        CalcularEdadResponse response = new CalcularEdadResponse();
        int edad = LocalDate.now().getYear() - request.getAnioNacimiento();
        response.setEdad(edad);
        return response;
    }
}
