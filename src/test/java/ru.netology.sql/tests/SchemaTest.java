package ru.netology.sql.tests;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.sql.data.DataHelper;
import ru.netology.sql.data.MysqlUtils;
import ru.netology.sql.page.LoginPage;

public class SchemaTest {

    @Test
    void shouldHaveSuccessLogin() {
        val authInfo = DataHelper.getAuthInfo();
        val loginPage = new LoginPage();
        val verificationPage = loginPage.validLogin(authInfo);
        val smsCode = MysqlUtils.getSmsCode(authInfo.getLogin());
        val dashboardPage = verificationPage.validVerify(smsCode);
        dashboardPage.assertHeadingIsVisible();
    }
}

