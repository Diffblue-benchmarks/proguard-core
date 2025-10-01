package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class MethodCustomStmtNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCustomStmtNode#MethodCustomStmtNode(Op, int[], String, Proto, MethodHandle,
   *       Object[])}
   *   <li>{@link MethodCustomStmtNode#getProto()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MethodCustomStmtNode.<init>(Op, int[], String, Proto, MethodHandle, Object[])",
    "Proto MethodCustomStmtNode.getProto()"
  })
  void testGettersAndSetters() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    // Act
    MethodCustomStmtNode actualMethodCustomStmtNode =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Name", proto, bsm, bsmArgs);
    Proto actualProto = actualMethodCustomStmtNode.getProto();

    // Assert
    MethodHandle methodHandle = actualMethodCustomStmtNode.bsm;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualProto);
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Name", proto, bsm, bsmArgs);
    DexCodeNode cv = new DexCodeNode();

    // Act
    methodCustomStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodCustomStmtNode);
    assertEquals("Name", ((MethodCustomStmtNode) getResult).name);
    assertEquals(0, ((MethodCustomStmtNode) getResult).__index);
    assertEquals(1, methodCustomStmtNode.bsmArgs.length);
    Object[] objectArray = ((MethodCustomStmtNode) getResult).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(Op.NOP, ((MethodCustomStmtNode) getResult).op);
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
    assertSame(proto, ((MethodCustomStmtNode) getResult).getProto());
    assertSame(methodCustomStmtNode.bsm, ((MethodCustomStmtNode) getResult).bsm);
    assertSame(methodCustomStmtNode.bsmArgs, objectArray);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((MethodCustomStmtNode) getResult).args);
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexCodeVisitor); when DexCodeVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitor() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Name", proto, bsm, bsmArgs);

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Name", proto, bsm, bsmArgs);

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle bsm = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Name", proto, bsm, bsmArgs);

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }
}
