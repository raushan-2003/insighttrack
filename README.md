# InsightTrack – Real-Time Emotion Feedback System 🎭

A Spring Boot-based backend system that captures real-time emotional feedback from users during live sessions using REST APIs and WebSocket. Useful for webinars, teaching, or virtual meetings.

---

## 🔧 Tech Stack
- Java 17, Spring Boot
- REST API + WebSocket (STOMP + SockJS)
- MySQL / H2, Spring Data JPA
- HTML + JS (Vanilla)
- JWT Auth (optional)
- Deployed on Render / Railway

---

## 🚀 Features
- Host can create sessions
- Users submit emoji-based feedback (😊 😐 😡)
- Real-time updates using WebSocket
- Live emotion analytics per session
- Session summary & leaderboard
- Optional login with JWT

---

## 📦 API Endpoints (Examples)

| Method | Endpoint                     | Description                  |
|--------|------------------------------|------------------------------|
| POST   | `/api/sessions`              | Create a new session         |
| POST   | `/api/feedback`              | Submit emotion               |
| GET    | `/api/feedback/{code}`       | View feedback for session    |
| GET    | `/api/analytics/{code}`      | View emotion analytics       |

---

## ✅ Sample JSON (Postman)

```json
{
  "sessionCode": "ABC123",
  "emotion": "😊",
  "userId": "guest_1"
}


🔄 WebSocket Topics

Topic	Purpose
/topic/feedback/{sessionCode}	Real-time feedback updates
/topic/analytics/{sessionCode}	Live emoji count updates

⚙️ Configuration (application.properties)
Copy this file to src/main/resources/application.properties:


# Server Port
server.port=8080

# Database Config
spring.datasource.url=jdbc:mysql://localhost:3306/insight_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# WebSocket Config (optional if using SockJS defaults)
spring.websocket.message-broker.enabled=true

# (Optional) JWT Settings
# jwt.secret=your_jwt_secret
# jwt.expiration=3600000
✅ This file is required to run the project. Make sure you provide your correct DB credentials.

📂 Folder Structure
bash
Copy
Edit
InsightTrack/
├── backend/               # Spring Boot code
├── README.md
├── .gitignore





🧑‍💻 Author
Raushan Singh
Backend Developer | Java | Spring Boot | AWS
🔗 LinkedIn
📧 raushansinghd2003@gmail.com
