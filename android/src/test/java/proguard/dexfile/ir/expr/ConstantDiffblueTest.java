package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class ConstantDiffblueTest {
  /**
   * Method under test: {@link Constant#clone()}
   */
  @Test
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
    assertEquals(Value.VT.CONSTANT, ((Constant) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link Constant#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
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
    assertEquals(Value.VT.CONSTANT, ((Constant) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link Constant#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("null", Exprs.nNull().toString0());
    assertEquals("65", Exprs.nByte((byte) 'A').toString0());
    assertEquals("A", Exprs.nChar('A').toString0());
  }

  /**
   * Method under test: {@link Constant#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    nNullResult.value = null;

    // Act and Assert
    assertEquals("NULL", nNullResult.toString0());
  }

  /**
   * Method under test: {@link Constant#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    nNullResult.value = "NULL";

    // Act and Assert
    assertEquals("\"NULL\"", nNullResult.toString0());
  }

  /**
   * Method under test: {@link Constant#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange
    Constant nByteResult = Exprs.nByte((byte) 'A');
    nByteResult.value = 42L;

    // Act and Assert
    assertEquals("42L", nByteResult.toString0());
  }

  /**
   * Method under test: {@link Constant#Constant(Object)}
   */
  @Test
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
    assertEquals(Value.VT.CONSTANT, actualConstant.vt);
  }
}
