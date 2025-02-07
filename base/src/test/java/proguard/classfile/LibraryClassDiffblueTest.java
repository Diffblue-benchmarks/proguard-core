package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.DominatorCalculator;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.visitor.ClassVisitor;

class LibraryClassDiffblueTest {
  /**
   * Test {@link LibraryClass#LibraryClass()}.
   *
   * <p>Method under test: {@link LibraryClass#LibraryClass()}
   */
  @Test
  @DisplayName("Test new LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.LibraryClass.<init>()"})
  void testNewLibraryClass() {
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
  @DisplayName("Test new LibraryClass(int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.<init>(int, java.lang.String, java.lang.String)"
  })
  void testNewLibraryClass2() {
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
  @DisplayName("Test new LibraryClass(int, String, String, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.<init>(int, java.lang.String, java.lang.String, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testNewLibraryClass3() {
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
  @DisplayName(
      "Test new LibraryClass(int, String, String, String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.<init>(int, java.lang.String, java.lang.String, java.lang.String[], proguard.classfile.Clazz[], int, proguard.classfile.Clazz[], proguard.classfile.LibraryField[], proguard.classfile.LibraryMethod[], proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testNewLibraryClass4() {
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
  @DisplayName("Test isVisible(); given LibraryClass(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.LibraryClass.isVisible()"})
  void testIsVisible_givenLibraryClass_thenReturnFalse() {
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
  @DisplayName("Test isVisible(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.LibraryClass.isVisible()"})
  void testIsVisible_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "This Class Name", "Super Class Name")).isVisible());
  }

  /**
   * Test {@link LibraryClass#getName(int)} with {@code int}.
   *
   * <p>Method under test: {@link LibraryClass#getName(int)}
   */
  @Test
  @DisplayName("Test getName(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getName(int)"})
  void testGetNameWithInt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getName(1));
  }

  /**
   * Test {@link LibraryClass#getType(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getType(int)}
   */
  @Test
  @DisplayName("Test getType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getType(int)"})
  void testGetType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getType(1));
  }

  /**
   * Test {@link LibraryClass#getRefClassName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getRefClassName(int)}
   */
  @Test
  @DisplayName("Test getRefClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getRefClassName(int)"})
  void testGetRefClassName() {
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
  @DisplayName("Test getRefName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getRefName(int)"})
  void testGetRefName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefName(1));
  }

  /**
   * Test {@link LibraryClass#getRefType(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getRefType(int)}
   */
  @Test
  @DisplayName("Test getRefType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getRefType(int)"})
  void testGetRefType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefType(1));
  }

  /**
   * Test {@link LibraryClass#getInterfaceCount()}.
   *
   * <p>Method under test: {@link LibraryClass#getInterfaceCount()}
   */
  @Test
  @DisplayName("Test getInterfaceCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.LibraryClass.getInterfaceCount()"})
  void testGetInterfaceCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new LibraryClass()).getInterfaceCount());
  }

  /**
   * Test {@link LibraryClass#getTag(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getTag(int)}
   */
  @Test
  @DisplayName("Test getTag(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.LibraryClass.getTag(int)"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getTag(1));
  }

  /**
   * Test {@link LibraryClass#getString(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getString(int)}
   */
  @Test
  @DisplayName("Test getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getString(int)"})
  void testGetString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getString(1));
  }

  /**
   * Test {@link LibraryClass#getStringString(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getStringString(int)}
   */
  @Test
  @DisplayName("Test getStringString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getStringString(int)"})
  void testGetStringString() {
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
  @DisplayName("Test getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getClassName(int)"})
  void testGetClassName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getClassName(1));
  }

  /**
   * Test {@link LibraryClass#getModuleName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getModuleName(int)}
   */
  @Test
  @DisplayName("Test getModuleName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getModuleName(int)"})
  void testGetModuleName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getModuleName(1));
  }

  /**
   * Test {@link LibraryClass#getPackageName(int)}.
   *
   * <p>Method under test: {@link LibraryClass#getPackageName(int)}
   */
  @Test
  @DisplayName("Test getPackageName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.LibraryClass.getPackageName(int)"})
  void testGetPackageName() {
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
  @DisplayName("Test extends_(String) with 'className'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.LibraryClass.extends_(java.lang.String)"})
  void testExtends_WithClassName_thenReturnFalse() {
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
  @DisplayName("Test extends_(String) with 'className'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.LibraryClass.extends_(java.lang.String)"})
  void testExtends_WithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "Class Name", "Class Name")).extends_("Class Name"));
  }

  /**
   * Test {@link LibraryClass#extends_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link LibraryClass#extends_(Clazz)}
   */
  @Test
  @DisplayName("Test extends_(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.LibraryClass.extends_(proguard.classfile.Clazz)"})
  void testExtends_WithClazz() {
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
  @DisplayName("Test extendsOrImplements(String) with 'className'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.extendsOrImplements(java.lang.String)"
  })
  void testExtendsOrImplementsWithClassName_thenReturnFalse() {
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
  @DisplayName("Test extendsOrImplements(String) with 'className'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.extendsOrImplements(java.lang.String)"
  })
  void testExtendsOrImplementsWithClassName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "Class Name", "Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Test {@link LibraryClass#extendsOrImplements(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link LibraryClass#extendsOrImplements(Clazz)}
   */
  @Test
  @DisplayName("Test extendsOrImplements(Clazz) with 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.extendsOrImplements(proguard.classfile.Clazz)"
  })
  void testExtendsOrImplementsWithClazz() {
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
  @DisplayName("Test findField(String, String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.LibraryClass.findField(java.lang.String, java.lang.String)"
  })
  void testFindField_thenReturnNull() {
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
  @DisplayName("Test findMethod(String, String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.LibraryClass.findMethod(java.lang.String, java.lang.String)"
  })
  void testFindMethod_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new LibraryClass(1, "This Class Name", "Super Class Name"))
            .findMethod("Name", "Descriptor"));
  }

  /**
   * Test {@link LibraryClass#accept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#accept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(ClassVisitor); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.accept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testAccept_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> libraryClass.accept(classVisitor));
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#accept(ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link ClassVisitor} {@link ClassVisitor#visitLibraryClass(LibraryClass)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#accept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ClassVisitor); when ClassVisitor visitLibraryClass(LibraryClass) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.accept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testAccept_whenClassVisitorVisitLibraryClassDoesNothing() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.accept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName("Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClass = null;
    libraryClass.interfaceClasses = new Clazz[] {new LibraryClass()};
    libraryClass.subClassCount = 0;
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.hierarchyAccept(false, false, true, false, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName("Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClass = null;
    libraryClass.interfaceClasses = new Clazz[] {new ProgramClass()};
    libraryClass.subClassCount = 0;
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    libraryClass.hierarchyAccept(false, false, true, false, classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()} addSubClass {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given LibraryClass() addSubClass LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenLibraryClassAddSubClassLibraryClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()} addSubClass {@link
   *       ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given LibraryClass() addSubClass ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenLibraryClassAddSubClassProgramClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(new ProgramClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given LibraryClass(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenLibraryClass_thenCallsVisitLibraryClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given LibraryClass(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenLibraryClass_thenCallsVisitLibraryClass2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.hierarchyAccept(true, false, true, true, classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()} addSubClass {@link
   *       LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); given ProgramClass() addSubClass LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_givenProgramClassAddSubClassLibraryClass() {
    // Arrange
    ProgramClass clazz = new ProgramClass();
    clazz.addSubClass(new LibraryClass());
    clazz.addSubClass(new LibraryClass());

    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(clazz);
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.hierarchyAccept(true, true, true, true, classVisitor);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.hierarchyAccept(boolean, boolean, boolean, boolean, proguard.classfile.visitor.ClassVisitor)"
  })
  void testHierarchyAccept_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> libraryClass.hierarchyAccept(true, true, true, true, classVisitor));
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#superClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#superClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test superClassAccept(ClassVisitor); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.superClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSuperClassAccept_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> libraryClass.superClassAccept(classVisitor));
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#superClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link ClassVisitor} {@link ClassVisitor#visitLibraryClass(LibraryClass)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#superClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test superClassAccept(ClassVisitor); when ClassVisitor visitLibraryClass(LibraryClass) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.superClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSuperClassAccept_whenClassVisitorVisitLibraryClassDoesNothing() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.superClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.superClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#interfacesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#interfacesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test interfacesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.interfacesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testInterfacesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.interfaceClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.interfacesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#interfacesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#interfacesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test interfacesAccept(ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.interfacesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testInterfacesAccept_thenCallsVisitProgramClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.interfaceClasses = new Clazz[] {new ProgramClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    libraryClass.interfacesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link LibraryClass#subclassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#subclassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test subclassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.subclassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSubclassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(new LibraryClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    libraryClass.subclassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link LibraryClass#subclassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#subclassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test subclassesAccept(ClassVisitor); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.subclassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSubclassesAccept_thenCallsVisitProgramClass() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(new ProgramClass());
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    libraryClass.subclassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link LibraryClass#subclassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#subclassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test subclassesAccept(ClassVisitor); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.subclassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testSubclassesAccept_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(new LibraryClass());
    libraryClass.subClassCount = 1;
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> libraryClass.subclassesAccept(classVisitor));
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.constantPoolEntriesAccept(proguard.classfile.constant.visitor.ConstantVisitor)",
    "void proguard.classfile.LibraryClass.constantPoolEntryAccept(int, proguard.classfile.constant.visitor.ConstantVisitor)",
    "int proguard.classfile.LibraryClass.getAccessFlags()",
    "java.lang.String proguard.classfile.LibraryClass.getName()",
    "proguard.classfile.Clazz proguard.classfile.LibraryClass.getSuperClass()",
    "java.lang.String proguard.classfile.LibraryClass.getSuperName()",
    "void proguard.classfile.LibraryClass.interfaceConstantsAccept(proguard.classfile.constant.visitor.ConstantVisitor)",
    "void proguard.classfile.LibraryClass.superClassConstantAccept(proguard.classfile.constant.visitor.ConstantVisitor)",
    "void proguard.classfile.LibraryClass.thisClassConstantAccept(proguard.classfile.constant.visitor.ConstantVisitor)",
    "java.lang.String proguard.classfile.LibraryClass.toString()"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations() {
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
  @DisplayName("Test mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations2() {
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
  @DisplayName("Test mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations3() {
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
  @DisplayName(
      "Test mayHaveImplementations(Method); given LibraryClass(); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations_givenLibraryClass_whenNull_thenReturnTrue() {
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
  @DisplayName("Test mayHaveImplementations(Method); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations_thenReturnTrue() {
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
  @DisplayName("Test mayHaveImplementations(Method); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.LibraryClass.mayHaveImplementations(proguard.classfile.Method)"
  })
  void testMayHaveImplementations_thenThrowUnsupportedOperationException() {
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
  @DisplayName("Test attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.attributesAccept(proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAttributesAccept() {
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
  @DisplayName("Test attributeAccept(String, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.attributeAccept(java.lang.String, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAttributeAccept() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> libraryClass.attributeAccept("Name", new DominatorCalculator(true)));
  }

  /**
   * Test {@link LibraryClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClass#kotlinMetadataAccept(KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test kotlinMetadataAccept(KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.LibraryClass.kotlinMetadataAccept(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testKotlinMetadataAccept_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    libraryClass.kotlinMetadataAccept(kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
