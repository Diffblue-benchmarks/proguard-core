package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.DelegateAbstractDomain;
import proguard.analysis.cpa.defaults.MergeJoinOperator;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.defaults.StaticPrecisionAdjustment;
import proguard.analysis.cpa.defaults.StopJoinOperator;
import proguard.analysis.cpa.interfaces.TransferRelation;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

class JvmTaintCpaDiffblueTest {
  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Map, Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Map, Map, Map)}
   */
  @Test
  @DisplayName("Test new JvmTaintCpa(Map, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Map, Map, Map)"})
  void testNewJvmTaintCpa() {
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
  @DisplayName("Test new JvmTaintCpa(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set)"})
  void testNewJvmTaintCpa2() {
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
    TransferRelation transferRelation = new JvmTaintCpa(sources).getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    assertTrue(((JvmTaintTransferRelation) transferRelation).getAbstractDefault().isEmpty());
  }

  /**
   * Test {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  @DisplayName("Test new JvmTaintCpa(Set, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set, Map, Map)"})
  void testNewJvmTaintCpa3() {
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

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(sources, taintTransformers, new HashMap<>());

    // Assert
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
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
  @DisplayName("Test new JvmTaintCpa(Set); then return TransferRelation AbstractDefault Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set)"})
  void testNewJvmTaintCpa_thenReturnTransferRelationAbstractDefaultEmpty() {
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
    TransferRelation transferRelation = new JvmTaintCpa(sources).getTransferRelation();
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
  @DisplayName(
      "Test new JvmTaintCpa(Set, Map, Map); then return TransferRelation AbstractDefault Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set, Map, Map)"})
  void testNewJvmTaintCpa_thenReturnTransferRelationAbstractDefaultEmpty2() {
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

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(sources, taintTransformers, new HashMap<>());

    // Assert
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
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
  @DisplayName(
      "Test new JvmTaintCpa(Set); when HashSet(); then AbstractDomain return DelegateAbstractDomain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set)"})
  void testNewJvmTaintCpa_whenHashSet_thenAbstractDomainReturnDelegateAbstractDomain() {
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
  @DisplayName(
      "Test new JvmTaintCpa(Set, Map, Map); when HashSet(); then AbstractDomain return DelegateAbstractDomain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmTaintCpa.<init>(Set, Map, Map)"})
  void testNewJvmTaintCpa_whenHashSet_thenAbstractDomainReturnDelegateAbstractDomain2() {
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
  @DisplayName("Test createSourcesMap(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JvmTaintCpa.createSourcesMap(Set)"})
  void testCreateSourcesMap() {
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
  @DisplayName("Test createSourcesMap(Set); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JvmTaintCpa.createSourcesMap(Set)"})
  void testCreateSourcesMap_thenReturnSizeIsOne() {
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
  @DisplayName("Test createSourcesMap(Set); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JvmTaintCpa.createSourcesMap(Set)"})
  void testCreateSourcesMap_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult =
        JvmTaintCpa.createSourcesMap(new HashSet<>());

    // Assert
    assertTrue(actualCreateSourcesMapResult.isEmpty());
  }
}
