package com.transaction.service;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.dto.PatientAppointmentRequest;
import com.transaction.entity.Appointment;
import com.transaction.entity.Patient;
import com.transaction.repository.AppointmentRepository;
import com.transaction.repository.PatientRepository;
import com.transaction.util.PromocodeValidator;

@Service
public class ProctoService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	

	//@Transactional(rollbackFor = {IllegalArgumentException.class,NullPointerException.class})
	//@Transactional(noRollbackFor = {RuntimeException.class})
	//@Transactional
	public String bookAppointment(PatientAppointmentRequest request) {
		
		// Save Patient
		Patient patient = request.getPatient();
		long patientId = patientRepository.save(patient).getPatientId();
		
		Appointment appointment = request.getAppointment();
		if(appointment.getPromoCode()!=null) {
			PromocodeValidator.ValidatePromoCode(appointment.getPromoCode());
		}
		appointment.setPatientId(patientId);
		String appointmentId = appointmentRepository.save(appointment).getAppointmentId();
		
		return "Hi "+ patient.getName() + " Your appointment booked successfully & appointment number is: " + appointmentId;
	}
}
