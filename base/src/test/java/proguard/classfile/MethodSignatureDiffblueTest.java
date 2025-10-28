package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

public class MethodSignatureDiffblueTest {
  /**
   * Method under test: {@link MethodSignature#computeIfAbsent(Clazz, Method)}
   */
  @Test
  public void testComputeIfAbsent() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", null);

    // Act
    MethodSignature actualComputeIfAbsentResult = MethodSignature.computeIfAbsent(clazz, (Method) method);

    // Assert
    assertEquals("? ?.Name(?)", actualComputeIfAbsentResult.getPrettyFqn());
    assertEquals("? ?.Name(?)", actualComputeIfAbsentResult.prettyFqn);
    assertEquals("?", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("?", actualComputeIfAbsentResult.getPackageName());
    assertEquals("L?;Namenull", actualComputeIfAbsentResult.getFqn());
    assertEquals("L?;Namenull", actualComputeIfAbsentResult.fqn);
    assertEquals("Name", actualComputeIfAbsentResult.getMethodName());
    assertNull(actualComputeIfAbsentResult.getClassName());
    assertNull(actualComputeIfAbsentResult.getDescriptor());
    assertEquals(75062036, actualComputeIfAbsentResult.hashCode);
    assertTrue(actualComputeIfAbsentResult.isIncomplete());
    assertSame(clazz, actualComputeIfAbsentResult.getReferencedClass());
    assertSame(method, actualComputeIfAbsentResult.getReferencedMethod());
  }

