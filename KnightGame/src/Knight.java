
public class Knight {
	int x;
	int y; 
	boolean validMove;

	public Knight(){
		this.x= 10;
		this.y= 10;
	}

	public boolean checkValidMove(int row, int col){
		if(col == (this.x + 1) && ((row == this.y+ 2) ||(row == this.y- 2)) ){
			System.out.println("valid");
			return true;
		}
		else if (col == (this.x- 1) && ((row == this.y+ 2) ||(row == this.y- 2))){
			System.out.println("valid");
			//setNewKnight(row, col);
			return true;

		}
		 else if (col == (this.x- 2) && ((row == this.y+ 1) ||(row == this.y- 1))){
			System.out.println("valid");
			//setNewKnight(row, col);
			return true;

		}
		else if (col == (this.x + 2) && ((row == this.y+ 1) ||(row == this.y- 1))){
			System.out.println("valid");
			//setNewKnight(row, col);
			return true;

		}
		else{
			System.out.println("NOT valid");
			//System.out.println("you pressed is : " + col + " " + row + " the knight is on : " + this.x  + " " + this.y );
			return false;
		}
	}

	public void setNewKnight(int row, int col) {
		this.x= col;
		this.y = row;
		
	}

	public int getX(){
		return x;

	}

	public int getY(){
		return y;
	}

	public void setX(int trow) {
		this.x= trow;	
	}


	public void setY(int tcol) {
		this.y= tcol;	

	}
}


