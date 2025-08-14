package dev.alberto.views;

import dev.alberto.controllers.MomentController;
import dev.alberto.models.EmotionEnum;
import dev.alberto.singletons.MomentControllerSingleton;



public class MomentsFilterByEmotionView extends View {
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    public static void printFilterMenu() {
        System.out.println("Seleccione la emoción para filtrar:");
        for (EmotionEnum e : EmotionEnum.values()) {
            System.out.println((e.ordinal() + 1) + ". " + e.getDisplayName());
        }
        int choice = SCANNER.nextInt();
        if (choice < 1 || choice > EmotionEnum.values().length) {
            System.out.println("Opción inválida.");
            HomeView.printMenu();
            return;
        }
        EmotionEnum selectedEmotion = EmotionEnum.values()[choice - 1];
        CONTROLLER.showMomentsByEmotion(selectedEmotion);
        HomeView.printMenu();
    }
    
}