  /**
   * Method under test: {@link MethodSignature#isIncomplete()}
   */
  @Test
  public void testIsIncomplete() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.UNKNOWN.isIncomplete());
    assertFalse(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.isIncomplete());
    assertTrue((new MethodSignature("Class Name")).isIncomplete());
  }

  /**
   * Method under test: {@link MethodSignature#calculateFqn()}
   */
  @Test
  public void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals("L?;?null", MethodSignature.UNKNOWN.calculateFqn());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.calculateFqn());
  }

  /**
   * Method under test: {@link MethodSignature#calculatePrettyFqn()}
   */
  @Test
  public void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("? ?.?(?)", MethodSignature.UNKNOWN.calculatePrettyFqn());
    assertEquals("Class ClassLoader.findLoadedClass(String)",
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE.calculatePrettyFqn());
    assertEquals("Class ClassLoader.loadClass(String,boolean)",
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2.calculatePrettyFqn());
    assertEquals("String Class.getCanonicalName()",
        ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE.calculatePrettyFqn());
    assertEquals("Method Class.getMethod(String,Class[])",
        ClassConstants.CLASS_GET_METHOD_SIGNATURE.calculatePrettyFqn());
  }

  /**
   * Method under test:
   * {@link MethodSignature#matchesIgnoreNull(MethodSignature, MethodSignature)}
   */
  @Test
  public void testMatchesIgnoreNull() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.matchesIgnoreNull(MethodSignature.UNKNOWN, MethodSignature.UNKNOWN));
    assertTrue(MethodSignature.matchesIgnoreNull(null, null));
    assertFalse(MethodSignature.matchesIgnoreNull(null, MethodSignature.UNKNOWN));
    assertFalse(MethodSignature.matchesIgnoreNull(MethodSignature.UNKNOWN,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertTrue(MethodSignature.matchesIgnoreNull(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse(MethodSignature.matchesIgnoreNull(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse(MethodSignature.matchesIgnoreNull(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Method under test:
   * {@link MethodSignature#matchesIgnoreNullAndDollar(MethodSignature, MethodSignature)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar() {
    // Arrange, Act and Assert
    assertTrue(MethodSignature.matchesIgnoreNullAndDollar(MethodSignature.UNKNOWN, MethodSignature.UNKNOWN));
    assertTrue(MethodSignature.matchesIgnoreNullAndDollar(null, null));
    assertFalse(MethodSignature.matchesIgnoreNullAndDollar(null, MethodSignature.UNKNOWN));
    assertFalse(MethodSignature.matchesIgnoreNullAndDollar(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        MethodSignature.UNKNOWN));
    assertFalse(MethodSignature.matchesIgnoreNullAndDollar(MethodSignature.UNKNOWN,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertTrue(MethodSignature.matchesIgnoreNullAndDollar(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse(MethodSignature.matchesIgnoreNullAndDollar(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE));
    assertFalse(MethodSignature.matchesIgnoreNullAndDollar(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE));
    assertTrue(MethodSignature.matchesIgnoreNullAndDollar(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
    assertTrue(MethodSignature.matchesIgnoreNullAndDollar(ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE,
        ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE));
  }

  /**
   * Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = MethodSignature.UNKNOWN;
    MethodSignature methodSignature2 = MethodSignature.UNKNOWN;

    // Act and Assert
    assertEquals(methodSignature, methodSignature2);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature2.hashCode());
  }

  /**
   * Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MethodSignature methodSignature = new MethodSignature(new LibraryClass());
    MethodSignature methodSignature2 = MethodSignature.UNKNOWN;

    // Act and Assert
    assertEquals(methodSignature, methodSignature2);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature2.hashCode());
  }

  /**
   * Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodSignature methodSignature = MethodSignature.UNKNOWN;

    // Act and Assert
    assertEquals(methodSignature, methodSignature);
    int expectedHashCodeResult = methodSignature.hashCode();
    assertEquals(expectedHashCodeResult, methodSignature.hashCode());
  }

  /**
   * Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, MethodSignature.UNKNOWN);
    assertNotEquals(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);
    assertNotEquals(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2, ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);
  }

  /**
   * Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MethodSignature.UNKNOWN, null);
  }

  /**
   * Method under test: {@link MethodSignature#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MethodSignature.UNKNOWN, "Different type to MethodSignature");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodSignature#getDescriptor()}
   *   <li>{@link MethodSignature#getMethodName()}
   *   <li>{@link MethodSignature#getReferencedMethod()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MethodSignature methodSignature = new MethodSignature("Class Name");

    // Act
    MethodDescriptor actualDescriptor = methodSignature.getDescriptor();
    String actualMethodName = methodSignature.getMethodName();

    // Assert
    assertNull(actualMethodName);
    assertNull(methodSignature.getReferencedMethod());
    assertNull(actualDescriptor);
  }

  /**
   * Method under test: {@link MethodSignature#MethodSignature(String)}
   */
  @Test
  public void testNewMethodSignature() {
    // Arrange and Act
    MethodSignature actualMethodSignature = new MethodSignature("Class Name");

    // Assert
    assertEquals("", actualMethodSignature.getExternalPackageName());
    assertEquals("", actualMethodSignature.getPackageName());
    assertEquals("? Class Name.?(?)", actualMethodSignature.getPrettyFqn());
    assertEquals("? Class Name.?(?)", actualMethodSignature.prettyFqn);
    assertEquals("Class Name", actualMethodSignature.getClassName());
    assertEquals("LClass Name;?null", actualMethodSignature.getFqn());
    assertEquals("LClass Name;?null", actualMethodSignature.fqn);
    assertNull(actualMethodSignature.getMethodName());
    assertNull(actualMethodSignature.getReferencedClass());
    assertNull(actualMethodSignature.getReferencedMethod());
    assertNull(actualMethodSignature.getDescriptor());
    assertEquals(-803315694, actualMethodSignature.hashCode);
    assertTrue(actualMethodSignature.isIncomplete());
  }

  /**
   * Method under test:
   * {@link MethodSignature#MethodSignature(String, String, String)}
   */
  @Test
  public void testNewMethodSignature2() {
    // Arrange and Act
    MethodSignature actualMethodSignature = new MethodSignature("Internal Class Name", "Method", (String) null);

    // Assert
    assertEquals("", actualMethodSignature.getExternalPackageName());
    assertEquals("", actualMethodSignature.getPackageName());
    assertEquals("? Internal Class Name.Method(?)", actualMethodSignature.getPrettyFqn());
    assertEquals("? Internal Class Name.Method(?)", actualMethodSignature.prettyFqn);
    assertEquals("Internal Class Name", actualMethodSignature.getClassName());
    assertEquals("LInternal Class Name;Methodnull", actualMethodSignature.getFqn());
    assertEquals("LInternal Class Name;Methodnull", actualMethodSignature.fqn);
    assertEquals("Method", actualMethodSignature.getMethodName());
    assertNull(actualMethodSignature.getReferencedClass());
    assertNull(actualMethodSignature.getReferencedMethod());
    assertNull(actualMethodSignature.getDescriptor());
    assertEquals(1218262932, actualMethodSignature.hashCode);
    assertTrue(actualMethodSignature.isIncomplete());
  }

  /**
   * Method under test:
   * {@link MethodSignature#MethodSignature(String, String, MethodDescriptor)}
   */
  @Test
  public void testNewMethodSignature3() {
    // Arrange and Act
    MethodSignature actualMethodSignature = new MethodSignature("Internal Class Name", "Method",
        (MethodDescriptor) null);

    // Assert
    assertEquals("", actualMethodSignature.getExternalPackageName());
    assertEquals("", actualMethodSignature.getPackageName());
    assertEquals("? Internal Class Name.Method(?)", actualMethodSignature.getPrettyFqn());
    assertEquals("? Internal Class Name.Method(?)", actualMethodSignature.prettyFqn);
    assertEquals("Internal Class Name", actualMethodSignature.getClassName());
    assertEquals("LInternal Class Name;Methodnull", actualMethodSignature.getFqn());
    assertEquals("LInternal Class Name;Methodnull", actualMethodSignature.fqn);
    assertEquals("Method", actualMethodSignature.getMethodName());
    assertNull(actualMethodSignature.getReferencedClass());
    assertNull(actualMethodSignature.getReferencedMethod());
    assertNull(actualMethodSignature.getDescriptor());
    assertEquals(1218262932, actualMethodSignature.hashCode);
    assertTrue(actualMethodSignature.isIncomplete());
  }

  /**
   * Method under test:
   * {@link MethodSignature#MethodSignature(String, String, MethodDescriptor)}
   */
  @Test
  public void testNewMethodSignature4() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    MethodSignature actualMethodSignature = new MethodSignature("Internal Class Name", "Method", descriptor);

    // Assert
    assertEquals("", actualMethodSignature.getExternalPackageName());
    assertEquals("", actualMethodSignature.getPackageName());
    assertEquals("Internal Class Name", actualMethodSignature.getClassName());
    assertEquals("LInternal Class Name;Method()Return Type", actualMethodSignature.getFqn());
    assertEquals("LInternal Class Name;Method()Return Type", actualMethodSignature.fqn);
    assertEquals("Method", actualMethodSignature.getMethodName());
    assertNull(actualMethodSignature.prettyFqn);
    assertNull(actualMethodSignature.getReferencedClass());
    assertNull(actualMethodSignature.getReferencedMethod());
    assertEquals(720610412, actualMethodSignature.hashCode);
    assertFalse(actualMethodSignature.isIncomplete());
    assertSame(descriptor, actualMethodSignature.getDescriptor());
  }

  /**
   * Method under test: {@link MethodSignature#MethodSignature(Clazz)}
   */
  @Test
  public void testNewMethodSignature5() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    MethodSignature actualMethodSignature = new MethodSignature(clazz);

    // Assert
    assertEquals("? ?.?(?)", actualMethodSignature.getPrettyFqn());
    assertEquals("? ?.?(?)", actualMethodSignature.prettyFqn);
    assertEquals("?", actualMethodSignature.getExternalPackageName());
    assertEquals("?", actualMethodSignature.getPackageName());
    assertEquals("L?;?null", actualMethodSignature.getFqn());
    assertEquals("L?;?null", actualMethodSignature.fqn);
    assertNull(actualMethodSignature.getMethodName());
    assertNull(actualMethodSignature.getClassName());
    assertNull(actualMethodSignature.getReferencedMethod());
    assertNull(actualMethodSignature.getDescriptor());
    assertEquals(29791, actualMethodSignature.hashCode);
    assertTrue(actualMethodSignature.isIncomplete());
    assertSame(clazz, actualMethodSignature.getReferencedClass());
  }

  /**
   * Method under test: {@link MethodSignature#MethodSignature(Clazz, Method)}
   */
  @Test
  public void testNewMethodSignature6() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", null);

    // Act
    MethodSignature actualMethodSignature = new MethodSignature(clazz, method);

    // Assert
    assertEquals("? ?.Name(?)", actualMethodSignature.getPrettyFqn());
    assertEquals("? ?.Name(?)", actualMethodSignature.prettyFqn);
    assertEquals("?", actualMethodSignature.getExternalPackageName());
    assertEquals("?", actualMethodSignature.getPackageName());
    assertEquals("L?;Namenull", actualMethodSignature.getFqn());
    assertEquals("L?;Namenull", actualMethodSignature.fqn);
    assertEquals("Name", actualMethodSignature.getMethodName());
    assertNull(actualMethodSignature.getClassName());
    assertNull(actualMethodSignature.getDescriptor());
    assertEquals(75062036, actualMethodSignature.hashCode);
    assertTrue(actualMethodSignature.isIncomplete());
    assertSame(clazz, actualMethodSignature.getReferencedClass());
    assertSame(method, actualMethodSignature.getReferencedMethod());
  }
}
