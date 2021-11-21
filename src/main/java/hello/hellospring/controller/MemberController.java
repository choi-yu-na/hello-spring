package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //스프링 컨테이너가 스프링 창에 틀때.. 통이 생기거든요...
    //@ 어노테이션을 하면...MemberController 객체를 생성해서 스프링에 등록해놉니다.
    // -> 스프링 컨테이너에서.. 스프링 빈이 관리된다고 표현을 하고요..

    //private final MemberService memberService = new MemberService();
        // 이 방식으로 쓸수도 있지만.. 그런데 스프링이 관리를 하게 되면..
        // 스프링 컨테이너에 등록을 하고.. 거기서 받아쓰도록 바꿔야돼요..
        //왜냐하면.. new로 하게되면 무슨 문제가 있습니까
        //다른 컨트롤러들이 MemberService를 가져다 쓸수있겟죠..
        //그러면 이 객체를 new 했어요.. 들어가보면.. 별 기능이 없어서..
        // 여러개를 생성할 필요없고 하나만 생성해서 공용ㅇ로 쓰면 되거든요
        //이제부터는 Spring Container에 딱 하나만 등록해서 쓰면 되는거에요

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
