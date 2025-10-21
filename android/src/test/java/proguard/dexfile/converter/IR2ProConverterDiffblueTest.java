package proguard.dexfile.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;
import proguard.classfile.editor.CompactCodeAttributeComposer;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;

public class IR2ProConverterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IR2ProConverter}
   *   <li>{@link IR2ProConverter#code(CompactCodeAttributeComposer)}
   *   <li>{@link IR2ProConverter#ir(IrMethod)}
   *   <li>{@link IR2ProConverter#optimizeSynchronized(boolean)}
   *   <li>{@link IR2ProConverter#usePrimitiveArrayConstants(boolean)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IR2ProConverter.<init>()",
    "IR2ProConverter IR2ProConverter.code(CompactCodeAttributeComposer)",
    "IR2ProConverter IR2ProConverter.ir(IrMethod)",
    "IR2ProConverter IR2ProConverter.optimizeSynchronized(boolean)",
    "IR2ProConverter IR2ProConverter.usePrimitiveArrayConstants(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IR2ProConverter actualIr2ProConverter = new IR2ProConverter();
    ProgramClass targetClass = new ProgramClass();
    IR2ProConverter actualCodeResult =
        actualIr2ProConverter.code(new CompactCodeAttributeComposer(targetClass));
    IR2ProConverter actualIrResult = actualIr2ProConverter.ir(new IrMethod());
    IR2ProConverter actualOptimizeSynchronizedResult =
        actualIr2ProConverter.optimizeSynchronized(true);
    IR2ProConverter actualUsePrimitiveArrayConstantsResult =
        actualIr2ProConverter.usePrimitiveArrayConstants(true);

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
   * Test {@link IR2ProConverter#toInternal(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link IR2ProConverter#toInternal(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IR2ProConverter.toInternal(String)"})
  public void testToInternal_when0_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", IR2ProConverter.toInternal("0"));
  }

  /**
   * Test {@link IR2ProConverter#toInternal(String)}.
   *
   * <ul>
   *   <li>When {@code BLjava/lang/Byte;}.
   *   <li>Then return {@code java/lang/Byte}.
   * </ul>
   *
   * <p>Method under test: {@link IR2ProConverter#toInternal(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IR2ProConverter.toInternal(String)"})
  public void testToInternal_whenBLjavaLangByte_thenReturnJavaLangByte() {
    // Arrange, Act and Assert
    assertEquals("java/lang/Byte", IR2ProConverter.toInternal("BLjava/lang/Byte;"));
  }

  /**
   * Test {@link IR2ProConverter#toInternal(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link IR2ProConverter#toInternal(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IR2ProConverter.toInternal(String)"})
  public void testToInternal_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", IR2ProConverter.toInternal("foo"));
  }

  /**
   * Test {@link IR2ProConverter#isZeroOrNull(Value)}.
   *
   * <ul>
   *   <li>When {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IR2ProConverter#isZeroOrNull(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IR2ProConverter.isZeroOrNull(Value)"})
  public void testIsZeroOrNull_whenArrayExpr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IR2ProConverter.isZeroOrNull(new ArrayExpr()));
  }

  /**
   * Test {@link IR2ProConverter#isZeroOrNull(Value)}.
   *
   * <ul>
   *   <li>When nByte {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IR2ProConverter#isZeroOrNull(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IR2ProConverter.isZeroOrNull(Value)"})
  public void testIsZeroOrNull_whenNByteA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IR2ProConverter.isZeroOrNull(Exprs.nByte((byte) 'A')));
  }

  /**
   * Test {@link IR2ProConverter#isZeroOrNull(Value)}.
   *
   * <ul>
   *   <li>When nNull.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IR2ProConverter#isZeroOrNull(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IR2ProConverter.isZeroOrNull(Value)"})
  public void testIsZeroOrNull_whenNNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(IR2ProConverter.isZeroOrNull(Exprs.nNull()));
  }
}
