package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.instruction.visitor.InstructionCounter;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class ConstantInstructionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Name is {@code nop}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantInstruction#ConstantInstruction()}
   *   <li>{@link ConstantInstruction#visitClassConstant(Clazz, ClassConstant)}
   *   <li>{@link ConstantInstruction#visitDoubleConstant(Clazz, DoubleConstant)}
   *   <li>{@link ConstantInstruction#visitFloatConstant(Clazz, FloatConstant)}
   *   <li>{@link ConstantInstruction#visitIntegerConstant(Clazz, IntegerConstant)}
   *   <li>{@link ConstantInstruction#visitLongConstant(Clazz, LongConstant)}
   *   <li>{@link ConstantInstruction#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   *   <li>{@link ConstantInstruction#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   *   <li>{@link ConstantInstruction#visitModuleConstant(Clazz, ModuleConstant)}
   *   <li>{@link ConstantInstruction#visitPackageConstant(Clazz, PackageConstant)}
   *   <li>{@link ConstantInstruction#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   *   <li>{@link ConstantInstruction#visitStringConstant(Clazz, StringConstant)}
   *   <li>{@link ConstantInstruction#visitUtf8Constant(Clazz, Utf8Constant)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Name is 'nop'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.<init>()",
    "void proguard.classfile.instruction.ConstantInstruction.<init>(byte, int)",
    "void proguard.classfile.instruction.ConstantInstruction.<init>(byte, int, int)",
    "void proguard.classfile.instruction.ConstantInstruction.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testGettersAndSetters_thenReturnNameIsNop() {
    // Arrange and Act
    ConstantInstruction actualConstantInstruction = new ConstantInstruction();
    LibraryClass clazz = new LibraryClass();
    actualConstantInstruction.visitClassConstant(clazz, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    actualConstantInstruction.visitDoubleConstant(clazz2, new DoubleConstant(10.0d));
    LibraryClass clazz3 = new LibraryClass();
    actualConstantInstruction.visitFloatConstant(clazz3, new FloatConstant(10.0f));
    LibraryClass clazz4 = new LibraryClass();
    actualConstantInstruction.visitIntegerConstant(clazz4, new IntegerConstant(42));
    LibraryClass clazz5 = new LibraryClass();
    actualConstantInstruction.visitLongConstant(clazz5, new LongConstant(42L));
    LibraryClass clazz6 = new LibraryClass();
    actualConstantInstruction.visitMethodHandleConstant(clazz6, new MethodHandleConstant(1, 1));
    LibraryClass clazz7 = new LibraryClass();
    actualConstantInstruction.visitMethodTypeConstant(clazz7, new MethodTypeConstant());
    LibraryClass clazz8 = new LibraryClass();
    actualConstantInstruction.visitModuleConstant(clazz8, new ModuleConstant(1));
    LibraryClass clazz9 = new LibraryClass();
    actualConstantInstruction.visitPackageConstant(clazz9, new PackageConstant(1));
    LibraryClass clazz10 = new LibraryClass();
    actualConstantInstruction.visitPrimitiveArrayConstant(clazz10, new PrimitiveArrayConstant());
    LibraryClass clazz11 = new LibraryClass();
    actualConstantInstruction.visitStringConstant(clazz11, new StringConstant());
    LibraryClass clazz12 = new LibraryClass();
    actualConstantInstruction.visitUtf8Constant(clazz12, new Utf8Constant("String"));

    // Assert
    assertEquals("nop", actualConstantInstruction.getName());
    assertEquals(0, actualConstantInstruction.constant);
    assertEquals(0, actualConstantInstruction.constantIndex);
    assertFalse(actualConstantInstruction.isCategory2());
    assertFalse(actualConstantInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualConstantInstruction.opcode);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link ConstantInstruction#constant} is one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantInstruction#ConstantInstruction(byte, int, int)}
   *   <li>{@link ConstantInstruction#visitClassConstant(Clazz, ClassConstant)}
   *   <li>{@link ConstantInstruction#visitDoubleConstant(Clazz, DoubleConstant)}
   *   <li>{@link ConstantInstruction#visitFloatConstant(Clazz, FloatConstant)}
   *   <li>{@link ConstantInstruction#visitIntegerConstant(Clazz, IntegerConstant)}
   *   <li>{@link ConstantInstruction#visitLongConstant(Clazz, LongConstant)}
   *   <li>{@link ConstantInstruction#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   *   <li>{@link ConstantInstruction#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   *   <li>{@link ConstantInstruction#visitModuleConstant(Clazz, ModuleConstant)}
   *   <li>{@link ConstantInstruction#visitPackageConstant(Clazz, PackageConstant)}
   *   <li>{@link ConstantInstruction#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   *   <li>{@link ConstantInstruction#visitStringConstant(Clazz, StringConstant)}
   *   <li>{@link ConstantInstruction#visitUtf8Constant(Clazz, Utf8Constant)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return constant is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.<init>()",
    "void proguard.classfile.instruction.ConstantInstruction.<init>(byte, int)",
    "void proguard.classfile.instruction.ConstantInstruction.<init>(byte, int, int)",
    "void proguard.classfile.instruction.ConstantInstruction.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testGettersAndSetters_whenA_thenReturnConstantIsOne() {
    // Arrange and Act
    ConstantInstruction actualConstantInstruction = new ConstantInstruction((byte) 'A', 1, 1);
    LibraryClass clazz = new LibraryClass();
    actualConstantInstruction.visitClassConstant(clazz, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    actualConstantInstruction.visitDoubleConstant(clazz2, new DoubleConstant(10.0d));
    LibraryClass clazz3 = new LibraryClass();
    actualConstantInstruction.visitFloatConstant(clazz3, new FloatConstant(10.0f));
    LibraryClass clazz4 = new LibraryClass();
    actualConstantInstruction.visitIntegerConstant(clazz4, new IntegerConstant(42));
    LibraryClass clazz5 = new LibraryClass();
    actualConstantInstruction.visitLongConstant(clazz5, new LongConstant(42L));
    LibraryClass clazz6 = new LibraryClass();
    actualConstantInstruction.visitMethodHandleConstant(clazz6, new MethodHandleConstant(1, 1));
    LibraryClass clazz7 = new LibraryClass();
    actualConstantInstruction.visitMethodTypeConstant(clazz7, new MethodTypeConstant());
    LibraryClass clazz8 = new LibraryClass();
    actualConstantInstruction.visitModuleConstant(clazz8, new ModuleConstant(1));
    LibraryClass clazz9 = new LibraryClass();
    actualConstantInstruction.visitPackageConstant(clazz9, new PackageConstant(1));
    LibraryClass clazz10 = new LibraryClass();
    actualConstantInstruction.visitPrimitiveArrayConstant(clazz10, new PrimitiveArrayConstant());
    LibraryClass clazz11 = new LibraryClass();
    actualConstantInstruction.visitStringConstant(clazz11, new StringConstant());
    LibraryClass clazz12 = new LibraryClass();
    actualConstantInstruction.visitUtf8Constant(clazz12, new Utf8Constant("String"));

    // Assert
    assertEquals("lstore_2", actualConstantInstruction.getName());
    assertEquals(1, actualConstantInstruction.constant);
    assertEquals(1, actualConstantInstruction.constantIndex);
    assertFalse(actualConstantInstruction.isWide());
    assertTrue(actualConstantInstruction.isCategory2());
    assertEquals('A', actualConstantInstruction.opcode);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantInstruction#ConstantInstruction(byte, int)}
   *   <li>{@link ConstantInstruction#visitClassConstant(Clazz, ClassConstant)}
   *   <li>{@link ConstantInstruction#visitDoubleConstant(Clazz, DoubleConstant)}
   *   <li>{@link ConstantInstruction#visitFloatConstant(Clazz, FloatConstant)}
   *   <li>{@link ConstantInstruction#visitIntegerConstant(Clazz, IntegerConstant)}
   *   <li>{@link ConstantInstruction#visitLongConstant(Clazz, LongConstant)}
   *   <li>{@link ConstantInstruction#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   *   <li>{@link ConstantInstruction#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   *   <li>{@link ConstantInstruction#visitModuleConstant(Clazz, ModuleConstant)}
   *   <li>{@link ConstantInstruction#visitPackageConstant(Clazz, PackageConstant)}
   *   <li>{@link ConstantInstruction#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   *   <li>{@link ConstantInstruction#visitStringConstant(Clazz, StringConstant)}
   *   <li>{@link ConstantInstruction#visitUtf8Constant(Clazz, Utf8Constant)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'A'; then return Name is 'lstore_2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.<init>()",
    "void proguard.classfile.instruction.ConstantInstruction.<init>(byte, int)",
    "void proguard.classfile.instruction.ConstantInstruction.<init>(byte, int, int)",
    "void proguard.classfile.instruction.ConstantInstruction.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)",
    "void proguard.classfile.instruction.ConstantInstruction.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testGettersAndSetters_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    ConstantInstruction actualConstantInstruction = new ConstantInstruction((byte) 'A', 1);
    LibraryClass clazz = new LibraryClass();
    actualConstantInstruction.visitClassConstant(clazz, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    actualConstantInstruction.visitDoubleConstant(clazz2, new DoubleConstant(10.0d));
    LibraryClass clazz3 = new LibraryClass();
    actualConstantInstruction.visitFloatConstant(clazz3, new FloatConstant(10.0f));
    LibraryClass clazz4 = new LibraryClass();
    actualConstantInstruction.visitIntegerConstant(clazz4, new IntegerConstant(42));
    LibraryClass clazz5 = new LibraryClass();
    actualConstantInstruction.visitLongConstant(clazz5, new LongConstant(42L));
    LibraryClass clazz6 = new LibraryClass();
    actualConstantInstruction.visitMethodHandleConstant(clazz6, new MethodHandleConstant(1, 1));
    LibraryClass clazz7 = new LibraryClass();
    actualConstantInstruction.visitMethodTypeConstant(clazz7, new MethodTypeConstant());
    LibraryClass clazz8 = new LibraryClass();
    actualConstantInstruction.visitModuleConstant(clazz8, new ModuleConstant(1));
    LibraryClass clazz9 = new LibraryClass();
    actualConstantInstruction.visitPackageConstant(clazz9, new PackageConstant(1));
    LibraryClass clazz10 = new LibraryClass();
    actualConstantInstruction.visitPrimitiveArrayConstant(clazz10, new PrimitiveArrayConstant());
    LibraryClass clazz11 = new LibraryClass();
    actualConstantInstruction.visitStringConstant(clazz11, new StringConstant());
    LibraryClass clazz12 = new LibraryClass();
    actualConstantInstruction.visitUtf8Constant(clazz12, new Utf8Constant("String"));

    // Assert
    assertEquals("lstore_2", actualConstantInstruction.getName());
    assertEquals(0, actualConstantInstruction.constant);
    assertEquals(1, actualConstantInstruction.constantIndex);
    assertFalse(actualConstantInstruction.isWide());
    assertTrue(actualConstantInstruction.isCategory2());
    assertEquals('A', actualConstantInstruction.opcode);
  }

  /**
   * Test {@link ConstantInstruction#copy(ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then return {@link ConstantInstruction#ConstantInstruction(byte, int)} with opcode is
   *       {@code A} and constantIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#copy(ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test copy(ConstantInstruction); then return ConstantInstruction(byte, int) with opcode is 'A' and constantIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.ConstantInstruction proguard.classfile.instruction.ConstantInstruction.copy(proguard.classfile.instruction.ConstantInstruction)"
  })
  void testCopy_thenReturnConstantInstructionWithOpcodeIsAAndConstantIndexIsOne() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertSame(
        constantInstruction, constantInstruction.copy(new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}.
   *
   * <p>Method under test: {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  @DisplayName("Test mayInstanceThrowExceptions(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.mayInstanceThrowExceptions(proguard.classfile.Clazz)"
  })
  void testMayInstanceThrowExceptions() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertFalse(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}.
   *
   * <p>Method under test: {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  @DisplayName("Test mayInstanceThrowExceptions(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.mayInstanceThrowExceptions(proguard.classfile.Clazz)"
  })
  void testMayInstanceThrowExceptions2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;

    // Act and Assert
    assertFalse(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}.
   *
   * <p>Method under test: {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  @DisplayName("Test mayInstanceThrowExceptions(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.mayInstanceThrowExceptions(proguard.classfile.Clazz)"
  })
  void testMayInstanceThrowExceptions3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC_W;

    // Act and Assert
    assertFalse(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  @DisplayName("Test mayInstanceThrowExceptions(Clazz); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.mayInstanceThrowExceptions(proguard.classfile.Clazz)"
  })
  void testMayInstanceThrowExceptions_thenReturnTrue() {
    // Arrange
    ConstantInstruction constantInstruction =
        new ConstantInstruction(Instruction.OP_INVOKEINTERFACE, 1);

    // Act and Assert
    assertTrue(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte proguard.classfile.instruction.ConstantInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', (new ConstantInstruction((byte) 'A', 1)).canonicalOpcode());
  }

  /**
   * Test {@link ConstantInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_LDC}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_LDC")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte proguard.classfile.instruction.ConstantInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_ldc() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC_W;

    // Act and Assert
    assertEquals(Instruction.OP_LDC, constantInstruction.canonicalOpcode());
  }

  /**
   * Test {@link ConstantInstruction#shrink()}.
   *
   * <p>Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.ConstantInstruction.shrink()"
  })
  void testShrink() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("lstore_2", constantInstruction.getName());
    assertEquals('A', constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Test {@link ConstantInstruction#shrink()}.
   *
   * <p>Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.ConstantInstruction.shrink()"
  })
  void testShrink2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', -71);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("lstore_2", constantInstruction.getName());
    assertEquals('A', constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Test {@link ConstantInstruction#shrink()}.
   *
   * <p>Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.ConstantInstruction.shrink()"
  })
  void testShrink3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_LDC, -71);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("ldc_w", constantInstruction.getName());
    assertEquals(Instruction.OP_LDC_W, constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Test {@link ConstantInstruction#shrink()}.
   *
   * <p>Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.ConstantInstruction.shrink()"
  })
  void testShrink4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_LDC, 65535);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("ldc_w", constantInstruction.getName());
    assertEquals(Instruction.OP_LDC_W, constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Test {@link ConstantInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link ConstantInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return ConstantInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.instruction.ConstantInstruction.shrink()"
  })
  void testShrink_thenReturnConstantInstruction() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC_W;

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof ConstantInstruction);
    assertEquals("ldc", constantInstruction.getName());
    assertEquals("ldc", actualShrinkResult.getName());
    assertEquals(Instruction.OP_LDC, constantInstruction.opcode);
    assertEquals(Instruction.OP_LDC, ((ConstantInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link ConstantInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.readInfo(byte[], int)"
  })
  void testReadInfo() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;

    // Act
    constantInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, constantInstruction.constant);
    assertEquals(65, constantInstruction.constantIndex);
  }

  /**
   * Test {@link ConstantInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.readInfo(byte[], int)"
  })
  void testReadInfo2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act
    constantInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, constantInstruction.constantIndex);
    assertEquals(65, constantInstruction.constant);
  }

  /**
   * Test {@link ConstantInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.readInfo(byte[], int)"
  })
  void testReadInfo3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act
    constantInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, constantInstruction.constant);
    assertEquals(16728, constantInstruction.constantIndex);
  }

  /**
   * Test {@link ConstantInstruction#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test readInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.readInfo(byte[], int)"
  })
  void testReadInfo4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act
    constantInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, constantInstruction.constant);
    assertEquals(16728, constantInstruction.constantIndex);
  }

  /**
   * Test {@link ConstantInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test readInfo(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.readInfo(byte[], int)"
  })
  void testReadInfo_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    constantInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(0, constantInstruction.constant);
    assertEquals(16728, constantInstruction.constantIndex);
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_ACONST_NULL, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_NOP,
          Instruction.OP_ACONST_NULL,
          Instruction.OP_NOP,
          'X',
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_NOP,
          Instruction.OP_ACONST_NULL,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_NOP,
          Instruction.OP_ACONST_NULL,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo5() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', -59);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo6() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction =
        new ConstantInstruction(Instruction.OP_MULTIANEWARRAY, -59);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> constantInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo7() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction =
        new ConstantInstruction(Instruction.OP_MULTIANEWARRAY, 65535);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, -1, Instruction.OP_NOP, 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link ConstantInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.writeInfo(byte[], int)"
  })
  void testWriteInfo_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_NOP, Instruction.OP_ACONST_NULL, 'A', 'X', 'A', 'X'},
        code);
  }

  /**
   * Test {@link ConstantInstruction#length(int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.ConstantInstruction.length(int)"})
  void testLength() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act and Assert
    assertEquals(5, constantInstruction.length(2));
  }

  /**
   * Test {@link ConstantInstruction#length(int)}.
   *
   * <p>Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.ConstantInstruction.length(int)"})
  void testLength2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act and Assert
    assertEquals(5, constantInstruction.length(2));
  }

  /**
   * Test {@link ConstantInstruction#length(int)}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int); then return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.ConstantInstruction.length(int)"})
  void testLength_thenReturnFour() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals(4, constantInstruction.length(2));
  }

  /**
   * Test {@link ConstantInstruction#length(int)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int); then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.ConstantInstruction.length(int)"})
  void testLength_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new ConstantInstruction((byte) 'A', 1)).length(2));
  }

  /**
   * Test {@link ConstantInstruction#length(int)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int); then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.instruction.ConstantInstruction.length(int)"})
  void testLength_thenReturnTwo() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;

    // Act and Assert
    assertEquals(2, constantInstruction.length(2));
  }

  /**
   * Test {@link ConstantInstruction#accept(Clazz, Method, CodeAttribute, int, InstructionVisitor)}.
   *
   * <ul>
   *   <li>When {@link InstructionCounter} (default constructor).
   *   <li>Then {@link InstructionCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#accept(Clazz, Method, CodeAttribute, int,
   * InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, int, InstructionVisitor); when InstructionCounter (default constructor); then InstructionCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testAccept_whenInstructionCounter_thenInstructionCounterCountIsOne() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    InstructionCounter instructionVisitor = new InstructionCounter();

    // Act
    constantInstruction.accept(clazz, method, codeAttribute, 2, instructionVisitor);

    // Assert
    assertEquals(1, instructionVisitor.getCount());
  }

  /**
   * Test {@link ConstantInstruction#toString(Clazz, int)} with {@code clazz}, {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] invokedynamic #1, 0 =}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test toString(Clazz, int) with 'clazz', 'offset'; then return '[2] invokedynamic #1, 0 ='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString(proguard.classfile.Clazz, int)"
  })
  void testToStringWithClazzOffset_thenReturn2Invokedynamic10() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act and Assert
    assertEquals("[2] invokedynamic #1, 0 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Test {@link ConstantInstruction#toString(Clazz, int)} with {@code clazz}, {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] invokeinterface #1, 0 =}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test toString(Clazz, int) with 'clazz', 'offset'; then return '[2] invokeinterface #1, 0 ='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString(proguard.classfile.Clazz, int)"
  })
  void testToStringWithClazzOffset_thenReturn2Invokeinterface10() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act and Assert
    assertEquals(
        "[2] invokeinterface #1, 0 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Test {@link ConstantInstruction#toString(Clazz, int)} with {@code clazz}, {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 #1 =}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  @DisplayName("Test toString(Clazz, int) with 'clazz', 'offset'; then return '[2] lstore_2 #1 ='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString(proguard.classfile.Clazz, int)"
  })
  void testToStringWithClazzOffset_thenReturn2Lstore21() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals("[2] lstore_2 #1 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Test {@link ConstantInstruction#toString(Clazz, int)} with {@code clazz}, {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] multianewarray #1, 0 =}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test toString(Clazz, int) with 'clazz', 'offset'; then return '[2] multianewarray #1, 0 ='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString(proguard.classfile.Clazz, int)"
  })
  void testToStringWithClazzOffset_thenReturn2Multianewarray10() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals(
        "[2] multianewarray #1, 0 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Test {@link ConstantInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code invokedynamic #1, 0}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'invokedynamic #1, 0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString()"
  })
  void testToString_thenReturnInvokedynamic10() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act and Assert
    assertEquals("invokedynamic #1, 0", constantInstruction.toString());
  }

  /**
   * Test {@link ConstantInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code invokeinterface #1, 0}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'invokeinterface #1, 0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString()"
  })
  void testToString_thenReturnInvokeinterface10() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act and Assert
    assertEquals("invokeinterface #1, 0", constantInstruction.toString());
  }

  /**
   * Test {@link ConstantInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code lstore_2 #1}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'lstore_2 #1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString()"
  })
  void testToString_thenReturnLstore21() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 #1", (new ConstantInstruction((byte) 'A', 1)).toString());
  }

  /**
   * Test {@link ConstantInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code multianewarray #1, 0}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'multianewarray #1, 0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.instruction.ConstantInstruction.toString()"
  })
  void testToString_thenReturnMultianewarray10() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals("multianewarray #1, 0", constantInstruction.toString());
  }

  /**
   * Test {@link ConstantInstruction#stackPopCount(Clazz)}.
   *
   * <p>Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPopCount(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.instruction.ConstantInstruction.stackPopCount(proguard.classfile.Clazz)"
  })
  void testStackPopCount() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_PUTSTATIC;

    // Act and Assert
    assertEquals(0, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#stackPopCount(Clazz)}.
   *
   * <p>Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPopCount(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.instruction.ConstantInstruction.stackPopCount(proguard.classfile.Clazz)"
  })
  void testStackPopCount2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals(0, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#stackPopCount(Clazz)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPopCount(Clazz); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.instruction.ConstantInstruction.stackPopCount(proguard.classfile.Clazz)"
  })
  void testStackPopCount_thenReturnOne() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEVIRTUAL;

    // Act and Assert
    assertEquals(1, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#stackPopCount(Clazz)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPopCount(Clazz); then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.instruction.ConstantInstruction.stackPopCount(proguard.classfile.Clazz)"
  })
  void testStackPopCount_thenReturnTwo() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(2, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#stackPushCount(Clazz)}.
   *
   * <p>Method under test: {@link ConstantInstruction#stackPushCount(Clazz)}
   */
  @Test
  @DisplayName("Test stackPushCount(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.instruction.ConstantInstruction.stackPushCount(proguard.classfile.Clazz)"
  })
  void testStackPushCount() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_GETSTATIC;

    // Act and Assert
    assertEquals(0, constantInstruction.stackPushCount(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#stackPushCount(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link ConstantInstruction#ConstantInstruction(byte, int)} with opcode is {@code A}
   *       and constantIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#stackPushCount(Clazz)}
   */
  @Test
  @DisplayName(
      "Test stackPushCount(Clazz); given ConstantInstruction(byte, int) with opcode is 'A' and constantIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.instruction.ConstantInstruction.stackPushCount(proguard.classfile.Clazz)"
  })
  void testStackPushCount_givenConstantInstructionWithOpcodeIsAAndConstantIndexIsOne() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(0, constantInstruction.stackPushCount(new LibraryClass()));
  }

  /**
   * Test {@link ConstantInstruction#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then calls {@link LibraryClass#getType(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); given 'Type'; then calls getType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenType_thenCallsGetType() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantInstruction.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ConstantInstruction#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link StackOverflowError}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName("Test visitDynamicConstant(Clazz, DynamicConstant); then throw StackOverflowError")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.instruction.ConstantInstruction.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_thenThrowStackOverflowError() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {new InvokeDynamicConstant()}, 1, 1, 1);

    // Act and Assert
    assertThrows(
        StackOverflowError.class,
        () -> constantInstruction.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}, and {@link ConstantInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantInstruction#equals(Object)}
   *   <li>{@link ConstantInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    ConstantInstruction constantInstruction2 = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(constantInstruction, constantInstruction2);
    int expectedHashCodeResult = constantInstruction.hashCode();
    assertEquals(expectedHashCodeResult, constantInstruction2.hashCode());
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}, and {@link ConstantInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantInstruction#equals(Object)}
   *   <li>{@link ConstantInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(constantInstruction, constantInstruction);
    int expectedHashCodeResult = constantInstruction.hashCode();
    assertEquals(expectedHashCodeResult, constantInstruction.hashCode());
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConstantInstruction constantInstruction =
        new ConstantInstruction(Instruction.OP_ACONST_NULL, 1);

    // Act and Assert
    assertNotEquals(constantInstruction, new ConstantInstruction((byte) 'A', 1));
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(constantInstruction, new ConstantInstruction((byte) 'A', 1));
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1, 65);

    // Act and Assert
    assertNotEquals(constantInstruction, new ConstantInstruction((byte) 'A', 1));
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConstantInstruction((byte) 'A', 1), null);
  }

  /**
   * Test {@link ConstantInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.instruction.ConstantInstruction.equals(java.lang.Object)",
    "int proguard.classfile.instruction.ConstantInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConstantInstruction((byte) 'A', 1), "Different type to ConstantInstruction");
  }
}
