package Q2;
/***********************************************************************
this program draws 10 randomized shapes(including their random colors) 
when the user pressed on the button

Name - Liron Cohen
***********************************************************************/


import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class DrawController {

    @FXML
    private Button btn;

    @FXML
    private Canvas canv;
    
    private GraphicsContext gc;
    
    enum Shapes{OVAL, LINE , RECTANGLE}
    
    final int SHAPE_NUMBERS = 10;
    
    double canvHeight , canvWidth , shapeMaxHeight , shapeMaxWidth , rndHeight , rndWidth;
    
    double x,y;
    
    Shapes[] shape = Shapes.values();
    
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    }
    
    @FXML
    void btnPressed(ActionEvent event) {
    	canvHeight = canv.getHeight();//getting the canvas height
    	canvWidth = canv.getWidth();//getting the canvas width
    	gc.clearRect(0, 0,canvWidth , canvHeight);//clear the screen from the earlier shapes
    	
    	for(int i=0 ; i<SHAPE_NUMBERS ; i++) {
    		Random r = new Random();
    		Color color = new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),r.nextDouble());//make random color
    		shapeMaxHeight = canvHeight/4; // maximum shape height
			shapeMaxWidth = canvWidth/4;   // maximum shape width
			rndHeight = shapeMaxHeight * r.nextDouble(); //random number between 0 to maximum shape height
			rndWidth = shapeMaxWidth * r.nextDouble();   //random number between 0 to maximum shape width
			
			/*start point (x,y)*/
			x = r.nextDouble() * canvWidth;  //x coordinate 
			y = r.nextDouble() * canvHeight; //y coordinate
			
	
    		switch (shape[r.nextInt(shape.length)]) {//choosing random shape
    			case RECTANGLE:
    				gc.setFill(color);
    				gc.fillRect(x,y,rndWidth,rndHeight);
    				break;
    			case OVAL:
    				gc.setFill(color);
    				gc.fillOval(x,y,rndWidth,rndHeight);
    				break;
    			case LINE:
    				gc.setStroke(color);
    				gc.strokeLine(x,y,x+rndWidth,y+rndHeight);
    				break;
    		}

    	}

    }
}

