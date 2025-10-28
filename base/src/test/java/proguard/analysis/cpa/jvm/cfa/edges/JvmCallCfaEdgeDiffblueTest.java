package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.List;
import org.junit.Test;
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
   * Methods under test:
   * <ul>
   *   <li>{@link JvmCallCfaEdge#JvmCallCfaEdge(Call)}
   *   <li>{@link JvmCallCfaEdge#getCall()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call = new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    JvmCallCfaEdge actualJvmCallCfaEdge = new JvmCallCfaEdge(call);
    Call actualCall = actualJvmCallCfaEdge.getCall();

    // Assert
    assertNull(actualJvmCallCfaEdge.getSource());
    assertNull(actualJvmCallCfaEdge.getTarget());
    assertSame(call, actualCall);
  }

  /**
   * Method under test: {@link JvmCallCfaEdge#targetSignature()}
   */
  @Test
  public void testTargetSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    MethodSignature actualTargetSignatureResult = (new JvmCallCfaEdge(new SymbolicCall(caller,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1, new BranchInstruction((byte) 'A', 1), true, true)))
            .targetSignature();

    // Assert
    assertEquals("Class ClassLoader.findLoadedClass(String)", actualTargetSignatureResult.getPrettyFqn());
    MethodDescriptor descriptor = actualTargetSignatureResult.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        actualTargetSignatureResult.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", actualTargetSignatureResult.getMethodName());
    assertEquals("java.lang", actualTargetSignatureResult.getExternalPackageName());
    assertEquals("java.lang", actualTargetSignatureResult.getPackageName());
    assertEquals("java/lang/ClassLoader", actualTargetSignatureResult.getClassName());
    assertNull(actualTargetSignatureResult.getReferencedClass());
    assertNull(actualTargetSignatureResult.getReferencedMethod());
    assertFalse(descriptor.isIncomplete());
    assertFalse(actualTargetSignatureResult.isIncomplete());
  }
}
