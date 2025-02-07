package proguard.dexfile.reader.visitors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;

class DexCodeVisitorDiffblueTest {
  /**
   * Test {@link DexCodeVisitor#DexCodeVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexCodeVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#DexCodeVisitor()}
   */
  @Test
  @DisplayName("Test new DexCodeVisitor(); then return visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.<init>(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testNewDexCodeVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor()).visitor);
  }

  /**
   * Test {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then return {@link DexCodeVisitor#visitor} {@link DexCodeVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)}
   *   <li>{@link DexCodeVisitor#DexCodeVisitor()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test new DexCodeVisitor(DexCodeVisitor); when DexCodeVisitor(); then return visitor visitor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.<init>()",
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.<init>(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testNewDexCodeVisitor_whenDexCodeVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor(new DexCodeVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexCodeVisitor#visitRegister(int)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitRegister(int)}
   */
  @Test
  @DisplayName(
      "Test visitRegister(int); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexCodeVisitor.visitRegister(int)"})
  void testVisitRegister_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(new DexCodeNode());

    // Act
    dexCodeVisitor.visitRegister(1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertEquals(1, ((DexCodeNode) dexCodeVisitor2).totalRegister);
  }

  /**
   * Test {@link DexCodeVisitor#visitStmt2R1N(Op, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitStmt2R1N(Op, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test visitStmt2R1N(Op, int, int, int); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitStmt2R1N(proguard.dexfile.reader.Op, int, int, int)"
  })
  void testVisitStmt2R1N_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt2R1N(Op.NOP, 1, 1, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitStmt3R(Op, int, int, int)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitStmt3R(Op, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test visitStmt3R(Op, int, int, int); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitStmt3R(proguard.dexfile.reader.Op, int, int, int)"
  })
  void testVisitStmt3R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt3R(Op.NOP, 1, 1, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitTypeStmt(Op, int, int, String)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitTypeStmt(Op, int, int, String)}
   */
  @Test
  @DisplayName(
      "Test visitTypeStmt(Op, int, int, String); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitTypeStmt(proguard.dexfile.reader.Op, int, int, java.lang.String)"
  })
  void testVisitTypeStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitTypeStmt(Op.NOP, 1, 1, "Type");

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitConstStmt(Op, int, Object)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitConstStmt(Op, int, Object)}
   */
  @Test
  @DisplayName(
      "Test visitConstStmt(Op, int, Object); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitConstStmt(proguard.dexfile.reader.Op, int, java.lang.Object)"
  })
  void testVisitConstStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitConstStmt(Op.NOP, 1, Constant.Null);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitFillArrayDataStmt(Op, int, Object)}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitFillArrayDataStmt(Op, int, Object)}
   */
  @Test
  @DisplayName("Test visitFillArrayDataStmt(Op, int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitFillArrayDataStmt(proguard.dexfile.reader.Op, int, java.lang.Object)"
  })
  void testVisitFillArrayDataStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitFillArrayDataStmt(Op.NOP, 1, Constant.Null);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitEnd()}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode} {@link DexCodeVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexCodeVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitEnd()}
   */
  @Test
  @DisplayName("Test visitEnd(); given DexCodeNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.visitors.DexCodeVisitor.visitEnd()"})
  void testVisitEnd_givenDexCodeNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexCodeNode visitor = mock(DexCodeNode.class);
    doNothing().when(visitor).visitEnd();

    // Act
    (new DexCodeVisitor(visitor)).visitEnd();

    // Assert
    verify(visitor).visitEnd();
  }

  /**
   * Test {@link DexCodeVisitor#visitFieldStmt(Op, int, int, Field)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitFieldStmt(Op, int, int, Field)}
   */
  @Test
  @DisplayName(
      "Test visitFieldStmt(Op, int, int, Field); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitFieldStmt(proguard.dexfile.reader.Op, int, int, proguard.dexfile.reader.Field)"
  })
  void testVisitFieldStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitFieldStmt(Op.NOP, 1, 1, new Field("Owner", "Name", "Type"));

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitFilledNewArrayStmt(Op, int[], String)}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitFilledNewArrayStmt(Op, int[], String)}
   */
  @Test
  @DisplayName("Test visitFilledNewArrayStmt(Op, int[], String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitFilledNewArrayStmt(proguard.dexfile.reader.Op, int[], java.lang.String)"
  })
  void testVisitFilledNewArrayStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitFilledNewArrayStmt(Op.NOP, new int[] {1, -1, 1, -1}, "Type");

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitJumpStmt(Op, int, int, DexLabel)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitJumpStmt(Op, int, int, DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitJumpStmt(Op, int, int, DexLabel); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitJumpStmt(proguard.dexfile.reader.Op, int, int, proguard.dexfile.reader.DexLabel)"
  })
  void testVisitJumpStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitJumpStmt(Op.NOP, 1, 1, new DexLabel());

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitLabel(DexLabel)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitLabel(DexLabel)}
   */
  @Test
  @DisplayName(
      "Test visitLabel(DexLabel); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitLabel(proguard.dexfile.reader.DexLabel)"
  })
  void testVisitLabel_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitLabel(new DexLabel());

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitSparseSwitchStmt(Op, int, int[], DexLabel[])}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitSparseSwitchStmt(Op, int, int[], DexLabel[])}
   */
  @Test
  @DisplayName("Test visitSparseSwitchStmt(Op, int, int[], DexLabel[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitSparseSwitchStmt(proguard.dexfile.reader.Op, int, int[], proguard.dexfile.reader.DexLabel[])"
  })
  void testVisitSparseSwitchStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitSparseSwitchStmt(
        Op.NOP, 1, new int[] {1, -1, 1, -1}, new DexLabel[] {new DexLabel()});

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitMethodStmt(Op, int[], Method, Proto)} with {@code op}, {@code
   * args}, {@code bsm}, {@code proto}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitMethodStmt(Op, int[], Method, Proto)}
   */
  @Test
  @DisplayName("Test visitMethodStmt(Op, int[], Method, Proto) with 'op', 'args', 'bsm', 'proto'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitMethodStmt(proguard.dexfile.reader.Op, int[], proguard.dexfile.reader.Method, proguard.dexfile.reader.Proto)"
  })
  void testVisitMethodStmtWithOpArgsBsmProto() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);
    Method bsm =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act
    dexCodeVisitor.visitMethodStmt(
        Op.NOP,
        new int[] {1, -1, 1, -1},
        bsm,
        new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitMethodStmt(Op, int[], Method)} with {@code op}, {@code args},
   * {@code method}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitMethodStmt(Op, int[], Method)}
   */
  @Test
  @DisplayName("Test visitMethodStmt(Op, int[], Method) with 'op', 'args', 'method'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitMethodStmt(proguard.dexfile.reader.Op, int[], proguard.dexfile.reader.Method)"
  })
  void testVisitMethodStmtWithOpArgsMethod() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitMethodStmt(
        Op.NOP,
        new int[] {1, -1, 1, -1},
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[])}
   * with {@code op}, {@code args}, {@code name}, {@code proto}, {@code bsm}, {@code bsmArgs}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitMethodStmt(Op, int[], String, Proto,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[]) with 'op', 'args', 'name', 'proto', 'bsm', 'bsmArgs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitMethodStmt(proguard.dexfile.reader.Op, int[], java.lang.String, proguard.dexfile.reader.Proto, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testVisitMethodStmtWithOpArgsNameProtoBsmBsmArgs() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    dexCodeVisitor.visitMethodStmt(
        Op.NOP,
        new int[] {1, -1, 1, -1},
        "Name",
        proto,
        new MethodHandle(1, new Field("Owner", "Name", "Type")),
        Constant.Null);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitStmt2R(Op, int, int)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitStmt2R(Op, int, int)}
   */
  @Test
  @DisplayName(
      "Test visitStmt2R(Op, int, int); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitStmt2R(proguard.dexfile.reader.Op, int, int)"
  })
  void testVisitStmt2R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt2R(Op.NOP, 1, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitStmt0R(Op)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitStmt0R(Op)}
   */
  @Test
  @DisplayName(
      "Test visitStmt0R(Op); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitStmt0R(proguard.dexfile.reader.Op)"
  })
  void testVisitStmt0R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt0R(Op.NOP);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitStmt1R(Op, int)}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitStmt1R(Op, int)}
   */
  @Test
  @DisplayName(
      "Test visitStmt1R(Op, int); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitStmt1R(proguard.dexfile.reader.Op, int)"
  })
  void testVisitStmt1R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt1R(Op.NOP, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitPackedSwitchStmt(Op, int, int, DexLabel[])}.
   *
   * <p>Method under test: {@link DexCodeVisitor#visitPackedSwitchStmt(Op, int, int, DexLabel[])}
   */
  @Test
  @DisplayName("Test visitPackedSwitchStmt(Op, int, int, DexLabel[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitPackedSwitchStmt(proguard.dexfile.reader.Op, int, int, proguard.dexfile.reader.DexLabel[])"
  })
  void testVisitPackedSwitchStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitPackedSwitchStmt(Op.NOP, 1, 1, new DexLabel[] {new DexLabel()});

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])}.
   *
   * <ul>
   *   <li>Then {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()} {@link DexCodeVisitor#visitor} {@link DexCodeNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitTryCatch(DexLabel, DexLabel, DexLabel[],
   * String[])}
   */
  @Test
  @DisplayName(
      "Test visitTryCatch(DexLabel, DexLabel, DexLabel[], String[]); then DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode() visitor DexCodeNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.visitors.DexCodeVisitor.visitTryCatch(proguard.dexfile.reader.DexLabel, proguard.dexfile.reader.DexLabel, proguard.dexfile.reader.DexLabel[], java.lang.String[])"
  })
  void testVisitTryCatch_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();

    // Act
    dexCodeVisitor.visitTryCatch(
        start, end, new DexLabel[] {new DexLabel()}, new String[] {"Type"});

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.tryStmts, ((DexCodeNode) dexCodeVisitor2).tryStmts);
  }

  /**
   * Test {@link DexCodeVisitor#visitDebug()}.
   *
   * <ul>
   *   <li>Given {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitDebug()}
   */
  @Test
  @DisplayName(
      "Test visitDebug(); given DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexDebugVisitor proguard.dexfile.reader.visitors.DexCodeVisitor.visitDebug()"
  })
  void testVisitDebug_givenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor(new DexCodeVisitor())).visitDebug());
  }

  /**
   * Test {@link DexCodeVisitor#visitDebug()}.
   *
   * <ul>
   *   <li>Given {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeVisitor#visitDebug()}
   */
  @Test
  @DisplayName("Test visitDebug(); given DexCodeVisitor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexDebugVisitor proguard.dexfile.reader.visitors.DexCodeVisitor.visitDebug()"
  })
  void testVisitDebug_givenDexCodeVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor()).visitDebug());
  }
}
