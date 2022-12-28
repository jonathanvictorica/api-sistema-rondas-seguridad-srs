package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/srs/user-security")
interface UserSecurityController {



	record CredentialDto() {
	}

	record UsuarioReduceDto() {
	}


	@PatchMapping("/unlockUser/{userId}")
	void unlockUser(@PathVariable("userId") String userId);

	@PostMapping("/changePassword")
	void changePassword(@RequestBody UserSecurityController.CredentialDto request);

	@PostMapping("/validateCredential")
	UserSecurityController.UsuarioReduceDto validateCredential(@RequestBody UserSecurityController.CredentialDto request);


}
