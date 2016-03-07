
public class BinarySearchTree <Integer>{
	//private int height;
	private BinaryNode root;
	
	public BinarySearchTree(int n){
		root = new BinaryNode(n);
	}
	
	public BinaryNode getRoot(){
		return root;
	}
	public int height(){
		return getHeight(root);
	}
	public int getHeight(BinaryNode node){
		if (node ==null)return 0;
		else if(node.left == null && node.right == null)return 0;
		else{
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
		}
	}
	
	public void add(int n){
		BinaryNode node = new BinaryNode(n); 
		if(root == null)root = node;
		else add(node, root);
		
	}
	public void add(BinaryNode insert, BinaryNode node){
		if(insert.data > node.data){
			if(node.right ==null)node.right = insert;
			else add(insert, node.right);
		}
		else{
			if(node.left == null){
				node.left = insert;
			}
			else add(insert, node.left);			
			
		}
	}
	public boolean search(int find){
		BinaryNode f = new BinaryNode(find);
		return search(f, root);
	}
	public boolean search(BinaryNode find, BinaryNode node){
		if(node == null)return false;
		
		else if(find.data ==  node.data)return true;
		
		else if(find.data > node.data)return search(find, node.right);

		else return search(find, node.left);
						
	
	}

	public void remove(int i){
		remove(i, root);
	}

	public void remove(int i, BinaryNode node){
		if(node == null) return;
		
		else if(i == node.data){//root being removed case
			
			if(node.left ==null&& node.right ==null){
				root = null;
				return;
			}
			else if(node.left !=null&& node.right ==null){
				root = node.left;
				return;
			}
			else if(node.left ==null&& node.right != null){
				root = node.right;
				return;
			}
			else{
				BinaryNode save = root;
				BinaryNode saveRight = root.right;
				
				root = nextNode(root);
				
				if(root.data == save.left.data){
					root.left = null;
					root.right = save.right;
				}
				else if(root.data == save.right.data){
					root.left = save.left;
					root.right = save.right.right;
				}
				else{
					root.left = save.left;
					root.right = save.right;
				}
			
			}	
			
		}
		
		else if(i > node.data){// travels to the right of the tree
			
			if(node.right.data == i){
				
				BinaryNode save = node.right;
				
				if(save.left ==null && save.right ==null){
					node.right = null;
					return;
				}
				
				node.right = nextNode(node.right);
				
				node =node.right;
				
				 if(node.data == save.left.data){
						node.left = save.left.left;
						node.right =save.right;
					}
					else if(node.data == save.right.data){
						node.left = save.left;
						node.right =save.right.right;
					}
					else{
						node.left = save.left;
						node.right = save.right;
					}
			}
			
			else 	remove(i, node.right); // travels to the right of the tree
			
		}
				
		else{ //travels to the left of the tree
			
			if(node.left.data == i){ 
												
				BinaryNode save = node.left;	
				if(save.left ==null && save.right ==null){
					node.left = null;
					return;
				}
				
				node.left = nextNode(node.left);	
				
				node =node.left;	
				
				 if(node.data == save.left.data){
					node.left = save.left.left;
					node.right =save.right;
				}
				else if(node.data == save.right.data){
					node.left = save.left;
					node.right =save.right.right;
				}
				else{
				node.left = save.left;
				node.right =save.right;
				}
				
				
			}
			else remove(i, node.left); // travels to the left of the tree
		}
			
		
	}
	
	// finds the node thats going to replace the the node being removed
	public BinaryNode nextNode(BinaryNode node){ 
		if(node.left == null && node.right ==null )return null;
		else if(node.left == null && node.right !=null) return node.right;
		else if(node.left != null && node.right == null) return node.left;
		
		else if(node.right.left == null){
			return node.right;
		}
		
		else{
			
		BinaryNode iter = node.right;
		BinaryNode parent  = iter;
		
		while(iter.left != null){ //iterates to the right left most node
			parent = iter;
			iter = iter.left;
		}
		
		parent.left = iter.right; // deletes the refrence of the node its returning
		return iter;
		}
	}
}
