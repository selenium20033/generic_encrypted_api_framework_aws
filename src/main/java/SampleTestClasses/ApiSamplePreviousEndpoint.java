package SampleTestClasses;

import utils.CognitoSignIn;
import utils.ConfigsReader;
import utils.ProvideIdentity;
import utils.SpringSecurityUser;


import org.junit.Test;
import org.seleniumhq.jetty9.server.Authentication;

import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.config.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.opensdk.config.ConnectionConfiguration;
import com.amazonaws.opensdk.config.TimeoutConfiguration;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserResult;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthResult;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;
import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidp.model.UserPoolClientType;
import com.amazonaws.services.workdocs.model.UserType;
import com.amazonaws.util.StringUtils;

import example.middleware.api.sdk.*;
import middleware.api.sdk.model.*;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;

import org.springframework.cloud.dataflow.server.controller.security.support.AuthenticationRequest;
import org.springframework.security.core.userdetails.UserDetails;

public class ApiSamplePreviousEndpoint {

	@Test
	public void test() {
		
		UserPoolClientType type=new UserPoolClientType();
        type.getLogoutURLs();
        
		ProvideIdentity.getAmazonCognitoIdentityClient();
		CognitoSignIn.signIn(null);
		
		MiddlewareApiSdk client = MiddlewareApiSdk.builder()
				.connectionConfiguration(
						new ConnectionConfiguration().maxConnections(100).connectionMaxIdleMillis(1000))
				.timeoutConfiguration(new TimeoutConfiguration().httpRequestTimeout(3000).totalExecutionTimeout(10000)
						.socketTimeout(2000))
				.build();
		
		MiddlewareApiSdkClientBuilder builder = MiddlewareApiSdk.builder();
		GetApiRootResult result = client.getApiRoot(new GetApiRootRequest());
		
		builder.setEndpoint("https://47npbmsh0j.execute-api.us-east-1.amazonaws.com/test/security/feature");

		client.getApiRoot(new GetApiRootRequest().sdkRequestConfig(SdkRequestConfig.builder().httpRequestTimeout(1500)
				.totalExecutionTimeout(5000).customQueryParam("orgId", "example").build()));

		System.out.println(result.sdkResponseMetadata().requestId());
		System.out.println(result.sdkResponseMetadata().httpStatusCode());
		// Full access to all HTTP headers (including modeled ones)
		result.sdkResponseMetadata().header("Content-Length").ifPresent(System.out::println);
	}
}
