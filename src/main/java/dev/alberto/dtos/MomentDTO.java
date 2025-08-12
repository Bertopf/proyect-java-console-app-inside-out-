package dev.alberto.dtos;

import java.time.LocalDate;

import dev.alberto.models.EmotionEnum;

public record MomentDTO(String title, String description, LocalDate date, EmotionEnum emotion) {
    
    
    
}
