# Spring Boot Redis
Spring Boot Redis Cache Application

Step 1 : Make sure Redis database is install and running in your machine

    https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/        

Step 2 : Add Dependency to pom.xml

    <!-- Spring Boot Starter Redis -->
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    <!-- Jackson for Serialization -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>

Step 3 : To use Redis as cache add @EnableCache to the Spring Boot main class file

    @SpringBootApplication
    @EnableCaching        
    public class TestApplication {    
        public static void main(String[] args) {
            // ...
        }    
    }

Step 4 : Create RedisConfig class
    
    @Configuration
    public class RedisConfig {

        @Bean
        public LettuceConnectionFactory redisConnectionFactory() {
            //
        }

        @Bean
        public RedisTemplate<String, Object> redisTemplate() {
           //
        }    
    }

Step 5 : Apply Caching on your data

    @Override
    @Cacheable(cacheNames = "myCache")
    public List<Course> retrieveCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        redisTemplate.opsForValue().set("courses", courses);
        return courses;
    }

