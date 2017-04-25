package com.adamkoch.lrs;

import java.security.NoSuchAlgorithmException;

/**
 * <a href="http://intertwingly.net/stories/2003/08/05/sha1demo.java">Sam Ruby's example</a>
 */
public class Sha1Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String data = "It's just data";
        Sha1Creator creator = new Sha1Creator();
        System.out.println("\n" + creator.getSha1(data));
    }

}
