package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.taglibs.standard.lang.jstl.ImplicitObjects.createParamMap;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter { // ControllerV3를 지원하는 어댑터를 구현
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    } // `ControllerV3` 을 처리할 수 있는 어댑터

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        return mv;
    }
    // handler를 컨트롤러 V3로 변환한 다음에 V3 형식에 맞도록 호출
    // supports() 를 통해 ControllerV3만 지원하기 때문에 타입 변환은 걱정없이 실행
    // -> ControllerV3는 ModelView를 반환하므로 그대로 ModelView를 반환

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}
