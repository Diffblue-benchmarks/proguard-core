package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.Signature;

public class JvmTaintExpandOperatorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmTaintExpandOperator#JvmTaintExpandOperator(JvmCfa, Map)}
   *   <li>{@link JvmTaintExpandOperator#getSignaturesToSources()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();

    // Act
    Map<Signature, Set<JvmTaintSource>> actualSignaturesToSources = (new JvmTaintExpandOperator(cfa,
        signaturesToSources)).getSignaturesToSources();

    // Assert
    assertTrue(actualSignaturesToSources.isEmpty());
    assertSame(signaturesToSources, actualSignaturesToSources);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JvmTaintExpandOperator#JvmTaintExpandOperator(JvmCfa, Map, boolean)}
   *   <li>{@link JvmTaintExpandOperator#getSignaturesToSources()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();

    // Act
    Map<Signature, Set<JvmTaintSource>> actualSignaturesToSources = (new JvmTaintExpandOperator(cfa,
        signaturesToSources, true)).getSignaturesToSources();

    // Assert
    assertTrue(actualSignaturesToSources.isEmpty());
    assertSame(signaturesToSources, actualSignaturesToSources);
  }
}
