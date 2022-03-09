package co.com.johan.nodes;

import co.com.johan.nodes.dto.NodeDTO;
import co.com.johan.nodes.dto.TreeDTO;
import co.com.johan.nodes.service.TreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest
class TreeNodesApplicationTests {

    private TreeService treeService;

    @BeforeEach
    void setUp() {
        treeService = new TreeService();
    }

    @Test
    void lowestCommonAncestor2944() {
        AssertionErrors.assertEquals("29 44", 39, treeService.lowestCommonAncestor(createTree().getRoot(), 29, 44).getValue());
    }

    @Test
    void lowestCommonAncestor4485() {
        AssertionErrors.assertEquals("44 85", 67, treeService.lowestCommonAncestor(createTree().getRoot(), 44, 85).getValue());
    }

    @Test
    void lowestCommonAncestor8387() {
        AssertionErrors.assertEquals("83 87", 85, treeService.lowestCommonAncestor(createTree().getRoot(), 83, 87).getValue());
    }

    TreeDTO createTree() {
        TreeDTO tree = new TreeDTO();
        tree.setRoot(new NodeDTO(67));
        tree.getRoot().setLeftNode(new NodeDTO(39));
        tree.getRoot().setRightNode(new NodeDTO(76));
        tree.getRoot().getLeftNode().setLeftNode(new NodeDTO(28));
        tree.getRoot().getLeftNode().setRightNode(new NodeDTO(44));
        tree.getRoot().getLeftNode().getLeftNode().setRightNode(new NodeDTO(29));
        tree.getRoot().getRightNode().setLeftNode(new NodeDTO(74));
        tree.getRoot().getRightNode().setRightNode(new NodeDTO(85));
        tree.getRoot().getRightNode().getRightNode().setLeftNode(new NodeDTO(83));
        tree.getRoot().getRightNode().getRightNode().setRightNode(new NodeDTO(87));
        return tree;
    }
}
