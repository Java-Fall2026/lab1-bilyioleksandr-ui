package ua.music.model;

import java.time.LocalDate;
import java.util.Objects;

public record PlayListTrack(MusicUser user, Track track, LocalDate addedDate) {
    public PlayListTrack {
        Objects.requireNonNull(user, "user cannot be null");
        Objects.requireNonNull(track, "track cannot be null");
        Objects.requireNonNull(addedDate, "addedDate cannot be null");
    }
}