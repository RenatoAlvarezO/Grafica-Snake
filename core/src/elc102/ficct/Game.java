package elc102.ficct;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import elc102.ficct.props.Grid;
import elc102.ficct.utils.Food;

public class Game extends ApplicationAdapter {
  SpriteBatch batch;
  Texture img;
  Grid grid;
  private float yPosition;
  private float xPosition;

  Food food;

  @Override
  public void create() {
    batch = new SpriteBatch();
    img = new Texture("Test-Prop.png");

    grid = new Grid(16, 9);
    food = new Food(new Texture("Test-Prop.png"),11,3);
   xPosition = 0f;
    yPosition = 0f;

    System.out.println(grid.getXPosition(food.getxGridPosition()));
    System.out.println(grid.getYPosition(food.getyGridPosition()));
  }

  @Override
  public void render() {

    if (Gdx.input.isKeyPressed(Input.Keys.W))
      // yPosition += grid.getCellWidth();
      food.setyGridPosition(food.getyGridPosition() + 1);
    if (Gdx.input.isKeyPressed(Input.Keys.S))
      food.setyGridPosition(food.getyGridPosition() - 1);
    if (Gdx.input.isKeyPressed(Input.Keys.D))
      food.setxGridPosition(food.getxGridPosition() + 1);
    if (Gdx.input.isKeyPressed(Input.Keys.A))
      food.setxGridPosition(food.getxGridPosition() - 1);
    ScreenUtils.clear(1, 0, 0, 1);
    batch.begin();
    food.draw(batch, grid.getXPosition(food.getxGridPosition()), grid.getYPosition(food.getyGridPosition()));
    // batch.draw(img, xPosition, yPosition);
    batch.end();

  }

  @Override
  public void dispose() {
    batch.dispose();
    img.dispose();
  }
}
