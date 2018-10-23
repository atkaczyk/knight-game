
public class Node {
	
	private Node parent;
	private BoardState boardState;
	
	public Node(BoardState boardState, Node parent){

		this.parent = parent;
		this.boardState = boardState;
		
	}
	
	public BoardState getBoardState() {
		return boardState;
	}
	
	public Node getParent() {
		return parent;
	}
	
}
