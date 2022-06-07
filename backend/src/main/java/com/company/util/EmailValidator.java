package com.company.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator {
    // Email Regex java
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // static Pattern object, since pattern is fixed
    private final Pattern pattern;

    public EmailValidator() {
        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public boolean validateEmail(String email) {
        // non-static Matcher object because it's created from the input String
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
