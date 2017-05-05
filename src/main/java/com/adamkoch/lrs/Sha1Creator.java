package com.adamkoch.lrs;

import com.adamkoch.lrs.api.Sha1Sum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Created by aakoch on 2017-04-17.</p>
 *
 * @author aakoch
 * @since 1.0.0
 */
public class Sha1Creator {

    private MessageDigest md;

    public Sha1Creator() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("SHA");
    }

    public Sha1Sum getSha1(String data) {
        StringBuilder sb = new StringBuilder(40);
        md.update(data.getBytes());
        byte[] digest = md.digest();
        for (byte aDigest : digest) {
            String hex = Integer.toHexString(aDigest);
            if (hex.length() == 1) hex = "0" + hex;
            hex = hex.substring(hex.length() - 2);
            sb.append(hex);
        }
        return StringSha1Sum.of(sb.toString());
    }


}
