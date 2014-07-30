import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

/**
 * The SliderBoard class sets up the board visually as a JPanel with the random
 * values generated at run time being stored as a Cell's contents in the grid.
 *
 * @author chrcoe
 */
@SuppressWarnings("serial")
public class SliderBoard extends JPanel {
    Pattern p = Pattern.compile("(\\d+)"); // find first set of digits

    /**
     * Constructs the board at run time.
     *
     * @param randValues
     *            the matrix of random values generated at run time.
     */
    public SliderBoard(int[][] randValues) {
        ImageIcon img = null;
        int[][] matrix = randValues;

        setLayout(new GridLayout(SliderDriver.ROWS, SliderDriver.COLS));
        int count = 0;
        for (int i = 0; i < SliderDriver.ROWS; i++) {
            for (int j = 0; j < SliderDriver.COLS; j++) {

                try {
                    // pulls images from my personal test server so they are
                    // visible online
                    // I uploaded them to my franklin cs server as well, but
                    // the way I did my REGEX catches the 05 in my login name
                    // and messes everything up, so I stuck to my personal
                    // server
                    URL url = new URL(
                            String.format(
                                    "http://chrcoe.dyndns.org/Test_Site/applets/graphics/%d.jpg",
                                    matrix[i][j]));
                    // URL url = new
                    // URL(String.format("http://cs.franklin.edu/~coe05/images/%d.jpg",
                    // matrix[i][j]));
                    img = new ImageIcon(url);
                }
                catch (MalformedURLException e) {
                    // if this prints, the URL is invalid
                    e.printStackTrace();
                }

                Cell newCell = new Cell(img, count);
                newCell.setName(String.format("%d", matrix[i][j]));
                newCell.addActionListener(new CellClick());
                add(newCell);
                count++;

            }
        }
    }

    /**
     * Inner action listener class for each cell in the grid. This listener will
     * check if the clicked cell is eligible for swapping, if it is, it will
     * then swap the clicked cell with the empty cell. Every button in the grid
     * gets this listener attached to it.
     *
     * @author chrcoe
     */
    class CellClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Cell clickedCell = (Cell) e.getSource();
            Cell emptyCell = (Cell) getComponent(findEmptyCell());

            ArrayList<Integer> pSlots = EligibleSlotComputer
                    .ComputeEligibleSlots(findEmptyCell());

            if (pSlots.contains(clickedCell.get_location())) {
                swapCell(clickedCell, emptyCell);
                pSlots = EligibleSlotComputer
                        .ComputeEligibleSlots(findEmptyCell());
            }

            validate();
            repaint();
        }
    }

    /**
     * This swaps the contents of the two cells passed in as parameters.
     *
     * @param clickedCell
     *            the cell clicked by the user
     * @param emptyCell
     *            the cell that is currently empty
     */
    private void swapCell(Cell clickedCell, Cell emptyCell) {
        ImageIcon tempCont = clickedCell.get_contents();
        clickedCell.set_contents(emptyCell.get_contents());
        emptyCell.set_contents(tempCont);
    }

    /**
     * Finds the index of the empty cell by looking at the image's filename.
     *
     * @return the index of the empty cell
     */
    private int findEmptyCell() {

        int zeroIndex = 0;
        Component[] components = getComponents();

        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Cell) {
                String fileName = ((Cell) components[i]).get_contents()
                        .getDescription();
                Matcher m = p.matcher(fileName);
                m.find();
                if (m.group(1).equals("0")) {
                    zeroIndex = i;
                    break;
                }
            }
        }
        return zeroIndex;
    }
}
