package FunctionsAndArrays;

import java.util.Scanner;

//Functions And Arrays
// (1) Functions
public class FunctionAndArrays
 {
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);

        // int n=sc.nextInt();
        // int d=sc.nextInt();
        // int ans=getDigitFrequency(n, d);
        // System.out.println(ans);

        // int n=sc.nextInt();
        // int b=sc.nextInt();
        // int ans=AnyBaseToDecimal(n, b);
        // System.out.println(ans);

        // int n=sc.nextInt();
        // int b1=sc.nextInt();
        // int b2=sc.nextInt();
        // int ans=AnyBaseToAnyBase(n,b1,b2);
        // System.out.println(ans);

        // int n1=sc.nextInt();
        // int n2=sc.nextInt();
        // int b=sc.nextInt();
        // // int ans=AnyBaseAddition(n1,n2,b);
        // // int ans=AnyBaseSubtraction(n1,n2,b);
        // int ans=AnyBaseMultiplication(n1,n2,b);
        // System.out.println(ans);

        SpanOfAnArray();
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

    //3) Any Base To Decimal
    public static int AnyBaseToDecimal(int n,int b)
    {
        int ans=0;
        int pow=1;
        while(n>0)
        {
            int rem = n%10;
            n=n/10;
            ans += rem * pow;
            pow = pow * b;
        }
        return ans;
    }

    //4) Any Base to Any Base
    public static int AnyBaseToAnyBase(int n,int b1,int b2)
    {
        int atd = AnyBaseToDecimal(n, b1);
        int dta= DecimalToAnyBase(atd, b2);
        return dta;
    }

    // 5) Any Base Addition
    public static int AnyBaseAddition(int n1,int n2,int b)
    {
        int ans=0;
        int c=0;
        int pow=1;
        while(n1>0 || n2>0 || c>0)
        {
            int r1= n1 % 10;
            int r2= n2 % 10;
            n1=n1/10;
            n2=n2/10;
            int totalRemPlusCarrySum = r1 + r2 + c;
            int finalRemValue = totalRemPlusCarrySum % b;
            c = totalRemPlusCarrySum/b;
            ans += finalRemValue*pow;
            pow = pow*10;
        }
        return ans;
    }

    //6) Any Base Subtraction
    public static int AnyBaseSubtraction(int n1,int n2,int b)
    {
        int ans=0;
        int c=0;
        int pow=1;
        while(n2>0)
        {
            int r1= n1 % 10;
            int r2= n2 % 10;
            n1=n1/10;
            n2=n2/10;
            
            int d=0;
            r2 = r2+c;
            if(r2>=r1)
            {
                c=0;
                d=r2-r1;
            }
            else{
                c=-1;
                d= r2+ b - r1;
            }
            ans += d*pow;
            pow = pow*10;
        }
        return ans;
    }

    //6) Any Base Multiplication
    public static int AnyBaseMultiplication(int n1,int n2,int b)
    {
        int rv=0;
        int pow=1;
        while(n2>0)
        {
            int d2= n2%10;
            n2 = n2/10;

            int sprd = getProductWithSingleDigit(b, n1, d2);
            rv = AnyBaseAddition(rv,sprd*pow, b);
            pow=pow*10;
        }
        return rv;
    }
    public static int getProductWithSingleDigit(int b,int n1,int d2)
    {
        int rv=0;
        int c=0;
        int pow=1;

        while(n1 > 0 || c > 0)
        {
            int d1=n1 % 10;
            n1= n1/10;

            int d= d1*d2 + c;

            d= d%b;
            c = d/b;

            rv += d*pow;
            pow= pow*10;
        }
        return rv;
    }

    //Arrays
    //Span of an array
    public static void SpanOfAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])
            {
                max=arr[i];
            }
        }

        int min=arr[0];
         for(int i=0;i<arr.length;i++){
            if(min>arr[i])
            {
                min=arr[i];
            }
        }

        int span=max-min;
        System.out.println(span);
    }
}
