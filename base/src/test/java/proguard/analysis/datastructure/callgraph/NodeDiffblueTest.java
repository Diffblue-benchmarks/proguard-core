package proguard.analysis.datastructure.callgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;

public class NodeDiffblueTest {
  /**
   * Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  public void testSuccessorsContain() {
    // Arrange, Act and Assert
    assertTrue((new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
        .successorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE))
        .successorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new Node(ClassConstants.CLASS_FOR_NAME_SIGNATURE))
        .successorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).successorsContain(null));
    assertFalse((new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE))
        .successorsContain(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Method under test: {@link Node#successorsContain(MethodSignature)}
   */
  @Test
  public void testSuccessorsContain2() {
    // Arrange
    Node node = new Node(MethodSignature.UNKNOWN);

    // Act and Assert
    assertTrue(node.successorsContain(new MethodSignature(new LibraryClass())));
  }

  /**
   * Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  public void testPredecessorsContain() {
    // Arrange, Act and Assert
    assertTrue((new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
        .predecessorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE))
        .predecessorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new Node(ClassConstants.CLASS_FOR_NAME_SIGNATURE))
        .predecessorsContain(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertFalse((new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).predecessorsContain(null));
    assertFalse((new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE))
        .predecessorsContain(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Method under test: {@link Node#predecessorsContain(MethodSignature)}
   */
  @Test
  public void testPredecessorsContain2() {
    // Arrange
    Node node = new Node(MethodSignature.UNKNOWN);

    // Act and Assert
    assertTrue(node.predecessorsContain(new MethodSignature(new LibraryClass())));
  }

  /**
   * Method under test: {@link Node#getSuccessorDepth()}
   */
  @Test
  public void testGetSuccessorDepth() {
    // Arrange, Act and Assert
    assertEquals(0, (new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).getSuccessorDepth());
  }

  /**
   * Method under test: {@link Node#getPredecessorDepth()}
   */
  @Test
  public void testGetPredecessorDepth() {
    // Arrange, Act and Assert
    assertEquals(0, (new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).getPredecessorDepth());
  }

  /**
   * Method under test: {@link Node#getAllPredecessors()}
   */
  @Test
  public void testGetAllPredecessors() {
    // Arrange, Act and Assert
    assertEquals(1, (new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).getAllPredecessors().size());
    assertEquals(1, (new Node(null)).getAllPredecessors().size());
  }

  /**
   * Method under test: {@link Node#getFurthestPredecessors()}
   */
  @Test
  public void testGetFurthestPredecessors() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).getFurthestPredecessors().size());
    assertEquals(1, (new Node(null)).getFurthestPredecessors().size());
  }

  /**
   * Method under test: {@link Node#getFurthestSuccessors()}
   */
  @Test
  public void testGetFurthestSuccessors() {
    // Arrange, Act and Assert
    assertEquals(1, (new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).getFurthestSuccessors().size());
    assertEquals(1, (new Node(null)).getFurthestSuccessors().size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Node#equals(Object)}
   *   <li>{@link Node#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Node node = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    Node node2 = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(node, node2);
    int expectedHashCodeResult = node.hashCode();
    assertEquals(expectedHashCodeResult, node2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Node#equals(Object)}
   *   <li>{@link Node#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Node node = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(node, node);
    int expectedHashCodeResult = node.hashCode();
    assertEquals(expectedHashCodeResult, node.hashCode());
  }

  /**
   * Method under test: {@link Node#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Node node = new Node(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);

    // Act and Assert
    assertNotEquals(node, new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test: {@link Node#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Method under test: {@link Node#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), "Different type to Node");
  }

  /**
   * Method under test: {@link Node#Node(MethodSignature)}
   */
  @Test
  public void testNewNode() {
    // Arrange and Act
    Node actualNode = new Node(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    MethodSignature methodSignature = actualNode.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    MethodDescriptor descriptor = methodSignature.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
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
}
