package ru.kpfu.itis.gitschool.config;

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
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
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
    @Qualifier("homeTaskConverter")
    private GenericConverter homeTaskConverter;


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setRedirectContextRelative(false);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/assets/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/assets/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/assets/img/");
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(studentGenericConverter);
        formatterRegistry.addConverter(homeTaskConverter);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("static/about");
    }

    @Bean
    public StringToEntityConverter studentGenericConverter() {
        return new StringToEntityConverter(Student.class);
    }

    @Bean
    public StringToEntityConverter homeTaskConverter() {
        return new StringToEntityConverter(HomeTask.class);
    }
}
