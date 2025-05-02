package ma.emsi.hospitalapp.web;

import ma.emsi.hospitalapp.entities.Patient;
import ma.emsi.hospitalapp.repository.Patientrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public String Index(Model model,@RequestParam(name="page",defaultValue = "0") int page,
                         @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword) {
        Page<Patient> patients = patientrepository.findByNomContainsIgnoreCaseOrPrenomIgnoreCase( keyword,keyword,PageRequest.of(page,size));
        model.addAttribute("pagepatients",patients.getContent());
        model.addAttribute("pages",new int[patients.getTotalPages()]);
        model.addAttribute("currentpage",page);
        model.addAttribute("keyword",keyword);
        return "Patients";
    }
    @GetMapping("/deletepatient")
    public String delete(@RequestParam(name="id") Long id,String keyword ) {
        patientrepository.deleteById(id);
        return "redirect:/Index";
    }


}
