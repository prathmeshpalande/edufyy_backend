package com.edufyy.backend.model;

public class GeneralResponseObject {

    private Integer responseCode;
    private String responseMessage;
    private Object responseData;

    public static GeneralResponseObject getSuccessResponse() {
        return new GeneralResponseObject(1, "Success", null);
    }

    public static GeneralResponseObject getFailureResponse() {
        return new GeneralResponseObject(0, "Failure", null);
    }

    public GeneralResponseObject() {
    }

    public GeneralResponseObject(Integer responseCode, String responseMessage, Object responseData) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
