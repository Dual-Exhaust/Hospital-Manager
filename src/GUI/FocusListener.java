package GUI;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.LinkedList;

import People.*;
import javax.swing.*;


public class FocusListener implements WindowFocusListener{

    private JList list = new JList();
    private LinkedList<Person> listModel;
    private JScrollPane scrollPane;

    public FocusListener(){

    }

    /*
    This constructor takes in our JList, LinkedList and scrollPane from the HomeMenu
    It sets our local class variables to point towards those objects so we can manipulate them directly
     */
    public FocusListener(JList list, LinkedList listModel, JScrollPane scrollPane){
        this.list = list;
        this.listModel = listModel;
        this.scrollPane = scrollPane;
    }


    /*
    This runs when the HomeMenu gains focus
    It takes our JList and replaces it with a new JList that is built with our LinkedList
    When we press add in the NewPerson window the LinkedList gets updated - that happens ~before this code runs
    It still does catch a NullPointer exception at certain points but I'm not sure why, it does update the
    list on the screen though
     */
    @Override
    public void windowGainedFocus(WindowEvent windowEvent) {
        //System.out.println(windowEvent);
        try {
            this.list = new JList(listModel.toArray());
            this.scrollPane.setViewportView(this.list);
        }
        catch(Exception e){
            System.err.println("Error Time");
            //e.printStackTrace();
        }
    }


    /*
    This is about the same as windowGainedFocus but only for when HomeMenu loses focus
     */
    @Override
    public void windowLostFocus(WindowEvent windowEvent) {
        //System.out.println(windowEvent);
        try {
            this.list = new JList(listModel.toArray());
            this.scrollPane.setViewportView(this.list);
        }
        catch(Exception e){
            System.err.println("Error Time");
            //e.printStackTrace();
        }
    }
}
