package utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.dataflow.server.controller.security.support.AuthenticationRequest;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthResult;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;
import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;

public class CognitoSignIn {

	public static SpringSecurityUser signIn(AuthenticationRequest authenticationRequest) {
		
		SpringSecurityUser userAuthenticated = null;
		AuthenticationResultType authenticationResult = null;
		AWSCognitoIdentityProvider cognitoClient = ProvideIdentity.getAmazonCognitoIdentityClient();
		final Map<String, String> authParams = new HashMap<>();
		authParams.put("USERNAME", "example@gmail.com");
		authParams.put("PASSWORD", "pass");                                            
		final AdminInitiateAuthRequest authRequest = new AdminInitiateAuthRequest();
		authRequest.withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH).withClientId("example")
				.withUserPoolId("us-east-1_s8nYPAH2B").withAuthParameters(authParams);
		AdminInitiateAuthResult result = cognitoClient.adminInitiateAuth(authRequest);
		System.out.println(result);
		cognitoClient.shutdown();
		//userAuthenticated=result;
		return userAuthenticated;
	
	}
}
