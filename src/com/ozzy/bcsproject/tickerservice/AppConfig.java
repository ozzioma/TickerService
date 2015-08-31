//package com.ozzy.tickerservice;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.oxm.Marshaller;
////import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.BeanNameViewResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//import org.springframework.web.servlet.view.xml.MarshallingView;
//
////import javax.xml.bind.Marshaller;
//import java.lang.reflect.Member;
//
///**
// * Created by Ozzy on 007, Jul 07, 2015.
// */
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.ozzy.hadoopdemos")
//public class AppConfig
//{
//
//
//    /*
//    @Bean
//    public View xmltemplate() {
//        return new MarshallingView(jaxb2Marshaller());
//    }
//
//    @Bean
//    public View jsontemplate() {
//        MappingJackson2JsonView view = new MappingJackson2JsonView();
//        view.setPrettyPrint(true);
//        return view;
//    }
//
//    @Bean
//    public Marshaller jaxb2Marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        //marshaller.setClassesToBeBound(Members.class, Member.class);
//        return marshaller;
//    }
//
//
//    @Bean
//    public ViewResolver viewResolver() {
//        return new BeanNameViewResolver();
//    }
//*/
//
//    @Bean
//    public ViewResolver viewResolver()
//    {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
//    @Bean
//    public TickerRepository tickerRepository()
//    {
//        return new TickerRepository();
//    }
//
//}
