package ua.music.util;

import ua.music.model.Track;

import java.time.LocalDate;

public class MusicUtils {

    public static String formatDuration(Track track) {
        ValidationHelper.requireNotNull(track, "track");
        int totalSeconds = track.getDurationSeconds();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public static int trackAgeYears(Track track) {
        ValidationHelper.requireNotNull(track, "track");
        ValidationHelper.requireNotNull(track.getAlbum(), "track.album");
        LocalDate releaseDate = track.getAlbum().getReleaseDate();
        return LocalDate.now().getYear() - releaseDate.getYear();
    }
}