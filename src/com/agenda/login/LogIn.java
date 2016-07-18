/* 
*User Log In
 */
package com.agenda.login;

/**
 *
 * @author Elena Ionita
 */
public class LogIn {
private final boolean registred=false;  
private final String password="target"; 

    public boolean register(String password) throws IllegalArgumentException{
    
       if( password == null || password.length()==0){
	                throw new IllegalArgumentException("You must enter the password!");
       }
       if ( !password.matches("targets")){
            throw new IllegalArgumentException("Invalid password!");
       }
    return registred;

 }   
    public boolean isRegistered() {
        return registred;
}
}
    