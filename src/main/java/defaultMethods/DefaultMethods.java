package defaultMethods;

interface A {
    default Number getNumber(){
        return 10;
    }
}
interface B {
    default Integer getNumber(){
        return 42;
    }
}

class C implements B, A {

    //If you remove this method the compilation will fail as it is ambiguous
    //which method is the most specific. Both getNumber are at the same level and are both the most specific
    //So we need to override it and reference the one to be called
    @Override
    public Integer getNumber() {
        return B.super.getNumber();
    }

    public static void main(String... args) {
        System.out.println(new C().getNumber());
    }
}

public class DefaultMethods {
}



