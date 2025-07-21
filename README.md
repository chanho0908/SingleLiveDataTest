# SingleLiveDataTest

# LiveData vs SingleLiveData 테스트

## 🎯 무엇을 테스트하나요?

일반 라이브데이터와 싱글 라이브데이터를 사용해 이벤트를 발생 시켰을 때 차이를 확인하는 테스트

## 🧪 테스트 하기

### LiveData 테스트

1. `LiveData로 이동` 버튼 클릭 → 두 번째 화면 이동
2. `돌아가기` 클릭 → 첫 번째 화면 복귀  
3. **📱 화면 회전** (세로 ↔ 가로)

**결과**: 😰 두 번째 화면으로 **또** 이동함

### SingleLiveData 테스트

1. 앱 재실행
2. `SingleLiveData로 이동` 버튼 클릭 → 두 번째 화면 이동
3. `돌아가기` 클릭 → 첫 번째 화면 복귀
4. **📱 화면 회전** (세로 ↔ 가로)

**결과**: 😊 첫 번째 화면 **그대로 유지**

## 📋 결과 정리

| | LiveData | SingleLiveData |
|--|----------|----------------|
| **화면 회전 시** | 다시 실행됨 ❌ | 실행되지 않음 ✅ |

## 🔍 핵심

- **LiveData**: 화면 회전 시 이전 동작이 다시 실행됨
- **SingleLiveData**: 화면 회전해도 한 번만 실행됨

## 🤔 왜 이렇게 되나요?
### LiveData가 다시 실행되는 이유
- 화면 회전 시 Activity가 재생성됨
- LiveData는 마지막 값을 기억하고 있음
- 새로운 Activity가 LiveData를 관찰하기 시작
- LiveData가 기억하던 값을 다시 전달함
- 결과적으로 이전 동작이 다시 실행됨

### SingleLiveData가 다시 실행되지 않는 이유
- 화면 회전 시 Activity가 재생성됨
- SingleLiveData는 한 번 사용된 값을 삭제함
- 새로운 Activity가 관찰을 시작해도 전달할 값이 없음
- 결과적으로 동작이 실행되지 않음

## 📌 언제 사용하나요?

- **화면 이동, 팝업 띄우기** → SingleLiveData
- **데이터 표시** → LiveData
