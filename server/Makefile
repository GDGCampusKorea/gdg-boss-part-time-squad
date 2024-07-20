# Makefile for a Gradle-based Java project

# 기본 타겟
all: clean build run


# Wrapper 설치
wrapper:
	@echo "Initializing project..."
	gradle wrapper

# 빌드 타겟
build:
	@echo "Building project..."
	./gradlew build

# 애플리케이션 실행
run:
	@echo "Running application..."
	./gradlew bootRun

# 클린업
clean:
	@echo "Cleaning up..."
	./gradlew clean

# 테스트 실행
test:
	@echo "Running tests..."
	./gradlew test
