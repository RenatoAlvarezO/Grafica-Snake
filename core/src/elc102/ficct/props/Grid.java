package elc102.ficct.props;

import com.badlogic.gdx.Gdx;

public class Grid {
  private int cellWidth;
  private int cellHeight;
  private int rowCount;
  private int columnCount;

  public Grid(int rowCount, int columnCount) {
    this.rowCount = rowCount;
    this.columnCount = columnCount;
    recalculateCellDimentions();
  }

  public int getCellWidth() {
    return cellWidth;
  }

  public int getCellHeight() {
    return cellHeight;
  }

  public int getRowCount() {
    return rowCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  public int getColumnCount() {
    return columnCount;
  }

  public void setColumnCount(int columnCount) {
    this.columnCount = columnCount;
  }

  public void recalculateCellDimentions() {
    this.cellWidth = Gdx.graphics.getWidth() / rowCount;
    this.cellHeight = Gdx.graphics.getHeight() / columnCount;
  }
// Hay algo raro con esta logica
   public int getXPosition(int x) {
    return cellWidth * x; 
  }

  public int getYPosition(int y) {
    return cellHeight * y;
  }
}
