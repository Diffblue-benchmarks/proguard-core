package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SignatureDiffblueTest {
  /**
   * Test {@link Signature#of(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then return {@link ClassSignature}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#of(Clazz, Member)}
   */
  @Test
  @DisplayName("Test of(Clazz, Member); then return ClassSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Signature Signature.of(Clazz, Member)"})
  void testOf_thenReturnClassSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    Signature actualOfResult = Signature.of(clazz, null);

    // Assert
    assertTrue(actualOfResult instanceof ClassSignature);
    assertEquals("", actualOfResult.getExternalPackageName());
    assertEquals("", actualOfResult.getPackageName());
    assertEquals("This Class Name", actualOfResult.getClassName());
    assertEquals("This Class Name", actualOfResult.getFqn());
    assertEquals("This Class Name", actualOfResult.getPrettyFqn());
    assertEquals("This Class Name", ((ClassSignature) actualOfResult).fqn);
    assertEquals("This Class Name", ((ClassSignature) actualOfResult).prettyFqn);
    assertEquals(-2060103915, ((ClassSignature) actualOfResult).hashCode);
    assertFalse(actualOfResult.isIncomplete());
  }

  /**
   * Test {@link Signature#of(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then return {@link FieldSignature}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#of(Clazz, Member)}
   */
  @Test
  @DisplayName("Test of(Clazz, Member); then return FieldSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Signature Signature.of(Clazz, Member)"})
  void testOf_thenReturnFieldSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    Signature actualOfResult = Signature.of(clazz, member);

    // Assert
    assertTrue(actualOfResult instanceof FieldSignature);
    assertEquals("Descriptor", ((FieldSignature) actualOfResult).descriptor);
    assertEquals("Lnull;Name", actualOfResult.getFqn());
    assertEquals("Lnull;Name", ((FieldSignature) actualOfResult).fqn);
    assertEquals("Name", ((FieldSignature) actualOfResult).memberName);
    assertNull(((FieldSignature) actualOfResult).prettyFqn);
    assertEquals(1320159907, ((FieldSignature) actualOfResult).hashCode);
    assertTrue(actualOfResult.isIncomplete());
  }

  /**
   * Test {@link Signature#of(Clazz, Member)}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod#LibraryMethod()}.
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#of(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test of(Clazz, Member); when LibraryMethod(); then ReferencedClass return LibraryClass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Signature Signature.of(Clazz, Member)"})
  void testOf_whenLibraryMethod_thenReferencedClassReturnLibraryClass() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod member = new LibraryMethod();

    // Act
    Signature actualOfResult = Signature.of(clazz, member);

    // Assert
    Clazz referencedClass = actualOfResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    Method referencedMethod = ((MethodSignature) actualOfResult).getReferencedMethod();
    assertTrue(referencedMethod instanceof LibraryMethod);
    assertTrue(actualOfResult instanceof MethodSignature);
    assertEquals("? ?.?(?)", actualOfResult.getPrettyFqn());
    assertEquals("? ?.?(?)", ((MethodSignature) actualOfResult).prettyFqn);
    assertEquals("L?;?null", actualOfResult.getFqn());
    assertEquals("L?;?null", ((MethodSignature) actualOfResult).fqn);
    assertNull(((MethodSignature) actualOfResult).getMethodName());
    assertNull(((MethodSignature) actualOfResult).getDescriptor());
    assertEquals(29791, ((MethodSignature) actualOfResult).hashCode);
    assertTrue(actualOfResult.isIncomplete());
    assertSame(clazz, referencedClass);
    assertSame(member, referencedMethod);
  }

  /**
   * Test {@link Signature#computeIfAbsent(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then return {@link ClassSignature}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#computeIfAbsent(Clazz, Member)}
   */
  @Test
  @DisplayName("Test computeIfAbsent(Clazz, Member); then return ClassSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Signature Signature.computeIfAbsent(Clazz, Member)"})
  void testComputeIfAbsent_thenReturnClassSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    Signature actualComputeIfAbsentResult = Signature.computeIfAbsent(clazz, null);

    // Assert
    assertTrue(actualComputeIfAbsentResult instanceof ClassSignature);
    assertEquals("", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("", actualComputeIfAbsentResult.getPackageName());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getClassName());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getPrettyFqn());
    assertEquals("This Class Name", ((ClassSignature) actualComputeIfAbsentResult).fqn);
    assertEquals("This Class Name", ((ClassSignature) actualComputeIfAbsentResult).prettyFqn);
    assertEquals(-2060103915, ((ClassSignature) actualComputeIfAbsentResult).hashCode);
    assertFalse(actualComputeIfAbsentResult.isIncomplete());
  }

  /**
   * Test {@link Signature#computeIfAbsent(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then return {@link FieldSignature}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#computeIfAbsent(Clazz, Member)}
   */
  @Test
  @DisplayName("Test computeIfAbsent(Clazz, Member); then return FieldSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Signature Signature.computeIfAbsent(Clazz, Member)"})
  void testComputeIfAbsent_thenReturnFieldSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    Signature actualComputeIfAbsentResult = Signature.computeIfAbsent(clazz, member);

    // Assert
    assertTrue(actualComputeIfAbsentResult instanceof FieldSignature);
    assertEquals("Descriptor", ((FieldSignature) actualComputeIfAbsentResult).descriptor);
    assertEquals("Lnull;Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("Lnull;Name", ((FieldSignature) actualComputeIfAbsentResult).fqn);
    assertEquals("Name", ((FieldSignature) actualComputeIfAbsentResult).memberName);
    assertNull(((FieldSignature) actualComputeIfAbsentResult).prettyFqn);
    assertEquals(1320159907, ((FieldSignature) actualComputeIfAbsentResult).hashCode);
    assertTrue(actualComputeIfAbsentResult.isIncomplete());
  }

  /**
   * Test {@link Signature#computeIfAbsent(Clazz, Member)}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod#LibraryMethod()}.
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#computeIfAbsent(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test computeIfAbsent(Clazz, Member); when LibraryMethod(); then ReferencedClass return LibraryClass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Signature Signature.computeIfAbsent(Clazz, Member)"})
  void testComputeIfAbsent_whenLibraryMethod_thenReferencedClassReturnLibraryClass() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod member = new LibraryMethod();

    // Act
    Signature actualComputeIfAbsentResult = Signature.computeIfAbsent(clazz, member);

    // Assert
    Clazz referencedClass = actualComputeIfAbsentResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    Method referencedMethod = ((MethodSignature) actualComputeIfAbsentResult).getReferencedMethod();
    assertTrue(referencedMethod instanceof LibraryMethod);
    assertTrue(actualComputeIfAbsentResult instanceof MethodSignature);
    assertEquals("? ?.?(?)", actualComputeIfAbsentResult.getPrettyFqn());
    assertEquals("? ?.?(?)", ((MethodSignature) actualComputeIfAbsentResult).prettyFqn);
    assertEquals("L?;?null", actualComputeIfAbsentResult.getFqn());
    assertEquals("L?;?null", ((MethodSignature) actualComputeIfAbsentResult).fqn);
    assertNull(((MethodSignature) actualComputeIfAbsentResult).getMethodName());
    assertNull(((MethodSignature) actualComputeIfAbsentResult).getDescriptor());
    assertEquals(29791, ((MethodSignature) actualComputeIfAbsentResult).hashCode);
    assertTrue(actualComputeIfAbsentResult.isIncomplete());
    assertSame(clazz, referencedClass);
    assertSame(member, referencedMethod);
  }

  /**
   * Test {@link Signature#getFqn()}.
   *
   * <p>Method under test: {@link Signature#getFqn()}
   */
  @Test
  @DisplayName("Test getFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getFqn()"})
  void testGetFqn() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.getFqn());
  }

  /**
   * Test {@link Signature#getFqn()}.
   *
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getFqn()}
   */
  @Test
  @DisplayName(
      "Test getFqn(); given ClassSignature(String) with 'Class Name'; then return 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getFqn()"})
  void testGetFqn_givenClassSignatureWithClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", new ClassSignature("Class Name").getFqn());
  }

  /**
   * Test {@link Signature#getFqn()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with className is {@code null}.
   *   <li>Then return {@code L?;?null}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getFqn()}
   */
  @Test
  @DisplayName(
      "Test getFqn(); given MethodSignature(String) with className is 'null'; then return 'L?;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getFqn()"})
  void testGetFqn_givenMethodSignatureWithClassNameIsNull_thenReturnLNull() {
    // Arrange, Act and Assert
    assertEquals("L?;?null", new MethodSignature((String) null).getFqn());
  }

  /**
   * Test {@link Signature#getFqn()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code LClass Name;?null}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getFqn()}
   */
  @Test
  @DisplayName(
      "Test getFqn(); given MethodSignature(String) with 'Class Name'; then return 'LClass Name;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getFqn()"})
  void testGetFqn_givenMethodSignatureWithClassName_thenReturnLClassNameNull() {
    // Arrange, Act and Assert
    assertEquals("LClass Name;?null", new MethodSignature("Class Name").getFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName("Test getPrettyFqn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPrettyFqn()"})
  void testGetPrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("? ?.?(?)", new MethodSignature((String) null).getPrettyFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName(
      "Test getPrettyFqn(); given ClassSignature(String) with 'Class Name'; then return 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPrettyFqn()"})
  void testGetPrettyFqn_givenClassSignatureWithClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", new ClassSignature("Class Name").getPrettyFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <ul>
   *   <li>Given {@link ClassConstants#CLASS_GET_NAME_SIGNATURE}.
   *   <li>Then return {@code String Class.getName()}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName(
      "Test getPrettyFqn(); given CLASS_GET_NAME_SIGNATURE; then return 'String Class.getName()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPrettyFqn()"})
  void testGetPrettyFqn_givenClass_get_name_signature_thenReturnStringClassGetName() {
    // Arrange, Act and Assert
    assertEquals("String Class.getName()", ClassConstants.CLASS_GET_NAME_SIGNATURE.getPrettyFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code ? Class Name.?(?)}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName(
      "Test getPrettyFqn(); given MethodSignature(String) with 'Class Name'; then return '? Class Name.?(?)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPrettyFqn()"})
  void testGetPrettyFqn_givenMethodSignatureWithClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("? Class Name.?(?)", new MethodSignature("Class Name").getPrettyFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code Class Class.forName(String,boolean,ClassLoader)}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName("Test getPrettyFqn(); then return 'Class Class.forName(String,boolean,ClassLoader)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPrettyFqn()"})
  void testGetPrettyFqn_thenReturnClassClassForNameStringBooleanClassLoader() {
    // Arrange, Act and Assert
    assertEquals(
        "Class Class.forName(String,boolean,ClassLoader)",
        ClassConstants.CLASS_FOR_NAME_SIGNATURE2.getPrettyFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <ul>
   *   <li>Then return {@code Class ClassLoader.findLoadedClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName("Test getPrettyFqn(); then return 'Class ClassLoader.findLoadedClass(String)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPrettyFqn()"})
  void testGetPrettyFqn_thenReturnClassClassLoaderFindLoadedClassString() {
    // Arrange, Act and Assert
    assertEquals(
        "Class ClassLoader.findLoadedClass(String)",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.getPrettyFqn());
  }

  /**
   * Test {@link Signature#getPackageName()}.
   *
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPackageName()}
   */
  @Test
  @DisplayName(
      "Test getPackageName(); given ClassSignature(String) with 'Class Name'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPackageName()"})
  void testGetPackageName_givenClassSignatureWithClassName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new ClassSignature("Class Name").getPackageName());
  }

  /**
   * Test {@link Signature#getPackageName()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPackageName()}
   */
  @Test
  @DisplayName("Test getPackageName(); given UNKNOWN; then return '?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPackageName()"})
  void testGetPackageName_givenUnknown_thenReturnQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", MethodSignature.UNKNOWN.getPackageName());
  }

  /**
   * Test {@link Signature#getPackageName()}.
   *
   * <ul>
   *   <li>Then return {@code java.lang}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPackageName()}
   */
  @Test
  @DisplayName("Test getPackageName(); then return 'java.lang'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getPackageName()"})
  void testGetPackageName_thenReturnJavaLang() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang", ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.getPackageName());
  }

  /**
   * Test {@link Signature#getExternalPackageName()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#UNKNOWN}.
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getExternalPackageName()}
   */
  @Test
  @DisplayName("Test getExternalPackageName(); given UNKNOWN; then return '?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getExternalPackageName()"})
  void testGetExternalPackageName_givenUnknown_thenReturnQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", MethodSignature.UNKNOWN.getExternalPackageName());
  }

  /**
   * Test {@link Signature#getExternalPackageName()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getExternalPackageName()}
   */
  @Test
  @DisplayName("Test getExternalPackageName(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getExternalPackageName()"})
  void testGetExternalPackageName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new ClassSignature("Class Name").getExternalPackageName());
  }

  /**
   * Test {@link Signature#getExternalPackageName()}.
   *
   * <ul>
   *   <li>Then return {@code java.lang}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getExternalPackageName()}
   */
  @Test
  @DisplayName("Test getExternalPackageName(); then return 'java.lang'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getExternalPackageName()"})
  void testGetExternalPackageName_thenReturnJavaLang() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.getExternalPackageName());
  }

  /**
   * Test {@link Signature#getClassName()}.
   *
   * <p>Method under test: {@link Signature#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.getClassName()"})
  void testGetClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", new ClassSignature("Class Name").getClassName());
  }

  /**
   * Test {@link Signature#getReferencedClass()}.
   *
   * <p>Method under test: {@link Signature#getReferencedClass()}
   */
  @Test
  @DisplayName("Test getReferencedClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Clazz Signature.getReferencedClass()"})
  void testGetReferencedClass() {
    // Arrange, Act and Assert
    assertNull(new ClassSignature("Class Name").getReferencedClass());
  }

  /**
   * Test {@link Signature#equals(Object)}, and {@link Signature#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Signature#equals(Object)}
   *   <li>{@link Signature#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    MethodSignature methodSignature2 = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act and Assert
    assertEquals(methodSignature, methodSignature2);
    assertEquals(methodSignature.hashCode(), methodSignature2.hashCode());
  }

  /**
   * Test {@link Signature#equals(Object)}, and {@link Signature#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Signature#equals(Object)}
   *   <li>{@link Signature#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act and Assert
    assertEquals(methodSignature, methodSignature);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature.hashCode());
  }

  /**
   * Test {@link Signature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Signature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
  }

  /**
   * Test {@link Signature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Signature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null);
  }

  /**
   * Test {@link Signature#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Signature#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, "Different type to Signature");
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName(
      "Test compareTo(Signature) with 'Signature'; given ClassSignature(String) with 'Class Name'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  void testCompareToWithSignature_givenClassSignatureWithClassName_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        new ClassSignature("Class Name")
            .compareTo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>Then return minus forty-three.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName("Test compareTo(Signature) with 'Signature'; then return minus forty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  void testCompareToWithSignature_thenReturnMinusFortyThree() {
    // Arrange, Act and Assert
    assertEquals(
        -43,
        new MethodSignature((String) null)
            .compareTo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>Then return minus thirty-nine.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName("Test compareTo(Signature) with 'Signature'; then return minus thirty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  void testCompareToWithSignature_thenReturnMinusThirtyNine() {
    // Arrange, Act and Assert
    assertEquals(
        -39,
        new MethodSignature("Class Name")
            .compareTo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName("Test compareTo(Signature) with 'Signature'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  void testCompareToWithSignature_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.compareTo(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>When {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName(
      "Test compareTo(Signature) with 'Signature'; when ClassSignature(String) with 'Class Name'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  void testCompareToWithSignature_whenClassSignatureWithClassName_thenReturnZero() {
    // Arrange
    ClassSignature classSignature = new ClassSignature("Class Name");

    // Act
    int actualCompareToResult = classSignature.compareTo(new ClassSignature("Class Name"));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName("Test compareTo(Signature) with 'Signature'; when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  void testCompareToWithSignature_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.compareTo(null));
  }

  /**
   * Test {@link Signature#toString()}.
   *
   * <p>Method under test: {@link Signature#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.toString());
  }

  /**
   * Test {@link Signature#toString()}.
   *
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ClassSignature(String) with 'Class Name'; then return 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.toString()"})
  void testToString_givenClassSignatureWithClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", new ClassSignature("Class Name").toString());
  }

  /**
   * Test {@link Signature#toString()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with className is {@code null}.
   *   <li>Then return {@code L?;?null}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given MethodSignature(String) with className is 'null'; then return 'L?;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.toString()"})
  void testToString_givenMethodSignatureWithClassNameIsNull_thenReturnLNull() {
    // Arrange, Act and Assert
    assertEquals("L?;?null", new MethodSignature((String) null).toString());
  }

  /**
   * Test {@link Signature#toString()}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with {@code Class Name}.
   *   <li>Then return {@code LClass Name;?null}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given MethodSignature(String) with 'Class Name'; then return 'LClass Name;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Signature.toString()"})
  void testToString_givenMethodSignatureWithClassName_thenReturnLClassNameNull() {
    // Arrange, Act and Assert
    assertEquals("LClass Name;?null", new MethodSignature("Class Name").toString());
  }
}
