package ru.netology.sql.data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getAuthInfoWrongPassword() {
        return new AuthInfo("vasya", "123");
    }

    public static AuthInfo getWrongAuthInfo() {
        return new AuthInfo("blabla", "blabla");
    }

    @Value
    public static class VerificationCode {
        String code;
    }
}
