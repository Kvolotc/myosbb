package com.softserve.osbb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Roman on 05.07.2016.
 */
@Entity
@Table(name = "osbb")
public class Osbb implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer osbbId;
    private String name;
    private String description;
    private Street street;
    private String houseNumber;
    private District district;
    private String districtStr;
    private Boolean available= true;
    private Attachment logo;
    private Timestamp creationDate;
    private User creator;
    private Collection<Contract> contracts;
    private Collection<Event> events;
    private Collection<House> houses;
    private Collection<Report> reports;
    private Collection<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "osbb_id")
    public Integer getOsbbId() {
        return osbbId;
    }

    public void setOsbbId(Integer osbbId) {
        this.osbbId = osbbId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "street", referencedColumnName = "id")
        public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
        public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Basic
    @Column(name = "house_number")
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Basic
    @Column(name = "district")
    public String getDistrictStr() {
        return districtStr;
    }

    public void setDistrictStr(String districtStr) {
        this.districtStr = districtStr;
    }

    @Column(name = "available", columnDefinition = "boolean default true", nullable = false)
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @OneToOne(optional=true)
    @JoinColumn(name = "logo_id", referencedColumnName = "attachment_id")
    public Attachment getLogo() {
        return logo;
    }

    public void setLogo(Attachment logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "creationDate")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @OneToOne(optional=true)
    @JoinColumn(name = "creator_id", referencedColumnName = "user_id")
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @OneToMany(mappedBy = "osbb", cascade = CascadeType.REMOVE)
    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToMany(mappedBy = "osbb", cascade = CascadeType.REMOVE)
    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }

    @OneToMany(mappedBy = "osbb", cascade = CascadeType.REMOVE)
    public Collection<House> getHouses() {
        return houses;
    }

    public void setHouses(Collection<House> houses) {
        this.houses = houses;
    }

    @OneToMany(mappedBy = "osbb", cascade = CascadeType.REMOVE)
    public Collection<Report> getReports() {
        return reports;
    }

    public void setReports(Collection<Report> reports) {
        this.reports = reports;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "osbb", cascade = CascadeType.REMOVE)
    @JsonIgnore
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Osbb{" +
                "osbbId=" + osbbId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", adress='" + houseNumber + '\'' +
                ", district='" + district + '\'' +
                ", dateOfCreation=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
