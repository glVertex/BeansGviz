/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.fourcode.BeansGviz;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author minaev
 */
public class ActuatorBeans {
    Map<String, Context> contexts;
    
    public void printGraphviz(Function<String, PrintStream> outStreamProvider)
        throws Exception {
        for(var e : contexts.entrySet()){
            var name = e.getKey();
            var beans = e.getValue();
            var out = outStreamProvider.apply(name);
            out.println("digraph "+name+" {");

            for(var beanEntry : beans.beans.entrySet()){
                var beanName = beanEntry.getKey();
                var beanData = beanEntry.getValue();
                
                var simpBeanName = Util.simpleName(beanName);

                var beanType = beanData.type
                        .replaceAll("\\.", ".<br/>")
                        .replaceAll("\\$", "\\$<br/>");
                out.print("    \""+simpBeanName+"\"");
                out.print(" [ label = <");
                out.print("<b>"+simpBeanName+"</b><br/>");
                out.print(""+beanType+"");
                out.print(">]");
                out.println();
                beanData.dependencies.forEach(dep->{
                    out.println("    \""+simpBeanName+"\" -> \""
                            +Util.simpleName(dep)+"\"");
                });
            }

            out.println("}");
        }
    }
}
