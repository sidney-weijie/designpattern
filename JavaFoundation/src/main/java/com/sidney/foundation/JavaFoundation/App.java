package com.sidney.foundation.JavaFoundation;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(System.getProperty("user.dir"));
        System.err.println(System.getProperty("line.separator"));
        
  /*      Map<String,Charset> charsets = Charset.availableCharsets();
        for(Entry<String, Charset> entry:charsets.entrySet()){
        	System.out.println(entry.getKey());
        }*/
        Path path = Paths.get("/app", "front","risk-front-service");
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
    }
}
