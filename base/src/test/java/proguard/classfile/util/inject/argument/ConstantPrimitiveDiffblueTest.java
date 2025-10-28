package proguard.classfile.util.inject.argument;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.math.BigDecimal;
import org.junit.Test;

public class ConstantPrimitiveDiffblueTest {
  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(Integer.valueOf(1));

    // Act and Assert
    assertEquals("I", constantPrimitive.getInternalType());
  }

  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType2() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>((byte) 'A');

    // Act and Assert
    assertEquals("B", constantPrimitive.getInternalType());
  }

  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType3() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(-1L);

    // Act and Assert
    assertEquals("J", constantPrimitive.getInternalType());
  }

  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType4() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>((short) -1);

    // Act and Assert
    assertEquals("S", constantPrimitive.getInternalType());
  }

  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType5() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(10.0d);

    // Act and Assert
    assertEquals("D", constantPrimitive.getInternalType());
  }

  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType6() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(10.0f);

    // Act and Assert
    assertEquals("F", constantPrimitive.getInternalType());
  }

  /**
   * Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  public void testGetInternalType7() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> constantPrimitive.getInternalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantPrimitive#ConstantPrimitive(Number)}
   *   <li>{@link ConstantPrimitive#toString()}
   *   <li>{@link ConstantPrimitive#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    ConstantPrimitive<Number> actualConstantPrimitive = new ConstantPrimitive<>(valueOfResult);
    String actualToStringResult = actualConstantPrimitive.toString();

    // Assert
    assertEquals("1:int", actualToStringResult);
    assertSame(valueOfResult, actualConstantPrimitive.getValue());
  }
}
