package proguard.dexfile.reader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Method#Method(String, String, Proto)}
   *   <li>{@link Method#toString()}
   *   <li>{@link Method#getName()}
   *   <li>{@link Method#getOwner()}
   *   <li>{@link Method#getProto()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Method.<init>(String, String, Proto)",
    "String Method.getName()",
    "String Method.getOwner()",
    "Proto Method.getProto()",
    "String Method.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    Method actualMethod = new Method("Owner", "Name", proto);
    String actualToStringResult = actualMethod.toString();
    String actualName = actualMethod.getName();
    String actualOwner = actualMethod.getOwner();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Owner", actualOwner);
    assertEquals("Owner->Name(Parameter Types)Return Type", actualToStringResult);
    assertSame(proto, actualMethod.getProto());
  }

  /**
   * Test {@link Method#Method(String, String, String[], String)}.
   *
   * <p>Method under test: {@link Method#Method(String, String, String[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Method.<init>(String, String, String[], String)"})
  public void testNewMethod() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};

    // Act
    Method actualMethod = new Method("Owner", "Name", parameterTypes, "Return Type");

    // Assert
    assertEquals("(Parameter Types)Return Type", actualMethod.getDesc());
    Proto proto = actualMethod.getProto();
    assertEquals("(Parameter Types)Return Type", proto.getDesc());
    assertEquals("Name", actualMethod.getName());
    assertEquals("Owner", actualMethod.getOwner());
    assertEquals("Return Type", actualMethod.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertSame(parameterTypes, actualMethod.getParameterTypes());
    assertSame(parameterTypes, proto.getParameterTypes());
  }

  /**
   * Test {@link Method#getDesc()}.
   *
   * <ul>
   *   <li>Then return {@code (Parameter Types)Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link Method#getDesc()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Method.getDesc()"})
  public void testGetDesc_thenReturnParameterTypesReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "(Parameter Types)Return Type",
        (new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .getDesc());
  }

  /**
   * Test {@link Method#getParameterTypes()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Parameter Types}.
   * </ul>
   *
   * <p>Method under test: {@link Method#getParameterTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] Method.getParameterTypes()"})
  public void testGetParameterTypes_thenReturnArrayOfStringWithParameterTypes() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"Parameter Types"},
        (new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .getParameterTypes());
  }

  /**
   * Test {@link Method#getReturnType()}.
   *
   * <ul>
   *   <li>Then return {@code Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link Method#getReturnType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Method.getReturnType()"})
  public void testGetReturnType_thenReturnReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "Return Type",
        (new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .getReturnType());
  }

  /**
   * Test {@link Method#equals(Object)}, and {@link Method#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));
    Method method2 =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method2);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method2.hashCode());
  }

  /**
   * Test {@link Method#equals(Object)}, and {@link Method#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Method method =
        new Method(null, "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));
    Method method2 =
        new Method(null, "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method2);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method2.hashCode());
  }

  /**
   * Test {@link Method#equals(Object)}, and {@link Method#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Method method =
        new Method("Owner", null, new Proto(new String[] {"Parameter Types"}, "Return Type"));
    Method method2 =
        new Method("Owner", null, new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method2);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method2.hashCode());
  }

  /**
   * Test {@link Method#equals(Object)}, and {@link Method#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method.hashCode());
  }

  /**
   * Test {@link Method#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Method#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Method method =
        new Method("Name", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(
        method,
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
  }

  /**
   * Test {@link Method#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Method#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Method method =
        new Method(null, "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(
        method,
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
  }

  /**
   * Test {@link Method#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Method#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Method method =
        new Method("Owner", "Owner", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(
        method,
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
  }

  /**
   * Test {@link Method#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Method#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Method method =
        new Method("Owner", null, new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(
        method,
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
  }

  /**
   * Test {@link Method#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Method#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")),
        null);
  }

  /**
   * Test {@link Method#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Method#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Method.equals(Object)", "int Method.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")),
        "Different type to Method");
  }
}
