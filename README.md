# AWS Lambda Course Management API

![AWS Lambda](https://img.shields.io/badge/AWS-Lambda-orange?style=for-the-badge&logo=amazon-aws)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.4-green?style=for-the-badge&logo=spring-boot)
![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java)

A serverless RESTful API for course management built with Spring Boot and AWS Lambda. This application allows you to create, read, update, and delete course information through a simple REST interface, all running on AWS's serverless infrastructure.

## 📋 Table of Contents

- [Architecture](#-architecture)
- [Features](#-features)
- [API Endpoints](#-api-endpoints)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [Local Development](#-local-development)
- [Deployment](#-deployment)
- [Technologies Used](#-technologies-used)

## 🏗 Architecture

This application follows a serverless architecture pattern:

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│             │     │             │     │             │
│  API        │────▶│  AWS        │────▶│  Spring     │
│  Gateway    │     │  Lambda     │     │  Boot App   │
│             │     │             │     │             │
└─────────────┘     └─────────────┘     └─────────────┘
```

- **API Gateway**: Routes HTTP requests to the Lambda function
- **AWS Lambda**: Executes the Spring Boot application in a serverless environment
- **Spring Boot**: Handles business logic and provides REST endpoints

The application uses the AWS Serverless Java Container library to bridge Spring Boot with AWS Lambda, allowing a standard Spring Boot application to run efficiently in a serverless environment.

## ✨ Features

- **Course Management**: Create, read, update, and delete course information
- **RESTful API**: Standard HTTP methods for interacting with resources
- **Serverless Architecture**: No server management required, scales automatically
- **Low Cost**: Pay only for what you use with AWS Lambda's pricing model

## 🔌 API Endpoints

| Method | Endpoint         | Description                   | Request Body    | Response        |
|--------|------------------|-------------------------------|-----------------|-----------------|
| GET    | /ping            | Health check endpoint         | -               | `{"pong": "Hello, World!"}` |
| GET    | /courses         | Get all courses               | -               | Array of Course objects |
| GET    | /courses/{id}    | Get course by ID              | -               | Course object or 404 |
| POST   | /courses         | Create a new course           | Course object   | Created Course object |
| PUT    | /courses/{id}    | Update an existing course     | Course object   | 200 OK or 404 Not Found |
| DELETE | /courses/{id}    | Delete a course               | -               | 200 OK or 404 Not Found |

### Course Object Structure

```json
{
  "id": 1,
  "name": "Introduction to AWS Lambda",
  "price": 99.99
}
```

## 📋 Prerequisites

- [AWS CLI](https://aws.amazon.com/cli/) - Configured with appropriate permissions
- [SAM CLI](https://github.com/awslabs/aws-sam-cli) - For local testing and deployment
- [Java 17](https://adoptium.net/) - Required for development
- [Maven](https://maven.apache.org/) - For building the project

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/aws-lambda-example.git
   cd aws-lambda-example
   ```

2. Build the project:
   ```bash
   mvn clean package
   ```

## 💻 Local Development

You can test the application locally using the SAM CLI:

1. Build the application:
   ```bash
   sam build
   ```

2. Start the local API:
   ```bash
   sam local start-api
   ```

3. Test the API:
   ```bash
   # Test the ping endpoint
   curl -s http://127.0.0.1:3000/ping | python -m json.tool

   # Get all courses
   curl -s http://127.0.0.1:3000/courses | python -m json.tool

   # Create a new course
   curl -s -X POST http://127.0.0.1:3000/courses \
     -H "Content-Type: application/json" \
     -d '{"name":"AWS Lambda Masterclass","price":149.99}' | python -m json.tool
   ```

## 🌩 Deployment

Deploy the application to AWS using the SAM CLI:

```bash
sam deploy --guided
```

Follow the prompts to configure your deployment. Once deployed, SAM will output the API Gateway URL that you can use to access your application.

Example:
```
-------------------------------------------------------------------------------------------------------------
OutputKey-Description                        OutputValue
-------------------------------------------------------------------------------------------------------------
AwsLambdaExampleApi - URL for application    https://xxxxxxxxxx.execute-api.us-west-2.amazonaws.com/Prod/
-------------------------------------------------------------------------------------------------------------
```

## 🛠 Technologies Used

- **Spring Boot 3**: Java framework for building web applications
- **AWS Lambda**: Serverless compute service
- **AWS API Gateway**: Managed service for creating, publishing, and securing APIs
- **AWS SAM**: Serverless Application Model for easier deployment
- **Java 17**: Programming language
- **Maven**: Build and dependency management
- **Lombok**: Reduces boilerplate code

---

Built with ❤️ using [AWS Serverless Java Container](https://github.com/aws/serverless-java-container)
