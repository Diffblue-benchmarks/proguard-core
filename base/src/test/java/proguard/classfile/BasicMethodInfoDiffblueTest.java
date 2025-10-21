package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BasicMethodInfoDiffblueTest {
  /**
   * Test {@link BasicMethodInfo#BasicMethodInfo(MethodInfo)}.
   *
   * <p>Method under test: {@link BasicMethodInfo#BasicMethodInfo(MethodInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicMethodInfo.<init>(MethodInfo)"})
  public void testNewBasicMethodInfo() {
    // Arrange
    BasicMethodInfo method =
        new BasicMethodInfo(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(method, new BasicMethodInfo(method));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicMethodInfo.<init>(MethodInfo)"})
  public void testNewBasicMethodInfo_thenReturnDescriptorPrettyReturnTypeIsClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicMethodInfo.<init>(String, MethodDescriptor)"})
  public void testNewBasicMethodInfo_thenReturnMethodName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicMethodInfo basicMethodInfo =
        new BasicMethodInfo("Method Name", new MethodDescriptor("Return Type", new ArrayList<>()));
    BasicMethodInfo basicMethodInfo2 =
        new BasicMethodInfo("Method Name", new MethodDescriptor("Return Type", new ArrayList<>()));

    // Act and Assert
    assertEquals(basicMethodInfo, basicMethodInfo2);
    int expectedHashCodeResult = basicMethodInfo.hashCode();
    assertEquals(expectedHashCodeResult, basicMethodInfo2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicMethodInfo basicMethodInfo =
        new BasicMethodInfo(
            "proguard.classfile.BasicMethodInfo",
            new MethodDescriptor("Return Type", new ArrayList<>()));

    // Act and Assert
    assertNotEquals(
        basicMethodInfo,
        new BasicMethodInfo("Method Name", new MethodDescriptor("Return Type", new ArrayList<>())));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicMethodInfo basicMethodInfo =
        new BasicMethodInfo(
            "Method Name",
            new MethodDescriptor("proguard.classfile.MethodDescriptor", new ArrayList<>()));

    // Act and Assert
    assertNotEquals(
        basicMethodInfo,
        new BasicMethodInfo("Method Name", new MethodDescriptor("Return Type", new ArrayList<>())));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BasicMethodInfo.equals(Object)", "int BasicMethodInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(
        new BasicMethodInfo("Method Name", new MethodDescriptor("Return Type", new ArrayList<>())),
        1);
  }
}
