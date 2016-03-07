
public class BST_tester {
	public static void main(String[] args){
		BinarySearchTree b = new BinarySearchTree(30);
		b.add(11);
		b.add(50);
		b.add(15);
		b.add(40);
		b.add(10);
		b.add(70);
		b.add(69);		
		b.add(68);
		b.add(67);

		
		TreePrinter tree  = new TreePrinter(b);
		tree.print("BST");
		b.remove(30);
		tree.print("BST");
		
		b.remove(40);
		tree.print("BST");
		
		b.remove(50);
		tree.print("BST");
		
		b.remove(67);
		tree.print("BST");
		
		b.remove(68);
		tree.print("BST");
		
		b.remove(69);
		tree.print("BST");
		
		b.remove(70);
		tree.print("BST");
		
		b.remove(11);
		tree.print("BST");
		
		b.remove(15);
		tree.print("BST");
		
		b.remove(10);
		tree.print("BST");
		

	}
}
