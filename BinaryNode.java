
public class BinaryNode <Integer>{ 
    int data; 
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int i) { 
    	data =i;
    	left=null;
    	right =null;
    }
    public BinaryNode() { 
    	left=null;
    	right =null;
    } 
    public int getData(){
    	return data;
    }
    public BinaryNode getRight(){
    	return right;
    }
    public BinaryNode getLeft(){
    	return left;
    }

 
}
