package dev.alberto.dtos;

import dev.alberto.models.EmotionEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MomentDTOTest {

    @Test
    void testCreationAndGetters() {
        LocalDate date = LocalDate.of(2025, 8, 14);
        MomentDTO dto = new MomentDTO("Título", "Descripción", date, EmotionEnum.ALEGRIA);

        assertEquals("Título", dto.title());
        assertEquals("Descripción", dto.description());
        assertEquals(date, dto.date());
        assertEquals(EmotionEnum.ALEGRIA, dto.emotion());
    }

    @Test
    void testEquality() {
        LocalDate date = LocalDate.of(2025, 8, 14);
        MomentDTO dto1 = new MomentDTO("Título", "Descripción", date, EmotionEnum.ALEGRIA);
        MomentDTO dto2 = new MomentDTO("Título", "Descripción", date, EmotionEnum.ALEGRIA);
        MomentDTO dto3 = new MomentDTO("Otro", "Descripción", date, EmotionEnum.ALEGRIA);

       
        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    @Test
    void testToString() {
        LocalDate date = LocalDate.of(2025, 8, 14);
        MomentDTO dto = new MomentDTO("Título", "Descripción", date, EmotionEnum.ALEGRIA);

        String expected = "MomentDTO[title=Título, description=Descripción, date=2025-08-14, emotion=ALEGRIA]";
        assertEquals(expected, dto.toString());
    }
}
