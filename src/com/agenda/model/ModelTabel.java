/*
* Model tabel.
 */
package com.agenda.model;

import com.agenda.entity.Subscriber;
import com.agenda.types.OrderTypes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Elena Ionita
 */

public abstract class ModelTabel extends AbstractTableModel {

    
private List<Subscriber>listSubscribers=new ArrayList<>();

private Comparator<Subscriber> byFirstName =new Comparator<Subscriber>(){
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
    return o1.getFirstName().toLowerCase().compareTo(o2.getFirstName().toLowerCase());
    }
};

private Comparator<Subscriber>byLastName=new Comparator<Subscriber>(){
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
    return o1.getLastName().toLowerCase().compareTo(o2.getLastName().toLowerCase());            
    }
};

private final Comparator<Subscriber>byCnp=new Comparator<Subscriber>(){
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
    return o1.getCnp().compareTo(o2.getCnp());
    }
};
private Comparator<Subscriber>byPhone=new Comparator<Subscriber>(){
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
    return (Integer.parseInt(o1.getMobileNumber().getPhone())-Integer.parseInt(o2.getMobileNumber().getPhone()));
    }
    };

public ModelTabel(List<Subscriber>listSubscribers) {
    this.listSubscribers=listSubscribers;
}

public List<Subscriber>orderBy(OrderTypes orderType){
   
    switch(orderType){
       case BY_FIRSTNAME:
           Collection.sort(listSubscribers,byFirstName);
           return listSubscribers;
       case BY_LASTNAME:
           Collection.sort(listSubscribers,byLastName);
           return listSubscribers;
       case BY_CNP:
           Collection.sort(listSubscribers,byCnp);
           return listSubscribers;
       case BY_PHONE_NUMBER:
           Collection.sort(listSubscribers,byPhone);
           return listSubscribers;
       default:return listSubscribers;
    }   
    
} 
@Override
public int getRowCount(){
    return listSubscribers.size();
}
@Override
public int getColumnCount(){
    return 5;
}
@Override
public String getColumnName(int column) {
    return new String[]{"Index","First name", "Last name", "CNP","Mobile No."}[column];
}

public List<Subscriber>getListSubscribers(){
    return listSubscribers;
}

public void setListSubscribers(List<Subscriber>listSubscribers){
    this.listSubscribers=listSubscribers;
    fireTableDataChanged();
}
                   
}
