package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class IrMethodDiffblueTest {
  /**
   * Test {@link IrMethod#clone()}.
   *
   * <ul>
   *   <li>Given {@link IrMethod} (default constructor).
   *   <li>Then return {@link IrMethod#args} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IrMethod IrMethod.clone()"})
  public void testClone_givenIrMethod_thenReturnArgsIsNull() {
    // Arrange and Act
    IrMethod actualCloneResult = (new IrMethod()).clone();

    // Assert
    assertNull(actualCloneResult.args);
    assertNull(actualCloneResult.name);
    assertNull(actualCloneResult.owner);
    assertNull(actualCloneResult.ret);
    assertNull(actualCloneResult.phiLabels);
    StmtList stmtList = actualCloneResult.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertFalse(actualCloneResult.isStatic);
    assertTrue(actualCloneResult.locals.isEmpty());
    assertTrue(actualCloneResult.traps.isEmpty());
    assertTrue(actualCloneResult.vars.isEmpty());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Given {@link IrMethod} (default constructor) {@link IrMethod#isStatic} is {@code true}.
   *   <li>Then return {@code // null static null null() { [Empty] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_givenIrMethodIsStaticIsTrue_thenReturnNullStaticNullNullEmpty() {
    // Arrange
    IrMethod irMethod = new IrMethod();
    irMethod.isStatic = true;

    // Act and Assert
    assertEquals("// null\n static null null() {\n\n[Empty]\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Given {@link IrMethod} (default constructor) {@link IrMethod#ret} is empty string.
   *   <li>Then return {@code // null null() { [Empty] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_givenIrMethodRetIsEmptyString_thenReturnNullNullEmpty() {
    // Arrange
    IrMethod irMethod = new IrMethod();
    irMethod.ret = "";

    // Act and Assert
    assertEquals("// null\n null() {\n\n[Empty]\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Given {@link IrMethod} (default constructor) {@link IrMethod#stmts} is {@code null}.
   *   <li>Then return {@code // null null null() { null }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_givenIrMethodStmtsIsNull_thenReturnNullNullNullNull() {
    // Arrange
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = null;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Given {@link IrMethod} (default constructor).
   *   <li>Then return {@code // null null null() { [Empty] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_givenIrMethod_thenReturnNullNullNullEmpty() {
    // Arrange, Act and Assert
    assertEquals("// null\nnull null() {\n\n[Empty]\n}", (new IrMethod()).toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nNop.
   *   <li>Then return {@code // null null null() { NOP }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_givenStmtListAddNNop_thenReturnNullNullNullNop() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nNop());
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nNOP\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { a0 = null[null] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullA0NullNull() {
    // Arrange
    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(Stmts.nAssign(left, new ArrayExpr()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\na0 = null[null]\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { a0 <- null[null] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullA0NullNull2() {
    // Arrange
    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(Stmts.nFillArrayData(left, new ArrayExpr()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\na0 <- null[null]\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { a0 := null[null] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullA0NullNull3() {
    // Arrange
    StmtList stmtList = new StmtList();
    Local local = new Local();
    stmtList.add(Stmts.nIdentity(local, new ArrayExpr()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\na0 := null[null]\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { null[null] = a0 }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullNullNullA0() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(Stmts.nAssign(left, new Local()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull[null] = a0\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { null[null] <- a0 }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullNullNullA02() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(Stmts.nFillArrayData(left, new Local()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull[null] <- a0\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { null[null] := a0 }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullNullNullA03() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr local = new ArrayExpr();
    stmtList.add(Stmts.nIdentity(local, new Local()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull[null] := a0\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { null[null] = null[null] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullNullNullNullNull() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(Stmts.nAssign(left, new ArrayExpr()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull[null] = null[null]\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { null[null] <- null[null] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullNullNullNullNull2() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(Stmts.nFillArrayData(left, new ArrayExpr()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull[null] <- null[null]\n\n}", irMethod.toString());
  }

  /**
   * Test {@link IrMethod#toString()}.
   *
   * <ul>
   *   <li>Then return {@code // null null null() { null[null] := null[null] }}.
   * </ul>
   *
   * <p>Method under test: {@link IrMethod#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IrMethod.toString()"})
  public void testToString_thenReturnNullNullNullNullNullNullNull3() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr local = new ArrayExpr();
    stmtList.add(Stmts.nIdentity(local, new ArrayExpr()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act and Assert
    assertEquals("// null\nnull null() {\n\nnull[null] := null[null]\n\n}", irMethod.toString());
  }

  /**
   * Test new {@link IrMethod} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link IrMethod}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IrMethod.<init>()"})
  public void testNewIrMethod() {
    // Arrange and Act
    IrMethod actualIrMethod = new IrMethod();

    // Assert
    assertNull(actualIrMethod.args);
    assertNull(actualIrMethod.name);
    assertNull(actualIrMethod.owner);
    assertNull(actualIrMethod.ret);
    assertNull(actualIrMethod.phiLabels);
    StmtList stmtList = actualIrMethod.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertFalse(actualIrMethod.isStatic);
    assertTrue(actualIrMethod.locals.isEmpty());
    assertTrue(actualIrMethod.traps.isEmpty());
    assertTrue(actualIrMethod.vars.isEmpty());
  }
}
