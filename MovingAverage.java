package LeetCode.Design;

public class MovingAverage {
	static int[] nums;
	int sum=0;
	int currentCount=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1));
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println(ma.next(10));
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println(ma.next(3));
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println(ma.next(5));
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	 public MovingAverage(int size) {
	        nums=new int[size];
	    }
	    
	    public double next(int val) {
	    	currentCount++;
	    	
	    	if(currentCount<nums.length) {
	    		sum+=val;
	    		nums[currentCount-1]=val;
	    		return ((double)sum)/currentCount;
	    	}else {
	    		int indexForVal = (currentCount%nums.length)-1;
	    		if(indexForVal==-1) {
	    			indexForVal=nums.length-1;
	    		}
	    		sum-=nums[indexForVal];
	    		sum+=val;
	    		nums[indexForVal]=val;
	    		return(double)sum/nums.length;
	    	}
	        
	    }
}
