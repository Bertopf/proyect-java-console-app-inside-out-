package dev.alberto.mappers;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.models.Moment;
import dev.alberto.models.EmotionEnum;

public class MomentMapper {
    public static Moment toEntity(MomentDTO dto) {
        Moment moment = new Moment(dto.title(), dto.description(), dto.date(), dto.emotion());
        return moment;
    }


}
