package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class AssignStmtDiffblueTest {
  /**
   * Test {@link AssignStmt#AssignStmt(ST, Value, Value)}.
   *
   * <p>Method under test: {@link AssignStmt#AssignStmt(ST, Value, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssignStmt.<init>(ST, Value, Value)"})
  public void testNewAssignStmt() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr right = new ArrayExpr();

    // Act
    AssignStmt actualAssignStmt = new AssignStmt(ST.LOCAL_START, left, right);

    // Assert
    Value op1 = actualAssignStmt.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualAssignStmt.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualAssignStmt.getOps());
    assertNull(actualAssignStmt.frame);
    assertNull(actualAssignStmt.exceptionHandlers);
    assertNull(actualAssignStmt._cfg_froms);
    assertNull(actualAssignStmt.getOp());
    assertNull(actualAssignStmt.getNext());
    assertNull(actualAssignStmt.getPre());
    assertNull(actualAssignStmt._ts_default_next);
    assertNull(actualAssignStmt.list);
    assertEquals(0, actualAssignStmt.id);
    assertEquals(ET.E2, actualAssignStmt.et);
    assertEquals(ST.LOCAL_START, actualAssignStmt.st);
    assertFalse(actualAssignStmt.visited);
    assertSame(left, op1);
    assertSame(right, op2);
  }

  /**
   * Test {@link AssignStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nAssign nNull and nNull.
   *   <li>Then Op1 return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt AssignStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_givenNAssignNNullAndNNull_thenOp1ReturnConstant() {
    // Arrange
    Constant left = Exprs.nNull();
    AssignStmt nAssignResult = Stmts.nAssign(left, Exprs.nNull());

    // Act
    Stmt actualCloneResult = nAssignResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult.getOp1() instanceof Constant);
    assertTrue(actualCloneResult.getOp2() instanceof Constant);
    assertTrue(actualCloneResult instanceof AssignStmt);
    assertNull(actualCloneResult.getOps());
    assertNull(((AssignStmt) actualCloneResult).frame);
    assertNull(((AssignStmt) actualCloneResult).exceptionHandlers);
    assertNull(((AssignStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((AssignStmt) actualCloneResult)._ts_default_next);
    assertNull(((AssignStmt) actualCloneResult).list);
    assertEquals(0, ((AssignStmt) actualCloneResult).id);
    assertEquals(ET.E2, ((AssignStmt) actualCloneResult).et);
    assertEquals(ST.ASSIGN, ((AssignStmt) actualCloneResult).st);
    assertFalse(((AssignStmt) actualCloneResult).visited);
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null][null] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullNullNull() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    left.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nAssign {@link ArrayExpr#ArrayExpr()} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNAssignArrayExprAndArrayExpr_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nAssign {@link ArrayExpr#ArrayExpr()} and {@code null}.
   *   <li>Then return {@code null[null] = null}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNAssignArrayExprAndNull_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null[null] = null", Stmts.nAssign(new ArrayExpr(), null).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nAssign {@code null} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNAssignNullAndArrayExpr_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null = null[null]", Stmts.nAssign(null, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nFillArrayData {@link ArrayExpr#ArrayExpr()} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null] <- null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNFillArrayDataArrayExprAndArrayExpr_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "null[null] <- null[null]", Stmts.nFillArrayData(left, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nFillArrayData {@link ArrayExpr#ArrayExpr()} and {@code null}.
   *   <li>Then return {@code null[null] <- null}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNFillArrayDataArrayExprAndNull_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null[null] <- null", Stmts.nFillArrayData(new ArrayExpr(), null).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nFillArrayData {@code null} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null <- null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNFillArrayDataNullAndArrayExpr_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null <- null[null]", Stmts.nFillArrayData(null, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nIdentity {@link ArrayExpr#ArrayExpr()} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null] := null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNIdentityArrayExprAndArrayExpr_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr local = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null] := null[null]", Stmts.nIdentity(local, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nIdentity {@link ArrayExpr#ArrayExpr()} and {@code null}.
   *   <li>Then return {@code null[null] := null}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNIdentityArrayExprAndNull_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null[null] := null", Stmts.nIdentity(new ArrayExpr(), null).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nIdentity {@code null} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null := null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_givenNIdentityNullAndArrayExpr_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null := null[null]", Stmts.nIdentity(null, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null][null[null]] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  public void testToString_thenReturnNullNullNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr left = new ArrayExpr(base, new ArrayExpr(), "[");

    // Act and Assert
    assertEquals(
        "null[null][null[null]] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }
}
