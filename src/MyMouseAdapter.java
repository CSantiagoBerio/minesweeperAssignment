import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {

	public int xGrid;
	public int yGrid;
	private Color MineColor = Color.BLACK;
	private Color FlagColor = Color.RED;

	public void mousePressed(MouseEvent e) {
		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame) c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
		Insets myInsets = myFrame.getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		int x = e.getX();
		int y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		myPanel.mouseDownGridX = myPanel.getGridX(x, y);
		myPanel.mouseDownGridY = myPanel.getGridY(x, y);
		myPanel.repaint();


		switch (e.getButton()) {
		case 1:		//Left mouse button

			break;
		case 3:		
			//Right mouse button
			//Do nothing

			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame)c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
		Insets myInsets = myFrame.getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		int x = e.getX();
		int y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		int gridX = myPanel.getGridX(x, y);
		int gridY = myPanel.getGridY(x, y);


		switch (e.getButton()) {
		case 1:		//Left mouse button

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing


						} else {
							if(!(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == (Color.RED)) && (myPanel.MinesArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.BLACK )) {
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = MineColor;
								for(int j=0; j<=10;j++){
									for(int i=0; i<=10;i++){
										if(myPanel.MinesArray[j][i]==Color.BLACK){
											myPanel.colorArray[j][i] = Color.BLACK;
										}else{
											myPanel.colorArray[j][i]= Color.LIGHT_GRAY;
										}
									}
								}
								myPanel.repaint();
								
								

							}
							else if(!(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.RED)){
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.LIGHT_GRAY;
								myPanel.repaint();
							}
						}
						if(!(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY]==Color.BLACK)){
							
								if( gridX != 0 || gridY != 0){
									if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] != Color.BLACK){
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY + 1] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX+1][myPanel.mouseDownGridY+1] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY - 1] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX-1][myPanel.mouseDownGridY-1] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY + 1] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY+1] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX+1][myPanel.mouseDownGridY] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY - 1] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY-1] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX-1][myPanel.mouseDownGridY] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY-1] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX+1][myPanel.mouseDownGridY-1] =Color.LIGHT_GRAY;
										}
										if(!(myPanel.MinesArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY + 1] == Color.BLACK )){
											myPanel.colorArray[myPanel.mouseDownGridX-1][myPanel.mouseDownGridY+1] =Color.LIGHT_GRAY;
										}
									}
								}
								
							

						}
					}

				}
			}




		case 3:		
			//Right mouse button flags square grid


			if((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)){
				//Is pressed outside
				//Do nothing
			}
			else 
				if((gridX == -1) || (gridY == -1)){
					//Is released outside
					//Do Nothing
				}
				else
					if((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)){
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					}
					else 
						if((myPanel.mouseDownGridX == 0) || (myPanel.mouseDownGridY  == 0)){
							//Do nothing
						}
						else{
							if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY]==Color.WHITE || 
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY]==Color.RED){
								if(gridX != 0 && gridY != 0 && !(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.RED)){
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = FlagColor;
									myPanel.repaint();
								}
								else if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.RED){
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.WHITE;
									myPanel.repaint();
								}
							}
						}
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}

	}
}
