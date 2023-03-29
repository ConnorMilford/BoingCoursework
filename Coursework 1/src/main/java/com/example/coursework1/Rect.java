
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends ClosedShape {

    private final int width;
    private final int height;

    /**
     * Creates a circle.
     * @param insertionTime time in milliseconds for the shape to be inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param height the height of the rect
     * @param width of the rect
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     */
    public Rect (int insertionTime, int x, int y, int vx, int vy,
            int width, int height, Color colour, boolean isFilled){

        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert a Rect to a string
     * @return a string representing the rect
     */

    @Override
    public String toString(){
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its width is " + this.width +
                "and its height is " + this.height;

        return result;

    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);

        if(isFilled){
            g.fillRect(x, y, width, height);
        } else {
            g.strokeRect(x, y, width, height);
        }
    }

    /**
     * @return The width of the circle
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the circle
     */
    @Override
    public int getHeight() {
        return height;
    }


}

