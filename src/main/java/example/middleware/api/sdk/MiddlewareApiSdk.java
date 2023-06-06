/**
 * null
 */
package example.middleware.api.sdk;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import middleware.api.sdk.model.*;

/**
 * Interface for accessing ThinkWhyMiddlewareApiSdk.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface MiddlewareApiSdk {

    /**
     * @param getApiRootRequest
     * @return Result of the GetApiRoot operation returned by the service.
     * @sample ThinkWhyMiddlewareApiSdk.GetApiRoot
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/95gilj8bma-2018-05-24T17:52:00Z/GetApiRoot"
     *      target="_top">AWS API Documentation</a>
     */
    GetApiRootResult getApiRoot(GetApiRootRequest getApiRootRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static MiddlewareApiSdkClientBuilder builder() {
        return new MiddlewareApiSdkClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
