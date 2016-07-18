/*
 * File handler.
 */
package com.agenda.filecontrol;

import com.agenda.entity.Subscriber;
import java.io.File;
import java.util.List;

/**
 *
 * @author Elena Ionita
 */
public class FileHandler {
    
/**
 * Static method that returns all the <tt>Subscriber</tt> type data from the file
 *
 * @return  Returns a Subscriber list with the data from the file
 *
 */
   public static List<Subscriber> readFile(File file){
       FileReader fileReader = new FileReader(file);
       Thread readThread = new Thread(fileReader);
       readThread.start();
       while(readThread.isAlive()){
       }
       return fileReader.getListSubscribers();
    }

    public static void writeFile(File saveFile, List<Subscriber> listSubscribers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
    
