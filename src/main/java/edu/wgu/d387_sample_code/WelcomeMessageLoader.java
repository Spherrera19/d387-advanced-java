package edu.wgu.d387_sample_code;

import java.util.ResourceBundle;


public class WelcomeMessageLoader implements Runnable {

    private final String bundleName;
    private String message;

    public WelcomeMessageLoader(String bundleName) {
        this.bundleName = bundleName;
    }

    @Override
    public void run(){

        ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
        this.message = bundle.getString("welcomeMessage");
    }

    public String getMessage() {
        return message;
    }
}
