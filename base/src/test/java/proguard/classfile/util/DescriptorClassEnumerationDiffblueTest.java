package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DescriptorClassEnumerationDiffblueTest {
  /**
   * Method under test: {@link DescriptorClassEnumeration#classCount()}
   */
  @Test
  public void testClassCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new DescriptorClassEnumeration("Descriptor")).classCount());
  }

  /**
   * Method under test: {@link DescriptorClassEnumeration#hasMoreClassNames()}
   */
  @Test
  public void testHasMoreClassNames() {
    // Arrange, Act and Assert
    assertTrue((new DescriptorClassEnumeration("Descriptor")).hasMoreClassNames());
    assertFalse((new DescriptorClassEnumeration("")).hasMoreClassNames());
  }

  /**
   * Method under test: {@link DescriptorClassEnumeration#nextFluff()}
   */
  @Test
  public void testNextFluff() {
    // Arrange
    DescriptorClassEnumeration descriptorClassEnumeration = new DescriptorClassEnumeration("Descriptor");

    // Act and Assert
    assertEquals("Descriptor", descriptorClassEnumeration.nextFluff());
    assertFalse(descriptorClassEnumeration.hasMoreClassNames());
  }

  /**
   * Method under test: {@link DescriptorClassEnumeration#nextFluff()}
   */
  @Test
  public void testNextFluff2() {
    // Arrange
    DescriptorClassEnumeration descriptorClassEnumeration = new DescriptorClassEnumeration("java.lang.String");

    // Act and Assert
    assertEquals("java.", descriptorClassEnumeration.nextFluff());
    assertTrue(descriptorClassEnumeration.isInnerClassName());
  }

  /**
   * Method under test: {@link DescriptorClassEnumeration#nextClassName()}
   */
  @Test
  public void testNextClassName() {
    // Arrange, Act and Assert
    assertEquals("java", (new DescriptorClassEnumeration("java.lang.String")).nextClassName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)}
   *   <li>{@link DescriptorClassEnumeration#isInnerClassName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new DescriptorClassEnumeration("Descriptor")).isInnerClassName());
  }
}
