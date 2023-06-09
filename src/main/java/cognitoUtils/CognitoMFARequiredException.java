package cognitoUtils;

import com.amazonaws.services.cognitoidp.model.RespondToAuthChallengeResult;

/**
 * Created by vinuv on 16-12-2016.
 */
public class CognitoMFARequiredException extends CognitoIdentityProviderException {

    private RespondToAuthChallengeResult challenge;

    public CognitoMFARequiredException(String message, Throwable throwable, RespondToAuthChallengeResult challenge) {
        super(message, throwable);
        this.challenge = challenge;
    }

    public CognitoMFARequiredException(String message,RespondToAuthChallengeResult challenge) {
        super(message);
        this.challenge = challenge;
    }

    public RespondToAuthChallengeResult getChallenge() {
        return this.challenge;
    }

    public CognitoUserCodeDeliveryDetails getParameters(){
        return new CognitoUserCodeDeliveryDetails(challenge.getChallengeParameters().get("CODE_DELIVERY_DESTINATION"),
                challenge.getChallengeParameters().get("CODE_DELIVERY_DELIVERY_MEDIUM"),
                null);
    }
}
