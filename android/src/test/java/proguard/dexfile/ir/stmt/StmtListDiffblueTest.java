package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class StmtListDiffblueTest {
  /**
   * Method under test: {@link StmtList#addAll(Collection)}
   */
  @Test
  public void testAddAll() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayList<Stmt> list = new ArrayList<>();

    // Act
    stmtList.addAll(list);

    // Assert that nothing has changed
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertTrue(list.isEmpty());
  }

  /**
   * Method under test: {@link StmtList#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
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
   * Method under test: {@link StmtList#compare(Stmt, Stmt)}
   */
  @Test
  public void testCompare() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt o1 = Stmts.nLabel();

    // Act and Assert
    assertEquals(0, stmtList.compare(o1, Stmts.nLabel()));
  }

  /**
   * Method under test: {@link StmtList#contains(Stmt)}
   */
  @Test
  public void testContains() {
    // Arrange
    StmtList stmtList = new StmtList();

    // Act and Assert
    assertFalse(stmtList.contains(Stmts.nLabel()));
  }

  /**
   * Method under test: {@link StmtList#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new StmtList()).iterator().hasNext());
  }

  /**
   * Method under test: {@link StmtList#move(Stmt, Stmt, Stmt)}
   */
  @Test
  public void testMove() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    LabelStmt dist = Stmts.nLabel();

    // Act
    stmtList.move(start, end, dist);

    // Assert
    assertSame(dist, start.getPre());
    assertSame(end, stmtList.getLast());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StmtList}
   *   <li>{@link StmtList#getFirst()}
   *   <li>{@link StmtList#getLast()}
   *   <li>{@link StmtList#getSize()}
   * </ul>
   */
  @Test
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
