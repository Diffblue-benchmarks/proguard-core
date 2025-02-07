package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.stmt.Stmt.ST;

class StmtListDiffblueTest {
  /**
   * Test {@link StmtList#addAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StmtList} (default constructor) Size is zero.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); when ArrayList(); then StmtList (default constructor) Size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.stmt.StmtList.addAll(java.util.Collection)"})
  void testAddAll_whenArrayList_thenStmtListSizeIsZero() {
    // Arrange
    StmtList stmtList = new StmtList();

    // Act
    stmtList.addAll(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
  }

  /**
   * Test {@link StmtList#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor).
   *   <li>Then return First is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; given StmtList (default constructor); then return First is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.StmtList proguard.dexfile.ir.stmt.StmtList.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_givenStmtList_thenReturnFirstIsNull() {
    // Arrange
    StmtList stmtList = new StmtList();

    // Act
    StmtList actualCloneResult = stmtList.clone(new LabelAndLocalMapper());

    // Assert
    assertNull(actualCloneResult.getFirst());
    assertNull(actualCloneResult.getLast());
    assertEquals(0, actualCloneResult.getSize());
    assertFalse(actualCloneResult.iterator().hasNext());
  }

  /**
   * Test {@link StmtList#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then First return {@link GotoStmt}.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then First return GotoStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.StmtList proguard.dexfile.ir.stmt.StmtList.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenFirstReturnGotoStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nGoto(Stmts.nLabel()));

    // Act and Assert
    Stmt first = stmtList.clone(new LabelAndLocalMapper()).getFirst();
    assertTrue(first instanceof GotoStmt);
    assertEquals(ST.GOTO, ((GotoStmt) first).st);
  }

  /**
   * Test {@link StmtList#compare(Stmt, Stmt)} with {@code Stmt}, {@code Stmt}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#compare(Stmt, Stmt)}
   */
  @Test
  @DisplayName("Test compare(Stmt, Stmt) with 'Stmt', 'Stmt'; when nLabel; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.ir.stmt.StmtList.compare(proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt)"
  })
  void testCompareWithStmtStmt_whenNLabel_thenReturnZero() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt o1 = Stmts.nLabel();

    // Act and Assert
    assertEquals(0, stmtList.compare(o1, Stmts.nLabel()));
  }

  /**
   * Test {@link StmtList#contains(Stmt)}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#contains(Stmt)}
   */
  @Test
  @DisplayName("Test contains(Stmt); when nLabel; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.ir.stmt.StmtList.contains(proguard.dexfile.ir.stmt.Stmt)"
  })
  void testContains_whenNLabel_thenReturnFalse() {
    // Arrange
    StmtList stmtList = new StmtList();

    // Act and Assert
    assertFalse(stmtList.contains(Stmts.nLabel()));
  }

  /**
   * Test {@link StmtList#iterator()}.
   *
   * <p>Method under test: {@link StmtList#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator proguard.dexfile.ir.stmt.StmtList.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new StmtList()).iterator().hasNext());
  }

  /**
   * Test {@link StmtList#toString()}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor).
   *   <li>Then return {@code [Empty]}.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#toString()}
   */
  @Test
  @DisplayName("Test toString(); given StmtList (default constructor); then return '[Empty]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.StmtList.toString()"})
  void testToString_givenStmtList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("[Empty]", (new StmtList()).toString());
  }

  /**
   * Test {@link StmtList#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null] = null[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.StmtList.toString()"})
  void testToString_thenReturnNullNullNullNull() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(Stmts.nAssign(left, new ArrayExpr()));

    // Act and Assert
    assertEquals("null[null] = null[null]\n", stmtList.toString());
  }

  /**
   * Test {@link StmtList#move(Stmt, Stmt, Stmt)}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then nLabel Pre {@link LabelStmt}.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#move(Stmt, Stmt, Stmt)}
   */
  @Test
  @DisplayName("Test move(Stmt, Stmt, Stmt); when nLabel; then nLabel Pre LabelStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.stmt.StmtList.move(proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt)"
  })
  void testMove_whenNLabel_thenNLabelPreLabelStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    LabelStmt dist = Stmts.nLabel();

    // Act
    stmtList.move(start, end, dist);

    // Assert
    Stmt pre = start.getPre();
    assertTrue(pre instanceof LabelStmt);
    Stmt last = stmtList.getLast();
    assertTrue(last instanceof LabelStmt);
    assertSame(dist, pre);
    assertSame(end, last);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StmtList}
   *   <li>{@link StmtList#getFirst()}
   *   <li>{@link StmtList#getLast()}
   *   <li>{@link StmtList#getSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.stmt.StmtList.<init>()",
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.StmtList.getFirst()",
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.StmtList.getLast()",
    "int proguard.dexfile.ir.stmt.StmtList.getSize()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    StmtList actualStmtList = new StmtList();
    Stmt actualFirst = actualStmtList.getFirst();
    Stmt actualLast = actualStmtList.getLast();

    // Assert
    assertNull(actualFirst);
    assertNull(actualLast);
    assertEquals(0, actualStmtList.getSize());
  }
}
