package com.dee.webdee.model.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dee.webdee.enumeration.core.Gender;
import com.dee.webdee.enumeration.core.UserTitle;
import com.dee.webdee.model.AuditModel;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "address")
@NamedQueries({
    @NamedQuery(name = "findAddressByOwner", query = "FROM AddressModel WHERE owner = :owner"),
    @NamedQuery(name = "findAddressByOwnerInBookAndType", 
           query = "FROM AddressModel WHERE owner = :owner AND visibleInAddressBook = 1 AND shippingAddress = :shipping AND billingAddress = :billing AND contactAddress = :contact"),
    @NamedQuery(name = "findAddressAddressByOwnerAndInBook", 
           query = "FROM AddressModel WHERE owner = :owner AND visibleInAddressBook = :inBook"),
})
public class AddressModel extends AuditModel {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "owner")
    private long owner;
    
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "fax", length = 15)
    private String fax;

    @Column(name = "title", length = 6)
    @Enumerated(EnumType.STRING)
    private UserTitle title = UserTitle.None;
    
    @Column(name = "gender", length = 6)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.None;
    
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "cellphone", length = 15)
    private String cellphone;

    @Column(name = "phone1", length = 15)
    private String phone1;

    @Column(name = "phone2", length = 15)
    private String phone2;
    
    // Working
    
    @Column(name = "building", length = 50)
    private String building;

    @Column(name = "appartment", length = 50)
    private String appartment;

    @Column(name = "company", length = 50)
    private String company;
    
    // Location ----------------

    @Column(name = "street_name", length = 100)
    private String streetName;

    @Column(name = "street_number", length = 20)
    private String streetNumber;

    @Column(name = "town", length = 100)
    private String town;

    @Column(name = "district", length = 100)
    private String districtName;

    @Column(name = "city", length = 100)
    private String cityName;

    @Column(name = "country", length = 100)
    private String countryName;

    @Column(name = "websites", length = 512)
    private String websites;
    
    @Column(name = "is_shipping_address")
    private boolean shippingAddress = Boolean.FALSE;

    @Column(name = "is_builling_address")
    private boolean billingAddress = Boolean.FALSE;

    @Column(name = "is_contact_address")
    private boolean contactAddress = Boolean.TRUE;

    @Column(name = "is_home_address")
    private boolean homeAddress = Boolean.FALSE;

    @Column(name = "is_office_address")
    private boolean officeAddress = Boolean.FALSE;

    @Column(name = "is_visible_in_address_book")
    private boolean visibleInAddressBook = Boolean.TRUE;
    
    @Column(name = "active")
    private boolean active = Boolean.TRUE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public UserTitle getTitle() {
        return title;
    }

    public void setTitle(UserTitle title) {
        this.title = title;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    public boolean isShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(boolean shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public boolean isBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(boolean billingAddress) {
        this.billingAddress = billingAddress;
    }

    public boolean isContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(boolean contactAddress) {
        this.contactAddress = contactAddress;
    }

    public boolean isVisibleInAddressBook() {
        return visibleInAddressBook;
    }

    public void setVisibleInAddressBook(boolean visibleInAddressBook) {
        this.visibleInAddressBook = visibleInAddressBook;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(boolean homeAddress) {
        this.homeAddress = homeAddress;
    }

    public boolean isOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(boolean officeAddress) {
        this.officeAddress = officeAddress;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }
    
    
}
