package ua.music.model;

import ua.common.BaseEntity;
import ua.music.util.ValidationHelper;

import java.util.Objects;

public class Track extends BaseEntity {
    private String isrcCode;
    private Album album;
    private String title;
    private int durationSeconds;
    private int trackNumber;

    public Track(String isrcCode, Album album, String title, int durationSeconds, int trackNumber) {
        super();
        setIsrcCode(isrcCode);
        setAlbum(album);
        setTitle(title);
        setDurationSeconds(durationSeconds);
        setTrackNumber(trackNumber);
    }

    public String getIsrcCode() {
        return isrcCode;
    }

    public void setIsrcCode(String isrcCode) {
        this.isrcCode = ValidationHelper.requireNonBlank(isrcCode, "isrcCode");
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        ValidationHelper.requireNotNull(album, "album");
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = ValidationHelper.requireNonBlank(title, "title");
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = ValidationHelper.requireInRange(durationSeconds, 1, 3600, "durationSeconds");
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = ValidationHelper.requireInRange(trackNumber, 1, 500, "trackNumber");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(isrcCode, track.isrcCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isrcCode);
    }

    @Override
    public String toString() {
        return "Track{" +
                "isrcCode='" + isrcCode + '\'' +
                ", album=" + (album != null ? album.getTitle() : null) +
                ", title='" + title + '\'' +
                ", durationSeconds=" + durationSeconds +
                ", trackNumber=" + trackNumber +
                ", createdAt=" + createdAt +
                '}';
    }
}
