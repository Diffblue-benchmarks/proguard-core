package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;

class JvmCallCfaEdgeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmCallCfaEdge#JvmCallCfaEdge(Call)}
   *   <li>{@link JvmCallCfaEdge#getCall()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge.<init>(proguard.analysis.datastructure.callgraph.Call)",
    "proguard.analysis.datastructure.callgraph.Call proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge.getCall()"
  })
  void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    JvmCallCfaEdge actualJvmCallCfaEdge = new JvmCallCfaEdge(call);
    Call actualCall = actualJvmCallCfaEdge.getCall();

    // Assert
    assertNull(actualJvmCallCfaEdge.getSource());
    assertNull(actualJvmCallCfaEdge.getTarget());
    assertSame(call, actualCall);
  }

  /**
   * Test {@link JvmCallCfaEdge#JvmCallCfaEdge(JvmCfaNode, JvmCfaNode, Call)}.
   *
   * <ul>
   *   <li>Then Source return {@link JvmUnknownCfaNode}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCallCfaEdge#JvmCallCfaEdge(JvmCfaNode, JvmCfaNode, Call)}
   */
  @Test
  @DisplayName(
      "Test new JvmCallCfaEdge(JvmCfaNode, JvmCfaNode, Call); then Source return JvmUnknownCfaNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge.<init>(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testNewJvmCallCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    JvmCallCfaEdge actualJvmCallCfaEdge =
        new JvmCallCfaEdge(JvmUnknownCfaNode.INSTANCE, target, call);

    // Assert
    JvmCfaNode source = actualJvmCallCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    Call call2 = actualJvmCallCfaEdge.getCall();
    assertTrue(call2 instanceof SymbolicCall);
    assertSame(call, call2);
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmCallCfaEdge.getTarget());
  }

  /**
   * Test {@link JvmCallCfaEdge#targetSignature()}.
   *
   * <ul>
   *   <li>Then return PrettyFqn is {@code Class ClassLoader.findLoadedClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCallCfaEdge#targetSignature()}
   */
  @Test
  @DisplayName(
      "Test targetSignature(); then return PrettyFqn is 'Class ClassLoader.findLoadedClass(String)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.MethodSignature proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge.targetSignature()"
  })
  void testTargetSignature_thenReturnPrettyFqnIsClassClassLoaderFindLoadedClassString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    MethodSignature actualTargetSignatureResult =
        (new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true)))
            .targetSignature();

    // Assert
    assertEquals(
        "Class ClassLoader.findLoadedClass(String)", actualTargetSignatureResult.getPrettyFqn());
    MethodDescriptor descriptor = actualTargetSignatureResult.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        actualTargetSignatureResult.getFqn());
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", actualTargetSignatureResult.getMethodName());
    assertEquals("java.lang", actualTargetSignatureResult.getExternalPackageName());
    assertEquals("java.lang", actualTargetSignatureResult.getPackageName());
    assertEquals("java/lang/ClassLoader", actualTargetSignatureResult.getClassName());
    assertNull(actualTargetSignatureResult.getReferencedClass());
    assertNull(actualTargetSignatureResult.getReferencedMethod());
    assertEquals(1, descriptor.getArgumentTypes().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(actualTargetSignatureResult.isIncomplete());
  }
}
