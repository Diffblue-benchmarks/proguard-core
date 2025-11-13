package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.TypeClass;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.IfStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;
import proguard.dexfile.ir.ts.TypeTransformer.TypeRef;

class TypeTransformerDiffblueTest {
  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName("Test transform(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Local condition = new Local();
    stmtList.add(new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert that nothing has changed
    Stmt first = irMethod.stmts.getFirst();
    assertTrue(first.getOp() instanceof Local);
    assertTrue(first instanceof IfStmt);
  }

  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName("Test transform(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform2() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Local key = new Local();
    LabelStmt[] targets = new LabelStmt[] {Stmts.nLabel()};

    LookupSwitchStmt stmt =
        new LookupSwitchStmt(key, new int[] {42, 1, 42, 1}, targets, Stmts.nLabel());
    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    Value op = first.getOp();
    assertTrue(op instanceof Local);
    assertTrue(first instanceof LookupSwitchStmt);
    assertEquals("I", ((Local) op).valueType);
  }

  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName("Test transform(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform3() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant condition = Exprs.nByte((byte) 'A');
    stmtList.add(new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    Value op = first.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(first instanceof IfStmt);
    assertEquals("I", ((Constant) op).valueType);
  }

  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName("Test transform(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform4() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant condition = Exprs.nChar('\u0001');
    stmtList.add(new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    Value op = first.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(first instanceof IfStmt);
    assertEquals("I", ((Constant) op).valueType);
  }

  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName("Test transform(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform5() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant key = Exprs.nByte((byte) 'A');
    LabelStmt[] targets = new LabelStmt[] {Stmts.nLabel()};

    LookupSwitchStmt stmt =
        new LookupSwitchStmt(key, new int[] {42, 1, 42, 1}, targets, Stmts.nLabel());
    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    Value op = first.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(first instanceof LookupSwitchStmt);
    assertEquals("I", ((Constant) op).valueType);
  }

  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName("Test transform(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform6() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant key = Exprs.nChar('\u0001');
    LabelStmt[] targets = new LabelStmt[] {Stmts.nLabel()};

    LookupSwitchStmt stmt =
        new LookupSwitchStmt(key, new int[] {42, 1, 42, 1}, targets, Stmts.nLabel());
    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    Value op = first.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(first instanceof LookupSwitchStmt);
    assertEquals("I", ((Constant) op).valueType);
  }

  /**
   * Test {@link TypeTransformer#transform(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First Op {@link
   *       Value#valueType} is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transform(IrMethod); then IrMethod (default constructor) stmts First Op valueType is 'Ljava/lang/Object;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeTransformer.transform(IrMethod)"})
  void testTransform_thenIrMethodStmtsFirstOpValueTypeIsLjavaLangObject() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant condition = Exprs.nNull();
    stmtList.add(new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel()));
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    Value op = first.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(first instanceof IfStmt);
    assertEquals("Ljava/lang/Object;", ((Constant) op).valueType);
  }

  /**
   * Test TypeRef {@link TypeRef#addAllUses(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} {@link
   *       TypeRef#uses} size is two.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#addAllUses(Set)}
   */
  @Test
  @DisplayName(
      "Test TypeRef addAllUses(Set); given '42'; then TypeRef(Value) with value is ArrayExpr() uses size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.addAllUses(Set)"})
  void testTypeRefAddAllUses_given42_thenTypeRefWithValueIsArrayExprUsesSizeIsTwo() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());

    HashSet<String> resultUses = new HashSet<>();
    resultUses.add("42");
    resultUses.add("foo");

    // Act
    boolean actualAddAllUsesResult = typeRef.addAllUses(resultUses);

    // Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(2, stringSet.size());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualAddAllUsesResult);
  }

