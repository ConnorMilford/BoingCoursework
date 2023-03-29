
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape {

    private final int side;

    /**
     * Creates a circle.
     * @param insertionTime time in milliseconds for the shape to be inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side length of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy,
                   int side, Color colour, boolean isFilled){

        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Method to convert a Square to a string
     * @return a string representing the square
     */

    @Override
    public String toString(){
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {

        g.setFill(colour);
        g.setStroke(colour);

        if(isFilled){
            g.fillRect(x, y, side, side);
        } else {
            g.strokeRect(x, y, side, side);
        }

    }

    /**
     * @return the side length
     */
    @Override
    public int getWidth() {
        return side;
    }

    /**
     * @return the side length
     */
    @Override
    public int getHeight() {
        return side;
    }


    /**
     * @return the side length
     */
    public int getSide() {
        return side;
    }


}
