package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/srs/round-execute")
interface RoundExecuteCommandController {

	record StartRoundDto(){

	}

	record MarkCheckpointDto(){

	}

	record FinishRoundDto(){

	}

	record NotifyLocationAgentOnlineDto(){

	}

	Long startRound(RoundExecuteCommandController.StartRoundDto request);

	void markCheckpoint(RoundExecuteCommandController.MarkCheckpointDto request);

	void finishRound(RoundExecuteCommandController.FinishRoundDto request);

	void finishRoundBySupervisor(RoundExecuteCommandController.FinishRoundDto request);

	void notifyLocationAgentOnline(RoundExecuteCommandController.NotifyLocationAgentOnlineDto request);




}
