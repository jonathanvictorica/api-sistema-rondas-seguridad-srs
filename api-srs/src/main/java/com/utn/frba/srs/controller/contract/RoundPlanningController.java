package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/srs/round-planning")
interface RoundPlanningController {

	record RoundPlanningDto() {
	}

	record RoundPlanningReduceDto() {
	}

	@PostMapping
	Long create(@RequestBody RoundPlanningController.RoundPlanningDto request);

	@PutMapping("/{roundPlanningId}")
	void update(@PathVariable("roundPlanningId") Long roundPlanningId, @RequestBody RoundPlanningController.RoundPlanningDto request);

	@DeleteMapping("/{roundPlanningId}")
	void delete(@PathVariable("roundPlanningId") Long roundPlanningId);

	@GetMapping("/findById/{roundPlanningId}")
	RoundPlanningController.RoundPlanningReduceDto findById(@PathVariable("roundPlanningId") Long roundPlanningId);

	@GetMapping("/findByRoundId/{roundId}")
	List<RoundPlanningController.RoundPlanningReduceDto> findByRoundId(@PathVariable("roundId") Long roundId);


}
