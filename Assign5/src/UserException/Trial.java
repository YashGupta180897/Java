package UserException;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

/**
 * Created by yash.gupta on 7/5/2019.
 */
public class Trial {

    public void meth() throws
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number:");
        int x=sc.nextInt();
        if(x<0)
        {
            try {
                throw new UserDefined("User Defined Exception caught");
            }
            catch(UserDefined u)
            {
                System.out.print(u.getMessage());
            }
        }
    }
    public static void main(String args[]) {
        Trial t = new Trial();
        t.meth();

    }
}
