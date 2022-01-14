/*
 * Copyright 2016 xtecuan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sv.gob.mined.projects.sgipd.beans;

import java.io.*;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.Logger;

/**
 *
 * @author xtecuan
 */
public abstract class XBaseBean implements Serializable {

    public static final Integer ENG = 1;
    public static final Integer SPA = 2;
    public static final String JSF = ".mined";
    public static final String FACES_REDIRECT = "?faces-redirect=true&params=true";
    private static Logger LOGGER = Logger.getLogger(XBaseBean.class);

    public void addMessage(String summary, String detail) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                summary, detail));
    }

    public void addError(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                summary, detail));
    }

    public void setParam(String name, String value) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().put(name, value);
    }

    public String getParam(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    public Integer getIntegerParam(String name) {
        return Integer.valueOf(getParam(name));
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public void setSessionAttribute(String name, Object value) {
        getSession().put(name, value);
    }

    public Object getSessionAttribute(String name) {
        return getSession().get(name);
    }

    public Map<String, Object> getSession() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    }

    public void removeSessionAttribute(String name) {
        getSession().remove(name);
    }

    /**
     * Postconstruct init method
     */
    public abstract void init();

    public void invalidateSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public void setFlashParam(String name, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name, value);
    }

    public Object getFlashParam(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getFlash().get(name);
    }

    public Integer getFlashIntegerParam(String name) {
        return (Integer) getFlashParam(name);
    }

    public String getFlashStringParam(String name) {
        return (String) getFlashParam(name);
    }

    public void downloadFile(byte[] file, String fileName) {
        try {

            ByteArrayInputStream istr = new ByteArrayInputStream(file);
            int contentLength = istr.available();

            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response
                    = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setContentType("application/x-download");
            response.setContentLength(contentLength);
            response.setHeader("Content-disposition",
                    "attachment; filename=\"" + fileName + "\"");

            while (contentLength-- > 0) {
                response.getOutputStream().write(istr.read());
            }

            istr.close();
            context.responseComplete();
        } catch (Exception e) {
            this.getLogger().error("Error en descarga de archivo: ", e);
        }
    }

    public void copyFile(File file, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            getLogger().info("New file uploaded: " + file.getName());
        } catch (IOException e) {
            getLogger().error("Error writing grade file: " + file.getName(), e);
        }
    }
}