  /**
   * Test TypeRef {@link TypeRef#addAllUses(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#addAllUses(Set)}
   */
  @Test
  @DisplayName(
      "Test TypeRef addAllUses(Set); given 'foo'; when HashSet() add 'foo'; then HashSet() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.addAllUses(Set)"})
  void testTypeRefAddAllUses_givenFoo_whenHashSetAddFoo_thenHashSetSizeIsOne() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());

    HashSet<String> resultUses = new HashSet<>();
    resultUses.add("foo");

    // Act
    boolean actualAddAllUsesResult = typeRef.addAllUses(resultUses);

    // Assert
    assertEquals(1, resultUses.size());
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualAddAllUsesResult);
  }

  /**
   * Test TypeRef {@link TypeRef#addAllUses(Set)}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} addUses
   *       {@code Ele}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#addAllUses(Set)}
   */
  @Test
  @DisplayName(
      "Test TypeRef addAllUses(Set); given TypeRef(Value) with value is ArrayExpr() addUses 'Ele'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.addAllUses(Set)"})
  void testTypeRefAddAllUses_givenTypeRefWithValueIsArrayExprAddUsesEle_thenReturnFalse() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.addUses("Ele");
    HashSet<String> resultUses = new HashSet<>();

    // Act
    boolean actualAddAllUsesResult = typeRef.addAllUses(resultUses);

    // Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertFalse(actualAddAllUsesResult);
    assertTrue(resultUses.isEmpty());
    assertTrue(stringSet.contains("Ele"));
  }

  /**
   * Test TypeRef {@link TypeRef#addAllUses(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} {@link
   *       TypeRef#uses} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#addAllUses(Set)}
   */
  @Test
  @DisplayName(
      "Test TypeRef addAllUses(Set); when HashSet(); then TypeRef(Value) with value is ArrayExpr() uses Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.addAllUses(Set)"})
  void testTypeRefAddAllUses_whenHashSet_thenTypeRefWithValueIsArrayExprUsesEmpty() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    HashSet<String> resultUses = new HashSet<>();

    // Act
    typeRef.addAllUses(resultUses);

    // Assert
    assertTrue(resultUses.isEmpty());
    assertTrue(typeRef.uses.isEmpty());
  }

  /**
   * Test TypeRef {@link TypeRef#addUses(String)}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} addUses
   *       {@code Ele}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#addUses(String)}
   */
  @Test
  @DisplayName(
      "Test TypeRef addUses(String); given TypeRef(Value) with value is ArrayExpr() addUses 'Ele'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.addUses(String)"})
  void testTypeRefAddUses_givenTypeRefWithValueIsArrayExprAddUsesEle_thenReturnFalse() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.addUses("Ele");

    // Act
    boolean actualAddUsesResult = typeRef.addUses("Ele");

    // Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertFalse(actualAddUsesResult);
    assertTrue(stringSet.contains("Ele"));
  }

  /**
   * Test TypeRef {@link TypeRef#addUses(String)}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#addUses(String)}
   */
  @Test
  @DisplayName(
      "Test TypeRef addUses(String); given TypeRef(Value) with value is ArrayExpr(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.addUses(String)"})
  void testTypeRefAddUses_givenTypeRefWithValueIsArrayExpr_thenReturnTrue() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());

    // Act
    boolean actualAddUsesResult = typeRef.addUses("Ele");

    // Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("Ele"));
    assertTrue(actualAddUsesResult);
  }

  /**
   * Test TypeRef {@link TypeRef#getProvideDesc()}.
   *
   * <p>Method under test: {@link TypeRef#getProvideDesc()}
   */
  @Test
  @DisplayName("Test TypeRef getProvideDesc()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getProvideDesc()"})
  void testTypeRefGetProvideDesc() {
    // Arrange, Act and Assert
    assertNull(new TypeRef(new ArrayExpr()).getProvideDesc());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} addUses
   *       {@code I}.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName(
      "Test TypeRef getType(); given TypeRef(Value) with value is ArrayExpr() addUses 'I'; then return 'I'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_givenTypeRefWithValueIsArrayExprAddUsesI_thenReturnI() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.addUses("I");
    typeRef.updateTypeClass(TypeClass.INT);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("I", typeRef.getType());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()}
   *       updateTypeClass {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName(
      "Test TypeRef getType(); given TypeRef(Value) with value is ArrayExpr() updateTypeClass 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_givenTypeRefWithValueIsArrayExprUpdateTypeClassBoolean() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.BOOLEAN);
    typeRef.addUses("Ele");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> typeRef.getType());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()}
   *       updateTypeClass {@code JD}.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName(
      "Test TypeRef getType(); given TypeRef(Value) with value is ArrayExpr() updateTypeClass 'JD'; then return 'J'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_givenTypeRefWithValueIsArrayExprUpdateTypeClassJd_thenReturnJ() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.JD);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("J", typeRef.getType());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName(
      "Test TypeRef getType(); given TypeRef(Value) with value is ArrayExpr(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_givenTypeRefWithValueIsArrayExpr_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new TypeRef(new ArrayExpr()).getType());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName("Test TypeRef getType(); then return 'I'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_thenReturnI() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.INT);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("I", typeRef.getType());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Then return {@code Z}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName("Test TypeRef getType(); then return 'Z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_thenReturnZ() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.ZIL);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("Z", typeRef.getType());
  }

  /**
   * Test TypeRef {@link TypeRef#getType()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#getType()}
   */
  @Test
  @DisplayName("Test TypeRef getType(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.getType()"})
  void testTypeRefGetType_thenThrowRuntimeException() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.addUses("Ele");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> typeRef.getType());
  }

  /**
   * Test TypeRef {@link TypeRef#merge(TypeRef)}.
   *
   * <ul>
   *   <li>Given {@code Ele}.
   *   <li>When {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} addUses
   *       {@code Ele}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#merge(TypeRef)}
   */
  @Test
  @DisplayName(
      "Test TypeRef merge(TypeRef); given 'Ele'; when TypeRef(Value) with value is ArrayExpr() addUses 'Ele'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeRef.merge(TypeRef)"})
  void testTypeRefMerge_givenEle_whenTypeRefWithValueIsArrayExprAddUsesEle() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());

    TypeRef other = new TypeRef(new ArrayExpr());
    other.addUses("Ele");

    // Act
    typeRef.merge(other);

    // Assert
    assertNull(other.uses);
  }

  /**
   * Test TypeRef {@link TypeRef#merge(TypeRef)}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} addUses
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#merge(TypeRef)}
   */
  @Test
  @DisplayName(
      "Test TypeRef merge(TypeRef); given TypeRef(Value) with value is ArrayExpr() addUses '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeRef.merge(TypeRef)"})
  void testTypeRefMerge_givenTypeRefWithValueIsArrayExprAddUses42() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.addUses("42");

    TypeRef other = new TypeRef(new ArrayExpr());
    other.addUses("Ele");

    // Act
    typeRef.merge(other);

    // Assert
    assertNull(other.uses);
  }

  /**
   * Test TypeRef {@link TypeRef#merge(TypeRef)}.
   *
   * <ul>
   *   <li>When {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#merge(TypeRef)}
   */
  @Test
  @DisplayName("Test TypeRef merge(TypeRef); when TypeRef(Value) with value is ArrayExpr()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeRef.merge(TypeRef)"})
  void testTypeRefMerge_whenTypeRefWithValueIsArrayExpr() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    TypeRef other = new TypeRef(new ArrayExpr());

    // Act
    typeRef.merge(other);

    // Assert that nothing has changed
    assertNull(other.uses);
  }

  /**
   * Test TypeRef {@link TypeRef#TypeRef(Value)}.
   *
   * <p>Method under test: {@link TypeRef#TypeRef(Value)}
   */
  @Test
  @DisplayName("Test TypeRef new TypeRef(Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeRef.<init>(Value)"})
  void testTypeRefNewTypeRef() {
    // Arrange and Act
    TypeRef actualTypeRef = new TypeRef(new ArrayExpr());

    // Assert
    assertTrue(actualTypeRef.value instanceof ArrayExpr);
    assertNull(actualTypeRef.getProvideDesc());
    assertNull(actualTypeRef.provideDesc);
    assertNull(actualTypeRef.uses);
    assertNull(actualTypeRef.arrayRoots);
    assertNull(actualTypeRef.children);
    assertNull(actualTypeRef.gArrayValues);
    assertNull(actualTypeRef.parents);
    assertNull(actualTypeRef.sArrayValues);
    assertNull(actualTypeRef.sameValues);
    assertEquals(TypeClass.UNKNOWN, actualTypeRef.clz);
  }

  /**
   * Test TypeRef {@link TypeRef#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code ?::null[null][null]: null > {}}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#toString()}
   */
  @Test
  @DisplayName(
      "Test TypeRef toString(); given ArrayExpr() Op1 is ArrayExpr(); then return '?::null[null][null]: null > {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.toString()"})
  void testTypeRefToString_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr value = new ArrayExpr();
    value.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("?::null[null][null]: null > {}", new TypeRef(value).toString());
  }

  /**
   * Test TypeRef {@link TypeRef#toString()}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code ?::null[null]: null > {}}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#toString()}
   */
  @Test
  @DisplayName(
      "Test TypeRef toString(); given TypeRef(Value) with value is ArrayExpr(); then return '?::null[null]: null > {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.toString()"})
  void testTypeRefToString_givenTypeRefWithValueIsArrayExpr_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("?::null[null]: null > {}", new TypeRef(new ArrayExpr()).toString());
  }

  /**
   * Test TypeRef {@link TypeRef#toString()}.
   *
   * <ul>
   *   <li>Given {@link TypeRef#TypeRef(Value)} with value is {@code null}.
   *   <li>Then return {@code ?::null: null > {}}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#toString()}
   */
  @Test
  @DisplayName(
      "Test TypeRef toString(); given TypeRef(Value) with value is 'null'; then return '?::null: null > {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.toString()"})
  void testTypeRefToString_givenTypeRefWithValueIsNull_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("?::null: null > {}", new TypeRef(null).toString());
  }

  /**
   * Test TypeRef {@link TypeRef#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ?::null[null]: null > {[]}}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#toString()}
   */
  @Test
  @DisplayName("Test TypeRef toString(); then return '?::null[null]: null > {[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.toString()"})
  void testTypeRefToString_thenReturnNullNullNull() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());
    typeRef.addUses("[]");

    // Act and Assert
    assertEquals("?::null[null]: null > {[]}", typeRef.toString());
  }

  /**
   * Test TypeRef {@link TypeRef#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ?::null[null][null[null]]: null > {}}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#toString()}
   */
  @Test
  @DisplayName("Test TypeRef toString(); then return '?::null[null][null[null]]: null > {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeRef.toString()"})
  void testTypeRefToString_thenReturnNullNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr value = new ArrayExpr(base, new ArrayExpr(), "[]");

    // Act and Assert
    assertEquals("?::null[null][null[null]]: null > {}", new TypeRef(value).toString());
  }

  /**
   * Test TypeRef {@link TypeRef#updateTypeClass(TypeClass)}.
   *
   * <ul>
   *   <li>Then {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} {@link
   *       TypeRef#clz} is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#updateTypeClass(TypeClass)}
   */
  @Test
  @DisplayName(
      "Test TypeRef updateTypeClass(TypeClass); then TypeRef(Value) with value is ArrayExpr() clz is 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.updateTypeClass(TypeClass)"})
  void testTypeRefUpdateTypeClass_thenTypeRefWithValueIsArrayExprClzIsBoolean() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());

    // Act
    boolean actualUpdateTypeClassResult = typeRef.updateTypeClass(TypeClass.BOOLEAN);

    // Assert
    assertEquals(TypeClass.BOOLEAN, typeRef.clz);
    assertTrue(actualUpdateTypeClassResult);
  }

  /**
   * Test TypeRef {@link TypeRef#updateTypeClass(TypeClass)}.
   *
   * <ul>
   *   <li>Then {@link TypeRef#TypeRef(Value)} with value is {@link ArrayExpr#ArrayExpr()} {@link
   *       TypeRef#clz} is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link TypeRef#updateTypeClass(TypeClass)}
   */
  @Test
  @DisplayName(
      "Test TypeRef updateTypeClass(TypeClass); then TypeRef(Value) with value is ArrayExpr() clz is 'UNKNOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeRef.updateTypeClass(TypeClass)"})
  void testTypeRefUpdateTypeClass_thenTypeRefWithValueIsArrayExprClzIsUnknown() {
    // Arrange
    TypeRef typeRef = new TypeRef(new ArrayExpr());

    // Act
    boolean actualUpdateTypeClassResult = typeRef.updateTypeClass(TypeClass.UNKNOWN);

    // Assert
    assertEquals(TypeClass.UNKNOWN, typeRef.clz);
    assertFalse(actualUpdateTypeClassResult);
  }
}
