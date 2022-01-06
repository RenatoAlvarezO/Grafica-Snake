package elc102.ficct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import elc102.ficct.controllers.CollitionController;
import elc102.ficct.controllers.InputController;
import elc102.ficct.props.Grid;
import elc102.ficct.utils.Food;
import elc102.ficct.utils.Obstacle;
import elc102.ficct.utils.Snake;
import elc102.ficct.utils.TimeCounter;

public class Game extends ApplicationAdapter {
  SpriteBatch batch;
  Texture img;
  Grid grid;
  private float yPosition;
  private float xPosition;

  List<Food> foodList;
  List<Obstacle> obstacleList;

  Snake snake;
  int counter = 0;

  InputController inputController;
  CollitionController collitionController;
  TimeCounter gameSpeed;

  @Override
  public void create() {
    batch = new SpriteBatch();
    img = new Texture("Test-Prop.png");

    grid = new Grid(16 * 3, 9 * 3);

    foodList = new LinkedList<>();
    obstacleList = new LinkedList<>();

    foodList.add(new Food(0, 0));
    foodList.add(new Food(1, 1));
    foodList.add(new Food(4, 7));
    foodList.add(new Food(8, 3));
    foodList.add(new Food(11, 7));
    foodList.add(new Food(14, 4));

    obstacleList.add(new Obstacle(17, 17));

    xPosition = 0f;
    yPosition = 0f;
    snake = new Snake(grid.getRowCount() / 2, grid.getColumnCount() / 2);

    inputController = new InputController(snake);
    inputController.start();
    gameSpeed = new TimeCounter(50);

    collitionController = new CollitionController(snake, foodList, obstacleList);
  }

  @Override
  public void render() {

    ScreenUtils.clear(Color.TEAL);

    if (gameSpeed.hasPassed()) {
      snake.updatePosition();
      gameSpeed.reset();
    }

    collitionController.foodCollitions();
    if (collitionController.obstacleCollition()) {
      inputController.stop(); 
      gameSpeed.stop();
    }
    batch.begin();

    snake.draw(batch, grid);
    for (Food food : foodList)
      food.draw(batch, grid);

    for (Obstacle obstacle : obstacleList)
      obstacle.draw(batch, grid);

    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    img.dispose();
  }

  @Override
  public void resize(int x, int y) {
    // grid.recalculateCellDimentions();
  }

}
