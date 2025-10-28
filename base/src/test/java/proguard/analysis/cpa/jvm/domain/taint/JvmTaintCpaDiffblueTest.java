package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
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
   * Method under test: {@link JvmTaintCpa#createSourcesMap(Set)}
   */
  @Test
  public void testCreateSourcesMap() {
    // Arrange and Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult = JvmTaintCpa.createSourcesMap(new HashSet<>());

    // Assert
    assertTrue(actualCreateSourcesMapResult.isEmpty());
  }

  /**
   * Method under test: {@link JvmTaintCpa#createSourcesMap(Set)}
   */
  @Test
  public void testCreateSourcesMap2() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()));

    // Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult = JvmTaintCpa.createSourcesMap(sources);

    // Assert
    assertEquals(1, actualCreateSourcesMapResult.size());
  }

  /**
   * Method under test: {@link JvmTaintCpa#createSourcesMap(Set)}
   */
  @Test
  public void testCreateSourcesMap3() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, true, taintsArgs,
        new HashSet<>()));
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs2,
        new HashSet<>()));

    // Act
    Map<Signature, Set<JvmTaintSource>> actualCreateSourcesMapResult = JvmTaintCpa.createSourcesMap(sources);

    // Assert
    assertEquals(1, actualCreateSourcesMapResult.size());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Map, Map, Map)}
   */
  @Test
  public void testNewJvmTaintCpa() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(signaturesToSources, taintTransformers, new HashMap<>());

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set)}
   */
  @Test
  public void testNewJvmTaintCpa2() {
    // Arrange and Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(new HashSet<>());

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set)}
   */
  @Test
  public void testNewJvmTaintCpa3() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()));

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(sources);

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set)}
   */
  @Test
  public void testNewJvmTaintCpa4() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, true, taintsArgs,
        new HashSet<>()));
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs2,
        new HashSet<>()));

    // Act
    JvmTaintCpa actualJvmTaintCpa = new JvmTaintCpa(sources);

    // Assert
    assertTrue(actualJvmTaintCpa.getAbstractDomain() instanceof DelegateAbstractDomain);
    assertTrue(actualJvmTaintCpa.getMergeOperator() instanceof MergeJoinOperator);
    assertTrue(actualJvmTaintCpa.getPrecisionAdjustment() instanceof StaticPrecisionAdjustment);
    assertTrue(actualJvmTaintCpa.getStopOperator() instanceof StopJoinOperator);
    TransferRelation transferRelation = actualJvmTaintCpa.getTransferRelation();
    assertTrue(transferRelation instanceof JvmTaintTransferRelation);
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  public void testNewJvmTaintCpa5() {
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
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  public void testNewJvmTaintCpa6() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()));
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
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTaintCpa#JvmTaintCpa(Set, Map, Map)}
   */
  @Test
  public void testNewJvmTaintCpa7() {
    // Arrange
    HashSet<JvmTaintSource> sources = new HashSet<>();
    HashSet<Integer> taintsArgs = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, true, taintsArgs,
        new HashSet<>()));
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    sources.add(new JvmTaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs2,
        new HashSet<>()));
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
    SetAbstractState<JvmTaintSource> abstractDefault = ((JvmTaintTransferRelation) transferRelation)
        .getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, ((JvmTaintTransferRelation) transferRelation).getAbstractNull());
  }
}
