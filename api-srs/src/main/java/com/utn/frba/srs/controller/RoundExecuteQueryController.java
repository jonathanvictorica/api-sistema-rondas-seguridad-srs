package com.utn.frba.srs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/srs/round-execute")
@RestController
public class RoundExecuteQueryController {


	public record RoundExecuteDto() {

	}

	public record RoundExecuteReduceDto() {

	}

	@GetMapping("/findByStateRevision")
	List<RoundExecuteQueryController.RoundExecuteReduceDto> findByStateRevision(){
		return null;
	}

	@GetMapping("/findOnlineById/{roundExecuteId}")
	RoundExecuteQueryController.RoundExecuteDto findOnlineById(@PathVariable Long roundExecuteId){
		return null;
	}


}
