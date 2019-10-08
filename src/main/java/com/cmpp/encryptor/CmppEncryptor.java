package com.cmpp.encryptor;

import io.xjar.XKit;
import io.xjar.boot.XBoot;
import io.xjar.key.XKey;

/**
 * @author licheng2, 2019/10/8 10:34
 */
public class CmppEncryptor {

    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("please make sure type in password and source jar file at least");
            }
            String pwd = args[0];
            if (pwd == null || pwd.length() == 0) {
                System.out.println("password can not be null");
                return;
            }
            XKey xKey = XKit.key(pwd);
            String sourceJar = args[1];
            if (sourceJar == null || sourceJar.length() == 0) {
                System.out.println("sourceJar can not be null");
                return;
            }
            String destJar = null;
            if (args.length > 2) {
                destJar = args[2];
            }
            if (destJar == null || destJar.length() == 0) {
                destJar = sourceJar.substring(0, sourceJar.lastIndexOf('.')) + "-encrypted.jar";
            }
            XBoot.encrypt(sourceJar, destJar, xKey);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
