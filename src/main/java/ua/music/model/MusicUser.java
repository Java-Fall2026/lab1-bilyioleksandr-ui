package ua.music.model;

import ua.common.BaseEntity;
import ua.music.util.FormatHelper;
import ua.music.util.ValidationHelper;

import java.util.List;
import java.util.Objects;

public class MusicUser extends BaseEntity {
    private String accountEmail;
    private String username;
    private String subscription;

    private static final List<String> ALLOWED_SUBSCRIPTIONS = List.of("FREE", "PREMIUM", "FAMILY");

    public MusicUser(String accountEmail, String username, String subscription) {
        super();
        setAccountEmail(accountEmail);
        setUsername(username);
        setSubscription(subscription);
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = FormatHelper.normalizeEmail(accountEmail);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = ValidationHelper.requireNonBlank(username, "username");
    }

    public String getSubscription() {
        return subscription;
    }

    public final void setSubscription(String subscription) {
        this.subscription = FormatHelper.normalizeAndValidateEnum(subscription, ALLOWED_SUBSCRIPTIONS, "subscription");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicUser musicUser = (MusicUser) o;
        return Objects.equals(accountEmail, musicUser.accountEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountEmail);
    }

    @Override
    public String toString() {
        return "MusicUser{" +
                "accountEmail='" + accountEmail + '\'' +
                ", username='" + username + '\'' +
                ", subscription='" + subscription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}