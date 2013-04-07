/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.setup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author root
 */
@WebListener()
public class MCloudContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("*************************************");
        System.out.println("***********     mCloud     *********");
        System.out.println("*************************************");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("java.class.path"));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         
    }
}
