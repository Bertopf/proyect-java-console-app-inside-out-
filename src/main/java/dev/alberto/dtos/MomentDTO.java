package dev.alberto.dtos;

import dev.alberto.models.EmotionEnum;

public record MomentDTO(String title, String description, String date, EmotionEnum emotion) {
    // This record will automatically generate the constructor, getters, and toString method
    // for the fields title, description, date, and emotion.
    // No additional code is needed here.
    
    
}
