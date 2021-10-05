# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 요구사항 정리

### 진행 방식
    - 구성
        - 기능요구사항 > 1
        - 프로그래밍 요구사항 > 3
        - 과제 진행 요구사항 > 1
    - 특징
        - 세 개의 요구사항을 만족하기 위해 노력할 것.
        - 기능 목록 만들기 > 기능 구현 > 기능 단위 commit하는 방식으로 진행할 것.

### 미션 제출 방법
    - 미션 구현 완료 > GitHub을 통해 제출
    - GitHub을 활용한 제출 방법 : [프리코스 과제 제출 문서](https://github.com/next-step/nextstep-docs/tree/master/precourse)를 참고해 제출한다.
    - GitHub 제출 > edu.nextstep@gmail.com 메일 발송.

### 기능 요구 사항
    - 제약 사항
        - 숫자의 범위 1-9
        - 서로 다른 수
        - 3자리의 수 
    - 조건
        - 같은 수 && 같은 자리 = 스트라이크
        - 같은 수 && 다른 자리 = 볼
        - 포볼 || 낫싱
    - 시나리오
        - C : 1-9까지 서로 다른 임의의 수 3개 선택
        - U : 3개의 숫자 입력
        - C : 결과 출력
        - U : 새로 시작할 것인지 선택
        - sudo
            start
            while != strike3():
                input3int()
                showResult()
            if repeat(): goto start
            end

### 프로그래밍 요구사항1 - 제약사항
    - 시작점을 baseball.Application의 main()으로 한다.
    - JDK 8 버전이어야 한다.
    - nextstep.utils 패키지의 Randoms, Console API를 활용해야한다.
        - 랜덤값 추출 : nextstep.utils.Randoms > pickNumberInRange()를 활용
        - 사용자 입력 값 : nextstep.utils.Console > readLine() 활용
    - test case
        - 최소한의 test case 2개는 통과하자.
        - (option) 할 수 있는 모든 테스트를 추가해보자.

### 프로그래밍 요구사항2 - 제약사항
    - 자바 코드 컨벤션을 지키자(https://naver.github.io/hackday-conventions-java/)
    - 인덴트는 1까지만 허용된다 > 함수(메소드)를 분리하자
        - for if 사용 금지
        - while if 사용 금지
    - stream api를 사용하지 않고 구현하자. but, 람다는 사용 가능
    - else 예약어를 쓰지 않는다
        - if에서 return 시켜버린다
        - switch/case 허용 안됨
    - 함수(메소드)의 row line은 10 line을 넘어가지 않도록 한다.
        - 함수(메소드)가 한 가지 일만 잘 하도록 구현

### 프로그래밍 요구사항3 - 단위 테스트
    - 도메인 로직에 단위 테스트를 구현하자.
        - 핵심 로직 구현 코드, UI 담당 로직을 분리해 구현하자.
        - MVC 패턴 기반으로 구현 > View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집중
    - pdf 문서를 참고해 사용법 학습 > JUnit5 기반 단위 테스트 구현

### 과제 진행 요구사항
    - README.md에 기능 목록 정리 추가 제일 먼저 해보자
    - commit 단위
        - README.md에 정리한 기능 목록 단위
        - 의미있는 단위
    - https://gist.github.com/stephenparish/9941e89d80e2bc58a153를 참고해 commit log를 남기려고 노력해 본다.

## 기능 목록
    - 학습 테스트 진행하기
        - [x] 힌트 관련 용어 학습
            - [x] Assertj 학습(https://assertj.github.io/doc/)
            - [x] [Junit5 학습](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)
        - [x] 테스트 패키지 생성 후 테스트 (StudyTest)
        - [x] 과제 제출을 위한 학습 테스트 (StringTest, SetTest)
    - 컴퓨터 기능 구현
        - [x] 랜덤 번호 생성 기능
            - [x] 1 ~ 9 사이의 숫자
            - [x] 정확히 3자리의 숫자
            - [x] 중복되지 않는 숫자
            - [x] 기능 테스트
    - 게이머 기능 구현
        - [x] 번호 입력 기능
            - [x] 1 ~ 9 사이의 숫자
            - [x] 정확히 3자리의 숫자
            - [x] 중복되지 않는 숫자
            - [x] 기능 테스트
        - [x] 검증 실패 시, 메세지 출력 후 게임 계속 진행
    - 매니저 기능 구현
        - [x] 판별 기능 - BaseballResult 객체에 삽입
            - [x] 같은 자리 && 같은 수 : 스트라이크
            - [x] 같은 수 : 볼
            - [x] 같은 수가 없으면 : 낫싱
    - [ ] 게임 시작 기능
    - [ ] 게임 종료 기능
    - [ ] 게임 재시작 기능