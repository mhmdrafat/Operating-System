package javaapplication1;

import java.io.*;
import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {
        Parser a = new Parser();
        Terminal t = new Terminal();
        while (true) {
            
            String in;
            Scanner sc = new Scanner(System.in);
            in = sc.nextLine();
            
            if (a.parse(in)) {
                try {
                    if (a.getCmd().equals("exit")) {
                        break;
                    } else if (a.getCmd().equals("ls")) {
                        t.ls();
                    } else if (a.getCmd().equals("cd")) {
                        t.cd(a.getArgs()[0]);
                    } else if (a.getCmd().equals("mkdir")) {
                        t.mkdir(a.getArgs()[0]);
                    } else if (a.getCmd().equals("pwd")) {
                        t.pwd();
                    } else if (a.getCmd().equals("rmdir")) {
                        t.rmdir(a.getArgs()[0]);
                    } else if (a.getCmd().equals("cat")) {
                        t.cat(a.getArgs()[0]);
                    } else if (a.getCmd().equals("cp")) {
                        t.cp(a.getArgs()[0],a.getArgs()[1]);
                    } else if (a.getCmd().equals("mv")) {
                        t.mv(a.getArgs()[0],a.getArgs()[1]);
                    } else if (a.getCmd().equals("rm")) {
                        t.rm(a.getArgs()[0]);
                    }

                } catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("error");
                }
            }
        }
    }
}
