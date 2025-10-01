package proguard.analysis.datastructure.callgraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;

class NodeDiffblueTest {
  /**
   * Test {@link Node#Node(MethodSignature)}.
   *
   * <p>Method under test: {@link Node#Node(MethodSignature)}
   */
  @Test
  @DisplayName("Test new Node(MethodSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(MethodSignature)"})
  void testNewNode() {
    // Arrange and Act
    Node actualNode = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    MethodSignature methodSignature = actualNode.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    MethodDescriptor descriptor = methodSignature.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertNull(methodSignature.getReferencedClass());
    assertNull(methodSignature.getReferencedMethod());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualNode.incomingCallLocations.isEmpty());
    assertTrue(actualNode.outgoingCallLocations.isEmpty());
    assertTrue(actualNode.predecessors.isEmpty());
    assertTrue(actualNode.successors.isEmpty());
  }

  /**
   * Test {@link Node#successorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test successorsContain(MethodSignature); given MethodSignature(String) with 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.successorsContain(MethodSignature)"})
  void testSuccessorsContain_givenMethodSignatureWithClassName() {
    // Arrange
    Node node = new Node(new MethodSignature("Class Name"));

    // Act
    boolean actualSuccessorsContainResult =
        node.successorsContain(new MethodSignature("Class Name"));

    // Assert
    assertTrue(actualSuccessorsContainResult);
  }

  /**
   * Test {@link Node#successorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@link
   *       ClassConstants#CLASS_FOR_NAME_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test successorsContain(MethodSignature); given Node(MethodSignature) with signature is CLASS_FOR_NAME_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.successorsContain(MethodSignature)"})
  void testSuccessorsContain_givenNodeWithSignatureIsClass_for_name_signature() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASS_FOR_NAME_SIGNATURE)
            .successorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#successorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@link
   *       ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test successorsContain(MethodSignature); given Node(MethodSignature) with signature is CLASSLOADER_LOAD_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.successorsContain(MethodSignature)"})
  void testSuccessorsContain_givenNodeWithSignatureIsClassloader_load_class_signature() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE)
            .successorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#successorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  @DisplayName("Test successorsContain(MethodSignature); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.successorsContain(MethodSignature)"})
  void testSuccessorsContain_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)
            .successorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#successorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE2}.
   * </ul>
   *
   * <p>Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  @DisplayName("Test successorsContain(MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.successorsContain(MethodSignature)"})
  void testSuccessorsContain_whenClassloader_load_class_signature2() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE)
            .successorsContain(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Test {@link Node#successorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  @DisplayName("Test successorsContain(MethodSignature); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.successorsContain(MethodSignature)"})
  void testSuccessorsContain_whenNull() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE).successorsContain(null));
  }

  /**
   * Test {@link Node#predecessorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Given {@link MethodSignature#MethodSignature(String)} with {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test predecessorsContain(MethodSignature); given MethodSignature(String) with 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.predecessorsContain(MethodSignature)"})
  void testPredecessorsContain_givenMethodSignatureWithClassName() {
    // Arrange
    Node node = new Node(new MethodSignature("Class Name"));

    // Act
    boolean actualPredecessorsContainResult =
        node.predecessorsContain(new MethodSignature("Class Name"));

    // Assert
    assertTrue(actualPredecessorsContainResult);
  }

  /**
   * Test {@link Node#predecessorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@link
   *       ClassConstants#CLASS_FOR_NAME_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test predecessorsContain(MethodSignature); given Node(MethodSignature) with signature is CLASS_FOR_NAME_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.predecessorsContain(MethodSignature)"})
  void testPredecessorsContain_givenNodeWithSignatureIsClass_for_name_signature() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASS_FOR_NAME_SIGNATURE)
            .predecessorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#predecessorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@link
   *       ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test predecessorsContain(MethodSignature); given Node(MethodSignature) with signature is CLASSLOADER_LOAD_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.predecessorsContain(MethodSignature)"})
  void testPredecessorsContain_givenNodeWithSignatureIsClassloader_load_class_signature() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE)
            .predecessorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#predecessorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  @DisplayName("Test predecessorsContain(MethodSignature); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.predecessorsContain(MethodSignature)"})
  void testPredecessorsContain_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)
            .predecessorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#predecessorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE2}.
   * </ul>
   *
   * <p>Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  @DisplayName("Test predecessorsContain(MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.predecessorsContain(MethodSignature)"})
  void testPredecessorsContain_whenClassloader_load_class_signature2() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE)
            .predecessorsContain(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Test {@link Node#predecessorsContain(MethodSignature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  @DisplayName("Test predecessorsContain(MethodSignature); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.predecessorsContain(MethodSignature)"})
  void testPredecessorsContain_whenNull() {
    // Arrange, Act and Assert
    assertFalse(
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE).predecessorsContain(null));
  }

  /**
   * Test {@link Node#getSuccessorDepth()}.
   *
   * <p>Method under test: {@link Node#getSuccessorDepth()}
   */
  @Test
  @DisplayName("Test getSuccessorDepth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Node.getSuccessorDepth()"})
  void testGetSuccessorDepth() {
    // Arrange, Act and Assert
    assertEquals(
        0, new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE).getSuccessorDepth());
  }

  /**
   * Test {@link Node#getPredecessorDepth()}.
   *
   * <p>Method under test: {@link Node#getPredecessorDepth()}
   */
  @Test
  @DisplayName("Test getPredecessorDepth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Node.getPredecessorDepth()"})
  void testGetPredecessorDepth() {
    // Arrange, Act and Assert
    assertEquals(
        0, new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE).getPredecessorDepth());
  }

  /**
   * Test {@link Node#getAllPredecessors()}.
   *
   * <p>Method under test: {@link Node#getAllPredecessors()}
   */
  @Test
  @DisplayName("Test getAllPredecessors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Node.getAllPredecessors()"})
  void testGetAllPredecessors() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)
            .getAllPredecessors()
            .size());
  }

  /**
   * Test {@link Node#getAllPredecessors()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getAllPredecessors()}
   */
  @Test
  @DisplayName("Test getAllPredecessors(); given Node(MethodSignature) with signature is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Node.getAllPredecessors()"})
  void testGetAllPredecessors_givenNodeWithSignatureIsNull() {
    // Arrange, Act and Assert
    assertEquals(1, new Node(null).getAllPredecessors().size());
  }

  /**
   * Test {@link Node#getFurthestPredecessors()}.
   *
   * <p>Method under test: {@link Node#getFurthestPredecessors()}
   */
  @Test
  @DisplayName("Test getFurthestPredecessors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Node.getFurthestPredecessors()"})
  void testGetFurthestPredecessors() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)
            .getFurthestPredecessors()
            .size());
  }

  /**
   * Test {@link Node#getFurthestPredecessors()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getFurthestPredecessors()}
   */
  @Test
  @DisplayName(
      "Test getFurthestPredecessors(); given Node(MethodSignature) with signature is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Node.getFurthestPredecessors()"})
  void testGetFurthestPredecessors_givenNodeWithSignatureIsNull() {
    // Arrange, Act and Assert
    assertEquals(1, new Node(null).getFurthestPredecessors().size());
  }

  /**
   * Test {@link Node#getFurthestSuccessors()}.
   *
   * <p>Method under test: {@link Node#getFurthestSuccessors()}
   */
  @Test
  @DisplayName("Test getFurthestSuccessors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Node.getFurthestSuccessors()"})
  void testGetFurthestSuccessors() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)
            .getFurthestSuccessors()
            .size());
  }

  /**
   * Test {@link Node#getFurthestSuccessors()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(MethodSignature)} with signature is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getFurthestSuccessors()}
   */
  @Test
  @DisplayName("Test getFurthestSuccessors(); given Node(MethodSignature) with signature is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Node.getFurthestSuccessors()"})
  void testGetFurthestSuccessors_givenNodeWithSignatureIsNull() {
    // Arrange, Act and Assert
    assertEquals(1, new Node(null).getFurthestSuccessors().size());
  }

  /**
   * Test {@link Node#equals(Object)}, and {@link Node#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Node#equals(Object)}
   *   <li>{@link Node#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.equals(Object)", "int Node.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Node node = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    Node node2 = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(node, node2);
    assertEquals(node.hashCode(), node2.hashCode());
  }

  /**
   * Test {@link Node#equals(Object)}, and {@link Node#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Node#equals(Object)}
   *   <li>{@link Node#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.equals(Object)", "int Node.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Node node = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(node, node);
    int expectedHashCodeResult = node.hashCode();
    assertEquals(expectedHashCodeResult, node.hashCode());
  }

  /**
   * Test {@link Node#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Node#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.equals(Object)", "int Node.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Node node = new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);

    // Act and Assert
    assertNotEquals(node, new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Node#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Node#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.equals(Object)", "int Node.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Test {@link Node#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Node#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.equals(Object)", "int Node.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), "Different type to Node");
  }
}
