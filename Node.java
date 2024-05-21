import java.util.ArrayList;
import java.util.Stack;

public class Node {
    private String element;
    private Node parent;
    private ArrayList<Node> children;
    private int thchild;

    public Node(String root) {
        children = new ArrayList<>();
        this.parent = null;
        this.element = root;
        thchild=0;
    }

    public Node(Node parent, String value) {
        children = new ArrayList<>();
        this.parent = parent;
        this.element = value;
    }

    public String getElement() {
        return element;
    }
    public void setElement(String s) {
         this.element=s;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getChild(int index) {
        return children.get(index);
    }

    public void addChild() {
        children.add(new Node(this, ""));
    }

    public void addChild(String element) {
        children.add(new Node(this, element));
        thchild++;
    }

    public void setValue(String element) {
        this.element = element;
    }

    public int getSize() {
        return children.size();
    }

    public boolean isEmpty() {
        return element.equals("");
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
    public int getThchild() {
    	return this.thchild;
    	
    }
    public void setThchild() {
    	this.thchild++;
    	
    }
    
    
    public void traverse() {
       
    	if(parent!=null)
    		System.out.println("Parent: " + parent.getElement() + "\tChildCount: " + getSize() + "\tIsLeaf: " + isLeaf() + "\tValue: " + element);
    	else
    		System.out.println( getElement() + "\tChildCount: " + getSize() + "\tIsLeaf: " + isLeaf() + "\tValue: " + element);
    	for(Node node : children)
            node.traverse();
    }
   
    public boolean isHeap(Node node){
    	
    	Stack<Node> nodes = new Stack<>();
     
         nodes.push(node);
     
        while (!nodes.isEmpty()) 
        {
             
            Node curr = nodes.pop();
     
            if (curr != null)
            {
            	if(curr.parent!=null) {
            		if(curr.getElement().charAt(1)<48 || curr.getElement().charAt(1)>57)
            			for(int i=0;i<curr.children.size();i++) {
            				if(curr.children.get(i).getElement().charAt(1)<48 || curr.children.get(i).getElement().charAt(1)>57)//not digit
            					if(curr.getElement().charAt(1)>curr.children.get(i).getElement().charAt(1)) {
            						return false;
            					}
            						
            			}	
                    
            	}else {
            		if(curr.getElement().charAt(0)<48 || curr.getElement().charAt(0)>57)
            			for(int i=0;i<curr.children.size();i++) {
            				if(curr.children.get(i).getElement().charAt(1)<48 || curr.children.get(i).getElement().charAt(1)>57)//not digit
            					if(curr.getElement().charAt(0)>curr.children.get(i).getElement().charAt(1)) {
            						return false;
            					}
            						
            			}	
                    
            		
            		
            	}
                for(int i = curr.children.size() - 1; i >= 0; i--) 
                {
                    nodes.add(curr.children.get(i));
                } 
            }
        }
     
        return true;
    	
    } 
	    
}    