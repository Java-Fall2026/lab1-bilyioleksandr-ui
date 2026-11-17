package ua.music.model;

import ua.common.BaseEntity;
import ua.music.util.ValidationHelper;

import java.time.LocalDate;
import java.util.Objects;

public class Artist extends BaseEntity {
    private String artistCode;
    private String stageName;
    private String country;
    private int debutYear;

    public Artist(String artistCode, String stageName, String country, int debutYear) {
        super();
        setArtistCode(artistCode);
        setStageName(stageName);
        setCountry(country);
        setDebutYear(debutYear);
    }

    public String getArtistCode() {
        return artistCode;
    }

    public void setArtistCode(String artistCode) {
        this.artistCode = ValidationHelper.requireNonBlank(artistCode, "artistCode");
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = ValidationHelper.requireNonBlank(stageName, "stageName");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = ValidationHelper.requireNonBlank(country, "country");
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = ValidationHelper.requireInRange(
                debutYear, 1900, LocalDate.now().getYear(), "debutYear"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(artistCode, artist.artistCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistCode);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistCode='" + artistCode + '\'' +
                ", stageName='" + stageName + '\'' +
                ", country='" + country + '\'' +
                ", debutYear=" + debutYear +
                ", createdAt=" + createdAt +
                '}';
    }
}
