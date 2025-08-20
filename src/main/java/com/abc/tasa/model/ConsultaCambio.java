package com.abc.tasa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class ConsultaCambio extends PanacheEntity {
    public String dni;
    public LocalDateTime fechaConsulta;
}
