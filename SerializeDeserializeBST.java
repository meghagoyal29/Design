package LeetCode.Design;

import java.util.LinkedList;
import java.util.Queue;

import TreesAndGraphs.TreeUtil;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class SerializeDeserializeBST {

	public static void main(String[] args) {
		String input = "6 2 8 0 4 7 9 # # 3 5";
		System.out.println(serialize(deserialize(input)));//6 2 0 ##4 3 ##5 ##8 7 ##9 ##
	}
	
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
       return serialize(root,0);
    }

    private static String serialize(TreeNode root, int level) {
    	if(root==null)
    		return"";
		StringBuffer sb = new StringBuffer();
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			TreeNode thisNode = nodes.remove();
			sb.append(thisNode==null?"#":thisNode.val);
			sb.append(" ");
			if(thisNode!=null) {
			nodes.add(thisNode.left);
			nodes.add(thisNode.right);}
		}
		int i=sb.length()-1;
		while(sb.charAt(i)=='#'||sb.charAt(i)==' ') {
			sb.deleteCharAt(i);
			i--;
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	
    	if(data==null||data.length()==0)
    		return null;
    	data=data.trim();
        String[] parts = data.split(" ");
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        nodes.add(root);
        int index = 1;
        while(!nodes.isEmpty()) {
        	TreeNode node = nodes.remove();
        	if(index== parts.length) break;
        	String item = parts[index++].trim();
        	if(!item.equals("#")) {
        		TreeNode left = new TreeNode(Integer.parseInt(item));
        		node.left=left;
        		nodes.add(node.left);
        	}
        	if(index== parts.length) break;
        	item = parts[index++].trim();
        	if(!item.equals("#")) {
        		TreeNode right = new TreeNode(Integer.parseInt(item));
        		node.right=right;
        		nodes.add(node.right);
        	}
        }
        return root;
    }
}

