package ma.emsi.hospitalapp.web;

import ma.emsi.hospitalapp.entities.Patient;
import ma.emsi.hospitalapp.repository.Patientrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private Patientrepository patientrepository;

    @GetMapping("/Index")
    public String Index(Model model) {
        List<Patient> patients = patientrepository.findAll();
        model.addAttribute("listpatients", patients);
        return "Patients";
    }
    @GetMapping("/deletepatient")
    public String delete(@RequestParam(name="id") Long id ){
        patientrepository.deleteById(id);
        return "redirect:/Index";
    }


}
