package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;

public class InitializationFinderDiffblueTest {
  /**
   * Method under test: {@link InitializationFinder#isInitializer()}
   */
  @Test
  public void testIsInitializer() {
    // Arrange, Act and Assert
    assertTrue((new InitializationFinder()).isInitializer());
    assertFalse((new InitializationFinder()).isInitializer(2));
  }

  /**
   * Method under test:
   * {@link InitializationFinder#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute() {
    // Arrange
    InitializationFinder initializationFinder = new InitializationFinder(new PartialEvaluator(), false);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    initializationFinder.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}));

    // Assert
    assertFalse(initializationFinder.isInitializer());
    assertEquals(InitializationFinder.NONE, initializationFinder.superInitializationOffset());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InitializationFinder#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link InitializationFinder#superInitializationOffset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    InitializationFinder initializationFinder = new InitializationFinder();
    LibraryClass clazz = new LibraryClass();

    // Act
    initializationFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert that nothing has changed
    assertEquals(0, initializationFinder.superInitializationOffset());
  }

  /**
   * Method under test: {@link InitializationFinder#InitializationFinder()}
   */
  @Test
  public void testNewInitializationFinder() {
    // Arrange and Act
    InitializationFinder actualInitializationFinder = new InitializationFinder();

    // Assert
    assertEquals(0, actualInitializationFinder.superInitializationOffset());
    assertTrue(actualInitializationFinder.isInitializer());
  }

  /**
   * Method under test:
   * {@link InitializationFinder#InitializationFinder(PartialEvaluator, boolean)}
   */
  @Test
  public void testNewInitializationFinder2() {
    // Arrange and Act
    InitializationFinder actualInitializationFinder = new InitializationFinder(new PartialEvaluator(), true);

    // Assert
    assertEquals(0, actualInitializationFinder.superInitializationOffset());
    assertTrue(actualInitializationFinder.isInitializer());
  }
}
