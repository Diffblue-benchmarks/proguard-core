package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SignatureDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Signature proguard.classfile.Signature.of(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testOf_thenReturnFieldSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    Signature actualOfResult = Signature.of(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertTrue(actualOfResult instanceof FieldSignature);
    assertEquals("Descriptor", ((FieldSignature) actualOfResult).descriptor);
    assertEquals("Lnull;Name", actualOfResult.getFqn());
    assertEquals("Lnull;Name", ((FieldSignature) actualOfResult).fqn);
    assertEquals("Name", ((FieldSignature) actualOfResult).memberName);
    assertNull(((FieldSignature) actualOfResult).prettyFqn);
    assertNull(actualOfResult.getReferencedClass());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Signature proguard.classfile.Signature.of(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
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
   *   <li>Then return {@link FieldSignature}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#computeIfAbsent(Clazz, Member)}
   */
  @Test
  @DisplayName("Test computeIfAbsent(Clazz, Member); then return FieldSignature")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Signature proguard.classfile.Signature.computeIfAbsent(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testComputeIfAbsent_thenReturnFieldSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    Signature actualComputeIfAbsentResult =
        Signature.computeIfAbsent(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertTrue(actualComputeIfAbsentResult instanceof FieldSignature);
    assertEquals("Descriptor", ((FieldSignature) actualComputeIfAbsentResult).descriptor);
    assertEquals("Lnull;Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("Lnull;Name", ((FieldSignature) actualComputeIfAbsentResult).fqn);
    assertEquals("Name", ((FieldSignature) actualComputeIfAbsentResult).memberName);
    assertNull(((FieldSignature) actualComputeIfAbsentResult).prettyFqn);
    assertNull(actualComputeIfAbsentResult.getReferencedClass());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Signature proguard.classfile.Signature.computeIfAbsent(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getFqn()"})
  void testGetFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @DisplayName("Test getPrettyFqn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getPrettyFqn()"})
  void testGetPrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getPrettyFqn());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getPackageName()"})
  void testGetPackageName_givenClassSignatureWithClassName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ClassSignature("Class Name")).getPackageName());
  }

  /**
   * Test {@link Signature#getPackageName()}.
   *
   * <ul>
   *   <li>Then return {@code proguard.classfile}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getPackageName()}
   */
  @Test
  @DisplayName("Test getPackageName(); then return 'proguard.classfile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getPackageName()"})
  void testGetPackageName_thenReturnProguardClassfile() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    clazz.thisClassName = "proguard.classfile.Clazz[]";

    // Act and Assert
    assertEquals("proguard.classfile", (new ClassSignature(clazz)).getPackageName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getExternalPackageName()"})
  void testGetExternalPackageName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ClassSignature("Class Name")).getExternalPackageName());
  }

  /**
   * Test {@link Signature#getExternalPackageName()}.
   *
   * <ul>
   *   <li>Then return {@code proguard.classfile}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#getExternalPackageName()}
   */
  @Test
  @DisplayName("Test getExternalPackageName(); then return 'proguard.classfile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getExternalPackageName()"})
  void testGetExternalPackageName_thenReturnProguardClassfile() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    clazz.thisClassName = "proguard.classfile.Clazz[]";

    // Act and Assert
    assertEquals("proguard.classfile", (new ClassSignature(clazz)).getExternalPackageName());
  }

  /**
   * Test {@link Signature#getClassName()}.
   *
   * <p>Method under test: {@link Signature#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.getClassName()"})
  void testGetClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getClassName());
  }

  /**
   * Test {@link Signature#getReferencedClass()}.
   *
   * <p>Method under test: {@link Signature#getReferencedClass()}
   */
  @Test
  @DisplayName("Test getReferencedClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.classfile.Clazz proguard.classfile.Signature.getReferencedClass()"})
  void testGetReferencedClass() {
    // Arrange, Act and Assert
    assertNull((new ClassSignature("Class Name")).getReferencedClass());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.Signature.equals(java.lang.Object)",
    "int proguard.classfile.Signature.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    MethodSignature methodSignature2 = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act and Assert
    assertEquals(methodSignature, methodSignature2);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.Signature.equals(java.lang.Object)",
    "int proguard.classfile.Signature.hashCode()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.Signature.equals(java.lang.Object)",
    "int proguard.classfile.Signature.hashCode()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.Signature.equals(java.lang.Object)",
    "int proguard.classfile.Signature.hashCode()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.Signature.equals(java.lang.Object)",
    "int proguard.classfile.Signature.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, "Different type to Signature");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.Signature.compareTo(proguard.classfile.Signature)"})
  void testCompareToWithSignature_whenClassSignatureWithClassName_thenReturnZero() {
    // Arrange
    ClassSignature classSignature = new ClassSignature("Class Name");

    // Act and Assert
    assertEquals(0, classSignature.compareTo(new ClassSignature("Class Name")));
  }

  /**
   * Test {@link Signature#compareTo(Signature)} with {@code Signature}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  @DisplayName(
      "Test compareTo(Signature) with 'Signature'; when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.Signature.compareTo(proguard.classfile.Signature)"})
  void testCompareToWithSignature_whenClassloader_find_loaded_class_signature() {
    // Arrange, Act and Assert
    assertEquals(
        -1,
        (new ClassSignature("Class Name"))
            .compareTo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.Signature.compareTo(proguard.classfile.Signature)"})
  void testCompareToWithSignature_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new ClassSignature("Class Name")).compareTo(null));
  }

  /**
   * Test {@link Signature#toString()}.
   *
   * <p>Method under test: {@link Signature#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.Signature.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).toString());
  }
}
