# Chapter1. 리버스 리팩토링

***

### 0단계: 최초 코드 커밋

### 1단계: 부모 클레스(Ch01Test)를 테스트 클래스로 통합
- 상위 클레스 Ch01Test의 테스트 코드를 하위 클레스 StatementTestReverseFactoring에 병합

### 2단계: 데이터 로더(Ch01DataLoader)를 테스트 클래스로 통합
- 상위 클레스 Ch01DataLoader 데이터 적재 기능을 통합
- 생성자 Ch01DataLoader(ClassLoader,ObjectMapper)를 없애고 단순 메서드로 변경
- **[Before]**
  ``` java
  public class Ch01Test {
      private static final Ch01DataLoader DATA_LOADER = new Ch01DataLoader(
            Ch01Test.class.getClassLoader(),
            new ObjectMapper()
      );
  ...
  }

   public class Ch01DataLoader {
     public Ch01DataLoader(final ClassLoader classLoader, final ObjectMapper mapper) {
         this.classLoader = classLoader;
         this.mapper = mapper;
     }
   
      private <T> T loadResource(String path, TypeReference<T> typeReference) {
        try (InputStream inputStream = classLoader.getResourceAsStream(path)) {
            if (Objects.isNull(inputStream)) {
                throw new IllegalStateException("테스트 리소스가 없습니다!: " + path);
            }
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
      }
   }
  ```
  
- **[After]**
  ``` java
  class StatementTestReverseFactoring {
    private <T> T loadResource(String path, TypeReference<T> typeReference) {
        final ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            if (Objects.isNull(inputStream)) {
                throw new IllegalStateException("테스트 리소스가 없습니다!: " + path);
            }
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
  }
  ```
  
### 3단계: TypeReference를 파라미터로 사용하지 않고, 각 변환 타입에 맞는 메서드로 분리
- ObjectMapper의 readValue는 아래와 같이 Class<T>, TypeReference<T>, JavaType 세 가지가 있다.
``` java
    // JSON 데이터를 단순한 Java 객체로 변환할 때 사용합니다.
    public <T> T readValue(InputStream src, Class<T> valueType)
    
    //List<User>, Map<String, User> 같은 제네릭 컬렉션 타입을 변환할 때
    public <T> T readValue(InputStream src, TypeReference<T> valueTypeRef)
    
    // List<Map<String, List<User>>> 같은 복잡한 데이터 구조를 변환할 때.
    // 동적으로 변하는 제네릭 타입을 처리할 때.
    public <T> T readValue(InputStream src, JavaType valueType)
``` 

| 메서드 | 특징 | 사용 예 | 제네릭 지원 | 
|----|----|----|----|
|readValue(InputStream, Class<T>) |	단순 객체 변환	| User.class | ❌ |
|readValue(InputStream, TypeReference<T>)	| 리스트, 맵 같은 제네릭 변환 | new TypeReference<List<User>>() {} |	✅ |
|readValue(InputStream, JavaType) | 복잡한 제네릭 타입 변환 | constructCollectionType(List.class, User.class)	 | ✅ (더 유연함) |

- 어떤 걸 사용해야 할까?
  - 단순한 객체 변환 (예: User.class) → readValue(InputStream, Class<T>)
  - 리스트, 맵 같은 컬렉션 변환 (예: List<User>) → readValue(InputStream, TypeReference<T>)
  - 동적이고 복잡한 제네릭 타입 변환 (예: List<Map<String, List<User>>>) → readValue(InputStream, JavaType)
  - 즉, 일반적으로 Class<T>보다 TypeReference<T>를 선호하며, 더 복잡한 타입을 다뤄야 하면 JavaType을 활용하면 됩니다!


### readValue(InputStream src, JavaType valueType) ###

#### 쉬운 예 ####
``` java
ObjectMapper mapper = new ObjectMapper();
InputStream inputStream = new FileInputStream("users.json");

JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
List<User> users = mapper.readValue(inputStream, type);
 ```

#### 복잡한 예 ####
``` json
[
  {
    "groupA": [
      {"name": "Alice", "age": 30},
      {"name": "Bob", "age": 25}
    ]
  },
  {
    "groupB": [
      {"name": "Charlie", "age": 28}
    ]
  }
]
```

``` java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.*;

public class ComplexCollectionExample {
    public static void main(String[] args) throws Exception {
        String json = "[{\"groupA\":[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]},{\"groupB\":[{\"name\":\"Charlie\",\"age\":28}]}]";
        ObjectMapper mapper = new ObjectMapper();

        TypeFactory typeFactory = mapper.getTypeFactory();
        JavaType listPersons = typeFactory.constructCollectionType(List.class, Person.class);
        JavaType stringKey = typeFactory.constructType(String.class);
        JavaType mapType = typeFactory.constructMapType(Map.class, stringKey, listPersons);

        JavaType complexType = typeFactory.constructCollectionType(List.class, mapType);

        List<Map<String, List<Person>>> result = mapper.readValue(json, complexType);

        result.forEach(System.out::println);
    }
}
 ```





  ---
# 참고 문법
### H3제목 

- .
- xxx `--.--`xxx.


  ```text
    block statement
  ```

1. xxx `블록 sentence` xxx



> 주석 : 
> 주석 내용....

<br/>

- 점문자
    - 들여쓰기



| 테이블 | 테이블 |
|----|----|
| 내용 | xx |
| xx | xx |

