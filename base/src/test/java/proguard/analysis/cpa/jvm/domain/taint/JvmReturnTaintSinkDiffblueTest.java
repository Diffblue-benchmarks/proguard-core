package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeDefaultCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.attribute.CodeAttribute;

class JvmReturnTaintSinkDiffblueTest {
  /**
   * Test {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature, Predicate)}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature, Predicate)}
   */
  @Test
  @DisplayName("Test new JvmReturnTaintSink(Signature, Predicate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate)"
  })
  void testNewJvmReturnTaintSink() {
    // Arrange and Act
    JvmReturnTaintSink actualJvmReturnTaintSink =
        new JvmReturnTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, mock(Predicate.class));

    // Assert
    Signature signature = actualJvmReturnTaintSink.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    MethodDescriptor descriptor = ((MethodSignature) signature).getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        signature.getFqn());
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

  /**
   * Test {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature)}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature)}
   */
  @Test
  @DisplayName("Test new JvmReturnTaintSink(Signature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.<init>(proguard.classfile.Signature)"
  })
  void testNewJvmReturnTaintSink2() {
    // Arrange and Act
    JvmReturnTaintSink actualJvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    Signature signature = actualJvmReturnTaintSink.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        signature.getFqn());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmReturnTaintSink.getMemoryLocations().size());
    assertFalse(signature.isIncomplete());
  }

  /**
   * Test {@link JvmReturnTaintSink#getMemoryLocations()}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmReturnTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertFalse(jvmReturnTaintSink.matchCfaEdge(new JvmAssumeExceptionCfaEdge(true, 1)));
  }

  /**
   * Test {@link JvmReturnTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge2() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertFalse(
        jvmReturnTaintSink.matchCfaEdge(
            new JvmAssumeDefaultCfaEdge(
                JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, new CodeAttribute(1), 2)));
  }

  /**
   * Test {@link JvmReturnTaintSink#equals(Object)}, and {@link JvmReturnTaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmReturnTaintSink#equals(Object)}
   *   <li>{@link JvmReturnTaintSink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    JvmReturnTaintSink jvmReturnTaintSink2 =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink2);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink2.hashCode());
  }

  /**
   * Test {@link JvmReturnTaintSink#equals(Object)}, and {@link JvmReturnTaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmReturnTaintSink#equals(Object)}
   *   <li>{@link JvmReturnTaintSink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink.hashCode());
  }

  /**
   * Test {@link JvmReturnTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmReturnTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);

    // Act and Assert
    assertNotEquals(
        jvmReturnTaintSink,
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmReturnTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmReturnTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Test {@link JvmReturnTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmReturnTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE),
        "Different type to JvmReturnTaintSink");
  }

  /**
   * Test {@link JvmReturnTaintSink#toString()}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink.toString()"
  })
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "[JvmReturnTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .toString());
  }
}
