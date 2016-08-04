package com.softserve.osbb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by cavayman on 05.07.2016.
 */
@Entity
@Table(name = "house")
public class House {
    public static final House EMPTY_HOUSE = new House();
    private Integer houseId;
    private String city;
    private String street;
    private String zipCode;
    private Collection<Apartment> apartments = new ArrayList<>();
    private Osbb osbb;

    public House() {
        //default
    }

    public House(String street) {
        this.street = street;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String address) {
        this.street = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @OneToMany(mappedBy = "house",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    public Collection<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Collection<Apartment> appartaments) {
        this.apartments = appartaments;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "osbb_id", referencedColumnName = "osbb_id")
    public Osbb getOsbb() {
        return osbb;
    }

    public void setOsbb(Osbb osbb) {
        this.osbb = osbb;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", osbb=" + osbb +
                '}';
    }
}
