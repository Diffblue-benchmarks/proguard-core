package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.stmt.Stmt.ST;

class StmtListDiffblueTest {
  /**
   * Test {@link StmtList#add(Stmt)}.
   *
   * <p>Method under test: {@link StmtList#add(Stmt)}
   */
  @Test
  @DisplayName("Test add(Stmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.add(Stmt)"})
  void testAdd() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    AssignStmt stmt = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());
    stmt.id = 1;

    // Act
    stmtList.add(stmt);

    // Assert
    assertEquals(1, stmt.id);
    StmtList stmtList2 = stmt.list;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
    Iterator<Stmt> iteratorResult = stmtList2.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(stmt, actualNextResult);
    assertSame(stmt, stmtList.getFirst());
    assertSame(stmt, stmtList.getLast());
    Iterator<Stmt> iteratorResult2 = stmtList.iterator();
    Stmt actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(stmt, actualNextResult2);
  }

  /**
   * Test {@link StmtList#add(Stmt)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor).
   *   <li>When nLabel.
   *   <li>Then nLabel {@link Stmt#id} is one.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#add(Stmt)}
   */
  @Test
  @DisplayName(
      "Test add(Stmt); given StmtList (default constructor); when nLabel; then nLabel id is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.add(Stmt)"})
  void testAdd_givenStmtList_whenNLabel_thenNLabelIdIsOne() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();

    // Act
    stmtList.add(stmt);

    // Assert
    assertEquals(1, stmt.id);
    StmtList stmtList2 = stmt.list;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
    assertEquals(1, stmtList2.getSize());
    Iterator<Stmt> iteratorResult = stmtList2.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(stmt, actualNextResult);
    assertNull(stmt.getPre());
    assertSame(stmt, stmtList.getFirst());
    assertSame(stmt, stmtList.getLast());
    assertEquals(1, stmtList.getSize());
    Iterator<Stmt> iteratorResult2 = stmtList.iterator();
    Stmt actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(stmt, actualNextResult2);
  }

  /**
   * Test {@link StmtList#addAll(Collection)}.
   *
   * <p>Method under test: {@link StmtList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.addAll(Collection)"})
  void testAddAll() {
    // Arrange
    StmtList stmtList = new StmtList();

    LinkedHashSet<Stmt> list = new LinkedHashSet<>();
    ArrayExpr left = new ArrayExpr();
    AssignStmt assignStmt = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());
    assignStmt.id = 0;
    list.add(assignStmt);

    // Act
    stmtList.addAll(list);

    // Assert
    Stmt first = stmtList.getFirst();
    assertSame(assignStmt, first);
    assertSame(first, stmtList.getLast());
    assertEquals(1, stmtList.getSize());
    Iterator<Stmt> iteratorResult = stmtList.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(assignStmt, actualNextResult);
  }

  /**
   * Test {@link StmtList#addAll(Collection)}.
   *
   * <p>Method under test: {@link StmtList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.addAll(Collection)"})
  void testAddAll2() {
    // Arrange
    StmtList stmtList = new StmtList();

    LinkedHashSet<Stmt> list = new LinkedHashSet<>();
    ArrayExpr left = new ArrayExpr();
    AssignStmt assignStmt = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());
    assignStmt.id = 1;
    list.add(assignStmt);

    // Act
    stmtList.addAll(list);

    // Assert
    Stmt first = stmtList.getFirst();
    assertSame(assignStmt, first);
    assertSame(first, stmtList.getLast());
    assertEquals(1, stmtList.getSize());
    Iterator<Stmt> iteratorResult = stmtList.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(assignStmt, actualNextResult);
  }

  /**
   * Test {@link StmtList#addAll(Collection)}.
   *
   * <ul>
   *   <li>Given nLabel.
   *   <li>When {@link ArrayList#ArrayList()} add nLabel.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); given nLabel; when ArrayList() add nLabel; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.addAll(Collection)"})
  void testAddAll_givenNLabel_whenArrayListAddNLabel_thenArrayListSizeIsTwo() {
    // Arrange
    StmtList stmtList = new StmtList();

    ArrayList<Stmt> list = new ArrayList<>();
    LabelStmt nLabelResult = Stmts.nLabel();
    list.add(nLabelResult);
    LabelStmt nLabelResult2 = Stmts.nLabel();
    list.add(nLabelResult2);

    // Act
    stmtList.addAll(list);

    // Assert
    StmtList stmtList2 = nLabelResult2.list;
    assertEquals(2, list.size());
    Stmt getResult = list.get(0);
    Stmt getResult2 = list.get(1);
    assertTrue(getResult instanceof LabelStmt);
    assertEquals(1, ((LabelStmt) getResult).id);
    assertSame(stmtList2, ((LabelStmt) getResult).list);
    assertSame(nLabelResult2, getResult.getNext());
    assertTrue(getResult2 instanceof LabelStmt);
    assertEquals(2, ((LabelStmt) getResult2).id);
    assertSame(stmtList2, ((LabelStmt) getResult2).list);
    assertSame(nLabelResult, getResult2.getPre());
    assertSame(nLabelResult, stmtList.getFirst());
    assertSame(nLabelResult2, stmtList.getLast());
    Iterator<Stmt> iteratorResult = stmtList.iterator();
    Stmt actualNextResult = iteratorResult.next();
    Stmt actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(nLabelResult, actualNextResult);
    assertSame(nLabelResult2, actualNextResult2);
  }

  /**
   * Test {@link StmtList#addAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link StmtList} (default constructor) Size is zero.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); given StmtList (default constructor); when ArrayList(); then StmtList (default constructor) Size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.addAll(Collection)"})
  void testAddAll_givenStmtList_whenArrayList_thenStmtListSizeIsZero() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StmtList StmtList.clone(LabelAndLocalMapper)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StmtList StmtList.clone(LabelAndLocalMapper)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int StmtList.compare(Stmt, Stmt)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StmtList.contains(Stmt)"})
  void testContains_whenNLabel_thenReturnFalse() {
    // Arrange
    StmtList stmtList = new StmtList();

    // Act and Assert
    assertFalse(stmtList.contains(Stmts.nLabel()));
  }

  /**
   * Test {@link StmtList#insertFirst(Stmt)}.
   *
   * <p>Method under test: {@link StmtList#insertFirst(Stmt)}
   */
  @Test
  @DisplayName("Test insertFirst(Stmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.insertFirst(Stmt)"})
  void testInsertFirst() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    AssignStmt stmt = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());
    stmt.id = 1;

    // Act
    stmtList.insertFirst(stmt);

    // Assert
    assertEquals(1, stmt.id);
    StmtList stmtList2 = stmt.list;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
    Iterator<Stmt> iteratorResult = stmtList2.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(stmt, actualNextResult);
    assertSame(stmt, stmtList.getFirst());
    assertSame(stmt, stmtList.getLast());
    Iterator<Stmt> iteratorResult2 = stmtList.iterator();
    Stmt actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(stmt, actualNextResult2);
  }

  /**
   * Test {@link StmtList#insertFirst(Stmt)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor).
   *   <li>When nLabel.
   *   <li>Then nLabel {@link Stmt#id} is one.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#insertFirst(Stmt)}
   */
  @Test
  @DisplayName(
      "Test insertFirst(Stmt); given StmtList (default constructor); when nLabel; then nLabel id is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.insertFirst(Stmt)"})
  void testInsertFirst_givenStmtList_whenNLabel_thenNLabelIdIsOne() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();

    // Act
    stmtList.insertFirst(stmt);

    // Assert
    assertEquals(1, stmt.id);
    StmtList stmtList2 = stmt.list;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
    assertEquals(1, stmtList2.getSize());
    Iterator<Stmt> iteratorResult = stmtList2.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(stmt, actualNextResult);
    assertNull(stmt.getNext());
    assertSame(stmt, stmtList.getFirst());
    assertSame(stmt, stmtList.getLast());
    assertEquals(1, stmtList.getSize());
    Iterator<Stmt> iteratorResult2 = stmtList.iterator();
    Stmt actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(stmt, actualNextResult2);
  }

  /**
   * Test {@link StmtList#insertLast(Stmt)}.
   *
   * <p>Method under test: {@link StmtList#insertLast(Stmt)}
   */
  @Test
  @DisplayName("Test insertLast(Stmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.insertLast(Stmt)"})
  void testInsertLast() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    AssignStmt stmt = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());
    stmt.id = 1;

    // Act
    stmtList.insertLast(stmt);

    // Assert
    assertEquals(1, stmt.id);
    StmtList stmtList2 = stmt.list;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
    Iterator<Stmt> iteratorResult = stmtList2.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(stmt, actualNextResult);
    assertSame(stmt, stmtList.getFirst());
    assertSame(stmt, stmtList.getLast());
    Iterator<Stmt> iteratorResult2 = stmtList.iterator();
    Stmt actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(stmt, actualNextResult2);
  }

  /**
   * Test {@link StmtList#insertLast(Stmt)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor).
   *   <li>When nLabel.
   *   <li>Then nLabel {@link Stmt#id} is one.
   * </ul>
   *
   * <p>Method under test: {@link StmtList#insertLast(Stmt)}
   */
  @Test
  @DisplayName(
      "Test insertLast(Stmt); given StmtList (default constructor); when nLabel; then nLabel id is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.insertLast(Stmt)"})
  void testInsertLast_givenStmtList_whenNLabel_thenNLabelIdIsOne() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();

    // Act
    stmtList.insertLast(stmt);

    // Assert
    assertEquals(1, stmt.id);
    StmtList stmtList2 = stmt.list;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
    assertEquals(1, stmtList2.getSize());
    Iterator<Stmt> iteratorResult = stmtList2.iterator();
    Stmt actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(stmt, actualNextResult);
    assertNull(stmt.getPre());
    assertSame(stmt, stmtList.getFirst());
    assertSame(stmt, stmtList.getLast());
    assertEquals(1, stmtList.getSize());
    Iterator<Stmt> iteratorResult2 = stmtList.iterator();
    Stmt actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(stmt, actualNextResult2);
  }

  /**
   * Test {@link StmtList#iterator()}.
   *
   * <p>Method under test: {@link StmtList#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator StmtList.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new StmtList().iterator().hasNext());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String StmtList.toString()"})
  void testToString_givenStmtList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("[Empty]", new StmtList().toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String StmtList.toString()"})
  void testToString_thenReturnNullNullNullNull() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    AssignStmt stmt = Stmts.nAssign(left, new ArrayExpr());
    stmtList.add(stmt);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StmtList.move(Stmt, Stmt, Stmt)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StmtList.<init>()",
    "Stmt StmtList.getFirst()",
    "Stmt StmtList.getLast()",
    "int StmtList.getSize()"
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
