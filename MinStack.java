package LeetCode.Design;

import java.util.Stack;

public class MinStack {
	static Stack<Integer> values;
	static Stack<Integer> minValues;
	public static void main(String[] args) {
		
		MinStack obj = new MinStack();
		 obj.push(512);
		 obj.push(-1024);
		 obj.push(-1024);
		 obj.push(512);
		 //obj.push(4);
		 //obj.push(5);
		 //obj.push(6);
		 System.out.println(values);
		 System.out.println(minValues);
		  //obj.getMin();
		  obj.pop();
		  System.out.println(values);
		  System.out.println(minValues);
		  obj.getMin();
		  obj.pop();
		  System.out.println(values);
		  System.out.println(minValues);
		  obj.getMin();
		  obj.pop();
		  System.out.println(values);
		  System.out.println(minValues);
		  obj.getMin();
	}
	
public MinStack() {
	values = new Stack<>();
	minValues = new Stack<>();
    }
    public void push(int x) {
    	values.push(x);
        if(minValues.isEmpty()||x<=minValues.peek()) {
        	minValues.push(x);
        }
    }
    public void pop() {
    	if(values.isEmpty())
    		return;
        if(values.peek().equals(minValues.peek())) {
        	values.pop();
        	minValues.pop();
        }else {
        	values.pop();
        }
    }
    public int top() {
    	if(values.isEmpty())
    		throw new IllegalArgumentException();
        return values.peek();
    }
    
    public int getMin() {
    	if(values.isEmpty())
    		throw new IllegalArgumentException();
        return minValues.peek();
    }
}
