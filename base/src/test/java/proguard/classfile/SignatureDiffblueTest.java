package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SignatureDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Signature Signature.of(Clazz, Member)"})
  public void testOf_thenReturnFieldSignature() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Signature Signature.of(Clazz, Member)"})
  public void testOf_whenLibraryMethod_thenReferencedClassReturnLibraryClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Signature Signature.computeIfAbsent(Clazz, Member)"})
  public void testComputeIfAbsent_thenReturnFieldSignature() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Signature Signature.computeIfAbsent(Clazz, Member)"})
  public void testComputeIfAbsent_whenLibraryMethod_thenReferencedClassReturnLibraryClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getFqn()"})
  public void testGetFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getFqn());
  }

  /**
   * Test {@link Signature#getPrettyFqn()}.
   *
   * <p>Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getPrettyFqn()"})
  public void testGetPrettyFqn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getPackageName()"})
  public void testGetPackageName_givenClassSignatureWithClassName_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getPackageName()"})
  public void testGetPackageName_thenReturnProguardClassfile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getExternalPackageName()"})
  public void testGetExternalPackageName_thenReturnEmptyString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getExternalPackageName()"})
  public void testGetExternalPackageName_thenReturnProguardClassfile() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.getClassName()"})
  public void testGetClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getClassName());
  }

  /**
   * Test {@link Signature#getReferencedClass()}.
   *
   * <p>Method under test: {@link Signature#getReferencedClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz Signature.getReferencedClass()"})
  public void testGetReferencedClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Signature.equals(Object)", "int Signature.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  public void testCompareToWithSignature_whenClassSignatureWithClassName_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  public void testCompareToWithSignature_whenClassloader_find_loaded_class_signature() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Signature.compareTo(Signature)"})
  public void testCompareToWithSignature_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new ClassSignature("Class Name")).compareTo(null));
  }

  /**
   * Test {@link Signature#toString()}.
   *
   * <p>Method under test: {@link Signature#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Signature.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).toString());
  }
}
