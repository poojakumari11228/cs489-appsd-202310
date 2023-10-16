package com.example;

import com.example.Service.AppointmentService;
import com.example.Service.DentistService;
import com.example.Service.Impl.AppointmentServiceImpl;
import com.example.Service.PatientService;
import com.example.entity.Address;
import com.example.entity.Appointments;
import com.example.entity.Dentist;
import com.example.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdsApplication implements CommandLineRunner {

	 private final AppointmentService appointmentService;
	 private final DentistService dentistService;
	 private final PatientService patientService;
	AdsApplication(AppointmentService appointmentService, DentistService dentistService, PatientService patientService){
		this.appointmentService = appointmentService;
		this.dentistService = dentistService;
		this.patientService = patientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ADS - Spring Data JPA");


		List<Appointments> appointments = appointmentService.findByDentistName("John");

		Dentist dentist = new Dentist("Petter", "Kit", "", "testdentist@gmail.com", "Orthodontics" );

		dentistService.addDentist(dentist);

		var orthodontics = dentistService.findBySpecialization("Orthodontics");

		System.out.println(orthodontics.size());

		Patient patient = new Patient("Park", "John", "12313", "park.john@gmail.com", "ABC street MR # 3", new Address("1000 N 4th street", "Fairfield", "52557"));

		patientService.addPatient(patient);

		var park = patientService.findByEmail("park.john@gmail.com");

		System.out.println(park.getFirstName());

	}
}
