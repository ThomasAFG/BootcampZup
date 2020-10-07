package com.zup.bootcamp.apibank.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@AllArgsConstructor
public class ClientImgDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private ClientBasicDTO basicInfo;

    private ClientAddressDTO addressInfo;

    @NotBlank(message = "Campo obrigatório!")
    private String pathFrontImg;

    @NotNull
    private String pathBackImg;

    public ClientBasicDTO getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(ClientBasicDTO basicInfo) {
        this.basicInfo = basicInfo;
    }

    public ClientAddressDTO getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(ClientAddressDTO addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getPathFrontImg() {
        return pathFrontImg;
    }

    public void setPathFrontImg(String pathFrontImg) {
        this.pathFrontImg = pathFrontImg;
    }

    public String getPathBackImg() {
        return pathBackImg;
    }

    public void setPathBackImg(String pathBackImg) {
        this.pathBackImg = pathBackImg;
    }
}
