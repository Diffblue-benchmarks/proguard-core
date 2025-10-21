package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;

public class DexCodeVisitorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.<init>()", "void DexCodeVisitor.<init>(DexCodeVisitor)"})
  public void testNewDexCodeVisitor_thenReturnVisitorIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.<init>()", "void DexCodeVisitor.<init>(DexCodeVisitor)"})
  public void testNewDexCodeVisitor_whenDexCodeVisitor_thenReturnVisitorVisitorIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitRegister(int)"})
  public void testVisitRegister_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitStmt2R1N(Op, int, int, int)"})
  public void testVisitStmt2R1N_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitStmt3R(Op, int, int, int)"})
  public void testVisitStmt3R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitTypeStmt(Op, int, int, String)"})
  public void testVisitTypeStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitConstStmt(Op, int, Object)"})
  public void testVisitConstStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitFillArrayDataStmt(Op, int, Object)"})
  public void testVisitFillArrayDataStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitFieldStmt(Op, int, int, Field)"})
  public void testVisitFieldStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitFilledNewArrayStmt(Op, int[], String)"})
  public void testVisitFilledNewArrayStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitJumpStmt(Op, int, int, DexLabel)"})
  public void testVisitJumpStmt_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitLabel(DexLabel)"})
  public void testVisitLabel_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitSparseSwitchStmt(Op, int, int[], DexLabel[])"})
  public void testVisitSparseSwitchStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitMethodStmt(Op, int[], Method, Proto)"})
  public void testVisitMethodStmtWithOpArgsBsmProto() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitMethodStmt(Op, int[], Method)"})
  public void testVisitMethodStmtWithOpArgsMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexCodeVisitor.visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[])"
  })
  public void testVisitMethodStmtWithOpArgsNameProtoBsmBsmArgs() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitStmt2R(Op, int, int)"})
  public void testVisitStmt2R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitStmt0R(Op)"})
  public void testVisitStmt0R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitStmt1R(Op, int)"})
  public void testVisitStmt1R_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitPackedSwitchStmt(Op, int, int, DexLabel[])"})
  public void testVisitPackedSwitchStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeVisitor.visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])"})
  public void testVisitTryCatch_thenDexCodeVisitorWithVisitorIsDexCodeNodeVisitorDexCodeNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexDebugVisitor DexCodeVisitor.visitDebug()"
  })
  public void testVisitDebug_givenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexDebugVisitor DexCodeVisitor.visitDebug()"
  })
  public void testVisitDebug_givenDexCodeVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor()).visitDebug());
  }
}
