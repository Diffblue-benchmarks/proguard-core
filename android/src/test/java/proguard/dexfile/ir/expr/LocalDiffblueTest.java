package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

class LocalDiffblueTest {
  /**
   * Test {@link Local#Local()}.
   *
   * <p>Method under test: {@link Local#Local()}
   */
  @Test
  @DisplayName("Test new Local()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.Local.<init>()"})
  void testNewLocal() {
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#Local(int)}.
   *
   * <p>Method under test: {@link Local#Local(int)}
   */
  @Test
  @DisplayName("Test new Local(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.Local.<init>(int)"})
  void testNewLocal2() {
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#Local(int, String)}.
   *
   * <p>Method under test: {@link Local#Local(int, String)}
   */
  @Test
  @DisplayName("Test new Local(int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.Local.<init>(int, java.lang.String)"})
  void testNewLocal3() {
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#Local(String)}.
   *
   * <p>Method under test: {@link Local#Local(String)}
   */
  @Test
  @DisplayName("Test new Local(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.Local.<init>(java.lang.String)"})
  void testNewLocal4() {
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#clone()}.
   *
   * <p>Method under test: {@link Local#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Local.clone()"})
  void testClone() {
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
    assertEquals(VT.LOCAL, ((Local) actualCloneResult).vt);
  }

  /**
   * Test {@link Local#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>When {@link LabelAndLocalMapper} (default constructor).
   *   <li>Then return {@link Local}.
   * </ul>
   *
   * <p>Method under test: {@link Local#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; when LabelAndLocalMapper (default constructor); then return Local")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Local.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_whenLabelAndLocalMapper_thenReturnLocal() {
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
    assertEquals(VT.LOCAL, ((Local) actualCloneResult).vt);
  }

  /**
   * Test {@link Local#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Local#Local()} {@link Local#debugName} is {@code foo}.
   *   <li>Then return {@code foo_0}.
   * </ul>
   *
   * <p>Method under test: {@link Local#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given Local() debugName is 'foo'; then return 'foo_0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Local.toString0()"})
  void testToString0_givenLocalDebugNameIsFoo_thenReturnFoo0() {
    // Arrange
    Local local = new Local();
    local.debugName = "foo";

    // Act and Assert
    assertEquals("foo_0", local.toString0());
  }

  /**
   * Test {@link Local#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Local#Local()}.
   *   <li>Then return {@code a0}.
   * </ul>
   *
   * <p>Method under test: {@link Local#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given Local(); then return 'a0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Local.toString0()"})
  void testToString0_givenLocal_thenReturnA0() {
    // Arrange, Act and Assert
    assertEquals("a0", (new Local()).toString0());
  }
}
