package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;

public class RemoveLocalFromSSADiffblueTest {
  /**
   * Method under test: {@link RemoveLocalFromSSA#getOrCreate(Map, Local)}
   */
  @Test
  public void testGetOrCreate() {
    // Arrange
    HashMap<Local, RemoveLocalFromSSA.PhiObject> map = new HashMap<>();

    // Act
    RemoveLocalFromSSA.PhiObject actualOrCreate = RemoveLocalFromSSA.getOrCreate(map, new Local());

    // Assert
    assertEquals(1, map.size());
    Local local = actualOrCreate.local;
    assertEquals("a0", local.toString0());
    assertNull(local.getOps());
    assertNull(local.tag);
    assertNull(local.debugName);
    assertNull(local.signature);
    assertNull(local.valueType);
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
    assertEquals(0, local._ls_index);
    assertEquals(ET.E0, local.et);
    assertEquals(Value.VT.LOCAL, local.vt);
    assertFalse(actualOrCreate.isInitByPhi);
    assertTrue(actualOrCreate.children.isEmpty());
    assertTrue(actualOrCreate.parent.isEmpty());
  }

  /**
   * Method under test:
   * {@link RemoveLocalFromSSA#linkPhiObject(RemoveLocalFromSSA.PhiObject, RemoveLocalFromSSA.PhiObject)}
   */
  @Test
  public void testLinkPhiObject() {
    // Arrange
    RemoveLocalFromSSA.PhiObject parent = new RemoveLocalFromSSA.PhiObject();

    // Act
    RemoveLocalFromSSA.linkPhiObject(parent, new RemoveLocalFromSSA.PhiObject());

    // Assert
    assertEquals(1, parent.children.size());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link RemoveLocalFromSSA.PhiObject}
   */
  @Test
  public void testPhiObjectNewPhiObject() {
    // Arrange and Act
    RemoveLocalFromSSA.PhiObject actualPhiObject = new RemoveLocalFromSSA.PhiObject();

    // Assert
    assertTrue(actualPhiObject.children.isEmpty());
    assertTrue(actualPhiObject.parent.isEmpty());
  }

  /**
   * Method under test:
   * {@link RemoveLocalFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged() {
    // Arrange
    RemoveLocalFromSSA removeLocalFromSSA = new RemoveLocalFromSSA();

    // Act and Assert
    assertFalse(removeLocalFromSSA.transformReportChanged(new IrMethod()));
  }

  /**
   * Method under test:
   * {@link RemoveLocalFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged2() {
    // Arrange
    RemoveLocalFromSSA removeLocalFromSSA = new RemoveLocalFromSSA();
    IrMethod method = new IrMethod();
    method.phiLabels = new ArrayList<>();

    // Act and Assert
    assertFalse(removeLocalFromSSA.transformReportChanged(method));
  }
}
