# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 문자열 계산 
> 모짝미를 통해 구현하여 작업목록 및 기능 분석은 네비게이터의 PC에 있습니다..!

## [2단계 로또(자동)](https://edu.nextstep.camp/s/E42ziiPQ/ls/hd8U68zo)
> 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급하고, 발급한 로또의 당첨 통계를 출력한다.

### 1. 구현 기능 목록
- 입력한 구입 금액에 따라 장당 1000원인 로또를 구매한다.
- 로또는 1~45까지의 숫자 중 중복되지 않는 숫자 6개를 뽑아내야 한다.
- 입력 받은 당첨 번호를 ','로 Split 처리 한다.
- 구매한 로또 번호와 당첨 번호의 일치하는 개수를 파악한다.
- 당첨 번호 일치 개수에 따라 등수를 파악한다.
- 각 등수별 당첨 횟수를 카운트 한다.
- 각 등수별 당첨 횟수에 따른 최종 당첨 금액을 산정한다.
- 구매 금액과 최종 당첨 금액에 따른 수익률을 산정한다.