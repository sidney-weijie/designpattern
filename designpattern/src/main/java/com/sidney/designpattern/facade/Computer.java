package com.sidney.designpattern.facade;

public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;
    
    public Computer(){
    	cpu = new CPU();
    	memory = new Memory();
    	disk = new Disk();
    }
    
    public void startup(){
    	System.err.println("start the computer!");
    	cpu.startup();
    	memory.startup();
    	disk.startup();
        System.err.println("start computer finished!");
    }
    
    public void shutdown(){
    	System.err.println("begin to close the computer!");
    	disk.shutdown();
    	memory.shutdown();
    	cpu.shutdown();
    	
    	System.err.println("computer closed!");
    }
    
}
