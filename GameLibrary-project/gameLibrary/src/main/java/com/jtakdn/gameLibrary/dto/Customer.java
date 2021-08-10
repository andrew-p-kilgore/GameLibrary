package com.jtakdn.gameLibrary.dto;

public class Customer {

    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String cardNumber;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result
                + ((cardNumber == null) ? 0 : cardNumber.hashCode());
        result = prime * result
                + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result
                + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Customer other = (Customer) obj;
        if (address == null)
        {
            if (other.address != null) return false;
        }
        else
            if (!address.equals(other.address)) return false;
        if (cardNumber == null)
        {
            if (other.cardNumber != null) return false;
        }
        else
            if (!cardNumber.equals(other.cardNumber)) return false;
        if (customerId == null)
        {
            if (other.customerId != null) return false;
        }
        else
            if (!customerId.equals(other.customerId)) return false;
        if (firstName == null)
        {
            if (other.firstName != null) return false;
        }
        else
            if (!firstName.equals(other.firstName)) return false;
        if (lastName == null)
        {
            if (other.lastName != null) return false;
        }
        else
            if (!lastName.equals(other.lastName)) return false;
        if (phoneNumber == null)
        {
            if (other.phoneNumber != null) return false;
        }
        else
            if (!phoneNumber.equals(other.phoneNumber)) return false;
        return true;
    }
    
    
}
