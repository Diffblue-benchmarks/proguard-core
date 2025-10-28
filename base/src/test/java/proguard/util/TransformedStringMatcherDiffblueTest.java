package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import org.junit.Test;

public class TransformedStringMatcherDiffblueTest {
  /**
   * Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse(
        (new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new EmptyStringMatcher())).matches("String"));
    assertFalse((new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new CollectionMatcher(new HashSet<>())))
        .matches("String"));
    assertTrue(
        (new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new ConstantMatcher(true))).matches("String"));
    assertFalse((new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new EmptyStringMatcher()))
        .matches("String", 1, 3));
    assertFalse((new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new CollectionMatcher(new HashSet<>())))
        .matches("String", 1, 3));
    assertTrue((new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new ConstantMatcher(true)))
        .matches("String", 1, 3));
  }

  /**
   * Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  public void testMatches2() {
    // Arrange
    AndStringFunction stringFunction = new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
        StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse((new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String"));
  }

  /**
   * Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  public void testMatches3() {
    // Arrange
    FilteredStringFunction stringFunction = new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
        StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse((new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String"));
  }

  /**
   * Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  public void testMatches4() {
    // Arrange
    AndStringFunction stringFunction = new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
        new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION));

    // Act and Assert
    assertFalse((new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String"));
  }

  /**
   * Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches5() {
    // Arrange
    AndStringFunction stringFunction = new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
        StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse((new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches6() {
    // Arrange
    FilteredStringFunction stringFunction = new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION,
        StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse((new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String", 1, 3));
  }

  /**
   * Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches7() {
    // Arrange
    AndStringFunction stringFunction = new AndStringFunction(StringFunction.IDENTITY_FUNCTION,
        new FilteredStringFunction("Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION));

    // Act and Assert
    assertFalse((new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String", 1, 3));
  }
}
