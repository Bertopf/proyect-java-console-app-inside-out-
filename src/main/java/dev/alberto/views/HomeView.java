package dev.alberto.views;

import dev.alberto.controllers.MomentController;

public class HomeView extends View {

    static final MomentController momentController = new MomentController();
    

    public static void printMenu() {
        String text = """
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Salir
                Seleccione una opción: """;
        System.out.print(text);
        int option = SCANNER.nextInt();
        if (option == 1) {
                MomentPostView.printStoreMenu();
            }

        if (option == 2) {
            momentController.ShowAllMoments();
            
            
        }

        if (option == 3) {
            MomentDeleteView.printDeleteMenu();
        }
    }

    
    
}
