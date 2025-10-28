package proguard.examples.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.ClassPool;

public class ExampleUtilDiffblueTest {
  /**
   * Method under test: {@link ExampleUtil#createClassPool(Class[])}
   */
  @Test
  public void testCreateClassPool() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertEquals(1, ExampleUtil.createClassPool(forNameResult).size());
  }

  /**
   * Method under test: {@link ExampleUtil#addClass(ClassPool, Class[])}
   */
  @Test
  public void testAddClass() {
    // Arrange
    ClassPool classPool = new ClassPool();
    Class<Object> forNameResult = Object.class;

    // Act
    ExampleUtil.addClass(classPool, forNameResult);

    // Assert
    assertEquals(1, classPool.size());
  }

  /**
   * Method under test: {@link ExampleUtil#executeMainMethod(ClassPool, String)}
   */
  @Test
  public void testExecuteMainMethod() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ExampleUtil.executeMainMethod(new ClassPool(), "Internal Class Name"));
    assertThrows(RuntimeException.class,
        () -> ExampleUtil.executeMainMethod(new ClassPool(), "Internal Class Name", "Arguments"));
  }
}
