/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.*;

public class Parser {

String []args;
String cmd;

    public Parser() {
        this.args =new String[2];
        args[0]="";
        args[1]="";
        this.cmd = "";
    }

public boolean parse (String input)
{
    StringTokenizer s=new StringTokenizer(input," ");
        cmd=s.nextToken();
        //System.out.println(cmd);
        //noargs
    if(cmd.equals("exit")||cmd.equals("ls")||cmd.equals("pwd"))return true;
    if(cmd.equals("cd")||cmd.equals("mv")||cmd.equals("rm")||cmd.equals("cat")||cmd.equals("cp")||cmd.equals("mkdir")||cmd.equals("rmdir"))
    {
        
        String k=new String("");
        if(s.hasMoreTokens())
                k+=s.nextToken();
        int i=k.length(),c=k.length();
        if(k.indexOf("root",0)!=-1)
        {
            i=k.indexOf("root",0);
            c=i+4;
        }
        args[0]=k.substring(0,i);
        args[1]=k.substring(c,k.length());
        if((cmd.equals("mv")||cmd.equals("cp"))&&(args[0].equals("")||args[1].equals("")))
        {
            System.out.println("few arguments");
            return false;
        }
        if((cmd.equals("rm")||cmd.equals("cat")||cmd.equals("mkdir")||cmd.equals("rmdir"))&&args[0].equals(""))
        {
            System.out.println("few arguments");
            return false;
        }
        
        return true;
    }
    System.out.println("unknown command");
        return false;
}
public String getCmd()
{
    return cmd;
}
public String[] getArgs()
{
    return args;
}
}
