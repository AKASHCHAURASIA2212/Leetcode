// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.reverseLevelOrder(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}


 
// } Driver Code Ends



/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree
{

    //  public void levelorder(Node root,ArrayList<Integer> li)
    //  {
    //       if(root==null)
    //       {
    //           return;
    //       }
         
    //      levelorder(root.left,li);
    //      levelorder(root.right,li);
         
    //      li.add(root.data);
         
    //      // sideView(root.left,li);
    //  }
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
           ArrayList<Integer> li = new ArrayList<>();
        
        // if(node==null)
        // {
        //   return li ; 
        // }
        
        Queue<Node> qu = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        qu.add(node);
        
        while(qu.size()>0)
        {
            int size = qu.size();
            while(size-->0)
            {
                Node temp = qu.remove();
                st.add(temp.data);
                
                 if(temp.right!=null)
                {
                    qu.add(temp.right);
                }
                
                if(temp.left!=null)
                {
                    qu.add(temp.left);
                }
            }
        }
        
        while(st.size()>0)
        {
            li.add(st.pop());
        }
        
        return li;
        
    }
}      