package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReflectiveMethodCallUtilDiffblueTest {
  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>Then return eleventh element Name is {@code char}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName("Test stringtypesToClasses(String); then return eleventh element Name is 'char'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_thenReturnEleventhElementNameIsChar()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Character");

    // Assert
    assertEquals("char", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[17]);
    assertNull(actualStringtypesToClassesResult[18]);
    assertEquals(19, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [B}.
   *   <li>Then return first element Name is {@code [B}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[B'; then return first element Name is '[B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenB_thenReturnFirstElementNameIsB()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[B");

    // Assert
    assertEquals("[B", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [C}.
   *   <li>Then return first element Name is {@code [C}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[C'; then return first element Name is '[C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenC_thenReturnFirstElementNameIsC()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[C");

    // Assert
    assertEquals("[C", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [D}.
   *   <li>Then return first element Name is {@code [D}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[D'; then return first element Name is '[D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenD_thenReturnFirstElementNameIsD()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[D");

    // Assert
    assertEquals("[D", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Descriptor}.
   *   <li>Then return first element Name is {@code double}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when 'Descriptor'; then return first element Name is 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenDescriptor_thenReturnFirstElementNameIsDouble()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("Descriptor");

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
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [F}.
   *   <li>Then return first element Name is {@code [F}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[F'; then return first element Name is '[F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenF_thenReturnFirstElementNameIsF()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[F");

    // Assert
    assertEquals("[F", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [I}.
   *   <li>Then return first element Name is {@code [I}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[I'; then return first element Name is '[I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenI_thenReturnFirstElementNameIsI()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[I");

    // Assert
    assertEquals("[I", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [J}.
   *   <li>Then return first element Name is {@code [J}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[J'; then return first element Name is '[J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenJ_thenReturnFirstElementNameIsJ()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[J");

    // Assert
    assertEquals("[J", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return eleventh element Name is {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when 'java.lang.Boolean'; then return eleventh element Name is 'byte'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenJavaLangBoolean_thenReturnEleventhElementNameIsByte()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Boolean");

    // Assert
    assertEquals("byte", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[15]);
    assertNull(actualStringtypesToClassesResult[Short.SIZE]);
    assertEquals(17, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Integer}.
   *   <li>Then return eleventh element Name is {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when 'java.lang.Integer'; then return eleventh element Name is 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenJavaLangInteger_thenReturnEleventhElementNameIsInt()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Integer");

    // Assert
    assertEquals("int", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[15]);
    assertNull(actualStringtypesToClassesResult[Short.SIZE]);
    assertEquals(17, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Short}.
   *   <li>Then return eleventh element Name is {@code short}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when 'java.lang.Short'; then return eleventh element Name is 'short'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenJavaLangShort_thenReturnEleventhElementNameIsShort()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("java.lang.Short");

    // Assert
    assertEquals("short", (actualStringtypesToClassesResult[10]).getName());
    assertNull(actualStringtypesToClassesResult[0]);
    assertNull(actualStringtypesToClassesResult[11]);
    assertNull(actualStringtypesToClassesResult[12]);
    assertNull(actualStringtypesToClassesResult[13]);
    assertNull(actualStringtypesToClassesResult[14]);
    assertEquals(15, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [S}.
   *   <li>Then return first element Name is {@code [S}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[S'; then return first element Name is '[S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenS_thenReturnFirstElementNameIsS()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[S");

    // Assert
    assertEquals("[S", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}.
   *
   * <ul>
   *   <li>When {@code [Z}.
   *   <li>Then return first element Name is {@code [Z}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#stringtypesToClasses(String)}
   */
  @Test
  @DisplayName(
      "Test stringtypesToClasses(String); when '[Z'; then return first element Name is '[Z'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class[] proguard.evaluation.value.ReflectiveMethodCallUtil.stringtypesToClasses(java.lang.String)"
  })
  void testStringtypesToClasses_whenZ_thenReturnFirstElementNameIsZ()
      throws ClassNotFoundException {
    // Arrange and Act
    Class<?>[] actualStringtypesToClassesResult =
        ReflectiveMethodCallUtil.stringtypesToClasses("[Z");

    // Assert
    assertEquals("[Z", (actualStringtypesToClassesResult[0]).getName());
    assertEquals(1, actualStringtypesToClassesResult.length);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>Given {@code [B}.
   *   <li>When {@link DetailedArrayReferenceValue} {@link TypedReferenceValue#getType()} return
   *       {@code [B}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); given '[B'; when DetailedArrayReferenceValue getType() return '[B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_givenB_whenDetailedArrayReferenceValueGetTypeReturnB() {
    // Arrange
    DetailedArrayReferenceValue value = mock(DetailedArrayReferenceValue.class);
    when(value.value()).thenThrow(new IllegalArgumentException("[B"));
    when(value.getType()).thenReturn("[B");
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ReflectiveMethodCallUtil.getObjectForValue(value, expectedType));
    verify(value).value();
    verify(value).getType();
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); given 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_givenType_thenThrowIllegalArgumentException() {
    // Arrange
    DetailedArrayReferenceValue value = mock(DetailedArrayReferenceValue.class);
    when(value.value()).thenThrow(new IllegalArgumentException("[B"));
    when(value.getType()).thenReturn("Type");
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ReflectiveMethodCallUtil.getObjectForValue(value, expectedType));
    verify(value).value();
    verify(value).getType();
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName("Test getObjectForValue(Value, Class); given 'Value'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_givenValue_thenReturnValue() {
    // Arrange
    DetailedArrayReferenceValue value = mock(DetailedArrayReferenceValue.class);
    when(value.value()).thenReturn("Value");
    when(value.getType()).thenReturn("Type");
    Class<Object> expectedType = Object.class;

    // Act
    Object actualObjectForValue = ReflectiveMethodCallUtil.getObjectForValue(value, expectedType);

    // Assert
    verify(value).value();
    verify(value).getType();
    assertEquals("Value", actualObjectForValue);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>Then return intValue is minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); then return intValue is minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_thenReturnIntValueIsMinusOneHundredTwentyEight() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        -128,
        ((Integer)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, expectedType))
            .intValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when DOUBLE_VALUE_0; then return doubleValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenDouble_value_0_thenReturnDoubleValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0d,
        ((Double)
                ReflectiveMethodCallUtil.getObjectForValue(
                    ParticularValueFactory.DOUBLE_VALUE_0, expectedType))
            .doubleValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when DOUBLE_VALUE; then return doubleValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenDouble_value_thenReturnDoubleValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0d,
        ((Double)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicValueFactory.DOUBLE_VALUE, expectedType))
            .doubleValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when FLOAT_VALUE_0; then return floatValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenFloat_value_0_thenReturnFloatValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0f,
        ((Float)
                ReflectiveMethodCallUtil.getObjectForValue(
                    ParticularValueFactory.FLOAT_VALUE_0, expectedType))
            .floatValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when FLOAT_VALUE; then return floatValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenFloat_value_thenReturnFloatValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0f,
        ((Float)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicValueFactory.FLOAT_VALUE, expectedType))
            .floatValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when INTEGER_VALUE; then return intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenInteger_value_thenReturnIntValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0,
        ((Integer)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicValueFactory.INTEGER_VALUE, expectedType))
            .intValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when 'java.lang.Boolean'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenJavaLangBoolean_thenReturnFalse() {
    // Arrange
    Class<Boolean> expectedType = Boolean.class;

    // Act and Assert
    assertFalse(
        (Boolean)
            ReflectiveMethodCallUtil.getObjectForValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, expectedType));
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when LONG_VALUE; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenLong_value_thenReturnLongValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0L,
        ((Long)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicValueFactory.LONG_VALUE, expectedType))
            .longValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName("Test getObjectForValue(Value, Class); when REFERENCE_VALUE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenReference_value_thenReturnNull() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertNull(
        ReflectiveMethodCallUtil.getObjectForValue(
            BasicValueFactory.REFERENCE_VALUE, expectedType));
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link Byte#TYPE}.
   *   <li>Then return byteValue is {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when TYPE; then return byteValue is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenType_thenReturnByteValueIsMin_value() {
    // Arrange, Act and Assert
    assertEquals(
        Byte.MIN_VALUE,
        ((Byte)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, Byte.TYPE))
            .byteValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link Character#TYPE}.
   *   <li>Then return charValue is {@code ﾀ}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName("Test getObjectForValue(Value, Class); when TYPE; then return charValue is 'ﾀ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenType_thenReturnCharValueIs() {
    // Arrange, Act and Assert
    assertEquals(
        'ﾀ',
        ((Character)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, Character.TYPE))
            .charValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TYPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName("Test getObjectForValue(Value, Class); when TYPE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (Boolean)
            ReflectiveMethodCallUtil.getObjectForValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, Boolean.TYPE));
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link Short#TYPE}.
   *   <li>Then return shortValue is minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName(
      "Test getObjectForValue(Value, Class); when TYPE; then return shortValue is minus one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenType_thenReturnShortValueIsMinusOneHundredTwentyEight() {
    // Arrange, Act and Assert
    assertEquals(
        (short) -128,
        ((Short)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, Short.TYPE))
            .shortValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#UNKNOWN_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @DisplayName("Test getObjectForValue(Value, Class); when UNKNOWN_VALUE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.ReflectiveMethodCallUtil.getObjectForValue(proguard.evaluation.value.Value, java.lang.Class)"
  })
  void testGetObjectForValue_whenUnknown_value_thenReturnNull() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertNull(
        ReflectiveMethodCallUtil.getObjectForValue(BasicValueFactory.UNKNOWN_VALUE, expectedType));
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [B}.
   *   <li>Then return Name is {@code [B}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[B'; then return Name is '[B'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenB_thenReturnNameIsB() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[B");

    // Assert
    assertEquals("[B", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [C}.
   *   <li>Then return Name is {@code [C}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[C'; then return Name is '[C'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenC_thenReturnNameIsC() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[C");

    // Assert
    assertEquals("[C", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [D}.
   *   <li>Then return Name is {@code [D}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[D'; then return Name is '[D'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenD_thenReturnNameIsD() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[D");

    // Assert
    assertEquals("[D", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [F}.
   *   <li>Then return Name is {@code [F}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[F'; then return Name is '[F'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenF_thenReturnNameIsF() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[F");

    // Assert
    assertEquals("[F", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [I}.
   *   <li>Then return Name is {@code [I}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[I'; then return Name is '[I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenI_thenReturnNameIsI() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[I");

    // Assert
    assertEquals("[I", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code Internal Array Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when 'Internal Array Type'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenInternalArrayType_thenReturnNull() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("Internal Array Type");

    // Assert
    assertNull(actualClassForArray);
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [J}.
   *   <li>Then return Name is {@code [J}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[J'; then return Name is '[J'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenJ_thenReturnNameIsJ() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[J");

    // Assert
    assertEquals("[J", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [Ljava/lang/String}.
   *   <li>Then return Name is {@code [LString;}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName(
      "Test getClassForArray(String); when '[Ljava/lang/String'; then return Name is '[Ljava.lang.String;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenLjavaLangString_thenReturnNameIsLjavaLangString() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[Ljava/lang/String");

    // Assert
    assertEquals("[Ljava.lang.String;", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [S}.
   *   <li>Then return Name is {@code [S}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[S'; then return Name is '[S'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenS_thenReturnNameIsS() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[S");

    // Assert
    assertEquals("[S", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForArray(String)}.
   *
   * <ul>
   *   <li>When {@code [Z}.
   *   <li>Then return Name is {@code [Z}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForArray(String)}
   */
  @Test
  @DisplayName("Test getClassForArray(String); when '[Z'; then return Name is '[Z'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForArray(java.lang.String)"
  })
  void testGetClassForArray_whenZ_thenReturnNameIsZ() {
    // Arrange and Act
    Class<?> actualClassForArray = ReflectiveMethodCallUtil.getClassForArray("[Z");

    // Assert
    assertEquals("[Z", actualClassForArray.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'A'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ReflectiveMethodCallUtil.getClassForPrimitive('A'));
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return Name is {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'B'; then return Name is 'byte'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenB_thenReturnNameIsByte() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('B');

    // Assert
    assertEquals("byte", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   *   <li>Then return Name is {@code char}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'C'; then return Name is 'char'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenC_thenReturnNameIsChar() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('C');

    // Assert
    assertEquals("char", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return Name is {@code double}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'D'; then return Name is 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenD_thenReturnNameIsDouble() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('D');

    // Assert
    assertEquals("double", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return Name is {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'F'; then return Name is 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenF_thenReturnNameIsFloat() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('F');

    // Assert
    assertEquals("float", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return Name is {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'I'; then return Name is 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenI_thenReturnNameIsInt() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('I');

    // Assert
    assertEquals("int", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return Name is {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'J'; then return Name is 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenJ_thenReturnNameIsLong() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('J');

    // Assert
    assertEquals("long", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code S}.
   *   <li>Then return Name is {@code short}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'S'; then return Name is 'short'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenS_thenReturnNameIsShort() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('S');

    // Assert
    assertEquals("short", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code V}.
   *   <li>Then return Name is {@code void}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'V'; then return Name is 'void'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenV_thenReturnNameIsVoid() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('V');

    // Assert
    assertEquals("void", actualClassForPrimitive.getName());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return Name is {@code boolean}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getClassForPrimitive(char)}
   */
  @Test
  @DisplayName("Test getClassForPrimitive(char); when 'Z'; then return Name is 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Class proguard.evaluation.value.ReflectiveMethodCallUtil.getClassForPrimitive(char)"
  })
  void testGetClassForPrimitive_whenZ_thenReturnNameIsBoolean() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('Z');

    // Assert
    assertEquals("boolean", actualClassForPrimitive.getName());
  }
}
