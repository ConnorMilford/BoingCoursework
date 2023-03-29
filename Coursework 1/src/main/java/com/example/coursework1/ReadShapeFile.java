

/**
 * Creation date: 28/2/23
 * Modification date: 12/03/23
 * Version History: 1.0, implemented file reader.
 * 1.1 implemented updated switch statement to include triangle objects.
 *
 * Program purpose: To read a file and create a queue of shapes from it.
 *
 * @author Connor Milford
 * @version 1.1
 * @file ReadShapeFile
 *
 */



import javafx.scene.paint.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 *
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */

	private static Queue<ClosedShape> readLineByLine(Scanner in) {

		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		// arrayList of strings to store the file data in.
		ArrayList<String> fileData = new ArrayList<>();


		// count represents the index of the array to access
		int count = -1;

		// string variable that is used to store the next line
		String line = null;

		// open and read file into new scanner using filename param

		while (in.hasNextLine()) {
			line = in.nextLine();
			fileData.add(line);
			count++;

			// uses regex to split a line at whitespace.
			String[] shapesData = line.split("[\\s\\xA0]+");


			/* Switch case uses shapedata[0] to tell
			 which shape needs to be made.*/

			switch (shapesData[0]){
				case "triangle":
					shapeQueue.enqueue(constructTriangle(shapesData));
					break;
				case "circle":
					shapeQueue.enqueue(constructCircle(shapesData));
					break;
				case "oval":
					shapeQueue.enqueue(constructOval(shapesData));
					break;
				case "rect":
					shapeQueue.enqueue(constructRectangle(shapesData));
					break;
				case "square":
					shapeQueue.enqueue(constructSquare(shapesData));
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + shapesData[0]);
			}

		}
		//return modified shape queue full of shapes from the file.
		return shapeQueue;
	}

	//method for every shape that can be constructed

	public static Circle constructCircle(String[] shape){

		Circle circle = null;

		try{

			int inserTime = Integer.parseInt(shape[1]);
			int circleX = Integer.parseInt(shape[2]);
			int circleY = Integer.parseInt(shape[3]);
			int vX = Integer.parseInt(shape[4]);
			int vY = Integer.parseInt(shape[5]);
			boolean isFilled = Boolean.parseBoolean(shape[6]);
			int diameter = Integer.parseInt(shape[7]);

			Color colour = Color.rgb(Integer.parseInt(shape[8]),
					Integer.parseInt(shape[9]), Integer.parseInt(shape[10]), 1.0);

			circle = new Circle(inserTime, circleX, circleY, vX,
					vY, diameter, colour, isFilled);

		} catch(NumberFormatException numberFormatException) {
			System.out.println("One or more of the numbers" +
					" were not valid. circle" + shape);
		}

		return circle;
	}

	/**
	 * Method to construct an Oval object based on the array parameter given.
	 *
	 * @param shape, a list of strings of data for given a given shape
	 *
	 * @return An oval object based on the shape parameter given
	 *
	 */

	public static Oval constructOval(String[] shape) {

		Oval oval = null;

		try {

			int inserTime = Integer.parseInt(shape[1]);
			int ovalX = Integer.parseInt(shape[2]);
			int ovalY = Integer.parseInt(shape[3]);
			int vX = Integer.parseInt(shape[4]);
			int vY = Integer.parseInt(shape[5]);
			boolean isFilled = Boolean.parseBoolean(shape[6]);
			int width = Integer.parseInt(shape[7]);
			int height = Integer.parseInt(shape[8]);

			Color colour = Color.rgb(Integer.parseInt(shape[9]),
					Integer.parseInt(shape[10]), Integer.parseInt(shape[11]), 1.0);

			oval = new Oval(inserTime, ovalX, ovalY, vX, vY, width, height,
					colour, isFilled);

		} catch(NumberFormatException numberFormatException){
			System.out.println("One or more of the numbers" +
					" were not valid. oval" + Arrays.toString(shape) +
					numberFormatException.getMessage());
		}

		return oval;

	}


	/**
	 * Method to construct a rect object based on the array parameter given.
	 *
	 * @param shape, a list of strings of data for given a given shape
	 *
	 * @return A rect object based on the shape parameter given
	 *
	 */

	public static Rect constructRectangle(String[] shape){

		Rect rect = null;

		try {

			int inserTime = Integer.parseInt(shape[1]);
			int rectX = Integer.parseInt(shape[2]);
			int rectY = Integer.parseInt(shape[3]);
			int vX = Integer.parseInt(shape[4]);
			int vY = Integer.parseInt(shape[5]);
			boolean isFilled = Boolean.parseBoolean(shape[6]);
			int width = Integer.parseInt(shape[7]);
			int height = Integer.parseInt(shape[8]);

			Color colour = Color.rgb(Integer.parseInt(shape[9]),
					Integer.parseInt(shape[10]), Integer.parseInt(shape[11]), 1.0);

			rect = new Rect(inserTime, rectX, rectY, vX, vY, width,
					height, colour, isFilled);

		} catch(NumberFormatException numberFormatException){
			System.out.println("One or more of the numbers" +
					" were not valid. rect" + Arrays.toString(shape));
		}

		return rect;

	}

	/**
	 * Method to construct a Square object based on the array parameter given.
	 *
	 * @param shape, a list of strings of data for given a given shape
	 *
	 * @return A square object based on the shape parameter given
	 *
	 */

	public static Square constructSquare(String[] shape){

		Square square = null;

		try {

			int inserTime = Integer.parseInt(shape[1]);
			int squareX = Integer.parseInt(shape[2]);
			int squareY = Integer.parseInt(shape[3]);
			int vX = Integer.parseInt(shape[4]);
			int vY = Integer.parseInt(shape[5]);
			boolean isFilled = Boolean.parseBoolean(shape[6]);
			int side = Integer.parseInt(shape[7]);


			Color colour = Color.rgb(Integer.parseInt(shape[8]),
					Integer.parseInt(shape[9]), Integer.parseInt(shape[10]), 1.0);

			square = new Square(inserTime, squareX, squareY, vX, vY,
					side, colour, isFilled);

		} catch(NumberFormatException numberFormatException){
			System.out.println("One or more of the numbers" +
					" were not valid. square" + Arrays.toString(shape));
		}

		return square;

	}

	/**
	 * Method to construct a Triangle object based on the array parameter given.
	 *
	 * @param shape, a list of strings of data for given a given shape
	 *
	 * @return A triangle object based on the shape parameter given
	 *
	 */



	public static Triangle constructTriangle(String[] shape){

		Triangle triangle = null;

		try {

			int inserTime = Integer.parseInt(shape[1]);
			int triX = Integer.parseInt(shape[2]);
			int triY = Integer.parseInt(shape[3]);
			int vX = Integer.parseInt(shape[4]);
			int vY = Integer.parseInt(shape[5]);
			boolean isFilled = Boolean.parseBoolean(shape[6]);
			int width = Integer.parseInt(shape[7]);
			int height = Integer.parseInt(shape[8]);


			Color colour = Color.rgb(Integer.parseInt(shape[9]),
					Integer.parseInt(shape[10]), Integer.parseInt(shape[11]), 1.0);

			triangle = new Triangle(inserTime, triX, triY, vX, vY,  width,
					height, colour, isFilled);



		} catch(NumberFormatException numberFormatException){
			System.out.println("One or more of the numbers" +
					" were not valid. square" + Arrays.toString(shape));
		}

		return triangle;

	}


	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */

	public static Queue<ClosedShape> readDataFile(String filename) {
		Scanner in = null;

		try {
			File file = new File(filename);
			in = new Scanner(file);

		} catch(FileNotFoundException fileNotFoundException){
			System.out.println(fileNotFoundException.getMessage());
			System.exit(0);
		}

		return ReadShapeFile.readLineByLine(in);
	}
}
