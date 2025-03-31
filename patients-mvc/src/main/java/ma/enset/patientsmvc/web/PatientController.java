package ma.enset.patientsmvc.web;


import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

   @GetMapping(path = "/user/index")
   public String patients(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword
   ){
       Page<Patient> patientPage = patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
       model.addAttribute("listPatients", patientPage.getContent());
       model.addAttribute("pages", new int [patientPage.getTotalPages()]);
       model.addAttribute("currentPage", page);
       model.addAttribute("keyword", keyword);
       return "patients";
   }

   @GetMapping("/admin/delete")
   public String delete(Long id, String keyword, int page){
       patientRepository.deleteById(id);
       return "redirect:/user/index?page=" + page + "&keyword=" + keyword;
   }
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user/patients")
    @ResponseBody
    public List<Patient> patientList(){
       return patientRepository.findAll();
    }

    @GetMapping("/admin/formPatients")
    public String formPatients(Model model){
       model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @GetMapping("/admin/editPatients")
    public String formPatients(Model model, @RequestParam Long id, String keyword, int page){
       Patient patient = patientRepository.findById(id).orElse(null);
       if(patient == null){
           throw new RuntimeException("Patient introuvable");
       }
        model.addAttribute("patient", patient);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "editPatients";
    }
    @PostMapping(path = "/save")
    public String save(Model model,@Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page ,
                       @RequestParam(defaultValue = " ") String keyword){
      if(bindingResult.hasErrors()){
          return "formPatients";
      }
       patientRepository.save(patient);
       return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
}
