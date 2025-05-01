package ma.emsi.hospitalapp;

import ma.emsi.hospitalapp.entities.Patient;
import ma.emsi.hospitalapp.repository.Patientrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(Patientrepository patientrepository) {
        return args -> {
            Patient p1=Patient.builder()
                    .nom("Salma")
                    .dateNaissance(new Date())
                    .malade(false)
                    .build();
            patientrepository.save(p1);
            Patient p2=Patient.builder()
                    .nom("Salma")
                    .dateNaissance(new Date())
                    .malade(false)
                    .build();
            patientrepository.save(p2);
            Patient p3=Patient.builder()
                    .nom("Salma")
                    .dateNaissance(new Date())
                    .malade(false)
                    .build();

            patientrepository.save(p3);

            List<Patient> patients=patientrepository.findAll();
            patients.forEach(p->System.out.println(p.toString()));

        };
    }
}

