package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, UUID> {
}
