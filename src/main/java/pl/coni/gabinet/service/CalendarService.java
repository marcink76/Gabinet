package pl.coni.gabinet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coni.gabinet.model.WorkingDay;
import pl.coni.gabinet.repositories.WorkingDayInt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private WorkingDayInt workingDayInt;

    public void addCalendarDays() {
        LocalDate startDate = LocalDate.now();
        LocalDate nextDay = startDate;
        LocalTime openTime;
        LocalTime closeTime;

        List<WorkingDay> workingDayList = new ArrayList<>();

        for (int i = 0; i < startDate.lengthOfYear(); i++) {
            String dayName = nextDay.getDayOfWeek().name();
            nextDay = nextDay.plusDays(1);
            switch (dayName) {
                case "SATURDAY":
                    openTime = LocalTime.of(8, 00);
                    closeTime = LocalTime.of(14, 00);
                    break;
                case "SUNDAY":
                    openTime = null;
                    closeTime = null;
                    break;
                default:
                    openTime = LocalTime.of(8, 00);
                    closeTime = LocalTime.of(22, 00);
                    break;
            }
            workingDayList.add(new WorkingDay(nextDay, openTime, closeTime, dayName));
        }
        workingDayInt.save(workingDayList);
    }

    public List<WorkingDay> showCurrentMonth(int numberOfMonth) {
        List<WorkingDay> workingDayList = workingDayInt.findAll();
        //TODO zrobić filtrowanie po miesiącu
        return workingDayList;
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}