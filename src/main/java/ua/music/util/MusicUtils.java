package ua.music.util;

import ua.music.model.Track;
import ua.music.model.MusicGenre;
import java.time.LocalDate;

public class MusicUtils {

    public static String formatDuration(Track track) {
        ValidationHelper.requireNotNull(track, "track");
        int totalSeconds = track.durationSeconds();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public static int trackAgeYears(Track track) {
        ValidationHelper.requireNotNull(track, "track");
        ValidationHelper.requireNotNull(track.album(), "track.album");
        LocalDate releaseDate = track.album().releaseDate();
        return LocalDate.now().getYear() - releaseDate.getYear();
    }

    public static double getGenreMultiplier(MusicGenre genre) {
        return switch (genre) {
            case ROCK -> 1.2;
            case POP -> 1.5;
            case JAZZ -> 1.0;
            case CLASSICAL -> 0.8;
            case ELECTRONIC -> 1.4;
            case HIPHOP -> 1.3;
        };
    }

    public static String getSubscriptionPerk(String subscriptionType) {
        return switch (subscriptionType.toLowerCase()) {
            case "free" -> "Standard audio quality, ads included";
            case "premium" -> "High fidelity audio, zero ads, offline downloads";
            case "family" -> "Up to 6 premium accounts included";
            default -> "Unknown subscription tier";
        };
    }
}