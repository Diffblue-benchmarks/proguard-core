package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReflectiveMethodCallUtilDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_thenReturnEleventhElementNameIsChar()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenB_thenReturnFirstElementNameIsB()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenC_thenReturnFirstElementNameIsC()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenD_thenReturnFirstElementNameIsD()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenDescriptor_thenReturnFirstElementNameIsDouble()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenF_thenReturnFirstElementNameIsF()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenI_thenReturnFirstElementNameIsI()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenJ_thenReturnFirstElementNameIsJ()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenJavaLangBoolean_thenReturnEleventhElementNameIsByte()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenJavaLangInteger_thenReturnEleventhElementNameIsInt()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenJavaLangShort_thenReturnEleventhElementNameIsShort()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenS_thenReturnFirstElementNameIsS()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class[] ReflectiveMethodCallUtil.stringtypesToClasses(String)"})
  public void testStringtypesToClasses_whenZ_thenReturnFirstElementNameIsZ()
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
   *   <li>Then return intValue is minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_thenReturnIntValueIsMinusOneHundredTwentyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenDouble_value_0_thenReturnDoubleValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0d,
        ((Double)
                ReflectiveMethodCallUtil.getObjectForValue(
                    ParticularValueFactory.DOUBLE_VALUE_0, expectedType))
            .doubleValue(),
        0.0);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenDouble_value_thenReturnDoubleValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0d,
        ((Double)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicValueFactory.DOUBLE_VALUE, expectedType))
            .doubleValue(),
        0.0);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenFloat_value_0_thenReturnFloatValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0f,
        ((Float)
                ReflectiveMethodCallUtil.getObjectForValue(
                    ParticularValueFactory.FLOAT_VALUE_0, expectedType))
            .floatValue(),
        0.0f);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenFloat_value_thenReturnFloatValueIsZero() {
    // Arrange
    Class<Object> expectedType = Object.class;

    // Act and Assert
    assertEquals(
        0.0f,
        ((Float)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicValueFactory.FLOAT_VALUE, expectedType))
            .floatValue(),
        0.0f);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenInteger_value_thenReturnIntValueIsZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenJavaLangBoolean_thenReturnFalse() {
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
   *   <li>When {@code Byte}.
   *   <li>Then return byteValue is {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenJavaLangByte_thenReturnByteValueIsMin_value() {
    // Arrange
    Class<Byte> expectedType = Byte.class;

    // Act and Assert
    assertEquals(
        Byte.MIN_VALUE,
        ((Byte)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, expectedType))
            .byteValue());
  }

  /**
   * Test {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}.
   *
   * <ul>
   *   <li>When {@code Character}.
   *   <li>Then return charValue is {@code ﾀ}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveMethodCallUtil#getObjectForValue(Value, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenJavaLangCharacter_thenReturnCharValueIs() {
    // Arrange
    Class<Character> expectedType = Character.class;

    // Act and Assert
    assertEquals(
        'ﾀ',
        ((Character)
                ReflectiveMethodCallUtil.getObjectForValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, expectedType))
            .charValue());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenLong_value_thenReturnLongValueIsZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenReference_value_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenType_thenReturnByteValueIsMin_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenType_thenReturnCharValueIs() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenType_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenType_thenReturnShortValueIsMinusOneHundredTwentyEight() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReflectiveMethodCallUtil.getObjectForValue(Value, Class)"})
  public void testGetObjectForValue_whenUnknown_value_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenB_thenReturnNameIsB() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenC_thenReturnNameIsC() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenD_thenReturnNameIsD() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenF_thenReturnNameIsF() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenI_thenReturnNameIsI() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenInternalArrayType_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenJ_thenReturnNameIsJ() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenLjavaLangString_thenReturnNameIsLjavaLangString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenS_thenReturnNameIsS() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForArray(String)"})
  public void testGetClassForArray_whenZ_thenReturnNameIsZ() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenA_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenB_thenReturnNameIsByte() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenC_thenReturnNameIsChar() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenD_thenReturnNameIsDouble() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenF_thenReturnNameIsFloat() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenI_thenReturnNameIsInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenJ_thenReturnNameIsLong() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenS_thenReturnNameIsShort() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenV_thenReturnNameIsVoid() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class ReflectiveMethodCallUtil.getClassForPrimitive(char)"})
  public void testGetClassForPrimitive_whenZ_thenReturnNameIsBoolean() {
    // Arrange and Act
    Class<?> actualClassForPrimitive = ReflectiveMethodCallUtil.getClassForPrimitive('Z');

    // Assert
    assertEquals("boolean", actualClassForPrimitive.getName());
  }
}
