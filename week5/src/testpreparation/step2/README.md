# 마스터즈코스 테스트 준비
> 작년 마스터즈코스 테스트 문제를 풀어보자.

## 평면큐브 구현
<details>
<summary>문제</summary>
<div markdown="1">

## 문제 설명
초기화면
```
R R W
G C W
G B B
```
사용자 입력을 받아서 아래의 동작을 하는 프로그램을 구현하시오.
```
> U  가장 윗줄을 왼쪽으로 한 칸 밀기 RRW -> RWR
> U' 가장 윗줄을 오른쪽으로 한 칸 밀기 RRW -> WRR
> R  가장 오른쪽 줄을 위로 한 칸 밀기 WWB -> WBW
> R' 가장 오른쪽 줄을 아래로 한 칸 밀기 WWB -> BWW
> L  가장 왼쪽 줄을 아래로 한 칸 밀기 RGG -> GRG (L의 경우 R과 방향이 반대임을 주의한다.)
> L' 가장 왼쪽 줄을 위로 한 칸 밀기 RGG -> GGR
> B  가장 아랫줄을 오른쪽으로 한 칸 밀기 GBB -> BGB (B의 경우도 U와 방향이 반대임을 주의한다.)
> B' 가장 아랫줄을 왼쪽으로 한 칸 밀기 GBB -> BBG
> Q  Bye~를 출력하고 프로그램을 종료한다.
```
## 요구사항
- 처음 시작하면 초기 상태를 출력한다.
- 간단한 프롬프트 (CLI에서 키보드 입력받기 전에 표시해주는 간단한 글자들 - 예: CUBE> )를 표시해 준다.
- 한 번에 여러 문자를 입력받은 경우 순서대로 처리해서 매 과정을 화면에 출력한다.
## 동작예시
```
R R W
G C W
G B B

CUBE> UUR

U
R W R
G C W
G B B

U
W R R
G C W
G B B

R
W R W
G C B
G B R

CUBE> Q
Bye~
```
## 2단계 코딩 요구사항
- 너무 크지 않은 함수 단위로 구현하려고 노력할 것
- 전역변수의 사용을 자제할 것
- 객체와 배열을 적절히 활용할 것
</div>
</details>

