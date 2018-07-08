package LeetCode.Design;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

public class MedianFinder {
	
	PriorityQueue<Integer> greaterThanMedian;
	PriorityQueue<Integer> smallerThanMedian;
	Double median = 0d;
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		mf.findMedian(); //-> 1.5
		mf.addNum(3); 
		mf.findMedian(); //-> 2
		mf.addNum(4); 
		mf.findMedian(); //-> 2
	}
	    /** initialize your data structure here. */
	    public MedianFinder() {
	    	greaterThanMedian = new PriorityQueue<>();//min heap
	    	smallerThanMedian = new PriorityQueue<>(new MaxHeamCoparator());//maxHeap
	    }
	    
	    public void addNum(int num) {
	    		    	
	        if(greaterThanMedian.size()==smallerThanMedian.size()) {
	        	if(greaterThanMedian.size()>0 && num>greaterThanMedian.peek()) {
	        		int temp = greaterThanMedian.poll();
	        		greaterThanMedian.add(num);
	        		smallerThanMedian.add(temp);
	        	}else {
	        		smallerThanMedian.add(num);
	        	}
	        	median = (double)smallerThanMedian.peek();
	        		
	        	
	        }else {
	        	if(smallerThanMedian.size()>0&&num>smallerThanMedian.peek()) {
	        		greaterThanMedian.add(num);
	        	}else {
	        		greaterThanMedian.add(smallerThanMedian.poll());
	        		smallerThanMedian.add(num);
	        	}
	        	median = (double) (double)((smallerThanMedian.peek()+greaterThanMedian.peek()))/2;
	        	
	        }
	    }
	    
	    public double findMedian() {
	    	System.out.println(greaterThanMedian);
	    	System.out.println(smallerThanMedian);
	        System.out.println(median);
	    	return median;
	    }
	}
class MaxHeamCoparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {

		return o2.compareTo(o1);
	}
	
}

