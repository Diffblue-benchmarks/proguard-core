package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

class LibraryClassBuilderDiffblueTest {
  /**
   * Test {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String)}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String)}
   */
  @Test
  @DisplayName("Test new LibraryClassBuilder(int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.LibraryClassBuilder.<init>(int, java.lang.String, java.lang.String)"
  })
  void testNewLibraryClassBuilder() {
    // Arrange, Act and Assert
    LibraryClass libraryClass =
        (new LibraryClassBuilder(1, "Class Name", "Superclass Name")).getLibraryClass();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.LibraryClassBuilder.<init>(int, java.lang.String, java.lang.String, java.lang.String[], proguard.classfile.Clazz[], int, proguard.classfile.Clazz[], proguard.classfile.LibraryField[], proguard.classfile.LibraryMethod[], proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testNewLibraryClassBuilder2() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};
    Clazz[] interfaceClasses = new Clazz[] {new LibraryClass()};
    Clazz[] subClasses = new Clazz[] {new LibraryClass()};
    LibraryField[] fields = new LibraryField[] {new LibraryField(1, "Name", "Descriptor")};
    LibraryMethod[] methods = new LibraryMethod[] {new LibraryMethod(1, "Name", "Descriptor")};
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act and Assert
    LibraryClass libraryClass =
        (new LibraryClassBuilder(
                1,
                "Class Name",
                "Superclass Name",
                interfaceNames,
                interfaceClasses,
                3,
                subClasses,
                fields,
                methods,
                kotlinMetadata))
            .getLibraryClass();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.LibraryClassBuilder.<init>(proguard.classfile.LibraryClass)"
  })
  void testNewLibraryClassBuilder3() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertSame(libraryClass, (new LibraryClassBuilder(libraryClass)).getLibraryClass());
  }

  /**
   * Test {@link LibraryClassBuilder#getLibraryClass()}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#getLibraryClass()}
   */
  @Test
  @DisplayName("Test getLibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.LibraryClass proguard.classfile.editor.LibraryClassBuilder.getLibraryClass()"
  })
  void testGetLibraryClass() {
    // Arrange and Act
    LibraryClass actualLibraryClass =
        (new LibraryClassBuilder(1, "Class Name", "Superclass Name")).getLibraryClass();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ConstantPoolEditor proguard.classfile.editor.LibraryClassBuilder.getConstantPoolEditor()"
  })
  void testGetConstantPoolEditor_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new LibraryClassBuilder(1, "Class Name", "Superclass Name")).getConstantPoolEditor());
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(Clazz) with 'interfaceClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addInterface(proguard.classfile.Clazz)"
  })
  void testAddInterfaceWithInterfaceClass() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addInterface(new LibraryClass()));
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addInterface(java.lang.String)"
  })
  void testAddInterfaceWithInterfaceName() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addInterface("Interface Name"));
  }

  /**
   * Test {@link LibraryClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link LibraryClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addInterface(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAddInterfaceWithInterfaceNameReferencedInterface() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addInterface("Interface Name", new LibraryClass()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addField(int, java.lang.String, java.lang.String)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder, libraryClassBuilder.addField(2, "Field Name", "Field Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addField(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addField(
            2, "Field Name", "Field Descriptor", new ConstantPoolRemapper()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addField(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor2() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addField(2, "Field Name", "Field Descriptor", new MemberRemover()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addField(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor_whenNull() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addField(2, "Field Name", "Field Descriptor", null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.LibraryField proguard.classfile.editor.LibraryClassBuilder.addAndReturnField(int, java.lang.String, java.lang.String)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addMethod(int, java.lang.String, java.lang.String)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder, libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addMethod(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor", null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addMethod(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor2() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addMethod(
            2, "Method Name", "Method Descriptor", new ConstantPoolRemapper()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.LibraryClassBuilder proguard.classfile.editor.LibraryClassBuilder.addMethod(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor3() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder =
        new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        libraryClassBuilder,
        libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor", new MemberRemover()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.LibraryMethod proguard.classfile.editor.LibraryClassBuilder.addAndReturnMethod(int, java.lang.String, java.lang.String)"
  })
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
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(1, libraryClassBuilder.getLibraryClass().methods.length);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
  }
}
