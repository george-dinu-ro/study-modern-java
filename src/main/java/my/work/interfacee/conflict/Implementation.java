package my.work.interfacee.conflict;

public class Implementation implements InterfaceA, InterfaceB {

    @Override
    public String defaultConcatenate(String s1, String s2) {
        return InterfaceA.super.defaultConcatenate(s1, s2);
    }

    @Override
    public String abstractConcatenate(String s1, String s2) {
        return s1 + s2;
    }

}
