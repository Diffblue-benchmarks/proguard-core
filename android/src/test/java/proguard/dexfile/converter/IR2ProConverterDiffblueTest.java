package proguard.dexfile.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.editor.CompactCodeAttributeComposer;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;

class IR2ProConverterDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.converter.IR2ProConverter.<init>()",
    "proguard.dexfile.converter.IR2ProConverter proguard.dexfile.converter.IR2ProConverter.code(proguard.classfile.editor.CompactCodeAttributeComposer)",
    "proguard.dexfile.converter.IR2ProConverter proguard.dexfile.converter.IR2ProConverter.ir(proguard.dexfile.ir.IrMethod)",
    "proguard.dexfile.converter.IR2ProConverter proguard.dexfile.converter.IR2ProConverter.optimizeSynchronized(boolean)",
    "proguard.dexfile.converter.IR2ProConverter proguard.dexfile.converter.IR2ProConverter.usePrimitiveArrayConstants(boolean)"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test toInternal(String); when '0'; then return '0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.converter.IR2ProConverter.toInternal(java.lang.String)"
  })
  void testToInternal_when0_thenReturn0() {
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
  @DisplayName("Test toInternal(String); when 'BLjava/lang/Byte;'; then return 'java/lang/Byte'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.converter.IR2ProConverter.toInternal(java.lang.String)"
  })
  void testToInternal_whenBLjavaLangByte_thenReturnJavaLangByte() {
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
  @DisplayName("Test toInternal(String); when 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.converter.IR2ProConverter.toInternal(java.lang.String)"
  })
  void testToInternal_whenFoo_thenReturnFoo() {
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
  @DisplayName("Test isZeroOrNull(Value); when ArrayExpr(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.converter.IR2ProConverter.isZeroOrNull(proguard.dexfile.ir.expr.Value)"
  })
  void testIsZeroOrNull_whenArrayExpr_thenReturnFalse() {
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
  @DisplayName("Test isZeroOrNull(Value); when nByte 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.converter.IR2ProConverter.isZeroOrNull(proguard.dexfile.ir.expr.Value)"
  })
  void testIsZeroOrNull_whenNByteA_thenReturnFalse() {
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
  @DisplayName("Test isZeroOrNull(Value); when nNull; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.converter.IR2ProConverter.isZeroOrNull(proguard.dexfile.ir.expr.Value)"
  })
  void testIsZeroOrNull_whenNNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(IR2ProConverter.isZeroOrNull(Exprs.nNull()));
  }
}
