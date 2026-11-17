package ua.music;

import ua.music.model.*;
import ua.music.util.MusicUtils;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(" 1. Object Creation & Validation");
        Artist artist = new Artist("ART-001", "Daft Punk", "France", 1993);
        System.out.println("Artist created: " + artist);

        Album album = new Album("UPC-123456789", "Discovery", artist, "ELECTRONIC", LocalDate.of(2001, 3, 12));
        System.out.println("Album created: " + album);

        Track track = new Track("ISRC-FRZ3", album, "Digital Love", 301, 3);
        System.out.println("Track created: " + track);

        MusicUser user = new MusicUser("  USER@GMAIL.COM ", "Alex", "premium");
        System.out.println("User created (normalized): " + user);

        PlayListTrack pt = new PlayListTrack(user, track, LocalDate.of(2023, 5, 10));
        System.out.println("PlaylistTrack created: " + pt);

        System.out.println("\n 2. Exception Handling (IllegalArgumentException)");
        try {
            new Artist("ART-002", "Bad Artist", "USA", 1850);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception (debut year): " + e.getMessage());
        }

        try {
            album.setGenre("ROCKNROLL");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception (invalid genre): " + e.getMessage());
        }

        System.out.println("\n 3. Comparison: == vs equals");
        Artist artistCopy = new Artist("ART-001", "Daft Punk Duplicate", "France", 1993);
        System.out.println("artist == artistCopy : " + (artist == artistCopy));
        System.out.println("artist.equals(artistCopy) : " + artist.equals(artistCopy));

        System.out.println("\n 4. BaseEntity createdAt field");
        System.out.println("Track creation timestamp: " + track.getCreatedAt());

        System.out.println("\n 5. MusicUtils Calculations");
        System.out.println("Formatted track duration: " + MusicUtils.formatDuration(track));
        System.out.println("Album age (years): " + MusicUtils.trackAgeYears(track));
    }
}