package com.abc.tasa.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/tipo-cambio")
@RegisterRestClient(configKey = "api-tipo-cambio")
public interface TipoCambioClient {
    @GET
    @Path("/today.json")
    TipoCambioResponse obtenerTipoCambio();
}
