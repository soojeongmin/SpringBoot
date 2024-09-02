package com.bit.springboard.controller;

import com.bit.springboard.config.SecurityConfiguration;
import com.bit.springboard.entity.FreeBoard;
import com.bit.springboard.entity.Member;
import com.bit.springboard.handler.LoginFailureHandler;
import com.bit.springboard.oauth.OAuth2UserServiceImpl;
import com.bit.springboard.service.ApiService;
import com.bit.springboard.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @WebMvcTest(테스트컨트롤러클래스.class): 웹에서 사용하는 요청 url에 대한 테스트를 진행할 수 있다.
//                                     ()안에 지정된 클래스에 대해서만 테스트 진행
@WebMvcTest(ApiController.class)
@Import(SecurityConfiguration.class)
public class FreeBoardControllerTest {
    @Autowired
    // 컨트롤러의 API를 테스트하기 위한 클래스
    // 서블릿 컨테이너의 구동 없이도 가상의 MVC 환경에서 HTTP 서블릿을 요청하기 위한 객체
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @MockBean
    private MemberService memberService;

    @MockBean
    private LoginFailureHandler loginFailureHandler;

    @MockBean
    private OAuth2UserServiceImpl oAuth2UserService;

    @Test
    void findByIdTest() throws Exception {
        // 테스트 계획 수립
        given(apiService.findFreeBoardById(4L))
                .willReturn(
                        FreeBoard.builder()
                                .id(4L)
                                .title("제목4")
                                .content("내용4")
                                .regdate(LocalDateTime.parse("2024-08-26T15:40:19.825936"))
                                .moddate(LocalDateTime.parse("2024-08-26T15:40:19.825974"))
                                .cnt(2)
                                .member(Member.builder()
                                        .id(1L)
                                        .nickname("bitcamp1")
                                        .build())
                                .boardFileList(new ArrayList<>())
                                .build()
                );

        // perform(): 요청 url을 테스트할 수 있는 메소드
        mockMvc.perform(get("/apis/boards/" + 4))
                // andExpect(): 결과값을 검증
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(4L))
                .andExpect(jsonPath("$.data.title").value("제목4"))
                .andExpect(jsonPath("$.data.content").value("내용4"))
                // andDo(print()): 응답 내용 전체 출력
                .andDo(print());
    }

}
