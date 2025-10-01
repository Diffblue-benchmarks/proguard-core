package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

class RangeValueFactoryDiffblueTest {
  /**
   * Test {@link RangeValueFactory#RangeValueFactory(ValueFactory, ValueFactory)}.
   *
   * <p>Method under test: {@link RangeValueFactory#RangeValueFactory(ValueFactory, ValueFactory)}
   */
  @Test
  @DisplayName("Test new RangeValueFactory(ValueFactory, ValueFactory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeValueFactory.<init>(ValueFactory, ValueFactory)"})
  void testNewRangeValueFactory() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    RangeValueFactory actualRangeValueFactory =
        new RangeValueFactory(arrayReferenceValueFactory, new ParticularReferenceValueFactory());

    // Assert
    assertTrue(
        actualRangeValueFactory.referenceValueFactory instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link RangeValueFactory#RangeValueFactory()}.
   *
   * <p>Method under test: {@link RangeValueFactory#RangeValueFactory()}
   */
  @Test
  @DisplayName("Test new RangeValueFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeValueFactory.<init>()"})
  void testNewRangeValueFactory2() {
    // Arrange, Act and Assert
    assertTrue(new RangeValueFactory().referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Test {@link RangeValueFactory#createIntegerValue()}.
   *
   * <p>Method under test: {@link RangeValueFactory#createIntegerValue()}
   */
  @Test
  @DisplayName("Test createIntegerValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeValueFactory.createIntegerValue()"})
  void testCreateIntegerValue() {
    // Arrange, Act and Assert
    assertSame(RangeValueFactory.INTEGER_VALUE_INT, new RangeValueFactory().createIntegerValue());
  }

  /**
   * Test {@link RangeValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <p>Method under test: {@link RangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @DisplayName("Test createIntegerValue(int, int) with 'min', 'max'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeValueFactory.createIntegerValue(int, int)"})
  void testCreateIntegerValueWithMinMax() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = new RangeValueFactory().createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link RangeValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <p>Method under test: {@link RangeValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName("Test createIntegerValue(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeValueFactory.createIntegerValue(int)"})
  void testCreateIntegerValueWithValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = new RangeValueFactory().createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
    assertTrue(actualCreateIntegerValueResult.isParticular());
  }
}
