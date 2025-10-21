package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodHandleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Field is {@link Field#Field(String, String, String)} with {@code Owner} and
   *       {@code Name} and {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Field, Method)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodHandle.<init>(int, Field)",
    "void MethodHandle.<init>(int, Field, Method)",
    "void MethodHandle.<init>(int, Method)",
    "Field MethodHandle.getField()",
    "Method MethodHandle.getMethod()",
    "int MethodHandle.getType()"
  })
  public void testGettersAndSetters_thenReturnFieldIsFieldWithOwnerAndNameAndType() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, field, method);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertEquals(1, actualMethodHandle.getType());
    assertSame(field, actualField);
    assertSame(method, actualMethod);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Field is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Method)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodHandle.<init>(int, Field)",
    "void MethodHandle.<init>(int, Field, Method)",
    "void MethodHandle.<init>(int, Method)",
    "Field MethodHandle.getField()",
    "Method MethodHandle.getMethod()",
    "int MethodHandle.getType()"
  })
  public void testGettersAndSetters_thenReturnFieldIsNull() {
    // Arrange
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, method);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertNull(actualField);
    assertEquals(1, actualMethodHandle.getType());
    assertSame(method, actualMethod);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   *   <li>Then return Method is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Field)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodHandle.<init>(int, Field)",
    "void MethodHandle.<init>(int, Field, Method)",
    "void MethodHandle.<init>(int, Method)",
    "Field MethodHandle.getField()",
    "Method MethodHandle.getMethod()",
    "int MethodHandle.getType()"
  })
  public void testGettersAndSetters_whenFieldWithOwnerAndNameAndType_thenReturnMethodIsNull() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, field);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertNull(actualMethod);
    assertEquals(1, actualMethodHandle.getType());
    assertSame(field, actualField);
  }

  /**
   * Test {@link MethodHandle#equals(Object)}, and {@link MethodHandle#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#equals(Object)}
   *   <li>{@link MethodHandle#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);
    MethodHandle methodHandle2 = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertEquals(methodHandle, methodHandle2);
    int expectedHashCodeResult = methodHandle.hashCode();
    assertEquals(expectedHashCodeResult, methodHandle2.hashCode());
  }

  /**
   * Test {@link MethodHandle#equals(Object)}, and {@link MethodHandle#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#equals(Object)}
   *   <li>{@link MethodHandle#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertEquals(methodHandle, methodHandle);
    int expectedHashCodeResult = methodHandle.hashCode();
    assertEquals(expectedHashCodeResult, methodHandle.hashCode());
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(0, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertNotEquals(
        methodHandle,
        new MethodHandle(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"))));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MethodHandle methodHandle =
        new MethodHandle(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, (Field) null));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandle(1, new Field("Owner", "Name", "Type")), null);
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodHandle.equals(Object)", "int MethodHandle.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MethodHandle(1, new Field("Owner", "Name", "Type")), "Different type to MethodHandle");
  }
}
