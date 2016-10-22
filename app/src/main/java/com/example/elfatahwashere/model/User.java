package com.example.elfatahwashere.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by CR055 on 20-Jul-16.
 */
public class User extends RealmObject {

    @PrimaryKey
    private String id;
    @SerializedName("api_id")
    private String apiId;
    @SerializedName("group_type")
    private int groupType;
    private String username;
    private String email;
    private String slug;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String name;
    private String about;
    @SerializedName("date_of_birth")
    private String dateOfBirth;
    @SerializedName("identity_id")
    private String identityId;
    private String phone;
    private String active;
    @SerializedName("invoice_id")
    private String invoiceId;
    @SerializedName("ticket_id")
    private String ticketId;
    @SerializedName("ticket_type")
    private String ticketType;
    private String barcode;
    @SerializedName("log_in_count")
    private int logInCount;
    @SerializedName("current_log_in_at")
    private String currentLogInAt;
    @SerializedName("last_log_in_at")
    private String lastLogInAt;
    @SerializedName("current_log_in_ip")
    private String currentLogInIp;
    @SerializedName("last_log_in_ip")
    private String lastLogInIp;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getLogInCount() {
        return logInCount;
    }

    public void setLogInCount(int logInCount) {
        this.logInCount = logInCount;
    }

    public String getCurrentLogInAt() {
        return currentLogInAt;
    }

    public void setCurrentLogInAt(String currentLogInAt) {
        this.currentLogInAt = currentLogInAt;
    }

    public String getLastLogInAt() {
        return lastLogInAt;
    }

    public void setLastLogInAt(String lastLogInAt) {
        this.lastLogInAt = lastLogInAt;
    }

    public String getCurrentLogInIp() {
        return currentLogInIp;
    }

    public void setCurrentLogInIp(String currentLogInIp) {
        this.currentLogInIp = currentLogInIp;
    }

    public String getLastLogInIp() {
        return lastLogInIp;
    }

    public void setLastLogInIp(String lastLogInIp) {
        this.lastLogInIp = lastLogInIp;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
