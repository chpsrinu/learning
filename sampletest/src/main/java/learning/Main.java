package learning;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {
            //Please provide your implementation here
    	String[] inp = new String[]{"DEPEND TELNET TCPIP NETCARD",
    			"DEPEND TCPIP NETCARD",
    			"DEPEND DNS TCPIP NETCARD",
    			"DEPEND BROWSER TCPIP HTML",
    			"INSTALL NETCARD",
    			"INSTALL TELNET",
    			"INSTALL foo",
    			"REMOVE NETCARD",
    			"INSTALL BROWSER",
    			"INSTALL DNS",
    			"LIST",
    			"REMOVE TELNET",
    			"REMOVE NETCARD",
    			"REMOVE DNS",
    			"REMOVE NETCARD",
    			"INSTALL NETCARD",
    			"REMOVE TCPIP",
    			"REMOVE BROWSER",
    			"REMOVE TCPIP",
    			"END"};
    	for(String line : inp)
            softwareDependency(line);
     }
    
    enum COMMAND {DEPEND, INSTALL, REMOVE, LIST, END}
    
    static class Software {
        private String name;
        private List<Software> dependencies;
        
        Software(String name) {
            this.name = name;
            dependencies = new ArrayList<>();
        }
        
        String getName() {
            return name;   
        }
        
        List<Software> getDependencies() {
            return dependencies;
        }
        
        void addDependencies(Software dependency) {
            this.dependencies.add(dependency);
        }
        
        public String toString() {
            return this.name;
        }
        
        public boolean equals(Object o) {
            if(this==o) {
                return true;
            }
            
            if(!(o instanceof Software)) {
                return false;
            }
            
            Software software = (Software)o;
            return Objects.equals(name, software.name);
        }
        
        public int hashCode() {
            return Objects.hash(name);
        }
        
    }
    
    private static Map<String, Software> allSoftware = new HashMap<>();
    private static List<Software> installedSoftware = new ArrayList<>();
    
    static void softwareDependency(String line) {
        System.out.println(line);
        
        final String[] commandTokens = line.split("\\s+");
        final String commandString = commandTokens[0];
        final COMMAND command = COMMAND.valueOf(commandString);
        
        switch(command) {
            case DEPEND:
                final String softwareName = commandTokens[1];
                buildDependencies(softwareName, commandTokens);
                break;
            case INSTALL:
                final Software softwareToBeInstalled = getSoftware(commandTokens[1]);
                if (isAlreadyInstalled(softwareToBeInstalled)) {
                    System.out.println(softwareToBeInstalled + " is already installed");
                } else {
                    //install
                    final List<Software> softwareDependenciesToBeInstalled = softwareToBeInstalled.getDependencies();
                    for(Software softwareDependency : softwareDependenciesToBeInstalled) {
                        if(!isAlreadyInstalled(softwareDependency)) {
                            install(softwareDependency);
                        }
                    }
                    install(softwareToBeInstalled);
                }
                break;
            case REMOVE:
                final Software softwareToBeRemoved = getSoftware(commandTokens[1]);
                if(!isAlreadyInstalled(softwareToBeRemoved)) {
                    System.out.println(softwareToBeRemoved + " is not installed");
                }
                else if(canRemoveSoftware(softwareToBeRemoved)) {
                    System.out.println("Removing " + softwareToBeRemoved);
                    installedSoftware.remove(softwareToBeRemoved);
                    
                    final List<Software> currentSoftwareDependencies = softwareToBeRemoved.getDependencies();
                    for(Software dependency : currentSoftwareDependencies) {
                        if (canRemoveSoftware(dependency)) {
                            System.out.println("Removing+++ " + dependency);
                            installedSoftware.remove(dependency);
                        }
                    }
                } else {
                    System.out.println(softwareToBeRemoved + " is still needed");
                }
                break;
            case LIST:
                for (Software installedSoftware : installedSoftware) {
                    System.out.println(installedSoftware);
                }
                break;
            case END:
                break;    
        }       
    }
    
    private static void install(Software software) {
        System.out.println("Installing " + software);
        installedSoftware.add(software);
    }
    
    private static boolean isAlreadyInstalled(Software softwareToBeInstalled) {
        return installedSoftware.contains(softwareToBeInstalled);
    }
    
    private static void buildDependencies(String softwareName, String[] commandTokens) {
        for (int i =2;i<commandTokens.length;i++) {
            final String currentDependency = commandTokens[i];
            final List<Software> dependenciesOfdependency = getSoftware(currentDependency).getDependencies();
            
            if(dependenciesOfdependency != null && dependenciesOfdependency.contains(getSoftware(softwareName))) {
                System.out.println(currentDependency + " depends on " + softwareName + ", ignoring command");
            } else {
                getSoftware(softwareName).addDependencies(getSoftware(currentDependency));
            }
        }
    }
    
    private static Software getSoftware(String name) {
        Software software = allSoftware.get(name);
        if (software == null) {
            software = new Software(name);
            allSoftware.put(name, software);
        } 
        return software;
    }
    
    private static boolean canRemoveSoftware(Software softwareToBeRemoved) {
        for (Software installedSoftware : installedSoftware) {
            final List<Software> requiredDependencies = installedSoftware.getDependencies();
            if (requiredDependencies != null) {
                for (Software dependency : requiredDependencies) {
                    if (softwareToBeRemoved.equals(dependency)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}