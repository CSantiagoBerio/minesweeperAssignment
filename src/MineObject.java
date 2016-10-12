import java.awt.Color;


public class MineObject {
	
	private boolean beenClicked = false;
	private int xCoordinate;
	private int yCoordinate;
	private Color mineColor; 
	

	public MineObject(int xCoordinate, int yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		
	}
	
	public boolean hasBeenClicked(){
		return beenClicked;
	}
	
	public void sethasBeenClicked(boolean clicked){
		beenClicked = clicked;
	}

	public int getxCoordinate() { return xCoordinate; }


	public int getyCoordinate() { return yCoordinate; }


	public Color setMineColor(Color mineColor){
		return this.mineColor = mineColor;
	}

	public Color getMineColor() {
		return mineColor;
	}
	
	
	
	
	
	
	
	
	
	

}