package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class ReflectiveMethodCallUtilDiffblueTest {
  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("Descriptor");

    // Assert
    assertEquals("double", (actualStringtypesToClassesResult[0]).getName());
    assertNull(actualStringtypesToClassesResult[1]);
    assertNull(actualStringtypesToClassesResult[2]);
    assertNull(actualStringtypesToClassesResult[3]);
    assertNull(actualStringtypesToClassesResult[4]);
    assertNull(actualStringtypesToClassesResult[5]);
    assertNull(actualStringtypesToClassesResult[6]);
    assertNull(actualStringtypesToClassesResult[7]);
    assertNull(actualStringtypesToClassesResult[8]);
    assertNull(actualStringtypesToClassesResult[9]);
    assertEquals(10, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses2() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[B");

    // Assert
    assertEquals("[B", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses3() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[C");

    // Assert
    assertEquals("[C", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses4() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[D");

    // Assert
    assertEquals("[D", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses5() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[F");

    // Assert
    assertEquals("[F", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses6() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[I");

    // Assert
    assertEquals("[I", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses7() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[J");

    // Assert
    assertEquals("[J", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses8() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[S");

    // Assert
    assertEquals("[S", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses9() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("[Z");

    // Assert
    assertEquals("[Z", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses10() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Boolean");

    // Assert
    assertEquals("byte", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[0]);
    assertNull(actualStringtypesToClassesResult[1]);
    assertNull(actualStringtypesToClassesResult[11]);
    assertNull(actualStringtypesToClassesResult[12]);
    assertNull(actualStringtypesToClassesResult[13]);
    assertNull(actualStringtypesToClassesResult[14]);
    assertNull(actualStringtypesToClassesResult[15]);
    assertNull(actualStringtypesToClassesResult[2]);
    assertNull(actualStringtypesToClassesResult[3]);
    assertNull(actualStringtypesToClassesResult[4]);
    assertNull(actualStringtypesToClassesResult[5]);
    assertNull(actualStringtypesToClassesResult[6]);
    assertNull(actualStringtypesToClassesResult[7]);
    assertNull(actualStringtypesToClassesResult[8]);
    assertNull(actualStringtypesToClassesResult[9]);
    assertNull(actualStringtypesToClassesResult[Short.SIZE]);
    assertEquals(17, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses11() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Character");

    // Assert
    assertEquals("char", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[0]);
    assertNull(actualStringtypesToClassesResult[1]);
    assertNull(actualStringtypesToClassesResult[11]);
    assertNull(actualStringtypesToClassesResult[12]);
    assertNull(actualStringtypesToClassesResult[13]);
    assertNull(actualStringtypesToClassesResult[14]);
    assertNull(actualStringtypesToClassesResult[15]);
    assertNull(actualStringtypesToClassesResult[17]);
    assertNull(actualStringtypesToClassesResult[18]);
    assertNull(actualStringtypesToClassesResult[2]);
    assertNull(actualStringtypesToClassesResult[3]);
    assertNull(actualStringtypesToClassesResult[4]);
    assertNull(actualStringtypesToClassesResult[5]);
    assertNull(actualStringtypesToClassesResult[6]);
    assertNull(actualStringtypesToClassesResult[7]);
    assertNull(actualStringtypesToClassesResult[8]);
    assertNull(actualStringtypesToClassesResult[9]);
    assertNull(actualStringtypesToClassesResult[Short.SIZE]);
    assertEquals(19, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses12() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Integer");

    // Assert
    assertEquals("int", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[0]);
    assertNull(actualStringtypesToClassesResult[1]);
    assertNull(actualStringtypesToClassesResult[11]);
    assertNull(actualStringtypesToClassesResult[12]);
    assertNull(actualStringtypesToClassesResult[13]);
    assertNull(actualStringtypesToClassesResult[14]);
    assertNull(actualStringtypesToClassesResult[15]);
    assertNull(actualStringtypesToClassesResult[2]);
    assertNull(actualStringtypesToClassesResult[3]);
    assertNull(actualStringtypesToClassesResult[4]);
    assertNull(actualStringtypesToClassesResult[5]);
    assertNull(actualStringtypesToClassesResult[6]);
    assertNull(actualStringtypesToClassesResult[7]);
    assertNull(actualStringtypesToClassesResult[8]);
    assertNull(actualStringtypesToClassesResult[9]);
    assertNull(actualStringtypesToClassesResult[Short.SIZE]);
    assertEquals(17, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  public void testStringtypesToClasses13() throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult = ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Short");

    // Assert
    assertEquals("short", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[0]);
    assertNull(actualStringtypesToClassesResult[1]);
    assertNull(actualStringtypesToClassesResult[11]);
    assertNull(actualStringtypesToClassesResult[12]);
    assertNull(actualStringtypesToClassesResult[13]);
    assertNull(actualStringtypesToClassesResult[14]);
    assertNull(actualStringtypesToClassesResult[2]);
    assertNull(actualStringtypesToClassesResult[3]);
    assertNull(actualStringtypesToClassesResult[4]);
    assertNull(actualStringtypesToClassesResult[5]);
    assertNull(actualStringtypesToClassesResult[6]);
    assertNull(actualStringtypesToClassesResult[7]);
    assertNull(actualStringtypesToClassesResult[8]);
    assertNull(actualStringtypesToClassesResult[9]);
    assertEquals(15, actualStringtypesToClassesResult.length);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  public void testGetObjectForValue() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(0.0d,
        ((Double) ReflectiveMethodCallUtil.getObjectForValue(BasicValueFactory.DOUBLE_VALUE, expectedType))
            .doubleValue(),
        0.0);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  public void testGetObjectForValue2() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(0.0f,
        ((Float) ReflectiveMethodCallUtil.getObjectForValue(BasicValueFactory.FLOAT_VALUE, expectedType)).floatValue(),
        0.0f);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  public void testGetObjectForValue3() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertNull(ReflectiveMethodCallUtil.getObjectForValue(BasicValueFactory.REFERENCE_VALUE, expectedType));
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  public void testGetObjectForValue4() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertNull(ReflectiveMethodCallUtil.getObjectForValue(BasicValueFactory.UNKNOWN_VALUE, expectedType));
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  public void testGetObjectForValue5() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(0.0d,
        ((Double) ReflectiveMethodCallUtil.getObjectForValue(ParticularValueFactory.DOUBLE_VALUE_0, expectedType))
            .doubleValue(),
        0.0);
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  public void testGetObjectForValue6() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(0.0f,
        ((Float) ReflectiveMethodCallUtil.getObjectForValue(ParticularValueFactory.FLOAT_VALUE_0, expectedType))
            .floatValue(),
        0.0f);
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("Internal Array Type");

    // Assert
    assertNull(actualClassForArray);
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray2() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[B");

    // Assert
    assertEquals("[B", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray3() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[C");

    // Assert
    assertEquals("[C", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray4() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[D");

    // Assert
    assertEquals("[D", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray5() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[F");

    // Assert
    assertEquals("[F", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray6() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[I");

    // Assert
    assertEquals("[I", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray7() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[J");

    // Assert
    assertEquals("[J", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray8() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[S");

    // Assert
    assertEquals("[S", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray9() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[Z");

    // Assert
    assertEquals("[Z", actualClassForArray.getName());
  }

  /**
   * Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  public void testGetClassForArray10() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[Ljava/lang/String");

    // Assert
    assertEquals("[Ljava.lang.String;", actualClassForArray.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ReflectiveMethodCallUtil.getClassForPrimitive('A'));
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive2() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('B');

    // Assert
    assertEquals("byte", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive3() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('C');

    // Assert
    assertEquals("char", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive4() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('D');

    // Assert
    assertEquals("double", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive5() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('F');

    // Assert
    assertEquals("float", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive6() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('I');

    // Assert
    assertEquals("int", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive7() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('J');

    // Assert
    assertEquals("long", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive8() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('S');

    // Assert
    assertEquals("short", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive9() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('V');

    // Assert
    assertEquals("void", actualClassForPrimitive.getName());
  }

  /**
   * Method under test:
   * {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  public void testGetClassForPrimitive10() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('Z');

    // Assert
    assertEquals("boolean", actualClassForPrimitive.getName());
  }
}
