package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BasicMethodInfoDiffblueTest {
  /**
   * Test {@link BasicMethodInfo#BasicMethodInfo(MethodInfo)}.
   *
   * <p>Method under test: {@link BasicMethodInfo#BasicMethodInfo(MethodInfo)}
   */
  @Test
  @DisplayName("Test new BasicMethodInfo(MethodInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicMethodInfo.<init>(MethodInfo)"})
  void testNewBasicMethodInfo() {
    // Arrange
    BasicMethodInfo method =
        new BasicMethodInfo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    BasicMethodInfo actualBasicMethodInfo = new BasicMethodInfo(method);

    // Assert
    assertEquals(method, actualBasicMethodInfo);
  }

  /**
   * Test {@link BasicMethodInfo#BasicMethodInfo(MethodInfo)}.
   *
   * <ul>
   *   <li>Then return Descriptor PrettyReturnType is {@code Class}.
   * </ul>
   *
   * <p>Method under test: {@link BasicMethodInfo#BasicMethodInfo(MethodInfo)}
   */
  @Test
  @DisplayName(
      "Test new BasicMethodInfo(MethodInfo); then return Descriptor PrettyReturnType is 'Class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicMethodInfo.<init>(MethodInfo)"})
  void testNewBasicMethodInfo_thenReturnDescriptorPrettyReturnTypeIsClass() {
    // Arrange and Act
    BasicMethodInfo actualBasicMethodInfo =
        new BasicMethodInfo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    MethodDescriptor descriptor = actualBasicMethodInfo.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertFalse(descriptor.isIncomplete());
    assertEquals(ClassConstants.FIELD_TYPE_TYPE, descriptor.getReturnType());
    assertEquals(
        ClassConstants.METHOD_NAME_FIND_LOADED_CLASS, actualBasicMethodInfo.getMethodName());
    assertEquals(ClassConstants.TYPE_JAVA_LANG_STRING, argumentTypes.get(0));
  }

  /**
   * Test {@link BasicMethodInfo#BasicMethodInfo(String, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Then return {@code Method Name}.
   * </ul>
   *
   * <p>Method under test: {@link BasicMethodInfo#BasicMethodInfo(String, MethodDescriptor)}
   */
  @Test
  @DisplayName("Test new BasicMethodInfo(String, MethodDescriptor); then return 'Method Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicMethodInfo.<init>(String, MethodDescriptor)"})
  void testNewBasicMethodInfo_thenReturnMethodName() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());

    // Act
    BasicMethodInfo actualBasicMethodInfo = new BasicMethodInfo("Method Name", descriptor);

    // Assert
    assertEquals("Method Name", actualBasicMethodInfo.getMethodName());
    assertSame(descriptor, actualBasicMethodInfo.getDescriptor());
  }

  /**
   * Test {@link BasicMethodInfo#equals(Object)}, and {@link BasicMethodInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicMethodInfo#equals(Object)}
   *   <li>{@link BasicMethodInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    BasicMethodInfo basicMethodInfo = new BasicMethodInfo("Method Name", descriptor);
    MethodDescriptor descriptor2 = new MethodDescriptor("Return Type", new ArrayList<>());
    BasicMethodInfo basicMethodInfo2 = new BasicMethodInfo("Method Name", descriptor2);

    // Act and Assert
    assertEquals(basicMethodInfo, basicMethodInfo2);
    assertEquals(basicMethodInfo.hashCode(), basicMethodInfo2.hashCode());
  }

  /**
   * Test {@link BasicMethodInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicMethodInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    BasicMethodInfo basicMethodInfo =
        new BasicMethodInfo("proguard.classfile.BasicMethodInfo", descriptor);
    MethodDescriptor descriptor2 = new MethodDescriptor("Return Type", new ArrayList<>());
    BasicMethodInfo basicMethodInfo2 = new BasicMethodInfo("Method Name", descriptor2);

    // Act and Assert
    assertNotEquals(basicMethodInfo, basicMethodInfo2);
  }

  /**
   * Test {@link BasicMethodInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicMethodInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodDescriptor descriptor =
        new MethodDescriptor("proguard.classfile.MethodDescriptor", new ArrayList<>());
    BasicMethodInfo basicMethodInfo = new BasicMethodInfo("Method Name", descriptor);
    MethodDescriptor descriptor2 = new MethodDescriptor("Return Type", new ArrayList<>());
    BasicMethodInfo basicMethodInfo2 = new BasicMethodInfo("Method Name", descriptor2);

    // Act and Assert
    assertNotEquals(basicMethodInfo, basicMethodInfo2);
  }

  /**
   * Test {@link BasicMethodInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicMethodInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MethodDescriptor descriptor = new MethodDescriptor("Return Type", new ArrayList<>());
    BasicMethodInfo basicMethodInfo = new BasicMethodInfo("Method Name", descriptor);

    // Act and Assert
    assertNotEquals(basicMethodInfo, 1);
  }
}
