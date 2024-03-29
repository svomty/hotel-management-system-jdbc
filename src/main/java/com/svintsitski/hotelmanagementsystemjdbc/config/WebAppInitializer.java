package com.svintsitski.hotelmanagementsystemjdbc.config;

import com.svintsitski.hotelmanagementsystemjdbc.config.application.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    /**
     * мэпинг сервлета настроен на “/” и поэтому все запросы будут перехвачены Диспетчером Сервлета Spring.
     */
}
