/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.grizzly.servlet;

/**
 * Class that may be used to configure various properties of cookies 
 * used for session tracking purposes.
 */
public class SessionCookieConfig implements javax.servlet.SessionCookieConfig {

    private String name;
    private String domain;
    private String path;
    private String comment;
    private boolean httpOnly = true;
    private boolean secure;
    private final WebappContext ctx;
    private int maxAge = -1;


    /**
     * Constructor
     */
    public SessionCookieConfig(WebappContext ctx) {
        this.ctx = ctx;
    }


    /**
     * @param name the cookie name to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt>
     * from which this <tt>SessionCookieConfig</tt> was acquired has
     * already been initialized
     */
    @Override
    public void setName(String name) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }

        this.name = name;
    }


    /**
     * @return the cookie name set via {@link #setName}, or
     * <tt>JSESSIONID</tt> if {@link #setName} was never called
     */
    @Override
    public String getName() {
        return name;
    }


    /**
     * @param domain the cookie domain to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt>
     * from which this <tt>SessionCookieConfig</tt> was acquired has
     * already been initialized
     */
    @Override
    public void setDomain(String domain) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }

        this.domain = domain;
    }


    /**
     * @return the cookie domain set via {@link #setDomain}, or
     * <tt>null</tt> if {@link #setDomain} was never called
     */
    @Override
    public String getDomain() {
        return domain;
    }


    /**
     * @param path the cookie path to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt>
     * from which this <tt>SessionCookieConfig</tt> was acquired has
     * already been initialized
     */
    @Override
    public void setPath(String path) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }
        this.path = path;
    }


    /**
     * @return the cookie path set via {@link #setPath}, or the context
     * path of the <tt>ServletContext</tt> from which this 
     * <tt>SessionCookieConfig</tt> was acquired if {@link #setPath}
     * was never called
     */
    @Override
    public String getPath() {
        return path;
    }


    /**
     * @param comment the cookie comment to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt>
     * from which this <tt>SessionCookieConfig</tt> was acquired has
     * already been initialized
     */
    @Override
    public void setComment(String comment) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }

        this.comment = comment;
    }


    /**
     * @return the cookie comment set via {@link #setComment}, or
     * <tt>null</tt> if {@link #setComment} was never called
     */
    @Override
    public String getComment() {
        return comment;
    }


    /**
     * @param httpOnly true if the session tracking cookies created
     * on behalf of the <tt>ServletContext</tt> from which this
     * <tt>SessionCookieConfig</tt> was acquired shall be marked as
     * <i>HttpOnly</i>, false otherwise
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt>
     * from which this <tt>SessionCookieConfig</tt> was acquired has
     * already been initialized
     */
    @Override
    public void setHttpOnly(boolean httpOnly) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }

        this.httpOnly = httpOnly;
    }


    /**
     * @return true if the session tracking cookies created on behalf of the
     * <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt>
     * was acquired will be marked as <i>HttpOnly</i>, false otherwise
     */
    @Override
    public boolean isHttpOnly() {
        return httpOnly;
    }


    /**
     * @param secure true if the session tracking cookies created on
     * behalf of the <tt>ServletContext</tt> from which this
     * <tt>SessionCookieConfig</tt> was acquired shall be marked as
     * <i>secure</i> even if the request that initiated the corresponding
     * session is using plain HTTP instead of HTTPS, and false if they
     * shall be marked as <i>secure</i> only if the request that initiated
     * the corresponding session was also secure
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt>
     * from which this <tt>SessionCookieConfig</tt> was acquired has
     * already been initialized
     */
    @Override
    public void setSecure(boolean secure) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }

        this.secure = secure;
    }


    /**
     * @return true if the session tracking cookies created on behalf of the
     * <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt>
     * was acquired will be marked as <i>secure</i> even if the request
     * that initiated the corresponding session is using plain HTTP
     * instead of HTTPS, and false if they will be marked as <i>secure</i>
     * only if the request that initiated the corresponding session was
     * also secure
     */
    @Override
    public boolean isSecure() {
        return secure;
    }


    @Override
    public void setMaxAge(int maxAge) {
        if (ctx.deployed) {
            throw new IllegalArgumentException("WebappContext has already been deployed");
        }

        this.maxAge = maxAge;
    }


    @Override
    public int getMaxAge() {
        return maxAge;
    }

}
