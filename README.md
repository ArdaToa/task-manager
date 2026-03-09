# Spring Boot Kurumsal Base (Generic) Mimari Projesi

Bu proje, Spring Boot temel alınarak geliştirilmiş, yüksek ölçeklenilebilirlik ve sürdürülebilirlik ilkelerine dayanan kurumsal seviyede bir "Generic Base Architecture" (Temel Mimari) uygulamasıdır. Proje yüzeyi bir Görev Yönetimi (Task Manager) API'si gibi görünse de, alt yapısında istenilen her türlü (E-Ticaret, İçerik Yönetimi vb.) modülün dakikalar içerisinde entegre edilebileceği dinamik bir zemin barındırmaktadır.

## Mimari Özellikler (Core Architecture)

Her yeni veritabanı tablosu (Entity) için tekrar tekrar aynı CRUD kodlarını yazmak yerine, bu projenin temelinde ileri seviye Generic katmanlar inşa edilmiştir:

*   **BaseDomain (MappedSuperclass):** Sistemdeki tüm varlıkların (Entity) kalıtımsal olarak aldığı, içerisinde evrensel alanların (`id`, `createdDate`, `updatedDate`, `isDeleted`) otomatize edildiği üst sınıftır.
*   **BaseRepository:** Spring Data JPA yeteneklerini barındıran, jenerik (T tipinde) veri erişim arayüzüdür.
*   **BaseService (Generic T, DTO):** İş mantığının (Business Logic) soyutlandığı, Entity-DTO dönüşümlerinin (`MapStruct` kullanılarak) ve standart CRUD işlemlerinin yönetildiği ana servis katmanıdır.
*   **BaseController:** Yönlendirmelerin (Routing), HTTP durum kodlarının ve standart JSON yanıtlarının (`ApiResponse` Wrapper) tek bir noktadan yönetildiği jenerik REST denetleyicisidir.
*   **BaseCriteriaService (Dynamic Specifications):** İleri seviye JPA Specification'ları kullanılarak, her türlü nesne üzerinde dinamik filtreleme (Property Filtering), sayfalama (Pagination) ve sıralama (Dynamic Sorting - DESC/ASC) yapabilen özel veritabanı sorgulama altyapısıdır.

## Güvenlik ve Kimlik Doğrulama (Security & Authentication)

*   **Stateless JWT Authentication:** Kullanıcı doğrulama işlemleri, JSON Web Token (jjwt kütüphanesi) üzerinden durumsuz (stateless) bir şekilde güvenle yönetilmektedir.
*   **Security Context Holder Entegrasyonu:** Mimari, istemciden gelen (Payload içerisindeki) güvensiz kullanıcı kimliklerini kabul etmez. Bunun yerine `SecurityUtil` adlı özel bileşen aracılığıyla, o an sistemi kullanan kişinin doğrulanmış kimlik bilgilerini doğrudan Spring Security Context içerisinden zekice çeker (Intercepting). Bu yapı, yetki aşımı (Privilege Escalation) ve veri sızıntılarını mimari seviyede engeller.

## Standart Hata Yönetimi (Global Exception Handling)

*    `@RestControllerAdvice` ve `@ExceptionHandler` anotasyonları kullanılarak projenin genelinde oluşabilecek tüm istisnalar (Entity Not Found, Validation Errors, Security Exceptions) tek bir merkezde toplanmıştır.
*   Sistem tarafından fırlatılan hatalar, kullanıcıya ham ve anlaşılmaz Stack Trace'ler halinde dönmek yerine, kurumsal API standartlarına uygun olarak `ApiResponse` arayüzüne dönüştürülüp sunulmaktadır.

## Teknoloji Yığını (Tech Stack)

*   **Programlama Dili:** Java 17
*   **Framework:** Spring Boot 3.x (Web, Data JPA, Security, Validation)
*   **Veritabanı:** MySQL
*   **Nesne Eşleme (Mapping):** MapStruct
*   **Kodu Temizleme:** Lombok
*   **Yapı Aracı:** Maven

## Veri Alışveriş Standardı (Enterprise API Wrapper)

Projedeki tüm başarılı veya başarısız HTTP yanıtları, içerisinde veri tipleri değişse dahi her zaman aşağıdaki JSON formatında (Wrapper) istemciye dönülmektedir:

```json
{
  "success": true,
  "message": "İşlem başarıyla gerçekleştirildi.",
  "data": { ... }
}
```

Bu proje; SOLID prensipleri, DRY (Don't Repeat Yourself) yaklaşımı, temiz kod (Clean Code) ve kurumsal yazılım kalıpları temel alınarak tasarlanmış ve yayına hazırlanmıştır.
