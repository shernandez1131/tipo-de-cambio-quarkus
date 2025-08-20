package com.abc.tasa.repository;

import com.abc.tasa.model.ConsultaCambio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApplicationScoped
public class ConsultaCambioRepository implements PanacheRepository<ConsultaCambio> {

    public long contarConsultasHoy(String dni) {
        LocalDate hoy = LocalDate.now();
        LocalDateTime inicio = hoy.atStartOfDay();
        LocalDateTime fin = hoy.plusDays(1).atStartOfDay();

        return find("dni = ?1 and fechaConsulta between ?2 and ?3", dni, inicio, fin).count();
    }
}
