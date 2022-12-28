package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/srs/checkpoint")
public interface CheckpointController {

	record CheckpointDto() {
	}

	record CheckpointReduceDto() {
	}

	@PostMapping
	Long create(@RequestBody CheckpointController.CheckpointDto request);

	@PutMapping("/{checkpointId}")
	void update(@PathVariable("checkpointId") Long checkpointId, @RequestBody CheckpointController.CheckpointDto request);

	@DeleteMapping("/{checkpointId}")
	void delete(@PathVariable("checkpointId") Long checkpointId);

	@GetMapping("/findBySubsidiary/{subsidiaryId}")
	List<CheckpointController.CheckpointReduceDto> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId);
}
