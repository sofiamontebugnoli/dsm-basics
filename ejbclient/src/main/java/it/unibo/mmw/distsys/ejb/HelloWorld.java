package it.unibo.mmw.distsys.ejb;
import javax.ejb.Remote;

@Remote
public interface HelloWorld {
    String getHelloWorld();
}