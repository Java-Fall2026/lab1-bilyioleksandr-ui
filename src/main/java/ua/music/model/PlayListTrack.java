package ua.music.model;

import ua.common.BaseEntity;
import ua.music.util.ValidationHelper;

import java.time.LocalDate;
import java.util.Objects;

public class PlayListTrack extends BaseEntity {
    private MusicUser user;
    private Track track;
    private LocalDate addedDate;

    public PlayListTrack(MusicUser user, Track track, LocalDate addedDate) {
        super();
        setUser(user);
        setTrack(track);
        setAddedDate(addedDate);
    }

    public MusicUser getUser() {
        return user;
    }

    public void setUser(MusicUser user) {
        ValidationHelper.requireNotNull(user, "user");
        this.user = user;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        ValidationHelper.requireNotNull(track, "track");
        this.track = track;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        ValidationHelper.requireNotFuture(addedDate, "addedDate");
        if (track != null && track.getAlbum() != null && addedDate.isBefore(track.getAlbum().getReleaseDate())) {
            throw new IllegalArgumentException(
                    String.format("Field 'addedDate' (%s) cannot be before album release date (%s).", addedDate, track.getAlbum().getReleaseDate())
            );
        }
        this.addedDate = addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayListTrack that = (PlayListTrack) o;
        return Objects.equals(user, that.user) && Objects.equals(track, that.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, track);
    }

    @Override
    public String toString() {
        return "PlaylistTrack{" +
                "user=" + (user != null ? user.getAccountEmail() : null) +
                ", track=" + (track != null ? track.getTitle() : null) +
                ", addedDate=" + addedDate +
                ", createdAt=" + createdAt +
                '}';
    }
}