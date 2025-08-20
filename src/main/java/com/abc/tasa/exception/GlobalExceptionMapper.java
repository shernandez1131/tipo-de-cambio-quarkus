package com.abc.tasa.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException ex) {
        int status = 500;

        if (ex instanceof LimiteConsultasException) {
            status = 429; // Too Many Requests
        } else if (ex instanceof jakarta.ws.rs.BadRequestException) {
            status = 400;
        }

        return Response.status(status)
                .entity(Map.of(
                        "error", ex.getMessage(),
                        "status", status
                ))
                .build();
    }
}
