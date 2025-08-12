package dev.alberto.views;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.controllers.MomentController;
import dev.alberto.views.HomeView;


public class MomentPostView extends View {

    private static MomentController CONTROLLER = HomeView.momentController;

    public static void printStoreMenu() {
        System.out.println("Ingrese el titulo:");
        String title = SCANNER.next();

        System.out.println("Ingrese la descripción:");
        String description = SCANNER.next();

        System.out.println("Ingrese la fecha (YYYY-MM-DD):");
        String date = SCANNER.next();

        MomentDTO momentDTO = new MomentDTO(title, description, date);
        CONTROLLER.StoreMoment(momentDTO);

        HomeView.printMenu();

    }

    
}
