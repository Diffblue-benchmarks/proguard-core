package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature, Predicate)}.
   *
   * <p>Method under test: {@link JvmReturnTaintSink#JvmReturnTaintSink(Signature, Predicate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmReturnTaintSink.<init>(Signature, Predicate)"})
  public void testNewJvmReturnTaintSink() {
    // Arrange and Act
    JvmReturnTaintSink actualJvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null);

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
    assertNull(actualJvmReturnTaintSink.isValidForSource);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmReturnTaintSink.<init>(Signature)"})
  public void testNewJvmReturnTaintSink2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set JvmReturnTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmReturnTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmReturnTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmReturnTaintSink.equals(Object)",
    "int JvmReturnTaintSink.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmReturnTaintSink.equals(Object)",
    "int JvmReturnTaintSink.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmReturnTaintSink.equals(Object)",
    "int JvmReturnTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmReturnTaintSink.equals(Object)",
    "int JvmReturnTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmReturnTaintSink.equals(Object)",
    "int JvmReturnTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmReturnTaintSink.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "[JvmReturnTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .toString());
  }

  /**
   * Test {@link JvmReturnTaintSink#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JvmReturnTaintSink#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmReturnTaintSink.toString()"})
  public void testToString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "[JvmReturnTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;,"
            + " filtered by source: null",
        (new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null))
            .toString());
  }
}
