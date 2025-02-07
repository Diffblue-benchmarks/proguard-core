package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Signature;

class SignatureAdapterDiffblueTest {
  /**
   * Test {@link SignatureAdapter#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAdapter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member); then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SignatureAdapter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_thenCallsAccept() {
    // Arrange
    Consumer<Signature> consumer = mock(Consumer.class);
    doNothing().when(consumer).accept(Mockito.<Signature>any());
    SignatureAdapter<Signature> signatureAdapter = new SignatureAdapter<>(consumer);
    LibraryClass clazz = new LibraryClass();

    // Act
    signatureAdapter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(consumer).accept(isA(Signature.class));
  }

  /**
   * Test {@link SignatureAdapter#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod#LibraryMethod()}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SignatureAdapter#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMember(Clazz, Member); when LibraryMethod(); then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SignatureAdapter.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_whenLibraryMethod_thenCallsAccept() {
    // Arrange
    Consumer<Signature> consumer = mock(Consumer.class);
    doNothing().when(consumer).accept(Mockito.<Signature>any());
    SignatureAdapter<Signature> signatureAdapter = new SignatureAdapter<>(consumer);
    LibraryClass clazz = new LibraryClass();

    // Act
    signatureAdapter.visitAnyMember(clazz, new LibraryMethod());

    // Assert
    verify(consumer).accept(isA(Signature.class));
  }
}
