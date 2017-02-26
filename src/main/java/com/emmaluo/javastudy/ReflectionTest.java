package com.emmaluo.javastudy;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by zcluo on 2017/2/26.
 */
public class ReflectionTest {
    public static void main(String[] args){

        String name;
        if(args.length > 0){
            name = args[0];
        }
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }
        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if(supercl != null && supercl != Object.class) System.out.print(" extends " + supercl.getName());
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors){
            String name = constructor.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if(modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = constructor.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++){
                if(j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for(Method m: methods){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++){
                if(j > 0)System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");

        }

    }
    private static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields){
            Class type = field.getType();
            String name = field.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length() > 0)System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }

    }
}
