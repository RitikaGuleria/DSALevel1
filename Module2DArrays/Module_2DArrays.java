package Module2DArrays;

import java.util.Scanner;

public class Module_2DArrays {
    public static void main(String[] args) {
        // MatrixMultiplication();
        // TheStateOfWakanda1();
        // SpiralDisplay();
        // ExitPointOfAMatrix();

        // int ans[][]=Transpose();
        // for(int i=0;i<ans.length;i++)
        // {
        //     for(int j=0;j<ans[0].length;j++)
        //     {
        //         System.out.print(ans[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        RotateBy90Degree();
    }

    //Matrix Multiplication
    public static void MatrixMultiplication()
    {
        Scanner sc=new Scanner(System.in);
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int r2=sc.nextInt();
        int c2=sc.nextInt();

        int one[][]=new int[r1][c1];

        for(int i=0;i<one.length;i++)
        {
            for(int j=0;j<one[0].length;j++)
            {
                one[i][j]=sc.nextInt();
            }
        }

        int two[][]=new int[r2][c2];

        for(int i=0;i<two.length;i++)
        {
            for(int j=0;j<two[0].length;j++)
            {
                two[i][j]=sc.nextInt();
            }
        }

        if(c1!=r2)
        {
            System.out.println("Sum isn't possible because of invalid inputs of metrics");
            return;
        }
        int ans[][]=new int[r1][c2];
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                for(int k=0;k<c1;k++)
                {
                    ans[i][j]+=one[i][k]*two[k][j];
                }
            }
        }
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    //The state of Wakanda 1
    public static void TheStateOfWakanda1()
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();

        int arr[][]=new int[r][c];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        for(int j=0;j<arr[0].length;j++)
        {
            if(j%2==0)
            {
                for(int i=0;i<arr.length;i++)
                {
                    System.out.println(arr[i][j]);
                }
            }else{
                for(int i=arr.length-1;i>=0;i--){
                   System.out.println(arr[i][j]); 
                }
            }
        }
    }
    //Spiral Display
    public static void SpiralDisplay()
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();

        int arr[][]=new int[r][c];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        int minr=0;
        int minc=0;
        int maxr=arr.length-1;
        int maxc=arr[0].length-1;
        int totalElements=r*c;
        int count=0;

        while(count<totalElements)
        {
            //Left wall<
            for(int i=minr,j=minc;i<=maxr && count<totalElements;i++)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;
            //Bottom wall
            for(int i=maxr,j=minc;j<=maxc && count<totalElements;j++)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;
            //Right wall
            for(int i=maxr,j=maxc ;i>=minr && count<totalElements ;i--)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;
            //Top wall
            for(int j=maxc,i=minr;j>=minc && count<totalElements;j--)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }

    }
    //Exit point of a matrix
    public static void ExitPointOfAMatrix()
    {
       Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();

        int arr[][]=new int[r][c];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int dir=0; //East-0, south-1,west-2,North-3
        int i=0;
        int j=0; 
        while(true)
        {
            dir=(dir+arr[i][j])%4;
            if(dir==0) //east
            {
                j++;
            }
            else if(dir==1) //south
            {
                i++;
            }
            else if(dir==2) //west
            {
                j--;
            }
            else if(dir==3) //north
            {
                i--;
            }


            if(i<0)
            {
                i++;
                break;
            }
            else if(i==arr.length)
            {
                i--;
                break;
            }
            else if(j<0)
            {
                j++;
                break;
            }
           else if(j==arr[0].length)
            {
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
    //Transpose of a matrix
    public static int[][] Transpose()
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();

        int arr[][]=new int[r][c];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        //method-1

        // int ans[][]=new int[arr[0].length][arr.length];
        // for(int i=0;i<arr[0].length;i++)
        // {
        //     for(int j=0;j<arr.length;j++)
        //     {
        //         ans[i][j]=arr[j][i];
        //     }
        // }
        // return ans;

        //method-2
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr[0].length;j++)
            {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        return arr;
    }

    //Rotate by 90 degree
    public static void RotateBy90Degree()
    {
        int arr[][]=Transpose();

        for(int i=0;i<arr.length;i++)
        {
            int li=0;
            int ri=arr[i].length-1;
            while(li<ri)
            {
                int temp=arr[i][li];
                arr[i][li]=arr[i][ri];
                arr[i][ri]=temp;

                li++;
                ri--;
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
