# Java Coding Test Workspace

Java 17 기준 코딩테스트 풀이용 최소 구조입니다.

## 폴더 구조

```text
coding-test/
├─ boj/
│  └─ week01/
│     └─ Main.java
├─ programmers/
│  ├─ hash/
│  │  └─ Solution.java
│  ├─ ...기존 풀이 폴더
│  └─ ...
├─ review/
│  └─ mistakes.md
└─ template/
   ├─ Main.java
   └─ Solution.java
```

기존 `programers/` 하위 풀이 파일은 버리지 않고 `coding-test/programmers/` 아래로 그대로 옮겼습니다.

## 사용 규칙

- Java 버전은 17 기준으로 풀이합니다.
- 백준 제출 파일은 항상 `Main.java`, 클래스명은 `Main`을 사용합니다.
- 프로그래머스 제출 파일은 항상 `Solution.java`, 클래스명은 `Solution`을 사용합니다.
- 패키지는 사용하지 않습니다.
- 빌드 시스템은 추가하지 않고, IntelliJ에서 폴더를 바로 열어 사용합니다.
- 한 문제를 풀고 나면 자주 틀린 포인트를 `coding-test/review/mistakes.md`에 기록합니다.

## 시작 방법

### 백준

1. 주차 폴더를 하나 만듭니다. 예: `coding-test/boj/week02`
2. `coding-test/template/Main.java`를 복사해서 `Main.java`로 둡니다.
3. 입력 파싱, 풀이, 출력만 채웁니다.
4. 제출 전 파일명과 클래스명이 모두 `Main`인지 확인합니다.

### 프로그래머스

1. 분류 폴더를 만듭니다. 예: `coding-test/programmers/stack-queue`
2. `coding-test/template/Solution.java`를 복사해서 `Solution.java`로 둡니다.
3. 사이트 메서드 시그니처에 맞게 `solution(...)`만 수정합니다.
4. 제출 전 클래스명이 `Solution`인지 확인합니다.

## 템플릿 사용 예시

### 백준 템플릿 복사

```powershell
Copy-Item .\coding-test\template\Main.java .\coding-test\boj\week02\Main.java
```

### 프로그래머스 템플릿 복사

```powershell
Copy-Item .\coding-test\template\Solution.java .\coding-test\programmers\hash\Solution.java
```

## IntelliJ 사용법

1. IntelliJ에서 `C:\study\algorithm` 폴더를 그대로 엽니다.
2. Project 뷰에서 `coding-test` 아래 폴더를 바로 선택해 풀이합니다.
3. 실행이 필요하면 해당 파일을 열고 Run을 누릅니다.
4. 패키지를 쓰지 않으므로 파일 이동 시 import 충돌만 없는지 확인하면 됩니다.

## 메모

- `out/`은 컴파일 산출물 폴더입니다.
- 기존 풀이 정리와 신규 템플릿 사용만으로도 바로 공부를 시작할 수 있게 최소 구조만 유지합니다.
