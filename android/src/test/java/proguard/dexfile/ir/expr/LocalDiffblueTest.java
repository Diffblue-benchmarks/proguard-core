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

public class LocalDiffblueTest {
  /**
   * Test {@link Local#Local()}.
   *
   * <p>Method under test: {@link Local#Local()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Local.<init>()"})
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#Local(int)}.
   *
   * <p>Method under test: {@link Local#Local(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Local.<init>(int)"})
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#Local(int, String)}.
   *
   * <p>Method under test: {@link Local#Local(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Local.<init>(int, String)"})
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#Local(String)}.
   *
   * <p>Method under test: {@link Local#Local(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Local.<init>(String)"})
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
    assertEquals(VT.LOCAL, actualLocal.vt);
  }

  /**
   * Test {@link Local#clone()}.
   *
   * <p>Method under test: {@link Local#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Local.clone()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Local.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_whenLabelAndLocalMapper_thenReturnLocal() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Local.toString0()"})
  public void testToString0_givenLocalDebugNameIsFoo_thenReturnFoo0() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Local.toString0()"})
  public void testToString0_givenLocal_thenReturnA0() {
    // Arrange, Act and Assert
    assertEquals("a0", (new Local()).toString0());
  }
}
