/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.fourcode.BeansGviz;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Function;

/**
 *
 * @author minaev
 */
public class StdoutPrintStreamProvider implements Function<String, PrintStream>,
        Closeable {

    @Override
    public PrintStream apply(String t) {
        return System.out;
    }

    @Override
    public void close() throws IOException {
    }
    
}
