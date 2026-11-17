package ua.music.util;

import java.time.LocalDate;

public class ValidationHelper {

    public static void requireNotNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(
                    String.format("Field '%s' cannot be null. Expected: non-null object, Got: null", fieldName)
            );
        }
    }

    public static String requireNonBlank(String value, String fieldName) {
        requireNotNull(value, fieldName);
        if (value.isBlank()) {
            throw new IllegalArgumentException(
                    String.format("Field '%s' cannot be blank. Expected: non-blank string, Got: '%s'", fieldName, value)
            );
        }
        return value.trim();
    }

    public static int requireInRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                    String.format("Field '%s' out of range [%d, %d]. Expected: value in range, Got: %d", fieldName, min, max, value)
            );
        }
        return value;
    }

    public static LocalDate requireNotFuture(LocalDate date, String fieldName) {
        requireNotNull(date, fieldName);
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    String.format("Field '%s' cannot be in the future. Expected: past or present date, Got: %s", fieldName, date)
            );
        }
        return date;
    }
}