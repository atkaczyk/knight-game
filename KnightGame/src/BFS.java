import java.util.ArrayList;
import java.util.PriorityQueue;

public class BFS {
	
	Controller control;
	
	public ArrayList<BoardState> getMoves(BoardState board) {
		
		PriorityQueue pq = new PriorityQueue();
		if(board.getPawns().size() <= 0){
			System.out.println("Game Over");
			return boards;
		}
		return null;
	}

}
