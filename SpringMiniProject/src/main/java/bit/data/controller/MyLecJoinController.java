package bit.data.controller;

import bit.data.dto.MyLecJoinDto;
import bit.data.service.MyLecJoinServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyLecJoinController {

    @Autowired
    MyLecJoinServiceInter myLecJoinService;

    //수강목록 출력(payok=="ok")+강의 결제 내역(payok == "ok" or "cancel")
    @GetMapping("/student/stuLectureList")
    public String stuLectureList(Model model, HttpServletRequest request){

        HttpSession session =request.getSession();
        int usernum= Integer.parseInt(session.getAttribute("usernum").toString());
        //수강목록
        List<MyLecJoinDto> list=myLecJoinService.getMyLecListByNum(usernum,"ok");
        //강의 결제내역
        List<MyLecJoinDto> plist=myLecJoinService.getMyLecPayByNum(usernum);

        model.addAttribute("list",list);
        model.addAttribute("plist",plist);

        return "/mypage/student/stuLectureList";

    }
    
    //시간표 출력(payok=="ok")
    @GetMapping("/student/timeTable")
    public String stuTimeTable(Model model, HttpServletRequest request){

        HttpSession session =request.getSession();
        int usernum= Integer.parseInt(session.getAttribute("usernum").toString());
        List<MyLecJoinDto> list=myLecJoinService.getMyLecListByNum(usernum,"ok");

        model.addAttribute("list",list);

        return "/mypage/student/timeTable";

    }


    //장바구니 출력(payok=="no")
    @GetMapping("/student/myCart")
    public String Cart(Model model, HttpServletRequest request){

        HttpSession session =request.getSession();
        int usernum= Integer.parseInt(session.getAttribute("usernum").toString());
        List<MyLecJoinDto> list=myLecJoinService.getMyLecListByNum(usernum,"no");

        model.addAttribute("list",list);
        return "/mypage/student/myCart";
    }

  

}
