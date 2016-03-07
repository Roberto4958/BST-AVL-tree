import java.text.DecimalFormat;
import java.text.NumberFormat;


public class tester_part2 {
	public static void main(String[] args){
		
		long startTime = System.currentTimeMillis();
		
		AVLSearchTree avl = new AVLSearchTree(0);

		
		for(int i = 1; i < 1000; i++){
			avl.add(i, "dont print rotaion");		
		}	
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		NumberFormat formatter = new DecimalFormat("#0.00000");
		
		System.out.println("\t N = 1,000");
		
		System.out.println("Adding execution AVL time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		startTime = System.currentTimeMillis();
		BinarySearchTree bst = new BinarySearchTree(0);
		
		for(int i = 0; i < 1000; i++){
			bst.add(i);		
		}
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("adding execution BST time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		//search 
		System.out.println();
		startTime = System.currentTimeMillis();
		avl.search(1000);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Execution AVL search time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		startTime = System.currentTimeMillis();
		bst.search(1000);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Execution BST search time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		
		/////////////////------------------Testing for n = 10,000--------------------//////////////////

		
		System.out.println();
		System.out.println();

		for(int i = 0; i < 9000; i++){
			avl.add(i, "dont print rotaion");		
		}	
		
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		formatter = new DecimalFormat("#0.00000");
		
		System.out.println("\t N = 10,000");
		
		System.out.println("Adding execution AVL time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		startTime = System.currentTimeMillis();

		
		for(int i = 1; i < 9000; i++){
			bst.add(i);		
		}
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Adding execution BST time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		//search 
		System.out.println();
		startTime = System.currentTimeMillis();
		avl.search(9000);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Execution AVL search time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		startTime = System.currentTimeMillis();
		bst.search(9000);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Execution BST search time:" + formatter.format((totalTime) / 1000d) + " seconds");
		
		
		/////////////////------------------Testing for n = 100,000--------------------//////////////////

		
//		System.out.println();
//		System.out.println();
//
//		for(int i = 10000; i < 100000; i++){
//			avl.add(i, "dont print rotaion");		
//		}	
//		
//		endTime   = System.currentTimeMillis();
//		totalTime = endTime - startTime;
//		formatter = new DecimalFormat("#0.00000");
//		
//		System.out.println("\t N = 100,000");
//		
//		System.out.println("Execution AVL time:" + formatter.format((totalTime) / 1000d) + " seconds");
//		
//		startTime = System.currentTimeMillis();
//
//		
//		for(int i = 10000; i < 100000; i++){
//			bst.add(i*-1);		
//		}
//		endTime   = System.currentTimeMillis();
//		totalTime = endTime - startTime;
//		System.out.println("Execution BST time:" + formatter.format((totalTime) / 1000d) + " seconds");
	}
	

}
