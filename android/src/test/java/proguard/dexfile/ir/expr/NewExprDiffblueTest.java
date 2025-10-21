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

public class NewExprDiffblueTest {
  /**
   * Test {@link NewExpr#NewExpr(String)}.
   *
   * <p>Method under test: {@link NewExpr#NewExpr(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NewExpr.<init>(String)"})
  public void testNewNewExpr() {
    // Arrange and Act
    NewExpr actualNewExpr = new NewExpr("Type");

    // Assert
    assertEquals("Type", actualNewExpr.type);
    assertNull(actualNewExpr.getOps());
    assertNull(actualNewExpr.tag);
    assertNull(actualNewExpr.valueType);
    assertNull(actualNewExpr.getOp());
    assertNull(actualNewExpr.getOp1());
    assertNull(actualNewExpr.getOp2());
    assertEquals(ET.E0, actualNewExpr.et);
    assertEquals(VT.NEW, actualNewExpr.vt);
  }

  /**
   * Test {@link NewExpr#clone()}.
   *
   * <p>Method under test: {@link NewExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value NewExpr.clone()"})
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nNew("Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof NewExpr);
    assertEquals("Type", ((NewExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((NewExpr) actualCloneResult).tag);
    assertNull(((NewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((NewExpr) actualCloneResult).et);
    assertEquals(VT.NEW, ((NewExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link NewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link NewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value NewExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");

    // Act
    Value actualCloneResult = nNewResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof NewExpr);
    assertEquals("Type", ((NewExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((NewExpr) actualCloneResult).tag);
    assertNull(((NewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((NewExpr) actualCloneResult).et);
    assertEquals(VT.NEW, ((NewExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link NewExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link NewExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NewExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");

    // Act
    nNewResult.releaseMemory();

    // Assert
    assertEquals("NEW ", nNewResult.toString0());
    assertNull(nNewResult.type);
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code D}.
   *   <li>Then return {@code NEW double}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewExpr.toString0()"})
  public void testToString0_givenNNewD_thenReturnNewDouble() {
    // Arrange, Act and Assert
    assertEquals("NEW double", Exprs.nNew("D").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code F}.
   *   <li>Then return {@code NEW float}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewExpr.toString0()"})
  public void testToString0_givenNNewF_thenReturnNewFloat() {
    // Arrange, Act and Assert
    assertEquals("NEW float", Exprs.nNew("F").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code I}.
   *   <li>Then return {@code NEW int}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewExpr.toString0()"})
  public void testToString0_givenNNewI_thenReturnNewInt() {
    // Arrange, Act and Assert
    assertEquals("NEW int", Exprs.nNew("I").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code J}.
   *   <li>Then return {@code NEW long}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewExpr.toString0()"})
  public void testToString0_givenNNewJ_thenReturnNewLong() {
    // Arrange, Act and Assert
    assertEquals("NEW long", Exprs.nNew("J").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code Type} {@link NewExpr#type} is empty string.
   *   <li>Then return {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewExpr.toString0()"})
  public void testToString0_givenNNewTypeTypeIsEmptyString_thenReturnNew() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");
    nNewResult.type = "";

    // Act and Assert
    assertEquals("NEW ", nNewResult.toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code Type} {@link NewExpr#type} is {@code null}.
   *   <li>Then return {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewExpr.toString0()"})
  public void testToString0_givenNNewTypeTypeIsNull_thenReturnNew() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");
    nNewResult.type = null;

    // Act and Assert
    assertEquals("NEW ", nNewResult.toString0());
  }
}
