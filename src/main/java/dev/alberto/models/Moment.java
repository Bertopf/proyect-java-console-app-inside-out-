package dev.alberto.models;

public class Moment {
    private String title;
    private String description;
    private String date;
    private EmotionEnum emotion;

    public Moment(String title, String description, String date, EmotionEnum emotion) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.emotion = emotion;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public EmotionEnum getEmotionEnum() {
        return emotion;
    }

    @Override
    public String toString() {
        return "Título: " + title + "\n" +
               "Fecha: " + date + "\n" +
               "Descripción: " + description + "\n" +
               "Emoción: " + emotion.getDisplayName() + "\n";
    }


}
