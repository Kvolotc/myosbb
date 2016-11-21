package com.softserve.osbb.dto;

import java.sql.Timestamp;

import com.softserve.osbb.model.Attachment;

/**
 * Created by nazar.dovhyy on 29.10.2016.
 */
public class OsbbRegistrationDTO extends AbstractDTO {

    private Integer osbbId;
    private String name;
    private String description;
    private UserRegistrationDTO creator;
    private String address;
    private String district;
    private Attachment logo;
    private Timestamp creationDate;
    private boolean available;


    public Integer getOsbbId() {
        return osbbId;
    }

    public void setOsbbId(Integer osbbId) {
        this.osbbId = osbbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRegistrationDTO getCreator() {
        return creator;
    }

    public void setCreator(UserRegistrationDTO creator) {
        this.creator = creator;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Attachment getLogo() {
        return logo;
    }

    public void setLogo(Attachment logo) {
        this.logo = logo;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
