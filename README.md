
## 📌 Project Overview
The **Online Quiz System** is a web-based application developed using **Spring Boot** and **MySQL** as the backend technologies. It enables users to participate in quizzes while allowing administrators to create and manage quizzes, questions, and participants securely.

## 🛠 Tech Stack
- **Backend:** Spring Boot
- **Database:** MySQL
- **Authentication:** JWT-based authentication
- **Version Control:** GitHub
- **Deployment Platforms:** GitHub
## 🚀 Deployment Instructions

### 1️⃣ Fork & Clone Repository
```sh
git clone https://github.com/your-username/online-quiz-system.git
cd online-quiz-system
```

### 2️⃣ Setup Environment Variables
Create a `.env` file in the root directory and configure the database settings.
```env
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/quiz_system
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=yourpassword
JWT_SECRET=your_secret_key
```

### 3️⃣ Build & Run Backend (Spring Boot)
```sh
cd backend
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Database Migration (MySQL)
Run the following SQL script to set up the database schema:
```sql
CREATE DATABASE quiz_system;
USE quiz_system;
```
(Spring Boot will handle table creation via JPA/Hibernate)

### 5️⃣ Run Frontend (If applicable)
```sh
cd frontend
npm install
npm start
```

### 6️⃣ GitHub Deployment (Backend)
#### Using GitHub Actions:
- Create a `.github/workflows/deploy.yml` file for CI/CD pipeline.
- Define jobs for testing, building, and deploying the backend.

Example:
```yaml
name: Deploy Spring Boot App
on: [push]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 17
        uses: actions/setup-java@v2
        with:
          distribution: 'temurin'
          java-version: '17'
      - name: Build the application
        run: mvn clean package
```


## 📌 Features
- **User Authentication:** Secure login with JWT-based authentication
- **Quiz Management:** Admins can create and manage quizzes
- **User Participation:** Users can attempt quizzes and view scores
- **Database Integration:** Uses MySQL with Spring Boot JPA/Hibernate
- **Rate Limiting:** Limits requests per user for security

## 🛡 Security & Best Practices
- Use environment variables for sensitive information
- Implement role-based access control
- Enable HTTPS for secure API communication

