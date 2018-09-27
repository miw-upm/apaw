package es.upm.miw.pd.vehicle.solution;

import es.upm.miw.pd.decorator.vehicle.solution.*;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    @Test
    void testVehicleWithGpsMp3Eds() {
        Vehicle vehicle = new Model(1000, "MyCar");
        Vehicle vehicle1 = new GPS(vehicle);
        Vehicle vehicle2 = new MP3(vehicle1);
        Vehicle vehicle3 = new EDS(vehicle2);
        assertEquals(1478, vehicle3.price());
        LogManager.getLogger().info(vehicle3.description());
    }
}
