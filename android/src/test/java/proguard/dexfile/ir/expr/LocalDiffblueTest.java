package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class LocalDiffblueTest {
  /**
   * Method under test: {@link Local#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = (new Local()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof Local);
    assertEquals("a0", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(((Local) actualCloneResult).tag);
    assertNull(((Local) actualCloneResult).debugName);
    assertNull(((Local) actualCloneResult).signature);
    assertNull(((Local) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(0, ((Local) actualCloneResult)._ls_index);
    assertEquals(ET.E0, ((Local) actualCloneResult).et);
    assertEquals(Value.VT.LOCAL, ((Local) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link Local#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Local local = new Local();

    // Act
    Value actualCloneResult = local.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof Local);
    assertEquals("a0", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(((Local) actualCloneResult).tag);
    assertNull(((Local) actualCloneResult).debugName);
    assertNull(((Local) actualCloneResult).signature);
    assertNull(((Local) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(0, ((Local) actualCloneResult)._ls_index);
    assertEquals(ET.E0, ((Local) actualCloneResult).et);
    assertEquals(Value.VT.LOCAL, ((Local) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link Local#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("a0", (new Local()).toString0());
  }

  /**
   * Method under test: {@link Local#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    Local local = new Local();
    local.debugName = "foo";

    // Act and Assert
    assertEquals("foo_0", local.toString0());
  }

  /**
   * Method under test: {@link Local#Local()}
   */
  @Test
  public void testNewLocal() {
    // Arrange and Act
    Local actualLocal = new Local();

    // Assert
    assertEquals("a0", actualLocal.toString0());
    assertNull(actualLocal.getOps());
    assertNull(actualLocal.tag);
    assertNull(actualLocal.debugName);
    assertNull(actualLocal.signature);
    assertNull(actualLocal.valueType);
    assertNull(actualLocal.getOp());
    assertNull(actualLocal.getOp1());
    assertNull(actualLocal.getOp2());
    assertEquals(0, actualLocal._ls_index);
    assertEquals(ET.E0, actualLocal.et);
    assertEquals(Value.VT.LOCAL, actualLocal.vt);
  }

  /**
   * Method under test: {@link Local#Local(int)}
   */
  @Test
  public void testNewLocal2() {
    // Arrange and Act
    Local actualLocal = new Local(1);

    // Assert
    assertEquals("a1", actualLocal.toString0());
    assertNull(actualLocal.getOps());
    assertNull(actualLocal.tag);
    assertNull(actualLocal.debugName);
    assertNull(actualLocal.signature);
    assertNull(actualLocal.valueType);
    assertNull(actualLocal.getOp());
    assertNull(actualLocal.getOp1());
    assertNull(actualLocal.getOp2());
    assertEquals(1, actualLocal._ls_index);
    assertEquals(ET.E0, actualLocal.et);
    assertEquals(Value.VT.LOCAL, actualLocal.vt);
  }

  /**
   * Method under test: {@link Local#Local(int, String)}
   */
  @Test
  public void testNewLocal3() {
    // Arrange and Act
    Local actualLocal = new Local(1, "Debug Name");

    // Assert
    assertEquals("Debug Name", actualLocal.debugName);
    assertEquals("Debug Name_1", actualLocal.toString0());
    assertNull(actualLocal.getOps());
    assertNull(actualLocal.tag);
    assertNull(actualLocal.signature);
    assertNull(actualLocal.valueType);
    assertNull(actualLocal.getOp());
    assertNull(actualLocal.getOp1());
    assertNull(actualLocal.getOp2());
    assertEquals(1, actualLocal._ls_index);
    assertEquals(ET.E0, actualLocal.et);
    assertEquals(Value.VT.LOCAL, actualLocal.vt);
  }

  /**
   * Method under test: {@link Local#Local(String)}
   */
  @Test
  public void testNewLocal4() {
    // Arrange and Act
    Local actualLocal = new Local("Debug Name");

    // Assert
    assertEquals("Debug Name", actualLocal.debugName);
    assertEquals("Debug Name_0", actualLocal.toString0());
    assertNull(actualLocal.getOps());
    assertNull(actualLocal.tag);
    assertNull(actualLocal.signature);
    assertNull(actualLocal.valueType);
    assertNull(actualLocal.getOp());
    assertNull(actualLocal.getOp1());
    assertNull(actualLocal.getOp2());
    assertEquals(0, actualLocal._ls_index);
    assertEquals(ET.E0, actualLocal.et);
    assertEquals(Value.VT.LOCAL, actualLocal.vt);
  }
}
