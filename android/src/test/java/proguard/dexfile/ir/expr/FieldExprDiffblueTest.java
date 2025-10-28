package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class FieldExprDiffblueTest {
  /**
   * Method under test: {@link FieldExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    FieldExpr nFieldResult = Exprs.nField(new ArrayExpr(), "Owner Type", "Field Name", "Field Type");

    // Act
    nFieldResult.releaseMemory();

    // Assert
    assertEquals("null.null", nFieldResult.toString0());
    assertNull(nFieldResult.name);
    assertNull(nFieldResult.owner);
    assertNull(nFieldResult.type);
    assertNull(nFieldResult.getOp());
  }

  /**
   * Method under test: {@link FieldExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant object = Exprs.nNull();
    FieldExpr nFieldResult = Exprs.nField(object, "Owner Type", "Field Name", "Field Type");

    // Act
    Value actualCloneResult = nFieldResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof FieldExpr);
    assertEquals("Field Name", ((FieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((FieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((FieldExpr) actualCloneResult).owner);
    assertEquals("null.Field Name", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(op.getOps());
    assertNull(((Constant) op).tag);
    assertNull(((FieldExpr) actualCloneResult).tag);
    assertNull(((Constant) op).valueType);
    assertNull(((FieldExpr) actualCloneResult).valueType);
    assertNull(op.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E1, ((FieldExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertEquals(Value.VT.FIELD, ((FieldExpr) actualCloneResult).vt);
    assertSame(object.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("null[null].Field Name",
        Exprs.nField(new ArrayExpr(), "Owner Type", "Field Name", "Field Type").toString0());
    assertEquals("null.Field Name", Exprs.nField(null, "Owner Type", "Field Name", "Field Type").toString0());
    assertEquals("null[null].[.Field Name",
        Exprs.nField(Exprs.nField(new ArrayExpr(), "[", "[", "["), "Owner Type", "Field Name", "Field Type")
            .toString0());
  }

  /**
   * Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    ArrayExpr object = new ArrayExpr();
    object.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null].Field Name",
        Exprs.nField(object, "Owner Type", "Field Name", "Field Type").toString0());
  }

  /**
   * Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null][null[null]].Field Name",
        Exprs.nField(Exprs.nArray(base, new ArrayExpr(), "["), "Owner Type", "Field Name", "Field Type").toString0());
  }

  /**
   * Method under test: {@link FieldExpr#FieldExpr(Value, String, String, String)}
   */
  @Test
  public void testNewFieldExpr() {
    // Arrange
    ArrayExpr object = new ArrayExpr();

    // Act
    FieldExpr actualFieldExpr = new FieldExpr(object, "Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualFieldExpr.name);
    assertEquals("Field Type", actualFieldExpr.type);
    assertEquals("Owner Type", actualFieldExpr.owner);
    assertEquals("null[null].Field Name", actualFieldExpr.toString0());
    assertNull(actualFieldExpr.getOps());
    assertNull(actualFieldExpr.tag);
    assertNull(actualFieldExpr.valueType);
    assertNull(actualFieldExpr.getOp1());
    assertNull(actualFieldExpr.getOp2());
    assertEquals(ET.E1, actualFieldExpr.et);
    assertEquals(Value.VT.FIELD, actualFieldExpr.vt);
    assertSame(object, actualFieldExpr.getOp());
  }
}
