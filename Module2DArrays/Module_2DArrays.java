package Module2DArrays;

import java.util.Scanner;

public class Module_2DArrays {
    public static void main(String[] args) {
        MatrixMultiplication();
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
                    ans[i][j]+=one[i][k]+two[k][j];
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
}
