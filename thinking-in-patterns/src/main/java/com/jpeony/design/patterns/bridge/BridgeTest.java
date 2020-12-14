package com.jpeony.design.patterns.bridge;

/**
 * @author yihonglei
 */
public class BridgeTest {
    public static void main(String[] args) {
        Person man = new Man();

        Person lady = new Lady();

        Clothing jacket = new Jacket();

        Clothing trouser = new Trouser();

        jacket.personDressCloth(man);
        trouser.personDressCloth(lady);

        jacket.personDressCloth(lady);
        trouser.personDressCloth(man);
    }
}
