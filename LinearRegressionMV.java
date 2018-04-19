
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prashant
 */
public class LinearRegressionMV {
    
    static double x[][];
    static double xT[][];
    static double xTx[][];
    static double xTy[][];
    static double w[][];
    static double y[][];
              
    static double[][] multiplication(double a[][], double b[][], int r1,int c1,int r2, int c2)
    {   double c[][]=new double[r1][c2];
            for(int i=0;i<r1;i++)
            {
                for(int j=0;j<c2;j++)
                {   c[i][j]=0.0;
                    for(int k=0;k<c1;k++)
                    {
                        c[i][j]=c[i][j]+a[i][k]*b[k][j];
                    }
                }
            }
       
        return c;
    }
    public static void main(String[] args) throws Exception
	{       
		
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter number of data points(Enter 44)");
            int n=sc.nextInt();
            System.out.println("Enter number of features(Enter 2)");
            int d=sc.nextInt();
		x=new double[n][d+1];
                xT=new double[d+1][n];
                xTx=new double[d+1][d+1];
                xTy=new double[d+1][1];
                w=new double[d+1][1];
                y=new double[n][1];
                String currentLine="";
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Prashant\\Documents\\NetBeansProjects\\LinearRegression\\LRMVData.txt"));
		//file contains 24 data with 2 features
                int i=0;
                while((currentLine=br.readLine())!=null &&i<n)
                {
                    StringTokenizer stk=new StringTokenizer(currentLine);
                    x[i][0]=1.0; 
                      for(int j=1;j<=d;j++)
                      {
                          x[i][j]=Double.parseDouble(stk.nextToken()); //features
                      }
                      y[i][0]=Double.parseDouble(stk.nextToken()); // output
                      i++;
                      
                 }
                //Print dataset
                System.out.println("=================Dataset======================");
                System.out.println("x0\tAge\tTemp\tlength of fish(class)");
                for(i=0;i<n;i++)
                {
                    for(int j=0;j<d+1;j++)
                        System.out.print(x[i][j]+"\t");
                    System.out.print(y[i][0]);
                    System.out.println("");
                }
                
                //print Matrix x
                System.out.println("==============Matrix X=================");
                for(i=0;i<n;i++)
                {
                    for(int j=0;j<d+1;j++)
                        System.out.print(x[i][j]+"\t");
                    System.out.println("");
                }
                
                //calculate tranpose
                for(i=0;i<n;i++)
                {
                    for(int j=0;j<d+1;j++)
                    {
                        xT[j][i]=x[i][j];
                    }
                }
                System.out.println("==============Transpose of Matrix X =================");
                for(i=0;i<d+1;i++)
                {
                    for(int j=0;j<n;j++)
                        System.out.print(xT[i][j]+"\t");
                    System.out.println("");
                }
                
                //calculate matrix multiplication xT*x
               xTx=multiplication(xT, x, d+1, n, n, d+1);
               // Print xTx matrix
               
               System.out.println("========xTx Matrix===============");
               for(i=0;i<d+1;i++)
               {
                   for(int j=0;j<d+1;j++)
                   {
                       System.out.print(xTx[i][j]+"  ");
                   }
                   System.out.println("");
               }
               
               //calculation of xTy
               xTy=multiplication(xT, y, d+1, n, n, 1);
               
               System.out.println("========xTy Matrix===============");
               for(i=0;i<d+1;i++)
               {
                   for(int j=0;j<1;j++)
                   {
                       System.out.print(xTy[i][j]+"  ");
                   }
                   System.out.println("");
               }
               
               // augmented matrix
               double aug[][]=new double[d+1][d+2];
               for(i=0;i<d+1;i++)
               {
                   for(int j=0;j<d+1;j++)
                   {
                       aug[i][j]=xTx[i][j];
                   }aug[i][d+1]=xTy[i][0];
               }
                System.out.println("========Augmented Matrix===============");
               for(i=0;i<d+1;i++)
               {
                   for(int j=0;j<d+2;j++)
                   {
                       System.out.print(aug[i][j]+"\t");
                    }
                   System.out.println("");
               }
               GaussElimination obj=new GaussElimination(aug);
               obj.forwrdElimination();
               w=obj.backSubstitution();
               System.out.println("==================W solution==================");
               
               for(i=0;i<d+1;i++)
               {
                   System.out.println(w[i][0]);
                   
               }
               
               System.out.println("===Estimation==========");
               System.out.println(1*w[0][0]+41*w[1][0]+31*w[2][0]);
               
               
     }
    
}
