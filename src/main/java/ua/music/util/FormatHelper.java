package ua.music.util;

import java.util.List;

public class FormatHelper {

    public static String normalizeAndValidateEnum(String value, List<String> allowedValues, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(
                    String.format("Field '%s' cannot be null. Expected one of %s, Got: null", fieldName, allowedValues)
            );
        }
        String normalized = value.strip().toUpperCase();
        if (!allowedValues.contains(normalized)) {
            throw new IllegalArgumentException(
                    String.format("Invalid value for field '%s'. Expected one of %s, Got: '%s'", fieldName, allowedValues, value)
            );
        }
        return normalized;
    }

    public static String normalizeEmail(String email) {
        String cleaned = ValidationHelper.requireNonBlank(email, "accountEmail");
        return cleaned.toLowerCase();
    }
}