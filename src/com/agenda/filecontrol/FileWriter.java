/*
 * File .
 */
package com.agenda.filecontrol;

import com.agenda.entity.Subscriber;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Elena Ionita
 */
public class FileWriter implements Runnable {
 
    private File file;
    private List<Subscriber> listSubscribers = new ArrayList<>();

/**
 * Creates  new <tt>FileWriter</tt> instance from given <tt>File</tt> and <tt>Subscriber</tt>
 * @param file The file where to write the <tt>Subscriber</tt> list
 * @param listSubscribers The <tt>Subscriber</tt> list to be written
 */
    public FileWriter(File file, List<Subscriber> listSubscribers){
        this.file = file;
        this.listSubscribers = listSubscribers;
    }

/**
 * Create an OutputStream to the file. Write the Serialized date to the file.
 */

@Override
        public void run(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            objectOutputStream.writeObject(listSubscribers);
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            objectOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fileOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
/**
 * Getter method that returns the written file
 * @return Return the File where the date is written.
 */

public File getFile() {
        return file;
    }
    

/**
 * Setter method for the written file
 * @param file 
 *          the File where the data is written.
 */
public void setFile(File file) {
        this.file = file;
    }
    

/**
 * Getter method that return the <tt>Abonat</tt> list that is written to the file.
 * @return Return the <tt>Abonat</tt> list that is written to the file.
 */
public List<Subscriber> getListSubscribers() {
        return listSubscribers;
    }
/**
 * Setter method for the data that is written to the file.
 * @param listSubscribers
 *              The data that is written to the file.
 */
    public void setListSubscribers (List<Subscriber> listSubscribers) {
        this.listSubscribers = listSubscribers;
    }  

//    @Override
//    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
