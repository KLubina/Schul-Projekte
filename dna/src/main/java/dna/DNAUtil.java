package dna;

public class DNAUtil {

    public static boolean validate(String seq) {
        // Punkt 1: Sequenz darf nur aus A, T, G, C bestehen, überprüft durch regulären Ausdruck
        if (!seq.matches("[ATGC]+")) {
            return false;
        }
        
        // Punkt 2: Die Länge der Sequenz muss durch drei teilbar sein
        if (seq.length() % 3 != 0) {
            return false;
        }

        // Punkt 3: Die DNA-Sequenz muss mit "ATG" beginnen
        if (!seq.startsWith("ATG")) {
            return false;
        }

        // Punkt 4: Die DNA-Sequenz muss mit "TAA", "TAG" oder "TGA" enden
        if (!(seq.endsWith("TAA") || seq.endsWith("TAG") || seq.endsWith("TGA"))) {
            return false;
        }

        // Punkt 5: Die Stop-Codons dürfen sonst nirgends in der Sequenz vorkommen
        // Entferne das erste und letzte Codon für diesen Check
        String middleSequence = seq.substring(3, seq.length() - 3);
        if (middleSequence.contains("TAA") || middleSequence.contains("TAG") || middleSequence.contains("TGA")) {
            return false;
        }

        // Wenn alle Checks bestanden sind, ist die Sequenz gültig
        return true;
    }
}