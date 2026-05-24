package edu.wgu.d387_sample_code;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeController {

    @GetMapping("/api/welcome")
    public List<String> getWelcomeMessages() {
        List<String> messages = new ArrayList<>();

        WelcomeMessageLoader englishLoader = new WelcomeMessageLoader("welcome_en");
        WelcomeMessageLoader frenchLoader = new WelcomeMessageLoader("welcome_fr");


        Thread englishThread = new Thread(englishLoader);
        Thread frenchThread = new Thread(frenchLoader);

        englishThread.start();
        frenchThread.start();


        try {

            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        messages.add(englishLoader.getMessage());
        messages.add(frenchLoader.getMessage());

        return messages;

    }
}

