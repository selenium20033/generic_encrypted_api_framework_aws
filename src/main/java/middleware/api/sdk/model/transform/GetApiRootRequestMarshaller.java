/**
 * null
 */
package middleware.api.sdk.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.protocol.*;

import middleware.api.sdk.model.*;

import com.amazonaws.annotation.SdkInternalApi;

/**
 * GetApiRootRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetApiRootRequestMarshaller {

    private static final GetApiRootRequestMarshaller instance = new GetApiRootRequestMarshaller();

    public static GetApiRootRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetApiRootRequest getApiRootRequest, ProtocolMarshaller protocolMarshaller) {

        if (getApiRootRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
