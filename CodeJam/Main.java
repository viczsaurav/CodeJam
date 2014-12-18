import java.util.*;
public class Main {
	static int ans=0;
	static int mod=(int)1e9+7;
	static int n,m;
	static void backtrack(int place ,char a[],char []add){
		
		if(place==add.length){
			
			
			boolean b[]=new boolean[a.length];
			int count=0;
			
			for(char r:add){
				
				if(!b[r-'1']){
					b[r-'1']=true;
					++count;
				}
				
				
			}
			
			
			if(count==b.length){
				
				++ans;
				if(ans>=mod)
					ans-=mod;
			}
			
			
			
			return ;
			
		}
		
		for(int i=0;i<a.length;i++){
			
			add[place]=a[i];
			backtrack(place+1,a,add);
			
		}
		
		
		return ;
		
	}

	public static void main(String[] args){
		
		Scanner s=new Scanner(System.in);
		
		int test=s.nextInt();int test1=0;
		while(test-->0){ans=0;
		 m=s.nextInt();
		 n=s.nextInt();
		char c[]=new char[m];
		for(int i=0;i<m;i++){
			
			c[i]=(char)(49+i);
			
		}
		char add[]=new char[n];
		
		backtrack(0,c,add);
		
		
		
		System.out.printf("Case #%d: %d\n",(++test1),ans);}
		
	}
	
	
	
}
