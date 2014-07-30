import javax.swing.*;

/**
 * Cell is more of a helper class to keep the contents and locations of each
 * cell straight. It follows better with OO principles.
 *
 * @author chrcoe
 */
@SuppressWarnings("serial")
public class Cell extends JButton {

    ImageIcon _contents; // it needs to hold type ImageIcon
    int _location;

    /**
     * Sets up a cell with the contents of the cell and the location within the
     * grid.
     *
     * @param contents
     *            the contents of this cell
     * @param location
     *            the location in the grid, this should not ever be changed
     */
    public Cell(ImageIcon contents, int location) {
//        _contents = contents;
        setIcon(contents);
//        contents.get
        _location = location;
//        setText(String.format("%d", _contents));
//        setName(String.format("%d", _location));
    }

    /**
     * @return the contents of this cell
     */
    public ImageIcon get_contents() {
        return (ImageIcon) getIcon();
//        return _contents;
    }

    /**
     * Allows setting of the contents in this cell.
     *
     * @param contents
     *            the contents to set
     */
    public void set_contents(ImageIcon contents) {
//        setText(String.format("%d", contents));
//        this._contents = contents;
        setIcon(contents);
    }

    /**
     * @return the location of the cell in the grid
     */
    public int get_location() {
        return _location;
    }

    // public void set_location(int location) {
    // setName(String.format("%d", location));
    // this._location = location;
    // }

    /**
     * Used mainly when stepping through the code with the debugger.
     */
    @Override
    public String toString() {
        return "Cell [_contents=" + _contents + ", _location=" + _location
                + "]";
    }

}
