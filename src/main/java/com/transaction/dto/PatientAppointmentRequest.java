package com.transaction.dto;

import com.transaction.entity.Appointment;
import com.transaction.entity.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentRequest {

	private Patient patient;
	private Appointment appointment;
}
