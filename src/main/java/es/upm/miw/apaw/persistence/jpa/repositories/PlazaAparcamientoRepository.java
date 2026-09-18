package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.PlazaAparcamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlazaAparcamientoRepository extends JpaRepository<PlazaAparcamiento, UUID> {
}
