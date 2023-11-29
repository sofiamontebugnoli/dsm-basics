package it.unibo.mmw.distsys.ejb;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface SingletonInterface {
    List<String> getStates(String country);

    void setStates(String country, List<String> states);
}