package dev.alberto.models;

import java.time.LocalDate;

public class Moment {
    private String title;
    private String description;
    private LocalDate date;
    private EmotionEnum emotion;

    public Moment(String title, String description, LocalDate date, EmotionEnum emotion) {
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

    public LocalDate getDate() {
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
