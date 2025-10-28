package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ClassUtilDiffblueTest {
  /**
   * Method under test: {@link ClassUtil#checkMagicNumber(int)}
   */
  @Test
  public void testCheckMagicNumber() throws UnsupportedOperationException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ClassUtil.checkMagicNumber(10));
  }

  /**
   * Method under test: {@link ClassUtil#internalClassVersion(int, int)}
   */
  @Test
  public void testInternalClassVersion() {
    // Arrange, Act and Assert
    assertEquals(196609, ClassUtil.internalClassVersion(3, 1));
    assertEquals(1048577, ClassUtil.internalClassVersion(Short.SIZE, 1));
    assertEquals(65537, ClassUtil.internalClassVersion(1, 1));
    assertEquals(1, ClassUtil.internalClassVersion(0, 1));
    assertEquals(0, ClassUtil.internalClassVersion("1.0.2"));
    assertEquals(2949123, ClassUtil.internalClassVersion("1.0"));
    assertEquals(2949123, ClassUtil.internalClassVersion("1.1"));
    assertEquals(3014656, ClassUtil.internalClassVersion("1.2"));
    assertEquals(3080192, ClassUtil.internalClassVersion("1.3"));
    assertEquals(3145728, ClassUtil.internalClassVersion("1.4"));
    assertEquals(3211264, ClassUtil.internalClassVersion("5"));
    assertEquals(3211264, ClassUtil.internalClassVersion("1.5"));
    assertEquals(3276800, ClassUtil.internalClassVersion("6"));
    assertEquals(3276800, ClassUtil.internalClassVersion("1.6"));
    assertEquals(3342336, ClassUtil.internalClassVersion("7"));
    assertEquals(3342336, ClassUtil.internalClassVersion("1.7"));
    assertEquals(3407872, ClassUtil.internalClassVersion("8"));
    assertEquals(3407872, ClassUtil.internalClassVersion("1.8"));
    assertEquals(3473408, ClassUtil.internalClassVersion("9"));
    assertEquals(3473408, ClassUtil.internalClassVersion("1.9"));
    assertEquals(3538944, ClassUtil.internalClassVersion("10"));
    assertEquals(3604480, ClassUtil.internalClassVersion("11"));
    assertEquals(3670016, ClassUtil.internalClassVersion("12"));
    assertEquals(3735552, ClassUtil.internalClassVersion("13"));
    assertEquals(3801088, ClassUtil.internalClassVersion("14"));
    assertEquals(3866624, ClassUtil.internalClassVersion("15"));
    assertEquals(3932160, ClassUtil.internalClassVersion("16"));
    assertEquals(3997696, ClassUtil.internalClassVersion("17"));
    assertEquals(4063232, ClassUtil.internalClassVersion("18"));
    assertEquals(4128768, ClassUtil.internalClassVersion("19"));
    assertEquals(4194304, ClassUtil.internalClassVersion("20"));
    assertEquals(4259840, ClassUtil.internalClassVersion("21"));
    assertEquals(4325376, ClassUtil.internalClassVersion("22"));
    assertEquals(4390912, ClassUtil.internalClassVersion("23"));
  }

  /**
   * Method under test: {@link ClassUtil#internalMajorClassVersion(int)}
   */
  @Test
  public void testInternalMajorClassVersion() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalMajorClassVersion(1));
  }

  /**
   * Method under test: {@link ClassUtil#internalMinorClassVersion(int)}
   */
  @Test
  public void testInternalMinorClassVersion() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMinorClassVersion(1));
  }

  /**
   * Method under test: {@link ClassUtil#externalClassVersion(int)}
   */
  @Test
  public void testExternalClassVersion() {
    // Arrange, Act and Assert
    assertNull(ClassUtil.externalClassVersion(1));
    assertEquals("1.0", ClassUtil.externalClassVersion(2949123));
    assertEquals("1.2", ClassUtil.externalClassVersion(3014656));
    assertEquals("1.3", ClassUtil.externalClassVersion(3080192));
    assertEquals("1.4", ClassUtil.externalClassVersion(3145728));
    assertEquals("1.5", ClassUtil.externalClassVersion(3211264));
    assertEquals("1.6", ClassUtil.externalClassVersion(3276800));
    assertEquals("1.7", ClassUtil.externalClassVersion(3342336));
    assertEquals("1.8", ClassUtil.externalClassVersion(3407872));
    assertEquals("1.9", ClassUtil.externalClassVersion(3473408));
    assertEquals("10", ClassUtil.externalClassVersion(3538944));
    assertEquals("11", ClassUtil.externalClassVersion(3604480));
    assertEquals("12", ClassUtil.externalClassVersion(3670016));
    assertEquals("13", ClassUtil.externalClassVersion(3735552));
    assertEquals("14", ClassUtil.externalClassVersion(3801088));
    assertEquals("15", ClassUtil.externalClassVersion(3866624));
    assertEquals("16", ClassUtil.externalClassVersion(3932160));
    assertEquals("17", ClassUtil.externalClassVersion(3997696));
    assertEquals("18", ClassUtil.externalClassVersion(4063232));
    assertEquals("19", ClassUtil.externalClassVersion(4128768));
    assertEquals("20", ClassUtil.externalClassVersion(4194304));
    assertEquals("21", ClassUtil.externalClassVersion(4259840));
    assertEquals("22", ClassUtil.externalClassVersion(4325376));
    assertEquals("23", ClassUtil.externalClassVersion(4390912));
  }

  /**
   * Method under test: {@link ClassUtil#checkVersionNumbers(int)}
   */
  @Test
  public void testCheckVersionNumbers() throws UnsupportedOperationException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ClassUtil.checkVersionNumbers(1));
    assertThrows(UnsupportedOperationException.class, () -> ClassUtil.checkVersionNumbers(4456448));
  }

  /**
   * Method under test: {@link ClassUtil#internalClassName(String)}
   */
  @Test
  public void testInternalClassName() {
    // Arrange, Act and Assert
    assertEquals("External Class Name", ClassUtil.internalClassName("External Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#canonicalClassName(String)}
   */
  @Test
  public void testCanonicalClassName() {
    // Arrange, Act and Assert
    assertEquals("External Class Name", ClassUtil.canonicalClassName("External Class Name"));
  }

  /**
   * Method under test:
   * {@link ClassUtil#externalFullClassDescription(int, String)}
   */
  @Test
  public void testExternalFullClassDescription() {
    // Arrange, Act and Assert
    assertEquals("public Internal Class Name", ClassUtil.externalFullClassDescription(1, "Internal Class Name"));
    assertEquals("Internal Class Name", ClassUtil.externalFullClassDescription(0, "Internal Class Name"));
    assertEquals("private final Internal Class Name",
        ClassUtil.externalFullClassDescription(50, "Internal Class Name"));
    assertEquals("protected Internal Class Name", ClassUtil.externalFullClassDescription(4, "Internal Class Name"));
    assertEquals("static Internal Class Name", ClassUtil.externalFullClassDescription(8, "Internal Class Name"));
    assertEquals("private protected static final @interface Internal Class Name",
        ClassUtil.externalFullClassDescription(-889275714, "Internal Class Name"));
    assertEquals("enum Internal Class Name", ClassUtil.externalFullClassDescription(16384, "Internal Class Name"));
    assertEquals("abstract Internal Class Name", ClassUtil.externalFullClassDescription(1024, "Internal Class Name"));
    assertEquals("synthetic Internal Class Name", ClassUtil.externalFullClassDescription(4096, "Internal Class Name"));
    assertEquals("module Internal Class Name", ClassUtil.externalFullClassDescription(32768, "Internal Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#externalClassName(String)}
   */
  @Test
  public void testExternalClassName() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Name", ClassUtil.externalClassName("Internal Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#externalBaseType(String)}
   */
  @Test
  public void testExternalBaseType() {
    // Arrange, Act and Assert
    assertEquals("External Array Type", ClassUtil.externalBaseType("External Array Type"));
    assertEquals("", ClassUtil.externalBaseType("[]"));
  }

  /**
   * Method under test: {@link ClassUtil#externalShortClassName(String)}
   */
  @Test
  public void testExternalShortClassName() {
    // Arrange, Act and Assert
    assertEquals("External Class Name", ClassUtil.externalShortClassName("External Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#internalShortClassName(String)}
   */
  @Test
  public void testInternalShortClassName() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Name", ClassUtil.internalShortClassName("Internal Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalArrayType(String)}
   */
  @Test
  public void testIsInternalArrayType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalArrayType("Internal Type"));
    assertFalse(ClassUtil.isInternalArrayType(""));
  }

  /**
   * Method under test: {@link ClassUtil#internalArrayTypeDimensionCount(String)}
   */
  @Test
  public void testInternalArrayTypeDimensionCount() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.internalArrayTypeDimensionCount("Internal Type"));
    assertEquals(0, ClassUtil.internalArrayTypeDimensionCount(""));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalArrayInterfaceName(String)}
   */
  @Test
  public void testIsInternalArrayInterfaceName() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalArrayInterfaceName("Internal Class Name"));
    assertTrue(ClassUtil.isInternalArrayInterfaceName("java/lang/Object"));
    assertTrue(ClassUtil.isInternalArrayInterfaceName("java/lang/Cloneable"));
    assertTrue(ClassUtil.isInternalArrayInterfaceName("java/io/Serializable"));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalPrimitiveType(char)}
   */
  @Test
  public void testIsInternalPrimitiveType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalPrimitiveType('A'));
    assertTrue(ClassUtil.isInternalPrimitiveType('Z'));
    assertTrue(ClassUtil.isInternalPrimitiveType('B'));
    assertTrue(ClassUtil.isInternalPrimitiveType('C'));
    assertTrue(ClassUtil.isInternalPrimitiveType('S'));
    assertTrue(ClassUtil.isInternalPrimitiveType('I'));
    assertTrue(ClassUtil.isInternalPrimitiveType('F'));
    assertTrue(ClassUtil.isInternalPrimitiveType('J'));
    assertTrue(ClassUtil.isInternalPrimitiveType('D'));
    assertTrue(ClassUtil.isInternalPrimitiveType("Internal Type"));
    assertFalse(ClassUtil.isInternalPrimitiveType("42"));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalPrimitiveBoxingType(String)}
   */
  @Test
  public void testIsInternalPrimitiveBoxingType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalPrimitiveBoxingType("Internal Type"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Boolean;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Byte;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Character;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Short;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Integer;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Float;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Long;"));
    assertTrue(ClassUtil.isInternalPrimitiveBoxingType("Ljava/lang/Double;"));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalPrimitiveTypeFromPrimitiveBoxingType(String)}
   */
  @Test
  public void testInternalPrimitiveTypeFromPrimitiveBoxingType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Type"));
    assertEquals('Z', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Boolean;"));
    assertEquals('B', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Byte;"));
    assertEquals('C', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Character;"));
    assertEquals('S', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Short;"));
    assertEquals('I', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Integer;"));
    assertEquals('F', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Float;"));
    assertEquals('J', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Long;"));
    assertEquals('D', ClassUtil.internalPrimitiveTypeFromPrimitiveBoxingType("Ljava/lang/Double;"));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalPrimitiveTypeOrString(String)}
   */
  @Test
  public void testIsInternalPrimitiveTypeOrString() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isInternalPrimitiveTypeOrString("Internal Type"));
    assertTrue(ClassUtil.isInternalPrimitiveTypeOrString("Ljava/lang/String;"));
    assertFalse(ClassUtil.isInternalPrimitiveTypeOrString("42"));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalCategory2Type(String)}
   */
  @Test
  public void testIsInternalCategory2Type() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalCategory2Type("Internal Type"));
    assertFalse(ClassUtil.isInternalCategory2Type("%"));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalClassType(String)}
   */
  @Test
  public void testIsInternalClassType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalClassType("Internal Type"));
    assertFalse(ClassUtil.isInternalClassType(""));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalType(String)}
   */
  @Test
  public void testIsInternalType() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalType("Type"));
    assertFalse(ClassUtil.isInternalType("%"));
  }

  /**
   * Method under test: {@link ClassUtil#internalTypeFromClassName(String)}
   */
  @Test
  public void testInternalTypeFromClassName() {
    // Arrange, Act and Assert
    assertEquals("LInternal Class Name;", ClassUtil.internalTypeFromClassName("Internal Class Name"));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalArrayTypeFromClassName(String, int)}
   */
  @Test
  public void testInternalArrayTypeFromClassName() {
    // Arrange, Act and Assert
    assertEquals("[[[LInternal Class Name;", ClassUtil.internalArrayTypeFromClassName("Internal Class Name", 3));
  }

  /**
   * Method under test: {@link ClassUtil#internalArrayTypeFromType(String, int)}
   */
  @Test
  public void testInternalArrayTypeFromType() {
    // Arrange, Act and Assert
    assertEquals("[[Internal Type", ClassUtil.internalArrayTypeFromType("Internal Type", 2));
  }

  /**
   * Method under test: {@link ClassUtil#internalTypeFromArrayType(String)}
   */
  @Test
  public void testInternalTypeFromArrayType() {
    // Arrange, Act and Assert
    assertEquals("Internal Array Type", ClassUtil.internalTypeFromArrayType("Internal Array Type"));
  }

  /**
   * Method under test: {@link ClassUtil#internalClassTypeFromType(String)}
   */
  @Test
  public void testInternalClassTypeFromType() {
    // Arrange, Act and Assert
    assertEquals("Internal Type", ClassUtil.internalClassTypeFromType("Internal Type"));
    assertEquals("", ClassUtil.internalClassTypeFromType(""));
  }

  /**
   * Method under test: {@link ClassUtil#internalTypeFromClassType(String)}
   */
  @Test
  public void testInternalTypeFromClassType() {
    // Arrange, Act and Assert
    assertEquals("LInternal Type;", ClassUtil.internalTypeFromClassType("Internal Type"));
    assertEquals("L;", ClassUtil.internalTypeFromClassType(""));
  }

  /**
   * Method under test: {@link ClassUtil#internalClassNameFromClassType(String)}
   */
  @Test
  public void testInternalClassNameFromClassType() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Type", ClassUtil.internalClassNameFromClassType("Internal Class Type"));
    assertEquals("", ClassUtil.internalClassNameFromClassType(""));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalClassNameFromClassSignature(String)}
   */
  @Test
  public void testInternalClassNameFromClassSignature() {
    // Arrange, Act and Assert
    assertEquals("Class Signature", ClassUtil.internalClassNameFromClassSignature("Class Signature"));
    assertEquals("", ClassUtil.internalClassNameFromClassSignature(""));
  }

  /**
   * Method under test: {@link ClassUtil#removeGenericTypes(String)}
   */
  @Test
  public void testRemoveGenericTypes() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassUtil.removeGenericTypes("Descriptor"));
  }

  /**
   * Method under test: {@link ClassUtil#internalClassNameFromType(String)}
   */
  @Test
  public void testInternalClassNameFromType() {
    // Arrange, Act and Assert
    assertNull(ClassUtil.internalClassNameFromType("Internal Class Type"));
    assertNull(ClassUtil.internalClassNameFromType(""));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalNumericClassNameFromPrimitiveType(char)}
   */
  @Test
  public void testInternalNumericClassNameFromPrimitiveType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.internalNumericClassNameFromPrimitiveType('A'));
    assertEquals("java/lang/Byte", ClassUtil.internalNumericClassNameFromPrimitiveType('B'));
    assertEquals("java/lang/Character", ClassUtil.internalNumericClassNameFromPrimitiveType('C'));
    assertEquals("java/lang/Double", ClassUtil.internalNumericClassNameFromPrimitiveType('D'));
    assertEquals("java/lang/Float", ClassUtil.internalNumericClassNameFromPrimitiveType('F'));
    assertEquals("java/lang/Integer", ClassUtil.internalNumericClassNameFromPrimitiveType('I'));
    assertEquals("java/lang/Long", ClassUtil.internalNumericClassNameFromPrimitiveType('J'));
    assertEquals("java/lang/Short", ClassUtil.internalNumericClassNameFromPrimitiveType('S'));
    assertEquals("java/lang/Void", ClassUtil.internalNumericClassNameFromPrimitiveType('V'));
    assertEquals("java/lang/Boolean", ClassUtil.internalNumericClassNameFromPrimitiveType('Z'));
    assertEquals("java/lang/reflect/Array", ClassUtil.internalNumericClassNameFromPrimitiveType('['));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalPrimitiveTypeFromNumericClassName(String)}
   */
  @Test
  public void testInternalPrimitiveTypeFromNumericClassName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.internalPrimitiveTypeFromNumericClassName("Internal Primitive Class Name"));
    assertEquals('V', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Void"));
    assertEquals('Z', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Boolean"));
    assertEquals('B', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Byte"));
    assertEquals('C', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Character"));
    assertEquals('S', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Short"));
    assertEquals('I', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Integer"));
    assertEquals('J', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Long"));
    assertEquals('F', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Float"));
    assertEquals('D', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/Double"));
    assertEquals('[', ClassUtil.internalPrimitiveTypeFromNumericClassName("java/lang/reflect/Array"));
  }

  /**
   * Method under test: {@link ClassUtil#internalSimpleClassName(String)}
   */
  @Test
  public void testInternalSimpleClassName() {
    // Arrange, Act and Assert
    assertEquals("Internal Class Name", ClassUtil.internalSimpleClassName("Internal Class Name"));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalPrimitiveTypeToComputationalType(String)}
   */
  @Test
  public void testInternalPrimitiveTypeToComputationalType() {
    // Arrange, Act and Assert
    assertEquals(BranchTargetFinder.UNKNOWN,
        ClassUtil.internalPrimitiveTypeToComputationalType("Internal Primitive Type"));
    assertEquals(1, ClassUtil.internalPrimitiveTypeToComputationalType("I"));
    assertEquals(1, ClassUtil.internalPrimitiveTypeToComputationalType("Z"));
    assertEquals(2, ClassUtil.internalPrimitiveTypeToComputationalType("J"));
    assertEquals(4, ClassUtil.internalPrimitiveTypeToComputationalType("D"));
    assertEquals(3, ClassUtil.internalPrimitiveTypeToComputationalType("F"));
  }

  /**
   * Method under test: {@link ClassUtil#isInitializer(String)}
   */
  @Test
  public void testIsInitializer() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInitializer("Internal Method Name"));
    assertTrue(ClassUtil.isInitializer("<clinit>"));
    assertTrue(ClassUtil.isInitializer("<init>"));
  }

  /**
   * Method under test: {@link ClassUtil#isClassInitializer(String)}
   */
  @Test
  public void testIsClassInitializer() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isClassInitializer("Internal Method Name"));
    assertTrue(ClassUtil.isClassInitializer("<clinit>"));
  }

  /**
   * Method under test: {@link ClassUtil#isInstanceInitializer(String)}
   */
  @Test
  public void testIsInstanceInitializer() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInstanceInitializer("Internal Method Name"));
    assertTrue(ClassUtil.isInstanceInitializer("<init>"));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodReturnType(String)}
   */
  @Test
  public void testInternalMethodReturnType() {
    // Arrange, Act and Assert
    assertEquals("Internal Method Descriptor", ClassUtil.internalMethodReturnType("Internal Method Descriptor"));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodParameterCount(String)}
   */
  @Test
  public void testInternalMethodParameterCount() {
    // Arrange, Act and Assert
    assertEquals(25, ClassUtil.internalMethodParameterCount("Internal Method Descriptor)"));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodParameterSize(String)}
   */
  @Test
  public void testInternalMethodParameterSize() {
    // Arrange, Act and Assert
    assertEquals(26, ClassUtil.internalMethodParameterSize("Internal Method Descriptor)"));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalMethodParameterNumber(String, int, int)}
   */
  @Test
  public void testInternalMethodParameterNumber() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 1, 1));
    assertEquals(0, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 1, 0));
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 8, 1));
    assertEquals(BranchTargetFinder.UNKNOWN,
        ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", 1, 60));
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", true, 1));
    assertEquals(0, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", false, 0));
    assertEquals(1, ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", false, 1));
    assertEquals(BranchTargetFinder.UNKNOWN,
        ClassUtil.internalMethodParameterNumber("Internal Method Descriptor", false, 18));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalMethodVariableIndex(String, int, int)}
   */
  @Test
  public void testInternalMethodVariableIndex() {
    // Arrange, Act and Assert
    assertEquals(11, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", 1, 10));
    assertEquals(19, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", 1, 17));
    assertEquals(10, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", 8, 10));
    assertEquals(10, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", true, 10));
    assertEquals(1, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", false, 0));
    assertEquals(19, ClassUtil.internalMethodVariableIndex("Internal Method Descriptor", false, 17));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodParameterType(String, int)}
   */
  @Test
  public void testInternalMethodParameterType() {
    // Arrange, Act and Assert
    assertEquals("n", ClassUtil.internalMethodParameterType("Internal Method Descriptor", 1));
  }

  /**
   * Method under test: {@link ClassUtil#internalTypeSize(String)}
   */
  @Test
  public void testInternalTypeSize() {
    // Arrange, Act and Assert
    assertEquals(1, ClassUtil.internalTypeSize("Internal Type"));
    assertEquals(1, ClassUtil.internalTypeSize("%"));
  }

  /**
   * Method under test: {@link ClassUtil#internalType(String)}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("LExternal Type;", ClassUtil.internalType("External Type"));
    assertEquals("V", ClassUtil.internalType("void"));
    assertEquals("Z", ClassUtil.internalType("boolean"));
    assertEquals("B", ClassUtil.internalType("byte"));
    assertEquals("C", ClassUtil.internalType("char"));
    assertEquals("S", ClassUtil.internalType("short"));
    assertEquals("I", ClassUtil.internalType("int"));
    assertEquals("F", ClassUtil.internalType("float"));
    assertEquals("J", ClassUtil.internalType("long"));
    assertEquals("D", ClassUtil.internalType("double"));
    assertEquals("%", ClassUtil.internalType("%"));
    assertEquals("[L;", ClassUtil.internalType("[]"));
  }

  /**
   * Method under test: {@link ClassUtil#externalArrayTypeDimensionCount(String)}
   */
  @Test
  public void testExternalArrayTypeDimensionCount() {
    // Arrange, Act and Assert
    assertEquals(0, ClassUtil.externalArrayTypeDimensionCount("External Type"));
    assertEquals(1, ClassUtil.externalArrayTypeDimensionCount("[]"));
  }

  /**
   * Method under test: {@link ClassUtil#externalType(String)}
   */
  @Test
  public void testExternalType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType("Internal Type"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType(null));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType("]"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalType(""));
    assertEquals("%", ClassUtil.externalType("%"));
  }

  /**
   * Method under test: {@link ClassUtil#externalClassForNameType(String)}
   */
  @Test
  public void testExternalClassForNameType() {
    // Arrange, Act and Assert
    assertEquals("Internal Type", ClassUtil.externalClassForNameType("Internal Type"));
    assertEquals("", ClassUtil.externalClassForNameType(""));
  }

  /**
   * Method under test: {@link ClassUtil#isInternalMethodDescriptor(String)}
   */
  @Test
  public void testIsInternalMethodDescriptor() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isInternalMethodDescriptor("Internal Descriptor"));
  }

  /**
   * Method under test: {@link ClassUtil#isExternalMethodNameAndArguments(String)}
   */
  @Test
  public void testIsExternalMethodNameAndArguments() {
    // Arrange, Act and Assert
    assertFalse(ClassUtil.isExternalMethodNameAndArguments("External Member Name And Arguments"));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  public void testInternalMethodDescriptor() {
    // Arrange, Act and Assert
    assertEquals("()LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", new ArrayList<>()));
    assertEquals("()[L;", ClassUtil.internalMethodDescriptor("[]", new ArrayList<>()));
    assertEquals("()V", ClassUtil.internalMethodDescriptor("void", new ArrayList<>()));
    assertEquals("()Z", ClassUtil.internalMethodDescriptor("boolean", new ArrayList<>()));
    assertEquals("()B", ClassUtil.internalMethodDescriptor("byte", new ArrayList<>()));
    assertEquals("()C", ClassUtil.internalMethodDescriptor("char", new ArrayList<>()));
    assertEquals("()S", ClassUtil.internalMethodDescriptor("short", new ArrayList<>()));
    assertEquals("()I", ClassUtil.internalMethodDescriptor("int", new ArrayList<>()));
    assertEquals("()%", ClassUtil.internalMethodDescriptor("%", new ArrayList<>()));
    assertEquals("()F", ClassUtil.internalMethodDescriptor("float", new ArrayList<>()));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  public void testInternalMethodDescriptor2() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("[]");

    // Act and Assert
    assertEquals("([L;)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  public void testInternalMethodDescriptor3() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("void");
    externalArguments.add("[]");

    // Act and Assert
    assertEquals("(V[L;)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  public void testInternalMethodDescriptor4() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("long");

    // Act and Assert
    assertEquals("(J)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Method under test: {@link ClassUtil#internalMethodDescriptor(String, List)}
   */
  @Test
  public void testInternalMethodDescriptor5() {
    // Arrange
    ArrayList<String> externalArguments = new ArrayList<>();
    externalArguments.add("double");

    // Act and Assert
    assertEquals("(D)LExternal Return Type;",
        ClassUtil.internalMethodDescriptor("External Return Type", externalArguments));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}
   */
  @Test
  public void testInternalMethodDescriptorFromInternalTypes() {
    // Arrange, Act and Assert
    assertEquals("()Internal Return Type",
        ClassUtil.internalMethodDescriptorFromInternalTypes("Internal Return Type", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}
   */
  @Test
  public void testInternalMethodDescriptorFromInternalTypes2() {
    // Arrange
    ArrayList<String> internalArguments = new ArrayList<>();
    internalArguments.add("Internal Arguments");

    // Act and Assert
    assertEquals("(Internal Arguments)Internal Return Type",
        ClassUtil.internalMethodDescriptorFromInternalTypes("Internal Return Type", internalArguments));
  }

  /**
   * Method under test:
   * {@link ClassUtil#internalMethodDescriptorFromInternalTypes(String, List)}
   */
  @Test
  public void testInternalMethodDescriptorFromInternalTypes3() {
    // Arrange
    ArrayList<String> internalArguments = new ArrayList<>();
    internalArguments.add("42");
    internalArguments.add("foo");

    // Act and Assert
    assertEquals("(42foo)Internal Return Type",
        ClassUtil.internalMethodDescriptorFromInternalTypes("Internal Return Type", internalArguments));
  }

  /**
   * Method under test:
   * {@link ClassUtil#externalFullFieldDescription(int, String, String)}
   */
  @Test
  public void testExternalFullFieldDescription() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(1, "Field Name", "Internal Field Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullFieldDescription(0, "Field Name", null));
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(50, "Field Name", "Internal Field Descriptor"));
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(4, "Field Name", "Internal Field Descriptor"));
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(8, "Field Name", "Internal Field Descriptor"));
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(-889275714, "Field Name", "Internal Field Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil
        .externalFullFieldDescription(BranchTargetFinder.UNKNOWN, "Field Name", "Internal Field Descriptor"));
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullFieldDescription(1, "Field Name", "public"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullFieldDescription(1, "Field Name", ""));
    assertEquals("public % Field Name", ClassUtil.externalFullFieldDescription(1, "Field Name", "%"));
  }

  /**
   * Method under test:
   * {@link ClassUtil#externalFullMethodDescription(String, int, String, String)}
   */
  @Test
  public void testExternalFullMethodDescription() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name", 1,
        "Internal Method Name", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name", 0,
        "<init>", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name",
        50, "Internal Method Name", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name", 4,
        "Internal Method Name", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name", 8,
        "Internal Method Name", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name",
        -889275714, "Internal Method Name", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalFullMethodDescription("Internal Class Name",
        BranchTargetFinder.UNKNOWN, "Internal Method Name", "Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalFullMethodDescription("Internal Class Name", 1, "Internal Method Name", ""));
    assertEquals("public % Internal Method Name(%)",
        ClassUtil.externalFullMethodDescription("Internal Class Name", 1, "Internal Method Name", "%"));
    assertEquals("public Internal Class Name()",
        ClassUtil.externalFullMethodDescription("Internal Class Name", 1, "<init>", "<init>"));
  }

  /**
   * Method under test: {@link ClassUtil#externalClassAccessFlags(int)}
   */
  @Test
  public void testExternalClassAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("public ", ClassUtil.externalClassAccessFlags(1));
    assertEquals("", ClassUtil.externalClassAccessFlags(0));
    assertEquals("private final ", ClassUtil.externalClassAccessFlags(50));
    assertEquals("protected ", ClassUtil.externalClassAccessFlags(4));
    assertEquals("static ", ClassUtil.externalClassAccessFlags(8));
    assertEquals("private protected static final @interface ", ClassUtil.externalClassAccessFlags(-889275714));
    assertEquals("enum ", ClassUtil.externalClassAccessFlags(16384));
    assertEquals("abstract ", ClassUtil.externalClassAccessFlags(1024));
    assertEquals("synthetic ", ClassUtil.externalClassAccessFlags(4096));
    assertEquals("module ", ClassUtil.externalClassAccessFlags(32768));
    assertEquals("Prefixpublic ", ClassUtil.externalClassAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalClassAccessFlags(0, "Prefix"));
    assertEquals("Prefixprivate Prefixfinal ", ClassUtil.externalClassAccessFlags(50, "Prefix"));
    assertEquals("Prefixprotected ", ClassUtil.externalClassAccessFlags(4, "Prefix"));
    assertEquals("Prefixstatic ", ClassUtil.externalClassAccessFlags(8, "Prefix"));
    assertEquals("Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefix@Prefixinterface ",
        ClassUtil.externalClassAccessFlags(-889275714, "Prefix"));
    assertEquals("Prefixenum ", ClassUtil.externalClassAccessFlags(16384, "Prefix"));
    assertEquals("Prefixabstract ", ClassUtil.externalClassAccessFlags(1024, "Prefix"));
    assertEquals("Prefixsynthetic ", ClassUtil.externalClassAccessFlags(4096, "Prefix"));
    assertEquals("Prefixmodule ", ClassUtil.externalClassAccessFlags(32768, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalFieldAccessFlags(int)}
   */
  @Test
  public void testExternalFieldAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("public ", ClassUtil.externalFieldAccessFlags(1));
    assertEquals("", ClassUtil.externalFieldAccessFlags(0));
    assertEquals("private final ", ClassUtil.externalFieldAccessFlags(50));
    assertEquals("protected ", ClassUtil.externalFieldAccessFlags(4));
    assertEquals("static ", ClassUtil.externalFieldAccessFlags(8));
    assertEquals("private protected static final transient synthetic ", ClassUtil.externalFieldAccessFlags(-889275714));
    assertEquals("public private protected static final volatile transient synthetic ",
        ClassUtil.externalFieldAccessFlags(BranchTargetFinder.UNKNOWN));
    assertEquals("Prefixpublic ", ClassUtil.externalFieldAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalFieldAccessFlags(0, "Prefix"));
    assertEquals("Prefixprivate Prefixfinal ", ClassUtil.externalFieldAccessFlags(50, "Prefix"));
    assertEquals("Prefixprotected ", ClassUtil.externalFieldAccessFlags(4, "Prefix"));
    assertEquals("Prefixstatic ", ClassUtil.externalFieldAccessFlags(8, "Prefix"));
    assertEquals("Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixtransient Prefixsynthetic ",
        ClassUtil.externalFieldAccessFlags(-889275714, "Prefix"));
    assertEquals("Prefixpublic Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixvolatile Prefixtransient"
        + " Prefixsynthetic ", ClassUtil.externalFieldAccessFlags(BranchTargetFinder.UNKNOWN, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalMethodAccessFlags(int)}
   */
  @Test
  public void testExternalMethodAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("public ", ClassUtil.externalMethodAccessFlags(1));
    assertEquals("", ClassUtil.externalMethodAccessFlags(0));
    assertEquals("private final synchronized ", ClassUtil.externalMethodAccessFlags(50));
    assertEquals("protected ", ClassUtil.externalMethodAccessFlags(4));
    assertEquals("static ", ClassUtil.externalMethodAccessFlags(8));
    assertEquals("private protected static final synchronized varargs strictfp synthetic ",
        ClassUtil.externalMethodAccessFlags(-889275714));
    assertEquals(
        "public private protected static final synchronized bridge varargs native abstract strictfp" + " synthetic ",
        ClassUtil.externalMethodAccessFlags(BranchTargetFinder.UNKNOWN));
    assertEquals("Prefixpublic ", ClassUtil.externalMethodAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalMethodAccessFlags(0, "Prefix"));
    assertEquals("Prefixprivate Prefixfinal Prefixsynchronized ", ClassUtil.externalMethodAccessFlags(50, "Prefix"));
    assertEquals("Prefixprotected ", ClassUtil.externalMethodAccessFlags(4, "Prefix"));
    assertEquals("Prefixstatic ", ClassUtil.externalMethodAccessFlags(8, "Prefix"));
    assertEquals(
        "Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixsynchronized Prefixvarargs Prefixstrictfp"
            + " Prefixsynthetic ",
        ClassUtil.externalMethodAccessFlags(-889275714, "Prefix"));
    assertEquals(
        "Prefixpublic Prefixprivate Prefixprotected Prefixstatic Prefixfinal Prefixsynchronized Prefixbridge"
            + " Prefixvarargs Prefixnative Prefixabstract Prefixstrictfp Prefixsynthetic ",
        ClassUtil.externalMethodAccessFlags(BranchTargetFinder.UNKNOWN, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalParameterAccessFlags(int)}
   */
  @Test
  public void testExternalParameterAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalParameterAccessFlags(1));
    assertEquals("", ClassUtil.externalParameterAccessFlags(0));
    assertEquals("final ", ClassUtil.externalParameterAccessFlags(50));
    assertEquals("synthetic ", ClassUtil.externalParameterAccessFlags(4096));
    assertEquals("mandated ", ClassUtil.externalParameterAccessFlags(32768));
    assertEquals("", ClassUtil.externalParameterAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalParameterAccessFlags(0, "Prefix"));
    assertEquals("Prefixfinal ", ClassUtil.externalParameterAccessFlags(50, "Prefix"));
    assertEquals("Prefixsynthetic ", ClassUtil.externalParameterAccessFlags(4096, "Prefix"));
    assertEquals("Prefixmandated ", ClassUtil.externalParameterAccessFlags(32768, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalMethodReturnType(String)}
   */
  @Test
  public void testExternalMethodReturnType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ClassUtil.externalMethodReturnType("Internal Method Descriptor"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalMethodReturnType("]"));
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalMethodReturnType(""));
    assertEquals("%", ClassUtil.externalMethodReturnType("%"));
  }

  /**
   * Method under test: {@link ClassUtil#externalModuleAccessFlags(int)}
   */
  @Test
  public void testExternalModuleAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalModuleAccessFlags(1));
    assertEquals("", ClassUtil.externalModuleAccessFlags(0));
    assertEquals("open ", ClassUtil.externalModuleAccessFlags(50));
    assertEquals("synthetic ", ClassUtil.externalModuleAccessFlags(4096));
    assertEquals("mandated ", ClassUtil.externalModuleAccessFlags(32768));
    assertEquals("", ClassUtil.externalModuleAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalModuleAccessFlags(0, "Prefix"));
    assertEquals("Prefixopen ", ClassUtil.externalModuleAccessFlags(50, "Prefix"));
    assertEquals("Prefixsynthetic ", ClassUtil.externalModuleAccessFlags(4096, "Prefix"));
    assertEquals("Prefixmandated ", ClassUtil.externalModuleAccessFlags(32768, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalRequiresAccessFlags(int)}
   */
  @Test
  public void testExternalRequiresAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalRequiresAccessFlags(1));
    assertEquals("", ClassUtil.externalRequiresAccessFlags(0));
    assertEquals("transitive ", ClassUtil.externalRequiresAccessFlags(50));
    assertEquals("static ", ClassUtil.externalRequiresAccessFlags(Double.SIZE));
    assertEquals("synthetic ", ClassUtil.externalRequiresAccessFlags(4096));
    assertEquals("mandated ", ClassUtil.externalRequiresAccessFlags(32768));
    assertEquals("", ClassUtil.externalRequiresAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalRequiresAccessFlags(0, "Prefix"));
    assertEquals("Prefixtransitive ", ClassUtil.externalRequiresAccessFlags(50, "Prefix"));
    assertEquals("Prefixstatic ", ClassUtil.externalRequiresAccessFlags(Double.SIZE, "Prefix"));
    assertEquals("Prefixsynthetic ", ClassUtil.externalRequiresAccessFlags(4096, "Prefix"));
    assertEquals("Prefixmandated ", ClassUtil.externalRequiresAccessFlags(32768, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalExportsAccessFlags(int)}
   */
  @Test
  public void testExternalExportsAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalExportsAccessFlags(1));
    assertEquals("", ClassUtil.externalExportsAccessFlags(0));
    assertEquals("synthetic ", ClassUtil.externalExportsAccessFlags(4096));
    assertEquals("mandated ", ClassUtil.externalExportsAccessFlags(32768));
    assertEquals("", ClassUtil.externalExportsAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalExportsAccessFlags(0, "Prefix"));
    assertEquals("Prefixsynthetic ", ClassUtil.externalExportsAccessFlags(4096, "Prefix"));
    assertEquals("Prefixmandated ", ClassUtil.externalExportsAccessFlags(32768, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalOpensAccessFlags(int)}
   */
  @Test
  public void testExternalOpensAccessFlags() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalOpensAccessFlags(1));
    assertEquals("", ClassUtil.externalOpensAccessFlags(0));
    assertEquals("synthetic ", ClassUtil.externalOpensAccessFlags(4096));
    assertEquals("mandated ", ClassUtil.externalOpensAccessFlags(32768));
    assertEquals("", ClassUtil.externalOpensAccessFlags(1, "Prefix"));
    assertEquals("", ClassUtil.externalOpensAccessFlags(0, "Prefix"));
    assertEquals("Prefixsynthetic ", ClassUtil.externalOpensAccessFlags(4096, "Prefix"));
    assertEquals("Prefixmandated ", ClassUtil.externalOpensAccessFlags(32768, "Prefix"));
  }

  /**
   * Method under test: {@link ClassUtil#externalMethodArguments(String)}
   */
  @Test
  public void testExternalMethodArguments() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.externalMethodArguments("Internal Method Descriptor"));
    assertEquals("%", ClassUtil.externalMethodArguments("%"));
  }

  /**
   * Method under test: {@link ClassUtil#internalPackageName(String)}
   */
  @Test
  public void testInternalPackageName() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalPackageName("Internal Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#internalPackagePrefix(String)}
   */
  @Test
  public void testInternalPackagePrefix() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.internalPackagePrefix("Internal Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#externalPackageName(String)}
   */
  @Test
  public void testExternalPackageName() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalPackageName("External Class Name"));
    assertEquals("1", ClassUtil.externalPackageName("1.0"));
  }

  /**
   * Method under test: {@link ClassUtil#externalPackagePrefix(String)}
   */
  @Test
  public void testExternalPackagePrefix() {
    // Arrange, Act and Assert
    assertEquals("", ClassUtil.externalPackagePrefix("External Class Name"));
  }

  /**
   * Method under test: {@link ClassUtil#isExtendable(Clazz)}
   */
  @Test
  public void testIsExtendable() {
    // Arrange, Act and Assert
    assertTrue(ClassUtil.isExtendable(new LibraryClass()));
    assertTrue(ClassUtil.isExtendable(null));
    assertFalse(ClassUtil.isExtendable(new LibraryClass(Short.SIZE, "This Class Name", "Super Class Name")));
  }
}
