package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class StaticFieldExprDiffblueTest {
  /**
   * Method under test: {@link StaticFieldExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Act
    nStaticFieldResult.releaseMemory();

    // Assert
    assertEquals(".null", nStaticFieldResult.toString0());
    assertNull(nStaticFieldResult.name);
    assertNull(nStaticFieldResult.owner);
    assertNull(nStaticFieldResult.type);
  }

  /**
   * Method under test: {@link StaticFieldExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof StaticFieldExpr);
    assertEquals("Field Name", ((StaticFieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((StaticFieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((StaticFieldExpr) actualCloneResult).owner);
    assertNull(actualCloneResult.getOps());
    assertNull(((StaticFieldExpr) actualCloneResult).tag);
    assertNull(((StaticFieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((StaticFieldExpr) actualCloneResult).et);
    assertEquals(Value.VT.STATIC_FIELD, ((StaticFieldExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link StaticFieldExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Act
    Value actualCloneResult = nStaticFieldResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof StaticFieldExpr);
    assertEquals("Field Name", ((StaticFieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((StaticFieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((StaticFieldExpr) actualCloneResult).owner);
    assertNull(actualCloneResult.getOps());
    assertNull(((StaticFieldExpr) actualCloneResult).tag);
    assertNull(((StaticFieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((StaticFieldExpr) actualCloneResult).et);
    assertEquals(Value.VT.STATIC_FIELD, ((StaticFieldExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type");
    nStaticFieldResult.owner = null;

    // Act and Assert
    assertEquals(".Field Name", nStaticFieldResult.toString0());
  }

  /**
   * Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type");
    nStaticFieldResult.owner = "";

    // Act and Assert
    assertEquals(".Field Name", nStaticFieldResult.toString0());
  }

  /**
   * Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange, Act and Assert
    assertEquals("double.Field Name", Exprs.nStaticField("D", "Field Name", "Field Type").toString0());
  }

  /**
   * Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange, Act and Assert
    assertEquals("float.Field Name", Exprs.nStaticField("F", "Field Name", "Field Type").toString0());
  }

  /**
   * Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange, Act and Assert
    assertEquals("int.Field Name", Exprs.nStaticField("I", "Field Name", "Field Type").toString0());
  }

  /**
   * Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  public void testToString06() {
    // Arrange, Act and Assert
    assertEquals("long.Field Name", Exprs.nStaticField("J", "Field Name", "Field Type").toString0());
  }

  /**
   * Method under test:
   * {@link StaticFieldExpr#StaticFieldExpr(String, String, String)}
   */
  @Test
  public void testNewStaticFieldExpr() {
    // Arrange and Act
    StaticFieldExpr actualStaticFieldExpr = new StaticFieldExpr("Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualStaticFieldExpr.name);
    assertEquals("Field Type", actualStaticFieldExpr.type);
    assertEquals("Owner Type", actualStaticFieldExpr.owner);
    assertNull(actualStaticFieldExpr.getOps());
    assertNull(actualStaticFieldExpr.tag);
    assertNull(actualStaticFieldExpr.valueType);
    assertNull(actualStaticFieldExpr.getOp());
    assertNull(actualStaticFieldExpr.getOp1());
    assertNull(actualStaticFieldExpr.getOp2());
    assertEquals(ET.E0, actualStaticFieldExpr.et);
    assertEquals(Value.VT.STATIC_FIELD, actualStaticFieldExpr.vt);
  }
}
