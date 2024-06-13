package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {

    @Test
    void addCar() {

        // Given
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        // When
        boolean result1 = parkingSystem.addCar(1);
        boolean result2 = parkingSystem.addCar(2);
        boolean result3 = parkingSystem.addCar(3);
        boolean result4 = parkingSystem.addCar(1);

        // Then
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
    }
}