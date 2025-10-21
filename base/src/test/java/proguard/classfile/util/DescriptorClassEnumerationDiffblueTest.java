package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DescriptorClassEnumerationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)}
   *   <li>{@link DescriptorClassEnumeration#isInnerClassName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DescriptorClassEnumeration.<init>(String)",
    "boolean DescriptorClassEnumeration.isInnerClassName()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new DescriptorClassEnumeration("Descriptor")).isInnerClassName());
  }

  /**
   * Test {@link DescriptorClassEnumeration#classCount()}.
   *
   * <ul>
   *   <li>Given {@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)} with {@code
   *       Descriptor}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#classCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DescriptorClassEnumeration.classCount()"})
  public void testClassCount_givenDescriptorClassEnumerationWithDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new DescriptorClassEnumeration("Descriptor")).classCount());
  }

  /**
   * Test {@link DescriptorClassEnumeration#hasMoreClassNames()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#hasMoreClassNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DescriptorClassEnumeration.hasMoreClassNames()"})
  public void testHasMoreClassNames_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DescriptorClassEnumeration("")).hasMoreClassNames());
  }

  /**
   * Test {@link DescriptorClassEnumeration#hasMoreClassNames()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#hasMoreClassNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DescriptorClassEnumeration.hasMoreClassNames()"})
  public void testHasMoreClassNames_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new DescriptorClassEnumeration("Descriptor")).hasMoreClassNames());
  }

  /**
   * Test {@link DescriptorClassEnumeration#nextFluff()}.
   *
   * <ul>
   *   <li>Given {@link DescriptorClassEnumeration#DescriptorClassEnumeration(String)} with {@code
   *       Descriptor}.
   *   <li>Then return {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#nextFluff()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DescriptorClassEnumeration.nextFluff()"})
  public void testNextFluff_givenDescriptorClassEnumerationWithDescriptor_thenReturnDescriptor() {
    // Arrange
    DescriptorClassEnumeration descriptorClassEnumeration =
        new DescriptorClassEnumeration("Descriptor");

    // Act and Assert
    assertEquals("Descriptor", descriptorClassEnumeration.nextFluff());
    assertFalse(descriptorClassEnumeration.hasMoreClassNames());
    assertFalse(descriptorClassEnumeration.isInnerClassName());
  }

  /**
   * Test {@link DescriptorClassEnumeration#nextFluff()}.
   *
   * <ul>
   *   <li>Then return {@code java.}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#nextFluff()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DescriptorClassEnumeration.nextFluff()"})
  public void testNextFluff_thenReturnJava() {
    // Arrange
    DescriptorClassEnumeration descriptorClassEnumeration =
        new DescriptorClassEnumeration("java.lang.String");

    // Act and Assert
    assertEquals("java.", descriptorClassEnumeration.nextFluff());
    assertTrue(descriptorClassEnumeration.hasMoreClassNames());
    assertTrue(descriptorClassEnumeration.isInnerClassName());
  }

  /**
   * Test {@link DescriptorClassEnumeration#nextClassName()}.
   *
   * <ul>
   *   <li>Then return {@code java}.
   * </ul>
   *
   * <p>Method under test: {@link DescriptorClassEnumeration#nextClassName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DescriptorClassEnumeration.nextClassName()"})
  public void testNextClassName_thenReturnJava() {
    // Arrange, Act and Assert
    assertEquals("java", (new DescriptorClassEnumeration("java.lang.String")).nextClassName());
  }
}
