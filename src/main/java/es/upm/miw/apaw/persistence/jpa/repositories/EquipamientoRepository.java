package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, UUID> {
}
