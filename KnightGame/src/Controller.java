import java.util.ArrayList;

public class Controller {
	
	TableDisplay tableDisplay;
	BoardState board;
	ArrayList<BoardState> boards;
	BFS bfs;
	

	public Controller(TableDisplay tableDisplay) {
		this.tableDisplay = tableDisplay;
		board =new BoardState();
		updateBoard();
	}

	public void checkValidMove(int i, int k){
		//Knight k = 
		if(board.getKnight().checkValidMove(i,k)){
			board.getKnight().setNewKnight(i, k);
			updateBoard();
		}

	}
	public void updatePawn() {
		for (int i = 0; i < board.getPawns().size(); i++){
			board.getPawns().get(i).movePawn();
		}
	}

	public void updateBoard(){
		checkCapture();
		updatePawn();
		checkCapture();
		if(checkWin()){
			tableDisplay.endGame();
		}
		tableDisplay.update(board);
	}

	public boolean checkCapture(){
		for (int i = 0; i < board.getPawns().size(); i++){
			if(board.getPawns().get(i).getX() == board.getKnight().getX() && board.getPawns().get(i).getY() == board.getKnight().getY()){
				board.getPawns().remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean checkWin(){
		if(board.getPawns().size() <= 0){
			System.out.println("GAME OVER BETCH");
			return true;
		}
		return false;
	}
	
	
	public int[][] generateStates(int[] currentState){
		int[][] possibleOutcomes = new int[4][4];
		updatePawn();
		
		for (int i = 0; i < board.getPawns().size(); i = i+2){
			currentState[i+2] = board.getPawns().get(i).getX();
			currentState[i+3] = board.getPawns().get(i).getY();
		}
		
		currentState[0] = board.getKnightX() + 2;
		currentState[1] = board.getKnightY() + 1;
		possibleOutcomes[0] = currentState;
		
		currentState[0] = board.getKnightX() + 2;
		currentState[1] = board.getKnightY() - 1;
		possibleOutcomes[1] = currentState;
		
		currentState[0] = board.getKnightX() - 2;
		currentState[1] = board.getKnightY() + 1;
		possibleOutcomes[2] = currentState;
		
		currentState[0] = board.getKnightX() - 2;
		currentState[1] = board.getKnightY() - 1;
		possibleOutcomes[3] = currentState;
		
		currentState[0] = board.getKnightX() + 1;
		currentState[1] = board.getKnightY() + 2;
		possibleOutcomes[4] = currentState;
		
		currentState[0] = board.getKnightX() + 1;
		currentState[1] = board.getKnightY() - 2;
		possibleOutcomes[5] = currentState;
		
		currentState[0] = board.getKnightX() - 1;
		currentState[1] = board.getKnightY() + 2;
		possibleOutcomes[6] = currentState;
		
		currentState[0] = board.getKnightX() - 1;
		currentState[1] = board.getKnightY() - 2;
		possibleOutcomes[7] = currentState;
	
		return possibleOutcomes;
	}

	public void bfs() {
		boards = bfs.getMoves(board);
		
	}

	public void updateBFS() {
		//board = boards.remove();
		updateBoard();
	}

}
