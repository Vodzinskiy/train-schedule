
# Тема: Веб-сайт розклад руху потягів
**Сутності**: потяги, станції, дата/час 

**Актори**: Користувач, Адміністратор 

**Сценарії використання**: 

+ ___Користувач___: Перегляд руху поїздів, Пошуг потягів з однієї заданої станції до іншої 

+ ___Адміністратор___: Створення/редагування/видалення інформації про потяги, станції 

## Виконали студенти групи ІО-04 
  - Водзінський Роман
  - Возниця Дмитро
  - Нерода Арсен
  
Посилання на сайт: [train-schedule](https://train-schedule-spring.herokuapp.com/) (для користувача)

Посилання на сайт: [train-schedule](https://train-schedule-spring.herokuapp.com/admin) (для адміністратора)  

# Лаб 2

+ __Користувач__ може знайти потяг заповнивши форму, також може натиснути на потяг та переглянути всю інформацію про нього

+ __Адміністратор__ може створювати/редагувати/видаляти станції та потяги за id, а також для редагування потягів змінювати не тільки його назву, а й станції через які він ходить


## Контрольні питання 

1. Поясніть значення наступних термінів:

  - Inversion of Control (IoC) - це принцип у розробці програмного
  забезпечення, який передає керування об’єктами або частинами програми до
  контейнера або фреймворку. Найчастіше ми використовуємо його в контексті
  об'єктно-орієнтованого програмування. В нашому випадку управління бере Spring
  Framework.
  
  - IoC container - контейнер Spring IoC є ядром Spring Framework. Він створює об’єкти, конфігурує та
  збирає їхні залежності, керує всім їхнім життєвим циклом.
  
  - Dependency Injection (DI) - це фундаментальний аспект фреймворку Spring, за
  допомогою якого контейнер Spring «впроваджує» об’єкти в інші об’єкти або
  «залежності».
  
  - Dependency inversion principle - Принцип інверсії залежностей (DIP) є частиною колекції принципів об'єктно-орієнтованого програмування, широко відомих як SOLID.       Принцип інверсії залежностей (DIP) стверджує, що модулі високого рівня не повинні залежати від модулів низького рівня; обидва повинні залежати від абстракцій.         Абстракції не повинні залежати від деталей.

2.  В чому полягає різниця між анотаціями @Component та @Bean? Опишіть переваги та недоліки створення бінів за допомогою цих анотацій.

|@Bean|@Component|
|---|---|
|@Bean використовується для явного оголошення одного bean-компонента, замість того, щоб дозволити Spring зробити це автоматично |Якщо будь-який клас анотовано @Component, він буде автоматично виявлений за допомогою сканування шляху до класу|
|Bean можна створити, навіть якщо клас знаходиться поза контейнером spring|Ми не можемо створити Component, якщо клас знаходиться поза контейнером spring|
|Це анотація на рівні методу|Це анотація рівня класу|
|Працює лише тоді, коли клас анотовано @Configuration|Працює без анотації @Configuration|
|@bean використовується, якщо вам потрібна конкретна реалізація на основі динамічних умов|Для Component ми не можемо написати конкретну реалізацію на основі динамічних умов|

3. Чому слід уникати ін’єкцій залежностей напряму у поле біна?

Тому що таким образом ми фактично втрачаємо гнучкість нашого проекту.
Наприклад якщо ми захочемо переконфігурувати проект, нам прийдеться вручну
правити код що у великих проектах забирає багато часу. Також це порушує Explicit
Dependency Principle.

4.  В яких випадках краще використовувати ін’єкції залежностей за допомогою конструкторів, а в яких за допомогою сетерів?

Конструктори ми повинні використовувати в разі якщо нам потрібно створити об’єкт зразу з всіма залежностями, в той час як сетери ми повинні використовувати коли ми
працюємо з великою кількістю залежностей а також це добре для читабельності.

5. В яких випадках краще використовувати біни типу singleton, а в яких prototype?

Біни singleton ми використовуємо для stateless об’єктів (без стану), тобто таких де ми можемо створити тільки один їхній екземпляр. В той час як prototype
використовується для бінів з багатьма станами.

6. Чи можливе у Spring Framework створення циркулярних залежностей при ін’єкціях?

Зараз Spring Framework не підтримує циркулярних залежностей. Це робить код набагато важчим для підтримування, читання, тестування та вразливішим до
помилок.

7. Чи може бути в одному проекті кілька класів з реалізацією якогось інтерфейсу, якщо цей інтерфейс використовується для ін’єкції залежностей?

Так

8. Чи може бін мати кілька методів, помічених анотацією @Autowired?

Так, це працює добре з сетерами.

9. Чи може бін мати кілька конструкторів, помічених анотацією @Autowired?

Так

# Лаб 3

Посилання на використання [умовного форматування ( if )](https://github.com/Vodzinskiy/train-schedule/blob/main/src/main/resources/templates/editTrain.html) рядки 14, 21

Посилання на використаня [елемент вибору ( switch/case )](https://github.com/Vodzinskiy/train-schedule/blob/main/src/main/resources/templates/index.html) рядок 57

Посилання на використаня [циклу ( each)](https://github.com/Vodzinskiy/train-schedule/blob/main/src/main/resources/templates/editTrain.html) рядок 61

## Контрольні питання 

1. Для чого потрібен шаблон проектування MVC.

Цей патерн розробки потрібен для того, щоб розділити логічні частини програми та створювати їх окремо один від одного. Тобто писати незалежні блоки коду, які можна як завгодно міняти, не чіпаючи інші.

2. В чому полягають переваги використання шаблону проектування Front Controller?

Переваги використання шаблону Front Controller

- __Централізований контроль__ Front Controller обробляє всі запити до веб-додатку. Ця реалізація централізованого керування, яка дозволяє уникнути використання кількох контролерів, є бажаною для застосування політик усієї програми, таких як відстеження користувачів і безпека.

- __Безпека ниток__ Новий об’єкт команди виникає під час отримання нового запиту, а об’єкти команди не призначені для потокової безпеки. Таким чином, в командних класах буде безпечно. Хоча безпека не гарантується, коли збираються проблеми з потоками, коди, які діють з командою, все одно є потоково безпечними.

- __Можливість налаштування__ Оскільки у веб-додатку потрібен лише один Front Controller, конфігурація реалізації веб-додатків значно спрощується. Обробник виконує решту диспетчеризації, тому не потрібно нічого змінювати перед додаванням нових команд із динамічними.

3. Поясніть особливості використання шаблону проектування Front Controller при реалізації веб-застосунків та RESTful веб-сервісів.

Front Controller перехоплює всі запити та виконує загальні функції, такі як реєстрація або дешифрування. Front Controller вибирає та пересилає запит до контролера сторінки. Контролер сторінки аналізує введені користувачем дані та перетворює їх у відповідні оновлення моделі. Модель застосовує бізнес-правила та постійно зберігає дані локально, на бізнес-рівні або за допомогою іншого віддаленого механізму збереження. На основі змін моделі та введення користувача контролер сторінки вибирає перегляд. Подання перетворює оновлені дані моделі у форму, зручну для користувача.

4. В чому полягають відмінності методів GET та POST протоколу HTTP?

||GET|POST|
|-|-|-|
|Обмеження на обсяг|4 Кб|Обмеження задаються сервером|
|Дані, що передаються|Видно відразу всім|Видно лише при перегляді через розширення браузера або іншими методами|
|Кешування|Сторінки з різними запитами вважаються різними, їх можна кешувати окремими документами|Сторінка завжди одна|
|Закладки|Сторінку із запитом можна додати до закладок браузера та звернутися до неї пізніше|Сторінки з різними запитами мають одну адресу, запит повторити не можна|
|Передача данних|GET передає данні в URL у виді query параметрів "ключ значення"|POST запит передає дані в тілі запиту|

5. Що таке сервлет?

Сервлет — це клас мови програмування Java, який використовується для розширення можливостей серверів, на яких розміщено програми, доступ до яких здійснюється за допомогою моделі програмування запит-відповідь. Хоча сервлети можуть відповідати на будь-який тип запиту, вони зазвичай використовуються для розширення додатків, розміщених на веб-серверах. Для таких програм технологія Java Servlet визначає специфічні для HTTP класи сервлетів.

6. Якими способами передаються данні HTML-форм з клієнта на сервер? В чому полягають їх переваги і недоліки?

Передача на сервер відбувається двома різними методами: GET і POST, для задання методу в тезі form використовується атрибут method, значеннями виступають ключові слова get і post. Якщо атрибут метод не заданий, то за умовчанням дані відправляються на сервер методом GET.
Головна відмінність методів у тому, що, передані методом get, передаються в url. Передавати особисті дані типу пароля небезпечно. Тому форми авторизації чи реєстрації необхідно передавати шляхом post.

7. Чи впливає регістр символів при передачі імен параметрів у HTTP-запитах до сервлетів?

Так

8. Чи впливає регістр символів при передачі значень параметрів у HTTP-запитах до сервлетів?

Ні

9. В чому полягає різниця між статичними HTML-сторінками та шаблонами сторінок Thymeleaf та JSP?

Різниця між статичними html сторінками та шаблонами сторінок Thymeleaf і JSP полягає у тому що в шаблонах ми можемо використовувати деякі особливості мови програмування java, та моделі передані з java класів, в той час як статичні html сторінки обмежуються лише мовою JavaScript

10. В чому полягає різниця між сервлетами та JSP-сторінками?

Java Server Pages (JSP) — це програми Java, які виконуються на сервері прикладних програм Java і розширюють можливості веб-сервера. Сервлети Java — це класи Java, призначені для відповіді на HTTP-запити в контексті веб-програми. Їхня відмінність заключається в тому що сервлет базується на програмі написаній на мові програмування Java в той час як JSP базується на HTML.

11. Як виглядає життєвий цикл JSP-сторінки? Що таке трансляція та компіляція JSP-сторінок?  


Життєвий цикл JSP визначається як процес від його створення до знищення. Це схоже на життєвий цикл сервлету з додатковим кроком, необхідним для компіляції JSP у сервлет.

12. Що таке скриптлети та директивні елементи?

JSP скриптлети використовується, щоб містити будь-який фрагмент коду, дійсний для тої мови скриптів, що використовується на сторінці. 
Синтаксис скриптлета такий: <% скрипт %>

Директиви — це елементи, які передають повідомлення в контейнер JSP і впливають на те, як він компілює сторінку JSP. Самі директиви не відображаються у вихідних даних XML. Існує три директиви: include, page і taglib.

13. В чому полягає різниця між директивою <%@ include%> та елементом <jsp:include>?

 <%@ include%> - цей механізм для статичного вмісту, наприклад HTML або JSP, вміст якого не змінюється під час виконання.
 
 <jsp:include> - цей механізм для динамічного вмісту, наприклад JSP або Servlet, вміст якого може змінюватися під час виконання.

14. Що таке JavaBean? Як їх використовувати у JSP-сторінках?

JavaBean це по суті звичайний Java об'єкт. Його використання в JSP відбувається за допомогою його ж моделі, відправленої контроллером в шаблонізатор, де його парсять за допомогою EL елементів та гетерів чи сетерів.

15. В чому полягають переваги/недоліки використання EL та JSTL у порівнянні з такими JSP-елементами як вирази (<%=…  %>) та скриптлети (<% … %>)?

Перевагою використання такого підходу є те що код стає більш зрозумілим не тільки для java розробника але й для веб дизайнерів. Недоліком є менша гнучкість, оскільки за допомогою скриптлетів та виразів можна було вставити java код та вирішити більш нестандартну задачу.

16. В чому полягають переваги/недоліки використання JSTL-елемента <c:out> у порівнянні зі звичайними EL-виразом ${…} або JSP-елементом <%=… %>?

Значною перевагою JSTL елемента <c:out> над іншим є захист від XSS атак шляхом екранування. Мінусом же такої ідеї є звісно нагромадження синтаксису а також те що його варто використовувати лише для статичного тексту.

17. Який час життя атрибутів на рівнях  requestScope, sessionScope, applicationScope? Чи можуть одночасно існувати атрибути з однаковими іменами на різних рівнях?

Application scope: Об'єкт доступний на час дії застосунку.

Request scope:  Об’єкт доступний з моменту надсилання запиту HTTP до надсилання клієнту відповіді.

Session scope: Об'єкт доступний на час сесії. Так можуть існувати пару атрибутів з однаковими іменами на різних рівнях.

18. Що таке XSS-атака? Як зробити сайт стійким до таких атак?

XSS атака - це атака при якій зі сторони користувачів на сервер замість звичайного тексту попадають ворожі скрипти. Наприклад при залишенні коментаря чи авторизації користувач замість даних про себе вводить скрипт, який буде рендеритися застосунком, і може наробити біди. Захиститися від цього можна екрануваннням. У шаблонізаторі thymeleaf екранування стоїть за замовчуванням.

19. Поясніть різницю між термінами forward та redirect.

redirect - встановлює статус відповіді на нову URL-адресу в Location заголовку та надсилає відповідь у браузер. Потім браузер, відповідно до специфікації http, робить ще один запит до нової URL-адреси

forward - відбувається повністю на сервері. Контейнер сервлетів просто пересилає той самий запит на цільову URL-адресу. Таким чином, ви можете використовувати однакові атрибути запиту та ті самі параметри запиту під час обробки нової URL-адреси. І браузер не дізнається, що URL-адреса змінилася (оскільки це сталося повністю на сервері).

# Лаб 4

## Контрольні питання 

1. Поясніть різницю між вебзастосунками та RESTful вебсервісами.

Оскільки веб-інтерфейси API є легкою архітектурою, вони розроблені для гаджетів, обмежених такими пристроями, як смартфони. Навпаки, API REST надсилають і отримують дані через системи, що робить їх складною архітектурою. 

Вебзастосунок означає: базові компоненти, такі як браузер, веб-сервер або сервер додатків, технологію на стороні сервера для серверної частини та базу даних для збереження даних. 

Сервіс RESTfull: це вебсервіс із синтаксичним аналізатором xml і API RESTFull, який надає спеціальні методи, щоб розробнику було комфортно. 

2. Які технології реалізації концепції сервісно-орієнтованої архітектури ви знаєте? Чим RESTful вебсервіси відрізняються від інших підходів?

Як правило, сервіс-орієнтована архітектура реалізується за допомогою веб-служб, що робить «функціональні будівельні блоки доступними через стандартні Інтернет-протоколи». Прикладом стандарту веб-сервісу є SOAP чи REST.

Веб-служби RESTful — це в основному веб-служби на основі архітектури REST. В архітектурі REST все є ресурсом. Веб-сервіси RESTful невеликі, добре масштабовані та зручні в обслуговуванні та дуже часто використовуються для створення API для веб-додатків. 
Хоча більшість API дотримуються формату «програма-програма», REST API суворо працює на веб-концепції клієнта та сервера. Клієнт і сервер відокремлені один від одного, що забезпечує більшу гнучкість.

3. Поясніть особливості використання шаблону проектування Front Controller при реалізації вебзастосунків та RESTful вебсервісів.

Front Controller визначається як «контролер, який обробляє всі запити для веб-сайту». Він стоїть перед веб-додатком і делегує запити наступним ресурсам. Він також надає інтерфейс для звичайної поведінки, як-от безпеки, інтернаціоналізації та представлення певних виглядів певним користувачам

Шаблон Front Controller-а в основному розділений на дві частини. Єдиний диспетчерський контролер та ієрархія команд.

Цей єдиний контролер надсилає запити до команд, щоб ініціювати поведінку, пов’язану із запитом.

4. Для реалізації якої чи яких операцій CRUD (create, read, update, delete) можуть використовуватися такі методи протоколу HTTP як GET, POST, PUT, PATCH, DELETE? 
<div align="center">

HTTP Verb| CRUD
--- | ---
POST | Create
GET | Read
PUT | Update/Replace
PATCH | Update/Modify
DELETE | Delete
</div>
5. Що означають поняття «безпечний» та «ідемпотентний» метод HTTP? Чи будь який безпечний метод є ідемпотентним? Чи будь який ідемпотентний метод є безпечним?

- Безпечний метод нічого не змінює внутрішньо (ресурси)

- Безпечні методи – це методи, які можна кешувати, попередньо вибирати без будь-яких наслідків для ресурсу.

- Ідемпотентний метод нічого не змінює зовні (відповідь)

- Ідемпотентний метод HTTP — це метод HTTP, який можна викликати багато разів без різних результатів.
<div align="center">

HTTP Method | Idempotent | Safe
--- | --- | ---
OPTIONS | yes  | yes 
GET | yes  | yes 
HEAD | yes  | yes 
PUT  | yes  | no
POST | no | no
DELETE | yes  | no
PATCH | no | no
</div>

6. В чому полягає різниця між анотаціями @Controller та @RestController?

@Controller — це звичайна анотація, яка використовується для позначення класу як Spring MVC Controller, тоді як @RestController — це спеціальний контролер, який використовується у веб-сервісах RESTFul і еквівалент @Controller + @ResponseBody.

Анотація @Controller вказує, що клас є «Контролером», наприклад. веб-контролер, тоді як анотація @RestController вказує, що клас є контролером, де методи @RequestMapping за замовчуванням передбачають семантику @ResponseBody, тобто обслуговують REST API.

7. В чому полягає різниця між анотаціями @GetMapping та @RequestMapping?

@RequestMapping використовується на рівні класу, тоді як @GetMapping використовується для підключення методів.

@RequestMapping підтримує споживання навіть із method=GET, тоді як @GetMapping не підтримує споживання.

8. В яких випадках можуть знадобитися анотації @RequestParam, @PathVariable, @RequestBody?

@RequestParam використовується для отримання параметрів запиту, параметрів форми та навіть файлів із запиту.
@RequestParam буде використовуватися в основному для операції GET.

@PathVariable може бути використана для обробки змінних шаблону у відображенні URI запиту та встановлення їх як параметрів методу. 
@PathVariable буде використовуватися в основному для операції DELETE/GET.

HTTP-запит крім заголовків та параметрів має також основну частину – тіло запиту. Її вміст також можна розпізнати як параметр у методі контролера. Для того, щоб це сталося, необхідно вказати @RequestBody в оголошенні цього параметра:
@RequestBody буде використовуватися в основному для операції PUT/POST.

9. Для чого потрібен клас ResponseEntity?

ResponseEntity представляє всю відповідь HTTP: код статусу, заголовки та тіло. У результаті ми можемо використовувати його для повного налаштування відповіді HTTP.
Якщо ми хочемо його використовувати, ми повинні повернути його з кінцевої точки.
ResponseEntity є загальним типом. Отже, ми можемо використовувати будь-який тип як тіло відповіді.

10. Як за допомогою анотації @Valid здійснювати валідацію даних, які надходять від клієнта?

Можна перевіряти дані на будь-яких компонентах Spring. Для цього використовується комбінація анотацій @Validated та @Valid.

Приклад валідації за допомогою @Valid:
```@Service
@Validated
public class PersonService {

    public void save(@Valid PersonDto personDto) {
        // do something
    }

}

```

## Контрольні питання 

1. Поясніть різницю між JDBC та JdbcTemplate.

Java DataBase Connectivity, скорочено JDBC — прикладний програмний інтерфейс Java, який визначає методи, з допомогою яких програмне забезпечення на Java здійснює доступ до бази даних в той час як JdbcTemplate являється центральним класом який виконує робочий процес JDBC.

2. Одним з найбільших плюсів prepared statement є екранування. Щось схоже ми мали з шаблонізаторами у ЛР3. Prepared statement цим шляхом надає захист від SQL injection - атаками зумовленими ін'єкціями мови SQL у базу даних.

3. Поясніть різницю між методами execute(), executeQuery() та executeUpdate() класу PreparedStatement.

__execute()__ - виконує оператор SQL у цьому об’єкті Prepared Statement, який може бути будь-яким видом оператора SQL.

__executeQuery()__ - виконує SQL-запит у цьому об’єкті Prepared Statement і повертає об’єкт ResultSet, згенерований запитом.

__executeUpdate()__ - 



