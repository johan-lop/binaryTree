package co.com.johan.nodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.johan.nodes.dto.CommonAncestorRequestDTO;
import co.com.johan.nodes.dto.CommonAncestorResponseDTO;
import co.com.johan.nodes.dto.TreeDTO;
import co.com.johan.nodes.service.TreeService;

@RestController()
@RequestMapping("/api/tree")
public class TreeController {

	@Autowired
	private TreeService treeService;

	@PostMapping()
	public String getDefaultTree(@RequestBody TreeDTO tree) {
		return treeService.createTree(tree);
	}

	@PostMapping(value = "/lowerCommonAncestor")
	public CommonAncestorResponseDTO findLowerCommonAncestor(@RequestBody CommonAncestorRequestDTO request) {
		return treeService.findLowestCommonAncestor(request.getTree(), request.getFirstNode(), request.getSecondNode());
	}	

}
