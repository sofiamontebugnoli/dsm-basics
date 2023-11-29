package it.unibo.mmw.distsys.ejb;
import javax.ejb.Remote;
@Remote
public interface StatelessInterface {
    String getHelloWorld();
}