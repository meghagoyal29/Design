package LeetCode.Design;

public class Celebrity {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
public int findCelebrity(int n) {
	int[] celeb = new int[n];
	int count = 0;
	int celebrity = -1;
       for(int i=0;i<n;i++) {
    	   for(int j=0;j<n;j++) {
    		   celeb[i]=0;
    		   if(i!=j && knows(i,j))
    		   {
    			   celeb[i]=-1;
    			   break;
    		   }
    		   
    	   }
    	   if(celeb[i]==0) {
    		   celebrity=i;
			   count++;
    	   }
       }
       if(count!=1) {
    	   return -1;
       }
       for(int i=0;i<n;i++) {
    	   if(i!=celebrity&&!knows(i,celebrity))
    		   return -1;
       }
       return celebrity;
    }
boolean knows(int a, int b) {
	
}
}
