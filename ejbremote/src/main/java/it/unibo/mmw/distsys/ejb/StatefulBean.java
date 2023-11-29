package it.unibo.mmw.distsys.ejb;

import javax.ejb.Stateful;

@Stateful(name = "StatefulInterface")
public class StatefulBean implements StatefulInterface {

    private int howManyTimes = 0;

    public int howManyTimes() {
        return howManyTimes;
    }

    public String getHelloWorld() {
        howManyTimes++;
        return "This is a Stateful Bean";
    }
}
