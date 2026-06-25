package edu.wgu.d387_sample_code;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

// Use REST controller to convert java return values into JSON arrays
@RestController
@CrossOrigin(origins = "http://localhost:4200") //Prevents browser CORS blocks by trusting port 4200
public class WelcomeController {

    // Activate when http://localhost:8080/api/welcome is visited
    @GetMapping("/api/welcome")
    public List<String> getWelcomeMessages() {
        //Create an empty list to hold final translated messages
        List<String> messages = new ArrayList<>();

        // Init 2 Runnable tasks with the different language files
        WelcomeMessageLoader englishLoader = new WelcomeMessageLoader("welcome_en");
        WelcomeMessageLoader frenchLoader = new WelcomeMessageLoader("welcome_fr");

        //Pass Loaders into separate Java Thread paths
        Thread englishThread = new Thread(englishLoader);
        Thread frenchThread = new Thread(frenchLoader);

        // Fire both paths concurrently
        englishThread.start();
        frenchThread.start();


        try {
        // Force REST endpoint to wait until both threads have finished running their internal methods
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {

            //Exception catch logic if a thread execution is interrupted
            e.printStackTrace();

        }
        //Extract strings from loaders and store in return array
        messages.add(englishLoader.getMessage());
        messages.add(frenchLoader.getMessage());

        // Return the list, spring boot will convert to JSON
        return messages;

    }
}

