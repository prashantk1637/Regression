///Linear Regression for single variable(feature)

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
class LinearRegressionSV
{       static int n;
	static double meanx,meany,meanxy,cov,sumx=0.0,sumy=0.0,sq_sumx=0.0,varx,sumxy=0.0,stdx=0,stdy=0;
	static double LinearRegression(double  x[], double  y[])
	{
           
		double a;
		for(int i=0;i<n;i++)
		{
			sumx=sumx+x[i];
			sumy=sumy+y[i];
                        sq_sumx=sq_sumx+x[i]*x[i];
			sumxy=sumxy+x[i]*y[i];
			
		}
		meanx=sumx/n;
		meany=sumy/n;
               
		meanxy=sumxy/n;
		cov=meanxy-meanx*meany;
		varx=(sq_sumx/n)-(meanx*meanx);
		stdx=Math.sqrt(varx);
                System.out.println("COV="+cov);
                System.out.println("STDVX="+stdx);
                
		a=cov/varx;
                
	return a;
	}
	public static void main(String[] args) throws Exception
	{       
		
            Scanner sc=new Scanner(System.in);
               System.out.println("Enter number of data points");
               
               n=sc.nextInt();
		double x[]=new double[n];
                double y[]=new double[n];
                String currentLine="";
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Prashant\\Documents\\NetBeansProjects\\LinearRegression\\LRSVData.txt"));
		int i=0;
                while((currentLine=br.readLine())!=null &&i<n)
                {
                   StringTokenizer stk=new StringTokenizer(currentLine);
                  
                       x[i]=Double.parseDouble(stk.nextToken());
                       y[i]=Double.parseDouble(stk.nextToken());
                       
                       i++;
                 }
                double a=LinearRegression(x, y);
                System.out.println("a="+a);
               //Estimate y for x=1.36
               System.out.println("============Estimation=============");
                double yy=meany+a*(4.913662712-meanx);
                System.out.println("yy="+yy+" for x=4.913662712");
              }
	
}