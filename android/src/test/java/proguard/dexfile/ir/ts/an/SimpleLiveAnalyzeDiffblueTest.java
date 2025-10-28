package proguard.dexfile.ir.ts.an;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.LocalVar;
import proguard.dexfile.ir.Trap;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class SimpleLiveAnalyzeDiffblueTest {
  /**
   * Method under test: {@link SimpleLiveAnalyze#markUsed()}
   */
  @Test
  public void testMarkUsed() {
    // Arrange, Act and Assert
    assertTrue((new SimpleLiveAnalyze(new IrMethod(), true)).markUsed().isEmpty());
  }

  /**
   * Method under test: {@link SimpleLiveAnalyze#getLocalSize()}
   */
  @Test
  public void testGetLocalSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new SimpleLiveAnalyze(new IrMethod(), true)).getLocalSize());
  }

  /**
   * Method under test: {@link SimpleLiveAnalyze#onAssignLocal(Local, Value)}
   */
  @Test
  public void testOnAssignLocal() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    Local local = new Local();

    // Act
    SimpleLiveValue actualOnAssignLocalResult = simpleLiveAnalyze.onAssignLocal(local, new ArrayExpr());

    // Assert
    assertEquals('x', actualOnAssignLocalResult.toRsp());
    assertNull(actualOnAssignLocalResult.otherParents);
    assertNull(actualOnAssignLocalResult.parent);
    assertTrue(actualOnAssignLocalResult.used);
  }

  /**
   * Method under test:
   * {@link SimpleLiveAnalyze#onUseLocal(SimpleLiveValue, Local)}
   */
  @Test
  public void testOnUseLocal() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue aValue = new SimpleLiveValue();

    // Act
    simpleLiveAnalyze.onUseLocal(aValue, new Local());

    // Assert
    assertEquals('x', aValue.toRsp());
    assertTrue(aValue.used);
  }

  /**
   * Method under test:
   * {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)}
   */
  @Test
  public void testMerge() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[]{new SimpleLiveValue()};
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertSame(distFrame,
        simpleLiveAnalyze.merge(new SimpleLiveValue[]{new SimpleLiveValue()}, distFrame, src, Stmts.nLabel()));
  }

  /**
   * Method under test:
   * {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)}
   */
  @Test
  public void testMerge2() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[]{new SimpleLiveValue()};
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertSame(distFrame, simpleLiveAnalyze.merge(new SimpleLiveValue[]{null}, distFrame, src, Stmts.nLabel()));
  }

  /**
   * Method under test:
   * {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)}
   */
  @Test
  public void testMerge3() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[]{null};
    LabelStmt src = Stmts.nLabel();

    // Act
    SimpleLiveValue[] actualMergeResult = simpleLiveAnalyze.merge(new SimpleLiveValue[]{new SimpleLiveValue()},
        distFrame, src, Stmts.nLabel());

    // Assert
    assertNull(actualMergeResult[0]);
    assertEquals(1, actualMergeResult.length);
    assertSame(distFrame, actualMergeResult);
  }

  /**
   * Method under test:
   * {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)}
   */
  @Test
  public void testMerge4() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertEquals(0, simpleLiveAnalyze.merge(new SimpleLiveValue[]{null}, null, src, Stmts.nLabel()).length);
  }

  /**
   * Method under test: {@link SimpleLiveAnalyze#newFrame(int)}
   */
  @Test
  public void testNewFrame() {
    // Arrange and Act
    SimpleLiveValue[] actualNewFrameResult = (new SimpleLiveAnalyze(new IrMethod(), true)).newFrame(3);

    // Assert
    assertNull(actualNewFrameResult[0]);
    assertNull(actualNewFrameResult[1]);
    assertNull(actualNewFrameResult[2]);
    assertEquals(3, actualNewFrameResult.length);
  }

  /**
   * Method under test: {@link SimpleLiveAnalyze#newValue()}
   */
  @Test
  public void testNewValue() {
    // Arrange and Act
    SimpleLiveValue actualNewValueResult = (new SimpleLiveAnalyze(new IrMethod(), true)).newValue();

    // Assert
    assertEquals('.', actualNewValueResult.toRsp());
    assertNull(actualNewValueResult.otherParents);
    assertNull(actualNewValueResult.parent);
    assertFalse(actualNewValueResult.used);
  }

  /**
   * Method under test:
   * {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}
   */
  @Test
  public void testNewSimpleLiveAnalyze() {
    // Arrange
    IrMethod method = new IrMethod();

    // Act
    SimpleLiveAnalyze actualSimpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Assert
    IrMethod irMethod = actualSimpleLiveAnalyze.method;
    assertNull(irMethod.args);
    assertNull(irMethod.name);
    assertNull(irMethod.owner);
    assertNull(irMethod.ret);
    assertNull(irMethod.phiLabels);
    assertEquals(0, actualSimpleLiveAnalyze.getLocalSize());
    assertFalse(irMethod.isStatic);
    List<Local> localList = irMethod.locals;
    assertTrue(localList.isEmpty());
    List<Trap> trapList = irMethod.traps;
    assertTrue(trapList.isEmpty());
    List<LocalVar> localVarList = irMethod.vars;
    assertTrue(localVarList.isEmpty());
    assertTrue(actualSimpleLiveAnalyze.aValues.isEmpty());
    assertSame(method.locals, localList);
    assertSame(method.stmts, irMethod.stmts);
    assertSame(method.traps, trapList);
    assertSame(method.vars, localVarList);
  }
}
