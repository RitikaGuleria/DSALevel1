package FunctionsAndArrays;

import java.util.ArrayList;
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
        // DifferenceOfTwoArrays();
        // ReverseAnArray();
        // RotateAnArray();
        // InverseOfAnArray();
        // SubArraysofAnArray();
        // CeilAndFloor_BrokenEconomy();
        // FirstAndLastIndex();
        // SubsetsOfAnArray();
        RemovePrime();
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

    //6) Any Base Subtraction-
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
    //Difference b/w two arrays-  assumng arr2 is a bigger
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

        //removing front zeros- MOST SIGNIFICANT DIGITS
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

    //Reverse an Array
    public static void ReverseAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;
        }
        for(int ians=0;ians<arr.length;ians++)
        {
            System.out.println(arr[ians]);
        }

    }

    //Rotate an array
    public static void RotateAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        //If K is a very big number
        k=k%arr.length;
        //if k is a -ve number
        if(k<0)
        {
            k=k+arr.length;
        }

        //first part reverse
        HelperReverseAnArray(arr, 0,n-k-1);
        //second part reverse
        HelperReverseAnArray(arr, arr.length-k,arr.length-1);
        //whole reverse of an array
        HelperReverseAnArray(arr, 0,arr.length-1);
    }
    //helper reverse an array
    public static void HelperReverseAnArray(int arr[],int i,int j)
    {
        int l=i;
        int r=j;
        while(l<r)
        {
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            l++;
            r--;
        }
        for(int ans=0;ans<arr.length;ans++)
        {
            System.out.print(arr[ans]);
        }
        System.out.println();
    }

    //Inverse of an array
    public static void InverseOfAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        int inv[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int v=arr[i];
            inv[v]=i;
        }
        for(int i=0;i<inv.length;i++)
        {
            System.out.print(inv[i]);
        }
    }

    //SubArrays of an array
    public static void SubArraysofAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length;j++)
            {
                for(int k=i;k<=j;k++)
                {
                    System.out.print(arr[k]+"\t");
                }
                System.out.println();
            }
        }
    }

    //Broken Economy- ceil and floor
    public static void CeilAndFloor_BrokenEconomy()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        int data=sc.nextInt();
        int lo=0;
        int hi=arr.length-1;
        int ceil=0;
        int floor=0;

        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(data<arr[mid])
            {
                hi=mid-1;
                ceil=arr[mid];
            }
            else if(data>arr[mid])
            {
                lo=mid+1;
                floor=arr[mid];
            }
            else{
                floor=arr[mid];
                ceil=arr[mid];
                break;
            }
        }
        System.out.println(floor);
        System.out.println(ceil);
    }

    //First and Last Index - using Binary Search
    public static void FirstAndLastIndex()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        int data=sc.nextInt();

        int lo=0;
        int hi=arr.length-1;
        int li=-1;

        while(lo<=hi)
        {
            int mid=(lo+hi)/2;

            if(data < arr[mid])
            {
                hi=mid-1;
            }
            else if(data > arr[mid])
            {
                lo=mid+1;
            }
            else
            {
                li=mid;
                lo=mid+1;
            }
        }
        System.out.println("Last index is "+li);

        lo=0;
        hi=arr.length-1;
        int fi=-1;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;

            if(data < arr[mid])
            {
                hi=mid-1;
            }
            else if(data > arr[mid])
            {
                lo=mid+1;
            }
            else
            {
                fi=mid;
                hi=mid-1;
            }
        }
        System.out.println("First index is "+fi);
    } 

    //Subsets of an Array
    public static void SubsetsOfAnArray()
    {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        int limit = (int) Math.pow(2,arr.length);

        for(int i=0;i<limit;i++)
        {
            int temp=i;
            String set="";
            for(int j=arr.length-1;j>=0;j--)
            {
                int r=temp%2;
                temp=temp/2;

                if(r==0)
                {
                    set="-\t"+set;
                }
                else{
                    set=arr[j] + "\t"+set;
                }
            }
            System.out.println(set);

        }
    }

    //Remove Prime from ArrayList
    public static void RemovePrime()
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(sc.nextInt());
        }

        for(int i=al.size()-1 ; i>=0 ; i--)
        {
            int item=al.get(i);
            if(isPrime(item))
            {
                al.remove(i);
            }
        }
        System.out.println(al);

    }
    public static boolean isPrime(int val)
    {
        for(int div=2;div*div<=val ;div++)
        {
            if(val%div==0)
            {
                return false;
            }
        }
        return true;
    }
}
