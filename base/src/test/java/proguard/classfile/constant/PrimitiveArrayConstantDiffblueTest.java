package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PrimitiveArrayConstantDiffblueTest {
  /**
   * Method under test: {@link PrimitiveArrayConstant#getPrimitiveType()}
   */
  @Test
  public void testGetPrimitiveType() {
    // Arrange, Act and Assert
    assertEquals('\u0000', (new PrimitiveArrayConstant()).getPrimitiveType());
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#getLength()}
   */
  @Test
  public void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new PrimitiveArrayConstant()).getLength());
  }

  /**
   * Method under test:
   * {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}
   */
  @Test
  public void testContentEquals() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant();

    // Act and Assert
    assertTrue(primitiveArrayConstant.contentEquals(new PrimitiveArrayConstant()));
  }

  /**
   * Method under test:
   * {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}
   */
  @Test
  public void testContentEquals2() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant("Values");

    // Act and Assert
    assertFalse(primitiveArrayConstant.contentEquals(new PrimitiveArrayConstant()));
  }

  /**
   * Method under test:
   * {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}
   */
  @Test
  public void testContentEquals3() {
    // Arrange, Act and Assert
    assertFalse((new PrimitiveArrayConstant()).contentEquals(null));
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.PRIMITIVE_ARRAY, (new PrimitiveArrayConstant()).getTag());
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant("Values");

    // Act and Assert
    assertNotEquals(primitiveArrayConstant, new PrimitiveArrayConstant());
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant();

    // Act and Assert
    assertEquals(primitiveArrayConstant, new PrimitiveArrayConstant());
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PrimitiveArrayConstant(), null);
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange, Act and Assert
    assertEquals(new PrimitiveArrayConstant(), new PrimitiveArrayConstant());
  }

  /**
   * Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PrimitiveArrayConstant(), "Different type to PrimitiveArrayConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PrimitiveArrayConstant#PrimitiveArrayConstant()}
   *   <li>{@link PrimitiveArrayConstant#toString()}
   *   <li>{@link PrimitiveArrayConstant#getValues()}
   *   <li>{@link PrimitiveArrayConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PrimitiveArrayConstant actualPrimitiveArrayConstant = new PrimitiveArrayConstant();
    String actualToStringResult = actualPrimitiveArrayConstant.toString();
    Object actualValues = actualPrimitiveArrayConstant.getValues();
    boolean actualIsCategory2Result = actualPrimitiveArrayConstant.isCategory2();

    // Assert
    assertEquals("PrimitiveArray(\u0000[0])", actualToStringResult);
    assertNull(actualValues);
    assertNull(actualPrimitiveArrayConstant.getProcessingInfo());
    assertEquals(0, actualPrimitiveArrayConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PrimitiveArrayConstant#PrimitiveArrayConstant(Object)}
   *   <li>{@link PrimitiveArrayConstant#toString()}
   *   <li>{@link PrimitiveArrayConstant#getValues()}
   *   <li>{@link PrimitiveArrayConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    PrimitiveArrayConstant actualPrimitiveArrayConstant = new PrimitiveArrayConstant("Values");
    String actualToStringResult = actualPrimitiveArrayConstant.toString();
    Object actualValues = actualPrimitiveArrayConstant.getValues();
    boolean actualIsCategory2Result = actualPrimitiveArrayConstant.isCategory2();

    // Assert
    assertEquals("PrimitiveArray(\u0000[0])", actualToStringResult);
    assertEquals("Values", actualValues);
    assertNull(actualPrimitiveArrayConstant.getProcessingInfo());
    assertEquals(0, actualPrimitiveArrayConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }
}
