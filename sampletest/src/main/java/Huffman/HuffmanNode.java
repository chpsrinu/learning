package Huffman;

public class HuffmanNode extends HuffmanTree {

	private HuffmanTree rightTree;
	private HuffmanTree leftTree;
	
	public HuffmanNode(HuffmanTree rightTree, HuffmanTree leftTree) {
		super(rightTree.getFrequency()+leftTree.getFrequency());
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
}
