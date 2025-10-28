package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassSignature;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;

public class JvmInvokeTaintSinkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmInvokeTaintSink.Builder#build()}
   *   <li>{@link JvmInvokeTaintSink.Builder#setCallMatcher(Predicate)}
   *   <li>{@link JvmInvokeTaintSink.Builder#setIsValidForSource(Predicate)}
   *   <li>{@link JvmInvokeTaintSink.Builder#setTakesArgs(Set)}
   *   <li>{@link JvmInvokeTaintSink.Builder#setTakesGlobals(Set)}
   *   <li>{@link JvmInvokeTaintSink.Builder#setTakesInstance(boolean)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange
    JvmInvokeTaintSink.Builder setIsValidForSourceResult = (new JvmInvokeTaintSink.Builder(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE)).setCallMatcher(null).setIsValidForSource(null);
    JvmInvokeTaintSink.Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());

    // Act
    JvmInvokeTaintSink actualBuildResult = setTakesArgsResult.setTakesGlobals(new HashSet<>())
        .setTakesInstance(true)
        .build();

    // Assert
    assertTrue(actualBuildResult.signature instanceof MethodSignature);
    assertNull(actualBuildResult.isValidForSource);
    assertNull(actualBuildResult.callMatcher);
    assertEquals(1, actualBuildResult.getMemoryLocations().size());
    assertTrue(actualBuildResult.takesArgs.isEmpty());
    assertTrue(actualBuildResult.takesGlobals.isEmpty());
    assertTrue(actualBuildResult.takesInstance);
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink.Builder#Builder(Signature)}
   */
  @Test
  public void testBuilderNewBuilder() {
    // Arrange and Act
    JvmInvokeTaintSink.Builder actualBuilder = new JvmInvokeTaintSink.Builder(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    Signature signature = actualBuilder.signature;
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
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualBuilder.takesInstance);
    assertTrue(actualBuilder.takesArgs.isEmpty());
    assertTrue(actualBuilder.takesGlobals.isEmpty());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(1, (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
        new HashSet<>())).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(1,
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2, true, takesArgs, new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(1,
        (new JvmInvokeTaintSink(ClassConstants.CLASS_GET_METHOD_SIGNATURE, true, takesArgs, new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations4() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(2, (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
        new HashSet<>())).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations5() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act and Assert
    assertEquals(3, (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
        new HashSet<>())).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations6() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("(");

    // Act and Assert
    assertEquals(2, (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        new HashSet<>(), takesGlobals)).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations7() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");
    takesGlobals.add("(");

    // Act and Assert
    assertEquals(3, (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true,
        new HashSet<>(), takesGlobals)).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations8() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(2,
        (new JvmInvokeTaintSink(ClassConstants.CLASS_GET_METHOD_SIGNATURE, true, takesArgs, new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  public void testGetMemoryLocations9() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(1, (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, takesArgs,
        new HashSet<>())).getMemoryLocations().size());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(new JvmAssumeExceptionCfaEdge(true, 1)));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue(jvmInvokeTaintSink.matchCfaEdge(new JvmCallCfaEdge(new SymbolicCall(caller,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(new JvmCallCfaEdge(new SymbolicCall(caller,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge4() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(ClassConstants.CLASS_FOR_NAME_SIGNATURE, true,
        takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(new JvmCallCfaEdge(new SymbolicCall(caller,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge5() {
    // Arrange
    ClassSignature signature = new ClassSignature("Class Name");
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(new JvmCallCfaEdge(new SymbolicCall(caller,
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge6() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(
        new JvmCallCfaEdge(new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge7() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(new JvmCallCfaEdge(new SymbolicCall(caller,
        ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  public void testMatchCfaEdge8() {
    // Arrange
    ClassSignature signature = new ClassSignature("Class Name");
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(
        new JvmCallCfaEdge(new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmInvokeTaintSink#equals(Object)}
   *   <li>{@link JvmInvokeTaintSink#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());
    HashSet<Integer> takesArgs2 = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink2 = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs2, new HashSet<>());

    // Act and Assert
    assertEquals(jvmInvokeTaintSink, jvmInvokeTaintSink2);
    int expectedHashCodeResult = jvmInvokeTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmInvokeTaintSink2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmInvokeTaintSink#equals(Object)}
   *   <li>{@link JvmInvokeTaintSink#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());

    // Act and Assert
    assertEquals(jvmInvokeTaintSink, jvmInvokeTaintSink);
    int expectedHashCodeResult = jvmInvokeTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmInvokeTaintSink.hashCode());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance",
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ClassSignature signature = new ClassSignature("[JvmInvokeTaintSink] ");
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals("[JvmInvokeTaintSink] [JvmInvokeTaintSink] , takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals("[JvmInvokeTaintSink] null, takes instance",
        (new JvmInvokeTaintSink(null, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    FieldSignature signature = new FieldSignature("[JvmInvokeTaintSink] ", "[JvmInvokeTaintSink] ",
        "[JvmInvokeTaintSink] ");

    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals("[JvmInvokeTaintSink] L[JvmInvokeTaintSink] ;[JvmInvokeTaintSink] , takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange
    MethodSignature signature = new MethodSignature("[JvmInvokeTaintSink] ");
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals("[JvmInvokeTaintSink] L[JvmInvokeTaintSink] ;?null, takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString6() {
    // Arrange
    MethodSignature signature = new MethodSignature(new LibraryClass());
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals("[JvmInvokeTaintSink] L?;?null, takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString7() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, takes args (2)",
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString8() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("[JvmInvokeTaintSink] ");

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, takes globals ([JvmInvokeTaintSink] )",
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, new HashSet<>(),
            takesGlobals)).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString9() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, filtered by call null",
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString10() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, filtered by source null, filtered by call null",
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs,
            new HashSet<>(), null)).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  public void testToString11() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " args (2)",
        (new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, takesArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
        true, takesArgs, new HashSet<>());
    HashSet<Integer> takesArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmInvokeTaintSink, new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, takesArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());
    HashSet<Integer> takesArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmInvokeTaintSink, new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, takesArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, new HashSet<>(), takesGlobals);
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmInvokeTaintSink, new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, takesArgs, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, new HashSet<>());
    HashSet<Integer> takesArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmInvokeTaintSink, new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, takesArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    JvmInvokeTaintSink jvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, takesArgs, new HashSet<>());
    HashSet<Integer> takesArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(jvmInvokeTaintSink, new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true, takesArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
        new HashSet<>()), null);
  }

  /**
   * Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(new JvmInvokeTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs,
        new HashSet<>()), "Different type to JvmInvokeTaintSink");
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(2, integerSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink4() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals);

    // Assert
    assertEquals(1, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink5() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals);

    // Assert
    assertEquals(2, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(2, stringSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink6() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, false, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink7() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, false, takesArgs, takesGlobals);

    // Assert
    assertEquals(1, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink8() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals, null);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink9() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals, null);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink10() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals, null);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(2, integerSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink11() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals, null);

    // Assert
    assertEquals(1, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink12() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, true, takesArgs, takesGlobals, null);

    // Assert
    assertEquals(2, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(2, stringSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink13() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, false, takesArgs, takesGlobals, null);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate)}
   */
  @Test
  public void testNewJvmInvokeTaintSink14() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, false, takesArgs, takesGlobals, null);

    // Assert
    assertEquals(1, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertNull(actualJvmInvokeTaintSink.isValidForSource);
    assertNull(actualJvmInvokeTaintSink.callMatcher);
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink15() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink16() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink17() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(2, integerSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink18() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    assertEquals(1, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink19() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    assertEquals(2, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(2, stringSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
    assertTrue(actualJvmInvokeTaintSink.takesInstance);
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink20() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, takesArgs, takesGlobals);

    // Assert
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(takesGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}
   */
  @Test
  public void testNewJvmInvokeTaintSink21() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink = new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, takesArgs, takesGlobals);

    // Assert
    assertEquals(1, takesGlobals.size());
    Signature signature = actualJvmInvokeTaintSink.signature;
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
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(signature.isIncomplete());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
  }
}
