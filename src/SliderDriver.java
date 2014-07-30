import java.util.*;
import javax.swing.*;

/**
 * This driver class is in charge of generating random values at run time and
 * sending these to the SliderBoard constructor and then displaying the Board on
 * this internal frame.
 *
 * @author chrcoe
 */
@SuppressWarnings("serial")
public class SliderDriver extends JInternalFrame {
    public static int ROWS = 4;
    public static int COLS = 4;

    /**
     * Sets up the driver by adding a new SliderBoard with the generated random
     * values matrix as its only parameter.
     */
    public SliderDriver() {
        // add the entire display JPanel to this JPanel object
        add(new SliderBoard(generateRandomValues()));
        pack();
        setVisible(true);
    }

    /**
     * Generates random values and fills in a matrix to pass to the SliderBoard
     * class.
     *
     * @return a matrix containing the generated values
     */
    private int[][] generateRandomValues() {
        int[] values = new int[16];
        ArrayList<Integer> usedVals = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < (ROWS * COLS); i++) {
            int nextValue = r.nextInt((ROWS * COLS));
            while (usedVals.contains(nextValue) || nextValue == (ROWS * COLS)) {
                nextValue = r.nextInt((ROWS * COLS));
            }
            usedVals.add(nextValue);
            values[i] = nextValue;
        }

        int[][] matrix = new int[ROWS][COLS];
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < ROWS; j++) {
                matrix[i][j] = values[count];
                count++;
            }
        }
        return matrix;
    }
}
