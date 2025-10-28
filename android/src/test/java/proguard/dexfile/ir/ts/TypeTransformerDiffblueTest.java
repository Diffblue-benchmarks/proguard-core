package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import proguard.dexfile.ir.ET;
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
import proguard.dexfile.ir.stmt.NopStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class TypeTransformerDiffblueTest {
  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();
    IrMethod irMethod = new IrMethod();

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertNull(irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform2() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    assertTrue(first instanceof LabelStmt);
    assertSame(stmt, first);
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform3() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    stmtList.add(Stmts.nLabel());
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    assertTrue(first instanceof LabelStmt);
    assertSame(stmt, first);
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform4() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    NopStmt stmt = Stmts.nNop();
    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    assertTrue(first instanceof NopStmt);
    assertSame(stmt, first);
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform5() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Local condition = new Local();
    IfStmt stmt = new IfStmt(Stmt.ST.LOCAL_START, condition, Stmts.nLabel());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform6() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant condition = Exprs.nNull();
    IfStmt stmt = new IfStmt(Stmt.ST.LOCAL_START, condition, Stmts.nLabel());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform7() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Local key = new Local();
    LookupSwitchStmt stmt = new LookupSwitchStmt(key, new int[]{42, 1, 42, 1}, new LabelStmt[]{Stmts.nLabel()},
        Stmts.nLabel());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform8() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant condition = Exprs.nByte((byte) 'A');
    IfStmt stmt = new IfStmt(Stmt.ST.LOCAL_START, condition, Stmts.nLabel());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform9() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant condition = Exprs.nChar('\u0001');
    IfStmt stmt = new IfStmt(Stmt.ST.LOCAL_START, condition, Stmts.nLabel());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer#transform(IrMethod)}
   */
  @Test
  public void testTransform10() {
    // Arrange
    TypeTransformer typeTransformer = new TypeTransformer();

    StmtList stmtList = new StmtList();
    Constant key = Exprs.nByte((byte) 'A');
    LookupSwitchStmt stmt = new LookupSwitchStmt(key, new int[]{42, 1, 42, 1}, new LabelStmt[]{Stmts.nLabel()},
        Stmts.nLabel());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    typeTransformer.transform(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#addAllUses(Set)}
   */
  @Test
  public void testTypeRefAddAllUses() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    HashSet<String> resultUses = new HashSet<>();

    // Act and Assert
    assertFalse(typeRef.addAllUses(resultUses));
    assertTrue(resultUses.isEmpty());
    assertTrue(typeRef.uses.isEmpty());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#addAllUses(Set)}
   */
  @Test
  public void testTypeRefAddAllUses2() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.addUses("Ele");
    HashSet<String> resultUses = new HashSet<>();

    // Act and Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertFalse(typeRef.addAllUses(resultUses));
    assertTrue(resultUses.isEmpty());
    assertTrue(stringSet.contains("Ele"));
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#addAllUses(Set)}
   */
  @Test
  public void testTypeRefAddAllUses3() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());

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
   * Method under test: {@link TypeTransformer.TypeRef#addAllUses(Set)}
   */
  @Test
  public void testTypeRefAddAllUses4() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());

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
    assertEquals(typeRef.uses, resultUses);
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#addUses(String)}
   */
  @Test
  public void testTypeRefAddUses() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());

    // Act
    boolean actualAddUsesResult = typeRef.addUses("Ele");

    // Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("Ele"));
    assertTrue(actualAddUsesResult);
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#addUses(String)}
   */
  @Test
  public void testTypeRefAddUses2() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.addUses("Ele");

    // Act and Assert
    Set<String> stringSet = typeRef.uses;
    assertEquals(1, stringSet.size());
    assertFalse(typeRef.addUses("Ele"));
    assertTrue(stringSet.contains("Ele"));
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getProvideDesc()}
   */
  @Test
  public void testTypeRefGetProvideDesc() {
    // Arrange, Act and Assert
    assertNull((new TypeTransformer.TypeRef(new ArrayExpr())).getProvideDesc());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TypeTransformer.TypeRef(new ArrayExpr())).getType());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType2() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.addUses("Ele");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> typeRef.getType());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType3() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.BOOLEAN);
    typeRef.addUses("Ele");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> typeRef.getType());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType4() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.INT);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("I", typeRef.getType());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType5() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.addUses("I");
    typeRef.updateTypeClass(TypeClass.INT);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("I", typeRef.getType());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType6() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.ZIL);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("Z", typeRef.getType());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#getType()}
   */
  @Test
  public void testTypeRefGetType7() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.updateTypeClass(TypeClass.JD);
    typeRef.addUses("Ele");

    // Act and Assert
    assertEquals("J", typeRef.getType());
  }

  /**
   * Method under test:
   * {@link TypeTransformer.TypeRef#merge(TypeTransformer.TypeRef)}
   */
  @Test
  public void testTypeRefMerge() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    TypeTransformer.TypeRef other = new TypeTransformer.TypeRef(new ArrayExpr());

    // Act
    typeRef.merge(other);

    // Assert
    assertNull(other.uses);
  }

  /**
   * Method under test:
   * {@link TypeTransformer.TypeRef#merge(TypeTransformer.TypeRef)}
   */
  @Test
  public void testTypeRefMerge2() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());

    TypeTransformer.TypeRef other = new TypeTransformer.TypeRef(new ArrayExpr());
    other.addUses("Ele");

    // Act
    typeRef.merge(other);

    // Assert
    assertNull(other.uses);
  }

  /**
   * Method under test:
   * {@link TypeTransformer.TypeRef#merge(TypeTransformer.TypeRef)}
   */
  @Test
  public void testTypeRefMerge3() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.addUses("42");

    TypeTransformer.TypeRef other = new TypeTransformer.TypeRef(new ArrayExpr());
    other.addUses("Ele");

    // Act
    typeRef.merge(other);

    // Assert
    assertNull(other.uses);
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#TypeRef(Value)}
   */
  @Test
  public void testTypeRefNewTypeRef() {
    // Arrange and Act
    TypeTransformer.TypeRef actualTypeRef = new TypeTransformer.TypeRef(new ArrayExpr());

    // Assert
    Value value = actualTypeRef.value;
    assertTrue(value instanceof ArrayExpr);
    assertEquals("null[null]", ((ArrayExpr) value).toString0());
    assertNull(value.getOps());
    assertNull(((ArrayExpr) value).tag);
    assertNull(actualTypeRef.getProvideDesc());
    assertNull(((ArrayExpr) value).elementType);
    assertNull(((ArrayExpr) value).valueType);
    assertNull(actualTypeRef.provideDesc);
    assertNull(actualTypeRef.uses);
    assertNull(actualTypeRef.arrayRoots);
    assertNull(actualTypeRef.children);
    assertNull(actualTypeRef.gArrayValues);
    assertNull(actualTypeRef.parents);
    assertNull(actualTypeRef.sArrayValues);
    assertNull(actualTypeRef.sameValues);
    assertNull(value.getOp());
    assertNull(value.getOp1());
    assertNull(value.getOp2());
    assertEquals(ET.E2, ((ArrayExpr) value).et);
    assertEquals(TypeClass.UNKNOWN, actualTypeRef.clz);
    assertEquals(Value.VT.ARRAY, ((ArrayExpr) value).vt);
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#toString()}
   */
  @Test
  public void testTypeRefToString() {
    // Arrange, Act and Assert
    assertEquals("?::null[null]: null > {}", (new TypeTransformer.TypeRef(new ArrayExpr())).toString());
    assertEquals("?::null: null > {}", (new TypeTransformer.TypeRef(null)).toString());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#toString()}
   */
  @Test
  public void testTypeRefToString2() {
    // Arrange
    ArrayExpr value = new ArrayExpr();
    value.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("?::null[null][null]: null > {}", (new TypeTransformer.TypeRef(value)).toString());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#toString()}
   */
  @Test
  public void testTypeRefToString3() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("?::null[null][null[null]]: null > {}",
        (new TypeTransformer.TypeRef(new ArrayExpr(base, new ArrayExpr(), "[]"))).toString());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#toString()}
   */
  @Test
  public void testTypeRefToString4() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());
    typeRef.addUses("[]");

    // Act and Assert
    assertEquals("?::null[null]: null > {[]}", typeRef.toString());
  }

  /**
   * Method under test: {@link TypeTransformer.TypeRef#updateTypeClass(TypeClass)}
   */
  @Test
  public void testTypeRefUpdateTypeClass() {
    // Arrange
    TypeTransformer.TypeRef typeRef = new TypeTransformer.TypeRef(new ArrayExpr());

    // Act and Assert
    assertEquals(TypeClass.UNKNOWN, typeRef.clz);
    assertFalse(typeRef.updateTypeClass(TypeClass.UNKNOWN));
  }
}
