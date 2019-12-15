package com.sunbelt.testsunbelt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Clase representativa de members
 */

public class Members implements Serializable {

    @SerializedName("MemberId")
    @Expose
    private Integer memberId;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("tier")
    @Expose
    private String tier;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("totalAmountDonated")
    @Expose
    private Integer totalAmountDonated;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("lastTransactionAt")
    @Expose
    private String lastTransactionAt;
    @SerializedName("lastTransactionAmount")
    @Expose
    private Integer lastTransactionAmount;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private Object company;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("twitter")
    @Expose
    private Object twitter;
    @SerializedName("github")
    @Expose
    private Object github;
    @SerializedName("website")
    @Expose
    private String website;


    public Members(Integer memberId, String createdAt, String type, String role, String tier, Boolean isActive, Integer totalAmountDonated, String currency, String lastTransactionAt, Integer lastTransactionAmount, String profile, String name, Object company, String description, String image, Object email, Object twitter, Object github, String website) {
        this.memberId = memberId;
        this.createdAt = createdAt;
        this.type = type;
        this.role = role;
        this.tier = tier;
        this.isActive = isActive;
        this.totalAmountDonated = totalAmountDonated;
        this.currency = currency;
        this.lastTransactionAt = lastTransactionAt;
        this.lastTransactionAmount = lastTransactionAmount;
        this.profile = profile;
        this.name = name;
        this.company = company;
        this.description = description;
        this.image = image;
        this.email = email;
        this.twitter = twitter;
        this.github = github;
        this.website = website;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getTotalAmountDonated() {
        return totalAmountDonated;
    }

    public void setTotalAmountDonated(Integer totalAmountDonated) {
        this.totalAmountDonated = totalAmountDonated;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLastTransactionAt() {
        return lastTransactionAt;
    }

    public void setLastTransactionAt(String lastTransactionAt) {
        this.lastTransactionAt = lastTransactionAt;
    }

    public Integer getLastTransactionAmount() {
        return lastTransactionAmount;
    }

    public void setLastTransactionAmount(Integer lastTransactionAmount) {
        this.lastTransactionAmount = lastTransactionAmount;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getTwitter() {
        return twitter;
    }

    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    public Object getGithub() {
        return github;
    }

    public void setGithub(Object github) {
        this.github = github;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
