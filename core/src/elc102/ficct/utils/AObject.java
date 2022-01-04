package elc102.ficct.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AObject {

  private Texture texture;
  private int xGridPosition;
  private int yGridPosition;

  public AObject(Texture texture, int xGridPosition, int yGridPosition) {
    this.texture = texture;
    this.xGridPosition = xGridPosition;
    this.yGridPosition = yGridPosition;
  }

  public AObject(Texture texture) {
    this.texture = texture;
    this.xGridPosition = 0;
    this.yGridPosition = 0;
  }

  public Texture getTexture() {
    return texture;
  }

  public void setTexture(Texture texture) {
    this.texture = texture;
  }

  public int getxGridPosition() {
    return xGridPosition;
  }

  public void setxGridPosition(int xGridPosition) {
    this.xGridPosition = xGridPosition;
  }

  public int getyGridPosition() {
    return yGridPosition;
  }

  public void setyGridPosition(int yGridPosition) {
    this.yGridPosition = yGridPosition;
  }

  public void setGridPosition(int x, int y) {
    this.xGridPosition = x;
    this.yGridPosition = y;
  }

  public void draw(SpriteBatch batch, int x, int y){
    batch.draw(texture, x, y);
  }

  public void dispose(){
    texture.dispose();
  }
}
