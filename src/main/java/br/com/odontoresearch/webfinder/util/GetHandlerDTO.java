package br.com.odontoresearch.webfinder.util;

public class GetHandlerDTO {
    private String errorMessage;
    private String object;
    private Integer status;

    public GetHandlerDTO(String errorMessage, String object, Integer status){
        this.errorMessage = errorMessage;
        this.object = object;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
