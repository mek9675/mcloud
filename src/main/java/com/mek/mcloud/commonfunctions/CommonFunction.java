/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.commonfunctions;

/**
 *
 * @author root
 */
public class CommonFunction {

    public static int nthOccurrence(String str, char c, int n) {
        int pos = str.indexOf(c, 0);
        while (n-- > 0 && pos != -1) {
            pos = str.indexOf(c, pos + 1);
        }
        return pos;
    }
    
}
