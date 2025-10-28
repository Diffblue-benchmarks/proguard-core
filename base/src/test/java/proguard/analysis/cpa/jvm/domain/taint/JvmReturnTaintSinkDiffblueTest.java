package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeDefaultCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.attribute.CodeAttribute;

public class JvmReturnTaintSinkDiffblueTest {
  /**
   * Method under test: {@link JvmReturnTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertFalse(jvmReturnTaintSink.matchCfaEdge(new JvmAssumeExceptionCfaEdge(true, 1)));
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge2() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    JvmAssumeDefaultCfaEdge edge = new JvmAssumeDefaultCfaEdge(JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE,
        new CodeAttribute(1), 2);

    // Act
    boolean actualMatchCfaEdgeResult = jvmReturnTaintSink.matchCfaEdge(edge);

    // Assert
    assertTrue(edge.getSource() instanceof JvmUnknownCfaNode);
    assertFalse(actualMatchCfaEdgeResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmReturnTaintSink#equals(Object)}
   *   <li>{@link JvmReturnTaintSink#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    JvmReturnTaintSink jvmReturnTaintSink2 = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink2);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmReturnTaintSink#equals(Object)}
   *   <li>{@link JvmReturnTaintSink#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink.hashCode());
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[JvmReturnTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).toString());
    assertEquals(
        "[JvmReturnTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;,"
            + " filtered by source: null",
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null)).toString());
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);

    // Act and Assert
    assertNotEquals(jvmReturnTaintSink, new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE),
        "Different type to JvmReturnTaintSink");
  }

  /**
   * Method under test:
   * {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature, Predicate)}
   */
  @Test
  public void testNewJvmReturnTaintSink() {
    // Arrange and Act
    JvmReturnTaintSink actualJvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null);

    // Assert
    Signature signature = actualJvmReturnTaintSink.signature;
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
    assertNull(actualJvmReturnTaintSink.isValidForSource);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmReturnTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
  }

  /**
   * Method under test: {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature)}
   */
  @Test
  public void testNewJvmReturnTaintSink2() {
    // Arrange and Act
    JvmReturnTaintSink actualJvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    Signature signature = actualJvmReturnTaintSink.signature;
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
    assertEquals(1, actualJvmReturnTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
  }
}
