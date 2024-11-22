package gestion_des_patients;

import gestion_des_patients.entities.Patient;
import gestion_des_patients.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class GestionDesPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesPatientsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date(), false, 40));
            patientRepository.save(new Patient(null, "Mohamed", new Date(), true, 35));
            patientRepository.save(new Patient(null, "Ali", new Date(), true, 100));
            patientRepository.save(new Patient(null, "Fatima", new Date(), false, 60));

            patientRepository.findAll().forEach(System.out::println);
        };
    }
    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
}



