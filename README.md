# WeatherApp 🌤️  
یک اپلیکیشن اندروید نوشته‌شده با **Kotlin** که اطلاعات آب‌وهوا را از API دریافت کرده و با یک UI ساده و تمیز نمایش می‌دهد.

---

## 📌 درباره پروژه  
WeatherApp یک پروژه آموزشی–کاربردی است برای یادگیری:

- **API & Networking**
- **JSON Parsing**
- **Retrofit / OkHttp**
- **Coroutines**
- **ViewBinding**
- طراحی UI ساده و کاربردی  
- ساخت یک اپ واقعی اندروید

این پروژه توسط **Erfan Hosseinpoor** توسعه داده شده است.

---

## ✨ ویژگی‌ها (Features)
- دریافت آب‌وهوا با نام شهر  
- نمایش:
  - دما (Temperature)  
  - وضعیت هوا (Weather Condition)  
  - رطوبت (Humidity)  
  - سرعت باد (Wind Speed)
- طراحی ساده و کاربردی  
- مدیریت خطا در:
  - قطع اینترنت  
  - شهر نامعتبر  
  - خطای API  
- استفاده از Kotlin Coroutines  
- ساختار کد تمیز  

---

## 🧩 ساختار پروژه (Project Structure)

```txt
WeatherApp/
├── app/src/main/java/.../MainActivity.kt
├── app/src/main/java/.../WeatherService.kt
├── app/src/main/java/.../model/WeatherResponse.kt
├── app/src/main/res/layout/activity_main.xml
├── app/src/main/res/drawable/
├── app/src/main/AndroidManifest.xml
└── build.gradle.kts


# 🛠️ تکنولوژی‌ها (Tech Stack)

- Kotlin  
- Android SDK  
- Retrofit  
- OkHttp  
- Gson / Moshi  
- Coroutines  
- ViewBinding  
- Material Components  

---

# ⚙️ نحوه اجرا (How to Run)

## 1. کلون پروژه
```bash
git clone https://github.com/erfanhspr-04/WeatherApp
cd WeatherApp
```

## 2. افزودن API Key  
پروژه از OpenWeatherMap API استفاده می‌کند.  
به سایت مراجعه کرده و API Key بگیرید.

در فایل `MainActivity.kt` مقدار زیر را وارد کنید:

```kotlin
val apiKey = "YOUR_API_KEY"
```

به‌جای `"YOUR_API_KEY"` کلید واقعی خودتان را قرار دهید.

## 3. Build & Run
پروژه را در Android Studio اجرا کنید.

---

# 📸 اسکرین‌شات‌ها

<img width="385" height="812" src="https://github.com/user-attachments/assets/263c0d5d-dfc2-4727-b9d3-046a256c0fc1" />
<img width="367" height="780" src="https://github.com/user-attachments/assets/bd98e4a3-973c-4fc5-b66c-cd89f3b388a6" />
<img width="363" height="781" src="https://github.com/user-attachments/assets/2ea6066b-d153-49fb-88cd-43f28dbbfb14" />
<img width="351" height="773" src="https://github.com/user-attachments/assets/98d9f1c0-17b1-40d5-8030-cb9dbd5b356a" />

---

# 📡 ساختار API

نمونه درخواست:

```
https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}&units=metric
```

مقادیر مهم JSON:
- `main.temp`
- `main.humidity`
- `weather[0].main`
- `wind.speed`

---

# 🚀 قابلیت‌های آینده (Future Improvements)

- نمایش Forecast چندروزه  
- آیکون‌های اختصاصی وضعیت هوا  
- ذخیره شهرهای محبوب  
- طراحی UI مدرن‌تر  
- Dark Mode  
- نمایش جزئیات بیشتر آب‌وهوا  

---

# 🤝 مشارکت (Contributing)

پروژه شخصی است اما Pull Request بررسی می‌شود.

---

# 👨‍💻 توسعه‌دهنده  
**Erfan Hosseinpoor**  
طراحی، کدنویسی، UI و تست توسط توسعه‌دهنده انجام شده است.
