# webstore 
Obecnie pracuję nad projektem.
Planuję dodać kilka koniecznych funkcjonalności, lecz chciałbym już teraz podzielić się efektami mojej pracy.
(m.in. mechanizm obsługujący koszyk zakupów i odnośniki łączące widoki w całość)

W projekcie użyłem:
1. Architektury MVC (Model-View-Controller)
2. Konfiguracji serwletu przekzaującego oraz kontekstu aplikacji opartych na XML
3. Interfejsu HandlerMapping i wzorców URI do mapowania żądań
4. Internacjonalizacji:
    - np. pod adresem: "webstore/products/add"
5. Warunkowych przekierowań:
    - użycie kodu promocyjnego pod adresem: "webstore/products/specialOffer?promo=OF3RTA" powoduje przekierowanie do strony z produktami
    - wpisanie innego kodu niż OF3RTA powoduje pojewienie się komunikatu błędu
6. Żądań typu multipart (załączanie plików lub obrazów):
    - "webstore/products/add"
7. Walidacji strony dodawania produktu:
    - "webstore/products/add"
8. Spring Security:
    - aby przejść na stronę dodawania produktu należy wpisać hasło oraz login (admin, admin)
    - po wprowadzeniu błędnych danych zostanie zwrócony błąd
9. Odwzorowania widoków od strony użytkownika:
    - po wprowadzeniu adresu "webstore/products/product/P2" otrzymamy stronę produktu
    - po dodaniu do powyższego adresu ".xml" lub ".json" wyświetlone zostanę informacje w odpowiednim formacie
10. Interceptorów raportujących o:
    - czasie wykonania żądania (export informacji do pliku "C:\\webstore\\webstore-performance.log")
    - użytkowniku dodającym produkt pod adresem: "webstore/products/add" (export: C:\\webstore\\webstore-Audit.log)
11. Wyszukiwania produktów:
    - np. złożonego z przedziału cenowego, producenta oraz kategorii: "webstore/products/fruits/low=2;high=7?manufacturer=chiquita"
    - lub tylko pod względem kategorii: "webstore/products/vegetables"
