
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prashant
 */
public class GaussElimination {
    double a[][];
    double w[][];
    int row,col;
    public GaussElimination(double a[][])
    {
        this.a=a;
        this.row=a.length;
        this.col=a[0].length;
        w=new double[row][1];
        //System.out.println("row="+row+"col="+col);
    }
    public void forwrdElimination()
    {
      for(int k=0;k<row-1;k++) //number of equations minus 1
      {
          for(int i=k+1;i<row;i++)
          { 
             double c=a[i][k]/a[k][k];
              for(int j=0;j<col;j++)
              {
                   a[i][j]=a[i][j]-c*a[k][j];
              }
          }
      }
       
    }
    public double[][] backSubstitution()
    {
        w[row-1][0]=a[row-1][col-1]/a[row-1][col-2];
        //System.out.println("w="+w[row-1][0]);
        for(int i=row-2; i>=0; i--)
        {
            double sum=0;
            for(int j=i+1; j<col-1; j++)
            {
                sum=sum+a[i][j]*w[j][0];
            }
            w[i][0]=(a[i][col-1]-sum)/a[i][i];
        }
        
        
        return w;
        /*System.out.println("== W solution==");
        for(int i=0;i<row;i++)
        {
            System.out.println(w[i][0]);
        }*/
    }
    
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       
        System.out.println("Enter number of rows and columns");
         int r=sc.nextInt();
         int c=sc.nextInt();
        double arr[][]=new double[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.println("Enter element=a["+i+"]["+j+"]");
                arr[i][j]=sc.nextDouble();
            }
        }
       arr[0][0]=1;arr[0][1]=1;arr[0][2]=1;arr[0][3]=6;
       arr[1][0]=2;arr[1][1]=1;arr[1][2]=-1;arr[1][3]=1;
       arr[2][0]=-1;arr[2][1]=2;arr[2][2]=2;arr[2][3]=9;
        System.out.println("Matrix print");
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("");
        }   
            
    GaussElimination obj=new GaussElimination(arr);
        obj.forwrdElimination();
        obj.backSubstitution();
    }*/
        
                
        
 }

