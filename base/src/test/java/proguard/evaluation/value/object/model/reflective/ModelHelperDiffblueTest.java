package proguard.evaluation.value.object.model.reflective;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.BasicMethodInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ClassLoaderModel;

public class ModelHelperDiffblueTest {
  /**
   * Test {@link ModelHelper#getConstructorHandlers(Class)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getConstructorHandlers(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ModelHelper.getConstructorHandlers(Class)"})
  public void testGetConstructorHandlers_thenReturnEmpty() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Map<BasicMethodInfo, Method> actualConstructorHandlers =
        ModelHelper.getConstructorHandlers(modelClass);

    // Assert
    assertTrue(actualConstructorHandlers.isEmpty());
  }

  /**
   * Test {@link ModelHelper#getStaticMethodHandlers(Class)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getStaticMethodHandlers(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ModelHelper.getStaticMethodHandlers(Class)"})
  public void testGetStaticMethodHandlers_thenReturnEmpty() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Map<BasicMethodInfo, Method> actualStaticMethodHandlers =
        ModelHelper.getStaticMethodHandlers(modelClass);

    // Assert
    assertTrue(actualStaticMethodHandlers.isEmpty());
  }

  /**
   * Test {@link ModelHelper#getDummyObject(Class)}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/ClassLoader;}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getDummyObject(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.object.model.reflective.ReflectiveModel ModelHelper.getDummyObject(Class)"
  })
  public void testGetDummyObject_thenReturnTypeIsLjavaLangClassLoader() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", ModelHelper.getDummyObject(modelClass).getType());
  }

  /**
   * Test {@link ModelHelper#getSupportedMethods(Class)}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#getSupportedMethods(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection ModelHelper.getSupportedMethods(Class)"})
  public void testGetSupportedMethods_thenReturnSizeIsThree() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    Collection<BasicMethodInfo> actualSupportedMethods =
        ModelHelper.getSupportedMethods(modelClass);

    // Assert
    assertTrue(actualSupportedMethods instanceof List);
    assertEquals(3, actualSupportedMethods.size());
    assertEquals(
        "findLoadedClass", ((List<BasicMethodInfo>) actualSupportedMethods).get(0).getMethodName());
    assertEquals(
        "loadClass", ((List<BasicMethodInfo>) actualSupportedMethods).get(1).getMethodName());
    assertEquals(
        "loadClass", ((List<BasicMethodInfo>) actualSupportedMethods).get(2).getMethodName());
  }

  /**
   * Test {@link ModelHelper#allParticular(List)}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModelHelper.allParticular(List)"})
  public void testAllParticular_givenDouble_value_whenArrayListAddDouble_value_thenReturnFalse() {
    // Arrange
    ArrayList<Value> values = new ArrayList<>();
    values.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertFalse(ModelHelper.allParticular(values));
  }

  /**
   * Test {@link ModelHelper#allParticular(List)}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModelHelper.allParticular(List)"})
  public void testAllParticular_givenDouble_value_whenArrayListAddDouble_value_thenReturnFalse2() {
    // Arrange
    ArrayList<Value> values = new ArrayList<>();
    values.add(BasicValueFactory.DOUBLE_VALUE);
    values.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertFalse(ModelHelper.allParticular(values));
  }

  /**
   * Test {@link ModelHelper#allParticular(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ModelHelper#allParticular(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModelHelper.allParticular(List)"})
  public void testAllParticular_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ModelHelper.allParticular(new ArrayList<>()));
  }
}
