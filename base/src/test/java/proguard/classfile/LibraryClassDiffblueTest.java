package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.DominatorCalculator;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;

public class LibraryClassDiffblueTest {
  /**
   * Test {@link LibraryClass#LibraryClass()}.
   *
   * <p>Method under test: {@link LibraryClass#LibraryClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClass.<init>()"})
  public void testNewLibraryClass() {
    // Arrange and Act
    LibraryClass actualLibraryClass = new LibraryClass();

    // Assert
    assertNull(actualLibraryClass.interfaceNames);
    assertNull(actualLibraryClass.fields);
    assertNull(actualLibraryClass.methods);
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getName());
    assertNull(actualLibraryClass.getSuperName());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(actualLibraryClass.kotlinMetadata);
    assertEquals(0, actualLibraryClass.getAccessFlags());
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertFalse(actualLibraryClass.isVisible());
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
  }

  /**
   * Test {@link LibraryClass#LibraryClass(int, String, String)}.
   *
   * <p>Method under test: {@link LibraryClass#LibraryClass(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClass.<init>(int, String, String)"})
  public void testNewLibraryClass2() {
    // Arrange and Act
    LibraryClass actualLibraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Assert
    assertEquals("Super Class Name", actualLibraryClass.getSuperName());
    assertEquals("This Class Name", actualLibraryClass.getName());
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(actualLibraryClass.kotlinMetadata);
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, actualLibraryClass.fields.length);
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.interfaceNames.length);
    assertEquals(0, actualLibraryClass.methods.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
    assertTrue(actualLibraryClass.isVisible());
  }

  /**
   * Test {@link LibraryClass#LibraryClass(int, String, String, KotlinMetadata)}.
   *
   * <p>Method under test: {@link LibraryClass#LibraryClass(int, String, String, KotlinMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClass.<init>(int, String, String, KotlinMetadata)"})
  public void testNewLibraryClass3() {
    // Arrange and Act
    LibraryClass actualLibraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    assertTrue(actualLibraryClass.kotlinMetadata instanceof KotlinClassKindMetadata);
    assertEquals("Super Class Name", actualLibraryClass.getSuperName());
    assertEquals("This Class Name", actualLibraryClass.getName());
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, actualLibraryClass.fields.length);
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.interfaceNames.length);
    assertEquals(0, actualLibraryClass.methods.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
    assertTrue(actualLibraryClass.isVisible());
  }

  /**
   * Test {@link LibraryClass#LibraryClass(int, String, String, String[], Clazz[], int, Clazz[],
   * LibraryField[], LibraryMethod[], KotlinMetadata)}.
   *
   * <p>Method under test: {@link LibraryClass#LibraryClass(int, String, String, String[], Clazz[],
   * int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LibraryClass.<init>(int, String, String, String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)"
  })
  public void testNewLibraryClass4() {
    // Arrange and Act
    LibraryClass actualLibraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new String[] {"Interface Names"},
            new Clazz[] {new LibraryClass()},
            3,
            new Clazz[] {new LibraryClass()},
            new LibraryField[] {new LibraryField(1, "Name", "Descriptor")},
            new LibraryMethod[] {new LibraryMethod(1, "Name", "Descriptor")},
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    assertTrue(actualLibraryClass.kotlinMetadata instanceof KotlinClassKindMetadata);
    assertEquals("Super Class Name", actualLibraryClass.getSuperName());
    assertEquals("This Class Name", actualLibraryClass.getName());
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertEquals(1, actualLibraryClass.getInterfaceCount());
    assertEquals(1, actualLibraryClass.fields.length);
    assertEquals(1, actualLibraryClass.interfaceClasses.length);
    assertEquals(1, actualLibraryClass.interfaceNames.length);
    assertEquals(1, actualLibraryClass.methods.length);
    assertEquals(1, actualLibraryClass.subClasses.length);
    assertEquals(3, actualLibraryClass.subClassCount);
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
    assertTrue(actualLibraryClass.isVisible());
  }

  /**
   * Test {@link LibraryClass#isVisible()}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#isVisible()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.isVisible()"})
  public void testIsVisible_givenLibraryClass_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LibraryClass()).isVisible());
  }

  /**
   * Test {@link LibraryClass#isVisible()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#isVisible()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.isVisible()"})
  public void testIsVisible_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "This Class Name", "Super Class Name")).isVisible());
  }

  /**
   * Test {@link LibraryClass#getName(int)} with {@code int}.
   *
   * <p>Method under test: {@link LibraryClass#getName(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getName(int)"})
  public void testGetNameWithInt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getName(1));
  }

  /**
   * Test {@link LibraryClass#getType(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getType(int)"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getType(1));
  }

  /**
   * Test {@link LibraryClass#getRefClassName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getRefClassName(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getRefClassName(int)"})
  public void testGetRefClassName() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> (new LibraryClass()).getRefClassName(1));
  }

  /**
   * Test {@link LibraryClass#getRefName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getRefName(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getRefName(int)"})
  public void testGetRefName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefName(1));
  }

  /**
   * Test {@link LibraryClass#getRefType(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getRefType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getRefType(int)"})
  public void testGetRefType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefType(1));
  }

  /**
   * Test {@link LibraryClass#getInterfaceCount()}.
   *
   * <p>Method under test: {@link LibraryClass#getInterfaceCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LibraryClass.getInterfaceCount()"})
  public void testGetInterfaceCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new LibraryClass()).getInterfaceCount());
  }

  /**
   * Test {@link LibraryClass#getTag(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getTag(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LibraryClass.getTag(int)"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getTag(1));
  }

  /**
   * Test {@link LibraryClass#getString(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getString(int)"})
  public void testGetString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getString(1));
  }

  /**
   * Test {@link LibraryClass#getStringString(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getStringString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getStringString(int)"})
  public void testGetStringString() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> (new LibraryClass()).getStringString(1));
  }

  /**
   * Test {@link LibraryClass#getClassName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getClassName(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getClassName(int)"})
  public void testGetClassName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getClassName(1));
  }

  /**
   * Test {@link LibraryClass#getModuleName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getModuleName(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getModuleName(int)"})
  public void testGetModuleName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getModuleName(1));
  }

  /**
   * Test {@link LibraryClass#getPackageName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getPackageName(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LibraryClass.getPackageName(int)"})
  public void testGetPackageName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getPackageName(1));
  }

  /**
   * Test {@link LibraryClass#extends_(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#extends_(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.extends_(String)"})
  public void testExtends_WithClassName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LibraryClass(1, "This Class Name", "Class Name")).extends_("Class Name"));
  }

  /**
   * Test {@link LibraryClass#extends_(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#extends_(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.extends_(String)"})
  public void testExtends_WithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "Class Name", "Class Name")).extends_("Class Name"));
  }

  /**
   * Test {@link LibraryClass#extends_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link LibraryClass#extends_(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.extends_(Clazz)"})
  public void testExtends_WithClazz() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(libraryClass.extends_(new LibraryClass()));
  }

  /**
   * Test {@link LibraryClass#extendsOrImplements(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#extendsOrImplements(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.extendsOrImplements(String)"})
  public void testExtendsOrImplementsWithClassName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new LibraryClass(1, "This Class Name", "Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Test {@link LibraryClass#extendsOrImplements(String)} with {@code className}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#extendsOrImplements(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.extendsOrImplements(String)"})
  public void testExtendsOrImplementsWithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "Class Name", "Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Test {@link LibraryClass#extendsOrImplements(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link LibraryClass#extendsOrImplements(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.extendsOrImplements(Clazz)"})
  public void testExtendsOrImplementsWithClazz() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(libraryClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Test {@link LibraryClass#findField(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#findField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.Field LibraryClass.findField(String, String)"})
  public void testFindField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new LibraryClass(1, "This Class Name", "Super Class Name"))
            .findField("Name", "Descriptor"));
  }

  /**
   * Test {@link LibraryClass#findMethod(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#findMethod(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method LibraryClass.findMethod(String, String)"})
  public void testFindMethod_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new LibraryClass(1, "This Class Name", "Super Class Name"))
            .findMethod("Name", "Descriptor"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LibraryClass#constantPoolEntriesAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}
   *   <li>{@link LibraryClass#interfaceConstantsAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#superClassConstantAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#thisClassConstantAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#toString()}
   *   <li>{@link LibraryClass#getAccessFlags()}
   *   <li>{@link LibraryClass#getName()}
   *   <li>{@link LibraryClass#getSuperClass()}
   *   <li>{@link LibraryClass#getSuperName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LibraryClass.constantPoolEntriesAccept(ConstantVisitor)",
    "void LibraryClass.constantPoolEntryAccept(int, ConstantVisitor)",
    "int LibraryClass.getAccessFlags()",
    "String LibraryClass.getName()",
    "Clazz LibraryClass.getSuperClass()",
    "String LibraryClass.getSuperName()",
    "void LibraryClass.interfaceConstantsAccept(ConstantVisitor)",
    "void LibraryClass.superClassConstantAccept(ConstantVisitor)",
    "void LibraryClass.thisClassConstantAccept(ConstantVisitor)",
    "String LibraryClass.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    libraryClass.constantPoolEntriesAccept(new ConstantLookupVisitor());
    libraryClass.constantPoolEntryAccept(1, new ConstantLookupVisitor());
    libraryClass.interfaceConstantsAccept(new ConstantLookupVisitor());
    libraryClass.superClassConstantAccept(new ConstantLookupVisitor());
    libraryClass.thisClassConstantAccept(new ConstantLookupVisitor());
    String actualToStringResult = libraryClass.toString();
    int actualAccessFlags = libraryClass.getAccessFlags();
    String actualName = libraryClass.getName();
    Clazz actualSuperClass = libraryClass.getSuperClass();

    // Assert
    assertEquals("LibraryClass(null)", actualToStringResult);
    assertNull(actualName);
    assertNull(libraryClass.getSuperName());
    assertNull(actualSuperClass);
    assertEquals(0, actualAccessFlags);
  }

  /**
   * Test {@link LibraryClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations() {
    // Arrange
    LibraryClass libraryClass =
        new LibraryClass(
            AccessConstants.FINAL,
            ClassConstants.METHOD_NAME_INIT,
            ClassConstants.METHOD_NAME_INIT);

    // Act and Assert
    assertFalse(libraryClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link LibraryClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        libraryClass.mayHaveImplementations(
            new LibraryMethod(AccessConstants.FINAL, "Name", "Descriptor")));
  }

  /**
   * Test {@link LibraryClass#mayHaveImplementations(Method)}.
   *
   * <p>Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations3() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        libraryClass.mayHaveImplementations(
            new LibraryMethod(1, ClassConstants.METHOD_NAME_INIT, "Descriptor")));
  }

  /**
   * Test {@link LibraryClass#mayHaveImplementations(Method)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations_givenLibraryClass_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass()).mayHaveImplementations(null));
  }

  /**
   * Test {@link LibraryClass#mayHaveImplementations(Method)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations_thenReturnTrue() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertTrue(libraryClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link LibraryClass#mayHaveImplementations(Method)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LibraryClass.mayHaveImplementations(Method)"})
  public void testMayHaveImplementations_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> libraryClass.mayHaveImplementations(new ProgramMethod()));
  }

  /**
   * Test {@link LibraryClass#attributesAccept(AttributeVisitor)}.
   *
   * <p>Method under test: {@link LibraryClass#attributesAccept(AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClass.attributesAccept(AttributeVisitor)"})
  public void testAttributesAccept() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> libraryClass.attributesAccept(new DominatorCalculator(true)));
  }

  /**
   * Test {@link LibraryClass#attributeAccept(String, AttributeVisitor)}.
   *
   * <p>Method under test: {@link LibraryClass#attributeAccept(String, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClass.attributeAccept(String, AttributeVisitor)"})
  public void testAttributeAccept() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> libraryClass.attributeAccept("Name", new DominatorCalculator(true)));
  }
}
