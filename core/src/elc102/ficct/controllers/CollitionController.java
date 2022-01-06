package elc102.ficct.controllers;

import java.util.List;

import elc102.ficct.utils.AObject;
import elc102.ficct.utils.Food;
import elc102.ficct.utils.Obstacle;
import elc102.ficct.utils.Snake;
import elc102.ficct.utils.SnakePart;

public class CollitionController {

  List<Obstacle> obstacleList;
  List<Food> foodList;
  Snake snake;

  public CollitionController(Snake snake, List<Food> foodList, List<Obstacle> obstacleList) {
    this.snake = snake;
    this.foodList = foodList;
    this.obstacleList = obstacleList;
  }

  public void foodCollitions() {
    SnakePart snakeHead = snake.getSnakeHead();

    for (int index = 0; index < foodList.size(); index++) {
      if (AObject.areColliding(snakeHead, foodList.get(index))) {
        foodList.remove(index);
        snake.addToTail();
        return;
      }
    }
  }

  public boolean obstacleCollition() {

    SnakePart snakeHead = snake.getSnakeHead();

    for (int index = 0; index < obstacleList.size(); index++)
      if (AObject.areColliding(snakeHead, obstacleList.get(index)))
        return true;
    return false;
  }
}