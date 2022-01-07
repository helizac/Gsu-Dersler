**1) Tarihte Genetik Algoritma**

Genetik algoritmaların temel ilkeleri ilk kez 1975 yılında Michigan Üniversitesi'ndeJohn Holland
tarafından ortaya atılmıştır ve John Holland bu çalışmalarını“Adaptation in Natural and Artificial
Systems”kitabında bir araya getirmiştir.

Genetik algoritmalar, çok boyutlu uzayda,en iyileştirmeamacıylaiterasyonlaryapan ve her
iterasyondaen iyinin hayatta kalması prensibinedayanaraken iyi çözümü arayan algoritmalardır.

Problemlere tek bir çözüm üretmek yerine her biri birbirinden tamamen bağımsız olan farklı
çözümlerden oluşan bir küme üretir.

Böylelikle, arama uzayında aynı anda birçok nokta değerlendirilmekte ve sonuçta global çözüme
ulaşma olasılığı yükselmektedir.

**2) Genetik Algoritmayla En Kısa Yolu Bulma**

En kısa yolu bulma genetik algoritmasını oluşturmak için, ilk önce bir nevi kromozom olan
bireyleri ve daha sonrasında ise bu bireylerden bir popülasyon oluşturmamız gerekmektedir.

```
Optimize bireyi yaratmak için bize başlangıçta gereken şeyler
bireyin başlangıç konumu, hedefin konumu ve hedefe kaç
adımda gidilebileceğidir. Mümkün olasılıklardan ( bu durum
için mümkün yönlerden ) rastgele genler seçerek bireye hareket
sağlayacak, yönlerden oluşan bir vektör oluştururuz. Bu vektör
bireyin genotipidir.
```
Bireyimizi oluşturduktan sonra sıra, popülasyon oluşturmaya gelir. Popülasyon oluşturulurken en
iyinin hayatta kalma prensibiyle genetik operatörler kullanılır. Bu operatörler seçim, çaprazlama
ve mutasyondan oluşmaktadır.

En iyinin hayatta kalma prensibini uygulamak için, bireylerin hedefe yaklaşıp yaklaşmadığına
bakılır ve bir uygunluk oranı döndürülür. Bu uygunluk oranı, gelecek nesilleri oluşturacak olan
ataları seçmekte kullanılır.

```
Daha sonra, hedefe en çok yaklaşan atalar kendi aralarında çaprazlanarak
daha gelişmiş nesiller elde edilir. Yeni oluşan bireylere, popülasyon içindeki
çeşitliliği korumak ve erken yakınsamayı önlemek için mutasyon işlemi
uygulanır. Bu işlemde bireyin bir ya da birkaç geninin yerimutasyon
olasılığına bağlı olarak değiştirilir.
```
Daha sonrasında bu işlem istenen nesil kadar veya uygunluk değeri sürekli olarak sabit kalana
kadar devam ettirilir. En sonda hayatta kalan birey, hedefe en kısa şekilde ulaşan bireydir.

Atalar arasında gen değişimi Yeni bireylerin oluşumu Mutasyon Gen Değişimi

```
Kaynakça
https://tr.wikipedia.org/wiki/Genetik_algoritma
https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf
```
