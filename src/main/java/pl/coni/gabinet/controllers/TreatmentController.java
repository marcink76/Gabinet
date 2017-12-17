package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coni.gabinet.model.Treatment;
import pl.coni.gabinet.service.TreatmentService;

@Controller
@RequestMapping("/treatment")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/add")
    private String addTreatment(Model model) {
        model.addAttribute("treatment", new Treatment());
        return "addTreatmentForm";
    }

    @PostMapping("/addtreatment")
    private String saveTreatment(Treatment treatment) {
        treatmentService.saveTreatment(treatment);
        return "index";
    }

}
