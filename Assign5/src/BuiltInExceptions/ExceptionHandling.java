package BuiltInExceptions;

import java.util.Objects;
import java.util.Scanner;
import java.io.*;
/**
 * Created by yash.gupta on 7/5/2019.
 */
public class ExceptionHandling {

    public static Scanner sc=new Scanner(System.in);

    private static void arithmetic()
    {
        System.out.println("1.Arithmetic Exception Handling");
        try{
            System.out.println("Enter 2 Numbers");
            int x=sc.nextInt();
            int y=sc.nextInt();
            int result=x/y;
            System.out.println("Division = "+result);   //Executed only when y!=0
        }
        catch(ArithmeticException ae)
        {
            System.out.println(ae.getMessage());
            //ae.printStackTrace();
        }
        finally{
            System.out.println("Code executed in finally");
        }
    }

    private static void array_index()
    {
        System.out.println("2.Array index out of bound handling");
        int[] arr=new int[5];
        System.out.println("Enter 5 array elements:");
        for(int i=0;i<5;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element to access:");
        int index=sc.nextInt();
        try{
            System.out.println(arr[index]);
        }
        catch(ArrayIndexOutOfBoundsException ai)            //Goes into catch block only when index>4
        {
            System.out.println(ai.getMessage());
            //ai.printStackTrace();
        }
        catch(Exception e)                      //general exception object catch
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        System.out.println("Out of the try catch block");
    }
    private static void file_not_found()
    {
        System.out.println("3.File not found exception");
        File file=new File("D:/test.txt");
        try{
            FileReader f=new FileReader(file);

        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
            //ioe.printStackTrace();
        }
       /* catch(FileNotFoundException fn)
        {
            System.out.println(fn.getMessage());
            fn.printStackTrace();
        }
*/
        //No use of this catch as FileNotFoundException is subclass of IOException

        finally{
                System.out.println("Deleted File Reference variable in finally");
                file.delete();
        }
    }

    private static void null_pointer()
    {
        System.out.println("4.Null pointer Exception");
        String a= null;
        try {
            System.out.println(a.charAt(0));
        }
        catch(NullPointerException np)
        {
            System.out.println(np.getMessage());
        }
        finally{
            System.out.println("Null pointer Exception occured!");
        }
    }

    private static void number_format()
    {
        System.out.println("5.Number Format Exception");
        try{
            System.out.println("Enter a number string:");
            String s=sc.next();
            int num=Integer.parseInt(s);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Number Format Exception Found!!");
            System.out.println(nfe.getMessage());
            //nfe.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        arithmetic();
        System.out.println();
        array_index();
        System.out.println();
        file_not_found();
        System.out.println();
        null_pointer();
        System.out.println();
        number_format();

    }
}
