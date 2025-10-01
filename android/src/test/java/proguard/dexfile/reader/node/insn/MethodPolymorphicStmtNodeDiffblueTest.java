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

class MethodPolymorphicStmtNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodPolymorphicStmtNode#MethodPolymorphicStmtNode(Op, int[], Method, Proto)}
   *   <li>{@link MethodPolymorphicStmtNode#getProto()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MethodPolymorphicStmtNode.<init>(Op, int[], Method, Proto)",
    "Proto MethodPolymorphicStmtNode.getProto()"
  })
  void testGettersAndSetters() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    // Act
    MethodPolymorphicStmtNode actualMethodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);
    Proto actualProto = actualMethodPolymorphicStmtNode.getProto();

    // Assert
    Method method2 = actualMethodPolymorphicStmtNode.method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertSame(proto, method2.getProto());
    assertSame(proto2, actualProto);
    assertArrayEquals(new String[] {"Parameter Types"}, method2.getParameterTypes());
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);
    DexCodeNode cv = new DexCodeNode();

    // Act
    methodPolymorphicStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodPolymorphicStmtNode);
    assertEquals(0, ((MethodPolymorphicStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodPolymorphicStmtNode) getResult).op);
    assertSame(proto, methodPolymorphicStmtNode.method.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
    assertSame(proto2, ((MethodPolymorphicStmtNode) getResult).getProto());
    assertSame(methodPolymorphicStmtNode.method, ((MethodPolymorphicStmtNode) getResult).method);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((MethodPolymorphicStmtNode) getResult).args);
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode(); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);

    // Act
    methodPolymorphicStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    Method method2 = methodPolymorphicStmtNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor(); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);

    // Act
    methodPolymorphicStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    Method method2 = methodPolymorphicStmtNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexCodeVisitor); when DexCodeVisitor(); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);

    // Act
    methodPolymorphicStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    Method method2 = methodPolymorphicStmtNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
  }
}
