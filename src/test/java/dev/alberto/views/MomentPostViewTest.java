package dev.alberto.views;

import dev.alberto.controllers.MomentController;
import dev.alberto.models.EmotionEnum;
import dev.alberto.models.Moment;
import dev.alberto.singletons.MomentControllerSingleton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HomeViewTest {

    private MomentController controller;

    @BeforeEach
    void setUp() {
        controller = MomentControllerSingleton.getInstance();
        controller.getAllMoments().clear(); // Limpiar momentos antes de cada test

        // Añadimos un momento de prueba usando record
        controller.getAllMoments().add(new Moment(
                "Momento de prueba",
                LocalDate.now(),
                "Descripción de prueba",
                
                EmotionEnum.ALEGRIA
        ));
    }

    @Test
    void testVerMomentosYSalir() {
        // Simular: opción 2 (ver momentos), opción 5 (salir)
        String simulatedInput = "2\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> HomeView.printMenu());
    }

    @Test
    void testEliminarMomento() {
        // Simular: opción 3 (eliminar), elegir momento 1, opción 5 (salir)
        String simulatedInput = "3\n1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> HomeView.printMenu());

        // Verificamos que se eliminó correctamente usando record syntax
        assertTrue(controller.getAllMoments().isEmpty(), "El momento debería haberse eliminado");
    }

    @Test
    void testAgregarMomento() {
        // Simular: opción 1 (agregar), título, fecha, descripción, emoción, opción 5 (salir)
        String simulatedInput = "1\nNuevoMomento\n14/08/2025\nNuevaDescripcion\n1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> HomeView.printMenu());

        // Verificamos que se agregó el momento
        assertEquals(2, controller.getAllMoments().size());
        assertEquals("NuevoMomento", controller.getAllMoments().get(1).getTitle());
        assertEquals("NuevaDescripcion", controller.getAllMoments().get(1).getDescription());
        assertEquals(EmotionEnum.ALEGRIA, controller.getAllMoments().get(1).getDescription());
    }

    
}
