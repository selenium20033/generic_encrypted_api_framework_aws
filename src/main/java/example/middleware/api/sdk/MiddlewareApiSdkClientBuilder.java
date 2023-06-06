/**
 * null
 */
package example.middleware.api.sdk;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.opensdk.protect.client.SdkSyncClientBuilder;
import com.amazonaws.opensdk.internal.config.ApiGatewayClientConfigurationFactory;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.Protocol;

import java.net.URI;
import javax.annotation.Generated;

/**
 * Fluent builder for {@link example.middleware.api.sdk.MiddlewareApiSdk}.
 * 
 * @see example.middleware.api.sdk.MiddlewareApiSdk#builder
 **/
@NotThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public final class MiddlewareApiSdkClientBuilder extends SdkSyncClientBuilder<MiddlewareApiSdkClientBuilder, MiddlewareApiSdk> {

    private static final URI DEFAULT_ENDPOINT = RuntimeHttpUtils.toUri("95gilj8bma.execute-api.us-east-1.amazonaws.com", Protocol.HTTPS);
    private static final String DEFAULT_REGION = "us-east-1";

    /**
     * Package private constructor - builder should be created via {@link MiddlewareApiSdk#builder()}
     */
    MiddlewareApiSdkClientBuilder() {
        super(new ApiGatewayClientConfigurationFactory());
    }

    /**
     * Construct a synchronous implementation of ThinkWhyMiddlewareApiSdk using the current builder configuration.
     *
     * @param params
     *        Current builder configuration represented as a parameter object.
     * @return Fully configured implementation of ThinkWhyMiddlewareApiSdk.
     */
    @Override
    protected MiddlewareApiSdk build(AwsSyncClientParams params) {
        return new MiddlewareApiSdkClient(params);
    }

    @Override
    protected URI defaultEndpoint() {
        return DEFAULT_ENDPOINT;
    }

    @Override
    protected String defaultRegion() {
        return DEFAULT_REGION;
    }

}
