package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.BasicRangeValueFactory.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.value.ValueFactory)"
  })
  void testNewBasicRangeValueFactory() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act and Assert
    assertTrue(
        (new BasicRangeValueFactory(
                    arrayReferenceValueFactory, new ParticularReferenceValueFactory()))
                .referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link BasicRangeValueFactory#BasicRangeValueFactory()}.
   *
   * <p>Method under test: {@link BasicRangeValueFactory#BasicRangeValueFactory()}
   */
  @Test
  @DisplayName("Test new BasicRangeValueFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.value.BasicRangeValueFactory.<init>()"})
  void testNewBasicRangeValueFactory2() {
    // Arrange, Act and Assert
    assertTrue(
        (new BasicRangeValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.BasicRangeValueFactory.createIntegerValue(int, int)"
  })
  void testCreateIntegerValueWithMinMax_whenOne_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new BasicRangeValueFactory()).createIntegerValue(1, 3);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.BasicRangeValueFactory.createIntegerValue(int, int)"
  })
  void testCreateIntegerValueWithMinMax_whenThree_thenReturnParticularIntegerValue() {
    // Arrange
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory();

    // Act
    IntegerValue actualCreateIntegerValueResult = basicRangeValueFactory.createIntegerValue(3, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(basicRangeValueFactory.INTEGER_VALUE_3, actualCreateIntegerValueResult);
  }
}
