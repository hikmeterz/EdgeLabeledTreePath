public class Tree {
    private Node root;

    public Tree(String roott) {
        root = new Node(roott);
    }

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root.isEmpty();
    }

    public void traverse() {
        if(!isEmpty())
            root.traverse();
    }
    
    
    
    
}