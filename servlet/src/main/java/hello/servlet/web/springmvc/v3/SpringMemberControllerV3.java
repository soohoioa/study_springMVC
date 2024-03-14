package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age, Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
/*
ViewName 직접 반환 : 뷰의 논리 이름을 반환할 수 있다.

@RequestParam 사용 :
스프링은 HTTP 요청 파라미터를 `@RequestParam` 으로 받을 수 있다.
`@RequestParam("username")` 은 `request.getParameter("username")` 와 거의 같은 코드라 생각하면 된다.
물론 GET 쿼리 파라미터, POST Form 방식을 모두 지원한다.

@RequestMapping -> @GetMapping, @PostMapping
@RequestMapping` 은 URL만 매칭하는 것이 아니라, HTTP Method도 함께 구분할 수 있다.
예를 들어서 URL이 `/new-form` 이고, HTTP Method가 GET인 경우를 모두 만족하는 매핑을 하려면 다음과 같이 처리하면 된다.
``
@RequestMapping(value = "/new-form", method = RequestMethod.GET)
``
이것을 `@GetMapping` , `@PostMapping` 으로 더 편리하게 사용할 수 있다.
참고로 Get, Post, Put, Delete, Patch 모두 애노테이션이 준비되어 있다.

`@GetMapping` 코드를 열어서 `@RequestMapping` 애노테이션을 내부에 가지고 있는 모습을 확인하자.
 */