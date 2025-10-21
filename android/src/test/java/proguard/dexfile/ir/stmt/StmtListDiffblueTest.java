package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class StmtListDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StmtList.addAll(Collection)"})
  public void testAddAll_whenArrayList_thenStmtListSizeIsZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StmtList StmtList.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_givenStmtList_thenReturnFirstIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StmtList StmtList.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstReturnGotoStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StmtList.compare(Stmt, Stmt)"})
  public void testCompareWithStmtStmt_whenNLabel_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StmtList.contains(Stmt)"})
  public void testContains_whenNLabel_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Iterator StmtList.iterator()"})
  public void testIterator() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String StmtList.toString()"})
  public void testToString_givenStmtList_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String StmtList.toString()"})
  public void testToString_thenReturnNullNullNullNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StmtList.move(Stmt, Stmt, Stmt)"})
  public void testMove_whenNLabel_thenNLabelPreLabelStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StmtList.<init>()",
    "Stmt StmtList.getFirst()",
    "Stmt StmtList.getLast()",
    "int StmtList.getSize()"
  })
  public void testGettersAndSetters() {
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
