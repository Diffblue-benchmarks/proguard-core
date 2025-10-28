package proguard.evaluation.value.object.model.reflective;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import proguard.classfile.BasicMethodInfo;
import proguard.classfile.MethodDescriptor;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ClassLoaderModel;

public class ModelHelperDiffblueTest {
  /**
   * Method under test: {@link ModelHelper#getConstructorHandlers(Class)}
   */
  @Test
  public void testGetConstructorHandlers() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Map<BasicMethodInfo, Method> actualConstructorHandlers = ModelHelper.getConstructorHandlers(modelClass);

    // Assert
    assertTrue(actualConstructorHandlers.isEmpty());
  }

  /**
   * Method under test: {@link ModelHelper#getStaticMethodHandlers(Class)}
   */
  @Test
  public void testGetStaticMethodHandlers() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Map<BasicMethodInfo, Method> actualStaticMethodHandlers = ModelHelper.getStaticMethodHandlers(modelClass);

    // Assert
    assertTrue(actualStaticMethodHandlers.isEmpty());
  }

  /**
   * Method under test: {@link ModelHelper#getDummyObject(Class)}
   */
  @Test
  public void testGetDummyObject() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", ModelHelper.getDummyObject(modelClass).getType());
  }

  /**
   * Method under test: {@link ModelHelper#getSupportedMethods(Class)}
   */
  @Test
  public void testGetSupportedMethods() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Collection<BasicMethodInfo> actualSupportedMethods = ModelHelper.getSupportedMethods(modelClass);

    // Assert
    assertTrue(actualSupportedMethods instanceof List);
    assertEquals(3, actualSupportedMethods.size());
    BasicMethodInfo getResult = ((List<BasicMethodInfo>) actualSupportedMethods).get(0);
    MethodDescriptor descriptor = getResult.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    BasicMethodInfo getResult2 = ((List<BasicMethodInfo>) actualSupportedMethods).get(2);
    MethodDescriptor descriptor2 = getResult2.getDescriptor();
    assertEquals("Class", descriptor2.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/Class;", descriptor2.getReturnType());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    List<String> argumentTypes2 = descriptor2.getArgumentTypes();
    assertEquals(2, argumentTypes2.size());
    assertEquals("Ljava/lang/String;", argumentTypes2.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("String,boolean", descriptor2.getPrettyArgumentTypes());
    assertEquals("Z", argumentTypes2.get(1));
    assertEquals("findLoadedClass", getResult.getMethodName());
    BasicMethodInfo getResult3 = ((List<BasicMethodInfo>) actualSupportedMethods).get(1);
    assertEquals("loadClass", getResult3.getMethodName());
    assertEquals("loadClass", getResult2.getMethodName());
    assertFalse(descriptor.isIncomplete());
    assertFalse(descriptor2.isIncomplete());
    assertEquals(descriptor, getResult3.getDescriptor());
  }

  /**
   * Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  public void testAllParticular() {
    // Arrange, Act and Assert
    assertTrue(ModelHelper.allParticular(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  public void testAllParticular2() {
    // Arrange
    ArrayList<Value> values = new ArrayList<>();
    values.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertFalse(ModelHelper.allParticular(values));
  }

  /**
   * Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  public void testAllParticular3() {
    // Arrange
    ArrayList<Value> values = new ArrayList<>();
    values.add(BasicValueFactory.DOUBLE_VALUE);
    values.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertFalse(ModelHelper.allParticular(values));
  }
}
