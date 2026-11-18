package ua.music.model;

import ua.music.util.ValidationHelper;
import java.time.LocalDate;
import java.util.Objects;

public record Album(String upcCode, String title, Artist artist, MusicGenre genre, LocalDate releaseDate) {
    public Album {
        ValidationHelper.requireNonBlank(upcCode, "upcCode");
        ValidationHelper.requireNonBlank(title, "title");
        Objects.requireNonNull(artist, "artist cannot be null");
        Objects.requireNonNull(genre, "genre cannot be null");
        Objects.requireNonNull(releaseDate, "releaseDate cannot be null");
    }
}