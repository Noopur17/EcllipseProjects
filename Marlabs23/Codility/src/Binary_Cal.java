import java.util.Scanner;

public class Binary_Cal {

	public static void solution(int N) {
		int c[]=new int [100];
		int i = 0;
		while(N>0) {
			c[i]=N%2;
			i++;
			N=N/2;
			
		}
		for(int j=i-1;j>=0;j--) {
			System.out.println(c[j]);
			boolean flag=false;
			for(j=i-1;j>=0;j++)
			{
				if(c[j]==0) {
					
				}
			}
		}
	}
	
	public static void main(String[] args)
	{ System.out.println("Enter the number:");
		Scanner sc = new Scanner(System.in);
	  int x = sc.nextInt();
	  solution(x);
	  	
	}
}
