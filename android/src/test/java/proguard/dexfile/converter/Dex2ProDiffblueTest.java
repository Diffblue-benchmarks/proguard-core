package proguard.dexfile.converter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.ConstantPoolEditor;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

class Dex2ProDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dex2Pro#Dex2Pro()}
   *   <li>{@link Dex2Pro#usePrimitiveArrayConstants(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.converter.Dex2Pro.<init>()",
    "proguard.dexfile.converter.Dex2Pro proguard.dexfile.converter.Dex2Pro.usePrimitiveArrayConstants(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Dex2Pro actualDex2Pro = new Dex2Pro();

    // Assert
    assertSame(actualDex2Pro, actualDex2Pro.usePrimitiveArrayConstants(true));
  }

  /**
   * Test {@link Dex2Pro#Dex2Pro(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#Dex2Pro(int)}
   */
  @Test
  @DisplayName("Test new Dex2Pro(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.converter.Dex2Pro.<init>(int)"})
  void testNewDex2Pro_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Dex2Pro(0));
  }

  /**
   * Test {@link Dex2Pro#shutdown(int)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#shutdown(int)}
   */
  @Test
  @DisplayName("Test shutdown(int); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.converter.Dex2Pro.shutdown(int)"})
  void testShutdown_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Dex2Pro(1)).shutdown(10));
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Given eight.
   *   <li>Then calls {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   *       String, Clazz, Method)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); given eight; then calls addInterfaceMethodrefConstant(String, String, String, Clazz, Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_givenEight_thenCallsAddInterfaceMethodrefConstant() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addInterfaceMethodrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Method>any()))
        .thenReturn(2);
    when(constantPoolEditor.addStringConstant(Mockito.<String>any())).thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getMethod())
        .thenReturn(
            new proguard.dexfile.reader.Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    when(mh.getType()).thenReturn(8);

    // Act
    int actualConvertBootstrapMethodResult =
        Dex2Pro.convertBootstrapMethod(programClass, constantPoolEditor, mh, new Object[] {"Args"});

    // Assert
    verify(constantPoolEditor)
        .addInterfaceMethodrefConstant(
            eq("Owner"),
            eq("Name"),
            eq("(Parameter Types)Return Type"),
            (Clazz) isNull(),
            (Method) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(9), eq(2));
    verify(constantPoolEditor).addStringConstant(eq("Args"));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getMethod();
    verify(mh).getType();
    Attribute[] attributeArray = programClass.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof BootstrapMethodsAttribute);
    assertNull(attribute.getProcessingInfo());
    BootstrapMethodInfo[] bootstrapMethodInfoArray =
        ((BootstrapMethodsAttribute) attribute).bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, attribute.getProcessingFlags());
    assertEquals(0, bootstrapMethodInfo.getProcessingFlags());
    assertEquals(0, actualConvertBootstrapMethodResult);
    assertEquals(1, attributeArray.length);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, programClass.u2attributesCount);
    assertEquals(1, bootstrapMethodInfo.u2methodArgumentCount);
    assertEquals(1, ((BootstrapMethodsAttribute) attribute).u2bootstrapMethodsCount);
    assertEquals(2, ((BootstrapMethodsAttribute) attribute).u2attributeNameIndex);
    assertEquals(2, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {2}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Given five.
   *   <li>When {@link MethodHandle} {@link MethodHandle#getType()} return five.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); given five; when MethodHandle getType() return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_givenFive_whenMethodHandleGetTypeReturnFive() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addMethodrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Method>any()))
        .thenReturn(2);
    when(constantPoolEditor.addStringConstant(Mockito.<String>any())).thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getMethod())
        .thenReturn(
            new proguard.dexfile.reader.Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    when(mh.getType()).thenReturn(5);

    // Act
    int actualConvertBootstrapMethodResult =
        Dex2Pro.convertBootstrapMethod(programClass, constantPoolEditor, mh, new Object[] {"Args"});

    // Assert
    verify(constantPoolEditor).addMethodHandleConstant(eq(5), eq(2));
    verify(constantPoolEditor)
        .addMethodrefConstant(
            eq("Owner"),
            eq("Name"),
            eq("(Parameter Types)Return Type"),
            (Clazz) isNull(),
            (Method) isNull());
    verify(constantPoolEditor).addStringConstant(eq("Args"));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getMethod();
    verify(mh).getType();
    Attribute[] attributeArray = programClass.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof BootstrapMethodsAttribute);
    assertNull(attribute.getProcessingInfo());
    BootstrapMethodInfo[] bootstrapMethodInfoArray =
        ((BootstrapMethodsAttribute) attribute).bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, attribute.getProcessingFlags());
    assertEquals(0, bootstrapMethodInfo.getProcessingFlags());
    assertEquals(0, actualConvertBootstrapMethodResult);
    assertEquals(1, attributeArray.length);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, programClass.u2attributesCount);
    assertEquals(1, bootstrapMethodInfo.u2methodArgumentCount);
    assertEquals(1, ((BootstrapMethodsAttribute) attribute).u2bootstrapMethodsCount);
    assertEquals(2, ((BootstrapMethodsAttribute) attribute).u2attributeNameIndex);
    assertEquals(2, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {2}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>Then calls {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz,
   *       Method)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); given four; then calls addMethodrefConstant(String, String, String, Clazz, Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_givenFour_thenCallsAddMethodrefConstant() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addMethodrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Method>any()))
        .thenReturn(2);
    when(constantPoolEditor.addStringConstant(Mockito.<String>any())).thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getMethod())
        .thenReturn(
            new proguard.dexfile.reader.Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    when(mh.getType()).thenReturn(4);

    // Act
    int actualConvertBootstrapMethodResult =
        Dex2Pro.convertBootstrapMethod(programClass, constantPoolEditor, mh, new Object[] {"Args"});

    // Assert
    verify(constantPoolEditor).addMethodHandleConstant(eq(6), eq(2));
    verify(constantPoolEditor)
        .addMethodrefConstant(
            eq("Owner"),
            eq("Name"),
            eq("(Parameter Types)Return Type"),
            (Clazz) isNull(),
            (Method) isNull());
    verify(constantPoolEditor).addStringConstant(eq("Args"));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getMethod();
    verify(mh).getType();
    Attribute[] attributeArray = programClass.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof BootstrapMethodsAttribute);
    assertNull(attribute.getProcessingInfo());
    BootstrapMethodInfo[] bootstrapMethodInfoArray =
        ((BootstrapMethodsAttribute) attribute).bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, attribute.getProcessingFlags());
    assertEquals(0, bootstrapMethodInfo.getProcessingFlags());
    assertEquals(0, actualConvertBootstrapMethodResult);
    assertEquals(1, attributeArray.length);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, programClass.u2attributesCount);
    assertEquals(1, bootstrapMethodInfo.u2methodArgumentCount);
    assertEquals(1, ((BootstrapMethodsAttribute) attribute).u2bootstrapMethodsCount);
    assertEquals(2, ((BootstrapMethodsAttribute) attribute).u2attributeNameIndex);
    assertEquals(2, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {2}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link MethodHandle#getField()}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); given one; then calls getField()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_givenOne_thenCallsGetField() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addStringConstant(Mockito.<String>any())).thenReturn(2);
    when(constantPoolEditor.addFieldrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Field>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getType()).thenReturn(1);
    when(mh.getField()).thenReturn(new proguard.dexfile.reader.Field("Owner", "Name", "Type"));

    // Act
    int actualConvertBootstrapMethodResult =
        Dex2Pro.convertBootstrapMethod(programClass, constantPoolEditor, mh, new Object[] {"Args"});

    // Assert
    verify(constantPoolEditor)
        .addFieldrefConstant(
            eq("Owner"), eq("Name"), eq("Type"), (Clazz) isNull(), (Field) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(2), eq(2));
    verify(constantPoolEditor).addStringConstant(eq("Args"));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getField();
    verify(mh).getType();
    Attribute[] attributeArray = programClass.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof BootstrapMethodsAttribute);
    assertNull(attribute.getProcessingInfo());
    BootstrapMethodInfo[] bootstrapMethodInfoArray =
        ((BootstrapMethodsAttribute) attribute).bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, attribute.getProcessingFlags());
    assertEquals(0, bootstrapMethodInfo.getProcessingFlags());
    assertEquals(0, actualConvertBootstrapMethodResult);
    assertEquals(1, attributeArray.length);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, programClass.u2attributesCount);
    assertEquals(1, bootstrapMethodInfo.u2methodArgumentCount);
    assertEquals(1, ((BootstrapMethodsAttribute) attribute).u2bootstrapMethodsCount);
    assertEquals(2, ((BootstrapMethodsAttribute) attribute).u2attributeNameIndex);
    assertEquals(2, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {2}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Given six.
   *   <li>When {@link MethodHandle} {@link MethodHandle#getType()} return six.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); given six; when MethodHandle getType() return six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_givenSix_whenMethodHandleGetTypeReturnSix() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addMethodrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Method>any()))
        .thenReturn(2);
    when(constantPoolEditor.addStringConstant(Mockito.<String>any())).thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getMethod())
        .thenReturn(
            new proguard.dexfile.reader.Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    when(mh.getType()).thenReturn(6);

    // Act
    int actualConvertBootstrapMethodResult =
        Dex2Pro.convertBootstrapMethod(programClass, constantPoolEditor, mh, new Object[] {"Args"});

    // Assert
    verify(constantPoolEditor).addMethodHandleConstant(eq(7), eq(2));
    verify(constantPoolEditor)
        .addMethodrefConstant(
            eq("Owner"),
            eq("Name"),
            eq("(Parameter Types)Return Type"),
            (Clazz) isNull(),
            (Method) isNull());
    verify(constantPoolEditor).addStringConstant(eq("Args"));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getMethod();
    verify(mh).getType();
    Attribute[] attributeArray = programClass.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof BootstrapMethodsAttribute);
    assertNull(attribute.getProcessingInfo());
    BootstrapMethodInfo[] bootstrapMethodInfoArray =
        ((BootstrapMethodsAttribute) attribute).bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, attribute.getProcessingFlags());
    assertEquals(0, bootstrapMethodInfo.getProcessingFlags());
    assertEquals(0, actualConvertBootstrapMethodResult);
    assertEquals(1, attributeArray.length);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, programClass.u2attributesCount);
    assertEquals(1, bootstrapMethodInfo.u2methodArgumentCount);
    assertEquals(1, ((BootstrapMethodsAttribute) attribute).u2bootstrapMethodsCount);
    assertEquals(2, ((BootstrapMethodsAttribute) attribute).u2attributeNameIndex);
    assertEquals(2, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {2}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantPoolEditor#addIntegerConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); then calls addIntegerConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_thenCallsAddIntegerConstant() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addIntegerConstant(anyInt())).thenReturn(2);
    when(constantPoolEditor.addInterfaceMethodrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Method>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getMethod())
        .thenReturn(
            new proguard.dexfile.reader.Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    when(mh.getType()).thenReturn(8);

    // Act
    int actualConvertBootstrapMethodResult =
        Dex2Pro.convertBootstrapMethod(programClass, constantPoolEditor, mh, new Object[] {true});

    // Assert
    verify(constantPoolEditor).addIntegerConstant(eq(1));
    verify(constantPoolEditor)
        .addInterfaceMethodrefConstant(
            eq("Owner"),
            eq("Name"),
            eq("(Parameter Types)Return Type"),
            (Clazz) isNull(),
            (Method) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(9), eq(2));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getMethod();
    verify(mh).getType();
    Attribute[] attributeArray = programClass.attributes;
    Attribute attribute = attributeArray[0];
    assertTrue(attribute instanceof BootstrapMethodsAttribute);
    assertNull(attribute.getProcessingInfo());
    BootstrapMethodInfo[] bootstrapMethodInfoArray =
        ((BootstrapMethodsAttribute) attribute).bootstrapMethods;
    BootstrapMethodInfo bootstrapMethodInfo = bootstrapMethodInfoArray[0];
    assertNull(bootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, attribute.getProcessingFlags());
    assertEquals(0, bootstrapMethodInfo.getProcessingFlags());
    assertEquals(0, actualConvertBootstrapMethodResult);
    assertEquals(1, attributeArray.length);
    assertEquals(1, bootstrapMethodInfoArray.length);
    assertEquals(1, programClass.u2attributesCount);
    assertEquals(1, bootstrapMethodInfo.u2methodArgumentCount);
    assertEquals(1, ((BootstrapMethodsAttribute) attribute).u2bootstrapMethodsCount);
    assertEquals(2, ((BootstrapMethodsAttribute) attribute).u2attributeNameIndex);
    assertEquals(2, bootstrapMethodInfo.u2methodHandleIndex);
    assertArrayEquals(new int[] {2}, bootstrapMethodInfo.u2methodArguments);
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_thenThrowIllegalArgumentException() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addMethodrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Method>any()))
        .thenThrow(new IllegalArgumentException("BootstrapMethods"));
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);
    MethodHandle mh = mock(MethodHandle.class);
    when(mh.getMethod())
        .thenReturn(
            new proguard.dexfile.reader.Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    when(mh.getType()).thenReturn(4);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass, constantPoolEditor, mh, new Object[] {"Args"}));
    verify(constantPoolEditor)
        .addMethodrefConstant(
            eq("Owner"),
            eq("Name"),
            eq("(Parameter Types)Return Type"),
            (Clazz) isNull(),
            (Method) isNull());
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
    verify(mh, atLeast(1)).getMethod();
    verify(mh).getType();
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_thenThrowUnsupportedOperationException() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addFieldrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Field>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass,
                constantPoolEditor,
                new MethodHandle(1, new proguard.dexfile.reader.Field("Owner", "Name", "Type")),
                new Object[] {proguard.dexfile.ir.expr.Constant.Null}));
    verify(constantPoolEditor)
        .addFieldrefConstant(
            eq("Owner"), eq("Name"), eq("Type"), (Clazz) isNull(), (Field) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(2), eq(2));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>When {@link proguard.dexfile.reader.Field#Field(String, String, String)} with owner is
   *       {@code ]} and {@code Name} and {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); when Field(String, String, String) with owner is ']' and 'Name' and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_whenFieldWithOwnerIsRightSquareBracketAndNameAndType() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addFieldrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Field>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass,
                constantPoolEditor,
                new MethodHandle(1, new proguard.dexfile.reader.Field("]", "Name", "Type")),
                new Object[] {proguard.dexfile.ir.expr.Constant.Null}));
    verify(constantPoolEditor)
        .addFieldrefConstant(eq("]"), eq("Name"), eq("Type"), (Clazz) isNull(), (Field) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(2), eq(2));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>When {@link MethodHandle#MethodHandle(int, Field)} with type is minus one and field is
   *       {@link proguard.dexfile.reader.Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); when MethodHandle(int, Field) with type is minus one and field is Field(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_whenMethodHandleWithTypeIsMinusOneAndFieldIsField() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass,
                constantPoolEditor,
                new MethodHandle(-1, new proguard.dexfile.reader.Field("Owner", "Name", "Type")),
                new Object[] {proguard.dexfile.ir.expr.Constant.Null}));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>When {@link MethodHandle#MethodHandle(int, Field)} with type is three and field is {@link
   *       proguard.dexfile.reader.Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); when MethodHandle(int, Field) with type is three and field is Field(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_whenMethodHandleWithTypeIsThreeAndFieldIsField() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addFieldrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Field>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass,
                constantPoolEditor,
                new MethodHandle(3, new proguard.dexfile.reader.Field("Owner", "Name", "Type")),
                new Object[] {proguard.dexfile.ir.expr.Constant.Null}));
    verify(constantPoolEditor)
        .addFieldrefConstant(
            eq("Owner"), eq("Name"), eq("Type"), (Clazz) isNull(), (Field) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(1), eq(2));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>When {@link MethodHandle#MethodHandle(int, Field)} with type is two and field is {@link
   *       proguard.dexfile.reader.Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); when MethodHandle(int, Field) with type is two and field is Field(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_whenMethodHandleWithTypeIsTwoAndFieldIsField() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addFieldrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Field>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass,
                constantPoolEditor,
                new MethodHandle(2, new proguard.dexfile.reader.Field("Owner", "Name", "Type")),
                new Object[] {proguard.dexfile.ir.expr.Constant.Null}));
    verify(constantPoolEditor)
        .addFieldrefConstant(
            eq("Owner"), eq("Name"), eq("Type"), (Clazz) isNull(), (Field) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(3), eq(2));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
  }

  /**
   * Test {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>When {@link MethodHandle#MethodHandle(int, Field)} with type is zero and field is {@link
   *       proguard.dexfile.reader.Field#Field(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link Dex2Pro#convertBootstrapMethod(ProgramClass, ConstantPoolEditor,
   * MethodHandle, Object[])}
   */
  @Test
  @DisplayName(
      "Test convertBootstrapMethod(ProgramClass, ConstantPoolEditor, MethodHandle, Object[]); when MethodHandle(int, Field) with type is zero and field is Field(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.converter.Dex2Pro.convertBootstrapMethod(proguard.classfile.ProgramClass, proguard.classfile.editor.ConstantPoolEditor, proguard.dexfile.reader.MethodHandle, java.lang.Object[])"
  })
  void testConvertBootstrapMethod_whenMethodHandleWithTypeIsZeroAndFieldIsField() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = mock(ConstantPoolEditor.class);
    when(constantPoolEditor.addFieldrefConstant(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Clazz>any(),
            Mockito.<Field>any()))
        .thenReturn(2);
    when(constantPoolEditor.addMethodHandleConstant(anyInt(), anyInt())).thenReturn(2);
    when(constantPoolEditor.addUtf8Constant(Mockito.<String>any())).thenReturn(2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            Dex2Pro.convertBootstrapMethod(
                programClass,
                constantPoolEditor,
                new MethodHandle(0, new proguard.dexfile.reader.Field("Owner", "Name", "Type")),
                new Object[] {proguard.dexfile.ir.expr.Constant.Null}));
    verify(constantPoolEditor)
        .addFieldrefConstant(
            eq("Owner"), eq("Name"), eq("Type"), (Clazz) isNull(), (Field) isNull());
    verify(constantPoolEditor).addMethodHandleConstant(eq(4), eq(2));
    verify(constantPoolEditor).addUtf8Constant(eq("BootstrapMethods"));
  }
}
