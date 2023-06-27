package FunctionsAndArrays;

import java.util.Scanner;

public class FunctionAndArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int ans=getDigitFrequency(n, d);
        System.out.println(ans);
    }

    // 1) Digit Frequency
    public static int getDigitFrequency(int n,int d)
    {
        int count=0;

        while(n>0)
        {
            int rem=n%10;
            n=n/10;

            if(rem==d)
            {
                count++;
            }
        }

        return count;
    }
}
