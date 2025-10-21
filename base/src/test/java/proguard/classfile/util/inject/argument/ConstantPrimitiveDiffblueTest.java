package proguard.classfile.util.inject.argument;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantPrimitiveDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantPrimitive#ConstantPrimitive(Number)}
   *   <li>{@link ConstantPrimitive#toString()}
   *   <li>{@link ConstantPrimitive#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantPrimitive.<init>(Number)",
    "java.lang.Object ConstantPrimitive.getValue()",
    "String ConstantPrimitive.toString()"
  })
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

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenBigDecimalWith23_thenThrowRuntimeException() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is {@code A}.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenConstantPrimitiveWithConstantIsA_thenReturnB() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>((byte) 'A');

    // Act and Assert
    assertEquals("B", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is minus one.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenConstantPrimitiveWithConstantIsMinusOne_thenReturnJ() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(-1L);

    // Act and Assert
    assertEquals("J", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is minus one.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenConstantPrimitiveWithConstantIsMinusOne_thenReturnS() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>((short) -1);

    // Act and Assert
    assertEquals("S", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is ten.
   *   <li>Then return {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenConstantPrimitiveWithConstantIsTen_thenReturnD() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(10.0d);

    // Act and Assert
    assertEquals("D", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is ten.
   *   <li>Then return {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenConstantPrimitiveWithConstantIsTen_thenReturnF() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(10.0f);

    // Act and Assert
    assertEquals("F", constantPrimitive.getInternalType());
  }

  /**
   * Test {@link ConstantPrimitive#getInternalType()}.
   *
   * <ul>
   *   <li>Given {@link ConstantPrimitive#ConstantPrimitive(Number)} with constant is valueOf one.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPrimitive#getInternalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstantPrimitive.getInternalType()"})
  public void testGetInternalType_givenConstantPrimitiveWithConstantIsValueOfOne_thenReturnI() {
    // Arrange
    ConstantPrimitive<Number> constantPrimitive = new ConstantPrimitive<>(Integer.valueOf(1));

    // Act and Assert
    assertEquals("I", constantPrimitive.getInternalType());
  }
}
