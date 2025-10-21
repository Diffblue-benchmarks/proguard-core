package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

public class ConstantDiffblueTest {
  /**
   * Test {@link Constant#Constant(Object)}.
   *
   * <p>Method under test: {@link Constant#Constant(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Constant.<init>(Object)"})
  public void testNewConstant() {
    // Arrange and Act
    Constant actualConstant = new Constant(Constant.Null);

    // Assert
    assertNull(actualConstant.getOps());
    assertNull(actualConstant.tag);
    assertNull(actualConstant.valueType);
    assertNull(actualConstant.getOp());
    assertNull(actualConstant.getOp1());
    assertNull(actualConstant.getOp2());
    assertEquals(ET.E0, actualConstant.et);
    assertEquals(VT.CONSTANT, actualConstant.vt);
  }

  /**
   * Test {@link Constant#clone()}.
   *
   * <p>Method under test: {@link Constant#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Constant.clone()"})
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nNull().clone();

    // Assert
    assertTrue(actualCloneResult instanceof Constant);
    assertNull(actualCloneResult.getOps());
    assertNull(((Constant) actualCloneResult).tag);
    assertNull(((Constant) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((Constant) actualCloneResult).et);
    assertEquals(VT.CONSTANT, ((Constant) actualCloneResult).vt);
  }

  /**
   * Test {@link Constant#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link Constant#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Constant.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    Value actualCloneResult = nNullResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof Constant);
    assertNull(actualCloneResult.getOps());
    assertNull(((Constant) actualCloneResult).tag);
    assertNull(((Constant) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((Constant) actualCloneResult).et);
    assertEquals(VT.CONSTANT, ((Constant) actualCloneResult).vt);
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nByte {@code A} {@link Constant#value} is forty-two.
   *   <li>Then return {@code 42L}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  public void testToString0_givenNByteAValueIsFortyTwo_thenReturn42l() {
    // Arrange
    Constant nByteResult = Exprs.nByte((byte) 'A');
    nByteResult.value = 42L;

    // Act and Assert
    assertEquals("42L", nByteResult.toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nByte {@code A}.
   *   <li>Then return {@code 65}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  public void testToString0_givenNByteA_thenReturn65() {
    // Arrange, Act and Assert
    assertEquals("65", Exprs.nByte((byte) 'A').toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nChar {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  public void testToString0_givenNCharA_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals("A", Exprs.nChar('A').toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nNull {@link Constant#value} is {@code null}.
   *   <li>Then return {@code NULL}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  public void testToString0_givenNNullValueIsNull_thenReturnNull() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    nNullResult.value = null;

    // Act and Assert
    assertEquals("NULL", nNullResult.toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nNull {@link Constant#value} is {@code NULL}.
   *   <li>Then return {@code "NULL"}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  public void testToString0_givenNNullValueIsNull_thenReturnNull2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    nNullResult.value = "NULL";

    // Act and Assert
    assertEquals("\"NULL\"", nNullResult.toString0());
  }

  /**
   * Test {@link Constant#toString0()}.
   *
   * <ul>
   *   <li>Given nNull.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Constant#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Constant.toString0()"})
  public void testToString0_givenNNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", Exprs.nNull().toString0());
  }
}
