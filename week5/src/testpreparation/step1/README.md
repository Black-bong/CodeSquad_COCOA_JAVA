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
|[start](#start메소드)|Input클래스를 생성하고, 입력받은 값 메소드로 넘겨주는 역할|
|[splitLetter](#splitLetter메소드)|사용자로부터 입력받은 문자 조건에 맞게 나눠주는 기능|
|[movingToLetter](#movingToLetter메소드)|이동방향과 이동값을 구분하여 메소드를 |
|[movingToLeft](#movingToLeft메소드)||
|[movingToRight](#movingToRight메소드)||
|[printLetter](#printLetter메소드)||

### start메소드
  ```java
  public void start() throws IOException {
      Input input = new Input();
      System.out.print("> ");
      String inputLetter = input.inputString();
      splitLetter(inputLetter);
  }
  ```
  - Input클래스를 생성자를 통해 생성하고, 값을 반환받아 splitLetter메소드로 값을 넘겨준다.
### splitLetter메소드
  ```java
  private void splitLetter(String inputText) {
      String[] letters = inputText.split(" +");
      String letter = letters[0];
      int moveCount = Integer.parseInt(letters[1]);
      String moveDirection = letters[2];
      movingToLetter(letter, moveCount, moveDirection);
  }
  ```
  - 사용자로부터 입력받은 값을 파라미터로 받아서 문자, 이동거리, 이동방향으로 나눠서 movingToLetter메소드로 넘겨준다.
### movingToLetter메소드
  ```java
  private void movingToLetter(String letter, int moveCount, String moveDirection) {
      char[] queue = new char[letter.length()];
      if (moveDirection.equals("r") && moveCount > 0) {
          movingToRight(letter, moveCount, queue);
      }
      if (moveDirection.equals("r") && moveCount < 0) {
          movingToLeft(letter, moveCount * - 1, queue);
      }

      if (moveDirection.equals("l") && moveCount > 0) {
          movingToLeft(letter, moveCount, queue);
      }
      if (moveDirection.equals("l") && moveCount < 0) {
          movingToRight(letter, moveCount * - 1, queue);
      }
  }
  ```
  - if문의 활용하여 이동방향과 이동값을 구분하여, 메소드를 호출해준다.
### movingToLeft메소드
  ```java
  private void movingToLeft(String letter, int moveCount, char[] queue) {
      for (int i = 0; i < letter.length(); i++) {
          queue[i] = letter.charAt(moveCount++ % queue.length);
      }
      printLetter(queue);
  }
  ```
  - 입력받은 문자를 0번째 index부터 기존 자리에 있는 문자의 index를 계산해서 저장
  - 나머지 연산자를 사용해서 입력받은 문자의 길이 범위 안에서 배열에 저장되도록 로직을 작성
### movingToRight메소드
  ```java
  private void movingToRight(String letter, int moveCount, char[] queue) {
      for (int i = 0; i < letter.length(); i++) {
          queue[i] = letter.charAt((moveCount * 4 + i) % queue.length);
      }
      printLetter(queue);
  }
  ```
### printLetter메소드
  ```java
  private void printLetter(char[] queue) {
      for (var c : queue) {
          System.out.print(c);
      }
  }
  ```
