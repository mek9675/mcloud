/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.filter;

import java.io.IOException;
import javax.servlet.*;

/**
 *
 * @author root
 */
public class MainFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
        fc.doFilter(req, res);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
