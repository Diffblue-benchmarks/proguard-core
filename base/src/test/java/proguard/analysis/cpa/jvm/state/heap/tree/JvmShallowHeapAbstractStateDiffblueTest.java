package proguard.analysis.cpa.jvm.state.heap.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.MapAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmHeapAbstractState;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;

class JvmShallowHeapAbstractStateDiffblueTest {
  /**
   * Test {@link JvmShallowHeapAbstractState#JvmShallowHeapAbstractState(MapAbstractState, Class,
   * LatticeAbstractState)}.
   *
   * <p>Method under test: {@link
   * JvmShallowHeapAbstractState#JvmShallowHeapAbstractState(MapAbstractState, Class,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test new JvmShallowHeapAbstractState(MapAbstractState, Class, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmShallowHeapAbstractState.<init>(MapAbstractState, Class, LatticeAbstractState)"
  })
  void testNewJvmShallowHeapAbstractState() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Assert
    ValueAbstractState valueAbstractState = actualJvmShallowHeapAbstractState.defaultValue;
    assertTrue(valueAbstractState.getValue() instanceof TypedReferenceValue);
    assertNull(valueAbstractState.getPrecision());
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#getFieldOrDefault(Object, String,
   * LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When empty string.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#getFieldOrDefault(Object, String,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test getFieldOrDefault(Object, String, LatticeAbstractState); given 'java.lang.Object'; when empty string; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.getFieldOrDefault(Object, String, LatticeAbstractState)"
  })
  void testGetFieldOrDefault_givenJavaLangObject_whenEmptyString_thenReturnUnknown() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmShallowHeapAbstractState.getFieldOrDefault("Object", "", ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#getFieldOrDefault(Object, String,
   * LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Fqn}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#getFieldOrDefault(Object, String,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test getFieldOrDefault(Object, String, LatticeAbstractState); given 'java.lang.Object'; when 'Fqn'; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.getFieldOrDefault(Object, String, LatticeAbstractState)"
  })
  void testGetFieldOrDefault_givenJavaLangObject_whenFqn_thenReturnUnknown() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmShallowHeapAbstractState.getFieldOrDefault("Object", "Fqn", ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#setField(Object, String, LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#setField(Object, String,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test setField(Object, String, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmShallowHeapAbstractState.setField(Object, String, LatticeAbstractState)"
  })
  void testSetField() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act
    jvmShallowHeapAbstractState.setField("Object", "Fqn", ValueAbstractState.UNKNOWN);

    // Assert that nothing has changed
    assertTrue(jvmShallowHeapAbstractState.referenceToObject.isEmpty());
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#setField(Object, String, LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#setField(Object, String,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test setField(Object, String, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmShallowHeapAbstractState.setField(Object, String, LatticeAbstractState)"
  })
  void testSetField2() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act
    jvmShallowHeapAbstractState.setField("Object", "", ValueAbstractState.UNKNOWN);

    // Assert
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        jvmShallowHeapAbstractState.referenceToObject;
    assertEquals(1, objectValueAbstractStateMap.size());
    assertSame(ValueAbstractState.UNKNOWN, objectValueAbstractStateMap.get("Object"));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#getArrayElementOrDefault(Object, LatticeAbstractState,
   * LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Array}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#getArrayElementOrDefault(Object,
   * LatticeAbstractState, LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test getArrayElementOrDefault(Object, LatticeAbstractState, LatticeAbstractState); given 'java.lang.Object'; when 'Array'; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.getArrayElementOrDefault(Object, LatticeAbstractState, LatticeAbstractState)"
  })
  void testGetArrayElementOrDefault_givenJavaLangObject_whenArray_thenReturnUnknown() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmShallowHeapAbstractState.getArrayElementOrDefault(
            "Array", ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#setArrayElement(Object, LatticeAbstractState,
   * LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#setArrayElement(Object,
   * LatticeAbstractState, LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test setArrayElement(Object, LatticeAbstractState, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmShallowHeapAbstractState.setArrayElement(Object, LatticeAbstractState, LatticeAbstractState)"
  })
  void testSetArrayElement() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act
    jvmShallowHeapAbstractState.setArrayElement(
        "Array", ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Assert
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        jvmShallowHeapAbstractState.referenceToObject;
    assertEquals(1, objectValueAbstractStateMap.size());
    assertSame(ValueAbstractState.UNKNOWN, objectValueAbstractStateMap.get("Array"));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#newObject(String, JvmCfaNode)} with {@code className},
   * {@code creationCite}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#newObject(String, JvmCfaNode)}
   */
  @Test
  @DisplayName("Test newObject(String, JvmCfaNode) with 'className', 'creationCite'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.newObject(String, JvmCfaNode)"
  })
  void testNewObjectWithClassNameCreationCite() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmShallowHeapAbstractState.newObject("Class Name", JvmUnknownCfaNode.INSTANCE));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#newArray(String, List, JvmCfaNode)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#newArray(String, List, JvmCfaNode)}
   */
  @Test
  @DisplayName(
      "Test newArray(String, List, JvmCfaNode); given UNKNOWN; when ArrayList() add UNKNOWN; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.newArray(String, List, JvmCfaNode)"
  })
  void testNewArray_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsOne() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    ArrayList<ValueAbstractState> dimensions = new ArrayList<>();
    dimensions.add(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualNewArrayResult =
        jvmShallowHeapAbstractState.newArray("Type", dimensions, JvmUnknownCfaNode.INSTANCE);

    // Assert
    assertEquals(1, dimensions.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, dimensions.get(0));
    assertSame(valueAbstractState, actualNewArrayResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#newArray(String, List, JvmCfaNode)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#newArray(String, List, JvmCfaNode)}
   */
  @Test
  @DisplayName(
      "Test newArray(String, List, JvmCfaNode); given UNKNOWN; when ArrayList() add UNKNOWN; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.newArray(String, List, JvmCfaNode)"
  })
  void testNewArray_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsTwo() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    ArrayList<ValueAbstractState> dimensions = new ArrayList<>();
    dimensions.add(ValueAbstractState.UNKNOWN);
    dimensions.add(ValueAbstractState.UNKNOWN);

    // Act
    jvmShallowHeapAbstractState.newArray("Type", dimensions, JvmUnknownCfaNode.INSTANCE);

    // Assert
    assertEquals(2, dimensions.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, dimensions.get(0));
    assertSame(valueAbstractState, dimensions.get(1));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#newArray(String, List, JvmCfaNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#newArray(String, List, JvmCfaNode)}
   */
  @Test
  @DisplayName("Test newArray(String, List, JvmCfaNode); when ArrayList(); then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmShallowHeapAbstractState.newArray(String, List, JvmCfaNode)"
  })
  void testNewArray_whenArrayList_thenReturnUnknown() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmShallowHeapAbstractState.newArray(
            "Type", new ArrayList<>(), JvmUnknownCfaNode.INSTANCE));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState.join(abstractState);

    // Assert
    assertSame(jvmShallowHeapAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState2() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass, ValueAbstractState.UNKNOWN);
    referenceToObject.put(jvmShallowHeapAbstractState, ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState2 =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass2, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject3 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass3 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject3, referenceClass3, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState2.join(abstractState);

    // Assert
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    Value value = valueAbstractState.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertNull(((TypedReferenceValue) value).getType());
    assertNull(actualJoinResult.getPrecision());
    assertNull(valueAbstractState.getPrecision());
    assertEquals(-1, ((TypedReferenceValue) value).isNotNull());
    assertEquals(1, ((TypedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
    assertTrue(value.isParticular());
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualJoinResult.referenceClass);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState3() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    referenceToObject2.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState.join(abstractState);

    // Assert
    assertSame(jvmShallowHeapAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState4() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put(42, ValueAbstractState.UNKNOWN);
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState.join(abstractState);

    // Assert
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        actualJoinResult.referenceToObject;
    assertEquals(2, objectValueAbstractStateMap.size());
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    assertSame(valueAbstractState, objectValueAbstractStateMap.get("42"));
    assertSame(valueAbstractState, objectValueAbstractStateMap.get(42));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState5() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject3 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState2 =
        new JvmShallowHeapAbstractState<>(
            referenceToObject3, referenceClass2, ValueAbstractState.UNKNOWN);
    referenceToObject2.put(jvmShallowHeapAbstractState2, ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass3 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass3, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState.join(abstractState);

    // Assert
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    Value value = valueAbstractState.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertNull(((TypedReferenceValue) value).getType());
    assertNull(actualJoinResult.getPrecision());
    assertNull(valueAbstractState.getPrecision());
    assertEquals(-1, ((TypedReferenceValue) value).isNotNull());
    assertEquals(1, ((TypedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
    assertTrue(value.isParticular());
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualJoinResult.referenceClass);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState6() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass, ValueAbstractState.UNKNOWN);
    referenceToObject.put(jvmShallowHeapAbstractState, ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState2 =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass2, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject3 =
        new HashMapAbstractState<>();
    referenceToObject3.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass3 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject3, referenceClass3, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState2.join(abstractState);

    // Assert
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        abstractState.referenceToObject;
    assertEquals(1, objectValueAbstractStateMap.size());
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap2 =
        actualJoinResult.referenceToObject;
    assertEquals(2, objectValueAbstractStateMap2.size());
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    assertSame(valueAbstractState, objectValueAbstractStateMap.get("42"));
    assertSame(valueAbstractState, objectValueAbstractStateMap2.get("42"));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState7() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass, ValueAbstractState.UNKNOWN);
    referenceToObject.put(jvmShallowHeapAbstractState, ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState2 =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass2, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject3 =
        new HashMapAbstractState<>();
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject4 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass3 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState3 =
        new JvmShallowHeapAbstractState<>(
            referenceToObject4, referenceClass3, ValueAbstractState.UNKNOWN);
    referenceToObject3.put(jvmShallowHeapAbstractState3, ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass4 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject3, referenceClass4, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState2.join(abstractState);

    // Assert
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    Value value = valueAbstractState.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertNull(((TypedReferenceValue) value).getType());
    assertNull(actualJoinResult.getPrecision());
    assertNull(valueAbstractState.getPrecision());
    assertEquals(-1, ((TypedReferenceValue) value).isNotNull());
    assertEquals(1, ((TypedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
    assertTrue(value.isParticular());
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualJoinResult.referenceClass);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link JvmShallowHeapAbstractState#referenceToObject} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'; given '42'; then return referenceToObject size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState_given42_thenReturnReferenceToObjectSizeIsOne() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    referenceToObject2.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState.join(abstractState);

    // Assert
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap =
        abstractState.referenceToObject;
    assertEquals(1, objectValueAbstractStateMap.size());
    MapAbstractState<Object, ValueAbstractState> objectValueAbstractStateMap2 =
        actualJoinResult.referenceToObject;
    assertEquals(1, objectValueAbstractStateMap2.size());
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    assertSame(valueAbstractState, objectValueAbstractStateMap.get("42"));
    assertSame(valueAbstractState, objectValueAbstractStateMap2.get("42"));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>Then return {@link JvmShallowHeapAbstractState#referenceToObject} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'; then return referenceToObject Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmShallowHeapAbstractState JvmShallowHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState_thenReturnReferenceToObjectEmpty() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualJoinResult =
        jvmShallowHeapAbstractState.join(abstractState);

    // Assert
    ValueAbstractState valueAbstractState = actualJoinResult.defaultValue;
    Value value = valueAbstractState.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertNull(((TypedReferenceValue) value).getType());
    assertNull(actualJoinResult.getPrecision());
    assertNull(valueAbstractState.getPrecision());
    assertEquals(-1, ((TypedReferenceValue) value).isNotNull());
    assertEquals(1, ((TypedReferenceValue) value).isNull());
    assertFalse(value.isCategory2());
    assertFalse(value.isSpecific());
    assertTrue(actualJoinResult.referenceToObject.isEmpty());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
    assertTrue(value.isParticular());
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualJoinResult.referenceClass);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmShallowHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act
    boolean actualIsLessOrEqualResult =
        jvmShallowHeapAbstractState.isLessOrEqual(
            new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmShallowHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState2() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    referenceToObject2.put("42", new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    boolean actualIsLessOrEqualResult = jvmShallowHeapAbstractState.isLessOrEqual(abstractState);

    // Assert
    assertFalse(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'; given UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmShallowHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState_givenUnknown_thenReturnTrue() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    referenceToObject2.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    boolean actualIsLessOrEqualResult = jvmShallowHeapAbstractState.isLessOrEqual(abstractState);

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmShallowHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState_thenReturnFalse() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    boolean actualIsLessOrEqualResult = jvmShallowHeapAbstractState.isLessOrEqual(abstractState);

    // Assert
    assertFalse(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'; when 'java.lang.Object'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmShallowHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> abstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act
    boolean actualIsLessOrEqualResult = jvmShallowHeapAbstractState.isLessOrEqual(abstractState);

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#equals(Object)}, and {@link
   * JvmShallowHeapAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmShallowHeapAbstractState#equals(Object)}
   *   <li>{@link JvmShallowHeapAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmShallowHeapAbstractState.equals(Object)",
    "int JvmShallowHeapAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState2 =
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertEquals(jvmShallowHeapAbstractState, jvmShallowHeapAbstractState2);
    assertEquals(jvmShallowHeapAbstractState.hashCode(), jvmShallowHeapAbstractState2.hashCode());
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#equals(Object)}, and {@link
   * JvmShallowHeapAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmShallowHeapAbstractState#equals(Object)}
   *   <li>{@link JvmShallowHeapAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmShallowHeapAbstractState.equals(Object)",
    "int JvmShallowHeapAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertEquals(jvmShallowHeapAbstractState, jvmShallowHeapAbstractState);
    int expectedHashCodeResult = jvmShallowHeapAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmShallowHeapAbstractState.hashCode());
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmShallowHeapAbstractState.equals(Object)",
    "int JvmShallowHeapAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    referenceToObject.put("42", ValueAbstractState.UNKNOWN);
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    // Act and Assert
    assertNotEquals(
        jvmShallowHeapAbstractState,
        new JvmShallowHeapAbstractState<>(
            referenceToObject2, referenceClass2, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmShallowHeapAbstractState.equals(Object)",
    "int JvmShallowHeapAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(jvmShallowHeapAbstractState, null);
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmShallowHeapAbstractState.equals(Object)",
    "int JvmShallowHeapAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(jvmShallowHeapAbstractState, "Different type to JvmShallowHeapAbstractState");
  }

  /**
   * Test {@link JvmShallowHeapAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmShallowHeapAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmShallowHeapAbstractState JvmShallowHeapAbstractState.copy()"})
  void testCopy() {
    // Arrange
    HashMapAbstractState<Object, ValueAbstractState> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, ValueAbstractState> jvmShallowHeapAbstractState =
        new JvmShallowHeapAbstractState<>(
            referenceToObject, referenceClass, ValueAbstractState.UNKNOWN);

    // Act
    JvmShallowHeapAbstractState<Object, ValueAbstractState> actualCopyResult =
        jvmShallowHeapAbstractState.copy();

    // Assert
    assertEquals(jvmShallowHeapAbstractState, actualCopyResult);
  }
}
