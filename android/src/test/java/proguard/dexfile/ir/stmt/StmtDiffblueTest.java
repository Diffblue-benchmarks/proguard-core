package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.Stmt.E1Stmt;
import proguard.dexfile.ir.stmt.Stmt.E2Stmt;
import proguard.dexfile.ir.stmt.Stmt.ST;

class StmtDiffblueTest {
  /**
   * Test E1Stmt {@link E1Stmt#getOp()}.
   *
   * <p>Method under test: {@link E1Stmt#getOp()}
   */
  @Test
  @DisplayName("Test E1Stmt getOp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.stmt.Stmt$E1Stmt.getOp()"})
  void testE1StmtGetOp() {
    // Arrange, Act and Assert
    assertNull((new TableSwitchStmt()).getOp());
  }

  /**
   * Test E1Stmt {@link E1Stmt#setOp(Value)}.
   *
   * <p>Method under test: {@link E1Stmt#setOp(Value)}
   */
  @Test
  @DisplayName("Test E1Stmt setOp(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.stmt.Stmt$E1Stmt.setOp(proguard.dexfile.ir.expr.Value)"
  })
  void testE1StmtSetOp() {
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
  @DisplayName("Test E2Stmt getOp1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.stmt.Stmt$E2Stmt.getOp1()"
  })
  void testE2StmtGetOp1() {
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
  @DisplayName("Test E2Stmt getOp2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.stmt.Stmt$E2Stmt.getOp2()"
  })
  void testE2StmtGetOp2() {
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
  @DisplayName("Test getNext()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.Stmt.getNext()"})
  void testGetNext() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getNext());
  }

  /**
   * Test {@link Stmt#getOp()}.
   *
   * <p>Method under test: {@link Stmt#getOp()}
   */
  @Test
  @DisplayName("Test getOp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.stmt.Stmt.getOp()"})
  void testGetOp() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp());
  }

  /**
   * Test {@link Stmt#getOp1()}.
   *
   * <p>Method under test: {@link Stmt#getOp1()}
   */
  @Test
  @DisplayName("Test getOp1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.stmt.Stmt.getOp1()"})
  void testGetOp1() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp1());
  }

  /**
   * Test {@link Stmt#getOp2()}.
   *
   * <p>Method under test: {@link Stmt#getOp2()}
   */
  @Test
  @DisplayName("Test getOp2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.stmt.Stmt.getOp2()"})
  void testGetOp2() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp2());
  }

  /**
   * Test {@link Stmt#getOps()}.
   *
   * <p>Method under test: {@link Stmt#getOps()}
   */
  @Test
  @DisplayName("Test getOps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.stmt.Stmt.getOps()"})
  void testGetOps() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOps());
  }

  /**
   * Test {@link Stmt#getPre()}.
   *
   * <p>Method under test: {@link Stmt#getPre()}
   */
  @Test
  @DisplayName("Test getPre()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.Stmt.getPre()"})
  void testGetPre() {
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
  @DisplayName("Test ST canBranch(); given 'GOTO'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canBranch()"})
  void testSTCanBranch_givenGoto_thenReturnTrue() {
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
  @DisplayName("Test ST canBranch(); given 'LOCAL_START'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canBranch()"})
  void testSTCanBranch_givenLocalStart_thenReturnFalse() {
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
  @DisplayName("Test ST canContinue(); given 'LOCAL_START'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canContinue()"})
  void testSTCanContinue_givenLocalStart_thenReturnTrue() {
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
  @DisplayName("Test ST canContinue(); given 'RETURN'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canContinue()"})
  void testSTCanContinue_givenReturn_thenReturnFalse() {
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
  @DisplayName("Test ST canSwitch(); given 'LOCAL_START'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canSwitch()"})
  void testSTCanSwitch_givenLocalStart_thenReturnFalse() {
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
  @DisplayName("Test ST canSwitch(); given 'LOOKUP_SWITCH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canSwitch()"})
  void testSTCanSwitch_givenLookupSwitch_thenReturnTrue() {
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
  @DisplayName("Test ST canThrow(); given 'LOCAL_START'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canThrow()"})
  void testSTCanThrow_givenLocalStart_thenReturnFalse() {
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
  @DisplayName("Test ST canThrow(); given 'LOCK'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.canThrow()"})
  void testSTCanThrow_givenLock_thenReturnTrue() {
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
  @DisplayName("Test ST mayThrow(); given 'ASSIGN'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.mayThrow()"})
  void testSTMayThrow_givenAssign_thenReturnTrue() {
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
  @DisplayName("Test ST mayThrow(); given 'LOCAL_START'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.stmt.Stmt$ST.mayThrow()"})
  void testSTMayThrow_givenLocalStart_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ST.LOCAL_START.mayThrow());
  }
}
