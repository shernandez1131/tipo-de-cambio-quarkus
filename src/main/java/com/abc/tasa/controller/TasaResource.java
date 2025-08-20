package com.abc.tasa.controller;

import com.abc.tasa.client.TipoCambioResponse;
import com.abc.tasa.service.TipoCambioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/tipo-cambio")
@Produces(MediaType.APPLICATION_JSON)
public class TasaResource {

    @Inject
    TipoCambioService service;

    @GET
    public TipoCambioResponse consultar(@QueryParam("dni") String dni) {
        if (dni == null || dni.isBlank()) {
            throw new BadRequestException("El campo dni es obligatorio.");
        }
        return service.consultar(dni);
    }
}

