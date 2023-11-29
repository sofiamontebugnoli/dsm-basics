package it.unibo.mmw.distsys;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;

import it.unibo.mmw.distsys.ejb.HelloWorld;
import it.unibo.mmw.distsys.ejb.StatefulInterface;
import it.unibo.mmw.distsys.ejb.SingletonInterface;

public class App {
    public Context context=null;

    public App() {
    }

    public static void main(String[] args) {
        App app = new App();
        String variabile = "";
        //test stateless bean HELLOWORLD
        try {
            // 1. Obtaining Context
            app.createInitialContext();
            // 2. Generate JNDI Lookup name and caste
            HelloWorld statelessInterface= (HelloWorld) app.context.lookup("ejb:/dsm-ex1//HelloWorld!it.unibo.mmw.distsys.ejb.HelloWorld");
            variabile = statelessInterface.getHelloWorld();
        } catch (NamingException e) {
            e.printStackTrace();
            variabile = "";
        } finally {
            try {
                app.closeContext();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        System.out.println(variabile);

        //test stateful bean HELLOWORLD
        int getNumberOfTimes=0; 
        try {
            // 1. Obtaining Context
            app.createInitialContext();
            // 2. Generate JNDI Lookup name and caste
            StatefulInterface statefulInterface= (StatefulInterface) app.context.lookup("ejb:/dsm-ex1//StatefulInterface!it.unibo.mmw.distsys.ejb.StatefulInterface");
            variabile = statefulInterface.getHelloWorld();
            getNumberOfTimes= statefulInterface.howManyTimes();
        } catch (NamingException e) {
            e.printStackTrace();
            variabile = "";
        } finally {
            try {
                app.closeContext();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        System.out.println(variabile);
        System.out.println(getNumberOfTimes);

        //test singleton bean states-countries
        ArrayList<String> country = new ArrayList<>();
        try {
            // 1. Obtaining Context
            app.createInitialContext();
            // 2. Generate JNDI Lookup name and caste
            SingletonInterface singletonInterface= (SingletonInterface) app.context.lookup("ejb:/dsm-ex1//SingletonInterface!it.unibo.mmw.distsys.ejb.SingletonInterface");
            country= singletonInterface.getStates("UnitedStates");
            
        } catch (NamingException e) {
            e.printStackTrace();
            variabile = "";
        } finally {
            try {
                app.closeContext();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("List of the states in the United States" + country.toString());
    }


    public void createInitialContext() throws NamingException {
        Properties prop = new Properties();
        prop.put(Context.INITIAL_CONTEXT_FACTORY,
                org.wildfly.naming.client.WildFlyInitialContextFactory.class.getName());
        prop.put(Context.PROVIDER_URL, "remote+http://192.168.17.50:8080/");

        this.context = new InitialContext(prop);
    }

    public void closeContext() throws NamingException {
        if (context != null) {
            context.close();
        }
    }

}