package cognitoUtils;

import com.amazonaws.services.cognitoidp.model.*;

import java.util.Date;

/**
 * This class is an abstraction for a tracked device. A instance of this class represents one
 * tracked device and encapsulates all details for that device. This class provides methods to access
 * the device details. The device attributes are stored as an object of {@link CognitoUserAttributes}.
 */
public class CognitoDevice {

    final private String DEVICE_NAME_ATTRIBUTE = "device_name";
    final private String DEVICE_TYPE_REMEMBERED = "remembered";
    final private String DEVICE_TYPE_NOT_REMEMBERED = "not_remembered";

    /**
     * Service generated device-key.
     */
    final private String deviceKey;

    /**
     * Device attributes, will be null if no device attributes are available.
     */
    private CognitoUserAttributes deviceAttributes;

    /**
     * The date on which the user first authenticated on this device.
     */
    private Date createDate;

    /**
     * The date on which device attribute/s last modified.
     */
    private Date lastModifiedDate;

    /**
     * Last logged in on this device.
     */
    private Date lastAccessedDate;

    /**
     * The {@link CognitoUserUtils} this device is linked to.
     */
    final private CognitoUserUtils user;


    /**
     * Constructs an object of type {@link CognitoDevice} with device details.
     *
     * @param deviceKey        REQUIRED: The device key.
     * @param deviceAttributes REQUIRED: All devices attributes, stored as a {@link CognitoUserAttributes} object.
     * @param createDate       REQUIRED: The date when the device tracking last began.
     * @param lastModifiedDate REQUIRED: The date on which the device attributes were last modified.
     * @param lastAccessedDate REQUIRED: The date this device details were last read.
     * @param user             REQUIRED: The {@link CognitoUserUtils} this device is linked to.
     */
    public CognitoDevice(String deviceKey, CognitoUserAttributes deviceAttributes, Date createDate, Date lastModifiedDate, Date lastAccessedDate, CognitoUserUtils user) {
        this.deviceKey = deviceKey;
        this.deviceAttributes = deviceAttributes;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.lastAccessedDate = lastAccessedDate;
        this.user = user;
    }

    /**
     * Constructs a {@link CognitoDevice} object with {@link DeviceType} object.
     *
     * @param device REQUIRED: A {@link DeviceType} object.
     * @param user   REQUIRED: The {@link CognitoUserUtils} this device is linked to.
     */
    public CognitoDevice(DeviceType device, CognitoUserUtils user) {
        this.deviceKey = device.getDeviceKey();
        this.deviceAttributes = new CognitoUserAttributes(device.getDeviceAttributes());
        this.createDate = device.getDeviceCreateDate();
        this.lastModifiedDate = device.getDeviceLastModifiedDate();
        this.lastAccessedDate = device.getDeviceLastModifiedDate();
        this.user = user;
    }

    /**
     * Returns the key of this device.
     *
     * @return device key.
     */
    public String getDeviceKey() {
        return deviceKey;
    }

    /**
     * Returns all device attributes as an {@link CognitoUserAttributes} object.
     *
     * @return device attributes as an {@link CognitoUserAttributes} object.
     */
    public CognitoUserAttributes getDeviceAttributes() {
        return deviceAttributes;
    }

