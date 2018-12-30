import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CandidateCode 
{ 

  public static void main(String arg[])
  {
	  FastReader fr = new FastReader();
    System.out.println(minimumpossiblecost(fr.nextLine()));
    // 2@10@1@2@3@1#1@-1@2@4@1@2#1@2@2@1@-1@1#3@-1@4@1@2@1#4@1@2@-1@2@1
  }
  public static int minimumpossiblecost(String input1)
  {
    String arr[]=input1.split("#");
    int c=arr[0].split("@").length;
    int r=arr.length;
    int intarr[][]= new int[r][];
    for(int i=0;i<r;i++)
    {
        intarr[i]= new int[c];
    }
    for(int i=0;i<arr.length;i++)
    {
        String row[]=arr[i].split("@");
        for(int j=0;j<row.length;j++)
        {
            intarr[i][j]=Integer.parseInt(row[j]);
        }
    }
    int temp=0;
    int ans=0;
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<r;j++) 
        {

            temp=0;
            if(intarr[i][j]==-1)
           {
            if(i==0 && j==0)
            {
                temp=minDiff(intarr[i][j+1],intarr[i+1][j],intarr[i+1][j+1]);
                if(temp==intarr[i][j+1])
                    intarr[i][j+1]=-1;
                else if(temp==intarr[i+1][j])
                    intarr[i+1][j]=-1;
                else if(temp==intarr[i+1][j+1])
                    intarr[i+1][j+1]=-1;
                ans=ans+temp;


            }
            else if(i==0 && j>0 && j<c-1)
            {
                temp=minDiff(intarr[i][j-1],intarr[i][j+1],intarr[i+1][j],intarr[i+1][j-1],intarr[i+1][j+1]);
                if(temp==intarr[i][j-1])
                    intarr[i][j-1]=-1;
                else if(temp==intarr[i][j+1])
                    intarr[i][j+1]=-1;
                else if(temp==intarr[i+1][j])
                    intarr[i+1][j]=-1;
                else if(temp==intarr[i+1][j-1])
                    intarr[i+1][j-1]=-1;
                else if(temp==intarr[i+1][j])
                    intarr[i+1][j+1]=-1;
                ans=ans+temp;

            }
            else if(i==0 && j==c-1)
            {
                temp=minDiff(intarr[i+1][j],intarr[i][j-1],intarr[i+1][j-1]);
                if(temp==intarr[i+1][j])
                    intarr[i+1][j]=-1;
                else if(temp==intarr[i][j-1])
                    intarr[i][j-1]=-1;
                else if(temp==intarr[i+1][j-1])
                    intarr[i+1][j-1]=-1;
                ans=ans+temp;

            }
            else if(i>0 && i<r-1 && j==0)
            {
                temp=minDiff(intarr[i+1][j],intarr[i-1][j],intarr[i][j+1],intarr[i-1][j+1],intarr[i+1][j+1]);
                if(temp==intarr[i+1][j])
                    intarr[i+1][j]=-1;
                else if(temp==intarr[i-1][j])
                    intarr[i-1][j]=-1;
                else if(temp==intarr[i][j+1])
                    intarr[i][j+1]=-1;
                else if(temp==intarr[i-1][j+1])
                    intarr[i-1][j+1]=-1;
                else if(temp==intarr[i+1][j+1])
                    intarr[i+1][j+1]=-1;
                ans=ans+temp;

            }
            else if(i>0 && i<r-1 && j==c-1)
            {

            temp=minDiff(intarr[i][j],intarr[i+1][j],intarr[i][j-1],intarr[i-1][j],intarr[i-1][j-1],intarr[i+1][j-1]);
                if(temp==intarr[i][j])
                    intarr[i][j]=-1;
                else if(temp==intarr[i+1][j])
                    intarr[i+1][j]=-1;
                else if(temp==intarr[i][j-1])
                    intarr[i][j-1]=-1;
                else if(temp==intarr[i-1][j])
                    intarr[i-1][j]=-1;
                else if(temp==intarr[i-1][j-1])
                    intarr[i-1][j-1]=-1;
                else if(temp==intarr[i+1][j-1])
                    intarr[i+1][j-1]=-1;
                ans=ans+temp;

            }
            else if(i==r-1 && j==0)
            {
                temp=minDiff(intarr[i-1][j],intarr[i][j+1],intarr[i-1][j+1]);
                if(temp==intarr[i-1][j])
                    intarr[i-1][j]=-1;
                else if(temp==intarr[i][j+1])
                    intarr[i][j+1]=-1;
                else if(temp==intarr[i-1][j+1])
                    intarr[i-1][j+1]=-1;
                ans=ans+temp;
            }
            else if(i==r-1 && j>0 && j<c-1)
            {
                temp=minDiff(intarr[i-1][j],intarr[i][j-1],intarr[i][j+1],intarr[i-1][j-1],intarr[i-1][j+1]);
                if(temp==intarr[i-1][j])
                    intarr[i-1][j]=-1;
                else if(temp==intarr[i][j-1])
                    intarr[i][j-1]=-1;
                else if(temp==intarr[i][j+1])
                    intarr[i][j+1]=-1;
                else if(temp==intarr[i-1][j-1])
                    intarr[i-1][j-1]=-1;
                else if(temp==intarr[i-1][j+1])
                    intarr[i-1][j+1]=-1;
                ans=ans+temp;
            }
            else if(i==r-1 && j==c-1)
            {
                temp=minDiff(intarr[i][j-1],intarr[i-1][j],intarr[i-1][j-1]);
                if(temp==intarr[i][j-1])
                    intarr[i][j-1]=-1;
                else if(temp==intarr[i-1][j])
                    intarr[i-1][j]=-1;
                else if(temp==intarr[i-1][j-1])
                    intarr[i-1][j-1]=-1;
                ans=ans+temp;

            }
            else
            {
                temp=minDiff(intarr[i+1][j],intarr[i-1][j],intarr[i][j+1],intarr[i][j-1],intarr[i-1][j+1],intarr[i-1][j-1],intarr[i+1][j+1],intarr[i+1][j-1]);
                if(temp==intarr[i+1][j])
                    intarr[i+1][j]=-1;
                else if(temp==intarr[i-1][j])
                    intarr[i-1][j]=-1;
                else if(temp==intarr[i][j+1])
                    intarr[i][j+1]=-1;
                else if(temp==intarr[i][j-1])
                    intarr[i][j-1]=-1;
                else if(temp==intarr[i-1][j+1])
                    intarr[i-1][j+1]=-1;
                else if(temp==intarr[i-1][j-1])
                    intarr[i-1][j-1]=-1;
                else if(temp==intarr[i+1][j+1])
                    intarr[i+1][j+1]=-1;
                else if(temp==intarr[i+1][j-1])
                    intarr[i+1][j-1]=-1;
                ans=ans+temp;

            }
         }
        }

    }
    for(int i = 0 ; i < r; i ++) {
    	System.out.println();
    	for(int j = 0 ; j < c ; j++) {
    		System.out.print(intarr[i][j] + " ");
    	}
    }
    return ans;
  }
  static int minDiff(int ...x)
  {
    int flag=0,min=10000;
    for(int i=0;i<x.length;i++)
    {
        if(x[i]==-1)
        {
            flag=1;
            break;
        }

    }
    if(flag==1)
    return 0;
    else
    {
        for(int i=0;i<x.length;i++)
        {
            if(x[i]<min)
            {
                min=x[i];
            }

        }   
    }
    return min;
  }
}


   
     class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
     
  
    public static void main(String[] args) 
    { 
        FastReader s=new FastReader(); 
        int n = s.nextInt(); 
        int k = s.nextInt(); 
        int count = 0; 
        while (n-- > 0) 
        { 
            int x = s.nextInt(); 
            if (x%k == 0) 
               count++; 
        } 
        System.out.println(count); 
    } 
} 