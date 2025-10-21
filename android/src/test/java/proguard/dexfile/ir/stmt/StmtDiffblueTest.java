package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.Stmt.E1Stmt;
import proguard.dexfile.ir.stmt.Stmt.E2Stmt;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class StmtDiffblueTest {
  /**
   * Test E1Stmt {@link E1Stmt#getOp()}.
   *
   * <p>Method under test: {@link E1Stmt#getOp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value E1Stmt.getOp()"})
  public void testE1StmtGetOp() {
    // Arrange, Act and Assert
    assertNull((new TableSwitchStmt()).getOp());
  }

  /**
   * Test E1Stmt {@link E1Stmt#setOp(Value)}.
   *
   * <p>Method under test: {@link E1Stmt#setOp(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void E1Stmt.setOp(Value)"})
  public void testE1StmtSetOp() {
    // Arrange
    TableSwitchStmt tableSwitchStmt = new TableSwitchStmt();
    ArrayExpr op = new ArrayExpr();

    // Act
    tableSwitchStmt.setOp(op);

    // Assert
    assertSame(op, tableSwitchStmt.getOp());
  }

  /**
   * Test E2Stmt {@link E2Stmt#getOp1()}.
   *
   * <p>Method under test: {@link E2Stmt#getOp1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value E2Stmt.getOp1()"})
  public void testE2StmtGetOp1() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());

    // Act and Assert
    assertSame(nAssignResult.op1, nAssignResult.getOp1());
  }

  /**
   * Test E2Stmt {@link E2Stmt#getOp2()}.
   *
   * <p>Method under test: {@link E2Stmt#getOp2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value E2Stmt.getOp2()"})
  public void testE2StmtGetOp2() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());

    // Act and Assert
    assertSame(nAssignResult.op2, nAssignResult.getOp2());
  }

  /**
   * Test {@link Stmt#getNext()}.
   *
   * <p>Method under test: {@link Stmt#getNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt Stmt.getNext()"})
  public void testGetNext() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getNext());
  }

  /**
   * Test {@link Stmt#getOp()}.
   *
   * <p>Method under test: {@link Stmt#getOp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Stmt.getOp()"})
  public void testGetOp() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp());
  }

  /**
   * Test {@link Stmt#getOp1()}.
   *
   * <p>Method under test: {@link Stmt#getOp1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Stmt.getOp1()"})
  public void testGetOp1() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp1());
  }

  /**
   * Test {@link Stmt#getOp2()}.
   *
   * <p>Method under test: {@link Stmt#getOp2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Stmt.getOp2()"})
  public void testGetOp2() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp2());
  }

  /**
   * Test {@link Stmt#getOps()}.
   *
   * <p>Method under test: {@link Stmt#getOps()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value[] Stmt.getOps()"})
  public void testGetOps() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOps());
  }

  /**
   * Test {@link Stmt#getPre()}.
   *
   * <p>Method under test: {@link Stmt#getPre()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt Stmt.getPre()"})
  public void testGetPre() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getPre());
  }

  /**
   * Test ST {@link ST#canBranch()}.
   *
   * <ul>
   *   <li>Given {@code GOTO}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canBranch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canBranch()"})
  public void testSTCanBranch_givenGoto_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ST.GOTO.canBranch());
  }

  /**
   * Test ST {@link ST#canBranch()}.
   *
   * <ul>
   *   <li>Given {@code LOCAL_START}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canBranch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canBranch()"})
  public void testSTCanBranch_givenLocalStart_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ST.LOCAL_START.canBranch());
  }

  /**
   * Test ST {@link ST#canContinue()}.
   *
   * <ul>
   *   <li>Given {@code LOCAL_START}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canContinue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canContinue()"})
  public void testSTCanContinue_givenLocalStart_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ST.LOCAL_START.canContinue());
  }

  /**
   * Test ST {@link ST#canContinue()}.
   *
   * <ul>
   *   <li>Given {@code RETURN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canContinue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canContinue()"})
  public void testSTCanContinue_givenReturn_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ST.RETURN.canContinue());
  }

  /**
   * Test ST {@link ST#canSwitch()}.
   *
   * <ul>
   *   <li>Given {@code LOCAL_START}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canSwitch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canSwitch()"})
  public void testSTCanSwitch_givenLocalStart_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ST.LOCAL_START.canSwitch());
  }

  /**
   * Test ST {@link ST#canSwitch()}.
   *
   * <ul>
   *   <li>Given {@code LOOKUP_SWITCH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canSwitch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canSwitch()"})
  public void testSTCanSwitch_givenLookupSwitch_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ST.LOOKUP_SWITCH.canSwitch());
  }

  /**
   * Test ST {@link ST#canThrow()}.
   *
   * <ul>
   *   <li>Given {@code LOCAL_START}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canThrow()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canThrow()"})
  public void testSTCanThrow_givenLocalStart_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ST.LOCAL_START.canThrow());
  }

  /**
   * Test ST {@link ST#canThrow()}.
   *
   * <ul>
   *   <li>Given {@code LOCK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ST#canThrow()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.canThrow()"})
  public void testSTCanThrow_givenLock_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ST.LOCK.canThrow());
  }

  /**
   * Test ST {@link ST#mayThrow()}.
   *
   * <ul>
   *   <li>Given {@code ASSIGN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ST#mayThrow()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.mayThrow()"})
  public void testSTMayThrow_givenAssign_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ST.ASSIGN.mayThrow());
  }

  /**
   * Test ST {@link ST#mayThrow()}.
   *
   * <ul>
   *   <li>Given {@code LOCAL_START}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ST#mayThrow()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ST.mayThrow()"})
  public void testSTMayThrow_givenLocalStart_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ST.LOCAL_START.mayThrow());
  }
}
