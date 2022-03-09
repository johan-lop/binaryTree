package co.com.johan.nodes.dto;

public class CommonAncestorRequestDTO {

	private TreeDTO tree;

	private Integer firstNode;

	private Integer secondNode;

	public TreeDTO getTree() {
		return tree;
	}

	public void setTree(TreeDTO tree) {
		this.tree = tree;
	}

	public Integer getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Integer firstNode) {
		this.firstNode = firstNode;
	}

	public Integer getSecondNode() {
		return secondNode;
	}

	public void setSecondNode(Integer secondNode) {
		this.secondNode = secondNode;
	}

}
