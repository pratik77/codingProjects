public class UniqueChar {

	
	static void getUniq(String str)
	{
		int n = str.length();
		int DP[][] = new int[n][n];
		for(int i=0;i<n;i++)
			DP[i][i]= 1;
		for(int gap=2;gap<=n;gap++)
		{
			for(int j=0; j<n-gap+1;j++)
			{
				int k = j+gap-1;
				if(str.charAt(j)==str.charAt(k))
				{
					DP[j][k]=2 - DP[j+1][k-1];
				}
				else
				{
					DP[j][k] = 1 + Math.min(DP[j][k-1],DP[j+1][k]);
				}
			}
		}
		int sum=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				sum = sum + DP[i][j];
			}
		}
		
		System.out.println(sum);
	}
	public static void main(String args[])
	{
		String str = "CODILITY";
		getUniq(str);
	}
}