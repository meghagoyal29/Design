package LeetCode.Design;

public class NonRepeatingNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
public int singleNumber(int[] nums) {
    int result = 0;   
	for(int num:nums) {
    	 result^=num;  
       }
	return result;
    }
}
