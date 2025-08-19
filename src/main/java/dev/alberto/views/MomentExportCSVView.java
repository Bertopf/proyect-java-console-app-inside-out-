package dev.alberto.views;

import dev.alberto.controllers.MomentController;
import dev.alberto.models.Moment;
import dev.alberto.singletons.MomentControllerSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MomentExportCSVView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void exportMomentsToCSV(String filename) {
        List<Moment> allMoments = CONTROLLER.getAllMoments();

        try (FileWriter writer = new FileWriter(filename)) {
            
            writer.append("Título,Fecha,Descripción,Emoción,EsBueno\n");

            
            for (Moment m : allMoments) {
                writer.append(escapeCsv(m.getTitle()))
                      .append(',')
                      .append(m.getDate().toString())
                      .append(',')
                      .append(escapeCsv(m.getDescription()))
                      .append(',')
                      .append(m.getEmotionEnum().getDisplayName())
                      .append(',')
                      .append(m.isGood() ? "Sí" : "No")
                      .append('\n');
            }

            System.out.println("Archivo CSV generado correctamente: " + filename);
        } catch (IOException e) {
            System.out.println("Error al generar el archivo CSV: " + e.getMessage());
        }
    }

   
    private static String escapeCsv(String input) {
        if (input.contains(",") || input.contains("\"")) {
            input = input.replace("\"", "\"\"");
            return "\"" + input + "\"";
        }
        return input;
    }
}
