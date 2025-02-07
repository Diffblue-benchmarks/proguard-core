package proguard.dexfile.ir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmts;

class TrapDiffblueTest {
  /**
   * Test {@link Trap#Trap()}.
   *
   * <ul>
   *   <li>Then return {@link Trap#types} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Trap#Trap()}
   */
  @Test
  @DisplayName("Test new Trap(); then return types is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.Trap.<init>()",
    "void proguard.dexfile.ir.Trap.<init>(proguard.dexfile.ir.stmt.LabelStmt, proguard.dexfile.ir.stmt.LabelStmt, proguard.dexfile.ir.stmt.LabelStmt[], java.lang.String[])"
  })
  void testNewTrap_thenReturnTypesIsNull() {
    // Arrange and Act
    Trap actualTrap = new Trap();

    // Assert
    assertNull(actualTrap.types);
    assertNull(actualTrap.handlers);
    assertNull(actualTrap.end);
    assertNull(actualTrap.start);
  }

  /**
   * Test {@link Trap#Trap(LabelStmt, LabelStmt, LabelStmt[], String[])}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@link Trap#end} Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Trap#Trap(LabelStmt, LabelStmt, LabelStmt[], String[])}
   */
  @Test
  @DisplayName(
      "Test new Trap(LabelStmt, LabelStmt, LabelStmt[], String[]); when nLabel; then return end Ops is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.Trap.<init>()",
    "void proguard.dexfile.ir.Trap.<init>(proguard.dexfile.ir.stmt.LabelStmt, proguard.dexfile.ir.stmt.LabelStmt, proguard.dexfile.ir.stmt.LabelStmt[], java.lang.String[])"
  })
  void testNewTrap_whenNLabel_thenReturnEndOpsIsNull() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();

    // Act
    Trap actualTrap =
        new Trap(start, end, new LabelStmt[] {Stmts.nLabel()}, new String[] {"Types"});

    // Assert
    LabelStmt labelStmt = actualTrap.end;
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualTrap.start;
    assertNull(labelStmt2.getOps());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
  }

  /**
   * Test {@link Trap#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link Trap#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.Trap proguard.dexfile.ir.Trap.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenReturnArrayLengthIsOne() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    Trap trap = new Trap(start, end, new LabelStmt[] {Stmts.nLabel()}, new String[] {"Types"});
    LabelAndLocalMapper mapper = new LabelAndLocalMapper();

    // Act
    Trap actualCloneResult = trap.clone(mapper);

    // Assert
    assertEquals(1, actualCloneResult.handlers.length);
    assertEquals(1, actualCloneResult.types.length);
    assertEquals(3, mapper.labels.size());
  }

  /**
   * Test {@link Trap#toString()}.
   *
   * <p>Method under test: {@link Trap#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.Trap.toString()"})
  void testToString() {
    // Arrange
    LabelStmt start = mock(LabelStmt.class);
    when(start.getDisplayName()).thenReturn("Display Name");
    LabelStmt end = Stmts.nLabel();

    // Act
    (new Trap(start, end, new LabelStmt[] {Stmts.nLabel()}, new String[] {".catch %s - %s : "}))
        .toString();

    // Assert
    verify(start).getDisplayName();
  }

  /**
   * Test {@link Trap#toString()}.
   *
   * <p>Method under test: {@link Trap#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.Trap.toString()"})
  void testToString2() {
    // Arrange
    LabelStmt start = mock(LabelStmt.class);
    when(start.getDisplayName()).thenReturn("Display Name");
    LabelStmt end = mock(LabelStmt.class);
    when(end.getDisplayName()).thenReturn("Display Name");

    // Act
    (new Trap(start, end, new LabelStmt[] {Stmts.nLabel()}, new String[] {".catch %s - %s : "}))
        .toString();

    // Assert
    verify(start).getDisplayName();
    verify(end).getDisplayName();
  }

  /**
   * Test {@link Trap#toString()}.
   *
   * <ul>
   *   <li>Then return {@code .catch Display Name - Display Name : all > Display Name,}.
   * </ul>
   *
   * <p>Method under test: {@link Trap#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return '.catch Display Name - Display Name : all > Display Name,'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.Trap.toString()"})
  void testToString_thenReturnCatchDisplayNameDisplayNameAllDisplayName() {
    // Arrange
    LabelStmt start = mock(LabelStmt.class);
    when(start.getDisplayName()).thenReturn("Display Name");
    LabelStmt end = mock(LabelStmt.class);
    when(end.getDisplayName()).thenReturn("Display Name");
    LabelStmt labelStmt = mock(LabelStmt.class);
    when(labelStmt.getDisplayName()).thenReturn("Display Name");

    // Act
    String actualToStringResult =
        (new Trap(start, end, new LabelStmt[] {labelStmt}, new String[] {null})).toString();

    // Assert
    verify(start).getDisplayName();
    verify(end).getDisplayName();
    verify(labelStmt).getDisplayName();
    assertEquals(".catch Display Name - Display Name : all > Display Name,", actualToStringResult);
  }

  /**
   * Test {@link Trap#toString()}.
   *
   * <ul>
   *   <li>Then return {@code .catch Display Name - Display Name : .catch %s - %s : > Display
   *       Name,}.
   * </ul>
   *
   * <p>Method under test: {@link Trap#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return '.catch Display Name - Display Name : .catch %s - %s : > Display Name,'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.Trap.toString()"})
  void testToString_thenReturnCatchDisplayNameDisplayNameCatchSSDisplayName() {
    // Arrange
    LabelStmt start = mock(LabelStmt.class);
    when(start.getDisplayName()).thenReturn("Display Name");
    LabelStmt end = mock(LabelStmt.class);
    when(end.getDisplayName()).thenReturn("Display Name");
    LabelStmt labelStmt = mock(LabelStmt.class);
    when(labelStmt.getDisplayName()).thenReturn("Display Name");

    // Act
    String actualToStringResult =
        (new Trap(start, end, new LabelStmt[] {labelStmt}, new String[] {".catch %s - %s : "}))
            .toString();

    // Assert
    verify(start).getDisplayName();
    verify(end).getDisplayName();
    verify(labelStmt).getDisplayName();
    assertEquals(
        ".catch Display Name - Display Name : .catch %s - %s :  > Display Name,",
        actualToStringResult);
  }
}
