package proguard.evaluation.value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class RangeValueFactoryDiffblueTest {
  /**
   * Test {@link RangeValueFactory#RangeValueFactory(ValueFactory, ValueFactory)}.
   *
   * <p>Method under test: {@link RangeValueFactory#RangeValueFactory(ValueFactory, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RangeValueFactory.<init>(ValueFactory, ValueFactory)"})
  public void testNewRangeValueFactory() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act and Assert
    assertTrue(
        (new RangeValueFactory(arrayReferenceValueFactory, new ParticularReferenceValueFactory()))
                .referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link RangeValueFactory#RangeValueFactory()}.
   *
   * <p>Method under test: {@link RangeValueFactory#RangeValueFactory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RangeValueFactory.<init>()"})
  public void testNewRangeValueFactory2() {
    // Arrange, Act and Assert
    assertTrue(
        (new RangeValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Test {@link RangeValueFactory#createIntegerValue()}.
   *
   * <p>Method under test: {@link RangeValueFactory#createIntegerValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeValueFactory.createIntegerValue()"})
  public void testCreateIntegerValue() {
    // Arrange
    RangeValueFactory rangeValueFactory = new RangeValueFactory();

    // Act and Assert
    assertSame(rangeValueFactory.INTEGER_VALUE_INT, rangeValueFactory.createIntegerValue());
  }

  /**
   * Test {@link RangeValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <p>Method under test: {@link RangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new RangeValueFactory()).createIntegerValue(1, 3);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeValueFactory.createIntegerValue(int)"})
  public void testCreateIntegerValueWithValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new RangeValueFactory()).createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
    assertTrue(actualCreateIntegerValueResult.isParticular());
  }
}
