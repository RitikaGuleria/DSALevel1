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

        // SpanOfAnArray();
        // findElementInAnArray();
        // BarChart();
        // SumOfTwoArrays();
        DifferenceOfTwoArrays();
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
    //Find Element in an array
    public static void findElementInAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        int data=sc.nextInt();
        int idx=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==data)
            {
                idx=i;
                break;
            }
        }
        System.out.println(idx);
    }
    //Bar Chart
    public static void BarChart()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }

        for(int floor=max;floor>=1;floor--)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]>=floor)
                {
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        } 
    }
    //Sum of two arrays
    public static void SumOfTwoArrays()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n1");
        int n1=sc.nextInt();
        int arr1[] = new int[n1];
        System.out.println("enter arr1 integers");
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter n2");
        int n2=sc.nextInt();
        int arr2[] = new int[n2];
        System.out.println("enter arr2 integers");
        for(int i=0;i<arr2.length;i++)
        {
            arr2[i]=sc.nextInt();
        }

        int sum[]= new int[n1 > n2 ? n1 : n2];

        
        int c=0;

        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=sum.length-1;

        while(k>=0)
        {
            int d=c;

            if(i>=0)
            {
                d += arr1[i];
            }
            if(j>=0)
            {
                d += arr2[j];
            }
            
            c=d/10;
            d=d%10;
            sum[k]=d;

            i--;
            j--;
            k--;
        }
        if(c!=0)
        {
            System.out.print(c);
        }
        for(int val : sum)
        {
            System.out.print(val);
        }
    }
    //Difference b/w two arrays
    public static void DifferenceOfTwoArrays()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n1");
        int n1=sc.nextInt();
        int arr1[] = new int[n1];
        System.out.println("enter arr1 integers");
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter n2");
        int n2=sc.nextInt();
        int arr2[] = new int[n2];
        System.out.println("enter arr2 integers");
        for(int i=0;i<arr2.length;i++)
        {
            arr2[i]=sc.nextInt();
        }

        int diff[]= new int[n2];
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=diff.length-1;

        int c=0; 

        while(k>=0){
            int d=0;
            int arr1v= i >=0 ? arr1[i] : 0;

            if(arr2[j]+c >= arr1v )
            {
                d= arr2[j] + c - arr1v;
                c=0;
            }
            else{
                d=arr2[j] + c + 10 - arr1v;
                c=-1;
            }

            diff[k] = d;
            i--;
            j--;
            k--;
        }

        //removing front zeros
        int idx=0;
        while(idx<diff.length)
        {
            if(diff[idx]==0)
            {
                idx++;
            }
            else{
                break;
            }
        }
        while(idx<diff.length)
        {
            System.out.print(diff[idx]);
            idx++;
        }
    }
}
