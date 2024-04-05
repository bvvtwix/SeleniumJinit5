package common;

import lombok.Getter;


public class Credentials {

    private static String loginName = CommonActions.readConfig("username", "user");
    private static String password = CommonActions.readConfig("user.password", "user");
    private static String email = CommonActions.readConfig("user.email", "user");
    private static String repoName = CommonActions.readConfig("reponame", "user");

    public static String getLoginName() {
        return loginName;
    }

    public static String getRepoName() {
        return repoName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

}
