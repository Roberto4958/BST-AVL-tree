
public class AVLnode <Integer> {
	   int data; 
	   AVLnode left;
	   AVLnode right;

	    public AVLnode(int i) { 
	    	data =i;
	    	left=null;
	    	right =null;
	    }
	    public AVLnode() { 
	    	left=null;
	    	right =null;
	    } 
	    public int getData(){
	    	return data;
	    }
	    public AVLnode getRight(){
	    	return right;
	    }
	    public AVLnode getLeft(){
	    	return left;
	    }
	    public boolean isBalance(){
	    	if(getHeight(right)-getHeight(left) > 1 || getHeight(right)-getHeight(left) < -1)return false;
	    	else return true;
	    }
	    public int getHeight(AVLnode node){
			if (node ==null)return 0;
			else if(node.left == null && node.right == null)return 0;
			else{
				return Math.max(getHeight(node.left), getHeight(node.right))+1;
			}
		}
}
