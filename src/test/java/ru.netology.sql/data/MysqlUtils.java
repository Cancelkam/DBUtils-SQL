package ru.netology.sql.data;

import lombok.Data;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class MysqlUtils {
    public static String getSmsCode(String login) throws SQLException {
        val runner = new QueryRunner();
//        val dataSQL = "SELECT login, password FROM users";
        val authcodeSQL = "SELECT CODE FROM auth_codes a JOIN users u ON u.id = a.user_id WHERE u.login='?'";
        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/db", "app", "pass"
                )
        ) {
//            val loginData = runner.query(conn, dataSQL, new BeanHandler<>(DataHelper.AuthInfo.class));
//            System.out.println(loginData);
            String authCode = runner.query(conn, authcodeSQL, login, new ScalarHandler<>());
            return authCode;
        }
    }
}
