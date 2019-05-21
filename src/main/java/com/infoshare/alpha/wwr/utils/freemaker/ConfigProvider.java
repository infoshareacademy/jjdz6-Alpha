package com.infoshare.alpha.wwr.utils.freemaker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigProvider {
    private Configuration configuration;

    public Configuration getConfiguration() {

        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
        }
        return configuration;
    }
}