    /**
     * Returns the value assigned for a specific attribute for this device. The attribute name is
     * passed as a string. Returns null if this attribute is not set for this device.
     *
     * @param attributeName REQUIRED: The name of the attribute whose value is needed.
     * @return value associated with the passed attribute name as a string, returns null if the attribute does not have any value set.
     */
    public String getDeviceAttribute(String attributeName) {
        try {
            return deviceAttributes.getAttributes().get(attributeName);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns the name of this device.
     *
     * @return Name of the device.
     */
    public String getDeviceName() {
        return getDeviceAttribute(DEVICE_NAME_ATTRIBUTE);
    }

    /**
     * Returns the date this device was created in the Cognito User Pools, that is the date when the
     * service started tracking this device.
     *
     * @return the date when the device tracking began.
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Returns the date when attributes for this device were last modified.
     *
     * @return the date when the device attributes were last modified.
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * The date when the device details were last read.
     *
     * @return the date when the device details were last read.
     */
    public Date getLastAccessedDate() {
        return lastAccessedDate;
    }


    /**
     * Fetches device properties, in the current thread. Call this method to ensure the device properties are current.
     * Reading device properties from this object can return null values.
     */
    public void getDevice() {


        try {
            GetDeviceResult getDeviceResult = getDeviceInternal(user.getCachedSession());
            updateThis(getDeviceResult.getDevice());
        } catch (Exception e) {
            throw new CognitoIdentityProviderException("Get device fail", e);
        }
    }


    /**
     * Stops tracking this device, runs in the current thread.
     */
    public void forgetDevice() {
        try {
            forgetDeviceInternal(user.getCachedSession());
        } catch (Exception e) {
            throw new CognitoIdentityProviderException("Forget device fail", e);
        }
    }


    /**
     * Marks this device as trusted, runs in the current thread.
     * <p>
     * <b>Note:</b> This method will perform network operations. Calling this method in
     * applications' main thread will cause Android to throw NetworkOnMainThreadException.
     * </p>
     */
    public void rememberThisDevice() {
        try {
            updateDeviceStatusInternal(user.getCachedSession(), DEVICE_TYPE_REMEMBERED);
        } catch (Exception e) {
            throw new CognitoIdentityProviderException("Remember device fail", e);
        }
    }


    /**
     * Marks this device as <b>not</b> trusted, runs in the current thread.
     * <p>
     * <b>Note:</b> This method will perform network operations. Calling this method in
     * applications' main thread will cause Android to throw NetworkOnMainThreadException.
     * </p>
     */
    public void doNotRememberThisDevice() {

        try {
            updateDeviceStatusInternal(user.getCachedSession(), DEVICE_TYPE_NOT_REMEMBERED);
        } catch (Exception e) {
            throw new CognitoIdentityProviderException("Donot remember this", e);
        }
    }

    /**
     * Internal method to forget this device.
     *
     * @param session REQUIRED: A valid {@link CognitoUserSession}.
     */
    private void forgetDeviceInternal(CognitoUserSession session) {
        if (session != null && session.isValid()) {
            if (this.deviceKey != null) {
                CognitoDevice currentDeviceKey = user.thisDevice();
                if (this.deviceKey.equals(currentDeviceKey.getDeviceKey())) {
                    // CognitoDeviceHelper.clearCachedDevice(user.context);
                }
                ForgetDeviceRequest forgetDeviceRequest = new ForgetDeviceRequest();
                forgetDeviceRequest.setAccessToken(session.getAccessToken().getJWTToken());
                forgetDeviceRequest.setDeviceKey(this.deviceKey);
                user.getCognitoIdentityProviderClient().forgetDevice(forgetDeviceRequest);
            } else {
                throw new CognitoParameterInvalidException("Device key is null");
            }
        } else {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
    }

    /**
     * Internal method to fetch device details.
     *
     * @param session REQUIRED: A valid {@link CognitoUserSession}.
     * @return
     */
    private GetDeviceResult getDeviceInternal(CognitoUserSession session) {
        if (session != null && session.isValid()) {
            if (this.deviceKey != null) {
                GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
                getDeviceRequest.setAccessToken(session.getAccessToken().getJWTToken());
                getDeviceRequest.setDeviceKey(this.deviceKey);
                return user.getCognitoIdentityProviderClient().getDevice(getDeviceRequest);
            } else {
                throw new CognitoParameterInvalidException("Device key is null");
            }
        } else {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
    }

    /**
     * Internal method to set device status.
     *
     * @param session          REQUIRED: A valid {@link CognitoUserSession}.
     * @param deviceTrustState REQUIRED: New status of the device.
     * @return
     */
    private UpdateDeviceStatusResult updateDeviceStatusInternal(CognitoUserSession session, String deviceTrustState) {
        if (session != null && session.isValid()) {
            if (this.deviceKey != null) {
                UpdateDeviceStatusRequest updateDeviceStatusRequest = new UpdateDeviceStatusRequest();
                updateDeviceStatusRequest.setAccessToken(session.getAccessToken().getJWTToken());
                updateDeviceStatusRequest.setDeviceKey(this.deviceKey);
                updateDeviceStatusRequest.setDeviceRememberedStatus(deviceTrustState);
                return user.getCognitoIdentityProviderClient().updateDeviceStatus(updateDeviceStatusRequest);
            } else {
                throw new CognitoParameterInvalidException("Device key is invalid");
            }
        } else {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
    }

    /**
     * Internal method to update this object.
     *
     * @param device REQUIRED: {@link DeviceType} returned from the service.
     */
    private void updateThis(DeviceType device) {
        if (device == null) {
            throw new CognitoInternalErrorException("Service returned null object, this object was not updated");
        }
        if (!device.getDeviceKey().equals(this.deviceKey)) {
            throw new CognitoInternalErrorException("Service error, this object was not updated");
        }
        this.deviceAttributes = new CognitoUserAttributes(device.getDeviceAttributes());
        this.lastModifiedDate = device.getDeviceLastModifiedDate();
        this.lastAccessedDate = device.getDeviceLastModifiedDate();
    }
}
