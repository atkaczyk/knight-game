public class Pawn {
	int x;
	int y;
	boolean validMove;
	String direction;

	public Pawn(int xPos, int yPos, String d){
		x = xPos;
		y  = yPos;
		direction = d;
	}

	public void movePawn(){
		if(direction.equals("LEFT")){
			setX( this.x -1);
			direction = "RIGHT";
		}
		else if(direction.equals("RIGHT")){
			setX(this.x + 1);
			direction = "LEFT";

		} else if(direction.equals("UP")){
			setY(this.y  + 1);
			direction = "DOWN";

		}else if(direction.equals("DOWN")){
			setY(y- 1);
			direction = "UP";
		}
	}

	public void setX(int i){
		x = i;
	}
	public void setY(int i){
		y  = i;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String getDirection(){
		return direction;
	}
}
