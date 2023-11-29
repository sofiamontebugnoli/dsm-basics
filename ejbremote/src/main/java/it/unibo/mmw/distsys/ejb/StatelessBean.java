package it.unibo.mmw.distsys.ejb;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "StatelessInterface")
public class StatelessBean implements StatelessInterface {

    @Resource
    private SessionContext context;

    @Override
    public String getHelloWorld() {
        return "This is a Stateless Bean";
    }

    
}