package io.github.mwttg.jsget.textured;

import io.github.mwttg.jsget.EntityHelper;
import io.github.mwttg.sjge.configuration.Configuration;
import io.github.mwttg.sjge.graphics.draw.single.textured.TexturedRendering;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL40;

public class MainLoop {

  private static final TexturedRendering TEXTURED_RENDERING = new TexturedRendering();

  private final Configuration configuration;

  public MainLoop(final Configuration configuration) {
    this.configuration = configuration;
  }

  public void loop(final long gameWindowId) {
    var entity = EntityHelper.createDefaultPlane(configuration);

    while (!GLFW.glfwWindowShouldClose(gameWindowId)) {
      GL40.glClear(GL40.GL_COLOR_BUFFER_BIT | GL40.GL_DEPTH_BUFFER_BIT);

      TEXTURED_RENDERING.draw(entity);

      GLFW.glfwSwapBuffers(gameWindowId);
      GLFW.glfwPollEvents();
    }
  }
}
