package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.CheckpointController;
import com.utn.frba.srs.model.Checkpoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CheckpointMapper {



    @Mappings({
            @Mapping(source="latitude", target="ubiety.latitude"),
            @Mapping(source="longitude", target="ubiety.longitude"),
            @Mapping(source="subsidiaryId", target="subsidiary.id")
    })
    Checkpoint toCheckpoint(CheckpointController.CheckpointDto entity);


    @Mappings({
            @Mapping(target="latitude", source= "ubiety.latitude"),
            @Mapping(target="longitude", source= "ubiety.longitude"),
            @Mapping(target="subsidiaryId", source= "subsidiary.id")
    })
    CheckpointController.CheckpointReduceDto toCheckpointReduceDto(Checkpoint entity) ;
}
