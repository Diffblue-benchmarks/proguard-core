package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.Stmt.ST;

class LabelStmtDiffblueTest {
  /**
   * Test new {@link LabelStmt} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LabelStmt}
   */
  @Test
  @DisplayName("Test new LabelStmt (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LabelStmt.<init>()"})
  void testNewLabelStmt() {
    // Arrange and Act
    LabelStmt actualLabelStmt = new LabelStmt();

    // Assert
    assertNull(actualLabelStmt.tag);
    assertNull(actualLabelStmt.frame);
    assertNull(actualLabelStmt.displayName);
    assertNull(actualLabelStmt.phis);
    assertNull(actualLabelStmt.exceptionHandlers);
    assertNull(actualLabelStmt._cfg_froms);
    assertNull(actualLabelStmt.getOp());
    assertNull(actualLabelStmt.getOp1());
    assertNull(actualLabelStmt.getOp2());
    assertNull(actualLabelStmt.getOps());
    assertNull(actualLabelStmt.getNext());
    assertNull(actualLabelStmt.getPre());
    assertNull(actualLabelStmt._ts_default_next);
    assertNull(actualLabelStmt.list);
    assertEquals(-1, actualLabelStmt.lineNumber);
    assertEquals(0, actualLabelStmt.id);
    assertEquals(ET.E0, actualLabelStmt.et);
    assertEquals(ST.LABEL, actualLabelStmt.st);
    assertFalse(actualLabelStmt.visited);
  }

  /**
   * Test {@link LabelStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>When {@link LabelAndLocalMapper} (default constructor).
   *   <li>Then return {@link LabelStmt#tag} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; when LabelAndLocalMapper (default constructor); then return tag is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LabelStmt LabelStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_whenLabelAndLocalMapper_thenReturnTagIsNull() {
    // Arrange
    LabelStmt nLabelResult = Stmts.nLabel();

    // Act
    LabelStmt actualCloneResult = nLabelResult.clone(new LabelAndLocalMapper());

    // Assert
    assertNull(actualCloneResult.tag);
    assertNull(actualCloneResult.frame);
    assertNull(actualCloneResult.displayName);
    assertNull(actualCloneResult.phis);
    assertNull(actualCloneResult.exceptionHandlers);
    assertNull(actualCloneResult._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(actualCloneResult._ts_default_next);
    assertNull(actualCloneResult.list);
    assertEquals(-1, actualCloneResult.lineNumber);
    assertEquals(0, actualCloneResult.id);
    assertEquals(ET.E0, actualCloneResult.et);
    assertEquals(ST.LABEL, actualCloneResult.st);
    assertFalse(actualCloneResult.visited);
  }

  /**
   * Test {@link LabelStmt#getDisplayName()}.
   *
   * <ul>
   *   <li>Given nLabel {@link LabelStmt#displayName} is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given nLabel displayName is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.getDisplayName()"})
  void testGetDisplayName_givenNLabelDisplayNameIsFoo_thenReturnFoo() {
    // Arrange
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo", nLabelResult.getDisplayName());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code foo: // [null[null][null] = null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ArrayExpr() Op1 is ArrayExpr(); then return 'foo: // [null[null][null] = null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_givenArrayExprOp1IsArrayExpr_thenReturnFooNullNullNullNullNullLine0() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    left.setOp1(new ArrayExpr());
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());

    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    assignStmtList.add(nAssignResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null][null] = null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code foo: // [null] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ArrayList() add 'null'; then return 'foo: // [null] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_givenArrayListAddNull_thenReturnFooNullLine0() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    assignStmtList.add(null);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Given nLabel {@link LabelStmt#phis} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code foo: // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nLabel phis is ArrayList(); then return 'foo: // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_givenNLabelPhisIsArrayList_thenReturnFooLine0() {
    // Arrange
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = new ArrayList<>();
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [a0 = null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [a0 = null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooA0NullNullLine0() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    Local left = new Local();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());
    assignStmtList.add(nAssignResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [a0 = null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null = null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null = null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullLine0() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    AssignStmt nAssignResult = Stmts.nAssign(null, new ArrayExpr());
    assignStmtList.add(nAssignResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null = null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] = null] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null[null] = null] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullLine02() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    assignStmtList.add(Stmts.nAssign(new ArrayExpr(), null));
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null] = null] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null <- null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null <- null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullLine03() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    AssignStmt nFillArrayDataResult = Stmts.nFillArrayData(null, new ArrayExpr());
    assignStmtList.add(nFillArrayDataResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null <- null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] <- null] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null[null] <- null] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullLine04() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    assignStmtList.add(Stmts.nFillArrayData(new ArrayExpr(), null));
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null] <- null] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null := null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null := null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullLine05() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    AssignStmt nIdentityResult = Stmts.nIdentity(null, new ArrayExpr());
    assignStmtList.add(nIdentityResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null := null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] := null] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null[null] := null] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullLine06() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    assignStmtList.add(Stmts.nIdentity(new ArrayExpr(), null));
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null] := null] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] = null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null[null] = null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullNullLine0() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    ArrayExpr left = new ArrayExpr();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());
    assignStmtList.add(nAssignResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null] = null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] <- null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null[null] <- null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullNullLine02() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    ArrayExpr left = new ArrayExpr();
    AssignStmt nFillArrayDataResult = Stmts.nFillArrayData(left, new ArrayExpr());
    assignStmtList.add(nFillArrayDataResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null] <- null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] := null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'foo: // [null[null] := null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullNullLine03() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    ArrayExpr local = new ArrayExpr();
    AssignStmt nIdentityResult = Stmts.nIdentity(local, new ArrayExpr());
    assignStmtList.add(nIdentityResult);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // [null[null] := null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null][null[null]] = null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'foo: // [null[null][null[null]] = null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullNullNullNullLine0() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    ArrayExpr base = new ArrayExpr();
    ArrayExpr left = new ArrayExpr(base, new ArrayExpr(), ":");
    assignStmtList.add(Stmts.nAssign(left, new ArrayExpr()));
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals(
        "foo: // [null[null][null[null]] = null[null]] // line 0", nLabelResult.toString());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code foo: // [null[null] = null[null], null[null] = null[null]] // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'foo: // [null[null] = null[null], null[null] = null[null]] // line 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LabelStmt.toString()"})
  void testToString_thenReturnFooNullNullNullNullNullNullNullNullLine0() {
    // Arrange
    ArrayList<AssignStmt> assignStmtList = new ArrayList<>();
    ArrayExpr left = new ArrayExpr();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());
    assignStmtList.add(nAssignResult);
    ArrayExpr left2 = new ArrayExpr();
    AssignStmt nAssignResult2 = Stmts.nAssign(left2, new ArrayExpr());
    assignStmtList.add(nAssignResult2);
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = assignStmtList;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals(
        "foo: // [null[null] = null[null], null[null] = null[null]] // line 0",
        nLabelResult.toString());
  }
}
