package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

public class JvmTaintSinkDiffblueTest {
  /**
   * Method under test:
   * {@link JvmTaintSink#convertSinksToMemoryLocations(Collection)}
   */
  @Test
  public void testConvertSinksToMemoryLocations() {
    // Arrange and Act
    Map<Signature, Map<JvmTaintSink, Set<JvmMemoryLocation>>> actualConvertSinksToMemoryLocationsResult = JvmTaintSink
        .convertSinksToMemoryLocations(new ArrayList<>());

    // Assert
    assertTrue(actualConvertSinksToMemoryLocationsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmTaintSink#convertSinksToMemoryLocations(Collection)}
   */
  @Test
  public void testConvertSinksToMemoryLocations2() {
    // Arrange
    ArrayList<JvmTaintSink> taintSinks = new ArrayList<>();
    taintSinks.add(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    taintSinks.add(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));

    // Act
    Map<Signature, Map<JvmTaintSink, Set<JvmMemoryLocation>>> actualConvertSinksToMemoryLocationsResult = JvmTaintSink
        .convertSinksToMemoryLocations(taintSinks);

    // Assert
    assertEquals(1, actualConvertSinksToMemoryLocationsResult.size());
  }

  /**
   * Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    JvmReturnTaintSink jvmReturnTaintSink2 = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink2);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink2.hashCode());
  }

  /**
   * Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink.hashCode());
  }

  /**
   * Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink = new JvmReturnTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);

    // Act and Assert
    assertNotEquals(jvmReturnTaintSink, new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE),
        "Different type to JvmTaintSink");
  }
}
