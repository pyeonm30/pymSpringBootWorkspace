package kr.ex.querydsl.domain;

public class MemberSearchCond {
    // 회원명, 팀명, 나이(크거나, 작거나 )
    private String username;
    private String teamName;
    private Integer ageGoe; // getter or equal
    private Integer ageLoe; // less or equal
}
