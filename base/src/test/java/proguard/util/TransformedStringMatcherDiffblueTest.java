package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TransformedStringMatcherDiffblueTest {
  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String)"})
  public void testMatchesWithString() {
    // Arrange, Act and Assert
    assertFalse(
        (new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new EmptyStringMatcher()))
            .matches("String"));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String)"})
  public void testMatchesWithString2() {
    // Arrange
    AndStringFunction stringFunction =
        new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse(
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String"));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String)"})
  public void testMatchesWithString3() {
    // Arrange
    FilteredStringFunction stringFunction =
        new FilteredStringFunction(
            "Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse(
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String"));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String)"})
  public void testMatchesWithString4() {
    // Arrange
    AndStringFunction stringFunction =
        new AndStringFunction(
            StringFunction.IDENTITY_FUNCTION,
            new FilteredStringFunction(
                "Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION));

    // Act and Assert
    assertFalse(
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher())).matches("String"));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse(
        (new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset2() {
    // Arrange
    AndStringFunction stringFunction =
        new AndStringFunction(StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse(
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset3() {
    // Arrange
    FilteredStringFunction stringFunction =
        new FilteredStringFunction(
            "Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION);

    // Act and Assert
    assertFalse(
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset4() {
    // Arrange
    AndStringFunction stringFunction =
        new AndStringFunction(
            StringFunction.IDENTITY_FUNCTION,
            new FilteredStringFunction(
                "Name Filter", StringFunction.IDENTITY_FUNCTION, StringFunction.IDENTITY_FUNCTION));

    // Act and Assert
    assertFalse(
        (new TransformedStringMatcher(stringFunction, new EmptyStringMatcher()))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_givenCollectionMatcherWithSetIsHashSet() {
    // Arrange, Act and Assert
    assertFalse(
        (new TransformedStringMatcher(
                StringFunction.IDENTITY_FUNCTION, new CollectionMatcher(new HashSet<>())))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String, int, int)} with {@code string}, {@code
   * beginOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String, int, int)"})
  public void testMatchesWithStringBeginOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new ConstantMatcher(true)))
            .matches("String", 1, 3));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String)"})
  public void testMatchesWithString_givenCollectionMatcherWithSetIsHashSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TransformedStringMatcher(
                StringFunction.IDENTITY_FUNCTION, new CollectionMatcher(new HashSet<>())))
            .matches("String"));
  }

  /**
   * Test {@link TransformedStringMatcher#matches(String)} with {@code string}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransformedStringMatcher#matches(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransformedStringMatcher.matches(String)"})
  public void testMatchesWithString_givenConstantMatcherWithMatchesIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TransformedStringMatcher(StringFunction.IDENTITY_FUNCTION, new ConstantMatcher(true)))
            .matches("String"));
  }
}
