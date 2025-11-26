# WeatherApp 🌤️  
یک اپلیکیشن اندروید نوشته‌شده با **Kotlin** که اطلاعات آب‌وهوا را از API دریافت کرده و با یک UI ساده و تمیز نمایش می‌دهد.

---

## 📌 درباره پروژه  
WeatherApp یک پروژه آموزشی–کاربردی است که با هدف یادگیری:

- کار با **API و Networking**  
- **JSON Parsing**  
- **Retrofit / OkHttp**  
- مدیریت Thread با **Coroutines**  
- طراحی UI ساده با **ViewBinding**  
- و ساخت اپ واقعی Android

طراحی و پیاده‌سازی شده است.  
این پروژه توسط **یک نفر** توسعه داده شده است.

---

## ✨ ویژگی‌ها (Features)
- دریافت آب‌وهوا بر اساس نام شهر  
- نمایش:
  - دما (Temperature)
  - وضعیت هوا (Weather Condition)
  - رطوبت (Humidity)
  - سرعت باد (Wind Speed)
- رابط کاربری ساده، مینیمال و کاربردی  
- هندل خطا در صورت:
  - وارد کردن نام شهر اشتباه  
  - قطع اینترنت  
  - مشکل سمت API  
- استفاده از Coroutine برای تماس شبکه  
- ساختار کد تمیز و خوانا  

---

## 🧩 ساختار پروژه (Project Structure)

WeatherApp/
├── app/src/main/java/.../MainActivity.kt
├── app/src/main/java/.../WeatherService.kt
├── app/src/main/java/.../model/WeatherResponse.kt
├── app/src/main/res/layout/activity_main.xml
├── app/src/main/res/drawable/...
├── app/src/main/AndroidManifest.xml
└── build.gradle.kts


---

## 🛠️ تکنولوژی‌ها (Tech Stack)
- **Kotlin**
- **Android SDK**
- **Retrofit**  
- **OkHttp**  
- **Gson / Moshi**  
- **Coroutines**  
- **ViewBinding**  
- **Material Components**

---

## ⚙️ نحوه اجرا (How to Run)

### 1. Clone پروژه  
```bash
git clone https://github.com/erfanhspr-04/WeatherApp
cd WeatherApp

apiKey = "89b58d0145a98ba71b882bf706fb3df5"

2. API Key اضافه کنید
پروژه از OpenWeatherMap API استفاده می‌کند.
در فایل MainActivity.kt این مقدار را val apiKey = your api key بگذارد(به جای your api Key، کلیدی را که از سایت openweathermap دریافت کرده اید بگذارید.)

3. Build & Run

پروژه را در Android Studio باز کرده و اجرا کنید.
<img width="385" height="812" alt="image-1" src="https://github.com/user-attachments/assets/263c0d5d-dfc2-4727-b9d3-046a256c0fc1" />

<img width="367" height="780" alt="image-2" src="https://github.com/user-attachments/assets/bd98e4a3-973c-4fc5-b66c-cd89f3b388a6" />

<img width="363" height="781" alt="image-3" src="https://github.com/user-attachments/assets/2ea6066b-d153-49fb-88cd-43f28dbbfb14" />

<img width="351" height="773" alt="image-4" src="https://github.com/user-attachments/assets/98d9f1c0-17b1-40d5-8030-cb9dbd5b356a" />

ساختار API

درخواست نمونه:
https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}&units=metric
پاسخ JSON شامل:

main.temp

main.humidity

weather[0].main

wind.speed

مدل‌های داده بر اساس این ساختار نوشته شده‌اند.

آینده پروژه (Future Improvements)

نمایش Forecast چندروزه

اضافه‌کردن آیکون‌های Weather

ذخیره شهرهای محبوب

طراحی UI مدرن‌تر

Dark Mode

نمایش جزئیات کامل‌تر آب‌وهوا

🤝 مشارکت (Contributing)

پروژه شخصی است اما Pull Request بررسی می‌شود.

👨‍💻 توسعه‌دهنده

Erfan Hosseinpoor
طراحی، کدنویسی، UI و تست توسط شخص توسعه‌دهنده انجام شده است.

