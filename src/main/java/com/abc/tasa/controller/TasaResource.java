package com.abc.tasa.controller;

import com.abc.tasa.client.TipoCambioResponse;
import com.abc.tasa.service.TipoCambioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/tipo-cambio")
@Produces(MediaType.APPLICATION_JSON)
public class TasaResource {

    @Inject
    TipoCambioService service;

    @Transactional
    @GET
    public TipoCambioResponse consultarTipoDeCambio(@QueryParam("dni") String dni) {
        if (dni == null || dni.isBlank()) {
            throw new BadRequestException("El campo dni es obligatorio.");
        }
        if (dni.length() != 8 || !dni.matches("\\d+")) {
            throw new BadRequestException("El campo dni debe contener exactamente 8 dígitos numéricos.");
        }
        return service.consultar(dni);
    }
}


