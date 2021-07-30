public class CTCIFirstCommonAncestor {
    public static void main(String[] args) {
        try{
            CTCIFirstCommonAncestor obj = new CTCIFirstCommonAncestor();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Creates the data(Binary Tree)
        Node node = new Node(14);
        node.leftNode = new Node(6);
        node.leftNode.leftNode = new Node(3);
        node.leftNode.leftNode.leftNode = new Node(1);
        node.leftNode.leftNode.rightNode = new Node(5);
        node.leftNode.rightNode = new Node(8);
        node.leftNode.rightNode.leftNode = new Node(7);
        node.leftNode.rightNode.rightNode = new Node(11);
        node.rightNode = new Node(21);
        node.rightNode.leftNode = new Node(18);
        node.rightNode.rightNode = new Node(25);
        node.rightNode.leftNode.leftNode = new Node(15);
        node.rightNode.leftNode.rightNode = new Node(19);
        node.rightNode.rightNode.leftNode = new Node(24);
        node.rightNode.rightNode.rightNode = new Node(27);
        //Prints the value of common ancestor
        System.out.println(findCommonAncestor(node.leftNode.leftNode.leftNode,node.rightNode,node).num);
    }
    public Node findCommonAncestor(Node node1,Node node2,Node topNode){
        Object[] finalNode = new Object[]{null};
        recursiveNodeFinder(node1,node2,topNode,finalNode);
        return (Node)finalNode[0];
    }
    public boolean recursiveNodeFinder(Node node1,Node node2,Node currNode,Object[] finalNode){
        int numOfNodesFound = 0;
        boolean isTrue = false;
        if(currNode.leftNode != null && recursiveNodeFinder(node1,node2,currNode.leftNode,finalNode)){
            isTrue = true;
            numOfNodesFound++;
        }
        if(currNode.rightNode != null && recursiveNodeFinder(node1,node2,currNode.rightNode,finalNode)){
            isTrue = true;
            numOfNodesFound++;
        }
        if(currNode == node1 || currNode == node2){
            numOfNodesFound++;
            isTrue = true;
        }
        if(numOfNodesFound == 2){
            finalNode[0] = currNode;
        }
        return isTrue;
    }
}
class Node {
    public int num;
    public Node leftNode;
    public Node rightNode;
    public Node(){}
    public Node(int num){
        this.num = num;
    }
    public Node(int num,Node leftNode,Node rightNode){
        this.num = num;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}