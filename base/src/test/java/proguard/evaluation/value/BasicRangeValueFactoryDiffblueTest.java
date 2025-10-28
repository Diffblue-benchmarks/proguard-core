package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class BasicRangeValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link BasicRangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new BasicRangeValueFactory()).createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertFalse(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link BasicRangeValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue2() {
    // Arrange
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory();

    // Act
    IntegerValue actualCreateIntegerValueResult = basicRangeValueFactory.createIntegerValue(3, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(basicRangeValueFactory.INTEGER_VALUE_3, actualCreateIntegerValueResult);
  }

  /**
   * Method under test:
   * {@link BasicRangeValueFactory#BasicRangeValueFactory(ValueFactory, ValueFactory)}
   */
  @Test
  public void testNewBasicRangeValueFactory() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertTrue((new BasicRangeValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory())).referenceValueFactory instanceof ParticularReferenceValueFactory);
  }

  /**
   * Method under test: {@link BasicRangeValueFactory#BasicRangeValueFactory()}
   */
  @Test
  public void testNewBasicRangeValueFactory2() {
    // Arrange, Act and Assert
    assertTrue((new BasicRangeValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }
}
