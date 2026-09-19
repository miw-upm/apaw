package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.Hotel;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
class HotelRepositoryIT {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    void testFindAll() {
        List<Hotel> hoteles = this.hotelRepository.findAll();

        assertThat(hoteles).hasSizeGreaterThanOrEqualTo(4);
        hoteles.forEach(hotel -> log.info("Hotel: {}", hotel));
    }

    @Test  // 1+N CONSULTAS A BD
    @Transactional
    void testFindAllWithEmpleados() {
        List<Hotel> hoteles = this.hotelRepository.findAll();

        assertThat(hoteles).hasSizeGreaterThanOrEqualTo(4);
        hoteles.forEach(hotel -> {
            log.info("Hotel: {}", hotel);
            assertThat(hotel.getEmpleados()).hasSizeGreaterThanOrEqualTo(1);
            hotel.getEmpleados().forEach(empleado ->
                    log.info("Empleado de {}: {}", hotel.getNombre(), empleado));
        });
    }

    @Test  // 1 CONSULTA A BD
    void testFindAllWithEmpleadosEntityGraph() {
        List<Hotel> hoteles = this.hotelRepository.findAllWithEmpleados();

        assertThat(hoteles).hasSizeGreaterThanOrEqualTo(4);
        hoteles.forEach(hotel -> {
            log.info("Hotel: {}", hotel);
            hotel.getEmpleados().forEach(empleado ->
                    log.info("Empleado de {}: {}", hotel.getNombre(), empleado));
        });
        assertThat(hoteles.stream().flatMap(hotel -> hotel.getEmpleados().stream()).toList())
                .hasSizeGreaterThanOrEqualTo(4);
    }
}
