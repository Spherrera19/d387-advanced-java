package edu.wgu.d387_sample_code;

import java.util.ResourceBundle;

/**
 * implements the Runnable interface, allowing it to execute
 * its core code inside an isolated, independent thread stream.
 */

public class WelcomeMessageLoader implements Runnable {

    //Name of the target resource bundle file (ex: "welcome_en")
    private final String bundleName;
    //Shared variable that will store the string message pulled by the thread.
    private String message;

    // Constructor used to instantiate the class with a specific target language bundle
    public WelcomeMessageLoader(String bundleName) {
        this.bundleName = bundleName;
    }

    // Start of the threads execution pathway
    // when thread.start() invoked, block runs async
    @Override
    public void run(){
    //Bind to the requested properties file in src/main/resources
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
    // Grab the string matching the defined key, assign to our instance variable
        this.message = bundle.getString("welcomeMessage");
    }

    // Getter method used by the controller to collect the string after the thread finishes running
    public String getMessage() {
        return message;
    }
}
