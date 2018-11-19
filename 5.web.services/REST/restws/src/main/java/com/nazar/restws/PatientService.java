package com.nazar.restws;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.GET;

import com.nazar.restws.model.Patient;

@Path("/patientservice")
public interface PatientService {
	
	@GET
	@Path("/patients")
	List<Patient> getPatients();

}
