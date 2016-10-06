import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	

	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
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
			break;
		case 3:		
			//Right mouse button
			//Do nothing
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame) c2;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);
			Insets myInsets2 = myFrame2.getInsets();
			int x4 = myInsets2.left;
			int y4 = myInsets2.top;
			e.translatePoint(-x4, -y4);
			int x3 = e.getX();
			int y3 = e.getY();
			myPanel2.x = x3;
			myPanel2.y = y3;
			myPanel2.mouseDownGridX = myPanel2.getGridX(x3, y3);
			myPanel2.mouseDownGridY = myPanel2.getGridY(x3, y3);
			myPanel2.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
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
						if ((gridX == 0) && (gridY == 0)) {
							//Paint diagonal grid cells

						} 
						else if(gridX == 0  ){
							//paint whole columns
							
						}
						else if(gridY == 0  ){
							//paint whole rows
							

						}
						else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
							Color beforeColor = null;
							
							//Same Color will not repeat consecutively
							do{
								beforeColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
								//newColor = colorSwitch();
								switch (generator.nextInt(5)) {
								case 0:
									newColor = Color.YELLOW;
									break;
								case 1:
									newColor = Color.MAGENTA;
									break;
								case 2:
									newColor = Color.BLACK;
									break;
								case 3:
									newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
									break;
								case 4:
									newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
									break;
								}
							}while((newColor.equals(beforeColor)));

							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();



						} if(gridY == 10 && gridX == 0){

						


						}

					}




				}


			}

			myPanel.repaint();
			break;



		case 3:		
			//Right mouse button flags square grid
			
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame)c2;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets2 = myFrame2.getInsets();
			int x3 = myInsets2.left;
			int y3 = myInsets2.top;
			e.translatePoint(-x3, -y3);
			int x4 = e.getX();
			int y4 = e.getY();
			myPanel2.x = x4;
			myPanel2.y = y4;
			int gridX2 = myPanel2.getGridX(x4, y4);
			int gridY2 = myPanel2.getGridY(x4, y4);
			if((myPanel2.mouseDownGridX == -1) || (myPanel2.mouseDownGridY == -1)){
				//Is pressed outside
				//Do nothing
			}
			else 
				if((gridX2 == -1) || (gridY2 == -1)){
					//Is released outside
					//Do Nothing
				}
			else
				if((myPanel2.mouseDownGridX != gridX2) || (myPanel2.mouseDownGridY != gridY2)){
					//Released the mouse button on a different cell where it was pressed
					//Do nothing
				}
				else {
					Color flagColor = null;
					flagColor = Color.RED;
					myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY] = flagColor;
					myPanel2.repaint();
				}

			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}

	}
}
