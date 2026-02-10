import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        // ArrayList with 10 rectangles
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        // various rectangle dimensions
        // small perimeters (< 10)
        rectangles.add(new Rectangle(1, 1, 1, 1));  // perimeter = 4
        rectangles.add(new Rectangle(0, 0, 2, 1));  // perimeter = 6
        rectangles.add(new Rectangle(0, 0, 1, 2));  // perimeter = 6

        // large perimeters (> 10)
        rectangles.add(new Rectangle(0, 0, 5, 5));  // perimeter = 20
        rectangles.add(new Rectangle(0, 0, 10, 2)); // perimeter = 24
        rectangles.add(new Rectangle(0, 0, 8, 3));  // perimeter = 22
        rectangles.add(new Rectangle(0, 0, 6, 4));  // perimeter = 20

        rectangles.add(new Rectangle(0, 0, 2, 2));  // perimeter = 8
        rectangles.add(new Rectangle(0, 0, 1, 3));  // perimeter = 8

        rectangles.add(new Rectangle(0, 0, 7, 7));  // perimeter = 28

        // filter
        Filter filter = new BigRectangleFilter();

        // output all rectangles
        System.out.println("All Rectangles:");
        System.out.println("------------------------------------------");
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle r = rectangles.get(i);
            double perimeter = 2 * (r.width + r.height);
            System.out.printf("Rectangle %d: width=%d, height=%d, perimeter=%.1f%n",
                    i + 1, r.width, r.height, perimeter);
        }

        System.out.println("\nRectangles with BIG perimeters (> 10):");
        System.out.println("------------------------------------------");
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle r = rectangles.get(i);
            if (filter.accept(r)) {
                double perimeter = 2 * (r.width + r.height);
                System.out.printf("Rectangle %d: width=%d, height=%d, perimeter=%.1f%n",
                        i + 1, r.width, r.height, perimeter);
            }
        }
    }
}
