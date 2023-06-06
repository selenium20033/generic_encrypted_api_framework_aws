package cognitoUtils;

/**
 * Created by vinuv on 16-12-2016.
 */
public class CognitoSignup {

    private CognitoUserUtils user;

    private Boolean confirmed;

    private CognitoUserCodeDeliveryDetails codeDeliveryDetails;

    public CognitoSignup(CognitoUserUtils user, Boolean confirmed, CognitoUserCodeDeliveryDetails codeDeliveryDetails) {
        this.user = user;
        this.confirmed = confirmed;
        this.codeDeliveryDetails = codeDeliveryDetails;
    }


    public CognitoUserUtils getUser() {
        return user;
    }

    public void setUser(CognitoUserUtils user) {
        this.user = user;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public CognitoUserCodeDeliveryDetails getCodeDeliveryDetails() {
        return codeDeliveryDetails;
    }

    public void setCodeDeliveryDetails(CognitoUserCodeDeliveryDetails codeDeliveryDetails) {
        this.codeDeliveryDetails = codeDeliveryDetails;
    }
}
