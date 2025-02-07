package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.visitor.ClassVisitor;
import proguard.testutils.cpa.NamedClass;

class ProgramClassDiffblueTest {
  /**
   * Test {@link ProgramClass#ProgramClass()}.
   *
   * <p>Method under test: {@link ProgramClass#ProgramClass()}
   */
  @Test
  @DisplayName("Test new ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ProgramClass.<init>()"})
  void testNewProgramClass() {
    // Arrange and Act
    ProgramClass actualProgramClass = new ProgramClass();

    // Assert
    assertNull(actualProgramClass.u2interfaces);
    assertNull(actualProgramClass.fields);
    assertNull(actualProgramClass.methods);
    assertNull(actualProgramClass.attributes);
    assertNull(actualProgramClass.constantPool);
    assertNull(actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.getSuperName());
    assertNull(actualProgramClass.getFeatureName());
    assertNull(actualProgramClass.getSuperClass());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(0, actualProgramClass.getAccessFlags());
    assertEquals(0, actualProgramClass.getInterfaceCount());
    assertEquals(0, actualProgramClass.getProcessingFlags());
    assertEquals(0, actualProgramClass.subClasses.length);
    assertEquals(0, actualProgramClass.subClassCount);
    assertEquals(0, actualProgramClass.u2attributesCount);
    assertEquals(0, actualProgramClass.u2constantPoolCount);
    assertEquals(0, actualProgramClass.u2fieldsCount);
    assertEquals(0, actualProgramClass.u2methodsCount);
    assertEquals(0, actualProgramClass.u2superClass);
    assertEquals(0, actualProgramClass.u2thisClass);
    assertEquals(0, actualProgramClass.u4version);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
  }

  /**
   * Test {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int)}.
   *
   * <p>Method under test: {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int)}
   */
  @Test
  @DisplayName("Test new ProgramClass(int, int, Constant[], int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.<init>(int, int, proguard.classfile.constant.Constant[], int, int, int)"
  })
  void testNewProgramClass2() {
    // Arrange and Act
    ProgramClass actualProgramClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Assert
    assertNull(actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.getFeatureName());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(0, actualProgramClass.getInterfaceCount());
    assertEquals(0, actualProgramClass.getProcessingFlags());
    assertEquals(0, actualProgramClass.attributes.length);
    assertEquals(0, actualProgramClass.fields.length);
    assertEquals(0, actualProgramClass.methods.length);
    assertEquals(0, actualProgramClass.subClasses.length);
    assertEquals(0, actualProgramClass.subClassCount);
    assertEquals(0, actualProgramClass.u2attributesCount);
    assertEquals(0, actualProgramClass.u2fieldsCount);
    assertEquals(0, actualProgramClass.u2methodsCount);
    assertEquals(1, actualProgramClass.getAccessFlags());
    assertEquals(1, actualProgramClass.constantPool.length);
    assertEquals(1, actualProgramClass.u2superClass);
    assertEquals(1, actualProgramClass.u2thisClass);
    assertEquals(1, actualProgramClass.u4version);
    assertEquals(3, actualProgramClass.u2constantPoolCount);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new int[] {}, actualProgramClass.u2interfaces);
  }

  /**
   * Test {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int, int, int[], int,
   * ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[])}.
   *
   * <p>Method under test: {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int,
   * int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test new ProgramClass(int, int, Constant[], int, int, int, int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.<init>(int, int, proguard.classfile.constant.Constant[], int, int, int, int, int[], int, proguard.classfile.ProgramField[], int, proguard.classfile.ProgramMethod[], int, proguard.classfile.attribute.Attribute[], int, proguard.classfile.Clazz[])"
  })
  void testNewProgramClass3() {
    // Arrange and Act
    ProgramClass actualProgramClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {new ClassConstant()},
            1,
            1,
            1,
            3,
            new int[] {1, 0, 1, 0},
            3,
            new ProgramField[] {new ProgramField()},
            3,
            new ProgramMethod[] {new ProgramMethod()},
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            3,
            new Clazz[] {new LibraryClass()});

    // Assert
    assertNull(actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.getFeatureName());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(0, actualProgramClass.getProcessingFlags());
    assertEquals(1, actualProgramClass.getAccessFlags());
    assertEquals(1, actualProgramClass.attributes.length);
    assertEquals(1, actualProgramClass.constantPool.length);
    assertEquals(1, actualProgramClass.fields.length);
    assertEquals(1, actualProgramClass.methods.length);
    assertEquals(1, actualProgramClass.subClasses.length);
    assertEquals(1, actualProgramClass.u2superClass);
    assertEquals(1, actualProgramClass.u2thisClass);
    assertEquals(1, actualProgramClass.u4version);
    assertEquals(3, actualProgramClass.getInterfaceCount());
    assertEquals(3, actualProgramClass.subClassCount);
    assertEquals(3, actualProgramClass.u2attributesCount);
    assertEquals(3, actualProgramClass.u2constantPoolCount);
    assertEquals(3, actualProgramClass.u2fieldsCount);
    assertEquals(3, actualProgramClass.u2methodsCount);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new int[] {1, 0, 1, 0}, actualProgramClass.u2interfaces);
  }

  /**
   * Test {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int, int, int[], int,
   * ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[], String, int, Object)}.
   *
   * <p>Method under test: {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int,
   * int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[], String,
   * int, Object)}
   */
  @Test
  @DisplayName(
      "Test new ProgramClass(int, int, Constant[], int, int, int, int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[], String, int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.<init>(int, int, proguard.classfile.constant.Constant[], int, int, int, int, int[], int, proguard.classfile.ProgramField[], int, proguard.classfile.ProgramMethod[], int, proguard.classfile.attribute.Attribute[], int, proguard.classfile.Clazz[], java.lang.String, int, java.lang.Object)"
  })
  void testNewProgramClass4() {
    // Arrange and Act
    ProgramClass actualProgramClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {new ClassConstant()},
            1,
            1,
            1,
            3,
            new int[] {1, 0, 1, 0},
            3,
            new ProgramField[] {new ProgramField()},
            3,
            new ProgramMethod[] {new ProgramMethod()},
            3,
            new Attribute[] {new BootstrapMethodsAttribute()},
            3,
            new Clazz[] {new LibraryClass()},
            "Feature Name",
            1,
            "Processing Info");

    // Assert
    assertEquals("Feature Name", actualProgramClass.getFeatureName());
    assertEquals("Processing Info", actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(1, actualProgramClass.getAccessFlags());
    assertEquals(1, actualProgramClass.getProcessingFlags());
    assertEquals(1, actualProgramClass.attributes.length);
    assertEquals(1, actualProgramClass.constantPool.length);
    assertEquals(1, actualProgramClass.fields.length);
    assertEquals(1, actualProgramClass.methods.length);
    assertEquals(1, actualProgramClass.subClasses.length);
    assertEquals(1, actualProgramClass.u2superClass);
    assertEquals(1, actualProgramClass.u2thisClass);
    assertEquals(1, actualProgramClass.u4version);
    assertEquals(3, actualProgramClass.getInterfaceCount());
    assertEquals(3, actualProgramClass.subClassCount);
    assertEquals(3, actualProgramClass.u2attributesCount);
    assertEquals(3, actualProgramClass.u2constantPoolCount);
    assertEquals(3, actualProgramClass.u2fieldsCount);
    assertEquals(3, actualProgramClass.u2methodsCount);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new int[] {1, 0, 1, 0}, actualProgramClass.u2interfaces);
  }

  /**
   * Test {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int, String, int,
   * Object)}.
   *
   * <p>Method under test: {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int,
   * String, int, Object)}
   */
  @Test
  @DisplayName("Test new ProgramClass(int, int, Constant[], int, int, int, String, int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.<init>(int, int, proguard.classfile.constant.Constant[], int, int, int, java.lang.String, int, java.lang.Object)"
  })
  void testNewProgramClass5() {
    // Arrange and Act
    ProgramClass actualProgramClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {new ClassConstant()},
            1,
            1,
            1,
            "Feature Name",
            1,
            "Processing Info");

    // Assert
    assertEquals("Feature Name", actualProgramClass.getFeatureName());
    assertEquals("Processing Info", actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(0, actualProgramClass.getInterfaceCount());
    assertEquals(0, actualProgramClass.attributes.length);
    assertEquals(0, actualProgramClass.fields.length);
    assertEquals(0, actualProgramClass.methods.length);
    assertEquals(0, actualProgramClass.subClasses.length);
    assertEquals(0, actualProgramClass.subClassCount);
    assertEquals(0, actualProgramClass.u2attributesCount);
    assertEquals(0, actualProgramClass.u2fieldsCount);
    assertEquals(0, actualProgramClass.u2methodsCount);
    assertEquals(1, actualProgramClass.getAccessFlags());
    assertEquals(1, actualProgramClass.getProcessingFlags());
    assertEquals(1, actualProgramClass.constantPool.length);
    assertEquals(1, actualProgramClass.u2superClass);
    assertEquals(1, actualProgramClass.u2thisClass);
    assertEquals(1, actualProgramClass.u4version);
    assertEquals(3, actualProgramClass.u2constantPoolCount);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new int[] {}, actualProgramClass.u2interfaces);
  }

  /**
   * Test {@link ProgramClass#getConstant(int)}.
   *
   * <ul>
   *   <li>Then return {@link ClassConstant#ClassConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getConstant(int)}
   */
  @Test
  @DisplayName("Test getConstant(int); then return ClassConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.constant.Constant proguard.classfile.ProgramClass.getConstant(int)"
  })
  void testGetConstant_thenReturnClassConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertSame(
        classConstant2,
        (new ProgramClass(1, 3, new Constant[] {classConstant, classConstant2}, 1, 1, 1))
            .getConstant(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProgramClass#getAccessFlags()}
   *   <li>{@link ProgramClass#getInterfaceCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.ProgramClass.getAccessFlags()",
    "int proguard.classfile.ProgramClass.getInterfaceCount()",
    "java.lang.String proguard.classfile.ProgramClass.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act
    int actualAccessFlags = programClass.getAccessFlags();

    // Assert
    assertEquals(0, actualAccessFlags);
    assertEquals(0, programClass.getInterfaceCount());
  }

  /**
   * Test {@link ProgramClass#getName()}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant} {@link ClassConstant#getName(Clazz)} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given ClassConstant getName(Clazz) return 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getName()"})
  void testGetName_givenClassConstantGetNameReturnName_thenReturnName() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    String actualName =
        (new ProgramClass(1, 3, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1))
            .getName();

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link ProgramClass#getSuperName()}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getSuperName()}
   */
  @Test
  @DisplayName("Test getSuperName(); given ProgramClass(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getSuperName()"})
  void testGetSuperName_givenProgramClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).getSuperName());
  }

  /**
   * Test {@link ProgramClass#getTag(int)}.
   *
   * <ul>
   *   <li>Then return seven.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getTag(int)}
   */
  @Test
  @DisplayName("Test getTag(int); then return seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.ProgramClass.getTag(int)"})
  void testGetTag_thenReturnSeven() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(
        7,
        (new ProgramClass(1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1))
            .getTag(1));
  }

  /**
   * Test {@link ProgramClass#getTag(int)}.
   *
   * <ul>
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getTag(int)}
   */
  @Test
  @DisplayName("Test getTag(int); then return six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.ProgramClass.getTag(int)"})
  void testGetTag_thenReturnSix() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(
        6,
        (new ProgramClass(1, 3, new Constant[] {classConstant, new DoubleConstant(10.0d)}, 1, 1, 1))
            .getTag(1));
  }

  /**
   * Test {@link ProgramClass#getRefClassName(int)}.
   *
   * <ul>
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getRefClassName(int)}
   */
  @Test
  @DisplayName("Test getRefClassName(int); then return 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getRefClassName(int)"})
  void testGetRefClassName_thenReturnClassName() {
    // Arrange
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    when(fieldrefConstant.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act
    String actualRefClassName =
        (new ProgramClass(
                1, 3, new Constant[] {mock(ClassConstant.class), fieldrefConstant}, 1, 1, 1))
            .getRefClassName(1);

    // Assert
    verify(fieldrefConstant).getClassName(isA(Clazz.class));
    assertEquals("Class Name", actualRefClassName);
  }

  /**
   * Test {@link ProgramClass#getRefClassName(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getRefClassName(int)}
   */
  @Test
  @DisplayName("Test getRefClassName(int); then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getRefClassName(int)"})
  void testGetRefClassName_thenReturnName() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    String actualRefClassName =
        (new ProgramClass(1, 3, new Constant[] {classConstant, new FieldrefConstant()}, 1, 1, 1))
            .getRefClassName(1);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    assertEquals("Name", actualRefClassName);
  }

  /**
   * Test {@link ProgramClass#getRefName(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getRefName(int)}
   */
  @Test
  @DisplayName("Test getRefName(int); then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getRefName(int)"})
  void testGetRefName_thenReturnName() {
    // Arrange
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    doNothing().when(fieldrefConstant).addProcessingFlags((int[]) Mockito.any());
    fieldrefConstant.addProcessingFlags(2, 1, 2, 1);
    FieldrefConstant fieldrefConstant2 = mock(FieldrefConstant.class);
    when(fieldrefConstant2.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    String actualRefName =
        (new ProgramClass(1, 3, new Constant[] {fieldrefConstant, fieldrefConstant2}, 1, 1, 1))
            .getRefName(1);

    // Assert
    verify(fieldrefConstant2).getName(isA(Clazz.class));
    verify(fieldrefConstant).addProcessingFlags((int[]) Mockito.any());
    assertEquals("Name", actualRefName);
  }

  /**
   * Test {@link ProgramClass#getRefType(int)}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getRefType(int)}
   */
  @Test
  @DisplayName("Test getRefType(int); then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getRefType(int)"})
  void testGetRefType_thenReturnType() {
    // Arrange
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    doNothing().when(fieldrefConstant).addProcessingFlags((int[]) Mockito.any());
    fieldrefConstant.addProcessingFlags(2, 1, 2, 1);
    FieldrefConstant fieldrefConstant2 = mock(FieldrefConstant.class);
    when(fieldrefConstant2.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    String actualRefType =
        (new ProgramClass(1, 3, new Constant[] {fieldrefConstant, fieldrefConstant2}, 1, 1, 1))
            .getRefType(1);

    // Assert
    verify(fieldrefConstant2).getType(isA(Clazz.class));
    verify(fieldrefConstant).addProcessingFlags((int[]) Mockito.any());
    assertEquals("Type", actualRefType);
  }

  /**
   * Test {@link ProgramClass#getClassName(int)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant} {@link ClassConstant#getName(Clazz)} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getClassName(int)}
   */
  @Test
  @DisplayName(
      "Test getClassName(int); given ClassConstant getName(Clazz) return 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.ProgramClass.getClassName(int)"})
  void testGetClassName_givenClassConstantGetNameReturnName_thenReturnName() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    String actualClassName =
        (new ProgramClass(1, 3, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1))
            .getClassName(1);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    assertEquals("Name", actualClassName);
  }

  /**
   * Test {@link ProgramClass#addSubClass(Clazz)}.
   *
   * <p>Method under test: {@link ProgramClass#addSubClass(Clazz)}
   */
  @Test
  @DisplayName("Test addSubClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.ProgramClass.addSubClass(proguard.classfile.Clazz)"})
  void testAddSubClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    LibraryClass clazz = new LibraryClass();

    // Act
    programClass.addSubClass(clazz);

    // Assert
    Clazz[] clazzArray = programClass.subClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, programClass.subClassCount);
    assertSame(clazz, clazzArray[0]);
  }

  /**
   * Test {@link ProgramClass#getSuperClass()}.
   *
   * <p>Method under test: {@link ProgramClass#getSuperClass()}
   */
  @Test
  @DisplayName("Test getSuperClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.classfile.Clazz proguard.classfile.ProgramClass.getSuperClass()"})
  void testGetSuperClass() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertNull(
        (new ProgramClass(1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1))
            .getSuperClass());
  }

  /**
   * Test {@link ProgramClass#getSuperClass()}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#getSuperClass()}
   */
  @Test
  @DisplayName("Test getSuperClass(); given ProgramClass(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.classfile.Clazz proguard.classfile.ProgramClass.getSuperClass()"})
  void testGetSuperClass_givenProgramClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).getSuperClass());
  }

  /**
   * Test {@link ProgramClass#extends_(String)} with {@code className}.
   *
   * <ul>
   *   <li>Given {@link NamedClass#NamedClass(String)} with {@code Member Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#extends_(String)}
   */
  @Test
  @DisplayName(
      "Test extends_(String) with 'className'; given NamedClass(String) with 'Member Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ProgramClass.extends_(java.lang.String)"})
  void testExtends_WithClassName_givenNamedClassWithMemberName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NamedClass("Member Name")).extends_("Class Name"));
  }

  /**
   * Test {@link ProgramClass#extends_(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#extends_(String)}
   */
  @Test
  @DisplayName("Test extends_(String) with 'className'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ProgramClass.extends_(java.lang.String)"})
  void testExtends_WithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NamedClass("Class Name")).extends_("Class Name"));
  }

  /**
   * Test {@link ProgramClass#extends_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  @DisplayName("Test extends_(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ProgramClass.extends_(proguard.classfile.Clazz)"})
  void testExtends_WithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertFalse(programClass.extends_(new LibraryClass()));
  }

  /**
   * Test {@link ProgramClass#extends_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  @DisplayName("Test extends_(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ProgramClass.extends_(proguard.classfile.Clazz)"})
  void testExtends_WithClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new LibraryClass())},
            1,
            1,
            1);

    // Act and Assert
    assertFalse(programClass.extends_(new LibraryClass()));
  }

  /**
   * Test {@link ProgramClass#extends_(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  @DisplayName("Test extends_(Clazz) with 'clazz'; given ProgramClass(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.ProgramClass.extends_(proguard.classfile.Clazz)"})
  void testExtends_WithClazz_givenProgramClass_thenReturnFalse() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(programClass.extends_(new LibraryClass()));
  }

  /**
   * Test {@link ProgramClass#extendsOrImplements(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#extendsOrImplements(String)}
   */
  @Test
  @DisplayName("Test extendsOrImplements(String) with 'className'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.extendsOrImplements(java.lang.String)"
  })
  void testExtendsOrImplementsWithClassName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NamedClass("Member Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Test {@link ProgramClass#extendsOrImplements(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#extendsOrImplements(String)}
   */
  @Test
  @DisplayName("Test extendsOrImplements(String) with 'className'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.extendsOrImplements(java.lang.String)"
  })
  void testExtendsOrImplementsWithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NamedClass("Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Test {@link ProgramClass#extendsOrImplements(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  @DisplayName("Test extendsOrImplements(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.extendsOrImplements(proguard.classfile.Clazz)"
  })
  void testExtendsOrImplementsWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertFalse(programClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Test {@link ProgramClass#extendsOrImplements(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  @DisplayName("Test extendsOrImplements(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.extendsOrImplements(proguard.classfile.Clazz)"
  })
  void testExtendsOrImplementsWithClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new LibraryClass())},
            1,
            1,
            1);

    // Act and Assert
    assertFalse(programClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Test {@link ProgramClass#extendsOrImplements(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  @DisplayName(
      "Test extendsOrImplements(Clazz) with 'clazz'; given ProgramClass(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.extendsOrImplements(proguard.classfile.Clazz)"
  })
  void testExtendsOrImplementsWithClazz_givenProgramClass_thenReturnFalse() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(programClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Test {@link ProgramClass#findField(String, String)}.
   *
   * <p>Method under test: {@link ProgramClass#findField(String, String)}
   */
  @Test
  @DisplayName("Test findField(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.ProgramClass.findField(java.lang.String, java.lang.String)"
  })
  void testFindField() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).findField("Name", "Descriptor"));
  }

  /**
   * Test {@link ProgramClass#findMethod(String, String)}.
   *
   * <p>Method under test: {@link ProgramClass#findMethod(String, String)}
   */
  @Test
  @DisplayName("Test findMethod(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.ProgramClass.findMethod(java.lang.String, java.lang.String)"
  })
  void testFindMethod() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).findMethod("Name", "Descriptor"));
  }

  /**
   * Test {@link ProgramClass#accept(ClassVisitor)}.
   *
   * <p>Method under test: {@link ProgramClass#accept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.accept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testAccept() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.accept(classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName("Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1);
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, false, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName("Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new LibraryClass())},
            1,
            1,
            1);
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, false, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName("Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new ProgramClass())},
            1,
            1,
            1);
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, false, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName("Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {classConstant, new ClassConstant(1, new LibraryClass())},
            1,
            1,
            1);
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()} addSubClass {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given ProgramClass() addSubClass LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenProgramClassAddSubClassLibraryClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()} addSubClass {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given ProgramClass() addSubClass LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenProgramClassAddSubClassLibraryClass2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, false, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()} addSubClass {@link
   *       ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given ProgramClass() addSubClass ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenProgramClassAddSubClassProgramClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.addSubClass(new ProgramClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor, atLeast(1)).visitProgramClass(Mockito.<ProgramClass>any());
  }

  /**
   * Test {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given ProgramClass(); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenProgramClass_thenCallsVisitProgramClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#subclassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#subclassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test subclassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.subclassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSubclassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    programClass.subclassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ProgramClass#subclassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#subclassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test subclassesAccept(ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.subclassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSubclassesAccept_thenCallsVisitProgramClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.addSubClass(new ProgramClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    programClass.subclassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ProgramClass#constantPoolEntriesAccept(ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#constantPoolEntriesAccept(ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test constantPoolEntriesAccept(ConstantVisitor); then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.constantPoolEntriesAccept(proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testConstantPoolEntriesAccept_thenCallsAccept() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1);
    programClass.u2constantPoolCount = 2;

    // Act
    programClass.constantPoolEntriesAccept(new ConstantLookupVisitor());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test constantPoolEntryAccept(int, ConstantVisitor); given ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.constantPoolEntryAccept(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testConstantPoolEntryAccept_givenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1);

    // Act
    programClass.constantPoolEntryAccept(1, new ConstantLookupVisitor());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test constantPoolEntryAccept(int, ConstantVisitor); then calls visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.constantPoolEntryAccept(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testConstantPoolEntryAccept_thenCallsVisitClassConstant() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {new ClassConstant(), mock(ClassConstant.class)}, 1, 1, 1);
    ConstantVisitor constantVisitor = mock(ConstantVisitor.class);
    doNothing()
        .when(constantVisitor)
        .visitClassConstant(Mockito.<Clazz>any(), Mockito.<ClassConstant>any());

    // Act
    programClass.constantPoolEntryAccept(0, constantVisitor);

    // Assert
    verify(constantVisitor).visitClassConstant(isA(Clazz.class), isA(ClassConstant.class));
  }

  /**
   * Test {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitModuleConstant(Clazz, ModuleConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test constantPoolEntryAccept(int, ConstantVisitor); then calls visitModuleConstant(Clazz, ModuleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.constantPoolEntryAccept(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testConstantPoolEntryAccept_thenCallsVisitModuleConstant() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {new ModuleConstant(), mock(ClassConstant.class)}, 1, 1, 1);
    ConstantVisitor constantVisitor = mock(ConstantVisitor.class);
    doNothing()
        .when(constantVisitor)
        .visitModuleConstant(Mockito.<Clazz>any(), Mockito.<ModuleConstant>any());

    // Act
    programClass.constantPoolEntryAccept(0, constantVisitor);

    // Assert
    verify(constantVisitor).visitModuleConstant(isA(Clazz.class), isA(ModuleConstant.class));
  }

  /**
   * Test {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link ConstantCounter} (default constructor).
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test constantPoolEntryAccept(int, ConstantVisitor); when ConstantCounter (default constructor); then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.constantPoolEntryAccept(int, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testConstantPoolEntryAccept_whenConstantCounter_thenConstantCounterCountIsOne() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {new ClassConstant(), mock(ClassConstant.class)}, 1, 1, 1);
    ConstantCounter constantVisitor = new ConstantCounter();

    // Act
    programClass.constantPoolEntryAccept(0, constantVisitor);

    // Assert
    assertEquals(1, constantVisitor.getCount());
  }

  /**
   * Test {@link ProgramClass#thisClassConstantAccept(ConstantVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#thisClassConstantAccept(ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test thisClassConstantAccept(ConstantVisitor); given ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.thisClassConstantAccept(proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testThisClassConstantAccept_givenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1);

    // Act
    programClass.thisClassConstantAccept(new ConstantLookupVisitor());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ProgramClass#superClassConstantAccept(ConstantVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#superClassConstantAccept(ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test superClassConstantAccept(ConstantVisitor); given ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.superClassConstantAccept(proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testSuperClassConstantAccept_givenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1);

    // Act
    programClass.superClassConstantAccept(new ConstantLookupVisitor());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ProgramClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  @DisplayName("Test mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(
            AccessConstants.FINAL,
            3,
            new Constant[] {new ClassConstant()},
            AccessConstants.FINAL,
            AccessConstants.FINAL,
            AccessConstants.FINAL);

    // Act and Assert
    assertFalse(programClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link ProgramClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  @DisplayName("Test mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(
        programClass.mayHaveImplementations(
            new LibraryMethod(AccessConstants.FINAL, "Name", "Descriptor")));
  }

  /**
   * Test {@link ProgramClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  @DisplayName("Test mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations3() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(
        programClass.mayHaveImplementations(
            new LibraryMethod(1, ClassConstants.METHOD_NAME_INIT, "Descriptor")));
  }

  /**
   * Test {@link ProgramClass#mayHaveImplementations(Method)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  @DisplayName(
      "Test mayHaveImplementations(Method); given ProgramClass(); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations_givenProgramClass_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ProgramClass()).mayHaveImplementations(null));
  }

  /**
   * Test {@link ProgramClass#mayHaveImplementations(Method)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  @DisplayName("Test mayHaveImplementations(Method); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.ProgramClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations_thenReturnTrue() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertTrue(programClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link ProgramClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClass#kotlinMetadataAccept(KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test kotlinMetadataAccept(KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.ProgramClass.kotlinMetadataAccept(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testKotlinMetadataAccept_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    programClass.kotlinMetadataAccept(kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
