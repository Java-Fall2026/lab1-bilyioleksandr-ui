package ua.music.model;

import ua.common.BaseEntity;
import ua.music.util.FormatHelper;
import ua.music.util.ValidationHelper;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Album extends BaseEntity {
    private String upcCode;
    private String title;
    private Artist artist;
    private String genre;
    private LocalDate releaseDate;

    private static final List<String> ALLOWED_GENRES = List.of("ROCK", "POP", "JAZZ", "CLASSICAL", "ELECTRONIC", "HIPHOP");

    public Album(String upcCode, String title, Artist artist, String genre, LocalDate releaseDate) {
        super();
        setUpcCode(upcCode);
        setTitle(title);
        setArtist(artist);
        setGenre(genre);
        setReleaseDate(releaseDate);
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = ValidationHelper.requireNonBlank(upcCode, "upcCode");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = ValidationHelper.requireNonBlank(title, "title");
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        ValidationHelper.requireNotNull(artist, "artist");
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = FormatHelper.normalizeAndValidateEnum(genre, ALLOWED_GENRES, "genre");
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        ValidationHelper.requireNotFuture(releaseDate, "releaseDate");
        if (artist != null && releaseDate.getYear() < artist.getDebutYear()) {
            throw new IllegalArgumentException(
                    String.format("Field 'releaseDate' year (%d) cannot be before artist debut year (%d).", releaseDate.getYear(), artist.getDebutYear())
            );
        }
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(upcCode, album.upcCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upcCode);
    }

    @Override
    public String toString() {
        return "Album{" +
                "upcCode='" + upcCode + '\'' +
                ", title='" + title + '\'' +
                ", artist=" + (artist != null ? artist.getStageName() : null) +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", createdAt=" + createdAt +
                '}';
    }
}