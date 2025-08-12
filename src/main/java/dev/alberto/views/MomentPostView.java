package dev.alberto.views;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.controllers.MomentController;
import dev.alberto.views.HomeView;
import dev.alberto.models.EmotionEnum;


public class MomentPostView extends View {
    private static MomentController CONTROLLER = HomeView.momentController;
    public static void printStoreMenu() {

        System.out.println("Ingrese el título:");
        String title = SCANNER.next();

        System.out.println("Ingrese la fecha: (dd/mm/aaaa)");
        String date = SCANNER.next();

        System.out.println("Ingrese la descripción:");
        String description = SCANNER.next();

        System.out.println("Seleccione la emoción:");
        for (EmotionEnum e : EmotionEnum.values()) {
            System.out.println((e.ordinal() + 1) + ". " + e.getDisplayName());
        }
        int emotionChoice = SCANNER.nextInt();
        EmotionEnum emotion = EmotionEnum.values()[emotionChoice - 1];
        
        MomentDTO momentDTO = new MomentDTO(title, date, description, emotion);
        CONTROLLER.StoreMoment(momentDTO);
        HomeView.printMenu();
    }
}