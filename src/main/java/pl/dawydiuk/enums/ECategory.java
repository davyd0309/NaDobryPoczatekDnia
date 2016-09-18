package pl.dawydiuk.enums;

/**
 * Created by Konrad on 13.09.2016.
 */
public enum ECategory {

    CATEGORY1("kategoria pierwsza", "opis kategorii 1", Byte.valueOf("1")),
    CATEGORY2("kategoria druga", "opis kategorii 2", Byte.valueOf("2")),
    CATEGORY3("kategoria trzecia", "opis kategorii 3", Byte.valueOf("3")),;

    private String title;
    private String description;
    private Byte byteId;


    public Byte getValue() {
        return this.byteId;
    }

    public static ECategory getByByteId(Byte id) {
        if (id.equals(CATEGORY1.getValue())) return CATEGORY1;
        if (id.equals(CATEGORY2.getValue())) return CATEGORY2;
        if (id.equals(CATEGORY3.getValue())) return CATEGORY3;
        return null;
    }


    ECategory(String title, String description, Byte byteId) {
        this.title = title;
        this.description = description;
        this.byteId = byteId;
    }
}
