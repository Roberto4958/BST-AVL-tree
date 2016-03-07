
public class AVLSearchTree <Integer>{
	
	private AVLnode root;
	
	public AVLSearchTree(int n){
		root = new AVLnode(n);
	}
	
	public AVLnode getRoot(){
		return root;
	}
	
	public int height(){
		return getHeight(root);
	}
	
	public int getHeight(AVLnode node){
		if (node ==null)return 0;
		else if(node.left == null && node.right == null)return 0;
		else{
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
		}
	}
	
	public void add(int n){
		AVLnode node = new AVLnode(n); 
		if(root == null)root = node;
		else add(node, root);
		
		checkIfBalence(root, root);		
	}
	public void add(int n, String s){
		AVLnode node = new AVLnode(n); 
		if(root == null)root = node;
		else add(node, root);
		
		checkIfBalenceNoPrint(root, root);	
	}
	
	public void add(AVLnode insert, AVLnode node){
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
		AVLnode f = new AVLnode(find);
		return search(f, root);
	}
	public boolean search(AVLnode find, AVLnode node){
		if(node == null)return false;
		
		else if(find.data ==  node.data)return true;
		
		else if(find.data > node.data)return search(find, node.right);

		else return search(find, node.left);
						
	
	}
	
	public void checkIfBalence(AVLnode node, AVLnode parent){
		int rightS;
		int leftS;
		
		if(node.left == null && node.right==null)return;
		
		
		if(node.left ==null)leftS=0;
		else leftS = getHeight(node.left)+1;
				
		if(node.right==null)rightS=0;
		else rightS = getHeight(node.right)+1;
		
		int weight = leftS-rightS;
		
		if(weight>1){
			
			if(getHeight(node.left.left) >= getHeight(node.left.right)){
				
				System.out.print("Single right Rotation ");
				
				if(root.data == node.data) root = singleRightRotation(node);
				
				else {
					
					try{
						if(parent.left.data == node.data) parent.left = singleRightRotation(node);
						else parent.right = singleRightRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = singleRightRotation(node);
					}
				}
			}
				
			else{
				System.out.print("Double Left Right Rotation Rotation ");
				
				if(root.data == node.data) root = doubleLeftRightRotation(node);
				
				else {					
					try{
						if(parent.left.data == node.data) parent.left = doubleLeftRightRotation(node);
						else parent.right = doubleLeftRightRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = doubleLeftRightRotation(node);
					}
				}
			
				
			}
		}
		else if(weight<-1){
			if(getHeight(node.right.left) <= getHeight(node.right.right)){
				System.out.print("Single Left Rotation ");
				
				if(root.data == node.data) root = singleLeftRotation(node);
				
				
				else {
					try{
						if(parent.left.data == node.data) parent.left = singleLeftRotation(node);
						else parent.right = singleLeftRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = singleLeftRotation(node);
					}
				}
			}
			else {
				System.out.print("Double Right Left Rotation Rotation ");
				if(root.data == node.data) root = doubleRightLeftRotation(node);
				
				else {					
					try{
						if(parent.left.data == node.data) parent.left = doubleRightLeftRotation(node);
						else parent.right = doubleRightLeftRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = doubleRightLeftRotation(node);
					}
				}
			}
		}
		if(node.left !=null)checkIfBalence(node.left, node);
		if(node.right !=null)checkIfBalence(node.right, node);
		//return true;
		
	}
	
	public void checkIfBalenceNoPrint(AVLnode node, AVLnode parent){
		int rightS;
		int leftS;
		
		if(node.left == null && node.right==null)return;
		
		
		if(node.left ==null)leftS=0;
		else leftS = getHeight(node.left)+1;
				
		if(node.right==null)rightS=0;
		else rightS = getHeight(node.right)+1;
		
		int weight = leftS-rightS;
		
		if(weight>1){
			
			if(getHeight(node.left.left) >= getHeight(node.left.right)){
				//System.out.print("Single right Rotation ");
				
				if(root.data == node.data) root = singleRightRotation(node);
				
				else {
					
					try{
						if(parent.left.data == node.data) parent.left = singleRightRotation(node);
						else parent.right = singleRightRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = singleRightRotation(node);
					}
				}
			}
				
			else{
				//System.out.print("Double Left Right Rotation Rotation ");
				
				if(root.data == node.data) root = doubleLeftRightRotation(node);
				
				else {					
					try{
						if(parent.left.data == node.data) parent.left = doubleLeftRightRotation(node);
						else parent.right = doubleLeftRightRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = doubleLeftRightRotation(node);
					}
				}
			
				
			}
		}
		else if(weight<-1){
			if(getHeight(node.right.left) <= getHeight(node.right.right)){
				//System.out.print("Single Left Rotation ");
				
				if(root.data == node.data) root = singleLeftRotation(node);
				
				
				else {
					try{
						if(parent.left.data == node.data) parent.left = singleLeftRotation(node);
						else parent.right = singleLeftRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = singleLeftRotation(node);
					}
				}
			}
			else {
				//System.out.print("Double Right Left Rotation Rotation ");
				if(root.data == node.data) root = doubleRightLeftRotation(node);
				
				else {					
					try{
						if(parent.left.data == node.data) parent.left = doubleRightLeftRotation(node);
						else parent.right = doubleRightLeftRotation(node);	
					}
					catch(NullPointerException e){
						parent.right = doubleRightLeftRotation(node);
					}
				}
			}
		}
		if(node.left !=null)checkIfBalenceNoPrint(node.left, node);
		if(node.right !=null)checkIfBalenceNoPrint(node.right, node);
		//return true;
		
		
	}
	
	private AVLnode singleRightRotation(AVLnode k2) // case 1 left-left rotation
	{
		//System.out.println("right rotation");

		AVLnode k1 = k2.getLeft();
		//System.out.println("k1 = "+ k1.data);

		k2.left = k1.right;
		k1.right=k2;
		//System.out.println("k1 left = "+ k1.left.data);
		//System.out.println("k1 = "+ k1.data);
		return k1;
	}
	
	private AVLnode singleLeftRotation(AVLnode k1)//case 4 right-right rotation
	{
		AVLnode k2 = k1.getRight();
		k1.right = k2.getLeft();
		k2.left = k1;
		return k2;
	}
	
	private AVLnode doubleLeftRightRotation(AVLnode k3)
	{
	 k3.left = singleLeftRotation(k3.getLeft());
	 return singleRightRotation(k3);
	}
	
	private AVLnode doubleRightLeftRotation(AVLnode k1)
	{
	 k1.right = singleRightRotation(k1.getRight());
	 return singleLeftRotation(k1);
	}
	
	public void remove(int i){
		remove(i, root);
		if(root !=null)checkIfBalence(root, root);
	}

	public void remove(int i, AVLnode node){
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
				AVLnode save = root;
				AVLnode saveRight = root.right;
				
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
				
				AVLnode save = node.right;
				
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
												
				AVLnode save = node.left;	
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
	public AVLnode nextNode(AVLnode node){ 
		if(node.left == null && node.right ==null )return null;
		else if(node.left == null && node.right !=null) return node.right;
		else if(node.left != null && node.right == null) return node.left;
		
		else if(node.right.left == null){
			return node.right;
		}
		
		else{
			
		AVLnode iter = node.right;
		AVLnode parent  = iter;
		
		while(iter.left != null){ //iterates to the right left most node
			parent = iter;
			iter = iter.left;
		}
		
		parent.left = iter.right; // deletes the refrence of the node its returning
		return iter;
		}
	}


}
