# sw300 demo project 'acme''


## Build

> acme 어플리케이션 빌드: ./gradlew build
>
> 도커 이미지 빌드: ./docker build -t acme:{tag} .

> 공개 도커 이미지 레파지터리: k16wire/sw300acme

## Run

> 소스를 가지고 직접 실행한다.
>
> $> gradle run
>
> 도커 이미지를 가지고 실행한다.
> 
> 데이터베이스를 h2가 아닌 MySQL 을 사용한다면 MySQL 데이터베이스를 준비한다.
> 
> - Database: acme
> - User: acmeadmin
> - Password: acmeadmin00

## Test

> 브라우저를 통해 접속
>
> [http://localhost:8080](http://localhost:8080)

## Test code

> given/when/then style

- CourseTest: Course,CourseWare,Discipline
- JobTest: Industry,Practice,Theory,LearningObject,Job
- ClazzTest: Venu,Clazz,ClassDay 테스트 케이스
- CustomerRepositoryTest: CustomerRepository
- ScheduleTest: 

## Repository Restful EndPoints

<pre><code>
{
  "_links" : {
    "classday" : {
      "href" : "http://localhost:8080/classdays{?page,size,sort}",
      "templated" : true
    },
    "topic" : {
      "href" : "http://localhost:8080/topics{?page,size,sort}",
      "templated" : true
    },
    "venu" : {
      "href" : "http://localhost:8080/venus{?page,size,sort}",
      "templated" : true
    },
    "theory" : {
      "href" : "http://localhost:8080/theorys{?page,size,sort}",
      "templated" : true
    },
    "clazz" : {
      "href" : "http://localhost:8080/clazzs{?page,size,sort}",
      "templated" : true
    },
    "enrollment" : {
      "href" : "http://localhost:8080/enrollments{?page,size,sort}",
      "templated" : true
    },
    "practice" : {
      "href" : "http://localhost:8080/practices{?page,size,sort}",
      "templated" : true
    },
    "job" : {
      "href" : "http://localhost:8080/jobs{?page,size,sort}",
      "templated" : true
    },
    "discipline" : {
      "href" : "http://localhost:8080/disciplines{?page,size,sort}",
      "templated" : true
    },
    "customer" : {
      "href" : "http://localhost:8080/customers{?page,size,sort}",
      "templated" : true
    },
    "industry" : {
      "href" : "http://localhost:8080/industrys{?page,size,sort}",
      "templated" : true
    },
    "paymentmethod" : {
      "href" : "http://localhost:8080/paymentmethods{?page,size,sort}",
      "templated" : true
    },
    "courseware" : {
      "href" : "http://localhost:8080/coursewares{?page,size,sort}",
      "templated" : true
    },
    "instructor" : {
      "href" : "http://localhost:8080/instructors{?page,size,sort}",
      "templated" : true
    },
    "lo" : {
      "href" : "http://localhost:8080/los{?page,size,sort}",
      "templated" : true
    },
    "course" : {
      "href" : "http://localhost:8080/courses{?page,size,sort}",
      "templated" : true
    },
    "payment" : {
      "href" : "http://localhost:8080/payments{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}
</code></pre>

## Frameworks

- [Spring Boot](http://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
    * PagingAndSortingRepository
- [Lombok](https://projectlombok.org/)
- [JodaTime](https://www.joda.org/joda-time/index.html)

## Tools

- [H2](http://www.h2database.com/html/main.html)
- [Gradle](https://gradle.org/)
- [PostMan](https://www.getpostman.com/)