/*
 * 2019 KAKAO BLIND RECRUITMENT
 * 길 찾기 게임
 * Java
 */

import java.util.Arrays;
import java.util.ArrayList;

public class DirectionGame {
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        
        Node[] tree = new Node[nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            tree[i] = new Node(i+1, nodeinfo[i]);
        }
        Arrays.sort(tree, (a, b) -> {
                if(a.position[1] == b.position[1]){
                    return a.position[0] - b.position[0];
                }
                return b.position[1] - a.position[1];
            });
        
        Node root = tree[0];
        Node parent;
        Node cur;
        for(int i=1; i < tree.length; i++){
            
            // 재귀
            // connectNode(root, tree[i]);
            
            // 반복문
            parent = root;
            cur = tree[i];
            while(true){
                if(cur.position[0] > parent.position[0]){
                    if(parent.right == null){
                        parent.right = cur;
                        break;
                    }
                    parent = parent.right;
                }
                else{
                    if(parent.left == null){
                        parent.left = cur;
                        break;
                    }
                    parent = parent.left;
                };
            }
        }
        preOrder(root);
        postOrder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        return answer;
    }
    
    class Node {
        int idx;
        int[] position;
        Node left;
        Node right;
        Node parent;
        
        public Node(int idx, int[] position){
            this.idx = idx;
            this.position = position;
        }
    }
    // 트리 구성 재귀 방식
    public void connectNode(Node parent, Node current){
        if(current.position[0] > parent.position[0]){
            if(parent.right == null) parent.right = current;
            else connectNode(parent.right, current);
        }else{
            if(parent.left == null) parent.left = current;
            else connectNode(parent.left, current);
        }
    }
    //전위순회 Preorder : Root -> Left -> Right
    public void preOrder(Node node) {
        if(node != null) {
            preorder.add(node.idx);
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    //후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            postorder.add(node.idx);
        }
    }
}
