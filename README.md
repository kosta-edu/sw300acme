# sw300 demo project 'acme''

## Run

> $> gradle run
>
> 브라우저에서 http://localhost:8080 접속

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

## Tests

> given/when/then style

- ClazzTest: Venu,Clazz,ClassDay 테스트 케이스


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