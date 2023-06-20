package org.example.ObjectTypes;

public enum CJKDescription {

    HORI2('⿰'),
    VERT2('⿱'),
    HORI3('⿲'),
    VERT3('⿳'),
    ENCIRALL('⿴'),
    ENCIRTOP('⿵'),
    ENCIRBUT('⿶'),
    ENCIRLEFT('⿷'),
    ENCTOPLEFT('⿸'),
    ENCTOPRIGHT('⿹'),
    ENCBUTLEFT('⿺'),
    OVERLAP('⿻');

    private final char unicodeCharacter;

    CJKDescription(char unicodeCharacter) {
        this.unicodeCharacter = unicodeCharacter;
    }

    public char getUnicodeCharacter() {
        return unicodeCharacter;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
