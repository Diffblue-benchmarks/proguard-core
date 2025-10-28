package proguard.io;

import static org.junit.Assert.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.junit.Test;

public class PKCS7OutputStreamDiffblueTest {
  /**
   * Method under test:
   * {@link PKCS7OutputStream#writeSignature(X509Certificate, String, String, byte[])}
   */
  @Test
  public void testWriteSignature() throws IOException, CertificateEncodingException {
    // Arrange
    PKCS7OutputStream pkcs7OutputStream = new PKCS7OutputStream(new DEROutputStream(new ByteArrayOutputStream(1)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pkcs7OutputStream.writeSignature(null, "Digest Algorithm",
        "Encryption Algorithm", "AXAXAXAX".getBytes("UTF-8")));
  }
}
