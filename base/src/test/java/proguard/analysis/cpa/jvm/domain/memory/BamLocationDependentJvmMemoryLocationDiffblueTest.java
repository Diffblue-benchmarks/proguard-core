package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

public class BamLocationDependentJvmMemoryLocationDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation)",
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)",
    "JvmMemoryLocation BamLocationDependentJvmMemoryLocation.getMemoryLocation()",
    "ProgramLocationDependentReachedSet BamLocationDependentJvmMemoryLocation.getSourceReachedSet()",
    "void BamLocationDependentJvmMemoryLocation.setProgramLocation(JvmCfaNode)",
    "void BamLocationDependentJvmMemoryLocation.setSourceReachedSet(ProgramLocationDependentReachedSet)"
  })
  public void testGettersAndSetters_whenInstance() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualBamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(programLocation);
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
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(
        expectedProgramLocation, actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation)",
    "void BamLocationDependentJvmMemoryLocation.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)",
    "JvmMemoryLocation BamLocationDependentJvmMemoryLocation.getMemoryLocation()",
    "ProgramLocationDependentReachedSet BamLocationDependentJvmMemoryLocation.getSourceReachedSet()",
    "void BamLocationDependentJvmMemoryLocation.setProgramLocation(JvmCfaNode)",
    "void BamLocationDependentJvmMemoryLocation.setSourceReachedSet(ProgramLocationDependentReachedSet)"
  })
  public void testGettersAndSetters_whenJvmLocalVariableLocationWithIndexIsOne() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualBamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(memoryLocation);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(programLocation);
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
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(
        expectedProgramLocation, actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#copy()}.
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "BamLocationDependentJvmMemoryLocation BamLocationDependentJvmMemoryLocation.copy()"
  })
  public void testCopy() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(
        bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation.copy());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState BamLocationDependentJvmMemoryLocation.extractFirstValue(LatticeAbstractState)"
  })
  public void testExtractFirstValue_thenReturnUnknown() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());

    // Act
    ValueAbstractState actualExtractFirstValueResult =
        bamLocationDependentJvmMemoryLocation.extractFirstValue(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractFirstValueResult.UNKNOWN, actualExtractFirstValueResult);
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}.
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode BamLocationDependentJvmMemoryLocation.getProgramLocation()"})
  public void testGetProgramLocation() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation2 =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation2);
    int expectedHashCodeResult = bamLocationDependentJvmMemoryLocation.hashCode();
    assertEquals(expectedHashCodeResult, bamLocationDependentJvmMemoryLocation2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BamLocationDependentJvmMemoryLocation.equals(Object)",
    "int BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BamLocationDependentJvmMemoryLocation.toString()"})
  public void testToString_thenReturnAString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BamLocationDependentJvmMemoryLocation.toString()"})
  public void testToString_thenReturnJvmLocalVariableLocation1() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", bamLocationDependentJvmMemoryLocation.toString());
  }
}
