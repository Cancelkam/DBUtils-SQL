package ru.netology.sql.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import ru.netology.sql.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
public class LoginPage {
    private SelenideElement loginField =  $("input[name=login]");
    private SelenideElement passwordField =  $("input[name=password]");
    private SelenideElement confirmButton =  $(".button__text");

    public LoginPage() {
        open("http://localhost:9999");
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        confirmButton.click();
        return new VerificationPage();
    }
}