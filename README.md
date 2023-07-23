# Blog App Projesi

Bu, Spring Boot ile oluşturulmuş bir blog uygulamasıdır. Bu proje, blog yazarlarının makalelerini yayınlayabileceği, kullanıcıların yorum yapabileceği ve etkileşimde bulunabileceği basit bir blog platformudur.

## Başlarken

Bu talimatlar, projeyi yerel makinenizde çalıştırmak ve geliştirmek için size yardımcı olacaktır.

### Gereksinimler

Bu projeyi çalıştırmak için aşağıdaki yazılımların yüklü olması gerekmektedir:

- Java Development Kit (JDK) 11 veya üstü
- Maven
- MySQL veritabanı

### Kurulum

1. Projeyi çalıştırmak için kullandığınız IDE'nin gerekliliklerine göre açınız. Maven projesi olduğu için direkt pom.xml'den çalıştırabilirsiniz. Bağımlılıklar yüklendikten sonra ikinci adıma geçin.


2. `application.properties` dosyasında, veritabanı bağlantısı için gerekli bilgileri düzenleyin:
``` spring.datasource.url = jdbc:mysql://localhost:3306/blogapp
spring.datasource.username = root
spring.datasource.password = password
spring.datasource.driver-class-name = com.mysql.jdbc.Driver ```

Uygulama başarıyla başlatıldığında, `http://localhost:8080` adresine giderek blog app'inizi kullanmaya başlayabilirsiniz.

## Kullanılan Paketler

Bu proje aşağıdaki paketleri kullanmaktadır:

- Lombok: Getter, setter ve constructor gibi tekrarlayıcı kodları azaltmak için kullanılır.
- Spring Data JPA: Veritabanı işlemleri için kullanılır.
- MySQL Connector: MySQL veritabanına bağlantı sağlar.
- Starter Validation: Giriş verilerini doğrulamak için kullanılır.

## Katkıda Bulunma

Her türlü katkıya ve yoruma açığım. Kendimi bu konuda geliştirmek istiyorum. Değerlendirmeleriniz için teşekkür ederim.
