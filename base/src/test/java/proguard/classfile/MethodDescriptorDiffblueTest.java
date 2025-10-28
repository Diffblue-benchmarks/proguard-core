package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MethodDescriptorDiffblueTest {
  /**
   * Method under test: {@link MethodDescriptor#isIncomplete()}
   */
  @Test
  public void testIsIncomplete() {
    // Arrange, Act and Assert
    assertFalse((new MethodDescriptor("Return Type", new ArrayList<>())).isIncomplete());
    assertTrue((new MethodDescriptor(null, new ArrayList<>())).isIncomplete());
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNull() {
    // Arrange, Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNull(null, null));
    assertFalse(MethodDescriptor.matchesIgnoreNull(null, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNull2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNull(descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNull3() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertFalse(MethodDescriptor.matchesIgnoreNull(descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNull4() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertFalse(MethodDescriptor.matchesIgnoreNull(descriptor, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNull(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNull5() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNull(descriptor, new MethodDescriptor(null, new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar() {
    // Arrange, Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNullAndDollar(null, null));
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(null, new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar2() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNullAndDollar(descriptor,
        new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar3() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor(null, new ArrayList<>());

    // Act and Assert
    assertFalse(MethodDescriptor.matchesIgnoreNullAndDollar(descriptor,
        new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar4() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("", new ArrayList<>());

    // Act and Assert
    assertFalse(MethodDescriptor.matchesIgnoreNullAndDollar(descriptor,
        new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar5() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Act and Assert
    assertFalse(MethodDescriptor.matchesIgnoreNullAndDollar(descriptor,
        new MethodDescriptor("Return Type", new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar6() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act and Assert
    assertTrue(MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, new MethodDescriptor(null, new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link MethodDescriptor#matchesIgnoreNullAndDollar(MethodDescriptor, MethodDescriptor)}
   */
  @Test
  public void testMatchesIgnoreNullAndDollar7() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", argumentTypes);

    ArrayList<String> argumentTypes2 = new ArrayList<>();
    argumentTypes2.add("42");

    // Act and Assert
    assertFalse(
        MethodDescriptor.matchesIgnoreNullAndDollar(descriptor, new MethodDescriptor("Return Type", argumentTypes2)));
  }

  /**
   * Method under test: {@link MethodDescriptor#getPrettyReturnType()}
   */
  @Test
  public void testGetPrettyReturnType() {
    // Arrange, Act and Assert
    assertEquals("?", (new MethodDescriptor(null, new ArrayList<>())).getPrettyReturnType());
  }

  /**
   * Method under test: {@link MethodDescriptor#getPrettyArgumentTypes()}
   */
  @Test
  public void testGetPrettyArgumentTypes() {
    // Arrange, Act and Assert
    assertEquals("", (new MethodDescriptor("Return Type", new ArrayList<>())).getPrettyArgumentTypes());
  }

  /**
   * Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("()Return Type", (new MethodDescriptor("Return Type", new ArrayList<>())).toString());
    assertEquals("()?", (new MethodDescriptor(null, new ArrayList<>())).toString());
  }

  /**
   * Method under test: {@link MethodDescriptor#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");

    // Act and Assert
    assertEquals("(foo)Return Type", (new MethodDescriptor("Return Type", argumentTypes)).toString());
  }

  /**
   * Method under test: {@link MethodDescriptor#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodDescriptor("Return Type", new ArrayList<>()), "42");
  }

  /**
   * Method under test: {@link MethodDescriptor#MethodDescriptor(String)}
   */
  @Test
  public void testNewMethodDescriptor() {
    // Arrange and Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor(null);

    // Assert
    assertEquals("?", actualMethodDescriptor.getPrettyArgumentTypes());
    assertEquals("?", actualMethodDescriptor.getPrettyReturnType());
    assertNull(actualMethodDescriptor.getReturnType());
    assertNull(actualMethodDescriptor.getArgumentTypes());
    assertTrue(actualMethodDescriptor.isIncomplete());
  }

  /**
   * Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  public void testNewMethodDescriptor2() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("", actualMethodDescriptor.getPrettyArgumentTypes());
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    List<String> argumentTypes2 = actualMethodDescriptor.getArgumentTypes();
    assertTrue(argumentTypes2.isEmpty());
    assertSame(argumentTypes, argumentTypes2);
  }

  /**
   * Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  public void testNewMethodDescriptor3() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("foo");

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    List<String> argumentTypes2 = actualMethodDescriptor.getArgumentTypes();
    assertEquals(1, argumentTypes2.size());
    assertEquals("foo", argumentTypes2.get(0));
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertSame(argumentTypes, argumentTypes2);
  }

  /**
   * Method under test: {@link MethodDescriptor#MethodDescriptor(String, List)}
   */
  @Test
  public void testNewMethodDescriptor4() {
    // Arrange
    ArrayList<String> argumentTypes = new ArrayList<>();
    argumentTypes.add("42");
    argumentTypes.add("foo");

    // Act
    MethodDescriptor actualMethodDescriptor = new MethodDescriptor("Return Type", argumentTypes);

    // Assert
    assertEquals("Return Type", actualMethodDescriptor.getReturnType());
    assertFalse(actualMethodDescriptor.isIncomplete());
    assertSame(argumentTypes, actualMethodDescriptor.getArgumentTypes());
  }
}
