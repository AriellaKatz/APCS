/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 97 - Prune Your Tree
2022-05-11
time spent: 1.0 hrs
*/

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if (_root == null) { _root = newNode; }
    else { insert(_root, newNode); }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      if (stRoot.getLeft() == null) { stRoot.setLeft(newNode); }
      else {
        TreeNode left = stRoot.getLeft();
        insert(left, newNode);
      }
    }
    else {
      if (stRoot.getRight() == null) { stRoot.setRight(newNode); }
      else {
        TreeNode right = stRoot.getRight();
        insert(right, newNode);
      }
    }
  }//end insert()

  /**
   * TreeNode remove( int )
   * Removes a data element from tree.
   */
  public TreeNode remove( int val )
  {
    TreeNode node = search(val);
    return remove(findParent(_root, node), node);
  }
  //helper for remove(int)
  public TreeNode remove( TreeNode parent, TreeNode node )
  {
    boolean isLeft = (parent.getLeft().getValue() == node.getValue());
    //if node has no children:
    if (node.getRight() == null && node.getLeft() == null) {
      if (isLeft) {
        parent.setLeft(null);
      }
      else {
        parent.setRight(null);
      }
    }
    //if node has one child:
    else if (node.getRight() == null) {
      if (isLeft) {
        parent.setLeft(node.getLeft());
      }
      else {
        parent.setRight(node.getLeft());
      }
    }
    else if (node.getLeft() == null) {
      if (isLeft) {
        parent.setLeft(node.getRight());
      }
      else {
        parent.setRight(node.getRight());
      }
    }
    //if node has two children:
    else {
      TreeNode tn = node.getLeft();
      while (tn.getRight() != null) {
        tn = tn.getRight();
      }
      TreeNode pt = findParent(node, tn);
      node.setValue(tn.getValue());
      //if replacement has no children:
      if (tn.getLeft() == null) {
        pt.setRight(null);
      }
      //if replacement has children (it will be a left child):
      else {
        pt.setRight(tn.getLeft());
      }
    }
    return node;
  }//end remove()
  //recursive helper for remove(int)
  //returns null if the node isn't even there
  public TreeNode findParent(TreeNode stRoot, TreeNode node)
  {
    if (stRoot.getLeft().getValue() == node.getValue()
    || stRoot.getRight().getValue() == node.getValue()) {
      return stRoot;
    }
    else if (search(node.getValue(), stRoot.getLeft()) != null) {
      return findParent(stRoot.getLeft(), node);
    }
    else if (search(node.getValue(), stRoot.getRight()) != null) {
      return findParent(stRoot.getRight(), node);
    }
    else { return null; }
  }



  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    System.out.println(currNode.getValue());
    if (currNode.getLeft() != null) {
      preOrderTrav(currNode.getLeft());
    }
    if(currNode.getRight() != null) {
      preOrderTrav(currNode.getRight());
    }
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
      inOrderTrav(currNode.getLeft());
    }
    System.out.println(currNode.getValue());
    if(currNode.getRight() != null) {
      inOrderTrav(currNode.getRight());
    }
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
      postOrderTrav(currNode.getLeft());
    }
    if(currNode.getRight() != null) {
      postOrderTrav(currNode.getRight());
    }
    System.out.println(currNode.getValue());
  }


      /*****************************************************
       * TreeNode search(int)
       * returns pointer to node containing target,
       * or null if target not found
       *****************************************************/
      public TreeNode search( int target )
      {
        return search(target, _root);
      }
      public TreeNode search(int target, TreeNode stRoot){
        if (stRoot.getValue() == target){
          return stRoot;
        }
        else if (target < stRoot.getValue()){
          if (stRoot.getLeft() == null) {return null;} //return null if the node is not there
          return search(target, stRoot.getLeft());
        }
        else{
          if (stRoot.getRight() == null) {return null;}
          return search(target, stRoot.getRight());
        }
      }


      /*****************************************************
       * int height()
       * returns height of this tree (length of longest leaf-to-root path)
       * eg: a 1-node tree has height 0
       *****************************************************/
      public int height()
      {
      	return height(_root);
      }
      public int height(TreeNode stRoot) {
        if (stRoot.getLeft() == null && stRoot.getRight() == null){
          return 1;
        }
        if (stRoot.getRight() == null){
          return height(stRoot.getLeft()) + 1;
        }
        if (stRoot.getLeft() == null){
          return height(stRoot.getRight()) + 1;
        }
        int n = height(stRoot.getLeft());
        int m = height(stRoot.getRight());
        if (n > m) {return n;}
        else{
          return m;
        }
      }

      /*****************************************************
       * int numLeaves()
       * returns number of leaves in tree
       *****************************************************/
      public int numLeaves()
      {
      	return numLeaves(_root);
      }
      public int numLeaves(TreeNode stRoot){
        if (stRoot.getLeft() == null && stRoot.getRight() == null){
          return 1;
        }
        if (stRoot.getRight() != null && stRoot.getLeft() != null){
          return numLeaves(stRoot.getRight()) + numLeaves(stRoot.getLeft());
        }
        else if (stRoot.getRight() != null){
          return numLeaves(stRoot.getRight());
        }
        else {
          return numLeaves(stRoot.getLeft());
        }
      }



  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public String toString() {
    return "";
  }


  //main method for testing
  public static void main( String[] args ) {

  	BST arbol = new BST();

  	System.out.println( "tree init'd: " + arbol );

  	//inserting in this order will build a perfect tree
  	arbol.insert( 3 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	arbol.insert( 2 );
  	arbol.insert( 5 );
  	arbol.insert( 4 );
  	arbol.insert( 6 );
  	/*
  	*/

  	//insering in this order will build a linked list to left
  	/*
  	arbol.insert( 6 );
  	arbol.insert( 5 );
  	arbol.insert( 3 );
  	arbol.insert( 4 );
  	arbol.insert( 2 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	*/

  	System.out.println( "tree after insertions:\n" + arbol );
  	System.out.println();

  	System.out.println();
  	for( int i=-1; i<8; i++ ) {
  	    System.out.println(" searching for "+i+": " + arbol.search(i) );
  	}

  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(6);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(5);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(4);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(3);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(2);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(1);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(0);
  	System.out.println();
  	System.out.println( arbol );
  }

}//end class
