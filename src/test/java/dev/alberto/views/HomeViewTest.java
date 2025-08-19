package dev.alberto.views;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.models.EmotionEnum;
import dev.alberto.singletons.MomentControllerSingleton;
import dev.alberto.views.HomeView;
import dev.alberto.controllers.MomentController;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final MomentController controller = MomentControllerSingleton.getInstance();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        controller.getAllMoments().clear(); 
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testShowAllMomentsOption() {
        
        controller.StoreMoment(new MomentDTO(
                "Momento de prueba",
                "Descripción",
                LocalDate.now(),
                EmotionEnum.ALEGRIA,
                true
        ));

       
        String simulatedInput = "2\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        HomeView.printMenu();

        String output = outputStream.toString();
        assertTrue(output.contains("Momento de prueba"));
    }

    @Test
    void testDeleteMomentOption() {
        
        controller.StoreMoment(new MomentDTO(
                "Momento a eliminar",
                "Descripción",
                LocalDate.now(),
                EmotionEnum.ALEGRIA,
                true    
        ));

        String simulatedInput = "3\n1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        HomeView.printMenu();

        String output = outputStream.toString();
        assertTrue(output.contains("Momento eliminado correctamente."));
    }
}
