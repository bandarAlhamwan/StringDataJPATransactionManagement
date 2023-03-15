package com.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dto.PatientAppointmentRequest;
import com.transaction.service.ProctoService;

@RestController
public class ProctoController {

	@Autowired
	private ProctoService proctoService;
	
	@PostMapping("bookAppointment")
	public String bookDoctorAppointment(@RequestBody PatientAppointmentRequest request) {
		return proctoService.bookAppointment(request);
	}
}
