package co.com.johan.nodes.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NodeDTO {

	@JsonCreator
	public NodeDTO(Integer value) {
		this.value = value;
		this.leftNode = this.rightNode = null;
	}

	private Integer value;

	private NodeDTO leftNode;

	private NodeDTO rightNode;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public NodeDTO getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(NodeDTO leftNode) {
		this.leftNode = leftNode;
	}

	public NodeDTO getRightNode() {
		return rightNode;
	}

	public void setRightNode(NodeDTO rightNode) {
		this.rightNode = rightNode;
	}

}
