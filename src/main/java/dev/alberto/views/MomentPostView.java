package dev.alberto.views;

import java.util.Scanner;
import dev.alberto.dtos.MomentDTO;
import dev.alberto.controllers.MomentController;
import dev.alberto.views.HomeView;
import dev.alberto.models.EmotionEnum;
import dev.alberto.singletons.MomentControllerSingleton;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class MomentPostView extends View {
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String title = SCANNER.next();

        LocalDate date = null;
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (date == null) {
            System.out.println("Ingrese la fecha (dd/MM/yyyy):");
            String dateInput = SCANNER.next();
            try {
                date = LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido, intenta de nuevo.");
            }
        }

        System.out.println("Ingrese la descripción:");
        String description = SCANNER.next();

        System.out.println("Seleccione la emoción:");
        for (EmotionEnum e : EmotionEnum.values()) {
            System.out.println((e.ordinal() + 1) + ". " + e.getDisplayName());
        }
        int emotionChoice = SCANNER.nextInt();
        EmotionEnum emotion = EmotionEnum.values()[emotionChoice - 1];

        // NUEVO: preguntar si el momento es bueno o malo
        System.out.println("¿El momento es bueno o malo?");
        System.out.println("1. Bueno");
        System.out.println("2. Malo");
        boolean isGood;
        int goodBadChoice = SCANNER.nextInt();
        if (goodBadChoice == 1) {
            isGood = true;
        } else if (goodBadChoice == 2) {
            isGood = false;
        } else {
            System.out.println("Opción inválida, se considerará momento bueno por defecto.");
            isGood = true;
        }

        MomentDTO momentDTO = new MomentDTO(title, description, date, emotion, isGood);
        CONTROLLER.StoreMoment(momentDTO);

        HomeView.printMenu();
    }
}
