package com.bdqn.bst.tree;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	private static class BinaryNode<AnyType>{
		BinaryNode(AnyType theElement){
			this(theElement,null,null);
		}
		BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
			
		}
		AnyType element;
		BinaryNode<AnyType> lt;
		BinaryNode<AnyType> rt;
	}
	
	private BinaryNode<AnyType> root;//¸ù½Úµã
	public BinarySearchTree(){
		this.root=null;
	}
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public boolean contains(AnyType x){
		return contains(x,root);
	}
	
	public AnyType findMin(){
		if(isEmpty())throw new RuntimeException();
		return findMin(root).element;
	}
	
	public AnyType findMax(){
		if(isEmpty())throw new RuntimeException();
		return findMax(root).element;
	}

	public void insert(AnyType x){
		root=insert(x,root);
	}

	public void remove(AnyType x){
		root=remove(x,root);
	}
	public boolean contains(AnyType x,BinaryNode<AnyType> node){
		if(node==null)
			return false;
		int compareResult=x.compareTo(node.element);
		if(compareResult>0){
			return contains(x,node.rt);
		}else if(compareResult<0){
			return contains(x,node.lt);
		}else{
			return true;
		}
	}
	public void printTree(){
		printTree(root);
	}
	private void printTree(BinaryNode<AnyType> node){
		
	}
	private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> node){
		if(node==null){
			return node;
		}
		int result=x.compareTo(node.element);
		if(result<0){
			node.lt=remove(x,node.lt);
		}else if(result>0){
			node.rt=remove(x,node.rt);
		}else if(node.lt!=null&&node.rt!=null){
			node.element=findMin(node.rt).element;
			node.rt=remove(node.element,node.rt);
		}else{
			node=(node.lt!=null)?node.lt:node.rt;
		}
		return node;
	}
	private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> node){
		if(node==null){
			return new BinaryNode(x,null,null);
		}
		int result=x.compareTo(node.element);
		if(result>0){
			node.rt=insert(x,node.rt);
		}else if(result <0){
			node.lt=insert(x,node.lt);
		}
		return node;
	}
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node){
		if(node==null){
			return null;
		}else if(node.rt==null){
			return node;
		}else{
			return findMax(node.rt);
		}
	}
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node){
		if(node==null){
			return null;
		}else if(node.lt==null){
			return node;
		}else{
			return findMin(node.lt);
		}
	}
}
