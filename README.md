# wise_mall

[//]: # (## 5월 3주차`)
[//]: # (![image]&#40;https://github.com/user-attachments/assets/2a279d99-46cc-4106-afc9-af39cd13fbea&#41;)
[//]: # ()
[//]: # (- 각 서비스 DB 테이블 구축)
[//]: # (- MSA 서비스간 API 통신 구축`)

# API 목록
현재 레포지토리에 정의된 주요 HTTP 엔드포인트를 다음 표에 정리했습니다.

## Monolithic-Architecture: v1

### Account-Service
| Method | URL | Description |
| --- | --- | --- |
| POST | /api/v1/account/join | 회원 가입 요청을 처리하고 계정을 생성합니다. |
| POST | /api/v1/account/login | 이메일과 비밀번호로 로그인하여 액세스/리프레시 토큰을 발급합니다. |
| POST | /api/v1/account/logout | 전달된 토큰 정보를 기반으로 세션을 종료합니다. |
| POST | /api/v1/account/reissue | 리프레시 토큰으로 새로운 액세스/리프레시 토큰 쌍을 발급합니다. |


### Product-Service
| Method | URL | Description |
| --- | --- | --- |
| POST | /api/v1/product | 신규 상품을 생성하고 기본 정보를 저장합니다. |
| GET | /api/v1/product/{id} | 상품 ID로 단일 상품 상세 정보를 조회합니다. |
| GET | /api/v1/product | page, size 쿼리 파라미터로 상품 목록을 페이지 단위로 반환합니다. |
| POST | /api/v1/product/{id} | 승인 대기 중인 상품을 승인 요청 상태로 변경합니다. |
| PUT | /api/v1/product/approve/allow | id 쿼리 파라미터로 지정한 상품 승인 요청을 허용합니다. |
| PUT | /api/v1/product/approve/deny | id 쿼리 파라미터로 지정한 상품 승인 요청을 거절합니다. |

### Order-Service
| Method | URL | Description |
| --- | --- | --- |
| POST | /api/v1/order | 주문 생성 요청 본문을 받아 주문을 생성합니다. |
| GET | /api/v1/order/{orderId} | 주문 ID로 주문 상세 정보를 조회합니다. |

### Payment-Service
| Method | URL | Description |
| --- | --- | --- |
| POST | /api/v1/payment | 주문 ID와 결제 정보를 받아 결제를 시도하고 상태를 반환합니다. |
| GET | /api/v1/payment/order/{orderId} | 지정한 주문의 결제 상태를 조회합니다. |
