package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SignatureDiffblueTest {
  /**
   * Method under test: {@link Signature#of(Clazz, Member)}
   */
  @Test
  public void testOf() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    Signature actualOfResult = Signature.of(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertTrue(actualOfResult instanceof FieldSignature);
    assertEquals("?", actualOfResult.getExternalPackageName());
    assertEquals("?", actualOfResult.getPackageName());
    assertEquals("Descriptor", ((FieldSignature) actualOfResult).descriptor);
    assertEquals("Lnull;Name", actualOfResult.getFqn());
    assertEquals("Lnull;Name", ((FieldSignature) actualOfResult).fqn);
    assertEquals("Name", ((FieldSignature) actualOfResult).memberName);
    assertNull(actualOfResult.getClassName());
    assertNull(((FieldSignature) actualOfResult).prettyFqn);
    assertNull(actualOfResult.getReferencedClass());
    assertEquals(1320159907, ((FieldSignature) actualOfResult).hashCode);
    assertTrue(actualOfResult.isIncomplete());
  }

  /**
   * Method under test: {@link Signature#of(Clazz, Member)}
   */
  @Test
  public void testOf2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod member = new LibraryMethod();

    // Act
    Signature actualOfResult = Signature.of(clazz, member);

    // Assert
    assertTrue(actualOfResult instanceof MethodSignature);
    assertEquals("? ?.?(?)", actualOfResult.getPrettyFqn());
    assertEquals("? ?.?(?)", ((MethodSignature) actualOfResult).prettyFqn);
    assertEquals("?", actualOfResult.getExternalPackageName());
    assertEquals("?", actualOfResult.getPackageName());
    assertEquals("L?;?null", actualOfResult.getFqn());
    assertEquals("L?;?null", ((MethodSignature) actualOfResult).fqn);
    assertNull(((MethodSignature) actualOfResult).getMethodName());
    assertNull(actualOfResult.getClassName());
    assertNull(((MethodSignature) actualOfResult).getDescriptor());
    assertEquals(29791, ((MethodSignature) actualOfResult).hashCode);
    assertTrue(actualOfResult.isIncomplete());
    assertSame(clazz, actualOfResult.getReferencedClass());
    assertSame(member, ((MethodSignature) actualOfResult).getReferencedMethod());
  }

  /**
   * Method under test: {@link Signature#computeIfAbsent(Clazz, Member)}
   */
  @Test
  public void testComputeIfAbsent() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    Signature actualComputeIfAbsentResult = Signature.computeIfAbsent(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertTrue(actualComputeIfAbsentResult instanceof FieldSignature);
    assertEquals("?", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("?", actualComputeIfAbsentResult.getPackageName());
    assertEquals("Descriptor", ((FieldSignature) actualComputeIfAbsentResult).descriptor);
    assertEquals("Lnull;Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("Lnull;Name", ((FieldSignature) actualComputeIfAbsentResult).fqn);
    assertEquals("Name", ((FieldSignature) actualComputeIfAbsentResult).memberName);
    assertNull(actualComputeIfAbsentResult.getClassName());
    assertNull(((FieldSignature) actualComputeIfAbsentResult).prettyFqn);
    assertNull(actualComputeIfAbsentResult.getReferencedClass());
    assertEquals(1320159907, ((FieldSignature) actualComputeIfAbsentResult).hashCode);
    assertTrue(actualComputeIfAbsentResult.isIncomplete());
  }

  /**
   * Method under test: {@link Signature#computeIfAbsent(Clazz, Member)}
   */
  @Test
  public void testComputeIfAbsent2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod member = new LibraryMethod();

    // Act
    Signature actualComputeIfAbsentResult = Signature.computeIfAbsent(clazz, member);

    // Assert
    assertTrue(actualComputeIfAbsentResult instanceof MethodSignature);
    assertEquals("? ?.?(?)", actualComputeIfAbsentResult.getPrettyFqn());
    assertEquals("? ?.?(?)", ((MethodSignature) actualComputeIfAbsentResult).prettyFqn);
    assertEquals("?", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("?", actualComputeIfAbsentResult.getPackageName());
    assertEquals("L?;?null", actualComputeIfAbsentResult.getFqn());
    assertEquals("L?;?null", ((MethodSignature) actualComputeIfAbsentResult).fqn);
    assertNull(((MethodSignature) actualComputeIfAbsentResult).getMethodName());
    assertNull(actualComputeIfAbsentResult.getClassName());
    assertNull(((MethodSignature) actualComputeIfAbsentResult).getDescriptor());
    assertEquals(29791, ((MethodSignature) actualComputeIfAbsentResult).hashCode);
    assertTrue(actualComputeIfAbsentResult.isIncomplete());
    assertSame(clazz, actualComputeIfAbsentResult.getReferencedClass());
    assertSame(member, ((MethodSignature) actualComputeIfAbsentResult).getReferencedMethod());
  }

  /**
   * Method under test: {@link Signature#getFqn()}
   */
  @Test
  public void testGetFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getFqn());
  }

  /**
   * Method under test: {@link Signature#getPrettyFqn()}
   */
  @Test
  public void testGetPrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getPrettyFqn());
  }

  /**
   * Method under test: {@link Signature#getPackageName()}
   */
  @Test
  public void testGetPackageName() {
    // Arrange, Act and Assert
    assertEquals("", (new ClassSignature("Class Name")).getPackageName());
  }

  /**
   * Method under test: {@link Signature#getPackageName()}
   */
  @Test
  public void testGetPackageName2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    clazz.thisClassName = "proguard.classfile.Clazz[]";

    // Act and Assert
    assertEquals("proguard.classfile", (new ClassSignature(clazz)).getPackageName());
  }

  /**
   * Method under test: {@link Signature#getExternalPackageName()}
   */
  @Test
  public void testGetExternalPackageName() {
    // Arrange, Act and Assert
    assertEquals("", (new ClassSignature("Class Name")).getExternalPackageName());
  }

  /**
   * Method under test: {@link Signature#getExternalPackageName()}
   */
  @Test
  public void testGetExternalPackageName2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    clazz.thisClassName = "proguard.classfile.Clazz[]";

    // Act and Assert
    assertEquals("proguard.classfile", (new ClassSignature(clazz)).getExternalPackageName());
  }

  /**
   * Method under test: {@link Signature#getClassName()}
   */
  @Test
  public void testGetClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).getClassName());
  }

  /**
   * Method under test: {@link Signature#getReferencedClass()}
   */
  @Test
  public void testGetReferencedClass() {
    // Arrange, Act and Assert
    assertNull((new ClassSignature("Class Name")).getReferencedClass());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Signature#equals(Object)}
   *   <li>{@link Signature#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link Signature#equals(Object)}
   *   <li>{@link Signature#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act and Assert
    assertEquals(methodSignature, methodSignature);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature.hashCode());
  }

  /**
   * Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  public void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new ClassSignature("Class Name")).compareTo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertEquals(-1, (new ClassSignature("Class Name")).compareTo(null));
  }

  /**
   * Method under test: {@link Signature#compareTo(Signature)}
   */
  @Test
  public void testCompareTo2() {
    // Arrange
    ClassSignature classSignature = new ClassSignature("Class Name");

    // Act and Assert
    assertEquals(0, classSignature.compareTo(new ClassSignature("Class Name")));
  }

  /**
   * Method under test: {@link Signature#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).toString());
  }

  /**
   * Method under test: {@link Signature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
  }

  /**
   * Method under test: {@link Signature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null);
  }

  /**
   * Method under test: {@link Signature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, "Different type to Signature");
  }
}
