package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.Hotel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {

    @EntityGraph(attributePaths = "empleados")
    @Query("select h from Hotel h")
    List<Hotel> findAllWithEmpleados();
}
