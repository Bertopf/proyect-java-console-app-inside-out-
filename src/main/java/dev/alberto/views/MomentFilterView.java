package dev.alberto.views;

public class MomentFilterView extends View {
    public static void printFilterMenu() {
        System.out.println("Filtrar por ...:");
        System.out.println("1. Emoción");
        System.out.println("2. Fecha");
        System.out.println("3. Bueno o malo");
        int choice = SCANNER.nextInt();
        if (choice == 1) {
            MomentsFilterByEmotionView.printFilterMenu();
        } else if (choice == 2) { 
            MomentFilterByDateView.printFilterMenu();

        } else if (choice == 3) {
            MomentFilterByGoodBadEmotionView.printFilterMenu();
        } else {
            System.out.println("Opción inválida. Intentelo de nuevo.");
            printFilterMenu();
        }
    }
}

