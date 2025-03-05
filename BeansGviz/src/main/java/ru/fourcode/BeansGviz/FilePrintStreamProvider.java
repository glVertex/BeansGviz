/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.fourcode.BeansGviz;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author minaev
 */
public class FilePrintStreamProvider implements Function<String, PrintStream>,
        Closeable {
    private static final Logger log = LoggerFactory.getLogger(
            FilePrintStreamProvider.class
    );
    
    private PrintStream currentPrintStream;
    private File baseFile;
    boolean fileByContext = false;

    public FilePrintStreamProvider(File baseFile) {
        this.baseFile = baseFile;
        if(baseFile.exists() && baseFile.isDirectory()){
            fileByContext = true;
        }
    }
    
    
    @Override
    public PrintStream apply(String contextName) {
        if(fileByContext && currentPrintStream!=null){
            currentPrintStream.close();
        }
        
        try {
            if(fileByContext){
                currentPrintStream = new PrintStream(
                    new File(baseFile, contextName+".gv")
                );
            }else{
                if(currentPrintStream == null){
                    currentPrintStream = new PrintStream(baseFile);
                }
            }
        } catch (FileNotFoundException ex) {
            log.error("cant out file creating", ex);
        }
        
        return currentPrintStream;
    }

    @Override
    public void close() throws IOException {
        if(currentPrintStream != null){
            currentPrintStream.close();
        }
    }
    
}
