package dev.alberto.views;

import dev.alberto.controllers.MomentController;
import dev.alberto.models.Moment;
import dev.alberto.singletons.MomentControllerSingleton;

import java.util.List;

public class MomentFilterByGoodBadEmotionView extends View {
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {
        System.out.println("Seleccione el tipo de momento a filtrar:");
        System.out.println("1. Bueno");
        System.out.println("2. Malo");
        String choice = SCANNER.next();

        boolean filterGood;
        if (choice.equals("1")) {
            filterGood = true;
        } else if (choice.equals("2")) {
            filterGood = false;
        } else {
            System.out.println("Opción inválida.");
            HomeView.printMenu();
            return;
        }

        List<Moment> allMoments = CONTROLLER.getAllMoments(); 
        List<Moment> filtered = allMoments.stream()
                                          .filter(m -> m.isGood() == filterGood)
                                          .toList();

        if (filtered.isEmpty()) {
            System.out.println("No se encontraron momentos con el filtro seleccionado.");
        } else {
            System.out.println("Momentos encontrados:");
            filtered.forEach(System.out::println);
        }

        HomeView.printMenu();
    }
}
