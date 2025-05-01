package ma.emsi.hospitalapp.repository;

import ma.emsi.hospitalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patientrepository extends JpaRepository<Patient, Long> {

}
