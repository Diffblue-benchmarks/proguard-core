package proguard.classfile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.testutils.cpa.NamedClass;

public class ProgramClassDiffblueTest {
  /**
   * Method under test: {@link ProgramClass#getConstant(int)}
   */
  @Test
  public void testGetConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertSame(classConstant2,
        (new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2}, 1, 1, 1)).getConstant(1));
  }

  /**
   * Method under test: {@link ProgramClass#getSuperName()}
   */
  @Test
  public void testGetSuperName() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).getSuperName());
  }

  /**
   * Method under test: {@link ProgramClass#getTag(int)}
   */
  @Test
  public void testGetTag() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(7, (new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1)).getTag(1));
  }

  /**
   * Method under test: {@link ProgramClass#getTag(int)}
   */
  @Test
  public void testGetTag2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(6,
        (new ProgramClass(1, 3, new Constant[]{classConstant, new DoubleConstant(10.0d)}, 1, 1, 1)).getTag(1));
  }

  /**
   * Method under test: {@link ProgramClass#addSubClass(Clazz)}
   */
  @Test
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
   * Method under test: {@link ProgramClass#getSuperClass()}
   */
  @Test
  public void testGetSuperClass() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).getSuperClass());
  }

  /**
   * Method under test: {@link ProgramClass#getSuperClass()}
   */
  @Test
  public void testGetSuperClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertNull((new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1)).getSuperClass());
  }

  /**
   * Method under test: {@link ProgramClass#extends_(String)}
   */
  @Test
  public void testExtends_() {
    // Arrange, Act and Assert
    assertFalse((new NamedClass("Member Name")).extends_("Class Name"));
    assertTrue((new NamedClass("Class Name")).extends_("Class Name"));
  }

  /**
   * Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  public void testExtends_2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(programClass.extends_(new LibraryClass()));
  }

  /**
   * Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  public void testExtends_3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertFalse(programClass.extends_(new LibraryClass()));
  }

  /**
   * Method under test: {@link ProgramClass#extends_(Clazz)}
   */
  @Test
  public void testExtends_4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, new ClassConstant(1, new LibraryClass())}, 1, 1, 1);

    // Act and Assert
    assertFalse(programClass.extends_(new LibraryClass()));
  }

  /**
   * Method under test: {@link ProgramClass#extendsOrImplements(String)}
   */
  @Test
  public void testExtendsOrImplements() {
    // Arrange, Act and Assert
    assertFalse((new NamedClass("Member Name")).extendsOrImplements("Class Name"));
    assertTrue((new NamedClass("Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  public void testExtendsOrImplements2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(programClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  public void testExtendsOrImplements3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertFalse(programClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Method under test: {@link ProgramClass#extendsOrImplements(Clazz)}
   */
  @Test
  public void testExtendsOrImplements4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, new ClassConstant(1, new LibraryClass())}, 1, 1, 1);

    // Act and Assert
    assertFalse(programClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Method under test: {@link ProgramClass#findField(String, String)}
   */
  @Test
  public void testFindField() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).findField("Name", "Descriptor"));
  }

  /**
   * Method under test: {@link ProgramClass#findMethod(String, String)}
   */
  @Test
  public void testFindMethod() {
    // Arrange, Act and Assert
    assertNull((new ProgramClass()).findMethod("Name", "Descriptor"));
  }

  /**
   * Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertTrue(programClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations2() {
    // Arrange, Act and Assert
    assertTrue((new ProgramClass()).mayHaveImplementations(null));
  }

  /**
   * Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations3() {
    // Arrange
    ProgramClass programClass = new ProgramClass(AccessConstants.FINAL, 3, new Constant[]{new ClassConstant()},
        AccessConstants.FINAL, AccessConstants.FINAL, AccessConstants.FINAL);

    // Act and Assert
    assertFalse(programClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations4() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(programClass.mayHaveImplementations(new LibraryMethod(AccessConstants.FINAL, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link ProgramClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations5() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertFalse(
        programClass.mayHaveImplementations(new LibraryMethod(1, ClassConstants.METHOD_NAME_INIT, "Descriptor")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProgramClass#getAccessFlags()}
   *   <li>{@link ProgramClass#getInterfaceCount()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link ProgramClass#ProgramClass()}
   */
  @Test
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
   * Method under test:
   * {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int)}
   */
  @Test
  public void testNewProgramClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act
    ProgramClass actualProgramClass = new ProgramClass(1, 3, new Constant[]{classConstant}, 1, 1, 1);

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
    assertEquals(0, actualProgramClass.u2interfaces.length);
    assertEquals(0, actualProgramClass.subClassCount);
    assertEquals(0, actualProgramClass.u2attributesCount);
    assertEquals(0, actualProgramClass.u2fieldsCount);
    assertEquals(0, actualProgramClass.u2methodsCount);
    assertEquals(1, actualProgramClass.getAccessFlags());
    Constant[] constantArray = actualProgramClass.constantPool;
    assertEquals(1, constantArray.length);
    assertEquals(1, actualProgramClass.u2superClass);
    assertEquals(1, actualProgramClass.u2thisClass);
    assertEquals(1, actualProgramClass.u4version);
    assertEquals(3, actualProgramClass.u2constantPoolCount);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
    assertSame(classConstant, constantArray[0]);
  }

  /**
   * Method under test:
   * {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int, int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[])}
   */
  @Test
  public void testNewProgramClass3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramField programField = new ProgramField();
    ProgramMethod programMethod = new ProgramMethod();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramClass actualProgramClass = new ProgramClass(1, 3, new Constant[]{classConstant}, 1, 1, 1, 3,
        new int[]{1, 0, 1, 0}, 3, new ProgramField[]{programField}, 3, new ProgramMethod[]{programMethod}, 3,
        new Attribute[]{bootstrapMethodsAttribute}, 3, new Clazz[]{libraryClass});

    // Assert
    assertNull(actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.getFeatureName());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(0, actualProgramClass.getProcessingFlags());
    assertEquals(1, actualProgramClass.getAccessFlags());
    Attribute[] attributeArray = actualProgramClass.attributes;
    assertEquals(1, attributeArray.length);
    Constant[] constantArray = actualProgramClass.constantPool;
    assertEquals(1, constantArray.length);
    ProgramField[] programFieldArray = actualProgramClass.fields;
    assertEquals(1, programFieldArray.length);
    ProgramMethod[] programMethodArray = actualProgramClass.methods;
    assertEquals(1, programMethodArray.length);
    Clazz[] clazzArray = actualProgramClass.subClasses;
    assertEquals(1, clazzArray.length);
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
    assertSame(libraryClass, clazzArray[0]);
    assertSame(programField, programFieldArray[0]);
    assertSame(programMethod, programMethodArray[0]);
    assertSame(bootstrapMethodsAttribute, attributeArray[0]);
    assertSame(classConstant, constantArray[0]);
    assertArrayEquals(new int[]{1, 0, 1, 0}, actualProgramClass.u2interfaces);
  }

  /**
   * Method under test:
   * {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int, int, int[], int, ProgramField[], int, ProgramMethod[], int, Attribute[], int, Clazz[], String, int, Object)}
   */
  @Test
  public void testNewProgramClass4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramField programField = new ProgramField();
    ProgramMethod programMethod = new ProgramMethod();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = new BootstrapMethodsAttribute();
    LibraryClass libraryClass = new LibraryClass();

    // Act
    ProgramClass actualProgramClass = new ProgramClass(1, 3, new Constant[]{classConstant}, 1, 1, 1, 3,
        new int[]{1, 0, 1, 0}, 3, new ProgramField[]{programField}, 3, new ProgramMethod[]{programMethod}, 3,
        new Attribute[]{bootstrapMethodsAttribute}, 3, new Clazz[]{libraryClass}, "Feature Name", 1, "Processing Info");

    // Assert
    assertEquals("Feature Name", actualProgramClass.getFeatureName());
    assertEquals("Processing Info", actualProgramClass.getProcessingInfo());
    assertNull(actualProgramClass.kotlinMetadata);
    assertEquals(1, actualProgramClass.getAccessFlags());
    assertEquals(1, actualProgramClass.getProcessingFlags());
    Attribute[] attributeArray = actualProgramClass.attributes;
    assertEquals(1, attributeArray.length);
    Constant[] constantArray = actualProgramClass.constantPool;
    assertEquals(1, constantArray.length);
    ProgramField[] programFieldArray = actualProgramClass.fields;
    assertEquals(1, programFieldArray.length);
    ProgramMethod[] programMethodArray = actualProgramClass.methods;
    assertEquals(1, programMethodArray.length);
    Clazz[] clazzArray = actualProgramClass.subClasses;
    assertEquals(1, clazzArray.length);
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
    assertSame(libraryClass, clazzArray[0]);
    assertSame(programField, programFieldArray[0]);
    assertSame(programMethod, programMethodArray[0]);
    assertSame(bootstrapMethodsAttribute, attributeArray[0]);
    assertSame(classConstant, constantArray[0]);
    assertArrayEquals(new int[]{1, 0, 1, 0}, actualProgramClass.u2interfaces);
  }

  /**
   * Method under test:
   * {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int, String, int, Object)}
   */
  @Test
  public void testNewProgramClass5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act
    ProgramClass actualProgramClass = new ProgramClass(1, 3, new Constant[]{classConstant}, 1, 1, 1, "Feature Name", 1,
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
    assertEquals(0, actualProgramClass.u2interfaces.length);
    assertEquals(0, actualProgramClass.subClassCount);
    assertEquals(0, actualProgramClass.u2attributesCount);
    assertEquals(0, actualProgramClass.u2fieldsCount);
    assertEquals(0, actualProgramClass.u2methodsCount);
    assertEquals(1, actualProgramClass.getAccessFlags());
    assertEquals(1, actualProgramClass.getProcessingFlags());
    Constant[] constantArray = actualProgramClass.constantPool;
    assertEquals(1, constantArray.length);
    assertEquals(1, actualProgramClass.u2superClass);
    assertEquals(1, actualProgramClass.u2thisClass);
    assertEquals(1, actualProgramClass.u4version);
    assertEquals(3, actualProgramClass.u2constantPoolCount);
    assertTrue(actualProgramClass.getExtraFeatureNames().isEmpty());
    assertSame(classConstant, constantArray[0]);
  }
}
