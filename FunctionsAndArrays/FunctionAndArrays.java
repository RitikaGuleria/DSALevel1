package FunctionsAndArrays;

import java.util.Scanner;

public class FunctionAndArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int d=sc.nextInt();
        // int ans=getDigitFrequency(n, d);
        // System.out.println(ans);

        int n=sc.nextInt();
        int b=sc.nextInt();
        int ans=DecimalToAnyBase(n, b);
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
    //Number system questions
    //2 ) Decimal to any Base
    public static int DecimalToAnyBase(int n, int b)
    {
        int ans=0;
        int pow=1;
        while(n>0)
        {
            int rem = n % b;
            n = n / b;
            ans += rem * pow;
            pow = pow * 10;
        }
        return ans;
    }
}
