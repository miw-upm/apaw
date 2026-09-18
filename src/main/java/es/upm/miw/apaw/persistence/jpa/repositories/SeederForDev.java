package es.upm.miw.apaw.persistence.jpa.repositories;

import es.upm.miw.apaw.persistence.jpa.entities.Empleado;
import es.upm.miw.apaw.persistence.jpa.entities.Equipamiento;
import es.upm.miw.apaw.persistence.jpa.entities.Habitacion;
import es.upm.miw.apaw.persistence.jpa.entities.Hotel;
import es.upm.miw.apaw.persistence.jpa.entities.PlazaAparcamiento;
import es.upm.miw.apaw.persistence.jpa.entities.Recepcion;
import es.upm.miw.apaw.persistence.jpa.entities.TipoHabitacion;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Log4j2
@Component
@Profile({"dev", "test"})
@Order(1)
@RequiredArgsConstructor
public class SeederForDev implements ApplicationRunner {
    public static final String PREFIX = "aaaaaaaa-bbbb-cccc-dddd-eeeeffff";

    private final HotelRepository hotelRepository;
    private final HabitacionRepository habitacionRepository;
    private final EmpleadoRepository empleadoRepository;
    private final PlazaAparcamientoRepository plazaAparcamientoRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;
    private final EquipamientoRepository equipamientoRepository;

    @Override
    public void run(ApplicationArguments args) {
        this.deleteAll();
        this.seed();
    }

    private void deleteAll() {
        this.hotelRepository.deleteAll();
        this.habitacionRepository.deleteAll();
        this.empleadoRepository.deleteAll();
        this.plazaAparcamientoRepository.deleteAll();
        this.tipoHabitacionRepository.deleteAll();
        this.equipamientoRepository.deleteAll();
        log.warn("------- Deleted All -----------");
    }

    private void seed() {
        log.warn("------- Initial Load from JAVA -----------");
        List<String> tipos = List.of("Individual", "Doble", "Triple", "Familiar");
        List<String> equipos = List.of("Televisor", "Minibar", "Caja fuerte", "Aire acondicionado");
        List<String> nombres = List.of("Ana Garcia", "Luis Perez", "Marta Lopez", "Pablo Ruiz");
        List<String> documentos = List.of("00000000T", "00000001R", "00000002W", "00000003A");
        List<String> hoteles = List.of("Hotel Centro", "Hotel Sol", "Hotel Mar", "Hotel Sierra");
        List<String> direcciones = List.of("C/ Mayor, 1", "C/ Alcala, 2", "Paseo del Mar, 3", "C/ Sierra, 4");

        for (int i = 0; i < 4; i++) {
            TipoHabitacion tipo = this.tipoHabitacionRepository.save(TipoHabitacion.builder()
                    .id(id(1, i)).denominacion(tipos.get(i)).ocupacionMaxima(i + 1).build());
            Equipamiento equipo = this.equipamientoRepository.save(Equipamiento.builder()
                    .id(id(2, i)).denominacion(equipos.get(i)).requiereMantenimiento(i != 2).build());
            PlazaAparcamiento plaza = this.plazaAparcamientoRepository.save(PlazaAparcamiento.builder()
                    .id(id(3, i)).codigo("P-" + (i + 1)).nivel(-1).build());
            Empleado empleado = this.empleadoRepository.save(Empleado.builder()
                    .id(id(4, i)).dni(documentos.get(i)).nombre(nombres.get(i))
                    .fechaAlta(LocalDate.of(2025, i + 1, 1)).plazaAparcamiento(plaza).build());
            Habitacion habitacion = Habitacion.builder()
                    .id(id(5, i)).numero("10" + (i + 1)).planta(1)
                    .precioBase(new BigDecimal("60.00").add(new BigDecimal("20.00").multiply(BigDecimal.valueOf(i))))
                    .tipoHabitacion(tipo).equipamientos(new HashSet<>(Set.of(equipo))).build();
            this.hotelRepository.save(Hotel.builder()
                    .id(id(6, i)).nombre(hoteles.get(i)).categoria(i + 2).direccion(direcciones.get(i))
                    .recepcion(Recepcion.builder().horarioApertura(LocalTime.of(7, 0))
                            .numeroMostradores(i + 1).build())
                    .habitaciones(new ArrayList<>(List.of(habitacion)))
                    .empleados(new ArrayList<>(List.of(empleado))).build());
        }
        log.warn("------- Loaded 4 records per entity -----------");
    }

    private static UUID id(int entity, int index) {
        return UUID.fromString(PREFIX + String.format("%02d%02d", entity, index));
    }
}
