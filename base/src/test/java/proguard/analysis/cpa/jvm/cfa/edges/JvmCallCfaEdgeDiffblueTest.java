package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class JvmCallCfaEdgeDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCallCfaEdge.<init>(Call)", "Call JvmCallCfaEdge.getCall()"})
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCallCfaEdge.<init>(JvmCfaNode, JvmCfaNode, Call)"})
  public void testNewJvmCallCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodSignature JvmCallCfaEdge.targetSignature()"})
  public void testTargetSignature_thenReturnPrettyFqnIsClassClassLoaderFindLoadedClassString() {
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
