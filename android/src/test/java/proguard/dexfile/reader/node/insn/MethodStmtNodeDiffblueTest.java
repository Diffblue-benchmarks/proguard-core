package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class MethodStmtNodeDiffblueTest {
  /**
   * Test {@link MethodStmtNode#MethodStmtNode(Op, int[], Method)}.
   *
   * <p>Method under test: {@link MethodStmtNode#MethodStmtNode(Op, int[], Method)}
   */
  @Test
  @DisplayName("Test new MethodStmtNode(Op, int[], Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodStmtNode.<init>(Op, int[], Method)"})
  void testNewMethodStmtNode() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    // Act
    MethodStmtNode actualMethodStmtNode =
        new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method);

    // Assert
    Method method2 = actualMethodStmtNode.method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertSame(proto, method2.getProto());
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method);
    DexCodeNode cv = new DexCodeNode();

    // Act
    methodStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodStmtNode);
    assertEquals(0, ((MethodStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodStmtNode) getResult).op);
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
    assertSame(proto, ((MethodStmtNode) getResult).getProto());
    assertSame(methodStmtNode.method, ((MethodStmtNode) getResult).method);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((MethodStmtNode) getResult).args);
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexCodeVisitor); when DexCodeVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitor() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method);

    // Act
    methodStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method);

    // Act
    methodStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method);

    // Act
    methodStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Test {@link MethodStmtNode#getProto()}.
   *
   * <p>Method under test: {@link MethodStmtNode#getProto()}
   */
  @Test
  @DisplayName("Test getProto()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Proto MethodStmtNode.getProto()"})
  void testGetProto() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method);

    // Act and Assert
    assertSame(proto, methodStmtNode.getProto());
  }
}
