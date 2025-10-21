package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PrimitiveArrayConstantDiffblueTest {
  /**
   * Test {@link PrimitiveArrayConstant#getPrimitiveType()}.
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#getPrimitiveType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char PrimitiveArrayConstant.getPrimitiveType()"})
  public void testGetPrimitiveType() {
    // Arrange, Act and Assert
    assertEquals('\u0000', (new PrimitiveArrayConstant()).getPrimitiveType());
  }

  /**
   * Test {@link PrimitiveArrayConstant#getLength()}.
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#getLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PrimitiveArrayConstant.getLength()"})
  public void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new PrimitiveArrayConstant()).getLength());
  }

  /**
   * Test {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}.
   *
   * <ul>
   *   <li>Given {@link PrimitiveArrayConstant#PrimitiveArrayConstant(Object)} with {@code Values}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrimitiveArrayConstant.contentEquals(PrimitiveArrayConstant)"})
  public void testContentEquals_givenPrimitiveArrayConstantWithValues_thenReturnFalse() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant("Values");

    // Act and Assert
    assertFalse(primitiveArrayConstant.contentEquals(new PrimitiveArrayConstant()));
  }

  /**
   * Test {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}.
   *
   * <ul>
   *   <li>Given {@link PrimitiveArrayConstant#PrimitiveArrayConstant()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrimitiveArrayConstant.contentEquals(PrimitiveArrayConstant)"})
  public void testContentEquals_givenPrimitiveArrayConstant_thenReturnTrue() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant();

    // Act and Assert
    assertTrue(primitiveArrayConstant.contentEquals(new PrimitiveArrayConstant()));
  }

  /**
   * Test {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}.
   *
   * <ul>
   *   <li>Given {@link PrimitiveArrayConstant#PrimitiveArrayConstant()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#contentEquals(PrimitiveArrayConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrimitiveArrayConstant.contentEquals(PrimitiveArrayConstant)"})
  public void testContentEquals_givenPrimitiveArrayConstant_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PrimitiveArrayConstant()).contentEquals(null));
  }

  /**
   * Test {@link PrimitiveArrayConstant#getTag()}.
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PrimitiveArrayConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.PRIMITIVE_ARRAY, (new PrimitiveArrayConstant()).getTag());
  }

  /**
   * Test {@link PrimitiveArrayConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean PrimitiveArrayConstant.equals(Object)",
    "int PrimitiveArrayConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant("Values");

    // Act and Assert
    assertNotEquals(primitiveArrayConstant, new PrimitiveArrayConstant());
  }

  /**
   * Test {@link PrimitiveArrayConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean PrimitiveArrayConstant.equals(Object)",
    "int PrimitiveArrayConstant.hashCode()"
  })
  public void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PrimitiveArrayConstant primitiveArrayConstant = new PrimitiveArrayConstant();

    // Act and Assert
    assertEquals(primitiveArrayConstant, new PrimitiveArrayConstant());
  }

  /**
   * Test {@link PrimitiveArrayConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean PrimitiveArrayConstant.equals(Object)",
    "int PrimitiveArrayConstant.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PrimitiveArrayConstant(), null);
  }

  /**
   * Test {@link PrimitiveArrayConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean PrimitiveArrayConstant.equals(Object)",
    "int PrimitiveArrayConstant.hashCode()"
  })
  public void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange, Act and Assert
    assertEquals(new PrimitiveArrayConstant(), new PrimitiveArrayConstant());
  }

  /**
   * Test {@link PrimitiveArrayConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean PrimitiveArrayConstant.equals(Object)",
    "int PrimitiveArrayConstant.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PrimitiveArrayConstant(), "Different type to PrimitiveArrayConstant");
  }
}
