package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HabitacionRepository extends JpaRepository<Habitacion, UUID> {
}
