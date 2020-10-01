package src;

import java.util.Scanner;
public class BankerAlgo
{
	static int n;
	static int m;
	static int nd[][];
	static int [][]max; 
	static int req[][]; 
	static int []spg; 
	int seq[] = new int[n]; 
	public static  void input() {
		Scanner input=new Scanner(System.in);
		req= new int[n][m];
		for(int i=0; i<n; i++) {
			System.out.println("For process P"+i+" enter required space ");
			for (int j=0; j<m; j++) {
				System.out.print("Enter "+(j+1)+"st value : ");
				req[i][j]=input.nextInt();

				}
		}
		max= new int[n][m];
		for(int i=0; i<n; i++) {
			System.out.println("For process P"+i+" enter maximum size  ");
			for (int j=0; j<m; j++) {
				System.out.print("Enter "+(j+1)+"st value : ");
				max[i][j]=input.nextInt();

				}
		}
		spg=new int[m];
		System.out.println("Enter the available space ");
		for (int j=0; j<m; j++) {
			System.out.print("Enter "+(j+1)+"st value : ");
			spg[j]=input.nextInt();
		}
	}
	public void safe() 
	  { 
	  int oc=0; 
	  boolean v[] = new boolean[n];  
	  for (int i = 0;i < n; i++) 
	  { 
	      v[i] = false; 
	  }
	  int w[] = new int[m];     
	  for (int i = 0;i < m; i++) 
	  { 
	      w[i] = spg[i]; 
	  } 

	  while (oc<n) 
	  { 
	      boolean f = false; 
	      for (int i = 0;i < n; i++) 
	      { 
	          if (v[i] == false) 
	           { 
	          int j; 
	          for (j = 0;j < m; j++) 
	          {         
	              if (nd[i][j] > w[j]) 
	              break; 
	          } 
	          if (j == m) 
	          { 
	             seq[oc++]=i; 
	             v[i]=true; 
	             f=true; 
	                        
	              for (j = 0;j < m; j++) 
	              { 
	              w[j] = w[j]+req[i][j]; 
	              } 
	          } 
	           } 
	      } 
	      if (f==false) 
	      { 
	    	  break;
	      } 
	  } 
	  if (oc < n) 
	  { 
	      System.out.println("The System is UnSafe!"); 
	  } 
	  else
	  { 
	      System.out.println("The sequence of execution of processes is : "); 
	              for (int i = 0;i < n; i++) 
	      { 
	          System.out.print("P" + seq[i]); 
	          if (i != n-1) 
	          System.out.print(" >> "); 
	      } 
	  } 
	  } 
	    
	  static void calculatend() 
	  { 
	  for (int i = 0;i < n; i++) 
	  { 
	      for (int j = 0;j < m; j++) 
	       { 
	      nd[i][j] = max[i][j]-req[i][j]; 
	       } 
	  }         
	  } 

	  public static void main(String[] args) 
	  {   
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of processes: ");
		n=input.nextInt();
		System.out.println("Enter number of resources: ");
		m=input.nextInt();	
		nd=new int [n][m];
	    int i, j, k;  
	    BankerAlgo gfg = new BankerAlgo(); 
	    gfg.input();     
	    gfg.calculatend();             
	    gfg.safe();         
	  } 
}