package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;

class InitializationFinderDiffblueTest {
  /**
   * Test {@link InitializationFinder#InitializationFinder()}.
   *
   * <p>Method under test: {@link InitializationFinder#InitializationFinder()}
   */
  @Test
  @DisplayName("Test new InitializationFinder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InitializationFinder.<init>()"})
  void testNewInitializationFinder() {
    // Arrange and Act
    InitializationFinder actualInitializationFinder = new InitializationFinder();

    // Assert
    assertEquals(0, actualInitializationFinder.superInitializationOffset());
    assertTrue(actualInitializationFinder.isInitializer());
  }

  /**
   * Test {@link InitializationFinder#InitializationFinder(PartialEvaluator, boolean)}.
   *
   * <p>Method under test: {@link InitializationFinder#InitializationFinder(PartialEvaluator,
   * boolean)}
   */
  @Test
  @DisplayName("Test new InitializationFinder(PartialEvaluator, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InitializationFinder.<init>(PartialEvaluator, boolean)"})
  void testNewInitializationFinder2() {
    // Arrange and Act
    InitializationFinder actualInitializationFinder =
        new InitializationFinder(new PartialEvaluator(), true);

    // Assert
    assertEquals(0, actualInitializationFinder.superInitializationOffset());
    assertTrue(actualInitializationFinder.isInitializer());
  }

  /**
   * Test {@link InitializationFinder#isInitializer()}.
   *
   * <p>Method under test: {@link InitializationFinder#isInitializer()}
   */
  @Test
  @DisplayName("Test isInitializer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InitializationFinder.isInitializer()"})
  void testIsInitializer() {
    // Arrange, Act and Assert
    assertTrue(new InitializationFinder().isInitializer());
  }

  /**
   * Test {@link InitializationFinder#isInitializer(int)} with {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InitializationFinder#isInitializer(int)}
   */
  @Test
  @DisplayName("Test isInitializer(int) with 'int'; when two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InitializationFinder.isInitializer(int)"})
  void testIsInitializerWithInt_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new InitializationFinder().isInitializer(2));
  }

  /**
   * Test {@link InitializationFinder#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link InitializationFinder#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute); given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InitializationFinder.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute_givenOne() {
    // Arrange
    InitializationFinder initializationFinder =
        new InitializationFinder(new PartialEvaluator(), false);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    codeAttribute.u4codeLength = 1;

    // Act
    initializationFinder.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertFalse(initializationFinder.isInitializer());
    assertEquals(InitializationFinder.NONE, initializationFinder.superInitializationOffset());
  }

  /**
   * Test {@link InitializationFinder#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link InitializationFinder#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute); given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InitializationFinder.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute_givenZero() {
    // Arrange
    InitializationFinder initializationFinder =
        new InitializationFinder(new PartialEvaluator(), false);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    codeAttribute.u4codeLength = 0;

    // Act
    initializationFinder.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertFalse(initializationFinder.isInitializer());
    assertEquals(InitializationFinder.NONE, initializationFinder.superInitializationOffset());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InitializationFinder#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link InitializationFinder#superInitializationOffset()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int InitializationFinder.superInitializationOffset()",
    "void InitializationFinder.visitAnyAttribute(Clazz, Attribute)"
  })
  void testGettersAndSetters() {
    // Arrange
    InitializationFinder initializationFinder = new InitializationFinder();
    LibraryClass clazz = new LibraryClass();

    // Act
    initializationFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(0, initializationFinder.superInitializationOffset());
  }
}
