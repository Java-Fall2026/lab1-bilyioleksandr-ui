package ua.music.model;

import ua.music.util.ValidationHelper;

public record Artist(String artistCode, String stageName, String country, int debutYear) {
    public Artist {
        ValidationHelper.requireNonBlank(artistCode, "artistCode");
        ValidationHelper.requireNonBlank(stageName, "stageName");
        ValidationHelper.requireNonBlank(country, "country");
        ValidationHelper.requireInRange(debutYear, 1900, 2026, "debutYear");
    }
}
