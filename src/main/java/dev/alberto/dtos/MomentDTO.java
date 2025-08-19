package dev.alberto.dtos;

import java.time.LocalDate;

import dev.alberto.models.EmotionEnum;

public record MomentDTO(String title, String description, LocalDate date, EmotionEnum emotion, boolean isGood) {

    public MomentDTO {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        if (date == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        if (emotion == null) {
            throw new IllegalArgumentException("La emoción no puede ser nula.");
        }
    }
    
    
    
}
