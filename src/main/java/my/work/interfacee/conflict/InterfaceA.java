package my.work.interfacee.conflict;

public interface InterfaceA {

    static String staticConcatenate(String s1, String s2) {
        return s1 + s2;
    }

    default String defaultConcatenate(String s1, String s2) {
        return s1 + s2;
    }

    String abstractConcatenate(String s1, String s2);

}
