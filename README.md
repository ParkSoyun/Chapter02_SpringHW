# 항해99_Chapter2_Spring과제

## 📌 주특기
* Spring

## 📌 요구사항
### 1. 아래의 정보를 가지는 ‘Bus’ 클래스 모델링
#### 포함해야 할 정보
1. 최대 승객수
2. 현재 승객수
3. 요금
4. 버스 번호
5. 주유량
6. 현재 속도
7. 상태
   1. 운행
   2. 차고지 행
   
#### 기능
1. 운행
2. 버스 상태 변경
3. 승객 탑승
4. 속도 변경
    
#### 요구사항
- 버스 번호
  - 버스 객체 생성시 번호는 고유값으로 생성되어야 합니다.
- 버스 상태 변경
  - 버스 객체 생성시 최초 상태는 **‘운행’** 상태가 되며
  - 주유량이 떨어지거나, 운행을 종료할 때 **‘차고지행’** 상태로 변경 합니다.
  - 10미만일 경우 ‘주유가 필요하다’는 메시지를 출력해 주세요
- 승객 탑승
  - 승객 탑승은 **‘최대 승객수’** 이하까지 가능하며 **‘운행 중’** 인 상태의 버스만 가능합니다.
  - 탑승시 현재 승객수가 증가되어야 합니다.
- 속도 변경
  - 주유 상태를 체크하고 주유량이 10 이상이어야 운행할 수 있습니다.
    - 경고메시지
      - 주유량을 확인해 주세요.
      - print문으로 출력
  - 변경할 속도를 입력 받아 현재 속도에 추가 하거나 뺄 수 있어야 합니다.

### 2. 아래의 정보를 가지는 ‘Taxi’ 클래스 모델링
#### 포함해야 할 정보
1. 택시 번호 
2. 주유량
3. 현재속도
4. 목적지 
5. 기본거리
6. 목적지까지 거리
7. 기본 요금
8. 거리당 요금
9. 상태 
   1. 운행 중
   2. 일반
   
#### 기능
1. 운행시작
2. 승객 탑승
3. 속도 변경
4. 거리당 요금 추가
5. 요금 결제

#### 요구 사항
- 운행 시작
    - 운행 시작전 주유상태를 체크 하고 주유량이 10 이상이어야 운행 가능
- 승객탑승
    - 승객 탑승은 택시 상태가 **‘일반'** 일 때만 가능합니다.
    - 그 외 택시는 **‘탑승 불가’** 처리를 해주세요.
    - ‘일반’ 상태의 택시가 승객을 태우면 **‘운행 중’** 상태로 변경해 주세요
- 속도 변경
    - 변경할 속도를 입력 받아 현재 속도에 추가 하거나 뺄 수 있어야 합니다.
- 거리당 요금 추가
    - 기본 거리보다 먼 곳은 추가 요금이 붙습니다.
    - 기본 거리와 추가 요금은 자유롭게 산정해 주세요
- 요금 결제
    - 최종 요금을 출력하는 것으로 합니다.
        
### 3. 다 하셨다면?
- 추상 클래스 및 인터페이스를 이용해 확장에 용이한 형태로 변경해보세요.
