package LeetCode.Design;

public class SlidingWindowMax {
	public static void main(String[] args) {
		int[] nums = {5,3,4};
		int[] max = maxSlidingWindow(nums, 2);
		for(int num:max) {
			System.out.print(num+" ");
		}
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(k==1)
			return nums;
		int maxLength = nums.length-k+1;
		int[] maxes =new int[maxLength];
		int currentMax= findMax(nums,0,k-1);
		maxes[0]=currentMax;
		for(int i=1;i<maxLength;i++) {
			int newLastIndex=i+k-1;
			if(nums[i-1]==currentMax) {
				currentMax=findMax(nums, i,newLastIndex);
			}else if(nums[newLastIndex]>currentMax) {
				currentMax = nums[newLastIndex];
			}
			maxes[i]=currentMax;
		}
		return maxes;
	}

	private static int findMax(int[] nums, int start, int end) {
		int max = Integer.MIN_VALUE;
		for(int i=start;i<=end;i++) {
			if(nums[i]>max) {
				max=nums[i];
			}
		}
		System.out.println(max);
		return max;
	}
}
