
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Triangle extends ClosedShape {

    private final int height;
    private final int width;



    /**
     * Creates a Triangle.
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
    protected Triangle(int insertionTime, int x, int y, int vx, int vy,
                       int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.height = height;
        this.width = width;
    }

    /**
     * Returns the x coordinates of the triangle at the time it is called.
     * xcoords[0] is the rightmost point.
     * @return an array of x coordinates for the triangle.
     */
    public double[] getXCoords(){
        double[] xCoords = new double[3];
        // a = x
        xCoords[0] = x;
        // b = x, same x, diff y
        xCoords[1] = x;
        // c = x + width.
        xCoords[2] = x+width;

        return xCoords;
    }

    /**
     * Returns the y coordinates of the triangle at the time it is called
     * ycoords[0] is the bottom most point.
     * @return an array of y coordinates for the triangle.
     */
    public double[] getYCoords(){
        double[] yCoords = new double[3];
        yCoords[0] = y;
        yCoords[1] = y + height;
        yCoords[2] = y + (height / 2);

        return yCoords;
    }

    /**
     * Draw the triangle on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon(getXCoords(), getYCoords(), 3);
        }
        else {
            g.strokePolygon(getXCoords(), getYCoords(), 3);
        }
    }

    /**
     * @return the width of the triangle
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return the height of the triangle
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Method to convert a Triangle to a string
     * @return a string representing the triangle
     */

    @Override
    public String toString () {
        String result = "This is a triangle\n";
        result += super.toString ();
        result += "Its width is " + this.width +
                " and its height is " + this.height + "\n";
        return result;
    }


}
