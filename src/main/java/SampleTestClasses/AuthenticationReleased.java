package SampleTestClasses;

import utils.CognitoSignIn;
import utils.ConfigsReader;
import utils.ProvideIdentity;
import utils.SpringSecurityUser;
import utils.HuaylupoSignOutMethod;

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
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.DeleteAccessKeyRequest;
import com.amazonaws.services.identitymanagement.model.DeleteAccessKeyResult;
import com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateRequest;
import com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateResult;
import com.amazonaws.services.identitymanagement.model.UpdateLoginProfileRequest;
import com.amazonaws.services.identitymanagement.model.UpdateLoginProfileResult;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.workdocs.model.UserType;
import com.amazonaws.util.StringUtils;

import example.middleware.api.sdk.*;
import io.restassured.RestAssured;
import middleware.api.sdk.model.*;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;

import org.springframework.cloud.dataflow.server.controller.security.support.AuthenticationRequest;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationReleased {

	@Test
	public void test() {

		UserPoolClientType type = new UserPoolClientType();
		type.getLogoutURLs();
	
		
		ProvideIdentity.getAmazonCognitoIdentityClient();
		CognitoSignIn.signIn(null);
		
		//RestAssured.given().when().get("https://example.amazonaws.com/tenants/product/list").prettyPrint();
		
		// Generic SDK name should be replaced with the cliend middleware SDK name
		
		GenericMiddlewareApiSdkClientBuilder builder = GenericMiddlewareApiSdk.builder();
		GetApiRootResult result = client.getApiRoot(new GetApiRootRequest());
	   builder.setEndpoint("https://47npbmsh0j.execute-api.us-east-1.amazonaws.com/tenants/product/list");
		
		GenericyMiddlewareApiSdk client = GenericMiddlewareApiSdk.builder()
				.connectionConfiguration(
						new ConnectionConfiguration().maxConnections(100).connectionMaxIdleMillis(1000))
				.timeoutConfiguration(new TimeoutConfiguration().httpRequestTimeout(3000).totalExecutionTimeout(10000)
						.socketTimeout(2000))
				.build();
		client.getApiRoot(new GetApiRootRequest().sdkRequestConfig(SdkRequestConfig.builder().httpRequestTimeout(1500)
				.totalExecutionTimeout(5000).customQueryParam("orgId", "example").build()));

				System.out.println(result.sdkResponseMetadata().requestId());
				System.out.println(result.sdkResponseMetadata().httpStatusCode());
				
				DeleteAccessKeyRequest request = new
						 DeleteAccessKeyRequest().withUserName("Bob").
						 withAccessKeyId("test"); 
						 DeleteAccessKeyResult response =client.deleteAccessKey(request);
						 
						 AmazonIdentityManagement update = AmazonIdentityManagementClientBuilder.standard().build();
						 DeleteSigningCertificateRequest request2 = new DeleteSigningCertificateRequest()
						 .withCertificateId("example");
						 DeleteSigningCertificateResult response2 = update.deleteSigningCertificate(request2);	
						 
						 UpdateLoginProfileRequest request3 = new UpdateLoginProfileRequest().
								 withUserName("Bob").withPassword("SomeKindOfPassword123!@#");
								 UpdateLoginProfileResult response3 = update.updateLoginProfile(request3);
								 
								 DeleteSigningCertificateRequest request4 = new
										 DeleteSigningCertificateRequest().withUserName("Anika").withCertificateId(
										 "example"); 
										 DeleteSigningCertificateResult response4 =update.deleteSigningCertificate(request4);
										 
										 AwsClientBuilder.EndpointConfiguration config = 
												 new AwsClientBuilder.EndpointConfiguration("https://47npbmsh0j.execute-api.us-east-1.amazonaws.com/test/security/feature", "us-east-1");
												 AWSSecretsManagerClientBuilder clientBuilder = AWSSecretsManagerClientBuilder.standard();
												 clientBuilder.setEndpointConfiguration(config);
		
	}

		
	}

    




