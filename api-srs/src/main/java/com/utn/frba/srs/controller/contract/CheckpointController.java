package com.utn.frba.srs.controller.contract;

import com.utn.frba.srs.exception.SRSException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/srs/checkpoint")
public interface CheckpointController {

	record CheckpointDto(
			String identificadorNFC,
			String latitud,String longitud,Long subsidiaryId
	) {
	}

	record CheckpointReduceDto(
			Long id,
			String identificadorNFC,
			String latitud,String longitud,Long subsidiaryId
	) {
	}

	@PostMapping
	void create(@RequestBody CheckpointDto request) throws SRSException;

	@PutMapping("/{checkpointId}")
	void update(@PathVariable("checkpointId") Long checkpointId, @RequestBody CheckpointController.CheckpointDto request) throws SRSException;


	@DeleteMapping("/{nfcIdentify}")
	void delete(@PathVariable("nfcIdentify") String nfcIdentify);

	@GetMapping("/findBySubsidiary/{subsidiaryId}")
	List<CheckpointController.CheckpointReduceDto> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId);
}
