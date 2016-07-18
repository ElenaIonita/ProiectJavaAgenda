/*
 * Controller CarteDeTelefon
 */
package com.agenda.controller;

import com.agenda.entity.Subscriber;
import com.agenda.exceptions.IdenticalMembersException;
import com.agenda.login.LogIn;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Elena Ionita
 */
public class CarteDeTelefon {
    
  private final File currentFile = null;
  private final List<Subscriber> listSubscribers = new ArrayList<>();
  private final LogIn login = new LogIn();
  

/**
* Public method that evaluates if the registration key is valid.
* @param password
*          The String that is evaluated.
* @return
*          Returns <strong>true</strong> if the password is valid, otherwise returns false.
* @throws NumberFormatException
*/
public boolean register(String password) throws NumberFormatException{
        return login.register(password);
}


/**
* Public method that evaluates if the user is registered.
* @return 
*      Returns <strong>true</strong> if the user is registered, otherwise returns false.
*/
public boolean isRegistered(){
        return login.isRegistered();
}


/**
* Adds a new <tt>Subscriber</tt> to the <tt>List<Subscriber></tt>
* @param  subscriber
*         A instance of <tt>Subscriber</tt>
* @throws  IdenticalMembersException
*          If the given Subscriber exists in the List
* 
*/
public void addSubscriber(Subscriber subscriber) throws IdenticalMembersException, IllegalArgumentException{
        boolean allClear = true;
        for(Subscriber item: listSubscribers){
            if(item.getCnp().equals(subscriber.getCnp())){
                allClear = false;
                throw new IdenticalMembersException("The subscriber already exist! You can modify the registration.");
            }
        }

    }


/**
* Delete a Subscriber from the Subscribers list.
* @param subscriber
*          A instance of <tt>Subscriber</tt>
*/
public void removeSubscriber(Subscriber subscriber){
        listSubscribers.remove(subscriber);
        }


/**
 * Edit the Subscriber from the Subscriber list
 *          The instance of the <tt>Subscriber</tt> that is edited
 * @param newSubscriber
 *          The instance of the <tt>Subscriber</tt> with the new data.
 * @throws IdenticalMembersException 
 */
public void editSubscriber(Subscriber newSubscriber) throws IdenticalMembersException{
        boolean allClear = true;
        for(Subscriber item: listSubscribers){
            if(item.getCnp().equals(newSubscriber.getCnp())){
                if(newSubscriber.getId() != item.getId()){
                    allClear = false;
                    throw new IdenticalMembersException("The subscriber already exist!");
                }
            }
        }
    }


/**
 * Search in the Subscriber list for the content String
 * @param content
 *          The String that is searched for in the Subscriber list
 * @return 
 *          Return an Subscriber with the objects that contain the searched String
 */
public List<Subscriber> search(String content){
        List<Subscriber> temp = new ArrayList<>();
        for(Subscriber subscriber: listSubscribers){
            if(subscriber.getFirstName().toLowerCase().contains(content) || subscriber.getLastName().toLowerCase().contains(content)
                    || Subscriber.getCnp().toLowerCase().contains(content) || subscriber.getMobileNumber().getPhone().toLowerCase().contains(content)){
                temp.add(subscriber);
            }
        }
        return temp;
    }


/**
 * Public method that exports the Subscriber list to the selected file.
 * @param saveFile 
 *          The file where the data is exported.
 */
    public void exportAgenda(File saveFile){
        setCurrentFile(saveFile);
        FileHandler.writeFile(saveFile, this.listSubscribers);
    }
    
    
/**
 * Public method that returns the Subscriber list.
 * @return 
 *      The Subscriber list.
 */
    public List<Subscriber> getListSubscribers() {
        return listSubscribers;
    }
    
    
/**
 * Public method that sets the Subscriber list.
 * @param listSubscribers
 *          The Subscriber list that replace the existent list.
 */
    public void setListSubscribers(List<Subscriber> listSubscribers) {
        this.listSubscribers = listSubscribers;
    }
    
}
