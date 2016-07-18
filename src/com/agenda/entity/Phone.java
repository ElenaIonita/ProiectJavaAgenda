/*
 * Phone
 */
package com.agenda.entity;

import java.io.Serializable;

/**
 *
 * @author Elena Ionita
 */
public class Phone implements Serializable{
    private String phone;
    public Phone (String phone ) {
        if( phone == null){
	                throw new IllegalArgumentException("You must enter a phone number!");
	  }
        if (!phone.matches("^0\\d+") || phone.length()!=10) {
                        throw new IllegalArgumentException("You must enter a valid phone number!");
        }
    this.phone=phone;
    }
    public String getPhone(){
        return phone;
}
    public void setPhone (String phone ) {
        if( phone == null){
	                throw new IllegalArgumentException("You must enter a phone number!");
	  }
        if (!phone.matches("^0\\d+") || phone.length()!=10) {
                        throw new IllegalArgumentException("You must enter a valid phone number!");
        }
    this.phone=phone;
    }
       @Override
    public String toString() {
        return "Mobile No.: "+ phone;
    }
    @Override
    public boolean equals(Object obj) {
        return (phone.equals(((Phone) obj).getPhone()));
    }
   }
