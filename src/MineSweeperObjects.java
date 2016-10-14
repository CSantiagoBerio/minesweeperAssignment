//import java.awt.Color;
//import java.util.Random;
//
//public class MineSweeperObjects {
//	
//	private int xCoordinate;
//	private int yCoordinate;
//	private Color mineColor;
//	private Random randCoordinate;
//	private MineSweeperObjects[][] objectMine;
//	
//	MineSweeperObjects(){
//		this.setMineColor(Color.BLACK);
//	}
//	
//	
//	
//	public boolean mineVerify(int xLoc, int yLoc){		
//		if(this.objectMine[xLoc][yLoc].getMineColor().equals(Color.BLACK)){
//			System.out.println("GAME OVER, YOU HAVE LOST!!");
//			return true;
//		}		
//		return false;
//								
//	}
//	
//	public  void addMines(MineSweeperObjects mineObj, int xCoordinate, int yCoordinate, Color c){
//		mineObj = new MineSweeperObjects();
//		this.mineColor = c;
//		objectMine[xCoordinate][yCoordinate] = mineObj;
//		}
//	
//	
//	
//
//	public int getxCoordinate() {
//		return xCoordinate;
//	}
//
//	public void setxCoordinate(int xCoordinate) {
//		this.xCoordinate = xCoordinate;
//	}
//
//	public int getyCoordinate() {
//		return yCoordinate;
//	}
//
//	public void setyCoordinate(int yCoordinate) {
//		this.yCoordinate = yCoordinate;
//	}
//
//	public Color getMineColor() {
//		return mineColor;
//	}
//
//	public void setMineColor(Color mineColor) {
//		this.mineColor = mineColor;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
