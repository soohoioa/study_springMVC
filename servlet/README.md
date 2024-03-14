# self-study-spring4

[인프런] 우아한형제들 최연소 기술이사 김영한의 스프링 완전 정복 로드맵 네번째, <br/>
        
스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술<br/>

IntelliJ_All : servlet<br/>
Project : Gradle-Groovy<br/>
Language : Java 17<br/>
Spring Boot : 3.1.7<br/>
Dependencies : Spring Web, Lombok<br/>
Packaging : War<br/>
** War 선택시 17버전으로 선택<br/>
server.port=7070<br/>

dependencies {<br/>
	implementation 'org.springframework.boot:spring-boot-starter-web'<br/>
	compileOnly 'org.projectlombok:lombok'<br/>
	annotationProcessor 'org.projectlombok:lombok'<br/>
	//providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'<br/>
	testImplementation 'org.springframework.boot:spring-boot-starter-test'<br/>
}<br/>
