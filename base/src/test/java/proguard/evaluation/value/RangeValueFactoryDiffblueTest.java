package proguard.evaluation.value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class RangeValueFactoryDiffblueTest {
  /**
   * Method under test: {@link RangeValueFactory#createIntegerValue()}
   */
  @Test
  public void testCreateIntegerValue() {
    // Arrange
    RangeValueFactory rangeValueFactory = new RangeValueFactory();

    // Act and Assert
    assertSame(rangeValueFactory.INTEGER_VALUE_INT, rangeValueFactory.createIntegerValue());
  }

  /**
   * Method under test: {@link RangeValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue2() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new RangeValueFactory()).createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
    assertTrue(actualCreateIntegerValueResult.isParticular());
  }

  /**
   * Method under test: {@link RangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue3() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new RangeValueFactory()).createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeValueFactory#RangeValueFactory(ValueFactory, ValueFactory)}
   */
  @Test
  public void testNewRangeValueFactory() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertTrue((new RangeValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory())).referenceValueFactory instanceof ParticularReferenceValueFactory);
  }

  /**
   * Method under test: {@link RangeValueFactory#RangeValueFactory()}
   */
  @Test
  public void testNewRangeValueFactory2() {
    // Arrange, Act and Assert
    assertTrue((new RangeValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }
}
