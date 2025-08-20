package com.abc.tasa.service;

import com.abc.tasa.client.TipoCambioClient;
import com.abc.tasa.client.TipoCambioResponse;
import com.abc.tasa.exception.LimiteConsultasException;
import com.abc.tasa.model.ConsultaCambio;
import com.abc.tasa.repository.ConsultaCambioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;

@ApplicationScoped
public class TipoCambioService {

    @Inject
    ConsultaCambioRepository repo;

    @Inject
    @RestClient
    TipoCambioClient client;

    public TipoCambioResponse consultar(String dni) {
        long consultas = repo.contarConsultasHoy(dni);

        if (consultas >= 10) {
            throw new LimiteConsultasException("Límite de 10 consultas por día alcanzado.");
        }

        TipoCambioResponse response = client.obtenerTipoCambio();

        ConsultaCambio c = new ConsultaCambio();
        c.dni = dni;
        c.fechaConsulta = LocalDateTime.now();
        repo.persist(c);

        return response;
    }
}
