package proguard.dexfile.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.editor.CompactCodeAttributeComposer;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;

public class IR2ProConverterDiffblueTest {
  /**
   * Method under test: {@link IR2ProConverter#toInternal(String)}
   */
  @Test
  public void testToInternal() {
    // Arrange, Act and Assert
    assertEquals("foo", IR2ProConverter.toInternal("foo"));
    assertEquals("0", IR2ProConverter.toInternal("0"));
    assertEquals("java/lang/Byte", IR2ProConverter.toInternal("BLjava/lang/Byte;"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IR2ProConverter}
   *   <li>{@link IR2ProConverter#code(CompactCodeAttributeComposer)}
   *   <li>{@link IR2ProConverter#ir(IrMethod)}
   *   <li>{@link IR2ProConverter#optimizeSynchronized(boolean)}
   *   <li>{@link IR2ProConverter#usePrimitiveArrayConstants(boolean)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IR2ProConverter actualIr2ProConverter = new IR2ProConverter();
    ProgramClass targetClass = new ProgramClass();
    IR2ProConverter actualCodeResult = actualIr2ProConverter.code(new CompactCodeAttributeComposer(targetClass));
    IR2ProConverter actualIrResult = actualIr2ProConverter.ir(new IrMethod());
    IR2ProConverter actualOptimizeSynchronizedResult = actualIr2ProConverter.optimizeSynchronized(true);
    IR2ProConverter actualUsePrimitiveArrayConstantsResult = actualIr2ProConverter.usePrimitiveArrayConstants(true);

    // Assert
    CompactCodeAttributeComposer compactCodeAttributeComposer = actualIr2ProConverter.code;
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    IrMethod irMethod = actualIr2ProConverter.ir;
    assertTrue(irMethod.locals.isEmpty());
    assertTrue(irMethod.traps.isEmpty());
    assertTrue(irMethod.vars.isEmpty());
    assertSame(targetClass, compactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, compactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
    assertSame(actualIr2ProConverter, actualCodeResult);
    assertSame(actualIr2ProConverter, actualIrResult);
    assertSame(actualIr2ProConverter, actualOptimizeSynchronizedResult);
    assertSame(actualIr2ProConverter, actualUsePrimitiveArrayConstantsResult);
  }

  /**
   * Method under test: {@link IR2ProConverter#isZeroOrNull(Value)}
   */
  @Test
  public void testIsZeroOrNull() {
    // Arrange, Act and Assert
    assertFalse(IR2ProConverter.isZeroOrNull(new ArrayExpr()));
    assertTrue(IR2ProConverter.isZeroOrNull(Exprs.nNull()));
    assertFalse(IR2ProConverter.isZeroOrNull(Exprs.nByte((byte) 'A')));
  }
}
