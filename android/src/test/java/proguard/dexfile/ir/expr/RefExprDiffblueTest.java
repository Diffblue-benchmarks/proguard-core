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

public class RefExprDiffblueTest {
  /**
   * Test {@link RefExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link RefExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RefExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    RefExpr nExceptionRefResult = Exprs.nExceptionRef("Type");

    // Act
    nExceptionRefResult.releaseMemory();

    // Assert
    assertNull(nExceptionRefResult.type);
  }

  /**
   * Test {@link RefExpr#RefExpr(VT, String, int)}.
   *
   * <p>Method under test: {@link RefExpr#RefExpr(VT, String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RefExpr.<init>(VT, String, int)"})
  public void testNewRefExpr() {
    // Arrange and Act
    RefExpr actualRefExpr = new RefExpr(VT.ADD, "Ref Type", 1);

    // Assert
    assertEquals("Ref Type", actualRefExpr.type);
    assertNull(actualRefExpr.getOps());
    assertNull(actualRefExpr.tag);
    assertNull(actualRefExpr.valueType);
    assertNull(actualRefExpr.getOp());
    assertNull(actualRefExpr.getOp1());
    assertNull(actualRefExpr.getOp2());
    assertEquals(1, actualRefExpr.parameterIndex);
    assertEquals(ET.E0, actualRefExpr.et);
    assertEquals(VT.ADD, actualRefExpr.vt);
  }

  /**
   * Test {@link RefExpr#clone()}.
   *
   * <p>Method under test: {@link RefExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value RefExpr.clone()"})
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nExceptionRef("Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof RefExpr);
    assertEquals("@Exception", actualCloneResult.toString0());
    assertEquals("Type", ((RefExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((RefExpr) actualCloneResult).tag);
    assertNull(((RefExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(-1, ((RefExpr) actualCloneResult).parameterIndex);
    assertEquals(ET.E0, ((RefExpr) actualCloneResult).et);
    assertEquals(VT.EXCEPTION_REF, ((RefExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link RefExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link RefExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value RefExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper() {
    // Arrange
    RefExpr nExceptionRefResult = Exprs.nExceptionRef("Type");

    // Act
    Value actualCloneResult = nExceptionRefResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof RefExpr);
    assertEquals("@Exception", actualCloneResult.toString0());
    assertEquals("Type", ((RefExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((RefExpr) actualCloneResult).tag);
    assertNull(((RefExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(-1, ((RefExpr) actualCloneResult).parameterIndex);
    assertEquals(ET.E0, ((RefExpr) actualCloneResult).et);
    assertEquals(VT.EXCEPTION_REF, ((RefExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link RefExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nExceptionRef {@code Type}.
   *   <li>Then return {@code @Exception}.
   * </ul>
   *
   * <p>Method under test: {@link RefExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RefExpr.toString0()"})
  public void testToString0_givenNExceptionRefType_thenReturnException() {
    // Arrange, Act and Assert
    assertEquals("@Exception", Exprs.nExceptionRef("Type").toString0());
  }

  /**
   * Test {@link RefExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nParameterRef {@code @Exception} and one.
   *   <li>Then return {@code @parameter_1}.
   * </ul>
   *
   * <p>Method under test: {@link RefExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RefExpr.toString0()"})
  public void testToString0_givenNParameterRefExceptionAndOne_thenReturnParameter1() {
    // Arrange, Act and Assert
    assertEquals("@parameter_1", Exprs.nParameterRef("@Exception", 1).toString0());
  }

  /**
   * Test {@link RefExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nThisRef {@code @Exception}.
   *   <li>Then return {@code @this}.
   * </ul>
   *
   * <p>Method under test: {@link RefExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RefExpr.toString0()"})
  public void testToString0_givenNThisRefException_thenReturnThis() {
    // Arrange, Act and Assert
    assertEquals("@this", Exprs.nThisRef("@Exception").toString0());
  }
}
