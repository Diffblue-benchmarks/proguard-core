package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class NewExprDiffblueTest {
  /**
   * Method under test: {@link NewExpr#clone()}
   */
  @Test
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
    assertEquals(Value.VT.NEW, ((NewExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link NewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
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
    assertEquals(Value.VT.NEW, ((NewExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link NewExpr#releaseMemory()}
   */
  @Test
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
   * Method under test: {@link NewExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");
    nNewResult.type = null;

    // Act and Assert
    assertEquals("NEW ", nNewResult.toString0());
  }

  /**
   * Method under test: {@link NewExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");
    nNewResult.type = "";

    // Act and Assert
    assertEquals("NEW ", nNewResult.toString0());
  }

  /**
   * Method under test: {@link NewExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange, Act and Assert
    assertEquals("NEW double", Exprs.nNew("D").toString0());
  }

  /**
   * Method under test: {@link NewExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange, Act and Assert
    assertEquals("NEW float", Exprs.nNew("F").toString0());
  }

  /**
   * Method under test: {@link NewExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange, Act and Assert
    assertEquals("NEW int", Exprs.nNew("I").toString0());
  }

  /**
   * Method under test: {@link NewExpr#toString0()}
   */
  @Test
  public void testToString06() {
    // Arrange, Act and Assert
    assertEquals("NEW long", Exprs.nNew("J").toString0());
  }

  /**
   * Method under test: {@link NewExpr#NewExpr(String)}
   */
  @Test
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
    assertEquals(Value.VT.NEW, actualNewExpr.vt);
  }
}
