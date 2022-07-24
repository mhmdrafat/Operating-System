package javaapplication1;
import java.io.*;
public class Terminal 
{
    String ddp;
    String cdp;
    Terminal()
    {
        ddp=cdp="C:\\Users\\Electronica\\Desktop\\defaultDirectory\\";
    }
    Terminal(String path)
    {
        File f=new File(path);
        if (f.exists())
        ddp=cdp=path;
    }
    public void mkdir (String path)throws IOException
    {
        if(path.contains(":\\")==false)
        {
            path=cdp+path;
        }
        File Dir =new File(path);  
        if(!Dir.exists())
        {
            if(Dir.mkdir())
                System.out.println("directory created");
        }
        else
            System.out.println("directory already exist");
        
    }
    public void cp(String path,String destination)throws IOException
    {
        if(path.contains(":\\")==false)
        {
            path=cdp+path;
        }
        if(destination.contains(":\\")==false)
        {
            destination=cdp+destination;
        }
        BufferedReader read;
        PrintWriter write;
        read= new BufferedReader(new FileReader(path));
        write = new PrintWriter (new FileWriter(destination));
        String line;
        while((line =read.readLine())!=null)
        {
            write.println(line);
        }
        read.close();
        write.close();
    }
    public void cat(String path)throws IOException
    {
        if(path.contains(":\\")==false)
        {
            path=cdp+path;
        }
        BufferedReader read;
        PrintWriter write;
        read= new BufferedReader(new FileReader(path));
        String line;
        while((line =read.readLine())!=null)
        {
            System.out.println(line);
        }
        read.close();
    }
    public void ls()throws IOException
    {
        File f=new File(cdp);
        String[] paths;
        paths=f.list();
        for(String path:paths)
        {
            System.out.println(path);
        }
    }
    public void cd(String path)throws IOException
    {
        //System.out.println(path);
        if(path.equals(""))path=ddp;
        if(path.contains(":\\")==false)
        {
            path=this.cdp+path;
        }
        //System.out.println(path);
        File f=new File(path);
        //System.out.println(f.exists());
        if (f.exists())
        {
            if(path.charAt(path.length()-1)!='\\')
            cdp=path+"\\";
            else
                cdp=path;
        }
        //System.out.println(cdp);
        
    }
    public void rmdir(String path)throws IOException
    {
        if(path.contains(":\\")==false)
        {
            path=cdp+path;
        }
        File f=new File(path);
        File []list=f.listFiles();
        for(File file:list)
        {
            file.delete();
        }
        for(String dir:f.list())
        {
            rmdir(f.getAbsolutePath()+"\\"+dir);
            
        }
        f.delete();
    }
    public void rm (String path)
    {
        if(path.contains(":\\")==false)
        {
            path=cdp+path;
        }
        File f=new File (path);
        if(!f.isDirectory())f.delete();
    }
    public void mv(String path,String destination)throws IOException
    {
        cp(path,destination);
        rm(path);
    }
    public void pwd()
    {
        System.out.println(cdp);
        
    }
}