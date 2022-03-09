package co.com.johan.nodes.service;

import org.springframework.stereotype.Service;

import co.com.johan.nodes.dto.CommonAncestorResponseDTO;
import co.com.johan.nodes.dto.NodeDTO;
import co.com.johan.nodes.dto.TreeDTO;

@Service
public class TreeService {

	private static String pointerRight = "└───";
	private static String pointerBooth = "├───";

	/**
	 * Crate a tree and return an graph of this
	 * 
	 * @param tree
	 * @return
	 */
	public String createTree(TreeDTO tree) {
		return print(tree);
	}

	/**
	 * Receive an tree and two nodes and return a graph and the lowest common ancestor
	 *  
	 * @param tree
	 * @param firstNode
	 * @param secondNode
	 * @return
	 */
	public CommonAncestorResponseDTO findLowestCommonAncestor(TreeDTO tree, int firstNode, int secondNode) {
		CommonAncestorResponseDTO response = new CommonAncestorResponseDTO();
		response.setGraph(this.print(tree));
		response.setLowestCommonAncestor(this.lowestCommonAncestor(tree.getRoot(), firstNode, secondNode).getValue());
		return response;
	}

	/**
	 * Print first root node
	 * @param tree
	 * @return
	 */
	private String print(TreeDTO tree) {
		if (tree == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(tree.getRoot().getValue());

		String pointerLeft = (tree.getRoot().getRightNode() != null) ? pointerBooth : pointerRight;
		printNode(tree.getRoot().getLeftNode(), sb, "", pointerLeft, tree.getRoot().getRightNode() != null);
		printNode(tree.getRoot().getRightNode(), sb, "", pointerRight, false);
		return sb.toString();
	}

	/**
	 * Print all nodes from tree
	 * @param node
	 * @param treeGraph
	 * @param padding
	 * @param pointer
	 * @param hasRight
	 */
	private void printNode(NodeDTO node, StringBuilder treeGraph, String padding, String pointer, boolean hasRight) {
		if (node != null) {
			treeGraph.append("\n");
			treeGraph.append(padding);
			treeGraph.append(pointer);
			treeGraph.append(node.getValue());

			StringBuilder paddingBuilder = new StringBuilder(padding);
			if (hasRight) {
				paddingBuilder.append("│  ");
			} else {
				paddingBuilder.append("   ");
			}
			String pointerForRight = pointerRight;
			String pointerForLeft = (node.getRightNode() != null) ? pointerBooth : pointerRight;
			printNode(node.getLeftNode(), treeGraph, paddingBuilder.toString(), pointerForLeft,
					node.getRightNode() != null);
			printNode(node.getRightNode(), treeGraph, paddingBuilder.toString(), pointerForRight, false);
		}
	}

	/**
	 * Find lowest common ancestor from a binary tree 
	 * @param node
	 * @param firstNode
	 * @param secondNode
	 * @return
	 */
	public NodeDTO lowestCommonAncestor(NodeDTO node, int firstNode, int secondNode) {
		if (node == null)
			return null;

		if (node.getValue() == firstNode || node.getValue() == secondNode)
			return node;

		NodeDTO leftLowerCommon = lowestCommonAncestor(node.getLeftNode(), firstNode, secondNode);
		NodeDTO rightLowerCommon = lowestCommonAncestor(node.getRightNode(), firstNode, secondNode);
		if (leftLowerCommon != null && rightLowerCommon != null)
			return node;

		return (leftLowerCommon != null) ? leftLowerCommon : rightLowerCommon;
	}

	
	/**
	 * Fin a lower common ancestor from a binary search tree
	 * @param node
	 * @param firtsNode
	 * @param secondNode
	 * @return
	 */
	public static NodeDTO lowestCommonAncestorBinarySearch(NodeDTO node, int firtsNode, int secondNode) {
		if (node == null)
			return null;

		if (node.getValue() > firtsNode && node.getValue() > secondNode) {
			return lowestCommonAncestorBinarySearch(node.getLeftNode(), firtsNode, secondNode);
		}
		if (node.getValue() < firtsNode && node.getValue() < secondNode) {
			return lowestCommonAncestorBinarySearch(node.getRightNode(), firtsNode, secondNode);
		}
		return node;
	}

}
