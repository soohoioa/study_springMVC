package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 스프링이 자동으로 스프링 빈으로 등록
public class SpringMemberFormControllerV1 {

    /**
     * @RequestMapping :
     * 요철 정보를 매핑.
     * 해당 URL이 호출되면 이 메서드가 호출.
     * 애노테이션을 기반으로 동작하기 때문에, 메서드의 이름은 임의로 지으면 된다.
     */
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
    /**
     * ModelAndView :
     * 모델과 뷰 정보를 담아서 반환하면 됨
     */
}
