
public class CheckBalanced {
	static Node root;
static Level helper(Node node, int counter) {
	if(node.left==null&&node.right==null) {
		Level h = new Level();
		h.N=counter;
		return h;
	}
	Level left = new Level();
	Level right = new Level();
	if(node.left!=null) {
		left = helper(node.left,counter+1);
	}
	if(node.right!=null) {
		right = helper(node.right,counter+1);
	}
	if(node.left!=null&&node.right!=null) {
		Level h = new Level();
		h.N=Math.max(left.N, right.N);
			if(left.N==right.N||left.N==right.N+1) {
				h.S=true;
				return h;
			}else {
				h.S=false;
				return h;
			}
	}
	if(node.left!=null&&node.right==null) {
		return left;
	}else {
		return right;
	}
	
}
static boolean isBalanced(Node node) {
	if(node.left!=null&&node.right!=null) {
		Level Left = new Level();
		Level Right = new Level();
		Left= helper(node.left,0);
		Right= helper(node.right,0);
		if(Left.N==Right.N||Left.N==Right.N+1) return true;
		return false;
	}
	if(node.left!=null&&node.right==null) {
		Level Left = new Level();
		Left= helper(node.left,0);
		if(Left.S==false) return false;
		return true;
	}else {
		Level Right = new Level();
		Right= helper(node.right,0);
		if(Right.S==false) return false;
		return true;
	}
}
public static void main(String[] args) {
	root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.right.right = new Node(6);
	root.left.left.left = new Node(7);
	
	/*root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(8);*/
     System.out.println(isBalanced(root));
}
}
class Level{
	int N;
	boolean S;
}
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}