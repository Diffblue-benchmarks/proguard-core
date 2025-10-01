package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

class BasicRangeValueFactoryDiffblueTest {
  /**
   * Test {@link BasicRangeValueFactory#BasicRangeValueFactory(ValueFactory, ValueFactory)}.
   *
   * <p>Method under test: {@link BasicRangeValueFactory#BasicRangeValueFactory(ValueFactory,
   * ValueFactory)}
   */
  @Test
  @DisplayName("Test new BasicRangeValueFactory(ValueFactory, ValueFactory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicRangeValueFactory.<init>(ValueFactory, ValueFactory)"})
  void testNewBasicRangeValueFactory() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    BasicRangeValueFactory actualBasicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());

    // Assert
    assertTrue(
        actualBasicRangeValueFactory.referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link BasicRangeValueFactory#BasicRangeValueFactory()}.
   *
   * <p>Method under test: {@link BasicRangeValueFactory#BasicRangeValueFactory()}
   */
  @Test
  @DisplayName("Test new BasicRangeValueFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicRangeValueFactory.<init>()"})
  void testNewBasicRangeValueFactory2() {
    // Arrange, Act and Assert
    assertTrue(
        new BasicRangeValueFactory().referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Test {@link BasicRangeValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicRangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int, int) with 'min', 'max'; when one; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue BasicRangeValueFactory.createIntegerValue(int, int)"})
  void testCreateIntegerValueWithMinMax_whenOne_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        new BasicRangeValueFactory().createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link BasicRangeValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicRangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int, int) with 'min', 'max'; when three; then return ParticularIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue BasicRangeValueFactory.createIntegerValue(int, int)"})
  void testCreateIntegerValueWithMinMax_whenThree_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        new BasicRangeValueFactory().createIntegerValue(3, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(ParticularValueFactory.INTEGER_VALUE_3, actualCreateIntegerValueResult);
  }
}
