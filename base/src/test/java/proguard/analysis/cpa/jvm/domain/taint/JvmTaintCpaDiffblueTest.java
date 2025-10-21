package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.DelegateAbstractDomain;
import proguard.analysis.cpa.defaults.MergeJoinOperator;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.defaults.StaticPrecisionAdjustment;
import proguard.analysis.cpa.defaults.StopJoinOperator;
import proguard.analysis.cpa.interfaces.TransferRelation;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

public class JvmTaintCpaDiffblueTest {
  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Map, Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Map, Map, Map)"})
  public void testNewJvmTaintCpa() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act
    JvmTaintCpa actualJvmTaintCpa =
        new JvmTaintCpa(signaturesToSources, taintTransformers, new HashMap<>());

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault =
        ((JvmTaintTransferRelation) transferRelation).getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set)}.
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set)"})
  public void testNewJvmTaintCpa2() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            false,
            true,
            taintsArgs,
            new HashSet<>()));
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));

    // Act and Assert
    TransferRelation transferRelation = (new JvmTaintCpa(sources)).getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    assertTrue(((JvmTaintTransferRelation) transferRelation).getAbstractDefault().isEmpty());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set, Map, Map)"})
  public void testNewJvmTaintCpa3() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            false,
            true,
            taintsArgs,
            new HashSet<>()));
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act and Assert
    TransferRelation transferRelation =
        (new JvmTaintCpa(sources, taintTransformers, new HashMap<>())).getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    assertTrue(((JvmTaintTransferRelation) transferRelation).getAbstractDefault().isEmpty());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set)}.
   *
   * <ul>
   *   <li>Then return TransferRelation AbstractDefault Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set)"})
  public void testNewJvmTaintCpa_thenReturnTransferRelationAbstractDefaultEmpty() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()));

    // Act and Assert
    TransferRelation transferRelation = (new JvmTaintCpa(sources)).getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    assertTrue(((JvmTaintTransferRelation) transferRelation).getAbstractDefault().isEmpty());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}.
   *
   * <ul>
   *   <li>Then return TransferRelation AbstractDefault Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set, Map, Map)"})
  public void testNewJvmTaintCpa_thenReturnTransferRelationAbstractDefaultEmpty2() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()));
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act and Assert
    TransferRelation transferRelation =
        (new JvmTaintCpa(sources, taintTransformers, new HashMap<>())).getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    assertTrue(((JvmTaintTransferRelation) transferRelation).getAbstractDefault().isEmpty());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then AbstractDomain return {@link DelegateAbstractDomain}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set)"})
  public void testNewJvmTaintCpa_whenHashSet_thenAbstractDomainReturnDelegateAbstractDomain() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(sources);

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault =
        ((JvmTaintTransferRelation) transferRelation).getAbstractDefault();
    assertEquals(sources, abstractDefault);
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then AbstractDomain return {@link DelegateAbstractDomain}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set, Map, Map)"})
  public void testNewJvmTaintCpa_whenHashSet_thenAbstractDomainReturnDelegateAbstractDomain2() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(sources, taintTransformers, new HashMap<>());

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault =
        ((JvmTaintTransferRelation) transferRelation).getAbstractDefault();
    assertEquals(sources, abstractDefault);
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Test {@link JvmTaintCpa#createSourcesMap(Set)}.
   *
   * <p>Method under test: {@link JvmTaintCpa#createSourcesMap(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JvmTaintCpa.createSourcesMap(Set)"})
  public void testCreateSourcesMap() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            false,
            true,
            taintsArgs,
            new HashSet<>()));
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));

    // Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult =
        JvmTaintCpa.createSourcesMap(sources);

    // Assert
    assertEquals(1, actualCreateSourcesMapResult.size());
  }

  /**
   * Test {@link JvmTaintCpa#createSourcesMap(Set)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintCpa#createSourcesMap(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JvmTaintCpa.createSourcesMap(Set)"})
  public void testCreateSourcesMap_thenReturnSizeIsOne() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()));

    // Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult =
        JvmTaintCpa.createSourcesMap(sources);

    // Assert
    assertEquals(1, actualCreateSourcesMapResult.size());
  }

  /**
   * Test {@link JvmTaintCpa#createSourcesMap(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintCpa#createSourcesMap(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map JvmTaintCpa.createSourcesMap(Set)"})
  public void testCreateSourcesMap_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult =
        JvmTaintCpa.createSourcesMap(new HashSet<>());

    // Assert
    assertTrue(actualCreateSourcesMapResult.isEmpty());
  }
}
