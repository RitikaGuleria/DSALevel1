package GettingStarted;

import java.util.*;

public class GettingStarted 
{
    public static void main(String[] args)
    {
        // GCD&LCM();
    }

    //1) isNumberPrime
    public static void isNumberPrime()
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
       
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int count=0;

            for(int div=1;div<=n;div++){
                if(n%div==0){
                    count++;
                }
            }
            if(count==2){
                System.out.println("Prime");
            }
            else{
                System.out.println("Not Prime");
            }
        }
    }
    //2)  isNumberPrime_optimized
    public static void isNumberPrime_optimized()
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
       
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int count=0;

            for(int div=2;div*div<=n;div++){
                if(n%div==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println("Prime");
            }
            else{
                System.out.println("Not Prime");
            }
        }
    }
    //3) PrintPrimeNmbersTillN
    public static void PrintPrimeNmbersTillN()
    {
        Scanner sc=new Scanner(System.in);
        int low=sc.nextInt();
        int high=sc.nextInt();
       
        for(int n=low;n<high;n++){
            int count=0;

            for(int div=2;div*div<=n;div++){
                if(n%div==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println("Prime -> "+n);
            }
        }
    }
    //4)Fibonacci
    public static void Fibonacci()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=0;
        int b=1;

        for(int i=0;i<=n;i++)
        {
            System.out.println(a);
            int c=a+b;
            a=b;
            b=c;
        }
    }
    //5)CountDigitsInNumber
    public static void CountDigitsInNumber()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int countDigits=0;
        while(n!=0)
        {
            n=n/10;
            countDigits++;
        }
        System.out.println(countDigits);
    }
    //6)DigitsOfANumber
    public static void DigitsOfANumber()
    {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int count=0;
        int temp=number;

        while(temp != 0)
        {
            temp=temp/10;
            count++;
        }
        System.out.println(count);

        int div=(int)Math.pow(10, count-1);
        while(div!=0)
        {
            int q=number/div;
            System.out.println(q);

            number=number%div;
            div=div/10;
        }
    } 
    //7) ReverseOfANumber
    public static void ReverseOfANumber()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0){
            int r=n%10;
            n=n/10;
            System.out.println(r);
        }
    }
    //8)InverseOfANumber
    public static void InverseOfANumber()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int op=1;
        int inv=0;
        while(n!=0)
        {
            int od=n%10;
            int id=op;
            int ip=od;

            inv=inv+id * (int)Math.pow(10, ip-1);

            n = n/10;
            op++ ;
        }
        System.out.println(inv);
    }
    //9) Rotate a number
    public static void RotateANumber()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int div=1;
        int mult=1;
        int nod=0;
        int temp=n;
        while(temp!=0)
        {
            temp=temp/10;
            nod++;
        }
        System.out.println(nod);

        k=k%nod;
        while(k<0)
        {
            k=k+nod;
        }

        for(int i=1;i<=nod;i++)
        {
            if(i<=k)
            {
                div=div*10;
            }
            else{
                mult=mult*10;
            }
        }

        int q=n/div;
        int r=n%mult;

        int ans=r*mult+q;
        System.out.println(ans);
    }
    //10) gcd and lcm
    public static void GCDAndLCM()
    {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int on1=n1;
        int on2=n2;
        while(n1%n2 !=0)
        {
            int rem=n1%n2;
            n1=n2;
            n2=rem;
        }
        int gcd=n2;
        int lcm= (on1*on2)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
    //11) Prime factorizatin of a number
    public static void PrimeFactorization()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int div=2 ; div*div<=n ; div++)
        {
            while(n%div==0)
            {
                n=n/div;
                System.out.println(div);
            }
            if(n!=1)
            {
                System.out.println(n);
            }
        }
    }
    //12) Benjamin bulb
    public static void BenjaminBulb()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i*i <=n ;i++)
        {
            System.out.println(i*i);
        }
    }
}
