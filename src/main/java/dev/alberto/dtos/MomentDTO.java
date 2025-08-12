package dev.alberto.dtos;

import dev.alberto.models.EmotionEnum;

public record MomentDTO(String title, String description, String date, EmotionEnum emotion) {
    
    
    
}
