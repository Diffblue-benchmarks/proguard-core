package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

class BamLocationDependentJvmMemoryLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link JvmUnknownCfaNode#INSTANCE}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#BamLocationDependentJvmMemoryLocation(JvmMemoryLocation,
   *       JvmCfaNode, ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#setProgramLocation(JvmCfaNode)}
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getMemoryLocation()}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getSourceReachedSet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation)",
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)",
    "JvmMemoryLocation BamLocationDependentJvmMemoryLocation.getMemoryLocation()",
    "ProgramLocationDependentReachedSet BamLocationDependentJvmMemoryLocation.getSourceReachedSet()",
    "void BamLocationDependentJvmMemoryLocation.setProgramLocation(JvmCfaNode)",
    "void BamLocationDependentJvmMemoryLocation.setSourceReachedSet(ProgramLocationDependentReachedSet)"
  })
  void testGettersAndSetters_whenInstance() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualBamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(JvmUnknownCfaNode.INSTANCE);
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    actualBamLocationDependentJvmMemoryLocation.setSourceReachedSet(sourceReachedSet);
    JvmMemoryLocation actualMemoryLocation =
        actualBamLocationDependentJvmMemoryLocation.getMemoryLocation();

    // Assert
    assertTrue(actualMemoryLocation instanceof JvmLocalVariableLocation);
    assertEquals(1, ((JvmLocalVariableLocation) actualMemoryLocation).index);
    assertSame(sourceReachedSet, actualBamLocationDependentJvmMemoryLocation.getSourceReachedSet());
    assertSame(memoryLocation, actualMemoryLocation);
    assertSame(
        JvmUnknownCfaNode.INSTANCE,
        actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link JvmLocalVariableLocation#JvmLocalVariableLocation(int)} with index is one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#BamLocationDependentJvmMemoryLocation(JvmMemoryLocation)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#setProgramLocation(JvmCfaNode)}
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getMemoryLocation()}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getSourceReachedSet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when JvmLocalVariableLocation(int) with index is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation)",
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)",
    "JvmMemoryLocation BamLocationDependentJvmMemoryLocation.getMemoryLocation()",
    "ProgramLocationDependentReachedSet BamLocationDependentJvmMemoryLocation.getSourceReachedSet()",
    "void BamLocationDependentJvmMemoryLocation.setProgramLocation(JvmCfaNode)",
    "void BamLocationDependentJvmMemoryLocation.setSourceReachedSet(ProgramLocationDependentReachedSet)"
  })
  void testGettersAndSetters_whenJvmLocalVariableLocationWithIndexIsOne() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualBamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(memoryLocation);
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(JvmUnknownCfaNode.INSTANCE);
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    actualBamLocationDependentJvmMemoryLocation.setSourceReachedSet(sourceReachedSet);
    JvmMemoryLocation actualMemoryLocation =
        actualBamLocationDependentJvmMemoryLocation.getMemoryLocation();

    // Assert
    assertTrue(actualMemoryLocation instanceof JvmLocalVariableLocation);
    assertEquals(1, ((JvmLocalVariableLocation) actualMemoryLocation).index);
    assertSame(sourceReachedSet, actualBamLocationDependentJvmMemoryLocation.getSourceReachedSet());
    assertSame(memoryLocation, actualMemoryLocation);
    assertSame(
        JvmUnknownCfaNode.INSTANCE,
        actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#copy()}.
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BamLocationDependentJvmMemoryLocation BamLocationDependentJvmMemoryLocation.copy()"
  })
  void testCopy() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> actualCopyResult =
        bamLocationDependentJvmMemoryLocation.copy();

    // Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, actualCopyResult);
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test extractFirstValue(LatticeAbstractState); then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState BamLocationDependentJvmMemoryLocation.extractFirstValue(LatticeAbstractState)"
  })
  void testExtractFirstValue_thenReturnUnknown() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        bamLocationDependentJvmMemoryLocation.extractFirstValue(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test extractFirstValue(LatticeAbstractState); then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState BamLocationDependentJvmMemoryLocation.extractFirstValue(LatticeAbstractState)"
  })
  void testExtractFirstValue_thenReturnUnknown2() {
    // Arrange
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);

    JvmTaintAbstractState abstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    sourceReachedSet.add(abstractState);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                new JvmLocalVariableLocation(1), JvmUnknownCfaNode.INSTANCE, sourceReachedSet);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        bamLocationDependentJvmMemoryLocation.extractFirstValue(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}.
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}
   */
  @Test
  @DisplayName("Test getProgramLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmCfaNode BamLocationDependentJvmMemoryLocation.getProgramLocation()"})
  void testGetProgramLocation() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNull(bamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}, and {@link
   * BamLocationDependentJvmMemoryLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation2 =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation2);
    assertEquals(
        bamLocationDependentJvmMemoryLocation.hashCode(),
        bamLocationDependentJvmMemoryLocation2.hashCode());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}, and {@link
   * BamLocationDependentJvmMemoryLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation);
    int expectedHashCodeResult = bamLocationDependentJvmMemoryLocation.hashCode();
    assertEquals(expectedHashCodeResult, bamLocationDependentJvmMemoryLocation.hashCode());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0));

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    bamLocationDependentJvmMemoryLocation.setProgramLocation(JvmUnknownCfaNode.INSTANCE);

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation, null);
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        "Different type to BamLocationDependentJvmMemoryLocation");
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BamLocationDependentJvmMemoryLocation.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    bamLocationDependentJvmMemoryLocation.setProgramLocation(
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()));

    // Act and Assert
    assertEquals(
        "JvmLocalVariableLocation(1)@Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang"
            + "/Class;:2",
        bamLocationDependentJvmMemoryLocation.toString());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#toString()}.
   *
   * <ul>
   *   <li>Then return {@code JvmLocalVariableLocation(1)}.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'JvmLocalVariableLocation(1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BamLocationDependentJvmMemoryLocation.toString()"})
  void testToString_thenReturnJvmLocalVariableLocation1() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", bamLocationDependentJvmMemoryLocation.toString());
  }
}
