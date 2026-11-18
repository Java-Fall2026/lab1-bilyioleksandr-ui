package ua.music.model;

import ua.music.util.FormatHelper;
import ua.music.util.ValidationHelper;

public record MusicUser(String accountEmail, String username, String subscriptionType) {
    public MusicUser {
        ValidationHelper.requireNonBlank(accountEmail, "accountEmail");
        accountEmail = FormatHelper.normalizeEmail(accountEmail);
        ValidationHelper.requireNonBlank(username, "username");
        ValidationHelper.requireNonBlank(subscriptionType, "subscriptionType");
    }
}