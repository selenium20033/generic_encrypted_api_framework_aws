package utils;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;

public class ProvideIdentity {

		public static AWSCognitoIdentityProvider getAmazonCognitoIdentityClient() {
			ClasspathPropertiesFileCredentialsProvider propertiesFileCredentialsProvider = new ClasspathPropertiesFileCredentialsProvider();

			return AWSCognitoIdentityProviderClientBuilder.standard()
					.withRegion("us-east-1").build();
		
		}
	}


