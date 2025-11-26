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
