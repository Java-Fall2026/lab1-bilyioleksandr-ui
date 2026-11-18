package ua.music.model;

import ua.music.util.ValidationHelper;
import java.util.Objects;

public record Track(String isrcCode, Album album, String title, int durationSeconds, int trackNumber) {
    public Track {
        ValidationHelper.requireNonBlank(isrcCode, "isrcCode");
        Objects.requireNonNull(album, "album cannot be null");
        ValidationHelper.requireNonBlank(title, "title");

        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("durationSeconds must be positive");
        }
        if (trackNumber <= 0) {
            throw new IllegalArgumentException("trackNumber must be positive");
        }
    }
}
