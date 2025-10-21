package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.ts.RemoveLocalFromSSA.PhiObject;

public class RemoveLocalFromSSADiffblueTest {
  /**
   * Test {@link RemoveLocalFromSSA#getOrCreate(Map, Local)}.
   *
   * <p>Method under test: {@link RemoveLocalFromSSA#getOrCreate(Map, Local)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PhiObject RemoveLocalFromSSA.getOrCreate(Map, Local)"})
  public void testGetOrCreate() {
    // Arrange
    HashMap<Local, PhiObject> map = new HashMap<>();

    // Act
    PhiObject actualOrCreate = RemoveLocalFromSSA.getOrCreate(map, new Local());

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
    assertEquals(VT.LOCAL, local.vt);
    assertFalse(actualOrCreate.isInitByPhi);
    assertTrue(actualOrCreate.children.isEmpty());
    assertTrue(actualOrCreate.parent.isEmpty());
  }

  /**
   * Test {@link RemoveLocalFromSSA#linkPhiObject(PhiObject, PhiObject)}.
   *
   * <ul>
   *   <li>When {@link PhiObject} (default constructor).
   *   <li>Then {@link PhiObject} (default constructor) {@link PhiObject#children} size is one.
   * </ul>
   *
   * <p>Method under test: {@link RemoveLocalFromSSA#linkPhiObject(PhiObject, PhiObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoveLocalFromSSA.linkPhiObject(PhiObject, PhiObject)"})
  public void testLinkPhiObject_whenPhiObject_thenPhiObjectChildrenSizeIsOne() {
    // Arrange
    PhiObject parent = new PhiObject();

    // Act
    RemoveLocalFromSSA.linkPhiObject(parent, new PhiObject());

    // Assert
    assertEquals(1, parent.children.size());
  }

  /**
   * Test PhiObject new {@link PhiObject} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PhiObject}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PhiObject.<init>()"})
  public void testPhiObjectNewPhiObject() {
    // Arrange and Act
    PhiObject actualPhiObject = new PhiObject();

    // Assert
    assertTrue(actualPhiObject.children.isEmpty());
    assertTrue(actualPhiObject.parent.isEmpty());
  }

  /**
   * Test {@link RemoveLocalFromSSA#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveLocalFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RemoveLocalFromSSA.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_givenArrayList_thenReturnFalse() {
    // Arrange
    RemoveLocalFromSSA removeLocalFromSSA = new RemoveLocalFromSSA();
    IrMethod method = new IrMethod();
    method.phiLabels = new ArrayList<>();

    // Act and Assert
    assertFalse(removeLocalFromSSA.transformReportChanged(method));
  }

  /**
   * Test {@link RemoveLocalFromSSA#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveLocalFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RemoveLocalFromSSA.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    RemoveLocalFromSSA removeLocalFromSSA = new RemoveLocalFromSSA();

    // Act and Assert
    assertFalse(removeLocalFromSSA.transformReportChanged(new IrMethod()));
  }
}
