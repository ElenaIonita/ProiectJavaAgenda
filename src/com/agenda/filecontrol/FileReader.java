/*
 * File reader.
 */
package com.agenda.filecontrol;

import com.agenda.entity.Subscriber;
import com.agenda.entity.Phone;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Elena Ionita
 */
public class FileReader implements Runnable{

      private File file;
      private final List<Subscriber> listSubscribers = new ArrayList<>();

/**
 * Creates  new <tt>FileReader</tt> instance from given <tt>File</tt>
 * @param file The read file.
 */
    public FileReader(File file){
        this.file = file;
    }


/**
 * Create an InputStream to the file. Read the Serialized date from the file.
 */
    @Override
    public void run() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listSubscribers.addAll((List<Subscriber>)objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            objectInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
/**
 * Getter method that returns the read file
 * @return Return the read file
 */
    public File getFile() {
        return file;
    }
    
/**
 * Setter method for the read file
 * @param file 
 *          the read file
 */
    public void setFile(File file) {
        this.file = file;
    }
    
/**
 * Getter method that return the <tt>Subscriber</tt> list that read from the file.
 * @return Return the <tt>Subscriber</tt> list that is read from the file.
 */
    public List<Subscriber> getListSubscribers() {
        return listSubscribers;
    }
}  
