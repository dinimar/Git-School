package ru.kpfu.itis.gitschool.config;

import org.jtwig.spring.JtwigViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kpfu.itis.gitschool.models.HomeTask;
import ru.kpfu.itis.gitschool.models.Student;
import ru.kpfu.itis.gitschool.utils.StringToEntityConverter;

@Configuration
@ComponentScan("ru.kpfu.itis.gitschool.controllers")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier("studentGenericConverter")
    private GenericConverter studentGenericConverter;
    @Autowired
    @Qualifier("homeTaskGenericConverter")
    private GenericConverter homeTaskGenericConverter;


    @Bean
    public ViewResolver viewResolver() {
        JtwigViewResolver resolver = new JtwigViewResolver();
        resolver.setPrefix("web:/WEB-INF/views/");
        resolver.setSuffix(".html.twig");
        resolver.setRedirectContextRelative(false);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/assets/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/assets/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/assets/fonts/");
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(studentGenericConverter);
        formatterRegistry.addConverter(homeTaskGenericConverter);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("static/base");
    }

    @Bean
    public StringToEntityConverter studentGenericConverter() {
        return new StringToEntityConverter(Student.class);
    }

    @Bean
    public StringToEntityConverter homeTaskGenericConverter() {
        return new StringToEntityConverter(HomeTask.class);
    }
}
