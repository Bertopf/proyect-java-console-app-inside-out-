package dev.alberto.views;

import java.util.Scanner;
import dev.alberto.dtos.MomentDTO;
import dev.alberto.controllers.MomentController;
import dev.alberto.views.HomeView;
import dev.alberto.models.EmotionEnum;
import dev.alberto.singletons.MomentControllerSingleton;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import dev.alberto.views.HomeView;


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
        MomentDTO momentDTO = new MomentDTO(title, description, date, emotion);
        CONTROLLER.StoreMoment(momentDTO);
        HomeView.printMenu();
    }
}