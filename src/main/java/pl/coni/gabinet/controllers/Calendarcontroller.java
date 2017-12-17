package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coni.gabinet.model.WorkingDay;
import pl.coni.gabinet.service.CalendarService;
import pl.coni.gabinet.repositories.WorkingDayInt;

import java.util.List;

@Controller
@RequestMapping("")
public class Calendarcontroller {

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private WorkingDayInt workingDay;

    @GetMapping("/showcalendar")
    public String calendar() {
        return "calendaroperator";
    }

    @GetMapping("/calendargenerator")
    public String calendargenerator() {
        calendarService.addCalendarDays();
        return "calendaroperator";
    }

    @GetMapping("/showall")
    public String showAllDays(Model model) {
        List<WorkingDay> workingDays = workingDay.findAll();
        model.addAttribute("workingDays", workingDays);
        return "showcalendar";
    }

    @GetMapping("/showcurrentmonth")
    public String showMonth(@RequestParam int month,
                            Model model) {
        List<WorkingDay> workingDays = calendarService.showCurrentMonth(month);
        model.addAttribute("workingDays", workingDays);
        return "showcalendar";
    }
}
