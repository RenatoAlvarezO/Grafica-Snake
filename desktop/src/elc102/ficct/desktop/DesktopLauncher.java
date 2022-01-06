package elc102.ficct.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

import elc102.ficct.Game;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

    config.title = "Snake";
    config.initialBackgroundColor = Color.TEAL;
    // config.width = 160;
    // config.height = 90;
    config.width = 1280;
    config.height = 720;
    // System.out.println("Width => " + config.width);
    // System.out.println("Height => " + config.height);
    new LwjglApplication(new Game(), config);
  }
}
