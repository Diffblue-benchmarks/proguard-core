package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.ts.RemoveLocalFromSSA.PhiObject;

class RemoveLocalFromSSADiffblueTest {
  /**
   * Test {@link RemoveLocalFromSSA#getOrCreate(Map, Local)}.
   *
   * <p>Method under test: {@link RemoveLocalFromSSA#getOrCreate(Map, Local)}
   */
  @Test
  @DisplayName("Test getOrCreate(Map, Local)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhiObject RemoveLocalFromSSA.getOrCreate(Map, Local)"})
  void testGetOrCreate() {
    // Arrange
    HashMap<Local, PhiObject> map = new HashMap<>();

    // Act
    PhiObject actualOrCreate = RemoveLocalFromSSA.getOrCreate(map, new Local());

    // Assert
    assertEquals(1, map.size());
    Local local = actualOrCreate.local;
    assertEquals("a0", local.toString0());
    assertNull(local.tag);
    assertNull(local.debugName);
    assertNull(local.signature);
    assertNull(local.valueType);
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
    assertNull(local.getOps());
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
  @DisplayName(
      "Test linkPhiObject(PhiObject, PhiObject); when PhiObject (default constructor); then PhiObject (default constructor) children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoveLocalFromSSA.linkPhiObject(PhiObject, PhiObject)"})
  void testLinkPhiObject_whenPhiObject_thenPhiObjectChildrenSizeIsOne() {
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
  @DisplayName("Test PhiObject new PhiObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhiObject.<init>()"})
  void testPhiObjectNewPhiObject() {
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
  @DisplayName("Test transformReportChanged(IrMethod); given ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RemoveLocalFromSSA.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_givenArrayList_thenReturnFalse() {
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
  @DisplayName(
      "Test transformReportChanged(IrMethod); when IrMethod (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RemoveLocalFromSSA.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    RemoveLocalFromSSA removeLocalFromSSA = new RemoveLocalFromSSA();

    // Act and Assert
    assertFalse(removeLocalFromSSA.transformReportChanged(new IrMethod()));
  }
}
