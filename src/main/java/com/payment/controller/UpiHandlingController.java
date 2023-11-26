package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payment.entity.UPI;
import com.payment.services.IUpiServices;

@RestController
@RequestMapping("upi-handling-controller")
public class UpiHandlingController {

	@Autowired
	private IUpiServices upiServices;

	@PostMapping("save-upi")
	public ResponseEntity<String> saveUpi(@RequestBody UPI upi) throws Exception {

		try {
			upiServices.addUpi(upi);
			return ResponseEntity.status(HttpStatus.OK).body("Upi added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
		}
	}
}
