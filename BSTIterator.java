package LeetCode.Design;

public class BSTIterator {
	TreeNode nextNode;
	TreeNode currentNode;
	int level=0;
	boolean isLeftChild;
	TreeNode root;
	public BSTIterator(TreeNode root) {
		nextNode=root;
		currentNode=root;
		this.root=root;
	}
	public static void main(String[] args) {
		String input1 = "6 2 8 0 4 7 9 # # 3 5";
		//String input1 = "1";
		TreeNode root = SerializeDeserializeBST.deserialize(input1);
		BSTIterator bst = new BSTIterator(root);
		while(bst.hasNext()) {
			System.out.println(bst.next());
		}
	}

	private void findBSTSuccessor(TreeNode root) {
		if(root==null) {
			return;
		}
		if(root.right!=null)
		{
			nextNode = root.right;
			level++;
			isLeftChild=false;
		while(nextNode!=null&&nextNode.left!=null) {
			nextNode=nextNode.left;
			level++;
			isLeftChild=true;
		}
		return;
		}
		else if(isLeftChild) {
			int thisLevel=0;
			TreeNode thisRoot=this.root;
			while(thisLevel<level-1 && thisRoot!=null) {
				if(nextNode.val<thisRoot.val) {
					thisRoot=thisRoot.left;
					isLeftChild=true;
				}else {
					thisRoot=thisRoot.right;
					isLeftChild=false;
				}
				thisLevel++;
			}
			nextNode=thisRoot;
			level--;
			return;
		}else {
			int thisLevel=0;
			TreeNode thisRoot=root;
			while(thisLevel<level&&thisRoot.val>nextNode.val) {
				thisRoot=thisRoot.left;
				thisLevel++;
			}
			nextNode=thisRoot;
			level=thisLevel;
		}
		nextNode=null;
		return;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {

		if(nextNode==null) {
			return false;
		}
		currentNode=nextNode;
		findBSTSuccessor(nextNode);
		return true;
	}

	/** @return the next smallest number */
	public int next() {
		
		return currentNode.val;

	}
}
