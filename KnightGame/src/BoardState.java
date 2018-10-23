import java.awt.Component;
import java.util.ArrayList;

public class BoardState {
	//inlcludes knight position
	//includes pawn arraylist position

	Knight knight = new Knight();
	ArrayList<Pawn> pawn = new ArrayList <Pawn>();
	//BoardState parent = new BoardState();


	int[] boardState;
	public BoardState() {
		
		knight.setNewKnight(10,10 );
		pawn.add(new Pawn(2, 3, "UP"));
		pawn.add(new Pawn(5, 7, "DOWN"));
		pawn.add(new Pawn(5, 12, "LEFT"));
		pawn.add(new Pawn(10, 12, "RIGHT"));
	}
	
	public BoardState(BoardState p) {
		
		
		knight.setNewKnight(10,10 );
		pawn.add(new Pawn(2, 3, "UP"));
		pawn.add(new Pawn(5, 7, "DOWN"));
		pawn.add(new Pawn(5, 12, "LEFT"));
		pawn.add(new Pawn(10, 12, "RIGHT"));
	}


	//return the knight and the pawns here , store them for when you need to search
	public void setBoardState(){
		boardState[0] = getKnightX();
		boardState[1] = getKnightY();

		for (int i = 0; i < pawn.size(); i = i+2){
			boardState[i+2] = pawn.get(i).getX();
			boardState[i+3] = pawn.get(i).getY();
		}
	}


 
//when the values have been changed,
	public void updateBoardState(int[] finalState){
		setKnightX(finalState[0]);
		setKnightY(finalState[1]);
		for (int i = 0; i < boardState.length; i = i+2){
			setPawnX(pawn.get(i), finalState[i+2]);
			setPawnY(pawn.get(i), finalState[i+3]);
		}
	}

	public int getNumPawns() {
		return pawn.size();
	}

	public int getPawnX(int i) {
		return pawn.get(i).getX();
	}

	public int getPawnY(int i) {
		return pawn.get(i).getY();
	}

	public int getKnightX() {
		return knight.getX();
	}
	public int getKnightY() {
		return knight.getY();
	}
	public void setKnightX(int i) {
		knight.setX(i);
	}
	public void setKnightY(int i) {
		knight.setY(i);
	}
	public void setPawnX(Pawn pawn, int i) {
		pawn.setX(i);
	}
	public void setPawnY(Pawn pawn, int i) {
		pawn.setY(i);
	}

	//	public void updateKnight(int row, int col) {
	//		knight.setNewKnight(row, col);

	public Knight  getKnight() {
		return knight;
	}

	public ArrayList<Pawn> getPawns() {
		// TODO Auto-generated method stub
		return pawn;
	}

	//	}
}
