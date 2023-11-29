package it.unibo.mmw.distsys.ejb;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface SingletonInterface {
    ArrayList<String> getStates(String country);
    void setStates(String country, ArrayList<String> states);
}