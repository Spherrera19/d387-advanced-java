package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeZoneController {

    @GetMapping("/api/presentation")
    public List<String> getPresentationTimes() {
        List<String> formattedTimes = new ArrayList<>();

        // 1. Set a base time for the presentation
        LocalDateTime baseTime = LocalDateTime.of(2026, 6, 25, 15, 30);

        // 2. Define our three target time zones
        ZoneId easternZone = ZoneId.of("America/New_York");
        ZoneId mountainZone = ZoneId.of("America/Denver");
        ZoneId utcZone = ZoneId.of("UTC");

        // 3. Anchor the base time to Eastern Time
        ZonedDateTime easternTime = ZonedDateTime.of(baseTime, easternZone);

        // 4. Convert that exact moment into Mountain and UTC times
        ZonedDateTime mountainTime = easternTime.withZoneSameInstant(mountainZone);
        ZonedDateTime utcTime = easternTime.withZoneSameInstant(utcZone);

        // 5. Create a formatter to display ONLY hours and minutes (HH:mm) as required by the rubric
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // 6. Format the times, add their labels, and add them to the list
        formattedTimes.add(easternTime.format(formatter) + " ET");
        formattedTimes.add(mountainTime.format(formatter) + " MT");
        formattedTimes.add(utcTime.format(formatter) + " UTC");

        // 7. Send the list back to the frontend
        return formattedTimes;
    }
}