## 목차
1. [Main클래스](#FlatCubeMain클래스)
2. [Input클래스](#Input클래스)
3. [FlatCube클래스](#FlatCube클래스)
4. [Cube클래스](#Cube클래스)
5. [Commends클래스](#Commends클래스)

### FlatCubeMain클래스
|메소드명|기능|
|------|----|
|[main](#main메소드)|프로그램의 실행|
### main메소드
  ```java
  public static void main(String[] args) throws IOException {
      FlatCube flatCube = new FlatCube();
      flatCube.start();
  }
  ```
  - 프로그램의 실행과 구현을 나누기 위해 클래스를 분리하고, main메소드만 남겨 실행 기능만 담당
### Input클래스
|메소드명|기능|
|------|----|
|[inputString](#inputString메소드)|사용자로부터 값을 입력받고, 반환해주는 기능|
  ```java
  public String inputString() throws IOException {
      BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
      return buf.readLine().toUpperCase();
  }
  ```
  - BufferedReader를 사용해서 사용자로 부터 입력을 받고, 입력값을 toUpperCase()로 대문자로 변경해준 뒤 값을 리턴해준다.
### FlatCube클래스
|메소드명|기능|
|------|----|
|[start](#start메소드)|필요한 객체 생성 및 반복적으로 사용자로부터 값을 입력받는 기능|
|[createCube](#createCube메소드)|큐브생성 기능|
|[createCommend](#createCommend메소드)|사용자로부터 입력받은 명령어에 따라 기능을 수행하도록 명령어 리스트를 생성하는 기능|
|[splitCommend](#splitCommend메소드)|입력받은 명령어를 나눠주는 기능|
|[movingToLeftBottomLine](#movingToLeftBottomLine메소드)|큐브 가장 아랫줄을 왼쪽으로 한 칸 이동시키는 기능|
|[movingToRightBottomLine](#movingToLeftBottomLine메소드)|큐브 가장 아랫줄을 오른쪽으로 한 칸 이동시키는 기능|
|[movingToDownLeftLine](#movingToLeftBottomLine메소드)|큐브 가장 왼쪽 줄을 아래로 한 칸 이동시키는 기능|
|[movingToUpLeftLine](#movingToLeftBottomLine메소드)|큐브 가장 왼쪽 줄을 위로 한 칸 이동시키는 기능|
|[movingToUpRightLine](#movingToLeftBottomLine메소드)|큐브 가장 오른쪽 줄을 위로 한 칸 이동시키는 기능|
|[movingToDownRightLine](#movingToLeftBottomLine메소드)|큐브 가장 오른쪽 줄을 아래로 한 칸 이동시키는 기능|
|[movingToRightTopLine](#movingToLeftBottomLine메소드)|큐브 가장 윗줄을 오른쪽으로 한 칸 이동시키는 기능|
|[movingToLeftTopLine](#movingToLeftBottomLine메소드)|큐브 가능 윗줄을 왼쪽으로 한 칸 이동시키는 기능|
### start메소드
  ```java
  public void start() throws IOException {
      Input input = new Input();
      Map<Integer, Runnable> commendList = new HashMap<>();
      Cube cube = createCube();
      cube.printCube();
      createCommend(cube, commendList);
      while (true) {
          System.out.print("CUBE> ");
          String inputCommend = input.inputString();
          if (inputCommend.equals("Q")) {
              System.out.println("Bye~");
              break;
          }
          splitCommend(inputCommend, commendList);
      }
  }
  ```
  - 프로그램 실행에 필요한 객체를 생성한다.
  - 반복적인 작업 수행을 위해 사용자로부터 특정값이 입력 되기전까지 값을 입력받는다.
### createCube메소드
  ```java
  private Cube createCube() {
      return new Cube(new String[][]{
              {"R ", "R ", "W "},
              {"G ", "C ", "W "},
              {"G ", "B ", "B "}
      });
  }
  ```
  - 프로그램에 사용될 큐브를 생성한다.
### createCommend메소드
  ```java
  private void createCommend(Cube cube, Map<Integer, Runnable> commendList) {
      commendList.put(0, () -> movingToRightTopLine(cube));
      commendList.put(1, () -> movingToLeftTopLine(cube));
      commendList.put(2, () -> movingToDownRightLine(cube));
      commendList.put(3, () -> movingToUpRightLine(cube));
      commendList.put(4, () -> movingToUpLeftLine(cube));
      commendList.put(5, () -> movingToDownLeftLine(cube));
      commendList.put(6, () -> movingToRightBottomLine(cube));
      commendList.put(7, () -> movingToLeftBottomLine(cube));
  }
  ```
  - switch 또는 if ~ else 문의 사용을 피하기위해 입력 받은 명령어에 따라 해당 기능을 하는 메소드를 실행하도록 함수형 인터페이스와 Map을 활용하였다.
### splitCommend메소드
  ```java
  private void splitCommend(String commend, Map<Integer, Runnable> commendList) {
      List<String> values = new ArrayList<>();
      int j = 0;
      for (int i = 0; i < commend.length(); i++) {
          String commends = Character.toString(commend.charAt(i));
          if (commends.equals("'")) {
              String temp = commend.charAt(i - 1) + commends;
              values.set(j - 1, temp);
              continue;
          }
          values.add(Character.toString(commend.charAt(i)));
          j++;
      }
      for (var i : values) {
          commendList.get(Commends.transferCommendID(i)).run();
      }
  }
  ```
  - 연속적으로 입력받은 명령어를 구분하고, 명령어 리스트로 값을 넘겨주고 반환된 명령어ID를 활용해 명령을 수행한다.
### movingToLeftBottomLine메소드
  ```java
  private void movingToLeftBottomLine(Cube cube) {
      System.out.println("B'");
      String[] replaceBottom = new String[cube.getCubeSize()];
      int cubeSize = cube.getCubeSize();
      int cubeLowIndex = 2;
      for (int i = 0; i < cubeSize; i++) {
          int columnIndex = (i + 1) % cubeSize;
          String bottomLineValue = cube.getCube()[cubeLowIndex][columnIndex];
          replaceBottom[i] = bottomLineValue;
      }
      cube.replaceColCube(cubeLowIndex, replaceBottom);
  }
  ```
  - 입력받은 명령어를 화면에 보여준다.
  - 왼쪽으로 이동하는 큐브의 값의 변경되는 index를 계산한 후 저장하여, 큐브를 변경시킬 메소드의 인자값으로 넘겨준다.
  - 다른 이동 명령어도 코드가 비슷, index 계산 로직만 조금씩 다르다.
### Cube클래스
|메소드명|기능|
|------|----|
|[replaceRowCube](#replaceRowCube메소드)|큐브의 행을 변경시키는 기능|
|[replaceColCube](#replaceColCube메소드)|큐브의 열을 변경시키는 기능|
|[printCube](#printCube메소드)|큐브의 현재 모습을 출력해주는 기능|
### replaceRowCube메소드
  ```java
  public void replaceRowCube(int lowIndex, String[] values) {
      for (int i = 0; i < values.length; i++) {
          cube[i][lowIndex] = values[i];
      }
      printCube();
  }
  ```
  - 변경되는 값을 매개변수로 받아서 큐브의 행에 값을 저장
### replaceColCube메소드
  ```java
  public void replaceColCube(int index, String[] values) {
      cube[index] = values;
      printCube();
  }
  ```
  - 변경되는 값을 매개변수로 받아서 큐브의열에 값을 저장
### printCube메소드
  ```java
  public void printCube() {
      for (String[] strings : cube) {
          for (String string : strings) {
              System.out.print(string);
          }
          System.out.println();
      }
      System.out.println();
  }
  ```
  - 큐브의 현재 모습을 출력해준다.
### Commends클래스
|메소드명|기능|
|------|----|
|[isSameCommend](#isSameCommend메소드)|입력된 값이 명령어와 일치하는지 구별해주는 메소드|
|[transferCommendID](#transferCommendID메소드)|입력된 값이 명령어와 일치하면 ID값을 반환 불일치하면 예외를 발생 시키는 기능|

enum 타입의 Commends클래스 내부 모습
  ```java
  public enum Commends {
    MOVING_TO_RIGHT_TOP_LINE("U'", 0),
    MOVING_TO_LEFT_TOP_LINE("U", 1),
    MOVING_TO_DOWN_RIGHT_LINE("R'", 2),
    MOVING_TO_UP_RIGHT_LINE("R", 3),
    MOVING_TO_UP_LEFT_LINE("L'",4 ),
    MOVING_TO_DOWN_LEFT_LINE("L",5 ),
    MOVING_TO_RIGHT_BOTTOM_LINE("B", 6),
    MOVING_TO_LEFT_BOTTOM_LINE("B'", 7),
    QUBE_EXIT("Q", 8);
  ```
  - 명령어 외의 값을 입력했을때 예외처리와 입력된 명령어에 따른 명령 수행을 좀 더 명확하게 확인하고자 enum으로 만들었다.
### isSameCommend메소드
  ```java
  public boolean isSameCommend(String commend) {
      return this.commend.equals(commend);
  }
  ```
  - boolean타입을 사용하여 명령어와 입력된 값이 일치하면 true, 불일치하면 flase를 반환해준다.
### transferCommendID메소드
  ```java
  public static int transferCommendID(String commend) {
      for(var c : Commends.values()) {
          if(c.isSameCommend(commend)) {
              return c.commendID;
          }
      }
      throw new IllegalArgumentException();
  }
  ```
  - isSameCommend에서 반환된 값을 활용하여, 명령어 ID를 반환
  - 입력된 값과 명령어가 다를경우 예외 발생
