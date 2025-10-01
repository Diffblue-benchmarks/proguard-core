package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.visitor.MemberVisitor;
import proguard.testutils.cpa.NamedClass;

class LibraryClassBuilderDiffblueTest {
  /**
   * Test {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String)}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String)}
   */
  @Test
  @DisplayName("Test new LibraryClassBuilder(int, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LibraryClassBuilder.<init>(int, String, String)"})
  void testNewLibraryClassBuilder() {
    // Arrange and Act
    LibraryClassBuilder actualLibraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Assert
    LibraryClass libraryClass = actualLibraryClassBuilder.getLibraryClass();
    assertEquals("Class Name", libraryClass.getName());
    assertEquals("Superclass Name", libraryClass.getSuperName());
    assertNull(libraryClass.getProcessingInfo());
    assertNull(libraryClass.getFeatureName());
    assertNull(libraryClass.getSuperClass());
    assertNull(libraryClass.kotlinMetadata);
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.getProcessingFlags());
    assertEquals(0, libraryClass.fields.length);
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, libraryClass.interfaceNames.length);
    assertEquals(0, libraryClass.methods.length);
    assertEquals(0, libraryClass.subClassCount);
    assertEquals(1, libraryClass.getAccessFlags());
    assertTrue(libraryClass.getExtraFeatureNames().isEmpty());
    assertSame(clazzArray, libraryClass.subClasses);
  }

  /**
   * Test {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String, String[], Clazz[],
   * int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String,
   * String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test new LibraryClassBuilder(int, String, String, String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LibraryClassBuilder.<init>(int, String, String, String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)"
  })
  void testNewLibraryClassBuilder2() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    Clazz[] interfaceClasses = new Clazz[] {new LibraryClass()};
    Clazz[] subClasses = new Clazz[] {new LibraryClass()};
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");
    LibraryField[] fields = new LibraryField[] {libraryField};
    LibraryMethod libraryMethod = new LibraryMethod(1, "Name", "Descriptor");
    LibraryMethod[] methods = new LibraryMethod[] {libraryMethod};
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    LibraryClassBuilder actualLibraryClassBuilder =
        new LibraryClassBuilder(
            1,
            "Class Name",
            "Superclass Name",
            interfaceNames,
            interfaceClasses,
            3,
            subClasses,
            fields,
            methods,
            kotlinMetadata);

    // Assert
    LibraryClass libraryClass = actualLibraryClassBuilder.getLibraryClass();
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinClassKindMetadata);
    assertEquals("Class Name", libraryClass.getName());
    assertEquals("Superclass Name", libraryClass.getSuperName());
    assertNull(libraryClass.getProcessingInfo());
    assertNull(libraryClass.getFeatureName());
    assertNull(libraryClass.getSuperClass());
    assertEquals(0, libraryClass.getProcessingFlags());
    assertEquals(1, libraryClass.getAccessFlags());
    assertEquals(1, libraryClass.getInterfaceCount());
    LibraryField[] libraryFieldArray = libraryClass.fields;
    assertEquals(1, libraryFieldArray.length);
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertEquals(1, clazzArray.length);
    LibraryMethod[] libraryMethodArray = libraryClass.methods;
    assertEquals(1, libraryMethodArray.length);
    Clazz[] clazzArray2 = libraryClass.subClasses;
    assertEquals(1, clazzArray2.length);
    assertEquals(3, libraryClass.subClassCount);
    assertTrue(libraryClass.getExtraFeatureNames().isEmpty());
    assertSame(kotlinMetadata, kotlinMetadata2);
    assertSame(interfaceNames, libraryClass.interfaceNames);
    assertSame(interfaceClasses, clazzArray);
    assertSame(subClasses, clazzArray2);
    assertSame(fields, libraryFieldArray);
    assertSame(methods, libraryMethodArray);
  }

  /**
   * Test {@link LibraryClassBuilder#LibraryClassBuilder(LibraryClass)}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#LibraryClassBuilder(LibraryClass)}
   */
  @Test
  @DisplayName("Test new LibraryClassBuilder(LibraryClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LibraryClassBuilder.<init>(LibraryClass)"})
  void testNewLibraryClassBuilder3() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertSame(libraryClass, new LibraryClassBuilder(libraryClass).getLibraryClass());
  }

  /**
   * Test {@link LibraryClassBuilder#getLibraryClass()}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#getLibraryClass()}
   */
  @Test
  @DisplayName("Test getLibraryClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClass LibraryClassBuilder.getLibraryClass()"})
  void testGetLibraryClass() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClass actualLibraryClass = libraryClassBuilder.getLibraryClass();

    // Assert
    assertEquals("Class Name", actualLibraryClass.getName());
    assertEquals("Superclass Name", actualLibraryClass.getSuperName());
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
  }

  /**
   * Test {@link LibraryClassBuilder#getConstantPoolEditor()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClassBuilder#getConstantPoolEditor()}
   */
  @Test
  @DisplayName("Test getConstantPoolEditor(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.editor.ConstantPoolEditor LibraryClassBuilder.getConstantPoolEditor()"
  })
  void testGetConstantPoolEditor_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> libraryClassBuilder.getConstantPoolEditor());
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(Clazz) with 'interfaceClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClassBuilder LibraryClassBuilder.addInterface(Clazz)"})
  void testAddInterfaceWithInterfaceClass() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddInterfaceResult =
        libraryClassBuilder.addInterface(new LibraryClass());

    // Assert
    assertSame(libraryClassBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(Clazz) with 'interfaceClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClassBuilder LibraryClassBuilder.addInterface(Clazz)"})
  void testAddInterfaceWithInterfaceClass2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(libraryClass);

    // Act
    LibraryClassBuilder actualAddInterfaceResult =
        libraryClassBuilder.addInterface(new NamedClass("Member Name"));

    // Assert
    assertSame(libraryClassBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClassBuilder LibraryClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddInterfaceResult =
        libraryClassBuilder.addInterface("Interface Name");

    // Assert
    assertSame(libraryClassBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClassBuilder LibraryClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddInterfaceResult =
        libraryClassBuilder.addInterface("Interface Name", new LibraryClass());

    // Assert
    assertSame(libraryClassBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addField(int, String, String)} with {@code u2accessFlags},
   * {@code fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClassBuilder LibraryClassBuilder.addField(int, String, String)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddFieldResult =
        libraryClassBuilder.addField(2, "Field Name", "Field Descriptor");

    // Assert
    assertSame(libraryClassBuilder, actualAddFieldResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String, MemberVisitor) with 'u2accessFlags', 'fieldName', 'fieldDescriptor', 'extraMemberVisitor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LibraryClassBuilder LibraryClassBuilder.addField(int, String, String, MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddFieldResult =
        libraryClassBuilder.addField(
            2, "Field Name", "Field Descriptor", new ConstantPoolRemapper());

    // Assert
    assertSame(libraryClassBuilder, actualAddFieldResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String, MemberVisitor) with 'u2accessFlags', 'fieldName', 'fieldDescriptor', 'extraMemberVisitor'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LibraryClassBuilder LibraryClassBuilder.addField(int, String, String, MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor_whenNull() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddFieldResult =
        libraryClassBuilder.addField(2, "Field Name", "Field Descriptor", null);

    // Assert
    assertSame(libraryClassBuilder, actualAddFieldResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addAndReturnField(int, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link LibraryMember#descriptor} is {@code Field Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addAndReturnField(int, String, String); then return descriptor is 'Field Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryField LibraryClassBuilder.addAndReturnField(int, String, String)"})
  void testAddAndReturnField_thenReturnDescriptorIsFieldDescriptor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryField actualAddAndReturnFieldResult =
        libraryClassBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    assertEquals("Field Descriptor", actualAddAndReturnFieldResult.descriptor);
    assertEquals("Field Name", actualAddAndReturnFieldResult.name);
    assertNull(actualAddAndReturnFieldResult.getProcessingInfo());
    assertNull(actualAddAndReturnFieldResult.referencedClass);
    assertEquals(0, actualAddAndReturnFieldResult.getProcessingFlags());
    assertEquals(1, libraryClassBuilder.getLibraryClass().fields.length);
    assertEquals(2, actualAddAndReturnFieldResult.getAccessFlags());
  }

  /**
   * Test {@link LibraryClassBuilder#addMethod(int, String, String)} with {@code u2accessFlags},
   * {@code methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String) with 'u2accessFlags', 'methodName', 'methodDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryClassBuilder LibraryClassBuilder.addMethod(int, String, String)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddMethodResult =
        libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertSame(libraryClassBuilder, actualAddMethodResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String, MemberVisitor) with 'u2accessFlags', 'methodName', 'methodDescriptor', 'extraMemberVisitor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LibraryClassBuilder LibraryClassBuilder.addMethod(int, String, String, MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddMethodResult =
        libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor", null);

    // Assert
    assertSame(libraryClassBuilder, actualAddMethodResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String, MemberVisitor) with 'u2accessFlags', 'methodName', 'methodDescriptor', 'extraMemberVisitor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LibraryClassBuilder LibraryClassBuilder.addMethod(int, String, String, MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor2() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryClassBuilder actualAddMethodResult =
        libraryClassBuilder.addMethod(
            2, "Method Name", "Method Descriptor", new ConstantPoolRemapper());

    // Assert
    assertSame(libraryClassBuilder, actualAddMethodResult);
  }

  /**
   * Test {@link LibraryClassBuilder#addAndReturnMethod(int, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link LibraryMember#descriptor} is {@code Method Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addAndReturnMethod(int, String, String); then return descriptor is 'Method Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LibraryMethod LibraryClassBuilder.addAndReturnMethod(int, String, String)"})
  void testAddAndReturnMethod_thenReturnDescriptorIsMethodDescriptor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryMethod actualAddAndReturnMethodResult =
        libraryClassBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertEquals("Method Descriptor", actualAddAndReturnMethodResult.descriptor);
    assertEquals("Method Name", actualAddAndReturnMethodResult.name);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(1, libraryClassBuilder.getLibraryClass().methods.length);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
  }
}
