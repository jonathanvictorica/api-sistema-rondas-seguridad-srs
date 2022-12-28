package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/srs/round-execute")
interface RoundExecuteQueryController {


	record RoundExecuteDto() {

	}

	record RoundExecuteReduceDto() {

	}

	@GetMapping("/findByStateRevision")
	List<RoundExecuteQueryController.RoundExecuteReduceDto> findByStateRevision();

	@GetMapping("/findOnlineById/{roundExecuteId}")
	RoundExecuteQueryController.RoundExecuteDto findOnlineById(@PathVariable Long roundExecuteId);


}
