package common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@NoArgsConstructor
@Setter
@Getter
public class CredentialsNew {

    private String userEmail;
    private String userPassword;
    static final Logger logger = LogManager.getLogger(CredentialsNew.class);

    public void getCredentials(String credentialType) {
        logger.info("getCredentials method call with value - " + credentialType);
        String email = CommonActions.readConfig(credentialType+".email", "user");
        String password = CommonActions.readConfig(credentialType+".password", "user");
        logger.info("email - " + email);
        logger.info("password - " + password);
        this.setUserEmail(email);
        this.setUserPassword(password);
    }
}
