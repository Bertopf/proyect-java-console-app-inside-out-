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

public class MomentsFilterByEmotionViewTest {

    private MomentController controller;

    @BeforeEach
    void setUp() {
       
        controller = MomentControllerSingleton.getInstance();
        controller.getAllMoments().clear();

        controller.getAllMoments().add(new Moment(
                "Momento Alegría",
                LocalDate.now(),
                "Descripción 1",
                EmotionEnum.ALEGRIA,
                true
        ));
        controller.getAllMoments().add(new Moment(
                "Momento Tristeza",
                LocalDate.now(),
                "Descripción 2",
                EmotionEnum.TRISTEZA,
                true
        ));
    }

    @Test
    void testFiltrarPorAlegria() {
       
        String simulatedInput = "1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        
        assertDoesNotThrow(() -> MomentsFilterByEmotionView.printFilterMenu());
    }

    
    }

