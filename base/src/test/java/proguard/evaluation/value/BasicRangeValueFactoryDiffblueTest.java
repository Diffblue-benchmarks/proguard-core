package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class BasicRangeValueFactoryDiffblueTest {
  /**
   * Test {@link BasicRangeValueFactory#BasicRangeValueFactory(ValueFactory, ValueFactory)}.
   *
   * <p>Method under test: {@link BasicRangeValueFactory#BasicRangeValueFactory(ValueFactory,
   * ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicRangeValueFactory.<init>(ValueFactory, ValueFactory)"})
  public void testNewBasicRangeValueFactory() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicRangeValueFactory.<init>()"})
  public void testNewBasicRangeValueFactory2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue BasicRangeValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax_whenOne_thenReturnRangeIntegerValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue BasicRangeValueFactory.createIntegerValue(int, int)"})
  public void testCreateIntegerValueWithMinMax_whenThree_thenReturnParticularIntegerValue() {
    // Arrange
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory();

    // Act
    IntegerValue actualCreateIntegerValueResult = basicRangeValueFactory.createIntegerValue(3, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(basicRangeValueFactory.INTEGER_VALUE_3, actualCreateIntegerValueResult);
  }
}
