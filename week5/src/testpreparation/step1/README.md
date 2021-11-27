# 마스터즈코스 테스트 준비
> 작년 마스터즈코스 테스트 문제를 풀어보자.

## 단어 밀어내기 구현
<details>
<summary>문제</summary>
<div markdown="1">
  
## 문제 설명
- 입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100) , L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.
- 주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.
- 밀려나간 단어는 반대쪽으로 채워진다.
  
## 입력 및 출력 예시
- 홀수 줄은 입력, 짝수 줄은 출력이다.
  
```
> apple 3 L
leapp

> banana 6 R
banana

> carrot -1 r
arrotc

> cat -4 R
atc
```
## 1단계 코딩 요구사항
- 컴파일 및 실행되지 않을 경우 불합격
- 자기만의 기준으로 최대한 간결하게 코드를 작성한다.
</div>
</details>

## 목차
1. [Main클래스](#MovieLettersMain클래스)
2. [Input클래스](#Input클래스)
3. [MovieLetter클래스](#MovieLetter클래스)

## MovieLettersMain클래스
|메소드명|기능|
|------|----|
|[main](#main메소드)|프로그램의 실행|

### main메소드
  ```java
  public static void main(String[] args) throws IOException {
      MovieLetter movieLetter = new MovieLetter();
      movieLetter.start();
  }
  ```
  - 프로그램의 실행과 구현을 나누기 위해 클래스를 분리하고, main메소드만 남겨 실행 기능만 담당

## Input클래스
|메소드명|기능|
|------|----|
|[inputString](#inputString메소드)|consol창으로 사용자의 입력을 받는다.|

### inputString메소드
  ```java
  public String inputString() throws IOException {
      BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
      return buf.readLine().toLowerCase();
  }
  ```
  - BufferedReader를 사용해서 사용자로 부터 입력을 받고, 입력값을 toLowerCase()로 소문자로 변경해준 뒤 값을 리턴해준다.

## MovieLetter클래스
|메소드명|기능|
|------|----|
|[start](#start메소드)||
|[splitLetter](#splitLetter메소드)||
|[movingToLetter](#movingToLetter메소드)||
|[movingToLeft](#movingToLeft메소드)||
|[movingToRight](#movingToRight메소드)||
|[printLetter](#printLetter메소드)||

### start메소드

### splitLetter메소드

### movingToLetter메소드

### movingToLeft메소드

### movingToRight메소드

### printLetter메소드
