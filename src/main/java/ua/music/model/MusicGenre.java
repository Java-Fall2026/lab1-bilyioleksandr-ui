package ua.music.model;

public enum MusicGenre {
    ROCK(1.2),
    POP(1.5),
    JAZZ(1.0),
    CLASSICAL(0.8),
    ELECTRONIC(1.4),
    HIPHOP(1.3);

    private final double popularityMultiplier;

    MusicGenre(double popularityMultiplier) {
        this.popularityMultiplier = popularityMultiplier;
    }

    public double getPopularityMultiplier() {
        return popularityMultiplier;
    }
}