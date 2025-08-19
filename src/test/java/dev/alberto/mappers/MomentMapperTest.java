package dev.alberto.mappers;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.models.Moment;
import dev.alberto.models.EmotionEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MomentMapperTest {

    @Test
    void testToEntity() {
        LocalDate date = LocalDate.of(2025, 8, 14);
        MomentDTO dto = new MomentDTO("Mi título", "Mi descripción", date, EmotionEnum.ALEGRIA, true);

        Moment entity = MomentMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.title(), entity.getTitle());
        assertEquals(dto.description(), entity.getDescription());
        assertEquals(dto.date(), entity.getDate());
        assertEquals(dto.emotion(), entity.getEmotionEnum());
    }

    @Test
    void testToEntityWithAllEmotions() {
        LocalDate date = LocalDate.now();
        for (EmotionEnum emotion : EmotionEnum.values()) {
            MomentDTO dto = new MomentDTO("Título", "Descripción", date, emotion, true);
            Moment entity = MomentMapper.toEntity(dto);
            assertEquals(dto.emotion(), entity.getEmotionEnum());
        }
    }
}
