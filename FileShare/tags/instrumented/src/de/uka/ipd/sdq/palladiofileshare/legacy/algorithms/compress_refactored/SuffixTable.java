package de.uka.ipd.sdq.palladiofileshare.legacy.algorithms.compress_refactored;

public final class SuffixTable {
    protected byte tab[];
    public SuffixTable() {
        tab = new byte[Compress.SUFFIX_TAB_SZ];
    }
    
    public void init(int size) {
        for (int code = 0; code < size; code++) {
            tab[code] = (byte) code;
        }
    }
    
    public byte of(int i) {
        return tab[i];
    }
    
    public void set(int i, byte v) {
        tab[i] = v;
    }
}
