package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractDomain;
import proguard.analysis.cpa.interfaces.MergeOperator;
import proguard.analysis.cpa.interfaces.PrecisionAdjustment;
import proguard.analysis.cpa.interfaces.StopOperator;
import proguard.analysis.cpa.interfaces.TransferRelation;

class SimpleCpaDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleCpa#SimpleCpa(AbstractDomain, TransferRelation, MergeOperator, StopOperator,
   *       PrecisionAdjustment)}
   *   <li>{@link SimpleCpa#getAbstractDomain()}
   *   <li>{@link SimpleCpa#getMergeOperator()}
   *   <li>{@link SimpleCpa#getPrecisionAdjustment()}
   *   <li>{@link SimpleCpa#getStopOperator()}
   *   <li>{@link SimpleCpa#getTransferRelation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.SimpleCpa.<init>(proguard.analysis.cpa.interfaces.AbstractDomain, proguard.analysis.cpa.interfaces.TransferRelation, proguard.analysis.cpa.interfaces.MergeOperator, proguard.analysis.cpa.interfaces.StopOperator, proguard.analysis.cpa.interfaces.PrecisionAdjustment)",
    "proguard.analysis.cpa.interfaces.AbstractDomain proguard.analysis.cpa.defaults.SimpleCpa.getAbstractDomain()",
    "proguard.analysis.cpa.interfaces.MergeOperator proguard.analysis.cpa.defaults.SimpleCpa.getMergeOperator()",
    "proguard.analysis.cpa.interfaces.PrecisionAdjustment proguard.analysis.cpa.defaults.SimpleCpa.getPrecisionAdjustment()",
    "proguard.analysis.cpa.interfaces.StopOperator proguard.analysis.cpa.defaults.SimpleCpa.getStopOperator()",
    "proguard.analysis.cpa.interfaces.TransferRelation proguard.analysis.cpa.defaults.SimpleCpa.getTransferRelation()"
  })
  void testGettersAndSetters() {
    // Arrange
    DelegateAbstractDomain<LatticeAbstractState> abstractDomain = new DelegateAbstractDomain<>();
    TransferRelation transferRelation = mock(TransferRelation.class);
    MergeOperator mergeOperator = mock(MergeOperator.class);
    StopOperator stopOperator = mock(StopOperator.class);
    PrecisionAdjustment precisionAdjustment = mock(PrecisionAdjustment.class);

    // Act
    SimpleCpa actualSimpleCpa =
        new SimpleCpa(
            abstractDomain, transferRelation, mergeOperator, stopOperator, precisionAdjustment);
    AbstractDomain actualAbstractDomain = actualSimpleCpa.getAbstractDomain();
    MergeOperator actualMergeOperator = actualSimpleCpa.getMergeOperator();
    PrecisionAdjustment actualPrecisionAdjustment = actualSimpleCpa.getPrecisionAdjustment();
    StopOperator actualStopOperator = actualSimpleCpa.getStopOperator();

    // Assert
    assertTrue(actualAbstractDomain instanceof DelegateAbstractDomain);
    assertSame(abstractDomain, actualAbstractDomain);
    assertSame(mergeOperator, actualMergeOperator);
    assertSame(precisionAdjustment, actualPrecisionAdjustment);
    assertSame(stopOperator, actualStopOperator);
    assertSame(transferRelation, actualSimpleCpa.getTransferRelation());
  }
}
