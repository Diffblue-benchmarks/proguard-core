package proguard.classfile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.testutils.cpa.NamedClass;

public class ProgramClassDiffblueTest {
  /**
   * Test {@link ProgramClass#ProgramClass()}.
   *
   * <p>Method under test: {@link ProgramClass#ProgramClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClass.<init>()"})
  public void testNewProgramClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClass.<init>(int, int, Constant[], int, int, int)"})
  public void testNewProgramClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClass.<init>(int, int, Constant[], int, int, int, int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[])"
  })
  public void testNewProgramClass3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClass.<init>(int, int, Constant[], int, int, int, int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[], String, int, Object)"
  })
  public void testNewProgramClass4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramClass.<init>(int, int, Constant[], int, int, int, String, int, Object)"
  })
  public void testNewProgramClass5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Constant ProgramClass.getConstant(int)"})
  public void testGetConstant_thenReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int ProgramClass.getAccessFlags()",
    "int ProgramClass.getInterfaceCount()",
    "String ProgramClass.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act
    int actualAccessFlags = programClass.getAccessFlags();

    // Assert
    assertEquals(0, actualAccessFlags);
    assertEquals(0, programClass.getInterfaceCount());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProgramClass.getSuperName()"})
  public void testGetSuperName_givenProgramClass_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ProgramClass.getTag(int)"})
  public void testGetTag_thenReturnSeven() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ProgramClass.getTag(int)"})
  public void testGetTag_thenReturnSix() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(
        6,
        (new ProgramClass(1, 3, new Constant[] {classConstant, new DoubleConstant(10.0d)}, 1, 1, 1))
            .getTag(1));
  }

  /**
   * Test {@link ProgramClass#addSubClass(Clazz)}.
   *
   * <p>Method under test: {@link ProgramClass#addSubClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramClass.addSubClass(Clazz)"})
  public void testAddSubClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz ProgramClass.getSuperClass()"})
  public void testGetSuperClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz ProgramClass.getSuperClass()"})
  public void testGetSuperClass_givenProgramClass_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extends_(String)"})
  public void testExtends_WithClassName_givenNamedClassWithMemberName_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extends_(String)"})
  public void testExtends_WithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NamedClass("Class Name")).extends_("Class Name"));
  }

  /**
   * Test {@link ProgramClass#extends_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extends_(Clazz)"})
  public void testExtends_WithClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extends_(Clazz)"})
  public void testExtends_WithClazz2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extends_(Clazz)"})
  public void testExtends_WithClazz_givenProgramClass_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extendsOrImplements(String)"})
  public void testExtendsOrImplementsWithClassName_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extendsOrImplements(String)"})
  public void testExtendsOrImplementsWithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NamedClass("Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Test {@link ProgramClass#extendsOrImplements(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extendsOrImplements(Clazz)"})
  public void testExtendsOrImplementsWithClazz() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extendsOrImplements(Clazz)"})
  public void testExtendsOrImplementsWithClazz2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.extendsOrImplements(Clazz)"})
  public void testExtendsOrImplementsWithClazz_givenProgramClass_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.Field ProgramClass.findField(String, String)"})
  public void testFindField() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).findField("Name", "Descriptor"));
  }

  /**
   * Test {@link ProgramClass#findMethod(String, String)}.
   *
   * <p>Method under test: {@link ProgramClass#findMethod(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method ProgramClass.findMethod(String, String)"})
  public void testFindMethod() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).findMethod("Name", "Descriptor"));
  }

  /**
   * Test {@link ProgramClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations_givenProgramClass_whenNull_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations_thenReturnTrue() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertTrue(programClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }
}
