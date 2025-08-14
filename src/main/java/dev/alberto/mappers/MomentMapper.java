package dev.alberto.mappers;

import dev.alberto.dtos.MomentDTO;
import dev.alberto.models.Moment;


public class MomentMapper {
    public static Moment toEntity(MomentDTO dto) {
        Moment moment = new Moment(dto.title(),dto.date(), dto.description(), dto.emotion());
        return moment;
    }


}
