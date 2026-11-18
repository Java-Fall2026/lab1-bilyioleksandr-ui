package ua.music;

import ua.music.model.*;
import ua.music.util.MusicUtils;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(" 1. Record Creation & Component Access");
        Artist artist = new Artist("ART-001", "Daft Punk", "France", 1993);
        System.out.println("Artist name: " + artist.stageName() + ", Country: " + artist.country());

        Album album = new Album("UPC-123456789", "Discovery", artist, MusicGenre.ELECTRONIC, LocalDate.of(2001, 3, 12));
        System.out.println("Album title: " + album.title() + ", Genre: " + album.genre());

        Track track = new Track("ISRC-FRZ3", album, "Digital Love", 301, 3);
        System.out.println("Track created: " + track);

        System.out.println("\n 2. Enum Features (values(), custom fields, valueOf exception)");
        System.out.println("All available genres: " + Arrays.toString(MusicGenre.values()));
        System.out.println("Popularity multiplier for ELECTRONIC: " + MusicGenre.ELECTRONIC.getPopularityMultiplier());

        try {
            MusicGenre.valueOf("ROCKNROLL");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for invalid enum value: " + e.getMessage());
        }

        System.out.println("\n 3. Switch Expressions Demonstration");
        System.out.println("Multiplier from switch for ROCK: " + MusicUtils.getGenreMultiplier(MusicGenre.ROCK));
        System.out.println("Subscription perk from switch: " + MusicUtils.getSubscriptionPerk("premium"));

        System.out.println("\n 4. Record Validation (IllegalArgumentException)");
        try {
            new Artist("ART-002", "Bad Artist", "USA", 1850);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught validation exception (debut year): " + e.getMessage());
        }

        System.out.println("\n 5. Record equals() and hashCode()");
        Artist artistDuplicate = new Artist("ART-001", "Daft Punk", "France", 1993);
        System.out.println("artist.equals(artistDuplicate): " + artist.equals(artistDuplicate));
        System.out.println("artist.hashCode() == artistDuplicate.hashCode(): " + (artist.hashCode() == artistDuplicate.hashCode()));

        System.out.println("\n 6. Generated toString() Output");
        MusicUser user = new MusicUser("user@gmail.com", "Alex", "premium");
        System.out.println("User toString: " + user);
    }
}