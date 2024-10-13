package dna;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DNAProbeTest {
	
	@ParameterizedTest
    @CsvSource({
    	"ATGCGTTAA, true",
    	"ATGCGTTA, false",
        "ATGCGTT, false",
        "ATGCGT, false",
        "ATGCGTAAGTAGTAA, true",
        "ATGTAG, false",
    })
	void test(String sequence, boolean expected) {
		DNA_Probe probe = new DNA_Probe(1, sequence, "Fundort", LocalDate.now(), 1, sequence, "Fundort", LocalDate.now());
        assertEquals(expected, probe.isValidSequence(sequence));
    }

	@Test
	void tesInvalidSequenceExeption() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new DNA_Probe(1, "ATGCGTTAA", "Fundort", LocalDate.now(), 1, "ATGCGTTAA", "Fundort", LocalDate.now());
		});
		
		String expectedMessage = "Ungültige DNA-Sequenz";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
