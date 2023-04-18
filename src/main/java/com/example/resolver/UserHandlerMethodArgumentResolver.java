package com.example.resolver;

import com.example.model.User;
import jakarta.validation.Valid;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;



public class UserHandlerMethodArgumentResolver  implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String name = webRequest.getParameter("name");
        String password = webRequest.getParameter("password");
        var u = new User(name, password);
//        if(parameter.hasParameterAnnotation(Valid.class)){
//            binderFactory.createBinder(webRequest,u,"resolvedObjectLogicalName").validate();
//        }

        return u;
    }
}
