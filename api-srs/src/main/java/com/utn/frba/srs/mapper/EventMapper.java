package com.utn.frba.srs.mapper;

import com.utn.frba.srs.controller.RoundExecuteCommandController;
import com.utn.frba.srs.events.producer.RoundFinishEvent;
import com.utn.frba.srs.events.producer.RoundMarkCheckpointEvent;
import com.utn.frba.srs.events.producer.RoundNotifyUbicationAgentEvent;
import com.utn.frba.srs.events.producer.RoundStartEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    RoundStartEvent.Data toRoundStartEvent(RoundExecuteCommandController.StartRoundDto entity);

    RoundFinishEvent.Data toRoundFinishEvent(RoundExecuteCommandController.FinishRoundDto entity);

    RoundMarkCheckpointEvent.Data toRoundMarkCheckpointEvent(RoundExecuteCommandController.MarkCheckpointDto entity);

    RoundNotifyUbicationAgentEvent.Data toRoundNotifyUbicationAgentEvent(RoundExecuteCommandController.NotifyLocationAgentOnlineDto entity);
}
