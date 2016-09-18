package pl.dawydiuk.enums;

/**
 * Created by Konrad on 13.09.2016.
 */
public enum EPlec {

    KOBIETA("Kobieta",Byte.valueOf("2")),
    MEZCZYZNA("Mężczyzna",Byte.valueOf("3"));

    private String nazwa;
    private Byte byteId;

    public Byte getValue(){
        return this.byteId;
    }

    public static EPlec getByByteId(Byte id){
        if(id.equals(KOBIETA.getValue()))
            return KOBIETA;
        if(id.equals(MEZCZYZNA.getValue()))
            return MEZCZYZNA;
        return null;
    }
    EPlec(String nazwa,Byte id) {
        this.byteId = id;
        this.nazwa = nazwa;
    }

}
