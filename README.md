# 실시간 채팅 시스템 개선 프로젝트 🔧

## 프로젝트 개요 📄
이 프로젝트는 졸업 작품에서 구현한 기존 WebSocket 서버의 한계를 보완하기 위한 토이 프로젝트로, 시스템 아키텍처를 개선하여 실시간 채팅 시스템의 확장성과 안정성을 높였습니다. 

## 개선된 아키텍처 🔍

### 1. **기존 시스템 한계**
- 초기 구현에서는 `Spring`의 `TextWebSocketHandler`를 상속받아 실시간 채팅을 구축했습니다.
- 하지만 트래픽 증가에 대비한 확장성 부족이 문제로 드러났습니다.

### 2. **개선 사항 🛠️**
- **로드 밸런싱 도입**: `Nginx`를 기반으로 한 로드 밸런싱을 적용하여 다중 채팅 서버 운영 구조로 변경했습니다. 이를 통해 수평 확장이 가능해졌습니다.
- **메시지 브로커 도입**: `Kafka`를 메시지 브로커로 도입하여 다중 서버 환경에서 안정적인 메시지 공유 및 순서 보장을 확보했습니다.
- **STOMP 프로토콜 적용**: Kafka와 연동하여 `STOMP` 프로토콜을 사용, Pub-Sub(구독/발행) 방식으로 메시지를 처리하도록 개선했습니다.
  
### 3. **운영 및 모니터링 📊**
- **Docker Compose**: 컨테이너 관리에 `Docker Compose`를 활용하여 여러 서비스를 동시에 관리할 수 있도록 했습니다.
- **모니터링 시스템**:
  - `Prometheus`를 통해 실시간 메트릭 데이터를 수집하고,
  - `Grafana` 대시보드를 사용하여 각 채팅 서버의 상태를 실시간으로 모니터링 할 수 있게 구성했습니다.

## 기술 스택 ⚙️
- **Spring Framework**: WebSocket 서버 구현
- **Nginx**: 로드 밸런싱
- **Kafka**: 메시지 브로커
- **STOMP**: 메시지 처리 프로토콜
- **Docker Compose**: 컨테이너 관리
- **Prometheus**: 메트릭 수집
- **Grafana**: 실시간 모니터링 대시보드

## 시스템 구조 🌐

### 다중 서버 환경
- **Nginx**를 사용하여 트래픽을 분산하고, 각 채팅 서버가 Kafka를 통해 메시지를 전파합니다.
- **Kafka**를 통해 다중 서버 간 안정적인 메시지 순서 보장 및 확장성을 확보합니다.

### 메시지 흐름 💬
1. 사용자가 채팅방에 메시지를 전송합니다.
2. 메시지는 Kafka를 통해 전파되며, 연결된 다른 서버에서 이를 수신하여 처리합니다.
3. STOMP 프로토콜을 이용한 Pub-Sub 방식으로 실시간 메시지 전송이 이루어집니다.

### 주요 목표 🎯
- **확장성**: 트래픽 증가 시에도 안정적으로 서비스를 운영할 수 있도록 확장 가능한 구조를 마련.
- **안정성**: Kafka를 통한 메시지 순서 보장 및 다중 서버 환경에서의 안정적인 메시지 전송을 구현.
- **모니터링**: 실시간 서버 상태 모니터링을 통해 시스템의 상태를 직관적으로 확인.
