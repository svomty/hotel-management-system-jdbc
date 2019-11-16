package com.svintsitski.hotelmanagementsystemjdbc.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
    /**
     * в AppSecurityConfig.java у нас находятся настройки Безопасности а в WebConfig.java настройки MVC. Необходимо
     * удостовериться, что настройки безопасности включены в основной контекст приложения (Иными словами их увидел и
     * втянул в себя Root Application Context). Для этого можно создать класс расширяющий(наследующий)
     * AbstractAnnotationConfigDispatcherServletInitializer. Нам нужно настроить все так чтобы определенный URL паттерн
     * (путь к определенному ресурсу) проходил через уровень безопасности (проходил бы проверку фильтрами Spring
     * Security)
     */
}
