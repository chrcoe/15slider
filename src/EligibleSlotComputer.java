import java.util.*;

/**
 * This class calculates the currently eligible slots based on the index of an
 * empty cell.
 *
 * @author chrcoe
 */
public class EligibleSlotComputer {
    /**
     * This only computes for a 4x4 matrix, if the grid will be a different
     * size, this will need to be looked at.
     *
     * @param zeroIndex
     *            the cell location to check
     * @return the location of eligible slots in an ArrayList<Integer>
     */
    public static ArrayList<Integer> ComputeEligibleSlots(int zeroIndex) {
        ArrayList<Integer> ess = new ArrayList<Integer>();

        switch (zeroIndex) {
            case 0:
                ess.add(1);
                ess.add(4);
                break;
            case 1:
                ess.add(2);
                ess.add(0);
                ess.add(5);
                break;
            case 2:
                ess.add(3);
                ess.add(1);
                ess.add(6);
                break;
            case 3:
                ess.add(2);
                ess.add(7);
                break;
            case 4:
                ess.add(0);
                ess.add(5);
                ess.add(8);
                break;
            case 5:
                ess.add(1);
                ess.add(4);
                ess.add(6);
                ess.add(9);
                break;
            case 6:
                ess.add(2);
                ess.add(5);
                ess.add(7);
                ess.add(10);
                break;
            case 7:
                ess.add(3);
                ess.add(6);
                ess.add(11);
                break;
            case 8:
                ess.add(4);
                ess.add(9);
                ess.add(12);
                break;
            case 9:
                ess.add(5);
                ess.add(8);
                ess.add(10);
                ess.add(13);
                break;
            case 10:
                ess.add(6);
                ess.add(9);
                ess.add(11);
                ess.add(14);
                break;
            case 11:
                ess.add(7);
                ess.add(10);
                ess.add(15);
                break;
            case 12:
                ess.add(8);
                ess.add(13);
                break;
            case 13:
                ess.add(9);
                ess.add(12);
                ess.add(14);
                break;
            case 14:
                ess.add(10);
                ess.add(13);
                ess.add(15);
                break;
            case 15:
                ess.add(11);
                ess.add(14);
                break;
            default:
                break;
        }

        return ess;
    }
}
