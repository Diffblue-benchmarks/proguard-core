package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

public class JvmTaintSourceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmTaintSource#equals(Object)}
   *   <li>{@link JvmTaintSource#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    JvmTaintSource jvmTaintSource2 = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs2, new HashSet<>());

    // Act and Assert
    assertEquals(jvmTaintSource, jvmTaintSource2);
    int expectedHashCodeResult = jvmTaintSource.hashCode();
    assertEquals(expectedHashCodeResult, jvmTaintSource2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmTaintSource#equals(Object)}
   *   <li>{@link JvmTaintSource#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs, new HashSet<>());

    // Act and Assert
    assertEquals(jvmTaintSource, jvmTaintSource);
    int expectedHashCodeResult = jvmTaintSource.hashCode();
    assertEquals(expectedHashCodeResult, jvmTaintSource.hashCode());
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE, true, true,
        taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmTaintSource, new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false,
        true, taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmTaintSource, new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        false, taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmTaintSource, new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmTaintSource, new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");
    JvmTaintSource jvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, new HashSet<>(), taintsGlobals);
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmTaintSource, new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        true, taintsArgs, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()), null);
  }

  /**
   * Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()), "Different type to JvmTaintSource");
  }

  /**
   * Method under test:
   * {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmTaintSource() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    JvmTaintSource actualJvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, true, taintsArgs, taintsGlobals);

    // Assert
    Signature signature = actualJvmTaintSource.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    MethodDescriptor descriptor = ((MethodSignature) signature).getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;", signature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertFalse(actualJvmTaintSource.callMatcher.isPresent());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(taintsGlobals.isEmpty());
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
    assertTrue(actualJvmTaintSource.taintsReturn);
    assertTrue(actualJvmTaintSource.taintsThis);
  }

  /**
   * Method under test:
   * {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmTaintSource2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    JvmTaintSource actualJvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, true, taintsArgs, taintsGlobals);

    // Assert
    Signature signature = actualJvmTaintSource.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    MethodDescriptor descriptor = ((MethodSignature) signature).getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;", signature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<Integer> integerSet = actualJvmTaintSource.taintsArgs;
    assertEquals(1, integerSet.size());
    assertFalse(actualJvmTaintSource.callMatcher.isPresent());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(taintsGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
    assertTrue(actualJvmTaintSource.taintsReturn);
    assertTrue(actualJvmTaintSource.taintsThis);
  }

  /**
   * Method under test:
   * {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmTaintSource3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(1);
    taintsArgs.add(2);
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    JvmTaintSource actualJvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, true, taintsArgs, taintsGlobals);

    // Assert
    Signature signature = actualJvmTaintSource.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    MethodDescriptor descriptor = ((MethodSignature) signature).getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;", signature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<Integer> integerSet = actualJvmTaintSource.taintsArgs;
    assertEquals(2, integerSet.size());
    assertFalse(actualJvmTaintSource.callMatcher.isPresent());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(taintsGlobals.isEmpty());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
    assertTrue(actualJvmTaintSource.taintsReturn);
    assertTrue(actualJvmTaintSource.taintsThis);
  }

  /**
   * Method under test:
   * {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmTaintSource4() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");

    // Act
    JvmTaintSource actualJvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, true, taintsArgs, taintsGlobals);

    // Assert
    assertEquals(1, taintsGlobals.size());
    Signature signature = actualJvmTaintSource.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    MethodDescriptor descriptor = ((MethodSignature) signature).getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;", signature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<String> stringSet = actualJvmTaintSource.taintsGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(actualJvmTaintSource.callMatcher.isPresent());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
    assertTrue(actualJvmTaintSource.taintsReturn);
    assertTrue(actualJvmTaintSource.taintsThis);
  }

  /**
   * Method under test:
   * {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmTaintSource5() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("42");
    taintsGlobals.add("foo");

    // Act
    JvmTaintSource actualJvmTaintSource = new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, true, taintsArgs, taintsGlobals);

    // Assert
    assertEquals(2, taintsGlobals.size());
    Signature signature = actualJvmTaintSource.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    MethodDescriptor descriptor = ((MethodSignature) signature).getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;", signature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<String> stringSet = actualJvmTaintSource.taintsGlobals;
    assertEquals(2, stringSet.size());
    assertFalse(actualJvmTaintSource.callMatcher.isPresent());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
    assertTrue(actualJvmTaintSource.taintsReturn);
    assertTrue(actualJvmTaintSource.taintsThis);
  }
}
